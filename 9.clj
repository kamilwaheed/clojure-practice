(ns exercises.grains)

(defn next-itr
  [a]
  (cond
    (zero? a) 1
    (= a 1) 2
    :else (*' 2 a)))

(defn square
  [n]
  (loop [n n a 0]
    (if (zero? n)
      a
      (recur (dec n) (next-itr a)))))

(defn total
  []
  (reduce #(+ %1 (square (inc %2))) 0 (range 64)))
