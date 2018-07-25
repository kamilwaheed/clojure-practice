(ns exercises.series)

(defn slices
  [x n]
  (loop [i 0
         a []]
    (if (= n 0)
      [""]
      (if (<= (+ i n) (count x))
        (recur (inc i) (cons (subs x i (+ i n)) a))
        a))))
