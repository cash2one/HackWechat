package com.tencent.mm.plugin.sns.abtest;

import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b {
    int MP = 0;
    int jNd = 0;
    int mScreenHeight = 0;
    NotInterestMenu qNE;
    ViewGroup qNF;
    NotInterestMenu$b qNG = new 1(this);
    Animation qNH = null;
    Animation qNI = null;
    private Animation qNJ = null;
    private Animation qNK = null;
    int qNL = 0;
    int qNM = 0;
    int qNN = 0;
    int qNO = 0;
    int qNP = 0;
    boolean qNQ = false;
    AbsoluteLayout qNR = null;
    boolean qNS = false;
    boolean qNT = false;
    c qNz;

    public b(ViewGroup viewGroup) {
        this.qNF = viewGroup;
        this.qNH = AnimationUtils.loadAnimation(ac.getContext(), a.qyp);
        this.qNH.setFillAfter(true);
        this.qNH.setDuration(100);
        this.qNH.setAnimationListener(new 2(this));
        this.qNI = AnimationUtils.loadAnimation(ac.getContext(), a.qys);
        this.qNI.setFillAfter(true);
        this.qNI.setDuration(100);
        this.qNI.setAnimationListener(new 3(this));
        this.qNJ = AnimationUtils.loadAnimation(ac.getContext(), a.qyq);
        this.qNJ.setFillAfter(true);
        this.qNJ.setDuration(100);
        this.qNJ.setAnimationListener(new 4(this));
        this.qNK = AnimationUtils.loadAnimation(ac.getContext(), a.qyr);
        this.qNK.setFillAfter(true);
        this.qNK.setDuration(100);
        this.qNK.setAnimationListener(new 5(this));
    }

    public final void btT() {
        if (this.qNR != null && this.qNF != null && this.qNE != null) {
            this.qNR.removeView(this.qNE);
            this.qNF.removeView(this.qNR);
            this.qNR = null;
            this.qNE = null;
            this.qNQ = false;
        }
    }
}
