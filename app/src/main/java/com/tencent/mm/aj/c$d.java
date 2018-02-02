package com.tencent.mm.aj;

import com.tencent.mm.z.bu;
import java.io.Serializable;

public class c$d implements Serializable {
    long endTime = 0;
    long huQ = 0;
    int huv = 0;
    boolean huw = true;
    boolean hux = false;
    int pid = 0;
    long startTime = 0;

    final void a(int i, long j, long j2, int i2) {
        this.pid = i;
        if (this.startTime <= 0) {
            this.startTime = j;
            this.huQ = bu.Ie();
        }
        this.endTime = j2;
        this.huv = i2;
    }

    static c$d b(int i, long j, long j2, int i2) {
        c$d com_tencent_mm_aj_c_d = new c$d();
        com_tencent_mm_aj_c_d.pid = i;
        com_tencent_mm_aj_c_d.startTime = j;
        com_tencent_mm_aj_c_d.endTime = j2;
        com_tencent_mm_aj_c_d.huv = i2;
        return com_tencent_mm_aj_c_d;
    }

    public final String toString() {
        return String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[]{Integer.valueOf(this.pid), a.bc(this.huQ), a.bc(this.startTime), a.bc(this.endTime), Boolean.valueOf(this.huw), Boolean.valueOf(this.hux), Integer.valueOf(this.huv)});
    }
}
