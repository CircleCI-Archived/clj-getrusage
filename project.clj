(defproject clj-getrusage "0.0.1"
  :description "call getrusage(2) from clojure"
  :url "http://github.com/circleci/clj-getrusage"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [net.java.dev.jna/jna "4.2.2"]]
  :java-source-paths ["src/java"])
