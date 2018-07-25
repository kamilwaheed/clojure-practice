(ns tic-tac-toe)

(defn transpose
  [l]
  (map #(map % l) (map #(fn [x] (nth x %)) (range 0 (count l)))))

(transpose [[1 2 3] [4 5 6] [7 8 9]])
(transpose '((1 2 3) (4 5 6) (7 8 9)))

(defn who-won
  [l]
  (cond
    (every? #(= % :x) l) :x
    (every? #(= % :o) l) :o
    :else nil))

(defn row-check
  [l]
  (some who-won l))

(defn diagonal-check
  [[[a1 _ c1] [_ b2 _] [a3 _ c3]]]
  (or (who-won [a1 b2 c3])
      (who-won [c1 b2 a3])))

(defn tic-tac-toe
  [l]
  (or (row-check l)
      (row-check (transpose l))
      (diagonal-check l)
      nil))

(defn mapr [f coll]
  (reduce (fn [r x] (conj r (f x)))
         [] coll))

(mapr inc [1 2 3])
