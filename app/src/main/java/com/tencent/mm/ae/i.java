package com.tencent.mm.ae;

import com.tencent.mm.network.q;
import com.tencent.mm.protocal.i.c.a;
import com.tencent.mm.protocal.k.d;

public abstract class i implements q {
    private d hmw;
    public boolean hmx = false;

    public abstract d Ho();

    public final d Kb() {
        if (this.hmw == null) {
            this.hmw = Ho();
            d dVar = this.hmw;
            dVar.vBi = com.tencent.mm.compatible.d.q.yF();
            dVar.vBh = com.tencent.mm.protocal.d.DEVICE_TYPE;
            dVar.vBg = com.tencent.mm.protocal.d.vAz;
            dVar.eE(a.vAV.Hm());
        }
        return this.hmw;
    }

    public int JY() {
        return 0;
    }

    public final boolean Kc() {
        return this.hmx;
    }
}
