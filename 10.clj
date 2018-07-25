(ns exercises.triangle)

(defn triangle?
  [a b c]
  (and (every? #(> % 0) [a b c])
       (every? #(> (+ (first %) (second %)) (nth % 2)) [[a b c] [b a c] [a c b]])))

(defn equilateral?
  [a b c]
  (= a b c))

(defn isosceles?
  [a b c]
  (> (reduce #(if (= (first %2) (second %2)) (inc %1) %1) 0 [[a b] [b c] [a c]]) 0))


(defn triangle-type
  [a b c]
  (cond
    (not (triangle? a b c)) :illogical
    (equilateral? a b c) :equilateral
    (isosceles? a b c) :isosceles
    :else :scalene))
