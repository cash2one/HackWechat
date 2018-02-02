package com.tencent.mm.plugin.sns.ui;

import android.text.TextUtils;
import com.tencent.mm.a.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.ui.ad.7;
import com.tencent.mm.protocal.c.aox;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class ad$3 implements Runnable {
    final /* synthetic */ ad ruF;

    ad$3(ad adVar) {
        this.ruF = adVar;
    }

    public final void run() {
        ad adVar = this.ruF;
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(adVar.nBo) || TextUtils.isEmpty(adVar.hbj)) {
            if (!adVar.ruB.l(adVar.videoPath, adVar.fvC, adVar.desc, adVar.fqR)) {
                x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.me(adVar.videoPath) + " thumb: " + FileOp.me(adVar.fvC));
                ag.y(new 7(adVar));
            }
            x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        } else {
            int i;
            aw awVar = adVar.ruB;
            String str = adVar.videoPath;
            String str2 = adVar.fvC;
            String str3 = adVar.desc;
            String str4 = adVar.fqR;
            String str5 = adVar.nBo;
            String str6 = adVar.hbj;
            String str7 = ae.getAccSnsTmpPath() + g.s(str.getBytes());
            aw.KJ(str7);
            FileOp.x(str, str7);
            String str8 = ae.getAccSnsTmpPath() + g.s(str2.getBytes());
            FileOp.x(str2, str8);
            aqr a = aw.a("", 6, str7, str8, str4, str5, str6);
            if (a == null) {
                x.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                i = 0;
            } else {
                a.nfe = str3;
                if (bh.ov(a.fon)) {
                    a.fon = str3;
                }
                awVar.qYq.wQo.vYd.add(a);
                aox com_tencent_mm_protocal_c_aox = new aox();
                com_tencent_mm_protocal_c_aox.wvG = a.qQY;
                awVar.qYr.wyc.add(com_tencent_mm_protocal_c_aox);
                i = 1;
            }
            if (i == 0) {
                x.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.me(adVar.videoPath) + " thumb: " + FileOp.me(adVar.fvC) + ",cdnUrl " + adVar.nBo + "cdnThubmUrl " + adVar.hbj);
                ag.y(new ad$6(adVar));
            }
            x.i("MicroMsg.SightWidget", "commitInThread cost time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        x.i("MicroMsg.SightWidget", "removeRunnable showProgress");
        ag.K(this.ruF.ruE);
        if (this.ruF.ruB != null) {
            ag.y(this.ruF.ruD);
        }
    }
}
