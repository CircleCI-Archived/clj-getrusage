(ns clj-getrusage.core
  (:import (com.sun.jna Native)
           (rusage)))

(defn getrusage
  ([]
   (getrusage :RUSAGE_SELF))
  ([who?]
   (let [who? (if (keyword? who?)
                ;; Hack: on platforms where RUSAGE_* are #defined, we can't discover their
                ;; values via JNA. Hard-coded here, but you can pass a numeric value to work
                ;; around if you need to.
                (who? {:RUSAGE_SELF 0
                       :RUSAGE_CHILDREN -1})
                who?)
         rusage (rusage.)
         f (com.sun.jna.Function/getFunction "c" "getrusage"
                                             com.sun.jna.Function/THROW_LAST_ERROR)]
     (.invokeInt f (to-array [who? rusage]))
     {
      :utime (+ (-> rusage .ru_utime .tv_sec (* 1000000))
                (-> rusage .ru_utime .tv_usec))
      :stime (+ (-> rusage .ru_stime .tv_sec (* 1000000))
                (-> rusage .ru_stime .tv_usec))
      :maxrss (.ru_maxrss rusage)
      :ixrss (.ru_ixrss rusage)
      :idrss (.ru_idrss rusage)
      :isrss (.ru_isrss rusage)
      :minflt (.ru_minflt rusage)
      :majflt (.ru_majflt rusage)
      :nswap (.ru_nswap rusage)
      :inblock (.ru_inblock rusage)
      :oublock (.ru_oublock rusage)
      :msgsnd (.ru_msgsnd rusage)
      :msgrcv (.ru_msgrcv rusage)
      :nsignals (.ru_nsignals rusage)
      :nvcsw (.ru_nvcsw rusage)
      :nivcsw (.ru_nivcsw rusage)})))
