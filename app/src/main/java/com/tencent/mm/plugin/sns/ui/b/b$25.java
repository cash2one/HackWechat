package com.tencent.mm.plugin.sns.ui.b;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mm.ae.k;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j$a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e;
import com.tencent.mm.plugin.sns.storage.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.u;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.List;

class b$25 implements OnClickListener {
    final /* synthetic */ b rPY;

    b$25(b bVar) {
        this.rPY = bVar;
    }

    public final void onClick(View view) {
        if (view.getTag() == null) {
            return;
        }
        if ((view.getTag() instanceof c) || (view.getTag() instanceof ap) || (view.getTag() instanceof ak) || (view.getTag() instanceof MaskImageView)) {
            Object obj;
            int i;
            int i2;
            int i3;
            int i4;
            Object obj2;
            m mVar;
            MaskImageView maskImageView;
            c cVar;
            Object obj3 = null;
            int i5 = 0;
            m Lm;
            Object obj4;
            int i6;
            if (view.getTag() instanceof ap) {
                Lm = h.Lm(((ap) view.getTag()).fus);
                if (view instanceof LinearLayout) {
                    obj4 = null;
                } else {
                    i6 = 1;
                }
                if (((ap) view.getTag()).rxk) {
                    obj = 1;
                    i = ((ap) view.getTag()).index;
                    if (i > 0) {
                        i2 = 2;
                    } else {
                        i2 = 1;
                    }
                } else {
                    i2 = 0;
                    i = 0;
                    obj = null;
                }
                i3 = i2;
                i4 = i;
                obj2 = obj;
                obj = obj4;
                mVar = Lm;
            } else if (view.getTag() instanceof MaskImageView) {
                Object obj5;
                maskImageView = (MaskImageView) view.getTag();
                if (maskImageView.getTag() instanceof ap) {
                    mVar = h.Lm(((ap) maskImageView.getTag()).fus);
                    if (view instanceof LinearLayout) {
                        i3 = 0;
                        i4 = 0;
                        obj2 = null;
                        obj = null;
                    } else {
                        obj5 = 1;
                    }
                } else {
                    obj5 = null;
                    mVar = null;
                }
                i3 = 0;
                i4 = 0;
                obj2 = null;
                obj = obj5;
            } else if (view.getTag() instanceof ak) {
                Lm = ae.bvv().Lm(((ak) view.getTag()).frH);
                if (view instanceof LinearLayout) {
                    obj4 = null;
                } else {
                    i6 = 1;
                }
                if (((ak) view.getTag()).rxk) {
                    obj3 = 1;
                    i5 = ((ak) view.getTag()).rxl;
                    i2 = i5 > 0 ? 2 : 1;
                } else {
                    i2 = 0;
                }
                i3 = i2;
                i4 = i5;
                obj2 = obj3;
                obj = obj4;
                mVar = Lm;
            } else {
                cVar = (c) view.getTag();
                Lm = h.Ll(cVar.fzW);
                if (cVar.rOI != null) {
                    i5 = cVar.rOI.index;
                    i3 = i5 > 0 ? 2 : 1;
                    i4 = i5;
                    int i7 = 1;
                    obj = null;
                    mVar = Lm;
                } else {
                    i3 = 0;
                    i4 = 0;
                    obj2 = null;
                    obj = null;
                    mVar = Lm;
                }
            }
            if (mVar != null && mVar.xl(32)) {
                String str;
                String bww;
                String Ch;
                try {
                    Object obj6;
                    a bxT = mVar.bxT();
                    if (bxT == null) {
                        obj6 = "";
                    } else {
                        str = bxT.iTh;
                    }
                    String str2 = mVar.bxV().nGJ;
                    if (!mVar.bwE()) {
                        g gVar = g.pQN;
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(this.rPY.scene == 0 ? 1 : 2);
                        objArr[1] = Integer.valueOf(obj != null ? 1 : 2);
                        objArr[2] = str2;
                        objArr[3] = obj6;
                        gVar.h(14066, objArr);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.TimelineClickListener", "report click ad card style error " + e.getMessage());
                }
                if (mVar.byB().bxR().bwA()) {
                    bww = mVar.byB().bxR().bww();
                    str = mVar.byA();
                    com.tencent.mm.kernel.g.Dh();
                    Ch = com.tencent.mm.kernel.a.Ch();
                    u.f(bww, str, Ch, u.Y(bww, str, Ch), 0);
                }
                bnp bxV = mVar.bxV();
                int i8;
                String str3;
                int i9;
                k cVar2;
                bnp bxV2;
                List list;
                Intent intent;
                boolean z;
                Parcelable snsAdClick;
                a bxT2;
                Bundle bundle;
                if ((bxV.wQo.vYc == 15 && bxV.wQv != 1) || (bxV.wQo.vYc == 27 && bxV.wQo.vYd.size() > i4 && ((aqr) bxV.wQo.vYd.get(i4)).ktN == 6)) {
                    ak akVar;
                    c cVar3;
                    ak akVar2;
                    x.i("MicroMsg.TimelineClickListener", "onsight click");
                    if (view.getTag() instanceof ak) {
                        akVar = (ak) view.getTag();
                    } else {
                        akVar = null;
                    }
                    if (view.getTag() instanceof c) {
                        cVar = (c) view.getTag();
                        if (bxV.wQo.vYc == 27) {
                            akVar = cVar.rOJ;
                        } else if (cVar.rOF.rxh != null && (cVar.rOF.rxh.getTag() instanceof ak)) {
                            akVar = (ak) cVar.rOF.rxh.getTag();
                        }
                        if (akVar != null) {
                            cVar3 = cVar;
                            akVar2 = akVar;
                        } else {
                            return;
                        }
                    }
                    cVar3 = null;
                    akVar2 = akVar;
                    if (mVar != null) {
                        if (this.rPY.rrV != null) {
                            this.rPY.rrV.bva().v(mVar);
                        }
                        boolean xl = mVar.xl(32);
                        bnp com_tencent_mm_protocal_c_bnp = akVar2.rxf;
                        if (com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() == 0) {
                            x.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                            return;
                        }
                        b iu;
                        String j;
                        int[] iArr;
                        int i10;
                        ak akVar3;
                        Intent intent2;
                        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i4);
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
                                if (xl) {
                                    j.a(j.b.qPU, j$a.PlayIcon, mVar);
                                    return;
                                }
                                return;
                            }
                        }
                        if (mVar.xl(32) && mVar.bxR().bwt()) {
                            if (e.el(mVar.byB().field_adxml, i4 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                obj = 1;
                                if (obj != null && xl && ae.bvs().u(com_tencent_mm_protocal_c_aqr)) {
                                    ae.bvs().z(com_tencent_mm_protocal_c_aqr);
                                    akVar2.rkR.setVisibility(8);
                                    akVar2.rxi.setVisibility(8);
                                    com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
                                    com.tencent.mm.plugin.sight.decode.a.a aVar = akVar2.qvN;
                                    int hashCode = this.rPY.activity.hashCode();
                                    i8 = akVar2.position;
                                    an ciT2 = an.ciT();
                                    ciT2.time = com_tencent_mm_protocal_c_bnp.pbl;
                                    bvs.a(mVar, com_tencent_mm_protocal_c_aqr, aVar, hashCode, i8, ciT2, xl);
                                    if (xl) {
                                        j.a(j.b.qPU, j$a.PlayIcon, mVar);
                                        return;
                                    }
                                    return;
                                }
                                if (this.rPY.scene != 0) {
                                    iu = b.iu(717);
                                } else {
                                    iu = b.iv(717);
                                }
                                iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32)).mB(mVar.byA()).mB(com_tencent_mm_protocal_c_aqr.nGJ);
                                iu.Sx();
                                if (this.rPY.scene != 0) {
                                    iu = b.iu(745);
                                } else {
                                    iu = b.iv(745);
                                }
                                iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32));
                                bww = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                                j = i.j(com_tencent_mm_protocal_c_aqr);
                                if (FileOp.bO(bww + j)) {
                                    new StringBuilder().append(bww).append(j);
                                    new StringBuilder().append(bww).append(i.e(com_tencent_mm_protocal_c_aqr));
                                }
                                if (FileOp.bO(bww + i.p(com_tencent_mm_protocal_c_aqr))) {
                                    new StringBuilder().append(bww).append(i.p(com_tencent_mm_protocal_c_aqr));
                                    new StringBuilder().append(bww).append(i.n(com_tencent_mm_protocal_c_aqr));
                                }
                                iArr = new int[2];
                                i2 = 0;
                                if (cVar3 == null) {
                                    if (cVar3.rOF.rxh != null) {
                                        cVar3.rOF.rxh.getLocationInWindow(iArr);
                                        i = cVar3.rOF.rxh.getWidth();
                                        i2 = cVar3.rOF.rxh.getHeight();
                                        i10 = i;
                                    } else if (cVar3.rOG == null) {
                                        cVar3.rOG.getLocationInWindow(iArr);
                                        i = cVar3.rOG.getWidth();
                                        i2 = cVar3.rOG.getHeight();
                                        i10 = i;
                                    } else {
                                        i10 = 0;
                                    }
                                } else if (view.getTag() instanceof ak) {
                                    if (view != null) {
                                        view.getLocationInWindow(iArr);
                                    }
                                    i = view.getWidth();
                                    i2 = view.getHeight();
                                    i10 = i;
                                } else {
                                    akVar3 = (ak) view.getTag();
                                    if (akVar3 != null) {
                                        akVar3.rxh.getLocationInWindow(iArr);
                                    }
                                    i = akVar3.rxh.getWidth();
                                    i2 = akVar3.rxh.getHeight();
                                    i10 = i;
                                }
                                g.pQN.h(11444, new Object[]{Integer.valueOf(3)});
                                if (obj == null) {
                                    Ch = mVar.byz();
                                    i8 = this.rPY.scene != 0 ? 1 : 2;
                                    str3 = "";
                                    if (obj2 == null) {
                                        i9 = 6;
                                    } else {
                                        i9 = 5;
                                    }
                                    if (mVar.byB() != null) {
                                        mVar.byB().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 21, mVar.bxV().rtA, mVar.bxW(), i3);
                                    com.tencent.mm.kernel.g.Dk();
                                    com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                                    intent2 = new Intent();
                                    intent2.putExtra("img_gallery_left", iArr[0]);
                                    intent2.putExtra("img_gallery_top", iArr[1]);
                                    intent2.putExtra("img_gallery_width", i10);
                                    intent2.putExtra("img_gallery_height", i2);
                                    intent2.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
                                    intent2.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
                                    intent2.putExtra("sns_landing_pages_ux_info", mVar.byA());
                                    bxV2 = mVar.bxV();
                                    if (bxV2 != null) {
                                        list = bxV2.wQo.vYd;
                                        if (list.size() > i4) {
                                            intent2.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(i4)).wxE);
                                        }
                                    }
                                    intent2.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                                    intent2.putExtra("sns_landig_pages_from_source", this.rPY.scene != 0 ? 1 : 2);
                                    intent2.putExtra("sns_landing_pages_xml", i4 <= 0 ? mVar.bxR().bwD() : mVar.byB().field_adxml);
                                    intent2.putExtra("sns_landing_pages_rec_src", mVar.byC());
                                    intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                    intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                    intent2.putExtra("sns_landing_is_native_sight_ad", true);
                                    this.rPY.activity.startActivity(intent2);
                                    this.rPY.activity.overridePendingTransition(0, 0);
                                }
                                if (b.a(this.rPY, mVar.bxT(), mVar, i4 <= 0)) {
                                    Ch = mVar.byz();
                                    i8 = this.rPY.scene != 0 ? 1 : 2;
                                    str3 = "";
                                    i9 = obj2 == null ? 6 : 5;
                                    if (mVar.byB() != null) {
                                        mVar.byB().getSource();
                                    }
                                    cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 0, mVar.bxV().rtA, mVar.bxW(), i3);
                                    com.tencent.mm.kernel.g.Dk();
                                    com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                                    bww = i4 <= 0 ? mVar.bxR().rfl.rdQ : mVar.byy();
                                    if (bh.ov(bww)) {
                                        bww = mVar.byx();
                                    }
                                    if (!bh.ov(bww)) {
                                        x.i("MicroMsg.TimelineClickListener", "adlink url " + bww + " " + mVar.bxR().rew);
                                        intent = new Intent();
                                        z = mVar.bxR().rew != 0;
                                        if (r.idC) {
                                            z = false;
                                        }
                                        snsAdClick = new SnsAdClick(mVar.byz(), this.rPY.scene != 0 ? 1 : 2, mVar.field_snsId, mVar.byA(), obj2 == null ? 6 : 5, (byte) 0);
                                        snsAdClick.hOw = mVar.bxV().nGJ;
                                        if (mVar != null && mVar.xl(32)) {
                                            bxT2 = mVar.bxT();
                                            if (bxT2 != null) {
                                                intent.putExtra("KsnsViewId", bxT2.iTh);
                                            }
                                        }
                                        intent.putExtra("KRightBtn", z);
                                        bundle = new Bundle();
                                        bundle.putParcelable("KSnsAdTag", snsAdClick);
                                        bundle.putString("key_snsad_statextstr", mVar.bxV().rtA);
                                        intent.putExtra("jsapiargs", bundle);
                                        intent.putExtra("rawUrl", bww);
                                        intent.putExtra("useJs", true);
                                        intent.putExtra("srcUsername", mVar.field_userName);
                                        intent.putExtra("stastic_scene", 15);
                                        intent.putExtra("KPublisherId", "sns_" + i.eq(mVar.field_snsId));
                                        intent.putExtra("pre_username", mVar.field_userName);
                                        intent.putExtra("prePublishId", "sns_" + i.eq(mVar.field_snsId));
                                        intent.putExtra("preUsername", mVar.field_userName);
                                        com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                                        return;
                                    }
                                    return;
                                }
                                Ch = mVar.byz();
                                i8 = this.rPY.scene != 0 ? 1 : 2;
                                str3 = "";
                                i9 = mVar.byD();
                                if (mVar.byB() != null) {
                                    mVar.byB().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 31, mVar.bxV().rtA, mVar.bxW(), i3);
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                                return;
                            }
                        }
                        obj = null;
                        if (obj != null) {
                        }
                        if (this.rPY.scene != 0) {
                            iu = b.iv(717);
                        } else {
                            iu = b.iu(717);
                        }
                        iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32)).mB(mVar.byA()).mB(com_tencent_mm_protocal_c_aqr.nGJ);
                        iu.Sx();
                        if (this.rPY.scene != 0) {
                            iu = b.iv(745);
                        } else {
                            iu = b.iu(745);
                        }
                        iu.mB(i.g(mVar)).ix(mVar.field_type).bU(mVar.xl(32));
                        bww = am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ);
                        j = i.j(com_tencent_mm_protocal_c_aqr);
                        if (FileOp.bO(bww + j)) {
                            new StringBuilder().append(bww).append(j);
                            new StringBuilder().append(bww).append(i.e(com_tencent_mm_protocal_c_aqr));
                        }
                        if (FileOp.bO(bww + i.p(com_tencent_mm_protocal_c_aqr))) {
                            new StringBuilder().append(bww).append(i.p(com_tencent_mm_protocal_c_aqr));
                            new StringBuilder().append(bww).append(i.n(com_tencent_mm_protocal_c_aqr));
                        }
                        iArr = new int[2];
                        i2 = 0;
                        if (cVar3 == null) {
                            if (view.getTag() instanceof ak) {
                                if (view != null) {
                                    view.getLocationInWindow(iArr);
                                }
                                i = view.getWidth();
                                i2 = view.getHeight();
                                i10 = i;
                            } else {
                                akVar3 = (ak) view.getTag();
                                if (akVar3 != null) {
                                    akVar3.rxh.getLocationInWindow(iArr);
                                }
                                i = akVar3.rxh.getWidth();
                                i2 = akVar3.rxh.getHeight();
                                i10 = i;
                            }
                        } else if (cVar3.rOF.rxh != null) {
                            cVar3.rOF.rxh.getLocationInWindow(iArr);
                            i = cVar3.rOF.rxh.getWidth();
                            i2 = cVar3.rOF.rxh.getHeight();
                            i10 = i;
                        } else if (cVar3.rOG == null) {
                            i10 = 0;
                        } else {
                            cVar3.rOG.getLocationInWindow(iArr);
                            i = cVar3.rOG.getWidth();
                            i2 = cVar3.rOG.getHeight();
                            i10 = i;
                        }
                        g.pQN.h(11444, new Object[]{Integer.valueOf(3)});
                        if (obj == null) {
                            if (i4 <= 0) {
                            }
                            if (b.a(this.rPY, mVar.bxT(), mVar, i4 <= 0)) {
                                Ch = mVar.byz();
                                if (this.rPY.scene != 0) {
                                }
                                str3 = "";
                                if (obj2 == null) {
                                }
                                if (mVar.byB() != null) {
                                    mVar.byB().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 0, mVar.bxV().rtA, mVar.bxW(), i3);
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                                if (i4 <= 0) {
                                }
                                if (bh.ov(bww)) {
                                    bww = mVar.byx();
                                }
                                if (!bh.ov(bww)) {
                                    x.i("MicroMsg.TimelineClickListener", "adlink url " + bww + " " + mVar.bxR().rew);
                                    intent = new Intent();
                                    if (mVar.bxR().rew != 0) {
                                    }
                                    if (r.idC) {
                                        z = false;
                                    }
                                    if (this.rPY.scene != 0) {
                                    }
                                    if (obj2 == null) {
                                    }
                                    snsAdClick = new SnsAdClick(mVar.byz(), this.rPY.scene != 0 ? 1 : 2, mVar.field_snsId, mVar.byA(), obj2 == null ? 6 : 5, (byte) 0);
                                    snsAdClick.hOw = mVar.bxV().nGJ;
                                    bxT2 = mVar.bxT();
                                    if (bxT2 != null) {
                                        intent.putExtra("KsnsViewId", bxT2.iTh);
                                    }
                                    intent.putExtra("KRightBtn", z);
                                    bundle = new Bundle();
                                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                                    bundle.putString("key_snsad_statextstr", mVar.bxV().rtA);
                                    intent.putExtra("jsapiargs", bundle);
                                    intent.putExtra("rawUrl", bww);
                                    intent.putExtra("useJs", true);
                                    intent.putExtra("srcUsername", mVar.field_userName);
                                    intent.putExtra("stastic_scene", 15);
                                    intent.putExtra("KPublisherId", "sns_" + i.eq(mVar.field_snsId));
                                    intent.putExtra("pre_username", mVar.field_userName);
                                    intent.putExtra("prePublishId", "sns_" + i.eq(mVar.field_snsId));
                                    intent.putExtra("preUsername", mVar.field_userName);
                                    com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                                    return;
                                }
                                return;
                            }
                            Ch = mVar.byz();
                            if (this.rPY.scene != 0) {
                            }
                            str3 = "";
                            i9 = mVar.byD();
                            if (mVar.byB() != null) {
                                mVar.byB().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 31, mVar.bxV().rtA, mVar.bxW(), i3);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                            return;
                        }
                        Ch = mVar.byz();
                        if (this.rPY.scene != 0) {
                        }
                        str3 = "";
                        if (obj2 == null) {
                            i9 = 5;
                        } else {
                            i9 = 6;
                        }
                        if (mVar.byB() != null) {
                            mVar.byB().getSource();
                        }
                        cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 21, mVar.bxV().rtA, mVar.bxW(), i3);
                        com.tencent.mm.kernel.g.Dk();
                        com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                        intent2 = new Intent();
                        intent2.putExtra("img_gallery_left", iArr[0]);
                        intent2.putExtra("img_gallery_top", iArr[1]);
                        intent2.putExtra("img_gallery_width", i10);
                        intent2.putExtra("img_gallery_height", i2);
                        intent2.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
                        intent2.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
                        intent2.putExtra("sns_landing_pages_ux_info", mVar.byA());
                        bxV2 = mVar.bxV();
                        if (bxV2 != null) {
                            list = bxV2.wQo.vYd;
                            if (list.size() > i4) {
                                intent2.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(i4)).wxE);
                            }
                        }
                        intent2.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                        if (this.rPY.scene != 0) {
                        }
                        intent2.putExtra("sns_landig_pages_from_source", this.rPY.scene != 0 ? 1 : 2);
                        if (i4 <= 0) {
                        }
                        intent2.putExtra("sns_landing_pages_xml", i4 <= 0 ? mVar.bxR().bwD() : mVar.byB().field_adxml);
                        intent2.putExtra("sns_landing_pages_rec_src", mVar.byC());
                        intent2.putExtra("sns_landing_pages_xml_prefix", "adxml");
                        intent2.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent2.putExtra("sns_landing_is_native_sight_ad", true);
                        this.rPY.activity.startActivity(intent2);
                        this.rPY.activity.overridePendingTransition(0, 0);
                    }
                } else if ((bxV.wQo.vYc == 1 && bxV.wQo.vYd.size() == 1) || bxV.wQo.vYc == 7 || (bxV.wQo.vYc == 27 && bxV.wQo.vYd.size() > i4 && ((aqr) bxV.wQo.vYd.get(i4)).ktN == 2)) {
                    TagImageView tagImageView;
                    if (view.getTag() instanceof c) {
                        cVar = (c) view.getTag();
                        if (bxV.wQo.vYc == 27) {
                            tagImageView = (TagImageView) cVar.rOI.view;
                        } else {
                            tagImageView = cVar.rOg.xy(0);
                        }
                    } else if (view.getTag() instanceof MaskImageView) {
                        maskImageView = (MaskImageView) view.getTag();
                    } else {
                        tagImageView = (TagImageView) view;
                    }
                    if (tagImageView.getTag() instanceof ap) {
                        if (mVar.bxR().bwt()) {
                            if (e.el(mVar.byB().field_adxml, i4 > 0 ? "adTurnCanvasInfo" : "adCanvasInfo")) {
                                Ch = mVar.byz();
                                i8 = this.rPY.scene == 0 ? 1 : 2;
                                str3 = "";
                                if (obj2 != null) {
                                    i9 = 6;
                                } else {
                                    i9 = 4;
                                }
                                if (mVar.byB() != null) {
                                    mVar.byB().getSource();
                                }
                                cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 21, mVar.bxV().rtA, mVar.bxW(), i3);
                                com.tencent.mm.kernel.g.Dk();
                                com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                                int[] iArr2 = new int[2];
                                if (tagImageView != null) {
                                    tagImageView.getLocationInWindow(iArr2);
                                }
                                i5 = tagImageView.getWidth();
                                i2 = tagImageView.getHeight();
                                Intent intent3 = new Intent();
                                intent3.putExtra("img_gallery_left", iArr2[0]);
                                intent3.putExtra("img_gallery_top", iArr2[1]);
                                intent3.putExtra("img_gallery_width", i5);
                                intent3.putExtra("img_gallery_height", i2);
                                intent3.putExtra("sns_landing_pages_share_sns_id", mVar.bxW());
                                intent3.putExtra("sns_landing_pages_rawSnsId", mVar.bxV().nGJ);
                                intent3.putExtra("sns_landing_pages_ux_info", mVar.byA());
                                intent3.putExtra("sns_landing_pages_aid", mVar.byv());
                                intent3.putExtra("sns_landing_pages_traceid", mVar.byw());
                                bxV2 = mVar.bxV();
                                if (bxV2 != null) {
                                    list = bxV2.wQo.vYd;
                                    if (list.size() > i4) {
                                        intent3.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(i4)).wxE);
                                    } else if (list.size() > 0) {
                                        intent3.putExtra("sns_landing_pages_share_thumb_url", ((aqr) list.get(0)).wxE);
                                    }
                                }
                                intent3.setClass(this.rPY.activity, SnsAdNativeLandingPagesUI.class);
                                intent3.putExtra("sns_landig_pages_from_source", this.rPY.scene == 0 ? 1 : 2);
                                intent3.putExtra("sns_landing_pages_xml", i4 > 0 ? mVar.bxR().bwD() : mVar.byB().field_adxml);
                                intent3.putExtra("sns_landing_pages_rec_src", mVar.byC());
                                intent3.putExtra("sns_landing_pages_xml_prefix", "adxml");
                                intent3.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                this.rPY.activity.startActivity(intent3);
                                this.rPY.activity.overridePendingTransition(0, 0);
                                if (this.rPY.rrV != null) {
                                    this.rPY.rrV.bva().v(mVar);
                                    return;
                                }
                                return;
                            }
                        }
                        if (b.a(this.rPY, mVar.bxT(), mVar, i4 > 0)) {
                            Ch = mVar.byz();
                            i8 = this.rPY.scene == 0 ? 1 : 2;
                            str3 = "";
                            i9 = mVar.byD();
                            if (mVar.byB() != null) {
                                mVar.byB().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 31, mVar.bxV().rtA, mVar.bxW(), i3);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                            return;
                        }
                        bww = i4 > 0 ? mVar.bxR().rfl.rdQ : mVar.byy();
                        if (bh.ov(bww)) {
                            bww = mVar.byx();
                        }
                        if (!bh.ov(bww)) {
                            Ch = mVar.byz();
                            i8 = this.rPY.scene == 0 ? 1 : 2;
                            str3 = "";
                            i9 = obj2 != null ? 6 : 4;
                            if (mVar.byB() != null) {
                                mVar.byB().getSource();
                            }
                            cVar2 = new com.tencent.mm.plugin.sns.a.b.c(Ch, 22, i8, str3, i9, 0, mVar.bxV().rtA, mVar.bxW(), i3);
                            com.tencent.mm.kernel.g.Dk();
                            com.tencent.mm.kernel.g.Di().gPJ.a(cVar2, 0);
                            x.i("MicroMsg.TimelineClickListener", "adlink url " + bww + " " + mVar.bxR().rew);
                            intent = new Intent();
                            z = mVar.bxR().rew == 0;
                            if (r.idC) {
                                z = false;
                            }
                            snsAdClick = new SnsAdClick(mVar.byz(), this.rPY.scene == 0 ? 1 : 2, mVar.field_snsId, mVar.byA(), obj2 != null ? 6 : 4, (byte) 0);
                            snsAdClick.hOw = mVar.bxV().nGJ;
                            if (mVar != null && mVar.xl(32)) {
                                bxT2 = mVar.bxT();
                                if (bxT2 != null) {
                                    intent.putExtra("KsnsViewId", bxT2.iTh);
                                }
                            }
                            intent.putExtra("KRightBtn", z);
                            bundle = new Bundle();
                            bundle.putParcelable("KSnsAdTag", snsAdClick);
                            bundle.putString("key_snsad_statextstr", mVar.bxV().rtA);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", bww);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", mVar.field_userName);
                            intent.putExtra("stastic_scene", 15);
                            intent.putExtra("KPublisherId", "sns_" + i.eq(mVar.field_snsId));
                            intent.putExtra("pre_username", mVar.field_userName);
                            intent.putExtra("prePublishId", "sns_" + i.eq(mVar.field_snsId));
                            intent.putExtra("preUsername", mVar.field_userName);
                            com.tencent.mm.plugin.sns.c.a.ifs.j(intent, this.rPY.activity);
                        }
                    }
                }
            }
        }
    }
}
