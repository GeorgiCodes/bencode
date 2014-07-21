(ns bencode.core)

(defn- decode-number [stream delimeter & ch]
  (loop [i (if (nil? ch) (.read stream) (first ch)), result ""]
    (let [c (char i)]
      (if (= c delimeter)
        (BigInteger. result)
        (recur (.read stream) (str result c))))))

(defn- decode-string [stream ch]
  (let [length (decode-number stream \: ch)
        buffer (make-array Byte/TYPE length)]
    (.read stream buffer)
    (String. buffer "ISO-8859-1")))

(defn- decode-list [stream]
  (loop [result []]
    (let [c (char (.read stream))]
      (if (= c \e)
        result
        (recur (conj result (decode stream (int c))))))))

(defn- decode-map [stream]
  (apply hash-map (decode-list stream)))

(defn decode [stream & i]
  (let [indicator (if (nil? i) (.read stream) (first i))]
    (cond
     (and (>= indicator 48)
          (<= indicator 57)) (decode-string stream indicator)
          (= (char indicator) \i) (decode-number stream \e)
          (= (char indicator) \l) (decode-list stream)
          (= (char indicator) \d) (decode-map stream))))


