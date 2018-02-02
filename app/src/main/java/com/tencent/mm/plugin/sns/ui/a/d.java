package com.tencent.mm.plugin.sns.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.plugin.sns.ui.r;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.an;

public final class d extends a {
    public final void d(c cVar) {
        if (cVar.rNO == null || cVar.rNO.getParent() == null) {
            cVar.rOA = cVar.mUL.findViewById(f.qCS);
            cVar.rOz = true;
        } else {
            cVar.rNO.setLayoutResource(g.qHA);
            if (!cVar.rOz) {
                cVar.rOA = cVar.rNO.inflate();
                cVar.rOz = true;
            }
        }
        cVar.rFu = cVar.rOA;
        cVar.rNR = (TagImageView) cVar.rFu.findViewById(f.qCp);
        cVar.rrj = (ImageView) cVar.rFu.findViewById(f.state);
        cVar.rNS = (TextView) cVar.rFu.findViewById(f.qDj);
        cVar.ihS = (TextView) cVar.rFu.findViewById(f.qFN);
        cVar.ihS.setTextColor(this.mActivity.getResources().getColor(i.c.black));
        com.tencent.mm.plugin.sns.data.i.b(cVar.rNR, this.mActivity);
    }

    public final void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        Object obj;
        Object obj2;
        String Mc;
        cVar.rNR.position = i;
        String str = ayVar.rsD;
        m mVar = ayVar.qyg;
        Object obj3 = null;
        if (ayVar.rrf) {
            if (mVar.bxR().rfi == 2) {
                obj3 = 1;
                cVar.rFu.setTag(cVar);
                cVar.rFu.setOnClickListener(avVar.qZo.rPX);
            }
            obj = null;
            obj2 = obj3;
        } else {
            if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 9) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMv);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 10) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMx);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 17) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMy);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 22) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMz);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 23) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMA);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 14) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMw);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 12) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rME);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 13) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.rzO.rMF);
                    obj = null;
                    obj2 = null;
                } else {
                    cVar.rFu.setOnClickListener(null);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 15) {
                if (com_tencent_mm_protocal_c_bnp.wQo.vYd.size() > 0) {
                    cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                    cVar.rFu.setOnClickListener(avVar.qZo.rPN);
                    obj = null;
                    obj2 = null;
                }
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 26) {
                cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                cVar.rFu.setOnClickListener(avVar.rzO.rMG);
                obj = null;
                obj2 = null;
            } else {
                cVar.rFu.setTag(new r(com_tencent_mm_protocal_c_bnp, str));
                cVar.rFu.setOnClickListener(avVar.rzO.rFh);
                if ((com_tencent_mm_protocal_c_bnp.hbg & 1) > 0) {
                    int i3 = 1;
                    obj2 = null;
                }
            }
            obj = null;
            obj2 = null;
        }
        if (obj2 != null) {
            avVar.kGt.c(cVar.rFu, avVar.qZo.rPH, avVar.qZo.rPp);
        } else {
            avVar.kGt.c(cVar.rFu, avVar.qZo.rPE, avVar.qZo.rPp);
        }
        obj3 = com_tencent_mm_protocal_c_bnp.wQo.vYc == 9 ? 1 : (a.bvV() & 1) <= 0 ? 1 : null;
        if (obj3 != null) {
            Mc = av.Mc(com_tencent_mm_protocal_c_bnp.wQo.nfX);
        } else {
            Mc = "";
        }
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 9 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 14 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 12 || com_tencent_mm_protocal_c_bnp.wQo.vYc == 13 || obj2 != null) {
            CharSequence charSequence = com_tencent_mm_protocal_c_bnp.wQo.nfe;
        } else {
            Object obj4 = Mc;
        }
        Mc = com_tencent_mm_protocal_c_bnp.wQo.fon;
        if (Mc == null || Mc.length() <= 40) {
            Object obj5 = Mc;
        } else {
            CharSequence charSequence2 = Mc.substring(0, 40) + "...";
        }
        cVar.rrj.setVisibility(8);
        if (!com_tencent_mm_protocal_c_bnp.wQo.vYd.isEmpty()) {
            cVar.rNR.setVisibility(0);
            aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
            com.tencent.mm.plugin.sns.model.g bvs;
            View view;
            int i4;
            int hashCode;
            an ciO;
            if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 15) {
                cVar.rrj.setImageResource(e.bDS);
                cVar.rrj.setVisibility(0);
                bvs = ae.bvs();
                view = cVar.rNR;
                i4 = i.i.dvA;
                hashCode = this.mActivity.hashCode();
                ciO = an.ciO();
                ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.b(com_tencent_mm_protocal_c_aqr, view, i4, hashCode, ciO);
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 5) {
                charSequence2 = com_tencent_mm_protocal_c_aqr.fon;
                cVar.rrj.setImageResource(e.bHg);
                cVar.rrj.setVisibility(0);
                bvs = ae.bvs();
                view = cVar.rNR;
                i4 = i.i.dvA;
                hashCode = this.mActivity.hashCode();
                ciO = an.ciO();
                ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.b(com_tencent_mm_protocal_c_aqr, view, i4, hashCode, ciO);
            } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 18) {
                cVar.rrj.setVisibility(0);
                cVar.rrj.setImageResource(e.bHg);
                cVar.rNR.setVisibility(0);
                bvs = ae.bvs();
                view = cVar.rNR;
                i4 = i.i.dvA;
                hashCode = this.mActivity.hashCode();
                ciO = an.ciO();
                ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.b(com_tencent_mm_protocal_c_aqr, view, i4, hashCode, ciO);
            } else {
                if (!(com_tencent_mm_protocal_c_bnp.qYw == null || bh.ov(com_tencent_mm_protocal_c_bnp.qYw.tnm))) {
                    cVar.rrj.setImageResource(e.bHg);
                    cVar.rrj.setVisibility(0);
                }
                bvs = ae.bvs();
                view = cVar.rNR;
                i4 = this.mActivity.hashCode();
                an ciO2 = an.ciO();
                ciO2.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.b(com_tencent_mm_protocal_c_aqr, view, i4, ciO2);
            }
        } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 18) {
            cVar.rrj.setVisibility(0);
            cVar.rrj.setImageResource(e.bHg);
            cVar.rNR.setVisibility(0);
            ae.bvs().a(cVar.rNR, -1, i.i.dvA, this.mActivity.hashCode());
        } else if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 26) {
            cVar.rNR.setVisibility(0);
            ae.bvs().a(cVar.rNR, -1, i.i.qIP, this.mActivity.hashCode());
        } else {
            cVar.rNR.setVisibility(0);
            ae.bvs().a(cVar.rNR, -1, i.i.dvD, this.mActivity.hashCode());
        }
        if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 15) {
            charSequence = "";
            charSequence2 = this.mActivity.getString(j.qKN);
        }
        if (bh.ov(charSequence)) {
            cVar.rNS.setVisibility(8);
        } else {
            cVar.rNS.setVisibility(0);
            cVar.rNS.setText(charSequence);
        }
        if (!bh.ov(charSequence2)) {
            if (cVar.rNS.getVisibility() == 8) {
                if (cVar.rNT != 2) {
                    cVar.ihS.setMaxLines(2);
                }
                cVar.rNT = 2;
            } else {
                if (cVar.rNT != 1) {
                    cVar.ihS.setMaxLines(1);
                }
                cVar.rNT = 1;
            }
            cVar.ihS.setVisibility(0);
            if (obj != null) {
                cVar.ihS.setText(com.tencent.mm.plugin.sns.data.i.a(charSequence2, this.mActivity, cVar.ihS));
            } else {
                cVar.ihS.setText(charSequence2);
            }
        } else if (i2 == 1) {
            cVar.ihS.setText(av.Mc(com_tencent_mm_protocal_c_bnp.wQo.nfX));
            cVar.ihS.setVisibility(0);
        } else {
            cVar.ihS.setVisibility(8);
        }
    }
}
