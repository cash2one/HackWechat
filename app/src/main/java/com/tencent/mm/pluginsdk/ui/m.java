package com.tencent.mm.pluginsdk.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Random;

public final class m extends Drawable {
    private Context context;
    private Paint iYm = new Paint(1);
    private ValueAnimator jWC = ValueAnimator.ofFloat(new float[]{0.0f, 100.0f});
    private Random random = new Random(System.currentTimeMillis());
    private int vlA;
    private int vlB;
    private int vlC;
    private int vlD = 2;
    private RectF vlE;
    private Drawable vle = null;
    private int vlf = 0;
    private int vlg = 0;
    private Interpolator vlh = new LinearInterpolator();
    private Interpolator vli = new AccelerateDecelerateInterpolator();
    private int vlj;
    private int vlk;
    private int vll;
    private int vlm;
    private int vln;
    private int vlo;
    private int vlp;
    private int vlq;
    private int vlr;
    private int vls;
    private int vlt = 0;
    private float vlu = 0.0f;
    private float vlv = -90.0f;
    private float vlw = 0.0f;
    private float vlx = 0.0f;
    private float vly = 5.0f;
    private boolean vlz = false;

    public m(Context context) {
        this.jWC.setInterpolator(this.vlh);
        this.jWC.addUpdateListener(new 1(this));
        this.vlE = new RectF();
        this.context = context;
        this.vlf = a.c(context, R.e.bui);
        this.vlg = a.c(context, R.e.bts);
        this.vle = context.getResources().getDrawable(R.k.dBx);
        this.vlm = a.ab(context, R.f.byp);
        this.vln = a.ab(context, R.f.byo);
        this.vlo = a.ab(context, R.f.byi);
        this.vlt = a.ab(context, R.f.byn);
        this.vlk = a.c(context, R.e.btZ);
        this.vll = a.ab(context, R.f.byk);
        this.vlr = a.ab(context, R.f.byj);
        this.vls = a.c(context, R.e.bua);
        this.vlA = this.vlr;
        this.vlB = this.vlA;
        this.vlC = a.ab(context, R.f.bym);
        this.vlp = a.ab(context, R.f.bym);
        this.vlq = a.ab(context, R.f.byl);
        this.vlj = a.ab(context, R.f.byq);
    }

    public final void caq() {
        x.d("MicroMsg.VoiceInputDrawable", "longClickState %s", Integer.valueOf(this.vlD));
        this.vlD = 7;
        this.jWC.cancel();
        this.vlu = 0.0f;
        invalidateSelf();
    }

    public final void car() {
        x.d("MicroMsg.VoiceInputDrawable", "readyState %s", Integer.valueOf(this.vlD));
        this.vlD = 2;
        this.jWC.cancel();
        this.vlu = 0.0f;
        this.vlv = -90.0f;
        this.vlw = 0.0f;
        this.vlx = 0.0f;
        this.vly = 5.0f;
        invalidateSelf();
    }

    public final void cas() {
        x.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", Integer.valueOf(this.vlD));
        this.vlD = 6;
        this.jWC.cancel();
        this.vlu = 0.0f;
        invalidateSelf();
    }

    public final void kU(boolean z) {
        x.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", Integer.valueOf(0), Boolean.valueOf(z));
        if (!z) {
            this.vlD = 3;
        }
        this.vlz = true;
        invalidateSelf();
    }

    public final void BS(int i) {
        boolean z = true;
        x.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", Integer.valueOf(i));
        if (i >= 28) {
            z = false;
        }
        this.vlz = z;
        invalidateSelf();
    }

    public final void cat() {
        x.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", Integer.valueOf(this.vlD));
        this.vlD = 4;
        this.jWC.cancel();
        this.vlu = 0.0f;
        this.jWC.setInterpolator(new AccelerateDecelerateInterpolator());
        this.jWC.setDuration(1000);
        this.jWC.setRepeatCount(-1);
        this.jWC.start();
    }

    public final void cau() {
        x.d("MicroMsg.VoiceInputDrawable", "disableState %s", Integer.valueOf(this.vlD));
        this.vlD = 5;
        this.jWC.cancel();
        this.vlu = 0.0f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        int width;
        int height;
        if ((this.vlD == 6 || this.vlD == 7) && !i(canvas)) {
            width = canvas.getWidth() >> 1;
            height = canvas.getHeight() >> 1;
            this.iYm.setShader(null);
            this.iYm.setStyle(Style.FILL);
            this.iYm.setColor(this.vlk);
            if (this.vlD == 7) {
                if (this.vlz) {
                    this.vlC -= 4;
                } else {
                    this.vlC += 4;
                }
                this.vlC = Math.min(Math.max(this.vlp, this.vlC), this.vlq);
                canvas.drawCircle((float) width, (float) height, (float) this.vlC, this.iYm);
            } else {
                canvas.drawCircle((float) width, (float) height, (float) this.vlp, this.iYm);
            }
        }
        if (!(this.vle == null || i(canvas))) {
            if (this.vlD == 5) {
                this.vle.setColorFilter(this.vlg, Mode.SRC_ATOP);
            } else {
                this.vle.setColorFilter(this.vlf, Mode.SRC_ATOP);
            }
            width = canvas.getWidth() / 2;
            height = canvas.getHeight() / 2;
            this.vle.setBounds(width - this.vlt, height - this.vlt, width + this.vlt, height + this.vlt);
            this.vle.draw(canvas);
        }
        if (this.vlD == 4 && canvas != null) {
            this.iYm.setColor(this.vlf);
            this.iYm.setStrokeWidth((float) this.vlj);
            this.iYm.setStyle(Style.STROKE);
            this.iYm.clearShadowLayer();
            this.iYm.setShader(null);
            this.vlE.left = (float) ((canvas.getWidth() / 2) - this.vlr);
            this.vlE.top = (float) ((canvas.getHeight() / 2) - this.vlr);
            this.vlE.right = (float) ((canvas.getWidth() / 2) + this.vlr);
            this.vlE.bottom = (float) ((canvas.getHeight() / 2) + this.vlr);
            canvas.drawArc(this.vlE, this.vlv, this.vlx, false, this.iYm);
            this.vlv += this.vlw;
            this.vlx += this.vly;
            if (this.vlx >= 360.0f) {
                this.vly = -this.vly;
                this.vlw = 5.0f;
            } else if (this.vlx <= 0.0f) {
                this.vly = -this.vly;
                this.vlw = 0.0f;
                this.vlv = -90.0f;
                this.vlx = 0.0f;
            }
        }
        if ((this.vlD == 6 || this.vlD == 7) && !i(canvas)) {
            this.iYm.setStyle(Style.FILL);
            this.iYm.setColor(this.vls);
            canvas.drawCircle((float) (canvas.getWidth() >> 1), (float) (canvas.getHeight() >> 1), (float) this.vlt, this.iYm);
        }
    }

    public final void setAlpha(int i) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public final int getIntrinsicWidth() {
        if (this.context == null) {
            return 0;
        }
        return a.eA(this.context);
    }

    public final int getIntrinsicHeight() {
        return this.vlt * 2;
    }

    public final int getOpacity() {
        return -3;
    }

    private static boolean i(Canvas canvas) {
        return canvas == null || canvas.getWidth() == 0 || canvas.getHeight() == 0;
    }
}
