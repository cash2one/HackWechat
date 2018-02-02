package com.tencent.mm.modelmulti;

import com.tencent.mm.network.q;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.w$a;
import com.tencent.mm.protocal.w.b;

public class d$a implements q {
    private final w$a hFf;
    private final b hFg;
    private final boolean hFh;
    int uin;

    public d$a() {
        this.hFf = new w$a();
        this.hFg = new b();
        this.hFh = false;
    }

    public d$a(b bVar) {
        this.hFf = new w$a();
        this.hFg = bVar;
        this.hFh = true;
    }

    public final e Hp() {
        return this.hFg;
    }

    public final int getType() {
        return 138;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newsync";
    }

    public final d Kb() {
        this.hFf.vBi = com.tencent.mm.compatible.d.q.yF();
        this.hFf.vBh = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.hFf.vBg = com.tencent.mm.protocal.d.vAz;
        this.hFf.eE(this.uin);
        return this.hFf;
    }

    public final boolean Kc() {
        return false;
    }

    public final int JY() {
        return 0;
    }
}
