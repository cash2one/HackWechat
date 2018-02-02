package com.tencent.mm.plugin.radar.ui;

import android.view.View;
import b.i;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.radar.b.c$m;
import com.tencent.mm.plugin.radar.b.c.b;
import com.tencent.mm.plugin.radar.b.c.e;
import com.tencent.mm.plugin.radar.b.e.c;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.protocal.c.bao;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.x;
import junit.framework.Assert;

public final class RadarViewController$e implements RadarMemberView$b {
    final /* synthetic */ RadarViewController pzY;

    RadarViewController$e(RadarViewController radarViewController) {
        this.pzY = radarViewController;
    }

    public final void a(bao com_tencent_mm_protocal_c_bao, e eVar) {
        b.c.b.e.i(com_tencent_mm_protocal_c_bao, "member");
        g gVar = g.pzC;
        String b = g.b(com_tencent_mm_protocal_c_bao);
        if (eVar != null) {
            switch (h.pxK[eVar.ordinal()]) {
                case 1:
                    RadarViewController.c(this.pzY).pxl.put(Long.valueOf(RadarViewController.e(this.pzY).HY(b)), new c(com_tencent_mm_protocal_c_bao, eVar));
                    RadarViewController.a(this.pzY, b, e.pwI);
                    return;
                case 2:
                    int i;
                    String str;
                    String username;
                    int i2;
                    long j;
                    com.tencent.mm.plugin.radar.b.c e = RadarViewController.e(this.pzY);
                    b.c.b.e.i(b, "username");
                    a h = g.h(h.class);
                    b.c.b.e.h(h, "service(IMessengerStorage::class.java)");
                    x WO = ((h) h).EY().WO(b);
                    b.c.b.e.h(WO, "contact");
                    CharSequence username2 = WO.getUsername();
                    if (username2 == null || b.f.a.X(username2)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        str = b;
                    } else {
                        username = WO.getUsername();
                        b.c.b.e.h(username, "contact.username");
                        str = username;
                    }
                    username = (String) e.pwy.get(str);
                    CharSequence charSequence = username;
                    if (charSequence == null || b.f.a.X(charSequence)) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        b bVar = com.tencent.mm.plugin.radar.b.c.pwC;
                        com.tencent.mm.sdk.platformtools.x.e(com.tencent.mm.plugin.radar.b.c.access$getTAG$cp(), "Verify Contact username(%s) error, verifyTicket is null", str);
                        e.HY(str);
                        j = -1;
                    } else {
                        d Xu = d.Xu(username);
                        long currentTimeMillis = System.currentTimeMillis();
                        com.tencent.mm.plugin.radar.b.c.a aVar = new com.tencent.mm.plugin.radar.b.c.a(e, new c$m(e, username, currentTimeMillis));
                        String cjI = Xu.cjI();
                        b.c.b.e.h(cjI, "verify.verifyTicket");
                        b.c.b.e.i(cjI, "verifyTicket");
                        String str2 = "username is null";
                        boolean z = str != null && str.length() > 0;
                        Assert.assertTrue(str2, z);
                        aVar.onStart();
                        g.CG().d((k) new o(str, cjI, 48));
                        j = currentTimeMillis;
                    }
                    RadarViewController.c(this.pzY).pxl.put(Long.valueOf(j), new c(com_tencent_mm_protocal_c_bao, eVar));
                    RadarViewController.a(this.pzY, b, e.pwI);
                    return;
                default:
                    return;
            }
        }
    }

    public final void b(bao com_tencent_mm_protocal_c_bao, e eVar) {
        Object b;
        if (com_tencent_mm_protocal_c_bao != null) {
            g gVar = g.pzC;
            b = g.b(com_tencent_mm_protocal_c_bao);
        } else {
            b = null;
        }
        View view = (View) RadarViewController.d(this.pzY).pAf.get(b);
        if (view != null) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new i("null cannot be cast to non-null type com.tencent.mm.plugin.radar.ui.RadarViewController.RadarSearchAdapter.ViewHolder");
            }
            RadarViewController.c.a aVar = (RadarViewController.c.a) tag;
            if (eVar != e.pwH) {
                aVar.pAj.blO();
            }
        }
        RadarViewController.f(this.pzY).bmk();
    }
}
