package com.tencent.mm.plugin.sns.ui.b;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.dh;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.as;
import com.tencent.mm.plugin.sns.ui.av$a;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMImageView;
import java.util.List;

public abstract class b {
    Activity activity;
    private ClipboardManager mxl;
    public OnClickListener rPA;
    public OnClickListener rPB;
    public c rPC;
    public c rPD;
    public c rPE;
    public c rPF;
    public c rPG;
    public c rPH;
    c rPI;
    public OnTouchListener rPJ;
    public OnClickListener rPK;
    public OnClickListener rPL;
    public OnClickListener rPM;
    public OnClickListener rPN;
    public OnClickListener rPO;
    public OnClickListener rPP;
    public OnClickListener rPQ;
    public OnItemClickListener rPR;
    public OnClickListener rPS = new 1(this);
    public OnClickListener rPT = new 12(this);
    public OnClickListener rPU;
    public av$a rPV;
    int rPW;
    public OnClickListener rPX = new OnClickListener(this) {
        final /* synthetic */ b rPY;

        {
            this.rPY = r1;
        }

        public final void onClick(View view) {
            TagImageView tagImageView;
            m mVar;
            MMImageView mMImageView;
            Object tag = view.getTag();
            if (tag instanceof c) {
                c cVar = (c) view.getTag();
                m Ll = h.Ll(cVar.fzW);
                tagImageView = cVar.rNR;
                mVar = Ll;
                mMImageView = null;
            } else if (tag instanceof m) {
                tagImageView = null;
                mVar = (m) tag;
                mMImageView = (MMImageView) view.getTag(f.qCJ);
            } else {
                mVar = null;
                tagImageView = null;
                mMImageView = null;
            }
            if (mVar != null) {
                String w;
                k cVar2;
                boolean z;
                e byB = mVar.byB();
                int source = byB.getSource();
                if (mVar != null && mVar.xl(32)) {
                    a bxT = mVar.bxT();
                    if (mVar.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(mVar.byB().field_adxml)) {
                        w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                        if (!bh.ov(w)) {
                            byB.field_adxml = w;
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (tagImageView != null) {
                            tagImageView.getLocationInWindow(iArr);
                            width = tagImageView.getWidth();
                            height = tagImageView.getHeight();
                        } else if (mMImageView != null) {
                            mMImageView.getLocationInWindow(iArr);
                            width = mMImageView.getWidth();
                            height = mMImageView.getHeight();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
                        intent.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
                        intent.putExtra("sns_landing_pages_ux_info", mVar.byA());
                        bnp bxV = mVar.bxV();
                        if (bxV != null) {
                            List list = bxV.wQo.vYd;
                            if (list.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                            }
                        }
                        intent.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                        intent.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 1 : 2);
                        intent.putExtra("sns_landing_pages_xml", mVar.byB().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", mVar.byC());
                        intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        this.rPY.activity.startActivity(intent);
                        this.rPY.activity.overridePendingTransition(0, 0);
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), 23, this.rPY.scene == 0 ? 1 : 2, "", 3, 21, source, mVar.bxV().rtA, mVar.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar2, 0);
                        return;
                    } else if (bxT != null && bxT.rdM == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", bxT.rdO);
                        intent2.putExtra("key_card_ext", bxT.rdP);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        d.b(this.rPY.activity, "card", ".ui.CardDetailUI", intent2);
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), 23, this.rPY.scene == 0 ? 1 : 2, "", 3, 11, source, mVar.bxV().rtA, mVar.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar2, 0);
                        return;
                    } else if (b.a(this.rPY, bxT, mVar, false)) {
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), 23, this.rPY.scene == 0 ? 1 : 2, "", mVar.byD(), 31, source, mVar.bxV().rtA, mVar.bxW());
                        g.Dk();
                        g.Di().gPJ.a(cVar2, 0);
                        return;
                    }
                }
                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), 23, this.rPY.scene == 0 ? 1 : 2, "", 3, 0, source, mVar.bxV().rtA, mVar.bxW());
                g.Dk();
                g.Di().gPJ.a(cVar2, 0);
                w = mVar.byy();
                if (bh.ov(w)) {
                    w = mVar.byx();
                }
                x.i("MicroMsg.TimelineClickListener", "adlink url " + w + " " + mVar.bxR().rew);
                Intent intent3 = new Intent();
                boolean z2 = mVar.bxR().rew == 0;
                if (r.idC) {
                    z = false;
                } else {
                    z = z2;
                }
                Parcelable snsAdClick = new SnsAdClick(mVar.byz(), this.rPY.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.byA(), 3, (byte) 0);
                snsAdClick.hOw = mVar.bxV().nGJ;
                if (mVar != null && mVar.xl(32)) {
                    a bxT2 = mVar.bxT();
                    if (bxT2 != null) {
                        intent3.putExtra("KsnsViewId", bxT2.iTh);
                    }
                }
                intent3.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                bundle.putString("key_snsad_statextstr", byB.bxV().rtA);
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", w);
                intent3.putExtra("useJs", true);
                intent3.putExtra("srcUsername", mVar.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + i.eq(mVar.field_snsId));
                intent3.putExtra("pre_username", mVar.field_userName);
                intent3.putExtra("prePublishId", "sns_" + i.eq(mVar.field_snsId));
                intent3.putExtra("preUsername", mVar.field_userName);
                com.tencent.mm.plugin.sns.c.a.ifs.j(intent3, this.rPY.activity);
            }
        }
    };
    public com.tencent.mm.plugin.sight.decode.a.b.e rPj;
    public a rPp;
    public OnClickListener rPq;
    public OnLongClickListener rPr;
    public c rPs;
    public OnClickListener rPt;
    public OnClickListener rPu;
    public OnClickListener rPv;
    public OnClickListener rPw;
    public OnClickListener rPx;
    public OnClickListener rPy;
    public OnClickListener rPz;
    ad rrV;
    public OnClickListener rtw;
    int scene = 0;

    public abstract void b(View view, int i, int i2, int i3);

    public abstract void bL(Object obj);

    public abstract void bzg();

    public abstract void bzh();

    public abstract void cB(View view);

    public abstract void cC(View view);

    public abstract void cD(View view);

    public abstract void cE(View view);

    public abstract void cF(View view);

    public abstract void cG(View view);

    static /* synthetic */ void a(b bVar, View view, m mVar, int i, String str, boolean z) {
        ak akVar = null;
        if (view.getTag() instanceof ak) {
            akVar = (ak) view.getTag();
        }
        if (view.getTag() instanceof c) {
            c cVar = (c) view.getTag();
            if (cVar.rOF.rxh.getTag() instanceof ak) {
                ak akVar2 = (ak) cVar.rOF.rxh.getTag();
                c cVar2 = cVar;
            } else {
                return;
            }
        }
        cVar2 = null;
        akVar2 = akVar;
        if (mVar != null && akVar2 != null) {
            if (bVar.rrV != null) {
                bVar.rrV.bva().v(mVar);
            }
            boolean xl = mVar.xl(32);
            bnp com_tencent_mm_protocal_c_bnp = akVar2.rxf;
            if (com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() == 0) {
                x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
            if (xl) {
                ae.bvs();
                if (!com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_aqr)) {
                    akVar2.rkR.setVisibility(8);
                    akVar2.rxi.setVisibility(0);
                    akVar2.rxi.cyN();
                    ae.bvs().z(com_tencent_mm_protocal_c_aqr);
                    com.tencent.mm.plugin.sns.model.b bvq = ae.bvq();
                    an ciT = an.ciT();
                    ciT.time = com_tencent_mm_protocal_c_bnp.pbl;
                    bvq.a(com_tencent_mm_protocal_c_aqr, 4, null, ciT);
                    return;
                }
            }
            Object obj = (mVar.xl(32) && mVar.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(str)) ? 1 : null;
            if (obj == null && xl && ae.bvs().u(com_tencent_mm_protocal_c_aqr)) {
                ae.bvs().z(com_tencent_mm_protocal_c_aqr);
                akVar2.rkR.setVisibility(8);
                akVar2.rxi.setVisibility(8);
                com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
                com.tencent.mm.plugin.sight.decode.a.a aVar = akVar2.qvN;
                int hashCode = bVar.activity.hashCode();
                int i2 = akVar2.position;
                an ciT2 = an.ciT();
                ciT2.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.a(mVar, com_tencent_mm_protocal_c_aqr, aVar, hashCode, i2, ciT2, xl);
                return;
            }
            int height;
            int i3;
            int[] iArr = new int[2];
            int width;
            if (cVar2 != null) {
                if (cVar2.rOF.rxh != null) {
                    cVar2.rOF.rxh.getLocationInWindow(iArr);
                }
                width = cVar2.rOF.rxh.getWidth();
                height = cVar2.rOF.rxh.getHeight();
                i3 = width;
            } else if (view.getTag() instanceof ak) {
                int height2;
                akVar = (ak) view.getTag();
                if (akVar != null) {
                    akVar.rxh.getLocationInWindow(iArr);
                    width = akVar.rxh.getWidth();
                    height2 = akVar.rxh.getHeight();
                } else {
                    height2 = 0;
                    width = 0;
                }
                height = height2;
                i3 = width;
            } else if (view != null) {
                view.getLocationInWindow(iArr);
                width = view.getWidth();
                height = view.getHeight();
                i3 = width;
            } else {
                height = 0;
                i3 = 0;
            }
            if (mVar.xl(32) && mVar.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(str)) {
                String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
                if (!bh.ov(w)) {
                    mVar.byB().field_adxml = w;
                }
                g.Di().gPJ.a(new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), i, bVar.scene == 0 ? 1 : 2, "", mVar.byD(), z ? 22 : 21, mVar.byB() != null ? mVar.byB().getSource() : 0, mVar.bxV().rtA, mVar.bxW()), 0);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i3);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
                intent.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
                intent.putExtra("sns_landing_pages_ux_info", mVar.byA());
                bnp bxV = mVar.bxV();
                if (bxV != null) {
                    List list = bxV.wQo.vYd;
                    if (list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                    }
                }
                intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
                intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", mVar.byC());
                intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                bVar.activity.startActivity(intent);
                bVar.activity.overridePendingTransition(0, 0);
                return;
            }
            x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
        }
    }

    static /* synthetic */ void a(b bVar, bnp com_tencent_mm_protocal_c_bnp) {
        if (com_tencent_mm_protocal_c_bnp != null && com_tencent_mm_protocal_c_bnp.qYu != null && com_tencent_mm_protocal_c_bnp.qYu.vFI != null && com.tencent.mm.pluginsdk.model.app.g.cA(com_tencent_mm_protocal_c_bnp.qYu.vFI.ngo)) {
            at atVar = com_tencent_mm_protocal_c_bnp.qYu;
            com.tencent.mm.plugin.sns.c.a.ift.a(bVar.activity, atVar.vFI.ngo, com.tencent.mm.plugin.sns.c.a.ift.cy(atVar.vFI.ngo), com_tencent_mm_protocal_c_bnp.ksU, 38, 19, 10, atVar.vFI.vFC, com_tencent_mm_protocal_c_bnp.nGJ);
        }
    }

    static /* synthetic */ boolean a(b bVar, a aVar, m mVar, boolean z) {
        if (aVar != null) {
            String str = "";
            String str2 = "";
            String str3 = "";
            if (z && mVar.bxR().rfl.fvL != null) {
                str = mVar.bxR().rfl.fvL;
                str2 = mVar.bxR().rfl.fnq;
                str3 = mVar.bxR().rfl.bpe;
            } else if (!(z || aVar.rdM != 4 || aVar.ree == null)) {
                str = aVar.ree.fvL;
                str2 = aVar.ree.fnq;
                str3 = aVar.ree.bpe;
            }
            if (!bh.ov(str)) {
                com.tencent.mm.sdk.b.b qpVar = new qp();
                qpVar.fIi.fnp = i.eq(mVar.field_snsId) + ":" + aVar.qZM + ":" + ae.bvb() + ":" + System.currentTimeMillis();
                qpVar.fIi.userName = str;
                qpVar.fIi.fIm = bh.VI(str3);
                qpVar.fIi.fIk = str2;
                qpVar.fIi.scene = bVar.scene == 0 ? 1045 : 1046;
                com.tencent.mm.sdk.b.a.xef.m(qpVar);
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(b bVar, View view, m mVar, int i, String str, boolean z) {
        if (view.getTag() instanceof c) {
            view = ((c) view.getTag()).rOg.xy(0);
        } else if (view.getTag() instanceof MaskImageView) {
            view = (MaskImageView) view.getTag();
        } else {
            TagImageView tagImageView = (TagImageView) view;
        }
        if (!(view.getTag() instanceof ap)) {
            return;
        }
        if (mVar.bxR().bwt() && com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.Lg(str)) {
            g.Di().gPJ.a(new com.tencent.mm.plugin.sns.a.b.c(mVar.byz(), i, bVar.scene == 0 ? 1 : 2, "", mVar.byD(), z ? 22 : 21, mVar.byB() != null ? mVar.byB().getSource() : 0, mVar.bxV().rtA, mVar.bxW()), 0);
            String w = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.w(mVar);
            if (!bh.ov(w)) {
                mVar.byB().field_adxml = w;
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            int width = view.getWidth();
            int height = view.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
            intent.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
            intent.putExtra("sns_landing_pages_ux_info", mVar.byA());
            intent.putExtra("sns_landing_pages_aid", mVar.byv());
            intent.putExtra("sns_landing_pages_traceid", mVar.byw());
            bnp bxV = mVar.bxV();
            if (bxV != null) {
                List list = bxV.wQo.vYd;
                if (list.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                }
            }
            intent.setClass(bVar.activity, SnsAdNativeLandingPagesUI.class);
            intent.putExtra("sns_landig_pages_from_source", bVar.scene == 0 ? 1 : 2);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", mVar.byC());
            intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            bVar.activity.startActivity(intent);
            bVar.activity.overridePendingTransition(0, 0);
            if (bVar.rrV != null) {
                bVar.rrV.bva().v(mVar);
                return;
            }
            return;
        }
        x.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
    }

    static /* synthetic */ m cK(View view) {
        if (view.getTag() instanceof ap) {
            return h.Lm(((ap) view.getTag()).fus);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            return maskImageView.getTag() instanceof ap ? h.Lm(((ap) maskImageView.getTag()).fus) : null;
        } else if (!(view.getTag() instanceof ak)) {
            return h.Ll(((c) view.getTag()).fzW);
        } else {
            return ae.bvv().Lm(((ak) view.getTag()).frH);
        }
    }

    public b(int i, Activity activity, ad adVar) {
        this.scene = i;
        this.activity = activity;
        this.rrV = adVar;
        this.rPW = bh.getInt(com.tencent.mm.k.g.zY().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        x.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", new Object[]{Integer.valueOf(this.rPW)});
        this.mxl = (ClipboardManager) this.activity.getSystemService("clipboard");
        this.rPp = new a(this.activity, this.scene, this.rrV);
        this.rPz = new 23(this);
        this.rPL = new 29(this);
        this.rPP = new 30(this);
        this.rPQ = new 31(this);
        this.rPq = new 32(this);
        this.rPr = new 33(this);
        this.rPs = new 34(this);
        this.rPG = new c(this) {
            final /* synthetic */ b rPY;

            {
                this.rPY = r1;
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof c) && !(view.getTag() instanceof m) && !(view.getTag() instanceof ak) && !(view.getTag() instanceof ap)) {
                    return false;
                }
                m Ll;
                Object tag = view.getTag();
                if (tag instanceof c) {
                    Ll = h.Ll(((c) view.getTag()).fzW);
                } else if (tag instanceof m) {
                    Ll = (m) tag;
                } else if (tag instanceof ak) {
                    Ll = ae.bvv().Lm(((ak) tag).frH);
                } else if (view.getTag() instanceof ap) {
                    Ll = ae.bvv().Lm(((ap) view.getTag()).fus);
                } else {
                    Ll = null;
                }
                if (Ll != null) {
                    if (!Ll.xl(32)) {
                        return false;
                    }
                    if (Ll.bxR() == null || Ll.bxR().rfi != 1) {
                        return false;
                    }
                    this.rPY.rPp.a(view, Ll.byq(), Ll.bxV());
                }
                return true;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                Object tag = view.getTag();
                if ((tag instanceof c) || (tag instanceof m) || (tag instanceof ak) || (tag instanceof ap)) {
                    m Ll;
                    if (tag instanceof c) {
                        Ll = h.Ll(((c) tag).fzW);
                    } else if (tag instanceof m) {
                        Ll = (m) tag;
                    } else if (tag instanceof ak) {
                        Ll = ae.bvv().Lm(((ak) tag).frH);
                    } else if (view.getTag() instanceof ap) {
                        Ll = ae.bvv().Lm(((ap) view.getTag()).fus);
                    } else {
                        Ll = null;
                    }
                    if (Ll.xl(32) && Ll.bxR() != null && Ll.bxR().rfi == 1 && Ll.bxT().ree == null) {
                        if (d.OQ("favorite")) {
                            com.tencent.mm.plugin.sns.storage.b bxR = Ll.bxR();
                            Ll.bxT();
                            if (bxR.bwy()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(j.eAd));
                            }
                            com.tencent.mm.sdk.b.b dhVar = new dh();
                            dhVar.frQ.frH = Ll.byq();
                            com.tencent.mm.sdk.b.a.xef.m(dhVar);
                            if (dhVar.frR.frp) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(j.qJu));
                            }
                        }
                        if (Ll != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, Ll);
                        }
                    }
                }
            }
        };
        this.rPH = new 3(this);
        this.rPE = new c(this) {
            final /* synthetic */ b rPY;

            {
                this.rPY = r1;
            }

            public final void a(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.r) {
                    this.rPY.rPI.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
            }

            public final boolean cL(View view) {
                if (!(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.r)) {
                    return false;
                }
                String str = ((com.tencent.mm.plugin.sns.ui.r) view.getTag()).frH;
                this.rPY.rPp.a(view, str, ae.bvv().Lm(str).bxV());
                return true;
            }
        };
        this.rPD = new 5(this);
        this.rtw = new 6(this);
        this.rPt = new 7(this);
        this.rPu = new 8(this);
        this.rPB = new 9(this);
        this.rPv = new 10(this);
        this.rPw = new 11(this);
        this.rPx = new 13(this);
        this.rPy = new 14(this);
        this.rPC = new 15(this);
        this.rPJ = new 16(this);
        this.rPK = new OnClickListener(this) {
            final /* synthetic */ b rPY;

            {
                this.rPY = r1;
            }

            public final void onClick(View view) {
                if (view.getTag() instanceof as) {
                    m Ll = ae.bvv().Ll(((as) view.getTag()).fzW);
                    if (Ll != null) {
                        Intent intent = new Intent();
                        intent.putExtra("sns_text_show", Ll.bxV().wQl);
                        intent.putExtra("sns_local_id", Ll.byq());
                        intent.setClass(this.rPY.activity, SnsSingleTextViewUI.class);
                        this.rPY.activity.startActivity(intent);
                    }
                }
            }
        };
        this.rPN = new 18(this);
        this.rPM = new 19(this);
        this.rPF = new 20(this);
        this.rPO = new 21(this);
        this.rPA = new 22(this);
        this.rPR = new 24(this);
        this.rPU = new 25(this);
        this.rPI = new 26(this);
        this.rPj = new 27(this);
    }

    public final void aUG() {
        com.tencent.mm.ae.e eVar = this.rPp;
        g.Dk();
        g.Di().gPJ.a(218, eVar);
    }

    public final void aBM() {
        com.tencent.mm.ae.e eVar = this.rPp;
        g.Dk();
        g.Di().gPJ.b(218, eVar);
    }
}
