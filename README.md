# clj-getrusage

Call getrusage(2) from clojure.

## Installation

Add clj-getrusage to your project.clj:

```clojure
:dependencies [[clj-getrusage "0.0.1"]]
```

## Usage

```clojure
(ns foo
  (:require [clj-getrusage.core :refer (getrusage)]))

;; returns a map:
;; {:stime 386895,
;;  :ixrss 0,
;;  :utime 10008755,
;;  :msgrcv 28,
;;  :nivcsw 8430,
;;  :inblock 0,
;;  :oublock 0,
;;  :nvcsw 18,
;;  :majflt 0,
;;  :nswap 0,
;;  :idrss 0,
;;  :maxrss 370970624,
;;  :isrss 0,
;;  :nsignals 17,
;;  :minftl 121686,
;;  :msgsnd 39}
;; ... see getrusage(2) for details :)
(getrusage)
```

## Note about portability

This library takes some shortcuts which are likely to cause portability problems (Best-case:
bad data. Worst-case: segmentation faults.) It is tested on OS X and Ubuntu 12.04. If you're
interested in using it elsewhere, let me know.
