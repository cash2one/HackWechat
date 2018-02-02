package com.tencent.mm.plugin.sns.ui;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.QImageView.a;

class SnsTimeLineUI$a extends Animation {
    ListView nKG;
    final /* synthetic */ SnsTimeLineUI rIN;
    float rIY;
    float rIZ;
    float rJa = -1.0f;
    float rJb;
    float rJc = 0.0f;
    private float rJd;
    boolean rJe;
    int rJf;
    boolean rJg = false;
    int rJh = 0;
    float rJi = 0.0f;
    float rJj = 0.0f;

    public SnsTimeLineUI$a(SnsTimeLineUI snsTimeLineUI, ListView listView) {
        this.rIN = snsTimeLineUI;
        this.nKG = listView;
    }

    public final void bBS() {
        x.d("MicroMsg.SnsTimeLineUI", "animtest playLoading");
        if (SnsTimeLineUI.l(this.rIN).getVisibility() == 0) {
            init();
            this.rJc = this.rJa + 20.0f;
            LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.l(this.rIN).getLayoutParams();
            layoutParams.y = (int) this.rJa;
            SnsTimeLineUI.l(this.rIN).setLayoutParams(layoutParams);
            bBT();
        }
    }

    public final void bBT() {
        if (SnsTimeLineUI.l(this.rIN).getVisibility() == 0) {
            init();
            SnsTimeLineUI.l(this.rIN).clearAnimation();
            SnsTimeLineUI.l(this.rIN).startAnimation(this);
            if (this.rJc >= this.rJa) {
                setDuration(20000);
                this.rJe = false;
                return;
            }
            setDuration(600);
            this.rJe = true;
        }
    }

    final void init() {
        if (this.rJa == -1.0f || ((double) this.rIZ) < 0.1d) {
            this.rJa = (float) b.b(this.rIN, 25.0f);
            this.rIY = (float) (SnsTimeLineUI.l(this.rIN).getWidth() / 2);
            this.rIZ = (float) (SnsTimeLineUI.l(this.rIN).getHeight() / 2);
            this.rJb = (this.rIZ * -2.0f) - 3.0f;
            x.d("MicroMsg.SnsTimeLineUI", "MIN_Y" + this.rJb);
            this.rJc = this.rJb;
            if (!this.rJg) {
                x.i("MicroMsg.SnsTimeLineUI", "initState");
                this.rJh = ((LayoutParams) SnsTimeLineUI.l(this.rIN).getLayoutParams()).y;
                this.rJi = this.rJa;
                this.rJj = this.rJc;
            }
            this.rJg = true;
        }
    }

    protected final void applyTransformation(float f, Transformation transformation) {
        if (SnsTimeLineUI.l(this.rIN).getVisibility() == 0) {
            float duration = ((float) getDuration()) * (f - this.rJd);
            if (duration >= 2.0f) {
                this.rJd = f;
                SnsTimeLineUI.l(this.rIN).setImageResource(i.qIN);
                SnsTimeLineUI.l(this.rIN).a(a.MATRIX);
                if (((float) getDuration()) * f >= ((float) (getDuration() - 600)) || this.rJe) {
                    LayoutParams layoutParams = (LayoutParams) SnsTimeLineUI.l(this.rIN).getLayoutParams();
                    this.rJc = ((float) layoutParams.y) - (duration / 3.0f);
                    layoutParams.y = (int) this.rJc;
                    SnsTimeLineUI.l(this.rIN).setLayoutParams(layoutParams);
                } else {
                    SnsTimeLineUI.l(this.rIN).mMatrix.postRotate(duration / 2.5f, this.rIY, this.rIZ);
                }
                SnsTimeLineUI.l(this.rIN).invalidate();
            }
        }
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        super.initialize(i, i2, i3, i4);
        this.rJd = 0.0f;
        this.rJc = this.rJa;
    }
}
