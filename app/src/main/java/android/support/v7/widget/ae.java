package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

final class ae extends Drawable {
    float Wl;
    private final RectF Wm;
    private final Rect Wn;
    float Wo;
    boolean Wp = false;
    boolean Wq = true;
    private final Paint fC;
    private PorterDuffColorFilter mq;
    private ColorStateList no;
    private Mode np;

    public ae(int i, float f) {
        this.Wl = f;
        this.fC = new Paint(5);
        this.fC.setColor(i);
        this.Wm = new RectF();
        this.Wn = new Rect();
    }

    public final void draw(Canvas canvas) {
        Object obj;
        Paint paint = this.fC;
        if (this.mq == null || paint.getColorFilter() != null) {
            obj = null;
        } else {
            paint.setColorFilter(this.mq);
            obj = 1;
        }
        canvas.drawRoundRect(this.Wm, this.Wl, this.Wl, paint);
        if (obj != null) {
            paint.setColorFilter(null);
        }
    }

    final void f(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.Wm.set((float) rect.left, (float) rect.top, (float) rect.right, (float) rect.bottom);
        this.Wn.set(rect);
        if (this.Wp) {
            float a = af.a(this.Wo, this.Wl, this.Wq);
            this.Wn.inset((int) Math.ceil((double) af.b(this.Wo, this.Wl, this.Wq)), (int) Math.ceil((double) a));
            this.Wm.set(this.Wn);
        }
    }

    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        f(rect);
    }

    public final void getOutline(Outline outline) {
        outline.setRoundRect(this.Wn, this.Wl);
    }

    public final void setAlpha(int i) {
        this.fC.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.fC.setColorFilter(colorFilter);
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setTintList(ColorStateList colorStateList) {
        this.no = colorStateList;
        this.mq = b(this.no, this.np);
        invalidateSelf();
    }

    public final void setTintMode(Mode mode) {
        this.np = mode;
        this.mq = b(this.no, this.np);
        invalidateSelf();
    }

    protected final boolean onStateChange(int[] iArr) {
        if (this.no == null || this.np == null) {
            return false;
        }
        this.mq = b(this.no, this.np);
        return true;
    }

    public final boolean isStateful() {
        return (this.no != null && this.no.isStateful()) || super.isStateful();
    }

    private PorterDuffColorFilter b(ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
