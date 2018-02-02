package com.tencent.mm.modelfriend;

import com.tencent.mm.by.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import java.util.HashMap;
import java.util.LinkedList;

public class af implements ap {
    private static HashMap<Integer, d> gwY;
    private c hxc;
    private i hxd;
    private l hxe;
    private ac hxf;
    private ae hxg;
    private r hxh;
    private p hxi;
    private e hxj = new e();
    private LinkedList<aou> hxk = null;
    private d hxl = new d();
    private f hxm = new f();
    private g hxn = new g();
    private c hxo = new 1(this);
    private c hxp = new 6(this);
    private c hxq = new 7(this);
    private c hxr = new 3(this);
    private c hxs = new 4(this);

    private static af OC() {
        ar.Ha();
        af afVar = (af) bp.hY(af.class.getName());
        if (afVar != null) {
            return afVar;
        }
        Object afVar2 = new af();
        ar.Ha().a(af.class.getName(), afVar2);
        return afVar2;
    }

    public static c OD() {
        g.Dh().Ct();
        if (OC().hxc == null) {
            af OC = OC();
            ar.Hg();
            OC.hxc = new c(com.tencent.mm.z.c.EV());
        }
        return OC().hxc;
    }

    public static i OE() {
        g.Dh().Ct();
        if (OC().hxd == null) {
            af OC = OC();
            ar.Hg();
            OC.hxd = new i(com.tencent.mm.z.c.EV());
        }
        return OC().hxd;
    }

    public static l OF() {
        g.Dh().Ct();
        if (OC().hxe == null) {
            af OC = OC();
            ar.Hg();
            OC.hxe = new l(com.tencent.mm.z.c.EV());
        }
        return OC().hxe;
    }

    public static ac OG() {
        g.Dh().Ct();
        if (OC().hxf == null) {
            af OC = OC();
            ar.Hg();
            OC.hxf = new ac(com.tencent.mm.z.c.EV());
        }
        return OC().hxf;
    }

    public static r OH() {
        g.Dh().Ct();
        if (OC().hxh == null) {
            af OC = OC();
            ar.Hg();
            OC.hxh = new r(com.tencent.mm.z.c.EV());
        }
        return OC().hxh;
    }

    public static ae OI() {
        g.Dh().Ct();
        if (OC().hxg == null) {
            af OC = OC();
            ar.Hg();
            OC.hxg = new ae(com.tencent.mm.z.c.EV());
        }
        return OC().hxg;
    }

    public static void f(LinkedList<aou> linkedList) {
        g.Dh().Ct();
        OC().hxk = linkedList;
    }

    public static LinkedList<aou> OJ() {
        g.Dh().Ct();
        return OC().hxk;
    }

    public static void OK() {
        g.Dh().Ct();
        OC().hxk = null;
    }

    public final void onAccountRelease() {
        a.xef.c(this.hxr);
        a.xef.c(this.hxs);
        a.xef.c(this.hxq);
        a.xef.c(this.hxl);
        a.xef.c(this.hxm);
        a.xef.c(this.hxn);
        a.xef.c(this.hxo);
        a.xef.c(this.hxp);
        com.tencent.mm.ae.d.c.b(Integer.valueOf(42), this.hxj);
        this.hxk = null;
        q.a.vcA = null;
    }

    public final void gd(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new 8());
        gwY.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new 9());
        gwY.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new 10());
        gwY.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return ac.gJN;
            }
        });
        gwY.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new 12());
        gwY.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new 13());
        gwY.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new 2());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(42), this.hxj);
        a.xef.b(this.hxr);
        a.xef.b(this.hxs);
        a.xef.b(this.hxq);
        a.xef.b(this.hxl);
        a.xef.b(this.hxm);
        a.xef.b(this.hxn);
        a.xef.b(this.hxo);
        a.xef.b(this.hxp);
        q.a.vcA = OD();
        ((m) g.k(m.class)).getFTSTaskDaemon().a(-86016, new 5(this));
    }

    public final void br(boolean z) {
    }

    public static p OL() {
        g.Dh().Ct();
        if (OC().hxi == null) {
            af OC = OC();
            ar.Hg();
            OC.hxi = new p(com.tencent.mm.z.c.EV());
        }
        return OC().hxi;
    }
}
