package android.support.design.widget;

import android.content.res.Resources;
import android.graphics.Canvas;
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
import android.support.design.a$c;
import android.support.v7.c.a.a;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

final class o extends a {
    static final double jb = Math.cos(Math.toRadians(45.0d));
    float fN;
    final Paint jc;
    final Paint jd;
    final RectF je;
    float jf;
    Path jg;
    float jh;
    float ji;
    float jj;
    float jk;
    private boolean jl = true;
    private final int jm;
    private final int jn;
    private final int jo;
    boolean jp = true;
    private boolean jq = false;

    public o(Resources resources, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.jm = resources.getColor(a$c.aV);
        this.jn = resources.getColor(a$c.aU);
        this.jo = resources.getColor(a$c.aT);
        this.jc = new Paint(5);
        this.jc.setStyle(Style.FILL);
        this.jf = (float) Math.round(f);
        this.je = new RectF();
        this.jd = new Paint(this.jc);
        this.jd.setAntiAlias(false);
        d(f2, f3);
    }

    private static int l(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    public final void setAlpha(int i) {
        super.setAlpha(i);
        this.jc.setAlpha(i);
        this.jd.setAlpha(i);
    }

    protected final void onBoundsChange(Rect rect) {
        this.jl = true;
    }

    final void d(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float l = (float) l(f);
        float l2 = (float) l(f2);
        if (l > l2) {
            if (!this.jq) {
                this.jq = true;
            }
            l = l2;
        }
        if (this.jk != l || this.ji != l2) {
            this.jk = l;
            this.ji = l2;
            this.jj = (float) Math.round(l * DownloadHelper.SAVE_FATOR);
            this.jh = l2;
            this.jl = true;
            invalidateSelf();
        }
    }

    public final boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) a(this.ji, this.jf, this.jp));
        int ceil2 = (int) Math.ceil((double) b(this.ji, this.jf, this.jp));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    public static float a(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) (DownloadHelper.SAVE_FATOR * f)) + ((1.0d - jb) * ((double) f2)));
        }
        return DownloadHelper.SAVE_FATOR * f;
    }

    public static float b(float f, float f2, boolean z) {
        if (z) {
            return (float) (((double) f) + ((1.0d - jb) * ((double) f2)));
        }
        return f;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void draw(Canvas canvas) {
        float f;
        if (this.jl) {
            Rect bounds = getBounds();
            float f2 = this.ji * DownloadHelper.SAVE_FATOR;
            this.je.set(((float) bounds.left) + this.ji, ((float) bounds.top) + f2, ((float) bounds.right) - this.ji, ((float) bounds.bottom) - f2);
            this.mDrawable.setBounds((int) this.je.left, (int) this.je.top, (int) this.je.right, (int) this.je.bottom);
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
            float f3 = -rectF2.top;
            if (f3 > 0.0f) {
                float f4 = this.jf / f3;
                f = f4 + ((1.0f - f4) / 2.0f);
                this.jc.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.jm, this.jn, this.jo}, new float[]{0.0f, f4, f, 1.0f}, TileMode.CLAMP));
            }
            this.jd.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.jm, this.jn, this.jo}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
            this.jd.setAntiAlias(false);
            this.jl = false;
        }
        int save = canvas.save();
        canvas.rotate(this.fN, this.je.centerX(), this.je.centerY());
        float f5 = (-this.jf) - this.jj;
        f = this.jf;
        Object obj = this.je.width() - (2.0f * f) > 0.0f ? 1 : null;
        Object obj2 = this.je.height() - (2.0f * f) > 0.0f ? 1 : null;
        float f6 = f / ((this.jk - (this.jk * 0.5f)) + f);
        float f7 = f / ((this.jk - (this.jk * 0.25f)) + f);
        float f8 = f / (f + (this.jk - (this.jk * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.je.left + f, this.je.top + f);
        canvas.scale(f6, f7);
        canvas.drawPath(this.jg, this.jc);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.je.width() - (2.0f * f), -this.jf, this.jd);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.je.right - f, this.je.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(180.0f);
        canvas.drawPath(this.jg, this.jc);
        if (obj != null) {
            canvas.scale(1.0f / f6, 1.0f);
            canvas.drawRect(0.0f, f5, this.je.width() - (2.0f * f), this.jj + (-this.jf), this.jd);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.je.left + f, this.je.bottom - f);
        canvas.scale(f6, f8);
        canvas.rotate(270.0f);
        canvas.drawPath(this.jg, this.jc);
        if (obj2 != null) {
            canvas.scale(1.0f / f8, 1.0f);
            canvas.drawRect(0.0f, f5, this.je.height() - (2.0f * f), -this.jf, this.jd);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.je.right - f, this.je.top + f);
        canvas.scale(f6, f7);
        canvas.rotate(90.0f);
        canvas.drawPath(this.jg, this.jc);
        if (obj2 != null) {
            canvas.scale(1.0f / f7, 1.0f);
            canvas.drawRect(0.0f, f5, this.je.height() - (2.0f * f), -this.jf, this.jd);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
        super.draw(canvas);
    }
}
