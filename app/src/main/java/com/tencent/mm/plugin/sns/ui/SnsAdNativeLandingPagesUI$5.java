package com.tencent.mm.plugin.sns.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.plugin.sns.ui.b.2;
import com.tencent.mm.plugin.sns.ui.b.b;
import java.util.Iterator;
import java.util.LinkedList;

class SnsAdNativeLandingPagesUI$5 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesUI ryv;

    SnsAdNativeLandingPagesUI$5(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        this.ryv = snsAdNativeLandingPagesUI;
    }

    public final void run() {
        SnsAdNativeLandingPagesUI.N(this.ryv);
        SnsAdNativeLandingPagesUI.O(this.ryv);
        this.ryv.rxG.r(SnsAdNativeLandingPagesUI.P(this.ryv), SnsAdNativeLandingPagesUI.Q(this.ryv), SnsAdNativeLandingPagesUI.R(this.ryv), SnsAdNativeLandingPagesUI.S(this.ryv));
        b bVar = this.ryv.rxG;
        View T = SnsAdNativeLandingPagesUI.T(this.ryv);
        LinkedList U = SnsAdNativeLandingPagesUI.U(this.ryv);
        View V = SnsAdNativeLandingPagesUI.V(this.ryv);
        b 1 = new 1(this);
        if (VERSION.SDK_INT >= 12 && T != null && bVar.rpS != bVar.rpP && bVar.rpS != bVar.rpR && bVar.rpS != bVar.rpO) {
            T.getLocationOnScreen(new int[2]);
            bVar.i(T, true);
            if (V != null) {
                V.animate().setDuration(300).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
            }
            Animation animationSet = new AnimationSet(true);
            Animation 2 = new 2(bVar, bVar.rpF, bVar.rpF, T, null);
            2.setDuration(300);
            2.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(2);
            2 = new TranslateAnimation(0.0f, (float) bVar.rpB, 0.0f, (float) bVar.rpC);
            2.setDuration(300);
            2.setInterpolator(new DecelerateInterpolator(1.2f));
            animationSet.addAnimation(2);
            animationSet.setFillAfter(true);
            animationSet.setAnimationListener(new b$3(bVar, 1));
            T.startAnimation(animationSet);
            Iterator it = U.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setAlpha(0.0f);
            }
        }
    }
}
