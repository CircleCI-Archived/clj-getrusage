(ns clj-getrusage.core-test
  (:require [clojure.test :refer :all]
            [clojure.pprint]
            [clj-getrusage.core :refer (getrusage)]))

(deftest getrusage-works
  (testing "throws on error"
    (is (thrown? Exception (getrusage -2))))
  (testing "basically behaves as expected"
    (let [rusage (getrusage)]
      (is (map? rusage))
      (is (contains? rusage :utime))))
  (testing "utime increases monotonically"
    (let [utimes (map :utime (repeatedly 100 getrusage))]
      (is (= (sort utimes) utimes))))
  (testing "stime increases monotonically"
    (let [stimes (map :stime (repeatedly 100 getrusage))]
      (is (= (sort stimes) stimes)))))
