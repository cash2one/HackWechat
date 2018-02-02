package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.bx.c;
import com.tencent.mm.bx.g;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public class ShakeEggAnimFrame extends FrameLayout {
    List<View> qqk = new ArrayList();
    int qql = 0;
    int size = 0;

    class b extends a {
        private int iQI;
        private int iQJ;
        final /* synthetic */ ShakeEggAnimFrame qqm;
        private float qqo;
        private float qqp;
        private float qqq;
        private float qqr;
        private float qqs = 0.01f;
        private float qqt = 0.02f;
        private float qqu;
        private float qqv;
        private float qqw;
        private float qqx;

        public b(ShakeEggAnimFrame shakeEggAnimFrame, int i, int i2) {
            this.qqm = shakeEggAnimFrame;
            super(shakeEggAnimFrame);
            this.iQI = i;
            this.iQJ = i2;
            this.qqo = ShakeEggAnimFrame.s(0.1f, 0.9f);
            this.qqp = this.qqo;
            this.qqr = ShakeEggAnimFrame.s(-0.3f, -0.1f);
            restart();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.qqu;
            float f3 = this.qqw;
            if (this.qqu != this.qqv) {
                f2 = this.qqu + ((this.qqv - this.qqu) * f);
            }
            if (this.qqw != this.qqx) {
                f3 = this.qqw + ((this.qqx - this.qqw) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            if (f == 1.0f) {
                restart();
            }
        }

        private void restart() {
            if (this.qqr > 0.0f) {
                this.qqt += this.qqs;
            }
            this.qqq = this.qqr;
            this.qqr += this.qqt;
            if (this.qqq > 1.1f) {
                Assert.assertTrue(this.targetView != null);
                this.targetView.post(new 1(this));
            }
            this.qqu = this.qqo * ((float) this.iQI);
            this.qqv = this.qqp * ((float) this.iQI);
            this.qqw = this.qqq * ((float) this.iQJ);
            this.qqx = this.qqr * ((float) this.iQJ);
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            setRepeatCount(-1);
            setDuration((long) this.duration);
        }
    }

    public ShakeEggAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void J(Activity activity) {
        for (View view : this.qqk) {
            view.clearAnimation();
            removeView(view);
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        setVisibility(0);
        for (int i = 0; i < 30; i++) {
            Animation bVar = new b(this, displayMetrics.widthPixels, displayMetrics.heightPixels);
            g.chg();
            com.tencent.mm.bx.b cgX = com.tencent.mm.bx.b.cgX();
            Drawable a = cgX.a((c) cgX.xkA.get(107));
            a.setBounds(0, 0, getSize(), getSize());
            ImageSpan imageSpan = new ImageSpan(a, 1);
            CharSequence spannableString = new SpannableString("  ");
            spannableString.setSpan(imageSpan, 0, 1, 33);
            View textView = new TextView(getContext());
            textView.setSingleLine();
            textView.setText(spannableString);
            textView.setAnimation(bVar);
            textView.setTag(bVar);
            addView(textView);
            ((a) bVar).targetView = textView;
            this.qqk.add(textView);
        }
    }

    static float s(float f, float f2) {
        return (((float) Math.random()) * (f2 - f)) + f;
    }

    private int getSize() {
        if (this.size == 0) {
            return (int) (((double) new TextView(getContext()).getTextSize()) * 1.2d);
        }
        return this.size;
    }
}
