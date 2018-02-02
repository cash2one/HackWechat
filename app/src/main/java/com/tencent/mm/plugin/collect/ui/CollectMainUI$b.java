package com.tencent.mm.plugin.collect.ui;

import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

class CollectMainUI$b {
    final /* synthetic */ CollectMainUI lnh;
    boolean lnq;
    LinkedList<a> lnr;

    private CollectMainUI$b(CollectMainUI collectMainUI) {
        this.lnh = collectMainUI;
        this.lnr = new LinkedList();
    }

    public final void azy() {
        if (this.lnq) {
            x.d("MicroMsg.CollectMainUI.ToastAnimationHelper", "Animating, wait. QueueSize=" + this.lnr.size());
        } else if (!this.lnr.isEmpty()) {
            a aVar = (a) this.lnr.poll();
            this.lnq = true;
            CollectMainUI.i(this.lnh);
            CollectMainUI.l(this.lnh).setLayoutParams(new LayoutParams(CollectMainUI.g(this.lnh).getWidth(), CollectMainUI.g(this.lnh).getHeight()));
            if (this.lnh.lmJ) {
                CollectMainUI.l(this.lnh).setPadding(0, CollectMainUI.ayf(), 0, 0);
            } else {
                CollectMainUI.l(this.lnh).setPadding(0, CollectMainUI.azx(), 0, 0);
            }
            CollectMainUI.m(this.lnh).setText(i.b(this.lnh.mController.xIM, aVar.gBL, CollectMainUI.m(this.lnh).getTextSize()));
            b.a(CollectMainUI.n(this.lnh), aVar.username);
            CollectMainUI.o(this.lnh).setText(e.d(aVar.ljg, aVar.fpP));
            CollectMainUI.l(this.lnh).setVisibility(0);
            AnimationSet animationSet = new AnimationSet(false);
            animationSet.addAnimation(new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f));
            int i = 0;
            for (int i2 = 0; i2 < CollectMainUI.p(this.lnh).size(); i2++) {
                if (((a) CollectMainUI.p(this.lnh).get(i2)).fuI.equals(aVar.fuI)) {
                    i = i2;
                }
            }
            float aoH = (float) CollectMainUI.aoH();
            float height = 0.0f + ((float) (CollectMainUI.g(this.lnh).getHeight() / 2));
            if (CollectMainUI.k(this.lnh).getVisibility() == 0) {
                height += (float) CollectMainUI.k(this.lnh).getHeight();
            }
            height += (float) ((i * CollectMainUI.tC()) + (CollectMainUI.tC() / 2));
            int[] iArr = new int[2];
            CollectMainUI.g(this.lnh).getLocationInWindow(iArr);
            animationSet.addAnimation(new TranslateAnimation(0.0f, aoH, 0.0f, (float) ((int) (height + ((float) (iArr[1] - CollectMainUI.Uz()))))));
            animationSet.setDuration(300);
            animationSet.setInterpolator(new DecelerateInterpolator());
            animationSet.setAnimationListener(new 1(this, aVar));
            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(300);
            scaleAnimation.setInterpolator(new LinearInterpolator());
            scaleAnimation.setAnimationListener(new 2(this, animationSet));
            CollectMainUI.l(this.lnh).startAnimation(scaleAnimation);
        }
    }
}
