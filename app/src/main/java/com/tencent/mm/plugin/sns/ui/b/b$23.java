package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.c.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.c.c;
import java.util.Map;

class b$23 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$23(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof Long)) {
            String byx;
            a bxT;
            k cVar;
            String str;
            Intent intent;
            boolean z;
            Parcelable snsAdClick;
            Bundle bundle;
            e eK = ae.bvy().eK(((Long) view.getTag()).longValue());
            m bxX = eK.bxX();
            j.a(b.qPU, j.a.qPS, eK.bxX());
            int source = eK.getSource();
            String byy = bxX.byy();
            if (bh.ov(byy)) {
                byx = bxX.byx();
            } else {
                byx = byy;
            }
            if (bxX.xl(32)) {
                bxT = bxX.bxT();
                int i = -1;
                com.tencent.mm.storage.a Wo = c.IG().Wo("Sns_CanvasAd_DetailLink_JumpWay");
                if (Wo.isValid()) {
                    i = bh.getInt(Wo.field_value, -1);
                }
                if (bxT != null && bxT.rdM == 1) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("key_card_id", bxT.rdO);
                    intent2.putExtra("key_card_ext", bxT.rdP);
                    intent2.putExtra("key_from_scene", 21);
                    intent2.putExtra("key_stastic_scene", 15);
                    d.b(this.rPY.activity, "card", ".ui.CardDetailUI", intent2);
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene == 0 ? 1 : 2, "", bxX.byD(), 11, source, bxX.bxV().rtA, bxX.bxW());
                    g.Dk();
                    g.Di().gPJ.a(cVar, 0);
                    return;
                } else if (bxT == null || r0 != 1) {
                    if (bxT == null || r0 != 0) {
                        if (bxT != null && r0 == -1 && bxT.rdM == 3) {
                            if (bxX.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(bxX.byB().field_adxml)) {
                                byy = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bxX);
                                if (!bh.ov(byy)) {
                                    eK.field_adxml = byy;
                                }
                                r1 = new Intent();
                                r1.putExtra("sns_landing_pages_share_sns_id", bxX.bxW());
                                r1.putExtra("sns_landing_pages_rawSnsId", bxX.bxV().nGJ);
                                r1.putExtra("sns_landing_pages_ux_info", bxX.byA());
                                r1.putExtra("sns_landing_pages_aid", bxX.byv());
                                r1.putExtra("sns_landing_pages_traceid", bxX.byw());
                                r0 = bxX.bxV();
                                if (r0 != null) {
                                    r0 = r0.wQo.vYd;
                                    if (r0.size() > 0) {
                                        r1.putExtra("sns_landing_pages_share_thumb_url", ((aqr) r0.get(0)).wxE);
                                    }
                                }
                                r1.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                                r1.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 9 : 10);
                                r1.putExtra("sns_landing_pages_xml", bxX.byB().field_adxml);
                                r1.putExtra("sns_landing_pages_rec_src", bxX.byC());
                                r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                                this.rPY.activity.startActivity(r1);
                                this.rPY.activity.overridePendingTransition(0, 0);
                                cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene == 0 ? 1 : 2, "", bxX.byD(), 21, source, bxX.bxV().rtA, bxX.bxW());
                                g.Dk();
                                g.Di().gPJ.a(cVar, 0);
                                return;
                            }
                        } else if (b.a(this.rPY, bxT, bxX, false)) {
                            cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene == 0 ? 1 : 2, "", bxX.byD(), 31, source, bxX.bxV().rtA, bxX.bxW());
                            g.Dk();
                            g.Di().gPJ.a(cVar, 0);
                            return;
                        }
                    } else if (bxX.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(bxX.byB().field_adxml)) {
                        byy = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bxX);
                        if (!bh.ov(byy)) {
                            eK.field_adxml = byy;
                        }
                        Map y = f.y(bxX.byB().field_adxml, "adxml");
                        if (y != null) {
                            byy = bh.az((String) y.get(".adxml.adCanvasInfo.shareWebUrl"), "");
                            if (!bh.ov(byy)) {
                                byx = byy;
                            }
                            str = byx;
                        } else {
                            x.e("MicroMsg.TimelineClickListener", "parse landingpagexml is error,landingpagexml is " + bxX.byB().field_adxml);
                            str = byx;
                        }
                        cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene != 0 ? 1 : 2, "", bxX.byD(), 0, source, bxX.bxV().rtA, bxX.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar, 0);
                        x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bxX.bxR().rew);
                        intent = new Intent();
                        z = bxX.bxR().rew != 0;
                        if (r.idC) {
                            z = false;
                        }
                        snsAdClick = new SnsAdClick(bxX.byz(), this.rPY.scene != 0 ? 1 : 2, bxX.field_snsId, bxX.byA(), bxX.byD(), (byte) 0);
                        snsAdClick.hOw = bxX.bxV().nGJ;
                        if (bxX.xl(32)) {
                            bxT = bxX.bxT();
                            if (bxT != null) {
                                intent.putExtra("KsnsViewId", bxT.iTh);
                            }
                        }
                        intent.putExtra("KRightBtn", z);
                        bundle = new Bundle();
                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                        bundle.putString("key_snsad_statextstr", eK.bxV().rtA);
                        intent.putExtra("jsapiargs", bundle);
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra("srcUsername", bxX.field_userName);
                        intent.putExtra("sns_local_id", bxX.byq());
                        intent.putExtra("stastic_scene", 15);
                        intent.putExtra("KPublisherId", "sns_" + i.eq(bxX.field_snsId));
                        intent.putExtra("pre_username", bxX.field_userName);
                        intent.putExtra("prePublishId", "sns_" + i.eq(bxX.field_snsId));
                        intent.putExtra("preUsername", bxX.field_userName);
                        com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                    }
                } else if (bxX.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(bxX.byB().field_adxml)) {
                    byy = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(bxX);
                    if (!bh.ov(byy)) {
                        eK.field_adxml = byy;
                    }
                    r1 = new Intent();
                    r1.putExtra("sns_landing_pages_share_sns_id", bxX.bxW());
                    r1.putExtra("sns_landing_pages_rawSnsId", bxX.bxV().nGJ);
                    r1.putExtra("sns_landing_pages_ux_info", bxX.byA());
                    r1.putExtra("sns_landing_pages_aid", bxX.byv());
                    r1.putExtra("sns_landing_pages_traceid", bxX.byw());
                    r0 = bxX.bxV();
                    if (r0 != null) {
                        r0 = r0.wQo.vYd;
                        if (r0.size() > 0) {
                            r1.putExtra("sns_landing_pages_share_thumb_url", ((aqr) r0.get(0)).wxE);
                        }
                    }
                    r1.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                    r1.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 9 : 10);
                    r1.putExtra("sns_landing_pages_xml", bxX.byB().field_adxml);
                    r1.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    r1.putExtra("sns_landing_pages_rec_src", bxX.byC());
                    r1.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    this.rPY.activity.startActivity(r1);
                    this.rPY.activity.overridePendingTransition(0, 0);
                    cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene == 0 ? 1 : 2, "", bxX.byD(), 21, source, bxX.bxV().rtA, bxX.bxW());
                    g.Dk();
                    g.Di().gPJ.a(cVar, 0);
                    return;
                }
            }
            str = byx;
            if (this.rPY.scene != 0) {
            }
            cVar = new com.tencent.mm.plugin.sns.a.b.c(bxX.byz(), 3, this.rPY.scene != 0 ? 1 : 2, "", bxX.byD(), 0, source, bxX.bxV().rtA, bxX.bxW());
            g.Dk();
            g.Di().gPJ.a(cVar, 0);
            x.i("MicroMsg.TimelineClickListener", "adlink url " + str + " " + bxX.bxR().rew);
            intent = new Intent();
            if (bxX.bxR().rew != 0) {
            }
            if (r.idC) {
                z = false;
            }
            if (this.rPY.scene != 0) {
            }
            snsAdClick = new SnsAdClick(bxX.byz(), this.rPY.scene != 0 ? 1 : 2, bxX.field_snsId, bxX.byA(), bxX.byD(), (byte) 0);
            snsAdClick.hOw = bxX.bxV().nGJ;
            if (bxX.xl(32)) {
                bxT = bxX.bxT();
                if (bxT != null) {
                    intent.putExtra("KsnsViewId", bxT.iTh);
                }
            }
            intent.putExtra("KRightBtn", z);
            bundle = new Bundle();
            bundle.putParcelable("KSnsAdTag", snsAdClick);
            bundle.putString("key_snsad_statextstr", eK.bxV().rtA);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("rawUrl", str);
            intent.putExtra("useJs", true);
            intent.putExtra("srcUsername", bxX.field_userName);
            intent.putExtra("sns_local_id", bxX.byq());
            intent.putExtra("stastic_scene", 15);
            intent.putExtra("KPublisherId", "sns_" + i.eq(bxX.field_snsId));
            intent.putExtra("pre_username", bxX.field_userName);
            intent.putExtra("prePublishId", "sns_" + i.eq(bxX.field_snsId));
            intent.putExtra("preUsername", bxX.field_userName);
            com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
        }
    }
}
