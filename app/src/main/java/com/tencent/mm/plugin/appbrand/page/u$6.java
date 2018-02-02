package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.page.u.b;
import com.tencent.mm.sdk.platformtools.bc;

class u$6 extends bc<Boolean> {
    final /* synthetic */ u jFr;
    final /* synthetic */ y jFw;
    final /* synthetic */ int jFx;
    final /* synthetic */ int jhi;

    u$6(u uVar, Boolean bool, int i, y yVar, int i2) {
        this.jFr = uVar;
        this.jhi = i;
        this.jFw = yVar;
        this.jFx = i2;
        super(1000, bool);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        u uVar = this.jFr;
        int i = this.jhi;
        y yVar = this.jFw;
        int i2 = this.jFx;
        if (i == uVar.jFm) {
            z = false;
        } else {
            b lm = uVar.lm(i);
            if (lm == null || lm.jFA == null) {
                z = false;
            } else {
                View view = (View) lm.jFA.get();
                if (view == null) {
                    z = false;
                } else {
                    b bVar;
                    uVar.jFq = i;
                    ViewGroup lj = uVar.lj(lm.jFB);
                    if ((lj instanceof AppBrandNativeContainerView) && ((AppBrandNativeContainerView) lj).jjb) {
                        b lm2 = uVar.lm(lm.jFB);
                        if (lm2 != null) {
                            ViewGroup lj2 = uVar.lj(lm2.jFB);
                            if (lj2 != null) {
                                View view2 = (View) lm.jFA.get();
                                if (view2 != null) {
                                    LayoutParams layoutParams = view2.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view2.setLayoutParams(layoutParams);
                                }
                                uVar.jFq = lm2.id;
                                lj = lj2;
                                bVar = lm2;
                                if (lj != null) {
                                    view = (View) bVar.jFA.get();
                                    lj.addView(uVar.jFo, lj.indexOfChild(view));
                                    lj.removeView(view);
                                }
                                uVar.jFn = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) bVar.z};
                                uVar.jEb.r(view, i2);
                                uVar.jFm = i;
                                uVar.jFp = yVar;
                                z = true;
                            }
                        }
                    }
                    bVar = lm;
                    if (lj != null) {
                        view = (View) bVar.jFA.get();
                        lj.addView(uVar.jFo, lj.indexOfChild(view));
                        lj.removeView(view);
                    }
                    uVar.jFn = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) bVar.z};
                    uVar.jEb.r(view, i2);
                    uVar.jFm = i;
                    uVar.jFp = yVar;
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
