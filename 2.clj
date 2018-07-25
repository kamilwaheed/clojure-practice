(ns exercises.rna)

(def mapping {"G" "C"
              "C" "G"
              "T" "A"
              "A" "U"})

(defn valid?
  [x]
  (every? #(contains? mapping %) (clojure.string/split x #"")))

(defn mapeach
  [x]
  (clojure.string/join "" (map #(get mapping %) (clojure.string/split x #""))))

(defn to-rna
  [x]
  (assert (valid? x))
  (mapeach x))

(to-rna "GGCCTTAA")
