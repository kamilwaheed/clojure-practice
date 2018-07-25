(ns exercises.roman-numerals)

(def mapping [[:I 1]
              [:IV 4]
              [:V 5]
              [:IX 9]
              [:X 10]
              [:XL 40]
              [:L 50]
              [:XC 90]
              [:C 100]
              [:CD 400]
              [:D 500]
              [:CM 900]
              [:M 1000]])

(defn next-itr
  [r a]
  (->> (reverse mapping)
       (some #(if (>= r (second %))
                [(- r (second %)) (str a (name (first %)))]
                false))))

(defn numerals
  [n]
  (loop [r n
         a ""]
    (let [[r' a'] (next-itr r a)]
      (if (> r' 0)
        (recur r' a')
        a'))))
