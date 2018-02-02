package com.tencent.mm.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public final class g {
    private int Wu = 0;
    private final Context context;
    private af mHandler = new af();
    int mHeight = 0;
    int mWidth = 0;
    int rpA = 0;
    private int rpB = 0;
    private int rpC = 0;
    private float rpD = 0.0f;
    private float rpE = 0.0f;
    float rpF = 0.0f;
    float rpG = 1.0f;
    public int rpH = 0;
    public int rpI = 0;
    public int rpJ = 0;
    public int rpK = 0;
    public int rpL = 0;
    private int rpM = 300;
    int rpN = 0;
    int rpO = 1;
    int rpP = 2;
    int rpQ = 3;
    int rpR = 4;
    int rpS = this.rpN;
    private int rpy = 0;
    int rpz = 0;
    float zkK = 0.0f;
    private float zkL = 1.0f;
    public float zkM = 1.0f;
    private int zkN = 0;
    int zkO = 0;
    private int zkP = 10;

    public g(Context context) {
        this.context = context;
    }

    public final void r(int i, int i2, int i3, int i4) {
        this.Wu = i;
        this.rpy = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    public final void fg(int i, int i2) {
        this.rpz = i;
        this.rpA = i2;
    }

    public final void fh(int i, int i2) {
        this.zkN = i;
        this.zkO = i2;
    }

    private void i(View view, boolean z) {
        int i;
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (this.Wu == 0 && this.rpy == 0) {
            this.Wu = view.getWidth() / 2;
            this.rpy = view.getHeight() / 2;
        }
        this.rpB = this.Wu - iArr[0];
        this.rpC = this.rpy - iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (width == 0 || height == 0) {
            width = this.rpz;
            i = this.rpA;
            height = width;
        } else {
            i = height;
            height = width;
        }
        if (!(height == 0 || i == 0)) {
            this.rpD = ((float) this.mWidth) / ((float) height);
            this.rpE = ((float) this.mHeight) / ((float) i);
        }
        float f = this.zkL;
        if (!(this.rpI == 0 && this.rpJ == 0 && this.rpK == 0 && this.rpL == 0)) {
            f = 1.1f;
        }
        if (z) {
            if (!(this.rpz == 0 || this.rpA == 0)) {
                this.rpD = ((float) this.mWidth) / ((float) this.rpz);
                this.rpE = ((float) this.mHeight) / ((float) this.rpA);
            }
            f = 1.0f;
        }
        if (((double) this.zkM) != 1.0d) {
            this.rpB += iArr[0];
            this.rpC += iArr[1];
            this.rpF = this.rpD * this.zkM;
            this.zkK = this.rpF;
            this.rpC = (int) (((float) this.rpC) - (((float) this.zkO) * this.rpF));
            this.rpB = (int) (((float) this.rpB) - (((float) this.zkN) * this.rpF));
            return;
        }
        if (this.rpD > this.rpE) {
            this.rpF = this.rpD * f;
            this.rpC = (int) (((float) this.rpC) - (((((float) i) * this.rpF) - (((float) this.mHeight) * f)) / 2.0f));
        } else {
            this.rpF = this.rpE * f;
            this.rpB = (int) (((float) this.rpB) - (((((float) height) * this.rpF) - (((float) this.mWidth) * f)) / 2.0f));
            if (this.rpA != 0 && this.rpA < i) {
                this.rpC = (int) (((float) this.rpC) - (((((float) i) * this.rpF) - (((float) this.mHeight) * f)) / 2.0f));
            }
        }
        this.rpC = (int) ((((float) this.rpC) - ((((float) this.mHeight) * (f - 1.0f)) / 2.0f)) - ((((float) this.rpH) * this.rpF) / 2.0f));
        this.rpB = (int) (((float) this.rpB) - ((((float) this.mWidth) * (f - 1.0f)) / 2.0f));
        if (this.rpA != 0 && this.rpy < (i - this.rpA) / 2) {
            this.rpC = (int) ((((f - 1.0f) * ((float) this.mHeight)) / 2.0f) + ((float) this.rpC));
        } else if (this.rpA != 0 && this.rpy + this.mHeight > (this.rpA + i) / 2) {
            this.rpC = (int) (((float) this.rpC) - (((f - 1.0f) * ((float) this.mHeight)) / 2.0f));
        }
        if (this.mWidth == 0 && this.mHeight == 0) {
            this.rpF = 0.5f;
            this.rpG = 0.0f;
            this.rpB = (int) (((float) this.rpB) - ((((float) height) * this.rpF) / 2.0f));
            this.rpC = (int) ((((float) this.rpC) - ((((float) i) * this.rpF) / 2.0f)) - ((((float) this.rpH) * this.rpF) / 2.0f));
        }
    }

    @TargetApi(16)
    public final void a(View view, View view2, b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.rpS != this.rpP && this.rpS != this.rpR && this.rpS != this.rpQ) {
            i(view, false);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.rpF);
            view.setScaleY(this.rpF);
            view.setTranslationX((float) this.rpB);
            view.setTranslationY((float) this.rpC);
            if (view2 != null) {
                view2.setAlpha(0.0f);
                view2.animate().setDuration((long) this.rpM).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
            }
            view.animate().setDuration((long) this.rpM).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new 1(this, bVar));
            this.mHandler.postDelayed(new 2(this, view), (long) this.zkP);
        }
    }

    @TargetApi(16)
    public final void a(View view, View view2, b bVar, a aVar) {
        if (VERSION.SDK_INT < 12 || view == null || this.rpS == this.rpP || this.rpS == this.rpR || this.rpS == this.rpO) {
            x.i("MicroMsg.ImagePreviewAnimation", "ExitAnimation not run! animationState: %s , gallery:%s", new Object[]{Integer.valueOf(this.rpS), view});
            return;
        }
        i(view, true);
        if (view2 != null) {
            view2.animate().setDuration(200).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
        }
        Animation animationSet = new AnimationSet(true);
        Animation 3 = new 3(this, this.rpF, this.rpF, view, aVar);
        3.setDuration(200);
        3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(3);
        3 = new TranslateAnimation(0.0f, (float) this.rpB, 0.0f, (float) this.rpC);
        3.setDuration(200);
        3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(3);
        3 = new AlphaAnimation(1.0f, this.rpG);
        3.setDuration(200);
        3.setInterpolator(new DecelerateInterpolator(1.2f));
        animationSet.addAnimation(3);
        animationSet.setFillAfter(true);
        animationSet.setAnimationListener(new 4(this, bVar));
        view.startAnimation(animationSet);
    }
}
