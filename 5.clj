(ns exercises.phone-number)

(defn number
  [x]
  (let [cleaned (clojure.string/replace x #"[^0-9]" "")]
    (if (and (or (= 11 (count cleaned)) (= 10 (count cleaned))) (clojure.string/starts-with? cleaned "1"))
      (clojure.string/join "" (take-last 10 cleaned))
      (clojure.string/join "" (repeat 10 "0")))))


(defn area-code
  [x]
  (->> x
       number
       (take 3)
       (clojure.string/join "")))

(defn pretty-print
  [x]
  (-> x
      number
      (clojure.string/replace #"([0-9]{3})([0-9]{3})([0-9]{4})" "($1) $2-$3")))
