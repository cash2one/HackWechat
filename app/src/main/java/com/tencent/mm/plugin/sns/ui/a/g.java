package com.tencent.mm.plugin.sns.ui.a;

import android.annotation.TargetApi;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bv.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.b$e;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.ak;
import com.tencent.mm.plugin.sns.ui.ap;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView;

public final class g extends a {
    private static int[] rPa = new int[]{f.qFQ, f.qFR};
    private static int[] rPb = new int[]{f.qFS};
    private static int[][] rPc;
    public int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private int rOZ = 0;

    static {
        r0 = new int[3][];
        r0[0] = new int[]{f.qFW, f.qFU};
        r0[1] = new int[]{f.qFV, f.qFT};
        r0[2] = new int[]{f.qFV, f.qFU};
        rPc = r0;
    }

    public final void d(c cVar) {
        if (this.mActivity != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            this.mScreenWidth = displayMetrics.widthPixels;
            this.mScreenHeight = displayMetrics.heightPixels;
            this.rOZ = Math.min(this.mScreenWidth, this.mScreenHeight) - a.fromDPToPix(this.mActivity, 82);
        }
        if (cVar.rNO == null || cVar.rOH) {
            cVar.rOG = cVar.mUL.findViewById(f.qFP);
            cVar.rOH = true;
        } else {
            cVar.rNO.setLayoutResource(com.tencent.mm.plugin.sns.i.g.qIe);
            cVar.rOG = cVar.rNO.inflate();
            cVar.rOH = true;
        }
        LayoutParams layoutParams = cVar.rOG.getLayoutParams();
        layoutParams.width = this.rOZ;
        layoutParams.height = this.rOZ;
        ak akVar = cVar.rOJ;
        akVar.rxh = i(cVar.rOG, 0, 6);
        akVar.rxg = akVar.rxh;
        akVar.qvN = (com.tencent.mm.plugin.sight.decode.a.a) akVar.rxh.findViewById(f.image);
        akVar.rkR = (ImageView) akVar.rxh.findViewById(f.cPl);
        akVar.rxi = (MMPinProgressBtn) akVar.rxh.findViewById(f.progress);
        akVar.rxj = (TextView) akVar.rxh.findViewById(f.qCa);
        akVar.rkU = (TextView) akVar.rxh.findViewById(f.qCb);
        ((SightPlayImageView) akVar.qvN).quJ = true;
        ((SightPlayImageView) akVar.qvN).a(QImageView.a.zwh);
        akVar.qvN.dt(this.rOZ, this.rOZ);
    }

