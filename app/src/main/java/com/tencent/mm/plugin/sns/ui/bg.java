package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.jr;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bme;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.r;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.List;

public final class bg {
    Context context;
    public OnClickListener rFh = new OnClickListener(this) {
        final /* synthetic */ bg rMH;

        {
            this.rMH = r1;
        }

        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.rMH.rMs >= 500) {
                this.rMH.rMs = currentTimeMillis;
                if (view.getTag() instanceof r) {
                    r rVar = (r) view.getTag();
                    bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
                    m Lm = ae.bvv().Lm(rVar.frH);
                    if (this.rMH.rrV != null) {
                        this.rMH.rrV.bva().v(Lm);
                    }
                    Intent intent;
                    aqr com_tencent_mm_protocal_c_aqr;
                    if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 18) {
                        Context context = this.rMH.context;
                        bnp com_tencent_mm_protocal_c_bnp2 = rVar.rsq;
                        j.a(b.qPV, a.qPN, ae.bvv().Lm(rVar.frH));
                        intent = new Intent();
                        com_tencent_mm_protocal_c_aqr = null;
                        if (com_tencent_mm_protocal_c_bnp2.wQo.vYd.size() > 0) {
                            com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp2.wQo.vYd.get(0);
                        }
                        intent.putExtra("IsAd", false);
                        intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bnp2.wQo.nfX);
                        intent.putExtra("KSta_SourceType", 2);
                        intent.putExtra("KSta_Scene", b.qPV.value);
                        intent.putExtra("KSta_FromUserName", com_tencent_mm_protocal_c_bnp2.ksU);
                        intent.putExtra("KSta_SnSId", com_tencent_mm_protocal_c_bnp2.nGJ);
                        if (com_tencent_mm_protocal_c_aqr == null) {
                            intent.putExtra("KMediaId", "fakeid_" + (com_tencent_mm_protocal_c_aqr == null ? com_tencent_mm_protocal_c_bnp2.nGJ : com_tencent_mm_protocal_c_aqr.nGJ));
                        } else {
                            intent.putExtra("KMediaId", com_tencent_mm_protocal_c_aqr.nGJ);
                        }
                        bme com_tencent_mm_protocal_c_bme = com_tencent_mm_protocal_c_bnp2.wQt;
                        if (com_tencent_mm_protocal_c_bme != null) {
                            intent.putExtra("KMediaVideoTime", com_tencent_mm_protocal_c_bme.hdp);
                            intent.putExtra("StreamWording", com_tencent_mm_protocal_c_bme.hdr);
                            intent.putExtra("StremWebUrl", com_tencent_mm_protocal_c_bme.hds);
                            intent.putExtra("KMediaTitle", com_tencent_mm_protocal_c_bme.hdq);
                            intent.putExtra("KStremVideoUrl", com_tencent_mm_protocal_c_bme.hdo);
                            intent.putExtra("KThumUrl", com_tencent_mm_protocal_c_bme.hdt);
                            intent.putExtra("KSta_StremVideoAduxInfo", com_tencent_mm_protocal_c_bme.hdu);
                            intent.putExtra("KSta_StremVideoPublishId", com_tencent_mm_protocal_c_bme.hdv);
                        }
                        intent.putExtra("KSta_SnsStatExtStr", com_tencent_mm_protocal_c_bnp2.rtA);
                        d.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    } else if (com_tencent_mm_protocal_c_bnp.qYw == null || bh.ov(com_tencent_mm_protocal_c_bnp.qYw.tnm)) {
                        String str = com_tencent_mm_protocal_c_bnp.wQo.nfX;
                        String str2 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
                        x.d("MicroMsg.TimeLineClickEvent", "url:" + str);
                        String A = com.tencent.mm.plugin.sns.c.a.ift.A(str, "timeline");
                        if (A != null && A.length() != 0) {
                            Intent intent2 = new Intent();
                            Bundle bundle = null;
                            if (com_tencent_mm_protocal_c_bnp != null) {
                                Bundle bundle2 = new Bundle();
                                bundle2.putString("KSnsStrId", com_tencent_mm_protocal_c_bnp.nGJ);
                                bundle2.putString("KSnsLocalId", rVar.frH);
                                bundle2.putBoolean("KFromTimeline", true);
                                if (com_tencent_mm_protocal_c_bnp.wQo != null && com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                                    bundle2.putString("K_sns_thumb_url", ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0)).wxE);
                                    bundle2.putString("K_sns_raw_url", com_tencent_mm_protocal_c_bnp.wQo.nfX);
                                    x.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0)).wxE, com_tencent_mm_protocal_c_bnp.wQo.nfX);
                                }
                                bundle = bundle2;
                            }
                            bundle.putString("key_snsad_statextstr", com_tencent_mm_protocal_c_bnp.rtA);
                            intent2.putExtra("rawUrl", A);
                            intent2.putExtra("shortUrl", A);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra(DownloadSettingTable$Columns.TYPE, -255);
                            if (com_tencent_mm_protocal_c_bnp.wQp != null) {
                                intent2.putExtra("srcUsername", com_tencent_mm_protocal_c_bnp.wQp);
                                intent2.putExtra("srcDisplayname", com_tencent_mm_protocal_c_bnp.vmT);
                                x.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + com_tencent_mm_protocal_c_bnp.vmT + " tlObj.publicUserName: " + com_tencent_mm_protocal_c_bnp.wQp);
                            }
                            intent2.putExtra("sns_local_id", rVar.frH);
                            if (Lm != null) {
                                intent2.putExtra("KPublisherId", "sns_" + i.eq(Lm.field_snsId));
                                intent2.putExtra("pre_username", Lm.field_userName);
                                intent2.putExtra("prePublishId", "sns_" + i.eq(Lm.field_snsId));
                                intent2.putExtra("preUsername", Lm.field_userName);
                                intent2.putExtra("share_report_pre_msg_url", A);
                                intent2.putExtra("share_report_pre_msg_title", com_tencent_mm_protocal_c_bnp.wQo.fon);
                                intent2.putExtra("share_report_pre_msg_desc", com_tencent_mm_protocal_c_bnp.wQo.nfe);
                                if (com_tencent_mm_protocal_c_bnp.wQo.vYd != null && com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                                    intent2.putExtra("share_report_pre_msg_icon_url", ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0)).wxE);
                                }
                                intent2.putExtra("share_report_pre_msg_appid", "");
                                intent2.putExtra("share_report_from_scene", 1);
                            }
                            if (!(com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.wQn == null)) {
                                intent2.putExtra("KAppId", com_tencent_mm_protocal_c_bnp.wQn.nGJ);
                            }
                            if (Lm != null && Lm.xl(32)) {
                                com.tencent.mm.plugin.sns.storage.a bxT = Lm.bxT();
                                if (bxT != null) {
                                    intent2.putExtra("KsnsViewId", bxT.iTh);
                                }
                            }
                            if (!(Lm == null || com_tencent_mm_protocal_c_bnp == null)) {
                                com.tencent.mm.modelsns.b iu;
                                if (this.rMH.scene == 0) {
                                    iu = com.tencent.mm.modelsns.b.iu(718);
                                } else {
                                    iu = com.tencent.mm.modelsns.b.iv(718);
                                }
                                iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(com_tencent_mm_protocal_c_bnp.wQp).mB(com_tencent_mm_protocal_c_bnp.wQn == null ? "" : com_tencent_mm_protocal_c_bnp.wQn.nGJ).mB(com_tencent_mm_protocal_c_bnp.wQo.nfX);
                                iu.Sx();
                                if (this.rMH.scene == 0) {
                                    iu = com.tencent.mm.modelsns.b.iu(743);
                                } else {
                                    iu = com.tencent.mm.modelsns.b.iv(743);
                                }
                                com.tencent.mm.modelsns.b mB = iu.mB(i.g(Lm)).ix(Lm.field_type).bU(Lm.xl(32)).mB(Lm.byA()).mB(com_tencent_mm_protocal_c_bnp.wQp);
                                if (com_tencent_mm_protocal_c_bnp.wQn == null) {
                                    str2 = "";
                                } else {
                                    str2 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
                                }
                                mB.mB(str2).mB(com_tencent_mm_protocal_c_bnp.wQo.nfX);
                                if (bundle != null) {
                                    str2 = "intent_key_StatisticsOplog";
                                    r0 = iu.KB();
                                    if (r0 != null) {
                                        bundle.putByteArray(str2, r0);
                                    }
                                }
                            }
                            if (bundle != null) {
                                intent2.putExtra("jsapiargs", bundle);
                            }
                            intent2.putExtra("geta8key_scene", 2);
                            intent2.putExtra("from_scence", 3);
                            if (bh.ov(com_tencent_mm_protocal_c_bnp.rLO) || !e.Lg(com_tencent_mm_protocal_c_bnp.rLO)) {
                                com.tencent.mm.plugin.sns.c.a.ifs.j(intent2, this.rMH.context);
                                str2 = null;
                                int i = 0;
                                if (!(com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.wQn == null)) {
                                    str2 = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
                                    i = bh.getInt(com_tencent_mm_protocal_c_bnp.wQn.ktA, 0);
                                }
                                A = com.tencent.mm.plugin.sns.c.a.ift.s(str2, i);
                                if (!bh.ov(A) && com.tencent.mm.plugin.sns.c.a.ift.cA(str2)) {
                                    String str3 = null;
                                    if (!(com_tencent_mm_protocal_c_bnp == null || com_tencent_mm_protocal_c_bnp.qYu == null || com_tencent_mm_protocal_c_bnp.qYu.vFI == null)) {
                                        str3 = com_tencent_mm_protocal_c_bnp.qYu.vFI.vFC;
                                    }
                                    com.tencent.mm.plugin.sns.c.a.ift.a(this.rMH.context, str2, A, com_tencent_mm_protocal_c_bnp == null ? null : com_tencent_mm_protocal_c_bnp.ksU, 5, 4, 1, str3, com_tencent_mm_protocal_c_bnp.nGJ);
                                }
                                g.pQN.h(11105, com_tencent_mm_protocal_c_bnp.ksU, com_tencent_mm_protocal_c_bnp.wQo.nfX);
                                if (Lm != null && Lm.field_type == 4) {
                                    com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                                    g gVar = g.pQN;
                                    Object[] objArr = new Object[3];
                                    objArr[0] = Integer.valueOf(1);
                                    objArr[1] = com_tencent_mm_protocal_c_aqr == null ? "" : com_tencent_mm_protocal_c_aqr.nfe;
                                    objArr[2] = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
                                    gVar.h(13043, objArr);
                                    return;
                                }
                                return;
                            }
                            int[] iArr = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                            }
                            int width = view.getWidth();
                            int height = view.getHeight();
                            intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            if (com_tencent_mm_protocal_c_bnp != null) {
                                List list = com_tencent_mm_protocal_c_bnp.wQo.vYd;
                                if (list.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                                }
                            }
                            intent.putExtra("sns_landing_pages_share_sns_id", Lm.bxW());
                            intent.putExtra("sns_landing_pages_rawSnsId", Lm.bxV().nGJ);
                            intent.putExtra("sns_landing_pages_aid", Lm.byv());
                            intent.putExtra("sns_landing_pages_traceid", Lm.byw());
                            intent.putExtra("sns_landing_pages_ux_info", Lm.byA());
                            intent.putExtra("sns_landig_pages_from_source", this.rMH.scene == 0 ? 3 : 4);
                            intent.setClass(this.rMH.context, SnsAdNativeLandingPagesUI.class);
                            intent.putExtra("sns_landing_pages_xml", com_tencent_mm_protocal_c_bnp.rLO);
                            intent.putExtra("sns_landing_pages_rec_src", Lm.byC());
                            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                            e.z(intent, this.rMH.context);
                        }
                    } else {
                        bg bgVar = this.rMH;
                        bzu com_tencent_mm_protocal_c_bzu = com_tencent_mm_protocal_c_bnp.qYw;
                        if (com_tencent_mm_protocal_c_bzu != null && !bh.ov(com_tencent_mm_protocal_c_bzu.tnm)) {
                            intent = new Intent();
                            intent.putExtra("key_proxy_fts_rec_ui", true);
                            intent.putExtra("key_scene", 3);
                            r0 = null;
                            try {
                                r0 = com_tencent_mm_protocal_c_bzu.toByteArray();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.TimeLineClickEvent", e, "", new Object[0]);
                            }
                            if (r0 != null) {
                                com.tencent.mm.ui.e.i.xEq = true;
                                intent.putExtra("key_search_web_data", r0);
                                d.b(bgVar.context, "webview", ".fts.topstory.ui.TopStoryVideoListUI", intent);
                            }
                        }
                    }
                }
            }
        }
    };
    public OnClickListener rMA = new 15(this);
    public OnClickListener rMB = new OnClickListener(this) {
        final /* synthetic */ bg rMH;

        {
            this.rMH = r1;
        }

        public final void onClick(View view) {
            boolean z = view.getTag() instanceof r;
            x.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click " + z);
            if (z) {
                r rVar = (r) view.getTag();
                bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
                if (bg.IF(com_tencent_mm_protocal_c_bnp.nGJ)) {
                    g.pQN.k(10231, "1");
                    com.tencent.mm.av.b.Qo();
                } else if (!(com.tencent.mm.p.a.aW(this.rMH.context) || com.tencent.mm.p.a.aU(this.rMH.context))) {
                    g.pQN.k(10090, "1,0");
                    if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                        com.tencent.mm.modelsns.b iu;
                        String str;
                        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                        if (this.rMH.scene == 0) {
                            iu = com.tencent.mm.modelsns.b.iu(738);
                        } else {
                            iu = com.tencent.mm.modelsns.b.iv(738);
                        }
                        com.tencent.mm.modelsns.b mB = iu.mB(com_tencent_mm_protocal_c_bnp.nGJ).mB(com_tencent_mm_protocal_c_bnp.ksU);
                        if (com_tencent_mm_protocal_c_bnp.wQn == null) {
                            str = "";
                        } else {
                            str = com_tencent_mm_protocal_c_bnp.wQn.nGJ;
                        }
                        mB.mB(str).mB(com_tencent_mm_protocal_c_aqr.fon).mB(com_tencent_mm_protocal_c_aqr.nfe).mB("");
                        iu.Sx();
                    }
                    if (rVar.rsr) {
                        com.tencent.mm.av.b.a(((com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class)).a(ae.FC(), com_tencent_mm_protocal_c_bnp, 9));
                    } else {
                        com.tencent.mm.av.b.b(((com.tencent.mm.av.a.a) com.tencent.mm.kernel.g.h(com.tencent.mm.av.a.a.class)).a(ae.FC(), com_tencent_mm_protocal_c_bnp, 1));
                    }
                }
                if (this.rMH.rMr != null) {
                    this.rMH.rMr.bAG();
                }
            }
        }
    };
    public OnClickListener rMC = new 3(this);
    public OnClickListener rMD = new OnClickListener(this) {
        final /* synthetic */ bg rMH;

        {
            this.rMH = r1;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (view.getTag() instanceof bnp) {
                bnp com_tencent_mm_protocal_c_bnp = (bnp) view.getTag();
                if (com_tencent_mm_protocal_c_bnp.wQu == null) {
                    x.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                    return;
                }
                String str = com_tencent_mm_protocal_c_bnp.wQu.username;
                com.tencent.mm.sdk.b.b qpVar = new qp();
                x.i("MicroMsg.TimeLineClickEvent", "username: " + str);
                qpVar.fIi.userName = str;
                qpVar.fIi.scene = HardCoderJNI.FUNC_RESET_SCREEN_RESOLUTION;
                qpVar.fIi.fnp = com_tencent_mm_protocal_c_bnp.nGJ + ":" + com_tencent_mm_protocal_c_bnp.ksU;
                com.tencent.mm.sdk.b.a.xef.m(qpVar);
            }
        }
    };
    public OnClickListener rME = new OnClickListener(this) {
        final /* synthetic */ bg rMH;

        {
            this.rMH = r1;
        }

        public final void onClick(View view) {
            x.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (view.getTag() instanceof r) {
                r rVar = (r) view.getTag();
                bnp com_tencent_mm_protocal_c_bnp = rVar.rsq;
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    m Lm = ae.bvv().Lm(rVar.frH);
                    if (this.rMH.rrV != null) {
                        this.rMH.rrV.bva().v(Lm);
                    }
                    String str = ((aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0)).rsn;
                    Intent intent = new Intent();
                    intent.putExtra("key_product_scene", 2);
                    intent.putExtra("key_product_info", str);
                    d.b(this.rMH.context, "product", ".ui.MallProductUI", intent);
                }
            }
        }
    };
    public OnClickListener rMF = new 6(this);
    public OnClickListener rMG = new 7(this);
    a rMr;
    long rMs = 0;
    public OnClickListener rMt = new 8(this);
    public OnClickListener rMu = new 9(this);
    public OnClickListener rMv = new 10(this);
    public OnClickListener rMw = new 11(this);
    public OnClickListener rMx = new 12(this);
    public OnClickListener rMy = new 13(this);
    public OnClickListener rMz = new 14(this);
    ad rrV;
    int scene = 0;
    r tipDialog;

    public bg(Context context, a aVar, int i, ad adVar) {
        this.context = context;
        this.rMr = aVar;
        this.scene = i;
        this.rrV = adVar;
    }

    protected static boolean IF(String str) {
        com.tencent.mm.sdk.b.b jrVar = new jr();
        jrVar.fAt.action = -2;
        com.tencent.mm.sdk.b.a.xef.m(jrVar);
        asv com_tencent_mm_protocal_c_asv = jrVar.fAu.fAv;
        if (com_tencent_mm_protocal_c_asv != null && com.tencent.mm.av.b.d(com_tencent_mm_protocal_c_asv) && str.equals(com_tencent_mm_protocal_c_asv.vVZ) && com.tencent.mm.av.b.Qq()) {
            return true;
        }
        return false;
    }
}
