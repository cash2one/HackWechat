package com.tencent.mm.plugin.bottle.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

class BottleImageView$1 extends Animation {
    private float kAW = -1.0f;
    private float kAX = -1.0f;
    private float kAY = -1.0f;
    private float kAZ = -1.0f;
    private float kBa = 1.0f;
    private float kBb = 0.1f;
    private float kCa;
    private float kCb;
    private float kCc;
    private float kCd;
    private float kCe;
    private boolean kCf = false;
    private float kCg = 0.0f;
    private float kCh = -850.0f;
    private float kCi = 1.0f;
    private float kCj = 0.3f;
    final /* synthetic */ BottleImageView kCk;

    BottleImageView$1(BottleImageView bottleImageView) {
        this.kCk = bottleImageView;
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (this.kAW == -1.0f) {
            this.kAW = (float) BottleImageView.c(this.kCk);
            this.kAX = (float) BottleImageView.d(this.kCk);
            this.kAY = (float) BottleImageView.e(this.kCk);
            this.kAZ = (float) BottleImageView.f(this.kCk);
            this.kCa = this.kAW + ((this.kAX - this.kAW) / 5.0f);
            this.kCb = this.kAW + (((this.kAX - this.kAW) * 3.0f) / 5.0f);
            this.kCc = ((((this.kCa - this.kAW) / (this.kAX - this.kAW)) * (this.kAZ - this.kAY)) + this.kAY) - ((float) b.b(BottleImageView.g(this.kCk), 67.0f));
            this.kCd = ((((this.kCb - this.kAW) / (this.kAX - this.kAW)) * (this.kAZ - this.kAY)) + this.kAY) - ((float) b.b(BottleImageView.g(this.kCk), 53.0f));
        }
        transformation.setAlpha(this.kCi + ((this.kCj - this.kCi) * f));
        float f2 = this.kBa + ((this.kBb - this.kBa) * f);
        transformation.getMatrix().setScale(f2, f2, (float) (BottleImageView.a(this.kCk) / 2), (float) (BottleImageView.b(this.kCk) / 2));
        transformation.getMatrix().postRotate(this.kCg + ((this.kCh - this.kCg) * f), (float) (BottleImageView.a(this.kCk) / 2), (float) (BottleImageView.b(this.kCk) / 2));
        float f3 = ((this.kAX - this.kAW) * f) + this.kAW;
        if (f3 >= this.kCa) {
            f2 = (((f3 - this.kAW) / (this.kCa - this.kAW)) * (this.kCc - this.kAY)) + this.kAY;
        } else if (f3 >= this.kCb) {
            if (!this.kCf) {
                this.kCf = true;
                this.kCc = this.kCe;
            }
            f2 = (((f3 - this.kCa) / (this.kCb - this.kCa)) * (this.kCd - this.kCc)) + this.kCc;
        } else {
            f2 = (((f3 - this.kCb) / (this.kAX - this.kCb)) * (this.kAZ - this.kCd)) + this.kCd;
        }
        this.kCe = f2;
        transformation.getMatrix().postTranslate(f3, f2);
        if (f == 1.0f) {
            this.kAW = -1.0f;
            this.kAX = -1.0f;
            this.kAY = -1.0f;
            this.kAZ = -1.0f;
            this.kCf = false;
        }
    }
}
