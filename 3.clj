;; (ns exercises.rna)

;; (defn collatz
;;   [x]
;;   (if (not (> x 0))
;;     (throw (IllegalArgumentException. "woot"))
;;     (loop [steps 0
;;            number x]
;;       (cond
;;         (= number 1) steps
;;         (even? number) (recur (inc steps) (/ number 2))
;;         :else (recur (inc steps) (+ (* number 3) 1))))))

;; (collatz 23)
