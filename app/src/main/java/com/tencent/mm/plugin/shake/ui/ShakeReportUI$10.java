package com.tencent.mm.plugin.shake.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.av.b;
import com.tencent.mm.plugin.shake.b.l;
import com.tencent.mm.plugin.shake.d.a.h;
import java.util.ArrayList;
import java.util.Collection;

class ShakeReportUI$10 implements AnimationListener {
    final /* synthetic */ ShakeReportUI qsi;

    ShakeReportUI$10(ShakeReportUI shakeReportUI) {
        this.qsi = shakeReportUI;
    }

    public final void onAnimationStart(Animation animation) {
        ShakeReportUI.c(this.qsi, false);
        ShakeReportUI.e(this.qsi, true);
        ShakeReportUI.f(this.qsi, false);
        ShakeReportUI.g(this.qsi, true);
        ShakeReportUI.z(this.qsi);
    }

    public final void onAnimationEnd(Animation animation) {
        ShakeReportUI.f(this.qsi, true);
        ShakeReportUI.g(this.qsi, false);
        if (!ShakeReportUI.A(this.qsi)) {
            ShakeReportUI.a(this.qsi, true);
            ShakeReportUI.d(this.qsi, true);
            ShakeReportUI.B(this.qsi);
            if (ShakeReportUI.C(this.qsi).qnP == 3) {
                b.Qo();
            } else if (ShakeReportUI.C(this.qsi).qnP == 5) {
                l.b bVar = ShakeReportUI.C(this.qsi).qnQ;
                if (bVar != null && (bVar instanceof h)) {
                    h hVar = (h) bVar;
                    Collection arrayList = new ArrayList();
                    arrayList.addAll(ShakeReportUI.bsy());
                    hVar.qpJ = arrayList;
                }
            }
            ShakeReportUI.C(this.qsi).qnQ.start();
        }
        ShakeReportUI.e(this.qsi, false);
    }

    public final void onAnimationRepeat(Animation animation) {
    }
}
