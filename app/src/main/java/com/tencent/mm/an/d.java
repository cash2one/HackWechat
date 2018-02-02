package com.tencent.mm.an;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.subapp.a;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.c;
import java.util.HashMap;

public class d implements ap {
    private static HashMap<Integer, com.tencent.mm.by.h.d> gwY;
    private b hyN;
    private c hyO;

    private static d OX() {
        ar.Ha();
        a aVar = (a) bp.hY("plugin.subapp");
        d dVar = aVar == null ? null : (d) aVar.Mi(d.class.getName());
        if (dVar != null) {
            return dVar;
        }
        ap dVar2 = new d();
        aVar.b(d.class.getName(), dVar2);
        return dVar2;
    }

    public static b OY() {
        g.Dh().Ct();
        if (OX().hyN == null) {
            d OX = OX();
            ar.Hg();
            OX.hyN = new b(c.EV());
        }
        return OX().hyN;
    }

    public final void onAccountRelease() {
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new com.tencent.mm.by.h.d() {
            public final String[] wg() {
                return b.gJN;
            }
        });
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return gwY;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        if (this.hyO == null) {
            this.hyO = new c();
        }
        ak.a.hfL = this.hyO;
        x.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[]{this.hyO});
        g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.pluginsdk.ui.applet.c());
        g.a(i.class, new f());
    }

    public final void br(boolean z) {
    }
}
