package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    private long hnk = 10;
    final /* synthetic */ c lKz;

    c$1(c cVar) {
        this.lKz = cVar;
    }

    public final boolean uF() {
        if (this.lKz.lKw == null) {
            long j = this.hnk;
            this.hnk = j - 1;
            if (j > 0) {
                return true;
            }
        }
        x.i("MicroMsg.exdevice.ExDeviceTaskService", "now retry count = %d", new Object[]{Long.valueOf(this.hnk)});
        if (this.hnk > 0) {
            this.lKz.aDQ();
        }
        return false;
    }
}
