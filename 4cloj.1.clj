(ns flipping-out)

(defn reducer
  [[acc longest] current]
  (if (or (empty? acc)
          (= (inc (last acc)) current))
    (let [new (conj acc current)
          new-count (count new)
          l-count (count longest)
          newl (if (and (> new-count 1)
                        (> new-count l-count))
                 new
                 longest)]
      [new newl])
    [[current] longest]))

(defn lis
  [xs]
  (->> xs
       (reduce reducer [[] []])
       (second)))
