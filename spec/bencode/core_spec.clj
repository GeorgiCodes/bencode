(ns bencode.core-spec
  (:require [speclj.core :refer :all]
            [bencode.core :refer :all]))


(describe "decode-string"
  (it "should decode bencoded positive integer"
      (should= [1337 nil] (decode-string "i1337e"))))


(read-string "12345")

