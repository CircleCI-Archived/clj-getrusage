/* This is almost certainly not portable to all operating systems! */
public class rusage extends com.sun.jna.Structure {
        public static class timeval extends com.sun.jna.Structure {
               public long tv_sec;
               public int tv_usec;
        }
        public timeval ru_utime;
        public timeval ru_stime;
        public long ru_maxrss;
        public long ru_ixrss;
        public long ru_idrss;
        public long ru_isrss;
        public long ru_minflt;
        public long ru_majflt;
        public long ru_nswap;
        public long ru_inblock;
        public long ru_oublock;
        public long ru_msgsnd;
        public long ru_msgrcv;
        public long ru_nsignals;
        public long ru_nvcsw;
        public long ru_nivcsw;
};
