package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a;
import android.support.design.a.d;
import android.support.design.a.h;
import android.support.v7.widget.i;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

@android.support.design.widget.CoordinatorLayout.b(a.class)
public class FloatingActionButton extends VisibilityAwareImageButton {
    private ColorStateList hT;
    private Mode hU;
    private int hV;
    private int hW;
    private int hX;
    private int hY;
    private boolean hZ;
    private final Rect ia;
    private i ib;
    private l ic;

    private class b implements p {
        final /* synthetic */ FloatingActionButton ij;

        private b(FloatingActionButton floatingActionButton) {
            this.ij = floatingActionButton;
        }

        public final float X() {
            return ((float) this.ij.V()) / 2.0f;
        }

        public final void d(int i, int i2, int i3, int i4) {
            this.ij.ia.set(i, i2, i3, i4);
            this.ij.setPadding(this.ij.hY + i, this.ij.hY + i2, this.ij.hY + i3, this.ij.hY + i4);
        }

        public final void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        public final boolean Y() {
            return this.ij.hZ;
        }
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        Mode mode;
        super(context, attributeSet, i);
        this.ia = new Rect();
        t.e(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.i.cC, i, h.bJ);
        this.hT = obtainStyledAttributes.getColorStateList(a.i.cJ);
        switch (obtainStyledAttributes.getInt(a.i.cK, -1)) {
            case 3:
                mode = Mode.SRC_OVER;
                break;
            case 5:
                mode = Mode.SRC_IN;
                break;
            case 9:
                mode = Mode.SRC_ATOP;
                break;
            case 14:
                mode = Mode.MULTIPLY;
                break;
            case 15:
                mode = Mode.SCREEN;
                break;
            default:
                mode = null;
                break;
        }
        this.hU = mode;
        this.hW = obtainStyledAttributes.getColor(a.i.cE, 0);
        this.hX = obtainStyledAttributes.getInt(a.i.cF, 0);
        this.hV = obtainStyledAttributes.getDimensionPixelSize(a.i.cH, 0);
        float dimension = obtainStyledAttributes.getDimension(a.i.cD, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(a.i.cG, 0.0f);
        this.hZ = obtainStyledAttributes.getBoolean(a.i.cI, false);
        obtainStyledAttributes.recycle();
        this.ib = new i(this, android.support.v7.widget.h.ey());
        this.ib.b(attributeSet, i);
        this.hY = (V() - ((int) getResources().getDimension(d.bb))) / 2;
        W().a(this.hT, this.hU, this.hW, this.hV);
        l W = W();
        if (W.iB != dimension) {
            W.iB = dimension;
            W.j(dimension);
        }
        l W2 = W();
        if (W2.iC != dimension2) {
            W2.iC = dimension2;
            W2.k(dimension2);
        }
        W().ad();
    }

    protected void onMeasure(int i, int i2) {
        int V = V();
        V = Math.min(resolveAdjustedSize(V, i), resolveAdjustedSize(V, i2));
        setMeasuredDimension((this.ia.left + V) + this.ia.right, (V + this.ia.top) + this.ia.bottom);
    }

    public ColorStateList getBackgroundTintList() {
        return this.hT;
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.hT != colorStateList) {
            this.hT = colorStateList;
            W().setBackgroundTintList(colorStateList);
        }
    }

    public Mode getBackgroundTintMode() {
        return this.hU;
    }

    public void setBackgroundTintMode(Mode mode) {
        if (this.hU != mode) {
            this.hU = mode;
            W().setBackgroundTintMode(mode);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setBackgroundResource(int i) {
    }

    public void setBackgroundColor(int i) {
    }

    public void setImageResource(int i) {
        this.ib.setImageResource(i);
    }

    final int V() {
        switch (this.hX) {
            case 1:
                return getResources().getDimensionPixelSize(d.bc);
            default:
                return getResources().getDimensionPixelSize(d.bd);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        l W = W();
        if (W.ab()) {
            if (W.iG == null) {
                W.iG = new l$1(W);
            }
            W.iE.getViewTreeObserver().addOnPreDrawListener(W.iG);
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l W = W();
        if (W.iG != null) {
            W.iE.getViewTreeObserver().removeOnPreDrawListener(W.iG);
            W.iG = null;
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        W().b(getDrawableState());
    }

    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        W().Z();
    }

    private static int resolveAdjustedSize(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        switch (mode) {
            case Integer.MIN_VALUE:
                return Math.min(i, size);
            case 1073741824:
                return size;
            default:
                return i;
        }
    }

    private l W() {
        if (this.ic == null) {
            int i = VERSION.SDK_INT;
            l mVar = i >= 21 ? new m(this, new b()) : i >= 14 ? new k(this, new b()) : new j(this, new b());
            this.ic = mVar;
        }
        return this.ic;
    }
}
