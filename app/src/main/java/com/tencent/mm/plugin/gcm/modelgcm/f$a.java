package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.d.a;
import com.tencent.mm.plugin.gcm.modelgcm.d.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public class f$a implements q {
    private final a nyw = new a();
    private final b nyx = new b();
    int uin;

    public final /* bridge */ /* synthetic */ e Hp() {
        return this.nyx;
    }

    public final int getType() {
        return 624;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/androidgcmunreg";
    }

    public final d Kb() {
        this.nyw.vBi = com.tencent.mm.compatible.d.q.yF();
        this.nyw.vBh = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.nyw.vBg = com.tencent.mm.protocal.d.vAz;
        this.nyw.eE(this.uin);
        return this.nyw;
    }

    public final boolean Kc() {
        return false;
    }

    public final int JY() {
        return 0;
    }
}
