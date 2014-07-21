(defproject bencode "0.1.0"
  :description "A Clojure library to decode bencoded input"
  :url "https://github.com/GeorgiCodes/bencode"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies [[speclj "3.0.0"]]}}
  :plugins [[speclj "3.0.0"]]
  :test-paths ["spec"])
