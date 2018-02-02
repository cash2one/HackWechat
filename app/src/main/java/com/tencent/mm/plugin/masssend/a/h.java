package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.bs.a;
import com.tencent.mm.z.c;
import java.util.HashMap;

public final class h implements ap {
    private static HashMap<Integer, d> gwY;
    private a okV = new 2(this);
    private b omX;
    private c omY;
    private i omZ = new i();
    private g ona = new g();

    private static h aYC() {
        ar.Ha();
        h hVar = (h) bp.hY("plugin.masssend");
        if (hVar != null) {
            return hVar;
        }
        Object hVar2 = new h();
        ar.Ha().a("plugin.favorite", hVar2);
        return hVar2;
    }

    public static b aYD() {
        g.Dh().Ct();
        if (aYC().omX == null) {
            h aYC = aYC();
            ar.Hg();
            aYC.omX = new b(c.EV());
        }
        return aYC().omX;
    }

    public static c aYE() {
        if (aYC().omY == null) {
            aYC().omY = new c();
        }
        return aYC().omY;
    }

    public final void onAccountRelease() {
        ar.getSysCmdMsgExtension().b("masssendapp", this.okV, false);
        com.tencent.mm.sdk.b.a.xef.c(this.omZ);
        com.tencent.mm.sdk.b.a.xef.c(this.ona);
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("MASSENDINFO_TABLE".hashCode()), new 1());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ar.getSysCmdMsgExtension().a("masssendapp", this.okV, false);
        com.tencent.mm.sdk.b.a.xef.b(this.omZ);
        com.tencent.mm.sdk.b.a.xef.b(this.ona);
    }

    public final void br(boolean z) {
    }
}
