(ns exercises.gigasecond)

(defn exp [x n]
  (loop [acc 1 n n]
    (if (zero? n) acc
        (recur (* x acc) (dec n)))))

(defn gigasecond
  [year month day]
  (let [d (java.util.Calendar/getInstance)]
    (doto d
      (.set year (dec month) day 0 0 0)
      (.add java.util.Calendar/SECOND (exp 10 9)))
    [(.get d java.util.Calendar/YEAR)
     (inc (.get d java.util.Calendar/MONTH))
     (.get d java.util.Calendar/DATE)]))
