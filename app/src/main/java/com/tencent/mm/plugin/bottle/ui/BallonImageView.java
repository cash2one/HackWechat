package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.a;

public class BallonImageView extends ImageView {
    private Animation kAV = new Animation(this) {
        private int iQI;
        private int iQJ;
        private float kAW = 0.1f;
        private float kAX = AnonymousClass1.s(0.1f, 0.8f);
        private float kAY = 0.1f;
        private float kAZ = AnonymousClass1.s(0.1f, 0.3f);
        private float kBa = 1.0f;
        private float kBb = AnonymousClass1.s(0.7f, 1.0f);
        private float kBc;
        private float kBd;
        private float kBe;
        private float kBf;
        final /* synthetic */ BallonImageView kBg;

        {
            this.kBg = r4;
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            float f2 = this.kBc;
            float f3 = this.kBe;
            if (this.kBc != this.kBd) {
                f2 = this.kBc + ((this.kBd - this.kBc) * f);
            }
            if (this.kBe != this.kBf) {
                f3 = this.kBe + ((this.kBf - this.kBe) * f);
            }
            transformation.getMatrix().setTranslate(f2, f3);
            f2 = this.kBa + ((this.kBb - this.kBa) * f);
            transformation.getMatrix().postScale(f2, f2);
            if (f == 1.0f) {
                this.kAW = this.kAX;
                this.kAY = this.kAZ;
                this.kAX = AnonymousClass1.s(0.1f, 0.8f);
                this.kAZ = AnonymousClass1.s(0.1f, 0.3f);
                this.kBa = this.kBb;
                this.kBb = AnonymousClass1.s(0.7f, 1.0f);
                arI();
            }
        }

        public final void initialize(int i, int i2, int i3, int i4) {
            super.initialize(i, i2, i3, i4);
            this.iQI = i3;
            this.iQJ = i4;
            arI();
        }

        private void arI() {
            this.kBc = this.kAW * ((float) this.iQI);
            this.kBd = this.kAX * ((float) this.iQI);
            this.kBe = this.kAY * ((float) this.iQJ);
            this.kBf = this.kAZ * ((float) this.iQJ);
        }

        private static float s(float f, float f2) {
            return (((float) Math.random()) * (f2 - f)) + f;
        }
    };

    public BallonImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.kAV.setRepeatCount(-1);
        this.kAV.setDuration(15000);
        this.kAV.setFillAfter(true);
    }

    public BallonImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.kAV.setRepeatCount(-1);
        this.kAV.setDuration(15000);
        this.kAV.setFillAfter(true);
    }

    public void setVisibility(int i) {
        if (i == 0) {
            setAnimation(this.kAV);
        } else {
            a.c(this, this.kAV);
        }
        super.setVisibility(i);
    }
}
