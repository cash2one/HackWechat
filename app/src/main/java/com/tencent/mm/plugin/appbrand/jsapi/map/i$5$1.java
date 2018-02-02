package com.tencent.mm.plugin.appbrand.jsapi.map;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.map.i.5;
import com.tencent.mm.plugin.appbrand.q$f;

class i$5$1 implements Runnable {
    final /* synthetic */ double hyj;
    final /* synthetic */ double hyk;
    final /* synthetic */ 5 jmi;

    i$5$1(5 5, double d, double d2) {
        this.jmi = 5;
        this.hyj = d;
        this.hyk = d2;
    }

    public final void run() {
        View appbrandMapLocationPoint;
        View view = (View) this.jmi.jeN.get(this.jmi.jhi, null);
        if (view == null) {
            appbrandMapLocationPoint = new AppbrandMapLocationPoint(this.jmi.jfB.mContext);
            this.jmi.jmc.a(appbrandMapLocationPoint, this.hyj, this.hyk);
            this.jmi.jeN.o(this.jmi.jhi, appbrandMapLocationPoint);
        } else {
            appbrandMapLocationPoint = view;
        }
        if (appbrandMapLocationPoint instanceof AppbrandMapLocationPoint) {
            AppbrandMapLocationPoint appbrandMapLocationPoint2 = (AppbrandMapLocationPoint) appbrandMapLocationPoint;
            this.jmi.jmc.b(appbrandMapLocationPoint, this.hyj, this.hyk);
            appbrandMapLocationPoint2.jlO.setImageResource(q$f.itk);
            double d = this.hyj;
            double d2 = this.hyk;
            if (appbrandMapLocationPoint2.jlR == -1.0d && appbrandMapLocationPoint2.jlS == -1.0d) {
                appbrandMapLocationPoint2.jlR = d;
                appbrandMapLocationPoint2.jlP = d;
                appbrandMapLocationPoint2.jlS = d2;
                appbrandMapLocationPoint2.jlQ = d2;
                return;
            }
            appbrandMapLocationPoint2.jlR = appbrandMapLocationPoint2.jlP;
            appbrandMapLocationPoint2.jlS = appbrandMapLocationPoint2.jlQ;
            appbrandMapLocationPoint2.jlQ = d2;
            appbrandMapLocationPoint2.jlP = d;
        }
    }
}
