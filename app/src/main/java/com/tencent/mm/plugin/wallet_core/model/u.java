package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.n;
import com.tencent.mm.g.a.st;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.util.Date;

public final class u extends c<st> implements e {
    private st sPt;
    private String sPu;

    public u() {
        this.sPu = null;
        this.xen = st.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long longValue;
        this.sPt = (st) bVar;
        this.sPu = this.sPt.fKA.fKC;
        g.Dk();
        Object obj = g.Dj().CU().get(a.xqB, Long.valueOf(0));
        long longValue2 = obj != null ? ((Long) obj).longValue() : 0;
        long time = new Date().getTime();
        g.Dk();
        obj = g.Dj().CU().get(a.xqC, Long.valueOf(600000));
        if (obj != null) {
            longValue = ((Long) obj).longValue();
            if (longValue <= 0) {
                longValue = 600000;
            }
        } else {
            longValue = 600000;
        }
        if (time - longValue2 > longValue || bh.ov(this.sPu)) {
            x.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            k dVar = new d();
            g.Dk();
            n nVar = g.Di().gPJ;
            nVar.a(385, this);
            nVar.a(dVar, 0);
        } else if (bh.ov(this.sPu)) {
            x.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.sPt.fqI.run();
            this.sPt = null;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            bLz();
        }
        return true;
    }

    private void bLz() {
        com.tencent.mm.plugin.wallet_core.d.d bLu = o.bLu();
        com.tencent.mm.sdk.e.c rVar = new r();
        rVar.field_bulletin_scene = this.sPu;
        if (bLu.b(rVar, new String[0])) {
            this.sPt.fKB.fKD = rVar.field_bulletin_scene;
            this.sPt.fKB.content = rVar.field_bulletin_content;
            this.sPt.fKB.url = rVar.field_bulletin_url;
        } else {
            x.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.sPt.fqI.run();
        this.sPt = null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        g.Dk();
        g.Di().gPJ.b(385, this);
        g.Dk();
        g.Dj().CU().a(a.xqB, Long.valueOf(new Date().getTime()));
        bLz();
    }
}
