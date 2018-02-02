package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aoy;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class b$29 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$29(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        int i = 2;
        if (view.getTag() instanceof String) {
            m Lm = ae.bvv().Lm((String) view.getTag());
            if (Lm == null) {
                return;
            }
            b iu;
            if (Lm.xl(32)) {
                x.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                k cVar = new c(Lm.byz(), 19, this.rPY.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar, 0);
                a bxT = Lm.bxT();
                if (bxT == null) {
                    x.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                    return;
                } else if (bh.ov(bxT.rdU)) {
                    x.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                    return;
                } else {
                    if (this.rPY.scene == 0) {
                        iu = b.iu(724);
                    } else {
                        iu = b.iv(724);
                    }
                    iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB("").mB("").mB("").mB("").mB(bxT.rdT).mB("").mB("");
                    iu.Sx();
                    x.i("MicroMsg.TimelineClickListener", "open webview url : " + bxT.rdU);
                    Intent intent = new Intent();
                    String byz = Lm.byz();
                    int i2 = this.rPY.scene == 0 ? 1 : 2;
                    long j = Lm.field_snsId;
                    String byA = Lm.byA();
                    if (Lm.field_type == 1) {
                        i = 1;
                    }
                    Parcelable snsAdClick = new SnsAdClick(byz, i2, j, byA, i);
                    snsAdClick.hOw = Lm.bxV().nGJ;
                    if (Lm != null && Lm.xl(32)) {
                        a bxT2 = Lm.bxT();
                        if (bxT2 != null) {
                            intent.putExtra("KsnsViewId", bxT2.iTh);
                        }
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("useJs", true);
                    intent.putExtra("KPublisherId", "sns_" + i.eq(Lm.field_snsId));
                    intent.putExtra("pre_username", Lm.field_userName);
                    intent.putExtra("prePublishId", "sns_" + i.eq(Lm.field_snsId));
                    intent.putExtra("preUsername", Lm.field_userName);
                    intent.putExtra("rawUrl", bxT.rdU);
                    com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                    return;
                }
            }
            aoy com_tencent_mm_protocal_c_aoy = Lm.bxV().wQm;
            Intent intent2 = new Intent();
            if (this.rPY.scene == 0) {
                iu = b.iu(724);
            } else {
                iu = b.iv(724);
            }
            iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(com_tencent_mm_protocal_c_aoy.wvH).ix(com_tencent_mm_protocal_c_aoy.rug).mB(com_tencent_mm_protocal_c_aoy.vQu).mB(com_tencent_mm_protocal_c_aoy.vQt).mB(com_tencent_mm_protocal_c_aoy.nTe).mB(com_tencent_mm_protocal_c_aoy.rue).mB(com_tencent_mm_protocal_c_aoy.hvv);
            iu.Sx();
            if (bh.ov(com_tencent_mm_protocal_c_aoy.wvH)) {
                intent2.putExtra("map_view_type", 7);
                intent2.putExtra("kwebmap_slat", (double) com_tencent_mm_protocal_c_aoy.vQu);
                intent2.putExtra("kwebmap_lng", (double) com_tencent_mm_protocal_c_aoy.vQt);
                intent2.putExtra("kPoiName", com_tencent_mm_protocal_c_aoy.nTe);
                intent2.putExtra("Kwebmap_locaion", com_tencent_mm_protocal_c_aoy.rue);
                d.b(this.rPY.activity, "location", ".ui.RedirectUI", intent2);
                return;
            }
            String format;
            if (this.rPY.rPW == 0) {
                format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&action=list#wechat_redirect", new Object[]{com_tencent_mm_protocal_c_aoy.wvH});
            } else {
                format = String.format("http://mp.weixin.qq.com/mp/lifedetail?bid=%s&tid=%s&action=list#wechat_redirect", new Object[]{com_tencent_mm_protocal_c_aoy.wvH, r1.nGJ});
            }
            intent2.putExtra("rawUrl", format);
            com.tencent.mm.plugin.sns.c.a.ifs.j(intent2, this.rPY.activity);
        }
    }
}
