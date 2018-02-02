package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.sns.a.b.c;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$b;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSightPlayerUI;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bkd;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.List;

class b$19 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$19(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        int i;
        int i2;
        int i3;
        int i4;
        Throwable e;
        x.i("MicroMsg.TimelineClickListener", "onsight click");
        if (view.getTag() instanceof ak) {
            ak akVar = (ak) view.getTag();
            m Lm = ae.bvv().Lm(akVar.frH);
            if (Lm != null) {
                if (this.rPY.rrV != null) {
                    this.rPY.rrV.bva().v(Lm);
                }
                boolean xl = Lm.xl(32);
                if (xl && Lm.bxR() != null && Lm.bxR().rfi == 1) {
                    this.rPY.rPU.onClick(view);
                    return;
                }
                bnp com_tencent_mm_protocal_c_bnp = akVar.rxf;
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() == 0) {
                    x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                    return;
                }
                aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                if (xl) {
                    ae.bvs();
                    if (!g.t(com_tencent_mm_protocal_c_aqr)) {
                        akVar.rkR.setVisibility(8);
                        akVar.rxi.setVisibility(0);
                        akVar.rxi.cyN();
                        ae.bvs().z(com_tencent_mm_protocal_c_aqr);
                        b bvq = ae.bvq();
                        an ciT = an.ciT();
                        ciT.time = com_tencent_mm_protocal_c_bnp.pbl;
                        bvq.a(com_tencent_mm_protocal_c_aqr, 4, null, ciT);
                        if (xl) {
                            j.a(j$b.Sight, a.qPL, Lm);
                            return;
                        }
                        return;
                    }
                }
                Object obj = (Lm.xl(32) && Lm.bxR().bwt() && e.Lg(Lm.byB().field_adxml)) ? 1 : null;
                if (obj == null && xl && ae.bvs().u(com_tencent_mm_protocal_c_aqr)) {
                    ae.bvs().z(com_tencent_mm_protocal_c_aqr);
                    akVar.rkR.setVisibility(8);
                    akVar.rxi.setVisibility(8);
                    g bvs = ae.bvs();
                    com.tencent.mm.plugin.sight.decode.a.a aVar = akVar.qvN;
                    int hashCode = this.rPY.activity.hashCode();
                    int i5 = akVar.position;
                    an ciT2 = an.ciT();
                    ciT2.time = com_tencent_mm_protocal_c_bnp.pbl;
                    bvs.a(Lm, com_tencent_mm_protocal_c_aqr, aVar, hashCode, i5, ciT2, xl);
                    if (xl) {
                        j.a(j$b.Sight, a.qPL, Lm);
                        return;
                    }
                    return;
                }
                com.tencent.mm.modelsns.b iu;
                if (this.rPY.scene == 0) {
                    iu = com.tencent.mm.modelsns.b.iu(717);
                } else {
                    iu = com.tencent.mm.modelsns.b.iv(717);
                }
                iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(com_tencent_mm_protocal_c_aqr.nGJ);
                iu.Sx();
                if (this.rPY.scene == 0) {
                    iu = com.tencent.mm.modelsns.b.iu(745);
                } else {
                    iu = com.tencent.mm.modelsns.b.iv(745);
                }
                iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32));
                if (xl) {
                    int i6 = this.rPY.scene == 0 ? 1 : 2;
                    String byz = Lm.byz();
                    int i7 = (Lm.xl(32) && Lm.bxR().bwt()) ? 21 : 17;
                    k cVar = new c(byz, i7, i6, "", Lm.byD(), Lm.bxW());
                    com.tencent.mm.kernel.g.Dk();
                    com.tencent.mm.kernel.g.Di().gPJ.a(cVar, 0);
                    if (!(Lm.bxR().bwt() && e.Lg(Lm.byB().field_adxml))) {
                        j.a(j$b.Sight, a.qPM, Lm);
                    }
                }
                String str = "";
                String r = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                String str2 = "";
                String j = i.j(com_tencent_mm_protocal_c_aqr);
                if (FileOp.bO(r + j)) {
                    str = r + j;
                    str2 = r + i.e(com_tencent_mm_protocal_c_aqr);
                }
                if (FileOp.bO(r + i.p(com_tencent_mm_protocal_c_aqr))) {
                    str = r + i.p(com_tencent_mm_protocal_c_aqr);
                    str2 = r + i.n(com_tencent_mm_protocal_c_aqr);
                }
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                int height = view.getHeight();
                com.tencent.mm.plugin.report.service.g.pQN.h(11444, new Object[]{Integer.valueOf(3)});
                Intent intent;
                if (!xl) {
                    x.i("MicroMsg.TimelineClickListener", "it not ad video, use online video activity to play.");
                    intent = new Intent();
                    intent.setClass(this.rPY.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", akVar.frH);
                    intent.putExtra("intent_isad", xl);
                    intent.putExtra("intent_from_scene", this.rPY.scene);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    iu.b(intent, "intent_key_StatisticsOplog");
                    this.rPY.activity.startActivity(intent);
                    this.rPY.activity.overridePendingTransition(0, 0);
                    b.a(this.rPY, Lm.bxV());
                } else if (Lm.xl(32) && Lm.bxR().bwt() && e.Lg(Lm.byB().field_adxml)) {
                    String w = e.w(Lm);
                    if (!bh.ov(w)) {
                        Lm.byB().field_adxml = w;
                    }
                    intent = new Intent();
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    intent.putExtra("sns_landing_pages_share_sns_id", Lm.bxW());
                    intent.putExtra("sns_landing_pages_rawSnsId", Lm.bxV().nGJ);
                    intent.putExtra("sns_landing_pages_ux_info", Lm.byA());
                    r2 = Lm.bxV();
                    if (r2 != null) {
                        List list = r2.wQo.vYd;
                        if (list.size() > 0) {
                            intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                        }
                    }
                    intent.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 1 : 2);
                    intent.putExtra("sns_landing_pages_xml", Lm.byB().field_adxml);
                    intent.putExtra("sns_landing_pages_rec_src", Lm.byC());
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                    intent.putExtra("sns_landing_is_native_sight_ad", true);
                    this.rPY.activity.startActivity(intent);
                    this.rPY.activity.overridePendingTransition(0, 0);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setClass(this.rPY.activity, SnsSightPlayerUI.class);
                    intent2.putExtra("intent_videopath", str);
                    intent2.putExtra("intent_thumbpath", str2);
                    intent2.putExtra("intent_localid", akVar.frH);
                    intent2.putExtra("intent_isad", xl);
                    intent2.putExtra("intent_from_scene", this.rPY.scene);
                    intent2.putExtra("img_gallery_left", iArr[0]);
                    intent2.putExtra("img_gallery_top", iArr[1]);
                    intent2.putExtra("img_gallery_width", width);
                    intent2.putExtra("img_gallery_height", height);
                    iu.b(intent2, "intent_key_StatisticsOplog");
                    this.rPY.activity.startActivity(intent2);
                    this.rPY.activity.overridePendingTransition(0, 0);
                    new af().postDelayed(new 1(this, com_tencent_mm_protocal_c_aqr, akVar, Lm, com_tencent_mm_protocal_c_bnp, xl), 500);
                    int[] iArr2 = new int[3];
                    if (!xl && ae.bvs().a(Lm, iArr2) > 5) {
                        ae.bvs().y(com_tencent_mm_protocal_c_aqr);
                        i = 1;
                    } else if (!xl || ae.bvs().b(Lm, iArr2) <= 5) {
                        i = 2;
                    } else {
                        ae.bvs().y(com_tencent_mm_protocal_c_aqr);
                        i = 1;
                    }
                    int i8 = iArr2[0];
                    int i9 = iArr2[1];
                    if (i == 2) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    width = iArr2[2];
                    r2 = Lm.bxV();
                    d dVar = new d();
                    dVar.q("20FeedId", r2.nGJ + ",");
                    dVar.q("21AdUxInfo", Lm.byA() + ",");
                    try {
                        bjv com_tencent_mm_protocal_c_bjv = (bjv) new bjv().aF(Lm.field_attrBuf);
                        if (com_tencent_mm_protocal_c_bjv.wNn != null) {
                            bkd com_tencent_mm_protocal_c_bkd = (bkd) new bkd().aF(com_tencent_mm_protocal_c_bjv.wNn.wJD.oz);
                            if (com_tencent_mm_protocal_c_bkd.wNC != null) {
                                i3 = com_tencent_mm_protocal_c_bkd.wNC.vYT;
                                try {
                                    i4 = com_tencent_mm_protocal_c_bkd.wNC.vYU;
                                } catch (Exception e2) {
                                    e = e2;
                                    x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                                    i4 = 0;
                                    dVar.q("22LayerId", i3 + ",");
                                    dVar.q("23ExpId", i4 + ",");
                                    dVar.q("24ClickState", i + ",");
                                    dVar.q("25ClickTime", bh.Wo() + ",");
                                    i4 = 0;
                                    if (!com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext())) {
                                        i4 = 1;
                                    } else if (!com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext())) {
                                        i4 = 2;
                                    } else if (!com.tencent.mm.sdk.platformtools.an.is3G(ac.getContext())) {
                                        i4 = 3;
                                    } else if (com.tencent.mm.sdk.platformtools.an.is4G(ac.getContext())) {
                                        i4 = 4;
                                    }
                                    dVar.q("26NetworkType", i4 + ",");
                                    dVar.q("27IsFlowControl", i8 + ",");
                                    dVar.q("28AutoDownloadSetting", i9 + ",");
                                    dVar.q("29IsAutoPlay", i2 + ",");
                                    dVar.q("30IsFlowControlDatePeriod", width + ",");
                                    x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Sz());
                                    com.tencent.mm.plugin.report.service.g.pQN.h(13323, new Object[]{dVar});
                                }
                                dVar.q("22LayerId", i3 + ",");
                                dVar.q("23ExpId", i4 + ",");
                                dVar.q("24ClickState", i + ",");
                                dVar.q("25ClickTime", bh.Wo() + ",");
                                i4 = 0;
                                if (!com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext())) {
                                    i4 = 1;
                                } else if (!com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext())) {
                                    i4 = 2;
                                } else if (!com.tencent.mm.sdk.platformtools.an.is3G(ac.getContext())) {
                                    i4 = 3;
                                } else if (com.tencent.mm.sdk.platformtools.an.is4G(ac.getContext())) {
                                    i4 = 4;
                                }
                                dVar.q("26NetworkType", i4 + ",");
                                dVar.q("27IsFlowControl", i8 + ",");
                                dVar.q("28AutoDownloadSetting", i9 + ",");
                                dVar.q("29IsAutoPlay", i2 + ",");
                                dVar.q("30IsFlowControlDatePeriod", width + ",");
                                x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Sz());
                                com.tencent.mm.plugin.report.service.g.pQN.h(13323, new Object[]{dVar});
                            }
                        }
                        i4 = 0;
                        i3 = 0;
                    } catch (Exception e3) {
                        e = e3;
                        i3 = 0;
                        x.printErrStackTrace("MicroMsg.TimelineClickListener", e, "", new Object[0]);
                        i4 = 0;
                        dVar.q("22LayerId", i3 + ",");
                        dVar.q("23ExpId", i4 + ",");
                        dVar.q("24ClickState", i + ",");
                        dVar.q("25ClickTime", bh.Wo() + ",");
                        i4 = 0;
                        if (!com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext())) {
                            i4 = 1;
                        } else if (!com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext())) {
                            i4 = 2;
                        } else if (!com.tencent.mm.sdk.platformtools.an.is3G(ac.getContext())) {
                            i4 = 3;
                        } else if (com.tencent.mm.sdk.platformtools.an.is4G(ac.getContext())) {
                            i4 = 4;
                        }
                        dVar.q("26NetworkType", i4 + ",");
                        dVar.q("27IsFlowControl", i8 + ",");
                        dVar.q("28AutoDownloadSetting", i9 + ",");
                        dVar.q("29IsAutoPlay", i2 + ",");
                        dVar.q("30IsFlowControlDatePeriod", width + ",");
                        x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Sz());
                        com.tencent.mm.plugin.report.service.g.pQN.h(13323, new Object[]{dVar});
                    }
                    dVar.q("22LayerId", i3 + ",");
                    dVar.q("23ExpId", i4 + ",");
                    dVar.q("24ClickState", i + ",");
                    dVar.q("25ClickTime", bh.Wo() + ",");
                    i4 = 0;
                    if (!com.tencent.mm.sdk.platformtools.an.isWifi(ac.getContext())) {
                        i4 = 1;
                    } else if (!com.tencent.mm.sdk.platformtools.an.is2G(ac.getContext())) {
                        i4 = 2;
                    } else if (!com.tencent.mm.sdk.platformtools.an.is3G(ac.getContext())) {
                        i4 = 3;
                    } else if (com.tencent.mm.sdk.platformtools.an.is4G(ac.getContext())) {
                        i4 = 4;
                    }
                    dVar.q("26NetworkType", i4 + ",");
                    dVar.q("27IsFlowControl", i8 + ",");
                    dVar.q("28AutoDownloadSetting", i9 + ",");
                    dVar.q("29IsAutoPlay", i2 + ",");
                    dVar.q("30IsFlowControlDatePeriod", width + ",");
                    x.i("MicroMsg.TimelineClickListener", "report SnsSightPreloadExp(sight_autodownload) logbuffer(13323): " + dVar.Sz());
                    com.tencent.mm.plugin.report.service.g.pQN.h(13323, new Object[]{dVar});
                }
            }
        }
    }
}
