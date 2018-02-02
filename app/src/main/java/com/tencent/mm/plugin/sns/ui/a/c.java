package com.tencent.mm.plugin.sns.ui.a;

import android.text.SpannableString;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.asv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.an;

public final class c extends a {
    public final void d(com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (cVar.rNO != null) {
            cVar.rNO.setLayoutResource(g.qHA);
            cVar.rOy = (ViewStub) cVar.mUL.findViewById(f.qCq);
            if (!(cVar.rOz || cVar.rOy == null)) {
                cVar.rOA = cVar.rOy.inflate();
                cVar.rOz = true;
            }
        } else {
            cVar.rOA = cVar.mUL.findViewById(f.qCS);
            cVar.rOz = true;
        }
        cVar.rFu = cVar.rOA;
        cVar.rFu.findViewById(f.state).setOnTouchListener(this.qZU.rsO);
        cVar.rNR = (TagImageView) cVar.rFu.findViewById(f.qCp);
        cVar.rrj = (ImageView) cVar.rFu.findViewById(f.state);
        cVar.rNS = (TextView) cVar.rFu.findViewById(f.qDj);
        cVar.ihS = (TextView) cVar.rFu.findViewById(f.qFN);
        cVar.ihS.setTextColor(this.mActivity.getResources().getColor(com.tencent.mm.plugin.sns.i.c.btR));
        cVar.ihS.setMaxLines(1);
        i.b(cVar.rNR, this.mActivity);
    }

    public final void a(com.tencent.mm.plugin.sns.ui.a.a.c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        String str = ayVar.rsD;
        if (com_tencent_mm_protocal_c_bnp.wQo.vYd.isEmpty()) {
            cVar.rFu.setVisibility(8);
            return;
        }
        Object obj;
        CharSequence charSequence;
        cVar.rNR.position = i;
        cVar.rFu.setVisibility(0);
        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
        com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
        View view = cVar.rNR;
        int i3 = com.tencent.mm.plugin.sns.i.i.dvn;
        int hashCode = this.mActivity.hashCode();
        an ciO = an.ciO();
        ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
        bvs.b(com_tencent_mm_protocal_c_aqr, view, i3, hashCode, ciO);
        cVar.rrj.setPressed(false);
        String str2 = com_tencent_mm_protocal_c_bnp.nGJ;
        if (b.Qq()) {
            asv Qs = b.Qs();
            if (Qs != null && b.d(Qs) && str2.equals(Qs.vVZ)) {
                obj = 1;
                if (obj == null) {
                    cVar.rrj.setImageResource(e.bDR);
                } else {
                    cVar.rrj.setImageResource(e.bDS);
                }
                cVar.rNR.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                cVar.rNR.setOnClickListener(avVar.rzO.rMB);
                cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                avVar.kGt.c(cVar.rFu, avVar.qZo.rPE, avVar.qZo.rPp);
                cVar.rFu.setOnClickListener(avVar.rzO.rFh);
                charSequence = com_tencent_mm_protocal_c_aqr.nfe;
                if (bh.ov(charSequence)) {
                    cVar.rNS.setVisibility(0);
                    cVar.rNS.setText(charSequence);
                } else {
                    cVar.rNS.setVisibility(4);
                }
                charSequence = com_tencent_mm_protocal_c_aqr.fon;
                if (bh.ov(charSequence)) {
                    cVar.ihS.setVisibility(0);
                    cVar.ihS.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
                }
                cVar.ihS.setVisibility(8);
                return;
            }
        }
        obj = null;
        if (obj == null) {
            cVar.rrj.setImageResource(e.bDS);
        } else {
            cVar.rrj.setImageResource(e.bDR);
        }
        cVar.rNR.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
        cVar.rNR.setOnClickListener(avVar.rzO.rMB);
        cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
        avVar.kGt.c(cVar.rFu, avVar.qZo.rPE, avVar.qZo.rPp);
        cVar.rFu.setOnClickListener(avVar.rzO.rFh);
        charSequence = com_tencent_mm_protocal_c_aqr.nfe;
        if (bh.ov(charSequence)) {
            cVar.rNS.setVisibility(4);
        } else {
            cVar.rNS.setVisibility(0);
            cVar.rNS.setText(charSequence);
        }
        charSequence = com_tencent_mm_protocal_c_aqr.fon;
        if (bh.ov(charSequence)) {
            cVar.ihS.setVisibility(8);
            return;
        }
        cVar.ihS.setVisibility(0);
        cVar.ihS.setText(new SpannableString(charSequence), BufferType.SPANNABLE);
    }
}
