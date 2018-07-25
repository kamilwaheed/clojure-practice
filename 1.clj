(ns exercises.bob)

(defn response-for
  [phrase]
  (cond
    (= (count (clojure.string/trim phrase)) 0) "Fine. Be that way!"
    (and (re-matches #".*[A-Za-z]+.*" phrase) (= (clojure.string/upper-case phrase) phrase)) "Woah, chill out!"
    (clojure.string/ends-with? phrase "?") "Sure."
    :else "Whatever."))
