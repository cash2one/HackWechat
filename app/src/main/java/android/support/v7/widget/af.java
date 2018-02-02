package android.support.v7.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v7.b.a.a;
import android.support.v7.b.a.b;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

final class af extends Drawable {
    static a Ws;
    static final double jb = Math.cos(Math.toRadians(45.0d));
    final int Wr;
    final RectF Wt;
    Paint fC;
    Paint jc;
    Paint jd;
    float jf;
    Path jg;
    float jh;
    float ji;
    float jj;
    float jk;
    private boolean jl = true;
    private final int jm;
    private final int jo;
    boolean jp = true;
    private boolean jq = false;

    af(Resources resources, int i, float f, float f2, float f3) {
        this.jm = resources.getColor(a.IX);
        this.jo = resources.getColor(a.IW);
        this.Wr = resources.getDimensionPixelSize(b.IY);
        this.fC = new Paint(5);
        this.fC.setColor(i);
        this.jc = new Paint(5);
        this.jc.setStyle(Style.FILL);
        this.jf = (float) ((int) (f + 0.5f));
        this.Wt = new RectF();
        this.jd = new Paint(this.jc);
        this.jd.setAntiAlias(false);
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f2 + ". Must be >= 0");
        } else if (f3 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f3 + ". Must be >= 0");
        } else {
            float l = (float) l(f2);
            float l2 = (float) l(f3);
            if (l > l2) {
                if (!this.jq) {
                    this.jq = true;
                }
                l = l2;
            }
            if (this.jk != l || this.ji != l2) {
                this.jk = l;
                this.ji = l2;
                this.jj = (float) ((int) (((l * DownloadHelper.SAVE_FATOR) + ((float) this.Wr)) + 0.5f));
                this.jh = ((float) this.Wr) + l2;
                this.jl = true;
                invalidateSelf();
            }
        }
    }

    private static int l(float f) {
        int i = (int) (0.5f + f);
        if (i % 2 == 1) {
            return i - 1;
        }
        return i;
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
        this.jc.setAlpha(i);
        this.jd.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.jl = true;
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.ji, this.jf, this.jp));
        int ceil2 = (int) Math.ceil((double) b(this.ji, this.jf, this.jp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (DownloadHelper.SAVE_FATOR * f)) + ((1.0d - jb) * ((double) f2)));
        }
        return DownloadHelper.SAVE_FATOR * f;
    }

    static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - jb) * ((double) f2)));
        }
        return f;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        int i;
        int i2 = 1;
        if (this.jl) {
            Rect bounds = getBounds();
            f = this.ji * DownloadHelper.SAVE_FATOR;
            this.Wt.set(((float) bounds.left) + this.ji, ((float) bounds.top) + f, ((float) bounds.right) - this.ji, ((float) bounds.bottom) - f);
            RectF rectF = new RectF(-this.jf, -this.jf, this.jf, this.jf);
            RectF rectF2 = new RectF(rectF);
            rectF2.inset(-this.jj, -this.jj);
            if (this.jg == null) {
                this.jg = new Path();
            } else {
                this.jg.reset();
            }
            this.jg.setFillType(FillType.EVEN_ODD);
            this.jg.moveTo(-this.jf, 0.0f);
            this.jg.rLineTo(-this.jj, 0.0f);
            this.jg.arcTo(rectF2, 180.0f, 90.0f, false);
            this.jg.arcTo(rectF, 270.0f, -90.0f, false);
            this.jg.close();
            f = this.jf / (this.jf + this.jj);
            float[] fArr = new float[]{0.0f, f, 1.0f};
            f = 0.0f;
            this.jc.setShader(new RadialGradient(0.0f, f, this.jf + this.jj, new int[]{this.jm, this.jm, this.jo}, fArr, TileMode.CLAMP));
            float f2 = 0.0f;
            this.jd.setShader(new LinearGradient(0.0f, (-this.jf) + this.jj, f2, (-this.jf) - this.jj, new int[]{this.jm, this.jm, this.jo}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.jd.setAntiAlias(false);
            this.jl = false;
        }
        canvas.translate(0.0f, this.jk / 2.0f);
        f = (-this.jf) - this.jj;
        float f3 = (this.jf + ((float) this.Wr)) + (this.jk / 2.0f);
        if (this.Wt.width() - (2.0f * f3) > 0.0f) {
            i = 1;
        } else {
            boolean z = false;
        }
        if (this.Wt.height() - (2.0f * f3) <= 0.0f) {
            i2 = 0;
        }
        int save = canvas.save();
        canvas.translate(this.Wt.left + f3, this.Wt.top + f3);
        canvas.drawPath(this.jg, this.jc);
        if (i != 0) {
            canvas.drawRect(0.0f, f, this.Wt.width() - (2.0f * f3), -this.jf, this.jd);
        }
        canvas.restoreToCount(save);
        save = canvas.save();
        canvas.translate(this.Wt.right - f3, this.Wt.bottom - f3);
        canvas.rotate(180.0f);
        canvas.drawPath(this.jg, this.jc);
        if (i != 0) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(0.0f, f, this.Wt.width() - (2.0f * f3), this.jj + (-this.jf), this.jd);
        }
        canvas.restoreToCount(save);
        i = canvas.save();
        canvas.translate(this.Wt.left + f3, this.Wt.bottom - f3);
        canvas.rotate(270.0f);
        canvas.drawPath(this.jg, this.jc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.Wt.height() - (2.0f * f3), -this.jf, this.jd);
        }
        canvas.restoreToCount(i);
        i = canvas.save();
        canvas.translate(this.Wt.right - f3, this.Wt.top + f3);
        canvas.rotate(90.0f);
        canvas.drawPath(this.jg, this.jc);
        if (i2 != 0) {
            canvas.drawRect(0.0f, f, this.Wt.height() - (2.0f * f3), -this.jf, this.jd);
        }
        canvas.restoreToCount(i);
        canvas.translate(0.0f, (-this.jk) / 2.0f);
        Ws.a(canvas, this.Wt, this.jf, this.fC);
    }
}
