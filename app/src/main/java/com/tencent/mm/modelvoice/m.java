package com.tencent.mm.modelvoice;

import com.tencent.mm.by.h.d;
import com.tencent.mm.e.b.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.storage.bm;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.p;
import java.util.HashMap;
import junit.framework.Assert;

public class m implements ap {
    private static HashMap<Integer, d> gwY;
    private c hXA = new 1(this);
    private u hXw;
    private bm hXx;
    private i hXy;
    private r hXz = new r();

    private static m UC() {
        return (m) p.s(m.class);
    }

    public static u UD() {
        g.Dh().Ct();
        if (UC().hXw == null) {
            Assert.assertTrue("dataDB is null ", g.Dj().gQj != null);
            UC().hXw = new u(g.Dj().gQj);
        }
        return UC().hXw;
    }

    public static bm UE() {
        g.Dh().Ct();
        if (UC().hXx == null) {
            Assert.assertTrue("dataDB is null ", g.Dj().gQj != null);
            UC().hXx = new bm(g.Dj().gQj);
        }
        return UC().hXx;
    }

    public static i UF() {
        g.Dh().Ct();
        if (UC().hXy == null) {
            UC().hXy = new i();
        }
        return UC().hXy;
    }

    public final void onAccountRelease() {
        if (UC().hXy != null) {
            UC().hXy.flT = 0;
        }
        com.tencent.mm.ae.d.c.b(Integer.valueOf(34), this.hXz);
        a.xef.c(this.hXA);
        b.D(new String[]{"//voicetrymore"});
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("VOICE_TABLE".hashCode()), new 2());
        gwY.put(Integer.valueOf("VOICETRANSTEXT_TABLE".hashCode()), new 3());
    }

    public final HashMap<Integer, d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        com.tencent.mm.ae.d.c.a(Integer.valueOf(34), this.hXz);
        a.xef.b(this.hXA);
        b.a(new a(), new String[]{"//voicetrymore"});
    }

    public final void br(boolean z) {
    }
}