    @TargetApi(16)
    public final void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        cVar.rOG.setTag(cVar);
        cVar.rOG.setVisibility(0);
        cVar.rOG.setLayerType(2, null);
        for (int findViewById : rPa) {
            View findViewById2 = cVar.rOG.findViewById(findViewById);
            if (findViewById2 != null) {
                findViewById2.setVisibility(8);
            }
            if (findViewById2 instanceof MaskImageView) {
                ((MaskImageView) findViewById2).a(QImageView.a.zwh);
            }
        }
        for (int findViewById3 : rPb) {
            findViewById2 = cVar.rOG.findViewById(findViewById3);
            if (findViewById2 != null) {
                findViewById2.setBackground(null);
                findViewById2.setVisibility(8);
                if (findViewById2 instanceof ViewGroup) {
                    ((ViewGroup) findViewById2).setClipChildren(false);
                }
            }
        }
        cVar.rOJ.qvN.clear();
        if (!ayVar.rrf || i2 != 12) {
            return;
        }
        if (com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() < 2) {
            x.e("MiroMsg.TurnMediaTimeLineItem", "not enough medias!");
            return;
        }
        int i3;
        if (cVar.rNE == 1) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        a aVar = null;
        a aVar2 = null;
        int i4 = 0;
        while (i4 < Math.min(com_tencent_mm_protocal_c_bnp.wQo.vYd.size(), 2)) {
            a aVar3;
            a aVar4;
            aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i4);
            View i5 = i(cVar.rOG, i4, 2);
            if (i5 != null) {
                LayoutParams layoutParams;
                View view;
                ap apVar = new ap();
                apVar.fus = cVar.frH;
                apVar.index = i4;
                apVar.rzb = this.rzb;
                apVar.position = i;
                i5.setTag(apVar);
                com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
                int hashCode = this.mActivity.hashCode();
                an ciO = an.ciO();
                ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                bvs.a(com_tencent_mm_protocal_c_aqr, i5, hashCode, ciO);
                if (com_tencent_mm_protocal_c_aqr.ktN == 6 && i3 == i4) {
                    boolean z = i3 > 0;
                    long j = ayVar.rJK;
                    ak akVar = cVar.rOJ;
                    m mVar = ayVar.qyg;
                    View view2 = akVar.rxg;
                    akVar.rxf = com_tencent_mm_protocal_c_bnp;
                    akVar.qvN.a(new 1(this, avVar, j, z));
                    if (!avVar.rHp.rrs.ej(((long) i4) + j)) {
                        akVar.qvN.a(new 2(this, avVar, j, z, i4, akVar));
                    } else if (!(avVar == null || avVar.rHp == null || avVar.rHp.rrs == null)) {
                        avVar.rHp.rrs.b(j, bh.Wq(), z);
                    }
                    akVar.a(com_tencent_mm_protocal_c_bnp, i, ayVar.rsD, ayVar.rrf);
                    akVar.rkU.setVisibility(8);
                    com.tencent.mm.plugin.sns.model.g bvs2 = ae.bvs();
                    long nanoTime = System.nanoTime() - System.nanoTime();
                    x.i("MiroMsg.TurnMediaTimeLineItem", "isMediaSightExist %b duration %s", Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_aqr)), Long.valueOf(nanoTime));
                    if (com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_aqr)) {
                        if (bvs2.u(com_tencent_mm_protocal_c_aqr)) {
                            akVar.rkR.setVisibility(0);
                            akVar.rxi.setVisibility(8);
                            akVar.rkR.setImageDrawable(a.b(this.mActivity, i.dAI));
                            akVar.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                        } else if (bvs2.v(com_tencent_mm_protocal_c_aqr)) {
                            akVar.rkR.setVisibility(8);
                            akVar.rxi.setVisibility(8);
                        } else if (!ayVar.rrf || bvs2.b(mVar, null) > 5) {
                            bvs2.y(com_tencent_mm_protocal_c_aqr);
                            akVar.rkR.setVisibility(0);
                            akVar.rxi.setVisibility(8);
                            akVar.rkR.setImageDrawable(a.b(this.mActivity, i.dAI));
                            akVar.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                        } else {
                            akVar.rkR.setVisibility(8);
                            akVar.rxi.setVisibility(8);
                        }
                        if (akVar.qvN.bsG()) {
                            x.d("MiroMsg.TurnMediaTimeLineItem", "play video error " + com_tencent_mm_protocal_c_aqr.nGJ + " " + com_tencent_mm_protocal_c_aqr.nfX + " " + com_tencent_mm_protocal_c_aqr.wxE + " " + i);
                            bvs2.y(com_tencent_mm_protocal_c_aqr);
                            akVar.rkR.setVisibility(0);
                            akVar.rxi.setVisibility(8);
                            akVar.rkR.setImageDrawable(a.b(this.mActivity, i.dAI));
                            akVar.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                        }
                    } else if (bvs2.w(com_tencent_mm_protocal_c_aqr)) {
                        akVar.rkR.setVisibility(8);
                        akVar.rxi.setVisibility(0);
                        akVar.rxi.cyN();
                    } else if (ayVar.rrf && bvs2.b(mVar, null) == 5) {
                        bvs2.A(com_tencent_mm_protocal_c_aqr);
                        akVar.rkR.setVisibility(8);
                        akVar.rxi.setVisibility(0);
                        akVar.rxi.cyN();
                    } else if (bvs2.x(com_tencent_mm_protocal_c_aqr)) {
                        akVar.rxi.setVisibility(8);
                        akVar.rkR.setImageResource(e.bGf);
                        akVar.rkR.setVisibility(0);
                    } else {
                        bvs2.y(com_tencent_mm_protocal_c_aqr);
                        akVar.rkR.setVisibility(0);
                        akVar.rxi.setVisibility(8);
                        akVar.rkR.setImageDrawable(a.b(this.mActivity, i.dAI));
                        akVar.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                        if (!ayVar.rrf && bvs2.a(mVar, null) == 4) {
                            akVar.rkU.setVisibility(0);
                        } else if (ayVar.rrf && bvs2.b(mVar, null) == 4) {
                            akVar.rkU.setVisibility(0);
                        }
                    }
                    layoutParams = akVar.rxj.getLayoutParams();
                    layoutParams.width = this.rOZ;
                    layoutParams.height = this.rOZ;
                    akVar.rxj.setLayoutParams(layoutParams);
                    akVar.qvN.bH(akVar);
                    com.tencent.mm.plugin.sight.decode.a.a aVar5 = akVar.qvN;
                    int hashCode2 = this.mActivity.hashCode();
                    an ciO2 = an.ciO();
                    ciO2.time = com_tencent_mm_protocal_c_bnp.pbl;
                    bvs2.a(mVar, com_tencent_mm_protocal_c_aqr, aVar5, -1, hashCode2, i, ciO2, ayVar.rrf, true);
                    view2.setVisibility(0);
                    akVar.rxh.setTag(akVar);
                    if (FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_aqr))) {
                        avVar.rHp.rrs.b(ayVar.rJK, 0, true, z);
                    } else {
                        avVar.rHp.rrs.b(ayVar.rJK, 0, false, z);
                    }
                    boolean z2 = ayVar.rrf ? ae.bvs().b(mVar, null) == 5 : ae.bvs().a(mVar, null) == 5;
                    avVar.rHp.rrs.a(ayVar.rJK, z2, 1, z);
                    view = view2;
                } else {
                    view = null;
                }
                layoutParams = i5.getLayoutParams();
                layoutParams.width = this.rOZ;
                layoutParams.height = this.rOZ;
                i5.setLayoutParams(layoutParams);
                if (view != null) {
                    layoutParams = view.getLayoutParams();
                    layoutParams.width = this.rOZ;
                    layoutParams.height = this.rOZ;
                    view.setLayoutParams(layoutParams);
                }
                if (i3 == i4 && com_tencent_mm_protocal_c_aqr.ktN == 2) {
                    i5.setVisibility(0);
                    i5.setOnTouchListener(new 3(this));
                }
                aVar3 = new a();
                aVar3.index = i4;
                if (view == null) {
                    view = i5;
                }
                aVar3.view = view;
                aVar3.rPg = i5;
                aVar3.rPh = cVar;
                aVar3.qTV = com_tencent_mm_protocal_c_aqr;
                aVar3.ryi = ayVar.qyg;
                if (aVar != null) {
                    aVar.rPi = aVar3;
                    aVar4 = aVar2;
                } else {
                    aVar4 = aVar3;
                }
                if (i4 == com_tencent_mm_protocal_c_bnp.wQo.vYd.size() - 1) {
                    aVar3.rPi = aVar4;
                }
                if (i4 == i3) {
                    cVar.rOI = aVar3;
                    a(aVar3);
                }
            } else {
                aVar4 = aVar2;
                aVar3 = aVar;
            }
            i4++;
            aVar2 = aVar4;
            aVar = aVar3;
        }
        if (cVar.mUL != null && (cVar.mUL instanceof FrameLayout)) {
            ((FrameLayout) cVar.mUL).setClipChildren(false);
        }
        if (cVar.rNN != null) {
            cVar.rNN.setClipChildren(false);
        }
        if (cVar.rOM != null && (cVar.rOM instanceof LinearLayout)) {
            ((LinearLayout) cVar.rOM).setClipChildren(false);
        }
        cVar.rOG.setOnClickListener(new 4(this, avVar, i3, cVar));
    }

    public static View i(View view, int i, int i2) {
        if (i2 == 6) {
            return view.findViewById(rPb[0]);
        }
        return view.findViewById(rPa[i]);
    }

    private static void a(a aVar) {
        View findViewById = aVar.rPh.rOG.findViewById(f.qFJ);
        View findViewById2 = aVar.rPh.rOG.findViewById(f.qFI);
        findViewById.setVisibility(8);
        findViewById2.setVisibility(8);
        ((TextView) aVar.rPh.rOG.findViewById(f.qFV)).setText(null);
        ((TextView) aVar.rPh.rOG.findViewById(f.qFW)).setText(null);
        ((TextView) aVar.rPh.rOG.findViewById(f.qFT)).setText(null);
        ((TextView) aVar.rPh.rOG.findViewById(f.qFU)).setText(null);
        b bxR = aVar.ryi.bxR();
        if (bxR.rfl != null && bxR.rfl.rfr != null && bxR.rfl.rfr.size() >= 2) {
            b$e com_tencent_mm_plugin_sns_storage_b_e = (b$e) bxR.rfl.rfr.get(aVar.index);
            if (com_tencent_mm_plugin_sns_storage_b_e.rfx >= 0 && com_tencent_mm_plugin_sns_storage_b_e.rfx < rPc.length) {
                int[] iArr = rPc[com_tencent_mm_plugin_sns_storage_b_e.rfx];
                TextView textView = (TextView) aVar.rPh.rOG.findViewById(iArr[0]);
                TextView textView2 = (TextView) aVar.rPh.rOG.findViewById(iArr[1]);
                if (bh.ov(com_tencent_mm_plugin_sns_storage_b_e.title)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(com_tencent_mm_plugin_sns_storage_b_e.title);
                }
                if (bh.ov(com_tencent_mm_plugin_sns_storage_b_e.desc)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(com_tencent_mm_plugin_sns_storage_b_e.desc);
                }
                ((View) textView.getParent()).setVisibility(0);
                ((View) textView2.getParent()).setVisibility(0);
            }
        }
    }
}
