package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.by.h.d;
import com.tencent.mm.network.n;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class b implements ap {
    private n pUH = new 1(this);
    g saU;
    private d saV = new d();
    public c saW = new c();
    private e saX;
    f saY;

    public static b bEB() {
        ar.Ha();
        b bVar = (b) bp.hY("plugin.talkroom");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ar.Ha().a("plugin.talkroom", bVar2);
        return bVar2;
    }

    public static g bEC() {
        if (bEB().saU == null) {
            bEB().saU = new g();
        }
        return bEB().saU;
    }

    public static e bED() {
        if (bEB().saX == null) {
            bEB().saX = new e();
        }
        return bEB().saX;
    }

    public static String bEE() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FB()).append("talkroom/").toString();
    }

    public static f bEF() {
        if (bEB().saY == null) {
            bEB().saY = new f();
        }
        return bEB().saY;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(56), this.saV);
        ar.a(this.pUH);
        a.vcp = bED();
        a.vcq = bEC();
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        com.tencent.mm.ae.d.c.b(Integer.valueOf(56), this.saV);
        ar.b(this.pUH);
        a.vcp = null;
        a.vcq = null;
        if (this.saU != null) {
            this.saU.aWa();
            this.saU = null;
        }
    }
}
