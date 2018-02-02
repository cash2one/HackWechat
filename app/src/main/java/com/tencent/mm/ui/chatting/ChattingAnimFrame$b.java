package com.tencent.mm.ui.chatting;

import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.c.a.a;
import com.tencent.mm.ui.c.a.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

class ChattingAnimFrame$b extends Animation {
    private int hX = 0;
    private float kBa;
    private float kBb;
    private float kBc;
    private float kBd;
    private float kBe;
    private float kBf;
    private OnLayoutChangeListener xGi = new 1(this);
    final /* synthetic */ ChattingAnimFrame yrn;
    private float yro;
    private float yrp;
    private float yrq;
    private float yrr;
    private int yrs = 0;
    private boolean yrt = false;

    public ChattingAnimFrame$b(ChattingAnimFrame chattingAnimFrame, int i, int i2) {
        this.yrn = chattingAnimFrame;
        this.yrs = i;
        this.hX = i2;
        this.yrt = false;
    }

    public ChattingAnimFrame$b(ChattingAnimFrame chattingAnimFrame, int i, int i2, boolean z) {
        this.yrn = chattingAnimFrame;
        this.yrs = i;
        this.hX = i2;
        this.yrt = z;
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        switch (this.yrs) {
            case 1:
                this.yro = ChattingAnimFrame.s(0.1f, 0.9f);
                this.yrp = ChattingAnimFrame.s(this.yro - 0.25f, this.yro + 0.25f);
                this.yrq = DownloadHelper.SAVE_FATOR;
                this.yrr = -0.2f;
                setInterpolator(new LinearInterpolator());
                break;
            case 2:
                this.yro = 0.0f;
                this.yrp = 0.0f;
                this.yrq = 0.0f;
                this.yrr = 1.0f;
                setInterpolator(new a());
                break;
            case 3:
                this.yro = 0.0f;
                this.yrp = 0.0f;
                this.yrq = DownloadHelper.SAVE_FATOR;
                if (this.yrt) {
                    this.yrr = ChattingAnimFrame.s(0.4f, 0.55f);
                } else {
                    this.yrr = ChattingAnimFrame.s(0.54999995f, 0.85f);
                }
                setInterpolator(new b());
                break;
            case 999:
                this.yro = ChattingAnimFrame.s(0.1f, 0.9f);
                this.yrp = ChattingAnimFrame.s(this.yro - 0.5f, this.yro + 0.5f);
                this.yrq = 0.0f;
                this.yrr = 0.0f;
                this.kBa = 0.8f;
                this.kBb = 1.1f;
                setInterpolator(new LinearInterpolator());
                break;
            default:
                this.yro = ChattingAnimFrame.s(0.1f, 0.9f);
                this.yrp = ChattingAnimFrame.s(this.yro - 0.5f, this.yro + 0.5f);
                this.yrq = -0.2f;
                this.yrr = 1.2f;
                setInterpolator(new LinearInterpolator());
                break;
        }
        if (!(this.yrs == 0 || this.yrs == 1)) {
            this.yrn.addOnLayoutChangeListener(this.xGi);
        }
        arI();
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        float f2 = this.kBc;
        float f3 = this.kBe;
        if (this.kBc != this.kBd) {
            f2 = this.kBc + ((this.kBd - this.kBc) * f);
        }
        if (this.kBe != this.kBf) {
            f3 = this.kBe + ((this.kBf - this.kBe) * f);
            if (this.yrs == 2) {
                f3 -= (float) this.hX;
            }
        }
        transformation.getMatrix().setTranslate(f2, f3);
        if (this.kBa != this.kBb && 3 == this.yrs) {
            f2 = this.kBa + ((this.kBb - this.kBa) * f);
            transformation.getMatrix().postScale(f2, f2);
        }
    }

    protected final void finalize() {
        super.finalize();
        x.i("MicroMsg.ChattingAnimFrame", "finalize!");
        this.yrn.removeOnLayoutChangeListener(this.xGi);
    }

    public final void arI() {
        this.kBc = this.yro * ((float) ChattingAnimFrame.a(this.yrn));
        this.kBd = this.yrp * ((float) ChattingAnimFrame.a(this.yrn));
        if (this.yrs == 2) {
            this.kBe = this.yrq * ((float) ChattingAnimFrame.b(this.yrn));
            this.kBf = this.yrr * ((float) ChattingAnimFrame.b(this.yrn));
        } else if (this.yrs == 3) {
            this.kBe = this.yrq * ((float) ChattingAnimFrame.c(this.yrn));
            this.kBf = this.yrr * ((float) ChattingAnimFrame.c(this.yrn));
            if (ChattingAnimFrame.d(this.yrn)) {
                this.kBe = (this.yrq * ((float) ChattingAnimFrame.c(this.yrn))) - ((float) ChattingAnimFrame.e(this.yrn));
                this.kBf = (this.yrr * ((float) ChattingAnimFrame.c(this.yrn))) - ((float) ChattingAnimFrame.e(this.yrn));
            }
            if (this.kBf < 0.0f) {
                this.kBf = 0.0f;
            }
        } else {
            this.kBe = this.yrq * ((float) ChattingAnimFrame.c(this.yrn));
            this.kBf = this.yrr * ((float) ChattingAnimFrame.c(this.yrn));
        }
    }
}
