package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ad;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.a.g;
import com.tencent.mm.plugin.sns.ui.a.g.5;
import com.tencent.mm.plugin.sns.ui.a.g.a;
import com.tencent.mm.plugin.sns.ui.b.b;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.bjk;
import com.tencent.mm.protocal.c.bjv;
import com.tencent.mm.protocal.c.bnp;
import com.tencent.mm.sdk.platformtools.af;

class j$1 extends b {
    final /* synthetic */ j rrK;

    j$1(j jVar, Activity activity, ad adVar) {
        this.rrK = jVar;
        super(0, activity, adVar);
    }

    public final void b(View view, int i, int i2, int i3) {
        if (i2 < 0) {
            new 1(this, i, i2, i3, view).run();
        }
    }

    public final void bL(Object obj) {
        this.rrK.rry.a((View) obj, 1, this.rrK.rrt);
    }

    public final void bzg() {
        if (this.rrK.qZU != null) {
            this.rrK.qZU.bBB();
        }
    }

    public final void cB(View view) {
        int i = 0;
        c cVar = (c) view.getTag();
        if (this.rrK.qZU.bBy() != null) {
            this.rrK.qZU.bBy().bzr();
            m mVar = new m();
            m xt = this.rrK.qZU.xt(cVar.position);
            if (xt.isValid()) {
                com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(741);
                bjv n = ai.n(xt);
                com.tencent.mm.modelsns.b ix = iu.mB(i.g(xt)).ix(xt.field_type).bU(xt.xl(32)).mB(xt.byA()).mB(xt.field_userName).ix(n == null ? 0 : n.wMY);
                if (n != null) {
                    i = n.wNb;
                }
                ix.ix(i);
                iu.Sx();
                this.rrK.a(cVar, xt, "", new bjk());
                bjk com_tencent_mm_protocal_c_bjk = new bjk();
            }
        }
    }

    public final void cC(View view) {
        int i = 0;
        if (view.getTag() instanceof c) {
            c cVar = (c) view.getTag();
            if (this.rrK.qZU.bBy() != null) {
                this.rrK.qZU.bBy().bzr();
                m mVar = new m();
                m xt = this.rrK.qZU.xt(cVar.position);
                if (xt.isValid()) {
                    com.tencent.mm.modelsns.b iu = com.tencent.mm.modelsns.b.iu(741);
                    bjv n = ai.n(xt);
                    com.tencent.mm.modelsns.b ix = iu.mB(i.g(xt)).ix(xt.field_type).bU(xt.xl(32)).mB(xt.byA()).mB(xt.field_userName).ix(n == null ? 0 : n.wMY);
                    if (n != null) {
                        i = n.wNb;
                    }
                    ix.ix(i);
                    iu.Sx();
                    this.rrK.a(cVar, xt, new bjk());
                }
            }
        }
    }

    public final void cD(View view) {
        if (this.rrK.qZU != null) {
            this.rrK.qZU.cI(view);
        }
    }

    public final void cE(View view) {
        c cVar = (c) view.getTag();
        m Lm = ae.bvv().Lm(cVar.frH);
        if (Lm != null && !Lm.bve() && !j.a(this.rrK)) {
            int i = 0;
            if (Lm.xl(32) && Lm.bxV().wQo.vYc == 27 && (cVar.rON instanceof g)) {
                g gVar = (g) cVar.rON;
                a aVar = cVar.rOI;
                if (aVar.rPi != null) {
                    c cVar2 = aVar.rPh;
                    m mVar = aVar.ryi;
                    bnp com_tencent_mm_protocal_c_bnp = cVar2.rOK;
                    a aVar2 = cVar2.rOI;
                    if (com_tencent_mm_protocal_c_bnp.wQo.vYc == 27 && com_tencent_mm_protocal_c_bnp.wQo.vYd.size() >= 2) {
                        int i2;
                        int i3;
                        int i4;
                        if (mVar.field_likeFlag == 1) {
                            i2 = 1;
                            i = 0;
                        } else {
                            i2 = 0;
                            i = 1;
                        }
                        aqr com_tencent_mm_protocal_c_aqr = (aqr) com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i2);
                        com_tencent_mm_protocal_c_bnp.wQo.vYd.get(i);
                        View view2 = cVar2.rOG;
                        View i5 = g.i(cVar2.rOG, i2, com_tencent_mm_protocal_c_aqr.ktN);
                        View i6 = g.i(cVar2.rOG, i, 2);
                        int[] iArr = new int[2];
                        view2.getLocationOnScreen(iArr);
                        view2.setPivotY((float) ((gVar.mScreenHeight / 2) - iArr[1]));
                        view2.setCameraDistance(8000.0f);
                        float width = ((float) view2.getWidth()) / 2.0f;
                        float height = ((float) view2.getHeight()) / 2.0f;
                        if (mVar.field_likeFlag == 1) {
                            i3 = -90;
                            i4 = 90;
                        } else {
                            i3 = 90;
                            i4 = -90;
                        }
                        Animation aVar3 = new com.tencent.mm.plugin.sns.ui.widget.a(view2.getContext(), 0.0f, (float) i4, width, height, true);
                        aVar3.setDuration(187);
                        aVar3.setInterpolator(new AccelerateInterpolator());
                        aVar3.setFillAfter(true);
                        aVar3.setAnimationListener(new 5(gVar, i6, i5, aVar2, view2, i3, width, height));
                        view2.startAnimation(aVar3);
                        i = 374;
                        if (Lm.field_likeFlag == 0) {
                            this.rrK.rrs.ek(cVar.rND);
                        }
                        if (Lm.bxV().wQo.vYd.size() > cVar.rOI.index && ((aqr) Lm.bxV().wQo.vYd.get(cVar.rOI.index)).ktN == 6) {
                            this.rrK.rrs.p(cVar.rND, cVar.rOI.index <= 0);
                        }
                        j.a(this.rrK, true);
                    }
                }
                i = 0;
                if (Lm.field_likeFlag == 0) {
                    this.rrK.rrs.ek(cVar.rND);
                }
                if (cVar.rOI.index <= 0) {
                }
                this.rrK.rrs.p(cVar.rND, cVar.rOI.index <= 0);
                j.a(this.rrK, true);
            }
            new af().postDelayed(new 2(this, Lm, cVar, view), (long) i);
        }
    }

    public final void cF(View view) {
        this.rrK.rrD.bzr();
        this.rrK.rrE.cA(view);
    }

    public final void bzh() {
        this.rrK.rrE.byS();
    }

    public final void cG(View view) {
        this.rrK.rrE.bwm();
        if (view.getTag() != null) {
            com.tencent.mm.plugin.sns.data.b bVar = (com.tencent.mm.plugin.sns.data.b) view.getTag();
            this.rrK.rrs.t(bVar.position, bVar.frH, bVar.iTh);
        }
    }
}
