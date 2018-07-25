(ns word-chains)

(defn min-str
  [s1 s2]
  (cond (<= (count s1) (count s2)) s1
        :else s2))

(defn max-str
  [s1 s2]
  (cond (<= (count s1) (count s2)) s2
        :else s1))

(defn added-or-deleted?
  [s1 s2]
  (and (not (= (count s1) (count s2)))
       (<= (Math/abs (- (count s1) (count s2))) 1)
       (let [smaller (min-str s1 s2)
             larger (max-str s2 s1)]
         (every? #(clojure.string/includes? larger (str %)) smaller))))

(defn flipped?
  [w1 w2]
  (let [s1 (to-array (char-array w1))
        s2 (to-array (char-array w2))]
    (and (= (count s1) (count s2))
         (loop [i 0
                mismatching 0]
           (cond
             (> mismatching 1) false
             (>= i (count s1)) true
             :else
             (recur (inc i)
                    (if (= (nth s1 i) (nth s2 i))
                      mismatching
                      (inc mismatching))))))))

(defn distance-one?
  [w1 w2]
  (cond
    (added-or-deleted? w1 w2) true
    (flipped? w1 w2) true
    :else false))

(defn find-word
  [current words checked]
  (some
   #(cond
      (= % current) false
      (contains? checked %) false
      (distance-one? current %) %
      :else nil)
   words))

;; (defn word-chains?
;;   [words]
;;   (loop [checked #{}
;;          current (first words)]
;;     (if (= (inc (count checked)) (count words))
;;       true
;;       (let [word-one-letter-away (find-word current words checked)]
;;         (if (nil? word-one-letter-away)
;;           false
;;           (recur (conj checked current)
;;                  word-one-letter-away))))))

(defn perm
  [xs i j]
  (-> xs
      (update i (constantly (nth xs j)))
      (update j (constantly (nth xs i)))))

(defn permutations
  [xs]
  (let [n (count xs)]
    (loop [perms [xs]
           c (into [] (take n (repeat 0)))
           i 0]
      (if (= i n)
        perms
        (if (< (nth c i) i)
          (if (even? i)
            (recur (conj perms (perm xs 0 i))
                   (update c i inc)
                   0)
            (recur (conj perms (perm xs (nth c i) i))
                   (update c i inc)
                   0))
          (recur perms
                 (update c i (constantly 0))
                 (inc i)))))))

(defn is-valid-chain?
  [xs]
  (loop [i 1
         n (count xs)
         valid? true]
    (if (or (>= i n) (not (= valid? true)))
      valid?
      (recur (inc i)
             n
             (distance-one? (nth xs i) (nth xs (dec i)))))))

(defn word-chains?
  [words]
  (let [xs (into [] words)
        perms (permutations xs)]
    (some is-valid-chain? perms)))

(word-chains? #{"abc" "abd" "ac"})
