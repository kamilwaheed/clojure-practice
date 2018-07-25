(ns min-path)

(defn min-path
  [v]
  (loop [row-i 1
         all (first v)]
    (if (>= row-i (count v))
      ((comp first sort) all)
      (let [row (nth v row-i)]
        (recur (inc row-i)
               (loop [i 0
                      new-all []]
                 (if (>= i (count row))
                   new-all
                   (let [col (nth row i)
                         i-1 (dec i)
                         cols-1 (dec (count row))
                         n (cond
                             (= i 0) (nth all i)
                             (= i cols-1) (nth all i-1)
                             :else (min (nth all i) (nth all i-1)))]
                     (recur (inc i)
                            (conj new-all (+ col n)))))))))))



(fn [v]
  (loop [row-i 1
         all (first v)]
    (if (>= row-i (count v))
      ((comp first sort) all)
      (let [row (nth v row-i)]
        (recur (inc row-i)
               (loop [i 0
                      new-all []]
                 (if (>= i (count row))
                   new-all
                   (let [col (nth row i)
                         i-1 (dec i)
                         cols-1 (dec (count row))
                         n (cond
                             (= i 0) (nth all i)
                             (= i cols-1) (nth all i-1)
                             :else (min (nth all i) (nth all i-1)))]
                     (recur (inc i)
                            (conj new-all (+ col n)))))))))))


(down '(1 2))

((fn [xxs]
   (letfn [(red [down up]
             (map + up (map min down (rest down))))]
     (->> xxs reverse (reduce red) first))) '([3] [2 4]))
