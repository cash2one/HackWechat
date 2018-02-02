package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.d.n.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class k implements a {
    Activity activity;
    private ad rrV;
    private int scene = 0;

    public k(Activity activity, int i, ad adVar) {
        this.activity = activity;
        this.scene = i;
        this.rrV = adVar;
    }

    public final void bJ(Object obj) {
        boolean z = false;
        Intent intent = new Intent();
        if (this.activity != null) {
            if (obj instanceof com.tencent.mm.plugin.sns.data.a) {
                com.tencent.mm.plugin.sns.data.a aVar = (com.tencent.mm.plugin.sns.data.a) obj;
                x.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.activity == null));
                m Lm = ae.bvv().Lm(aVar.fus);
                if (aVar.qQH) {
                    b bxR = Lm.bxR();
                    String byz = Lm.byz();
                    if (bxR == null || bxR.reG != 1 || bh.ov(bxR.reH)) {
                        this.rrV.bva().a(Lm, false);
                        intent.putExtra("Contact_User", aVar.userName);
                        intent.putExtra("Contact_Scene", 37);
                        com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.activity);
                        com.tencent.mm.ae.k cVar = new c(Lm.byz(), 2, aVar.scene, "", Lm.byD(), Lm.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                        return;
                    }
                    String str = bxR.reH;
                    x.i("Micro.ClickableCallBack", "headClickParam url " + str + " " + bxR.reI);
                    Intent intent2 = new Intent();
                    if (bxR.reI == 0) {
                        z = true;
                    }
                    intent2.putExtra("KsnsViewId", byz);
                    intent2.putExtra("KRightBtn", z);
                    intent2.putExtra("jsapiargs", new Bundle());
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    com.tencent.mm.plugin.sns.c.a.ifs.j(intent2, this.activity);
                    return;
                }
                com.tencent.mm.modelsns.b iu;
                obj = aVar.userName;
                if (this.scene == 0) {
                    iu = com.tencent.mm.modelsns.b.iu(719);
                } else {
                    iu = com.tencent.mm.modelsns.b.iv(719);
                }
                iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(obj);
                iu.Sx();
                if (this.scene == 0) {
                    iu = com.tencent.mm.modelsns.b.iu(746);
                } else {
                    iu = com.tencent.mm.modelsns.b.iv(746);
                }
                iu.mB(obj).bU(obj.endsWith(q.FS()));
                iu.b(intent, "intent_key_StatisticsOplog");
                if (this.scene == 0) {
                    this.rrV.bva().a(Lm, false);
                }
            } else {
                obj = (String) obj;
                if (obj.contains("@")) {
                    obj = obj.replace("@", "");
                }
                g.Dk();
                com.tencent.mm.storage.x WM = ((h) g.h(h.class)).EY().WM(obj);
                if (WM != null && WM.cia()) {
                    intent.putExtra("Contact_User", obj);
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.activity);
                    return;
                } else if (this.scene == 0) {
                    m mVar = new m();
                    mVar.field_userName = obj;
                    this.rrV.bva().a(mVar, false);
                }
            }
            intent.putExtra("Contact_User", obj);
            com.tencent.mm.plugin.sns.c.a.ifs.d(intent, this.activity);
        }
    }
}
