package com.tencent.mm.plugin.sns.ui.a;

import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sight.decode.a.b$f;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sns.i$e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.ay;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.widget.MMPinProgressBtn;

public final class h extends a {
    private int mScreenHeight;
    private int mScreenWidth;
    private e rPj = new e(this) {
        final /* synthetic */ h rPk;

        {
            this.rPk = r1;
        }

        public final void d(b bVar, int i) {
        }
    };

    public final void d(c cVar) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        if (cVar.rNO != null) {
            cVar.rNO.setLayoutResource(g.qEK);
            cVar.rOD = (ViewStub) cVar.mUL.findViewById(f.qCq);
            if (!cVar.rOE) {
                cVar.rOF.rxg = cVar.rOD.inflate();
                cVar.rOE = true;
            }
        } else {
            cVar.rOF.rxg = cVar.mUL.findViewById(f.qEK);
            cVar.rOE = true;
        }
        cVar.rOF.rxh = cVar.rOF.rxg.findViewById(f.bTD);
        cVar.rOF.qvN = (a) cVar.rOF.rxg.findViewById(f.image);
        cVar.rOF.rxh.setOnClickListener(this.qZU.qZo.rPM);
        cVar.rOF.rkR = (ImageView) cVar.rOF.rxg.findViewById(f.cPl);
        cVar.rOF.rxi = (MMPinProgressBtn) cVar.rOF.rxg.findViewById(f.progress);
        cVar.rOF.rxj = (TextView) cVar.rOF.rxg.findViewById(f.qCa);
        cVar.rOF.rkU = (TextView) cVar.rOF.rxg.findViewById(f.qCb);
        com.tencent.mm.kernel.g.Dk();
        if (((Boolean) com.tencent.mm.kernel.g.Dj().CU().get(344065, Boolean.valueOf(false))).booleanValue()) {
            cVar.rOF.qvN.h((TextView) ((ViewStub) cVar.rOF.rxg.findViewById(f.qDu)).inflate());
        }
    }

    public final void a(c cVar, int i, ay ayVar, bnp com_tencent_mm_protocal_c_bnp, int i2, av avVar) {
        aqr com_tencent_mm_protocal_c_aqr;
        if (com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() <= 0) {
            com_tencent_mm_protocal_c_aqr = null;
        } else {
            com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(0);
        }
        x.v("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[]{Integer.valueOf(i)});
        m Ll = ae.bvv().Ll(cVar.fzW);
        if (!ayVar.rrf || com_tencent_mm_protocal_c_aqr == null) {
            cVar.rOF.rxj.setVisibility(8);
            cVar.rOF.qvN.bsI();
            cVar.rOF.qvN.a(null);
            cVar.rOF.qvN.a(null);
        } else {
            final long j = ayVar.rJK;
            cVar.rOF.qvN.a(new 2(this, avVar, j));
            if (!avVar.rHp.rrs.ej(j)) {
                final av avVar2 = avVar;
                final c cVar2 = cVar;
                cVar.rOF.qvN.a(new b$f(this) {
                    final /* synthetic */ h rPk;

                    public final void b(b bVar, long j) {
                        if (avVar2 != null && avVar2.rHp != null && avVar2.rHp.rrs != null) {
                            int bsO = (int) bVar.bsO();
                            avVar2.rHp.rrs.b(j, bh.Wq(), false);
                            avVar2.rHp.rrs.v(j, bsO);
                            avVar2.rHp.rrs.z(j, j);
                            cVar2.rOF.qvN.a(null);
                        }
                    }
                });
            }
        }
        cVar.rOF.a(com_tencent_mm_protocal_c_bnp, i, ayVar.rsD, ayVar.rrf);
        cVar.rOF.rkU.setVisibility(8);
        com.tencent.mm.plugin.sns.model.g bvs = ae.bvs();
        if (com_tencent_mm_protocal_c_bnp.wQo == null || com_tencent_mm_protocal_c_bnp.wQo.vYd.size() <= 0) {
            a aVar = cVar.rOF.qvN;
            bvs.a(aVar, "", -1, this.mActivity.hashCode());
            aVar.B(null);
            aVar.aA(null, false);
        } else {
            int fromDPToPix;
            Pair create;
            int intValue;
            LayoutParams layoutParams;
            a aVar2;
            int hashCode;
            an ciO;
            boolean z;
            long nanoTime = System.nanoTime() - System.nanoTime();
            x.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[]{Boolean.valueOf(com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_aqr)), Long.valueOf(nanoTime)});
            if (com.tencent.mm.plugin.sns.model.g.t(com_tencent_mm_protocal_c_aqr)) {
                if (bvs.u(com_tencent_mm_protocal_c_aqr)) {
                    cVar.rOF.rkR.setVisibility(0);
                    cVar.rOF.rxi.setVisibility(8);
                    cVar.rOF.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.mActivity, i.dAI));
                    cVar.rOF.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                } else if (bvs.v(com_tencent_mm_protocal_c_aqr)) {
                    cVar.rOF.rkR.setVisibility(8);
                    cVar.rOF.rxi.setVisibility(8);
                } else if (!ayVar.rrf || bvs.b(Ll, null) > 5) {
                    bvs.y(com_tencent_mm_protocal_c_aqr);
                    cVar.rOF.rkR.setVisibility(0);
                    cVar.rOF.rxi.setVisibility(8);
                    cVar.rOF.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.mActivity, i.dAI));
                    cVar.rOF.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                } else {
                    cVar.rOF.rkR.setVisibility(8);
                    cVar.rOF.rxi.setVisibility(8);
                }
                if (cVar.rOF.qvN.bsG()) {
                    x.d("MicroMsg.VideoTimeLineItem", "play video error " + com_tencent_mm_protocal_c_aqr.nGJ + " " + com_tencent_mm_protocal_c_aqr.nfX + " " + com_tencent_mm_protocal_c_aqr.wxE + " " + i);
                    bvs.y(com_tencent_mm_protocal_c_aqr);
                    cVar.rOF.rkR.setVisibility(0);
                    cVar.rOF.rxi.setVisibility(8);
                    cVar.rOF.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.mActivity, i.dAI));
                    cVar.rOF.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                }
            } else if (bvs.w(com_tencent_mm_protocal_c_aqr)) {
                cVar.rOF.rkR.setVisibility(8);
                cVar.rOF.rxi.setVisibility(0);
                cVar.rOF.rxi.cyN();
            } else if (ayVar.rrf && bvs.b(Ll, null) == 5) {
                bvs.A(com_tencent_mm_protocal_c_aqr);
                cVar.rOF.rkR.setVisibility(8);
                cVar.rOF.rxi.setVisibility(0);
                cVar.rOF.rxi.cyN();
            } else if (bvs.x(com_tencent_mm_protocal_c_aqr)) {
                cVar.rOF.rxi.setVisibility(8);
                cVar.rOF.rkR.setImageResource(i$e.bGf);
                cVar.rOF.rkR.setVisibility(0);
            } else {
                bvs.y(com_tencent_mm_protocal_c_aqr);
                cVar.rOF.rkR.setVisibility(0);
                cVar.rOF.rxi.setVisibility(8);
                cVar.rOF.rkR.setImageDrawable(com.tencent.mm.bv.a.b(this.mActivity, i.dAI));
                cVar.rOF.rkR.setContentDescription(this.mActivity.getString(j.qJJ));
                if (!ayVar.rrf && bvs.a(Ll, null) == 4) {
                    cVar.rOF.rkU.setVisibility(0);
                } else if (ayVar.rrf && bvs.b(Ll, null) == 4) {
                    cVar.rOF.rkU.setVisibility(0);
                }
            }
            Pair a = com.tencent.mm.modelsns.e.a(cVar.rOK, cVar.rOF.qvN.bsF(), ayVar.rrf);
            if (ayVar.rrf) {
                com.tencent.mm.plugin.sns.storage.b bxR = ayVar.qyg.bxR();
                int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
                if (bxR != null && bxR.rfi == 1 && cVar.rOE) {
                    fromDPToPix = (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 28);
                    create = Pair.create(Integer.valueOf(fromDPToPix), Integer.valueOf((int) ((((float) fromDPToPix) * com_tencent_mm_protocal_c_aqr.wxH.wyv) / com_tencent_mm_protocal_c_aqr.wxH.wyu)));
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.rOF.qvN.dt(intValue, fromDPToPix);
                    layoutParams = cVar.rOF.rxj.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.rOF.rxj.setLayoutParams(layoutParams);
                    cVar.rOF.qvN.bH(cVar.rOF);
                    aVar2 = cVar.rOF.qvN;
                    hashCode = this.mActivity.hashCode();
                    ciO = an.ciO();
                    ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                    bvs.a(Ll, com_tencent_mm_protocal_c_aqr, aVar2, hashCode, i, ciO, ayVar.rrf);
                    cVar.rOF.rxh.setTag(cVar.rOF);
                    cVar.rOV.setTag(cVar.rOF);
                    cVar.rOW.setTag(cVar.rOF);
                    if (FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_aqr))) {
                        avVar.rHp.rrs.n(ayVar.rJK, false);
                    } else {
                        avVar.rHp.rrs.n(ayVar.rJK, true);
                    }
                    if (ayVar.rrf) {
                        if (ae.bvs().a(Ll, null) == 5) {
                        }
                    }
                    avVar.rHp.rrs.o(ayVar.rJK, z);
                } else if (bxR != null && bxR.reY > 0.0f && bxR.reZ > 0.0f) {
                    float a2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reY, 1, bxR.rfa, bxR.rfb);
                    float a3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a((double) bxR.reZ, 1, bxR.rfa, bxR.rfb);
                    if (bxR.reX == 0) {
                        if (a2 >= ((float) (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)))) {
                            a2 = (float) (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12));
                            a3 = (float) ((int) ((bxR.reZ * a2) / bxR.reY));
                        }
                        create = Pair.create(Integer.valueOf((int) a2), Integer.valueOf((int) a3));
                    } else if (bxR.reX == 1) {
                        r4 = (((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12);
                        r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * bxR.reZ) / bxR.reY)));
                        cVar.rNI.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                        create = r3;
                    } else if (bxR.reX == 2) {
                        r4 = ((width - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12)) - com.tencent.mm.bv.a.fromDPToPix(this.mActivity, 12);
                        r3 = Pair.create(Integer.valueOf(r4), Integer.valueOf((int) ((((float) r4) * bxR.reZ) / bxR.reY)));
                        cVar.rNI.setLayoutParams(new LinearLayout.LayoutParams(r4, -2));
                        create = r3;
                    }
                    intValue = ((Integer) create.first).intValue();
                    fromDPToPix = ((Integer) create.second).intValue();
                    cVar.rOF.qvN.dt(intValue, fromDPToPix);
                    layoutParams = cVar.rOF.rxj.getLayoutParams();
                    layoutParams.width = intValue;
                    layoutParams.height = fromDPToPix;
                    cVar.rOF.rxj.setLayoutParams(layoutParams);
                    cVar.rOF.qvN.bH(cVar.rOF);
                    aVar2 = cVar.rOF.qvN;
                    hashCode = this.mActivity.hashCode();
                    ciO = an.ciO();
                    ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
                    bvs.a(Ll, com_tencent_mm_protocal_c_aqr, aVar2, hashCode, i, ciO, ayVar.rrf);
                    cVar.rOF.rxh.setTag(cVar.rOF);
                    cVar.rOV.setTag(cVar.rOF);
                    cVar.rOW.setTag(cVar.rOF);
                    if (FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_aqr))) {
                        avVar.rHp.rrs.n(ayVar.rJK, true);
                    } else {
                        avVar.rHp.rrs.n(ayVar.rJK, false);
                    }
                    z = ayVar.rrf ? ae.bvs().b(Ll, null) == 5 : ae.bvs().a(Ll, null) == 5;
                    avVar.rHp.rrs.o(ayVar.rJK, z);
                }
            }
            create = a;
            intValue = ((Integer) create.first).intValue();
            fromDPToPix = ((Integer) create.second).intValue();
            cVar.rOF.qvN.dt(intValue, fromDPToPix);
            layoutParams = cVar.rOF.rxj.getLayoutParams();
            layoutParams.width = intValue;
            layoutParams.height = fromDPToPix;
            cVar.rOF.rxj.setLayoutParams(layoutParams);
            cVar.rOF.qvN.bH(cVar.rOF);
            aVar2 = cVar.rOF.qvN;
            hashCode = this.mActivity.hashCode();
            ciO = an.ciO();
            ciO.time = com_tencent_mm_protocal_c_bnp.pbl;
            bvs.a(Ll, com_tencent_mm_protocal_c_aqr, aVar2, hashCode, i, ciO, ayVar.rrf);
            cVar.rOF.rxh.setTag(cVar.rOF);
            cVar.rOV.setTag(cVar.rOF);
            cVar.rOW.setTag(cVar.rOF);
            if (FileOp.bO(am.r(ae.getAccSnsPath(), com_tencent_mm_protocal_c_aqr.nGJ) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_aqr))) {
                avVar.rHp.rrs.n(ayVar.rJK, true);
            } else {
                avVar.rHp.rrs.n(ayVar.rJK, false);
            }
            if (ayVar.rrf) {
                if (ae.bvs().b(Ll, null) == 5) {
                }
            }
            avVar.rHp.rrs.o(ayVar.rJK, z);
        }
        if (Ll == null || Ll.bwy()) {
            avVar.kGt.c(cVar.rOF.rxh, avVar.qZo.rPG, avVar.qZo.rPp);
        } else {
            avVar.kGt.c(cVar.rOF.rxh, avVar.qZo.rPF, avVar.qZo.rPp);
        }
    }
}
