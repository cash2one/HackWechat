package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

class d extends Drawable implements Callback, c, l {
    static final Mode mo = Mode.SRC_IN;
    Drawable mDrawable;
    private boolean ms;
    private int ua;
    private Mode ub;
    private boolean uc;
    a ud;

    protected static abstract class a extends ConstantState {
        int me;
        ColorStateList no = null;
        Mode np = d.mo;
        ConstantState ue;

        public abstract Drawable newDrawable(Resources resources);

        a(a aVar) {
            if (aVar != null) {
                this.me = aVar.me;
                this.ue = aVar.ue;
                this.no = aVar.no;
                this.np = aVar.np;
            }
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public int getChangingConfigurations() {
            return (this.ue != null ? this.ue.getChangingConfigurations() : 0) | this.me;
        }
    }

    private static class b extends a {
        b(a aVar) {
            super(aVar);
        }

        public final Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }
    }

    d(a aVar, Resources resources) {
        this.ud = aVar;
        if (this.ud != null && this.ud.ue != null) {
            k(a(this.ud.ue, resources));
        }
    }

    d(Drawable drawable) {
        this.ud = bo();
        k(drawable);
    }

    protected Drawable a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public void draw(Canvas canvas) {
        this.mDrawable.draw(canvas);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mDrawable != null) {
            this.mDrawable.setBounds(rect);
        }
    }

    public void setChangingConfigurations(int i) {
        this.mDrawable.setChangingConfigurations(i);
    }

    public int getChangingConfigurations() {
        return ((this.ud != null ? this.ud.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.mDrawable.getChangingConfigurations();
    }

    public void setDither(boolean z) {
        this.mDrawable.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.mDrawable.setFilterBitmap(z);
    }

    public void setAlpha(int i) {
        this.mDrawable.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mDrawable.setColorFilter(colorFilter);
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!bp() || this.ud == null) ? null : this.ud.no;
        return (colorStateList != null && colorStateList.isStateful()) || this.mDrawable.isStateful();
    }

    public boolean setState(int[] iArr) {
        return c(iArr) || this.mDrawable.setState(iArr);
    }

    public int[] getState() {
        return this.mDrawable.getState();
    }

    public Drawable getCurrent() {
        return this.mDrawable.getCurrent();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
    }

    public int getOpacity() {
        return this.mDrawable.getOpacity();
    }

    public Region getTransparentRegion() {
        return this.mDrawable.getTransparentRegion();
    }

    public int getIntrinsicWidth() {
        return this.mDrawable.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.mDrawable.getIntrinsicHeight();
    }

    public int getMinimumWidth() {
        return this.mDrawable.getMinimumWidth();
    }

    public int getMinimumHeight() {
        return this.mDrawable.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        return this.mDrawable.getPadding(rect);
    }

    public ConstantState getConstantState() {
        if (this.ud != null) {
            if ((this.ud.ue != null ? 1 : null) != null) {
                this.ud.me = getChangingConfigurations();
                return this.ud;
            }
        }
        return null;
    }

    public Drawable mutate() {
        if (!this.ms && super.mutate() == this) {
            this.ud = bo();
            if (this.mDrawable != null) {
                this.mDrawable.mutate();
            }
            if (this.ud != null) {
                this.ud.ue = this.mDrawable != null ? this.mDrawable.getConstantState() : null;
            }
            this.ms = true;
        }
        return this;
    }

    a bo() {
        return new b(this.ud);
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }

    protected boolean onLevelChange(int i) {
        return this.mDrawable.setLevel(i);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.ud.no = colorStateList;
        c(getState());
    }

    public void setTintMode(Mode mode) {
        this.ud.np = mode;
        c(getState());
    }

    private boolean c(int[] iArr) {
        if (!bp()) {
            return false;
        }
        ColorStateList colorStateList = this.ud.no;
        Mode mode = this.ud.np;
        if (colorStateList == null || mode == null) {
            this.uc = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.uc && colorForState == this.ua && mode == this.ub) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.ua = colorForState;
        this.ub = mode;
        this.uc = true;
        return true;
    }

    public final Drawable bn() {
        return this.mDrawable;
    }

    public final void k(Drawable drawable) {
        if (this.mDrawable != null) {
            this.mDrawable.setCallback(null);
        }
        this.mDrawable = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.ud != null) {
                this.ud.ue = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    protected boolean bp() {
        return true;
    }
}
