package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.pk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bh;

class SnsSightPlayerUI$8 implements OnClickListener {
    final /* synthetic */ SnsSightPlayerUI rGv;

    SnsSightPlayerUI$8(SnsSightPlayerUI snsSightPlayerUI) {
        this.rGv = snsSightPlayerUI;
    }

    public final void onClick(View view) {
        b iu;
        if (SnsSightPlayerUI.a(this.rGv).xl(32)) {
            j.a(j.b.qPU, j$a.EnterCompleteVideo, SnsSightPlayerUI.a(this.rGv));
        }
        Intent intent = new Intent();
        String r = am.r(ae.getAccSnsPath(), SnsSightPlayerUI.b(this.rGv).nGJ);
        String k = i.k(SnsSightPlayerUI.b(this.rGv));
        intent.setClass(this.rGv, VideoAdPlayerUI.class);
        intent.putExtra("KFullVideoPath", r + k);
        intent.putExtra("KThumbPath", SnsSightPlayerUI.c(this.rGv));
        intent.putExtra("IsAd", true);
        intent.putExtra("KStremVideoUrl", SnsSightPlayerUI.b(this.rGv).wxL);
        intent.putExtra("KThumUrl", bh.ov(SnsSightPlayerUI.b(this.rGv).wxO) ? SnsSightPlayerUI.b(this.rGv).wxE : SnsSightPlayerUI.b(this.rGv).wxO);
        intent.putExtra("KMediaId", SnsSightPlayerUI.b(this.rGv).nGJ);
        intent.putExtra("KUrl", SnsSightPlayerUI.b(this.rGv).nfX);
        intent.putExtra("KViewId", SnsSightPlayerUI.a(this.rGv).byz());
        bnp bxV = SnsSightPlayerUI.a(this.rGv).bxV();
        String str = "KSta_StremVideoAduxInfo";
        if (SnsSightPlayerUI.a(this.rGv).bxT() == null) {
            r = "";
        } else {
            r = SnsSightPlayerUI.a(this.rGv).bxT().qZM;
        }
        intent.putExtra(str, r);
        intent.putExtra("KSta_StremVideoPublishId", bxV.nGJ);
        intent.putExtra("KSta_SourceType", 1);
        intent.putExtra("KSta_Scene", j.b.qPU.value);
        intent.putExtra("KSta_FromUserName", bxV.ksU);
        intent.putExtra("KSta_SnSId", bxV.nGJ);
        intent.putExtra("KSta_SnsStatExtStr", bxV.rtA);
        intent.putExtra("KMediaVideoTime", SnsSightPlayerUI.b(this.rGv).rNe);
        if (bh.ov(SnsSightPlayerUI.b(this.rGv).wxP)) {
            r = bxV.wQl;
        } else {
            r = SnsSightPlayerUI.b(this.rGv).wxP;
        }
        intent.putExtra("KMediaTitle", r);
        com.tencent.mm.plugin.sns.storage.b bxR = SnsSightPlayerUI.a(this.rGv).bxR();
        if (bxR != null && bxR.reD == 0) {
            intent.putExtra("StreamWording", bxR.reE);
            intent.putExtra("StremWebUrl", bxR.reF);
        }
        m Lm = ae.bvv().Lm(SnsSightPlayerUI.d(this.rGv));
        if (SnsSightPlayerUI.e(this.rGv) == 0) {
            iu = b.iu(747);
        } else {
            iu = b.iv(747);
        }
        iu.mB(i.g(Lm)).ix(Lm.field_type).bU(true).mB(Lm.byA()).ix(SnsSightPlayerUI.b(this.rGv).rNe);
        iu.Sx();
        if (SnsSightPlayerUI.e(this.rGv) == 0) {
            iu = b.iu(748);
        } else {
            iu = b.iv(748);
        }
        iu.mB(i.g(Lm)).ix(Lm.field_type).bU(true).mB(Lm.byA()).ix(SnsSightPlayerUI.b(this.rGv).rNe);
        iu.b(intent, "intent_key_StatisticsOplog");
        this.rGv.startActivity(intent);
        k cVar = new c(SnsSightPlayerUI.a(this.rGv).byz(), 14, 5, "", 2, SnsSightPlayerUI.a(this.rGv).bxW());
        g.Dk();
        g.Di().gPJ.a(cVar, 0);
        if (SnsSightPlayerUI.e(this.rGv) == 0) {
            com.tencent.mm.sdk.b.b pkVar = new pk();
            pkVar.fHo.fAs = true;
            a.xef.m(pkVar);
        }
    }
}
