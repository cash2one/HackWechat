package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.b.b;

class d extends Drawable {
    final Paint fC = new Paint(1);
    final Rect fD = new Rect();
    final RectF fE = new RectF();
    float fF;
    int fG;
    int fH;
    int fI;
    int fJ;
    private ColorStateList fK;
    private int fL;
    boolean fM = true;
    float fN;

    public d() {
        this.fC.setStyle(Style.STROKE);
    }

    public void draw(Canvas canvas) {
        float height;
        if (this.fM) {
            Paint paint = this.fC;
            Rect rect = this.fD;
            copyBounds(rect);
            height = this.fF / ((float) rect.height());
            float f = 0.0f;
            paint.setShader(new LinearGradient(0.0f, (float) rect.top, f, (float) rect.bottom, new int[]{b.l(this.fG, this.fL), b.l(this.fH, this.fL), b.l(b.m(this.fH, 0), this.fL), b.l(b.m(this.fJ, 0), this.fL), b.l(this.fJ, this.fL), b.l(this.fI, this.fL)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP));
            this.fM = false;
        }
        height = this.fC.getStrokeWidth() / 2.0f;
        RectF rectF = this.fE;
        copyBounds(this.fD);
        rectF.set(this.fD);
        rectF.left += height;
        rectF.top += height;
        rectF.right -= height;
        rectF.bottom -= height;
        canvas.save();
        canvas.rotate(this.fN, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.fC);
        canvas.restore();
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.fF);
        rect.set(round, round, round, round);
        return true;
    }

    public void setAlpha(int i) {
        this.fC.setAlpha(i);
        invalidateSelf();
    }

    final void c(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.fL = colorStateList.getColorForState(getState(), this.fL);
        }
        this.fK = colorStateList;
        this.fM = true;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public int getOpacity() {
        return this.fF > 0.0f ? -3 : -2;
    }

    protected void onBoundsChange(Rect rect) {
        this.fM = true;
    }

    public boolean isStateful() {
        return (this.fK != null && this.fK.isStateful()) || super.isStateful();
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.fK != null) {
            int colorForState = this.fK.getColorForState(iArr, this.fL);
            if (colorForState != this.fL) {
                this.fM = true;
                this.fL = colorForState;
            }
        }
        if (this.fM) {
            invalidateSelf();
        }
        return this.fM;
    }
}
