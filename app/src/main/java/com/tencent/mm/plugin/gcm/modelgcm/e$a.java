package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.c.a;
import com.tencent.mm.plugin.gcm.modelgcm.c.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public class e$a implements q {
    private final a nyu = new a();
    private final b nyv = new b();
    int uin;

    public final /* bridge */ /* synthetic */ e Hp() {
        return this.nyv;
    }

    public final int getType() {
        return 623;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/androidgcmreg";
    }

    public final d Kb() {
        this.nyu.vBi = com.tencent.mm.compatible.d.q.yF();
        this.nyu.vBh = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.nyu.vBg = com.tencent.mm.protocal.d.vAz;
        this.nyu.eE(this.uin);
        return this.nyu;
    }

    public final boolean Kc() {
        return false;
    }

    public final int JY() {
        return 0;
    }
}
