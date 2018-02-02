package com.tencent.mm.plugin.sns.ui;

import android.os.StrictMode;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.al.a;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.a.a.c;
import com.tencent.mm.plugin.sns.ui.j.1;
import com.tencent.mm.protocal.c.bjv;

class j$1$2 implements Runnable {
    final /* synthetic */ View jLA;
    final /* synthetic */ 1 rrN;
    final /* synthetic */ m rrO;
    final /* synthetic */ c rrP;

    j$1$2(1 1, m mVar, c cVar, View view) {
        this.rrN = 1;
        this.rrO = mVar;
        this.rrP = cVar;
        this.jLA = view;
    }

    public final void run() {
        if (this.rrN.rrK.rrt != null) {
            this.rrN.rrK.rrt.qWT.u(this.rrO);
        }
        if (this.rrP.rNE == 0) {
            bjv n = ai.n(this.rrO);
            b iu = b.iu(707);
            iu.mB(i.g(this.rrO)).ix(this.rrO.field_type).bU(this.rrO.xl(32)).mB(this.rrO.byA()).mB(this.rrO.field_userName).ix(n.wMY).ix(n.wNb);
            iu.Sx();
            StrictMode.allowThreadDiskReads();
            this.rrP.rNE = 1;
            this.rrO.field_likeFlag = this.rrP.rNE;
            h.a(this.rrO.bxW(), this.rrO);
            ((TextView) this.jLA.findViewById(f.qBe)).setText(j.qKX);
            a.a(this.rrO, this.rrO.xl(32) ? 7 : 1, "");
        } else {
            this.rrP.rNE = 0;
            this.rrO.field_likeFlag = this.rrP.rNE;
            h.a(this.rrO.bxW(), this.rrO);
            ((TextView) this.jLA.findViewById(f.qBe)).setText(j.qLx);
            a.Kq(this.rrO.bxW());
        }
        av avVar = this.rrN.rrK.qZU;
        LinearLayout linearLayout = (LinearLayout) this.jLA;
        Runnable 1 = new 1(this);
        ImageView imageView = (ImageView) linearLayout.findViewById(f.qBc);
        Animation scaleAnimation = new ScaleAnimation(0.9f, 1.2f, 0.9f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setStartOffset(100);
        scaleAnimation.setRepeatCount(0);
        imageView.clearAnimation();
        imageView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new av$7(avVar, linearLayout, 1));
    }
}
