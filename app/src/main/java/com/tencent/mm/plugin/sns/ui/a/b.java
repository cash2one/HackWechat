package com.tencent.mm.plugin.sns.ui.a;

import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.ar;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.aqs;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.z.q;
import java.util.ArrayList;
import java.util.List;

public final class b extends a {
    private int rzR = 103;

    public final void d(c cVar) {
        cVar.rNZ.setImageResource(e.qzk);
        cVar.rNF.setTextColor(-2730427);
        if (cVar.rNO != null) {
            cVar.rNO.setLayoutResource(g.qHq);
            if (!cVar.rNP) {
                cVar.rOg = (PhotosContent) cVar.rNO.inflate();
                cVar.rNP = true;
            }
        } else {
            cVar.rOg = (PhotosContent) cVar.mUL.findViewById(f.qCm);
            cVar.rNP = true;
        }
        x.i("MiroMsg.HBRewardTimeLineItem", "viewtype " + this.kTK);
        TagImageView tagImageView = (TagImageView) cVar.rOg.findViewById(ar.rDU[0]);
        cVar.rOg.a(tagImageView);
        tagImageView.setOnClickListener(this.qZU.qZo.rtw);
    }

    public final void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        String str = ayVar.rsD;
        if (cVar.rOR != null) {
            if (!ayVar.rKa || cVar.qOc.wNo == null || cVar.qOc.wNo.wNQ <= 0) {
                cVar.rOR.setBackgroundResource(e.qza);
            } else {
                cVar.rOR.setBackgroundResource(e.qzb);
            }
        }
        TagImageView xy = cVar.rOg.xy(0);
        List arrayList = new ArrayList();
        arrayList.add(xy);
        ap apVar = new ap();
        apVar.fus = str;
        apVar.index = 0;
        apVar.rBS = arrayList;
        apVar.rzb = this.rzb;
        if (xy != null) {
            xy.setTag(apVar);
        }
        aqs com_tencent_mm_protocal_c_aqs = ayVar.rKA;
        cVar.roU = com_tencent_mm_protocal_c_aqs;
        if (com_tencent_mm_protocal_c_aqs == null) {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo is null " + ayVar.rsD);
        } else if (q.FS().equals(com_tencent_mm_protocal_c_bnp.ksU)) {
            cVar.rOg.setVisibility(0);
            r1 = avVar.rzG;
            r2 = cVar.rOg;
            r4 = ayVar.rsD;
            r5 = this.mActivity.hashCode();
            r8 = this.rzb;
            r9 = an.ciO();
            r9.time = com_tencent_mm_protocal_c_bnp.pbl;
            r1.a(r2, com_tencent_mm_protocal_c_bnp, r4, r5, i2, i, r8, r9, true);
        } else if (ayVar.rKd) {
            cVar.rOg.setVisibility(0);
            r1 = avVar.rzG;
            r2 = cVar.rOg;
            r4 = ayVar.rsD;
            r5 = this.mActivity.hashCode();
            r8 = this.rzb;
            r9 = an.ciO();
            r9.time = com_tencent_mm_protocal_c_bnp.pbl;
            r1.a(r2, com_tencent_mm_protocal_c_bnp, r4, r5, i2, i, r8, r9, false);
        } else if (com_tencent_mm_protocal_c_aqs.fLD == 0) {
            cVar.rOg.setVisibility(0);
            r1 = avVar.rzG;
            r2 = cVar.rOg;
            r4 = ayVar.rsD;
            r5 = this.mActivity.hashCode();
            r8 = this.rzb;
            r9 = an.ciO();
            r9.time = com_tencent_mm_protocal_c_bnp.pbl;
            r1.a(r2, com_tencent_mm_protocal_c_bnp, r4, r5, i2, i, r8, r9, true);
        } else {
            x.e("MiroMsg.HBRewardTimeLineItem", "mediaPostInfo.hbStatus is " + com_tencent_mm_protocal_c_aqs.fLD);
        }
    }
}
