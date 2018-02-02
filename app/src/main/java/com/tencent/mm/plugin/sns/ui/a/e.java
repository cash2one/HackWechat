package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i$g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.aqt;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    MaskImageView rOX;
    private int rzQ;
    private int rzR = 103;

    public final void d(c cVar) {
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        x.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.kTK);
        this.rzQ = ae.bvD();
        if (cVar.rNO != null) {
            if (this.kTK == 2) {
                cVar.rNO.setLayoutResource(i$g.qIb);
            } else if (this.kTK == 3) {
                cVar.rNO.setLayoutResource(i$g.qHY);
            } else if (this.kTK == 4) {
                cVar.rNO.setLayoutResource(i$g.qHZ);
            } else if (this.kTK == 5) {
                cVar.rNO.setLayoutResource(i$g.qIa);
            } else {
                x.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.kTK);
            }
            if (!cVar.rNP) {
                cVar.rOg = (PhotosContent) cVar.rNO.inflate();
                cVar.rNP = true;
            }
        } else {
            cVar.rOg = (PhotosContent) cVar.mUL.findViewById(f.qCX);
            cVar.rNP = true;
        }
        cVar.rOg.rvB.clear();
        for (int i = 0; i < ar.rDQ[this.kTK]; i++) {
            TagImageView tagImageView = (TagImageView) cVar.rOg.findViewById(ar.rDU[i]);
            cVar.rOg.a(tagImageView);
            tagImageView.setOnClickListener(this.qZU.qZo.rtw);
            this.qZU.kGt.c(tagImageView, this.qZU.qZo.rPD, this.qZU.qZo.rPp);
        }
        cVar.rOg.xx(this.rzQ);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        cVar.rOg.setVisibility(0);
        String str = com_tencent_mm_protocal_c_bnp.wQn == null ? null : com_tencent_mm_protocal_c_bnp.wQn.nGJ;
        if (!bh.ov(str)) {
            boolean booleanValue;
            if (avVar.rHB.containsKey(str)) {
                booleanValue = ((Boolean) avVar.rHB.get(str)).booleanValue();
            } else {
                avVar.rHB.put(str, Boolean.valueOf(a.ift.cA(str)));
                booleanValue = true;
            }
            if (booleanValue) {
                a.ift.a(this.mActivity, str, com_tencent_mm_protocal_c_bnp.ksU, com_tencent_mm_protocal_c_bnp.wQs, ayVar.rJK);
            }
        }
        List linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (ayVar.rrf && i2 == 2) {
            b bxR = ayVar.qyg.bxR();
            if (bxR != null && bxR.rfi == 1 && cVar.rOg.xy(0) != null) {
                aqr com_tencent_mm_protocal_c_aqr;
                if (com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() <= 0) {
                    com_tencent_mm_protocal_c_aqr = null;
                } else {
                    com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
                }
                width = (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 28);
                int i3 = (int) ((com_tencent_mm_protocal_c_aqr.wxH.wyv * ((float) width)) / com_tencent_mm_protocal_c_aqr.wxH.wyu);
                aqt com_tencent_mm_protocal_c_aqt = new aqt();
                com_tencent_mm_protocal_c_aqt.wyu = (float) width;
                com_tencent_mm_protocal_c_aqt.wyv = (float) i3;
                com_tencent_mm_protocal_c_aqt.wyw = com_tencent_mm_protocal_c_aqt.wyu * com_tencent_mm_protocal_c_aqt.wyv;
                linkedList.add(com_tencent_mm_protocal_c_aqt);
                for (int i4 = 0; i4 < ar.rDQ[i2]; i4++) {
                    avVar.kGt.c((TagImageView) cVar.rOg.findViewById(ar.rDU[i4]), avVar.qZo.rPG, avVar.qZo.rPp);
                }
            } else if (bxR != null && bxR.reY > 0.0f && bxR.reZ > 0.0f) {
                float a = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reY, 1, bxR.rfa, bxR.rfb);
                float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reZ, 1, bxR.rfa, bxR.rfb);
                if (bxR.reX == 0) {
                    aqt com_tencent_mm_protocal_c_aqt2 = new aqt();
                    com_tencent_mm_protocal_c_aqt2.wyu = a;
                    com_tencent_mm_protocal_c_aqt2.wyv = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)))) {
                        com_tencent_mm_protocal_c_aqt2.wyu = (float) (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12));
                        com_tencent_mm_protocal_c_aqt2.wyv = (float) ((int) ((com_tencent_mm_protocal_c_aqt2.wyu * bxR.reZ) / bxR.reY));
                    }
                    com_tencent_mm_protocal_c_aqt2.wyw = com_tencent_mm_protocal_c_aqt2.wyu * com_tencent_mm_protocal_c_aqt2.wyv;
                    linkedList.add(com_tencent_mm_protocal_c_aqt2);
                } else if (bxR.reX == 1) {
                    width = (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12);
                    r5 = (int) ((((float) width) * bxR.reZ) / bxR.reY);
                    r6 = new aqt();
                    if (width > 0) {
                        a = (float) width;
                    }
                    r6.wyu = a;
                    if (r5 > 0) {
                        a = (float) r5;
                    } else {
                        a = a2;
                    }
                    r6.wyv = a;
                    r6.wyw = r6.wyu * r6.wyv;
                    linkedList.add(r6);
                } else if (bxR.reX == 2) {
                    width = ((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12);
                    r5 = (int) ((((float) width) * bxR.reZ) / bxR.reY);
                    r6 = new aqt();
                    if (width > 0) {
                        a = (float) width;
                    }
                    r6.wyu = a;
                    if (r5 > 0) {
                        a2 = (float) r5;
                    }
                    r6.wyv = a2;
                    r6.wyw = r6.wyu * r6.wyv;
                    linkedList.add(r6);
                }
            }
            if (!bh.ov(bxR.rfd)) {
                d.a("adId", bxR.rfd, false, 41, 0, new 1(this, cVar.rOg, bxR, cVar.rOg.xy(0)));
            }
        }
        ar arVar = avVar.rzG;
        PhotosContent photosContent = cVar.rOg;
        str = ayVar.rsD;
        int hashCode = this.mActivity.hashCode();
        boolean z = this.rzb;
        an ciO = an.ciO();
        ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
        arVar.a(photosContent, com_tencent_mm_protocal_c_bnp, str, hashCode, i2, i, z, ciO, linkedList);
        cVar.rOV.setTag(cVar.rOg.xy(0));
        cVar.rOW.setTag(cVar.rOg.xy(0));
    }
}
