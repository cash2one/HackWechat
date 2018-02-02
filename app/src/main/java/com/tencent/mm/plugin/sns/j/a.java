package com.tencent.mm.plugin.sns.j;

import android.database.Cursor;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.c.bje;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends com.tencent.mm.vending.app.a implements e {
    String jKk;
    String rIa;
    boolean rIb;
    int rIc;
    public volatile aw rJv;
    protected volatile com.tencent.mm.plugin.sns.model.al.a rLY;
    private com.tencent.mm.plugin.sns.b.h.a rRR;
    boolean rtl;

    public final void a(com.tencent.mm.plugin.sns.b.h.a aVar) {
        this.rLY = ae.bvl();
        com.tencent.mm.plugin.sns.j.c.a aVar2 = (com.tencent.mm.plugin.sns.j.c.a) J(com.tencent.mm.plugin.sns.j.c.a.class);
        this.rRR = aVar;
        this.rLY.a(1, aVar2.jKk, this.rRR);
    }

    public final com.tencent.mm.plugin.sns.model.al.a bvl() {
        return this.rLY;
    }

    protected final void onCreate() {
        super.onCreate();
        a(b.class, new 1(this));
        a(com.tencent.mm.plugin.sns.j.c.a.class, new 2(this));
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[]{this});
        ae.bvq().qSA.clear();
        ae.bvq();
        com.tencent.mm.plugin.sns.model.b.buy();
    }

    protected final void onDestroy() {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[]{this});
        g.Dk();
        if (!(!g.Dh().Cy() || this.rLY == null || this.rRR == null)) {
            this.rLY.a(this.rRR, 1);
        }
        super.onDestroy();
    }

    static b bCI() {
        String str;
        b bVar = new b();
        Cursor byb = ae.bvA().byb();
        int count = byb.getCount();
        String str2 = "";
        if (count > 0) {
            byb.moveToFirst();
            i iVar = new i();
            iVar.b(byb);
            try {
                str = ((bje) new bje().aF(iVar.field_curActionBuf)).wFM;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
            byb.close();
            bVar.rRY = count;
            bVar.rRX = str;
            return bVar;
        }
        str = str2;
        byb.close();
        bVar.rRY = count;
        bVar.rRX = str;
        return bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar.toString()});
    }

    public final void g(String str, boolean z, int i) {
        this.rLY.a(1, str, z, i);
    }

    public final void h(String str, boolean z, int i) {
        this.rLY.b(1, str, z, i);
    }
}
