package com.tencent.mm.plugin.sns.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.af;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private int Wu = 0;
    private final Context context;
    private af mHandler = new af();
    int mHeight = 0;
    int mWidth = 0;
    int rpA = 0;
    int rpB = 0;
    int rpC = 0;
    private float rpD = 0.0f;
    private float rpE = 0.0f;
    float rpF = 0.0f;
    float rpG = 1.0f;
    int rpH = 0;
    int rpI = 0;
    int rpJ = 0;
    int rpK = 0;
    int rpL = 0;
    private int rpM = 300;
    private int rpN = 0;
    int rpO = 1;
    int rpP = 2;
    int rpQ = 3;
    int rpR = 4;
    int rpS = this.rpN;
    private int rpy = 0;
    int rpz = 0;

    public b(Context context) {
        this.context = context;
    }

    public final void r(int i, int i2, int i3, int i4) {
        this.Wu = i;
        this.rpy = i2;
        this.mWidth = i3;
        this.mHeight = i4;
    }

    final void i(View view, boolean z) {
        int i;
        float f;
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
        if (this.rpI == 0 && this.rpJ == 0 && this.rpK == 0 && this.rpL == 0) {
            f = 1.0f;
        } else {
            f = 1.1f;
        }
        if (z) {
            if (!(this.rpz == 0 || this.rpA == 0)) {
                this.rpD = ((float) this.mWidth) / ((float) this.rpz);
                this.rpE = ((float) this.mHeight) / ((float) this.rpA);
            }
            f = 1.0f;
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
    public final void a(View view, LinkedList<View> linkedList, View view2, b bVar) {
        if (VERSION.SDK_INT >= 12 && view != null && this.rpS != this.rpP && this.rpS != this.rpR && this.rpS != this.rpQ) {
            i(view, false);
            e.eb(this.context);
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            view.setScaleX(this.rpF);
            view.setScaleY(this.rpF);
            view.setTranslationX((float) this.rpB);
            view.setTranslationY((float) this.rpC);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration((long) this.rpM);
            animatorSet.setInterpolator(new DecelerateInterpolator(1.2f));
            Builder play = animatorSet.play(ObjectAnimator.ofFloat(view2, View.ALPHA, new float[]{0.0f, 1.0f}));
            Animator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{view.getScaleX(), 1.0f});
            Animator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{view.getScaleY(), 1.0f});
            Animator ofFloat3 = ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{view.getTranslationX(), 0.0f});
            play.with(ofFloat).with(ofFloat2).with(ofFloat3).with(ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{view.getTranslationY(), 0.0f}));
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                View view3 = (View) it.next();
                view3.setAlpha(0.0f);
                view3.setVisibility(0);
                view3.setTranslationY(100.0f);
                ofFloat3 = ObjectAnimator.ofFloat(view3, View.ALPHA, new float[]{0.0f, 1.0f});
                ofFloat = ObjectAnimator.ofFloat(view3, View.TRANSLATION_Y, new float[]{view3.getTranslationY(), 0.0f});
                ofFloat3.setDuration((long) (this.rpM >>> 1));
                ofFloat.setDuration((long) (this.rpM >>> 1));
                play.before(ofFloat3);
                play.before(ofFloat);
            }
            animatorSet.addListener(new 1(this, bVar));
            animatorSet.start();
        }
    }
}
