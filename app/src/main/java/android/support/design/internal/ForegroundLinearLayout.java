package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.a.i;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import com.tencent.mm.plugin.gif.MMGIFException;

public class ForegroundLinearLayout extends LinearLayoutCompat {
    private Drawable dR;
    private final Rect dS;
    private final Rect dT;
    private int dU;
    protected boolean dV;
    boolean dW;

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ForegroundLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dS = new Rect();
        this.dT = new Rect();
        this.dU = 119;
        this.dV = true;
        this.dW = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.cL, i, 0);
        this.dU = obtainStyledAttributes.getInt(i.cN, this.dU);
        Drawable drawable = obtainStyledAttributes.getDrawable(i.cM);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.dV = obtainStyledAttributes.getBoolean(i.cO, true);
        obtainStyledAttributes.recycle();
    }

    public int getForegroundGravity() {
        return this.dU;
    }

    public void setForegroundGravity(int i) {
        if (this.dU != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) == 0) {
                i2 |= 48;
            }
            this.dU = i2;
            if (this.dU == 119 && this.dR != null) {
                this.dR.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.dR;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.dR != null) {
            this.dR.jumpToCurrentState();
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.dR != null && this.dR.isStateful()) {
            this.dR.setState(getDrawableState());
        }
    }

    public void setForeground(Drawable drawable) {
        if (this.dR != drawable) {
            if (this.dR != null) {
                this.dR.setCallback(null);
                unscheduleDrawable(this.dR);
            }
            this.dR = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.dU == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public Drawable getForeground() {
        return this.dR;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.dW |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.dW = true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.dR != null) {
            Drawable drawable = this.dR;
            if (this.dW) {
                this.dW = false;
                Rect rect = this.dS;
                Rect rect2 = this.dT;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.dV) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.dU, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.dR != null) {
            this.dR.setHotspot(f, f2);
        }
    }
}
