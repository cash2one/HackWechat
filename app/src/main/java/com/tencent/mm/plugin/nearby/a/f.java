package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.by.h;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.jz;
import com.tencent.mm.pluginsdk.d.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import java.util.HashMap;

public final class f implements ap {
    private c kYX = new 5(this);
    private c oOa = new 1(this);
    private c oOb = new c<iu>(this) {
        final /* synthetic */ f oOg;

        {
            this.oOg = r2;
            this.xen = iu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            iu iuVar = (iu) bVar;
            switch (iuVar.fzl.fut) {
                case 1:
                    b.bN(iuVar.fzl.fzn, iuVar.fzl.fzo);
                    break;
                case 2:
                    b.tN(iuVar.fzl.fzo);
                    break;
                case 3:
                    iuVar.fzm.fpW = b.beQ();
                    break;
                case 4:
                    b.beR();
                    break;
                case 5:
                    b.beS();
                    break;
                case 6:
                    b.Gz(iuVar.fzl.fzn);
                    break;
                case 7:
                    iu.b bVar2 = iuVar.fzm;
                    ar.Hg();
                    Long l = (Long) com.tencent.mm.z.c.CU().get(8210, null);
                    boolean z = l == null ? true : System.currentTimeMillis() > l.longValue();
                    bVar2.fpW = z;
                    break;
                default:
                    x.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            return false;
        }
    };
    com.tencent.mm.pluginsdk.d.c<jy> oOc = new 3(this);
    com.tencent.mm.pluginsdk.d.c<jz> oOd = new 4(this);
    d oOe = new 6(this);
    private a oOf = new 7(this);

    public final void onAccountRelease() {
        ar.Hg();
        com.tencent.mm.z.c.EY().b(this.oOf);
        com.tencent.mm.sdk.b.a.xef.c(this.oOb);
        com.tencent.mm.sdk.b.a.xef.c(this.kYX);
        com.tencent.mm.sdk.b.a.xef.c(this.oOc);
        com.tencent.mm.sdk.b.a.xef.c(this.oOd);
        this.oOa.dead();
    }

    public final HashMap<Integer, h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        ar.Hg();
        com.tencent.mm.z.c.EY().a(this.oOf);
        com.tencent.mm.sdk.b.a.xef.b(this.kYX);
        com.tencent.mm.sdk.b.a.xef.b(this.oOb);
        com.tencent.mm.sdk.b.a.xef.b(this.oOc);
        com.tencent.mm.sdk.b.a.xef.b(this.oOd);
        this.oOa.ceO();
    }

    public final void br(boolean z) {
    }
}
