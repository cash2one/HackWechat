package com.tencent.mm.aj;

import java.io.Serializable;

class c$a implements Serializable {
    long huu = 0;
    long time = 0;
    int type = 0;

    c$a(long j, long j2, int i) {
        this.huu = j;
        this.time = j2;
        this.type = i;
    }

    public final String toString() {
        return String.format("serverTime:%s,time:%s,type:%s", new Object[]{a.bc(this.huu), a.bc(this.time), Integer.valueOf(this.type)});
    }
}
