package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.lucky.a.b;
import com.tencent.mm.plugin.sns.lucky.b.a;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;
import java.util.List;

class b$6 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$6(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof ap) {
            String str = ((ap) view.getTag()).fus;
            m Lm = h.Lm(str);
            if (Lm == null) {
                x.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId " + str);
            } else if (Lm.xl(32) && Lm.bxR() != null && Lm.bxR().rfi == 1) {
                this.rPY.rPU.onClick(view);
            } else {
                if (Lm.bxV().wQo.vYc == 21) {
                    if (q.FS().equals(Lm.field_userName)) {
                        str = Lm.bxV().nGJ;
                        com.tencent.mm.plugin.sns.lucky.a.m.j(Lm);
                        com.tencent.mm.plugin.sns.lucky.a.m.i(Lm);
                        System.currentTimeMillis();
                        b.pY(25);
                    }
                    if (!q.FS().equals(Lm.field_userName)) {
                        a.a(2, Lm);
                        b.pY(30);
                    }
                }
                if (Lm.xl(32)) {
                    Lm.bxT();
                    if (Lm.bxR().bwt() && e.Lg(Lm.byB().field_adxml)) {
                        str = e.w(Lm);
                        if (!bh.ov(str)) {
                            Lm.byB().field_adxml = str;
                        }
                        k cVar = new c(Lm.byz(), 21, this.rPY.scene == 0 ? 1 : 2, "", Lm.byD(), Lm.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                        int[] iArr = new int[2];
                        if (view != null) {
                            view.getLocationInWindow(iArr);
                        }
                        int width = view.getWidth();
                        int height = view.getHeight();
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", Lm.bxW());
                        intent.putExtra("sns_landing_pages_rawSnsId", Lm.bxV().nGJ);
                        intent.putExtra("sns_landing_pages_ux_info", Lm.byA());
                        intent.putExtra("sns_landing_pages_aid", Lm.byv());
                        intent.putExtra("sns_landing_pages_traceid", Lm.byw());
                        bnp bxV = Lm.bxV();
                        if (bxV != null) {
                            List list = bxV.wQo.vYd;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                                intent.putExtra("sns_landing_pages_from_outer_index", ((ap) view.getTag()).index);
                            }
                        }
                        intent.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 1 : 2);
                        intent.putExtra("sns_landing_pages_xml", Lm.byB().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", Lm.byC());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        this.rPY.activity.startActivity(intent);
                        this.rPY.activity.overridePendingTransition(0, 0);
                        if (this.rPY.rrV != null) {
                            this.rPY.rrV.bva().v(Lm);
                        }
                    } else {
                        this.rPY.bL(view);
                    }
                } else {
                    this.rPY.bL(view);
                }
                Lm.xl(32);
                ap apVar = (ap) view.getTag();
                if (apVar.rzb && Lm != null) {
                    ax.b(Lm, apVar.index);
                    ax.c(Lm, apVar.index);
                    au.Kx(Lm.byq());
                }
                if (Lm != null) {
                    bnp bxV2 = Lm.bxV();
                    if (bxV2 != null) {
                        String str2 = bxV2.wQn == null ? null : bxV2.wQn.nGJ;
                        if (!bh.ov(str2) && com.tencent.mm.plugin.sns.c.a.ift.cA(str2)) {
                            com.tencent.mm.plugin.sns.c.a.ift.a(null, str2, com.tencent.mm.plugin.sns.c.a.ift.cy(str2), bxV2.ksU, 2, 4, 4, bxV2.wQs, bxV2.nGJ);
                        }
                    }
                }
            }
        }
    }
}
