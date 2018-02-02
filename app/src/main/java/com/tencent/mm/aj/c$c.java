package com.tencent.mm.aj;

import java.io.Serializable;

class c$c implements Serializable {
    long huA = 0;
    long huB = 0;
    long huP = 0;
    long huu = 0;
    long huz = 0;
    int pid = 0;

    c$c(int i, long j, long j2, long j3, long j4, long j5) {
        this.pid = i;
        this.huu = j;
        this.huP = j2;
        this.huz = j3;
        this.huA = j4;
        this.huB = j5;
    }

    public final String toString() {
        return String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s", new Object[]{Integer.valueOf(this.pid), a.bc(this.huu), a.bc(this.huP), a.bc(this.huz), Long.valueOf(this.huA), Long.valueOf(this.huB)});
    }
}
