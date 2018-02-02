package android.support.a.a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.b.a.a;
import android.support.v4.b.a.l;
import android.util.AttributeSet;

@TargetApi(21)
abstract class e extends Drawable implements l {
    Drawable mn;

    e() {
    }

    static TypedArray a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.mn != null) {
            this.mn.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public ColorFilter getColorFilter() {
        if (this.mn != null) {
            return a.g(this.mn);
        }
        return null;
    }

    protected boolean onLevelChange(int i) {
        if (this.mn != null) {
            return this.mn.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    protected void onBoundsChange(Rect rect) {
        if (this.mn != null) {
            this.mn.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.mn != null) {
            a.a(this.mn, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.mn != null) {
            a.a(this.mn, i, i2, i3, i4);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.mn != null) {
            this.mn.setFilterBitmap(z);
        }
    }

    public void jumpToCurrentState() {
        if (this.mn != null) {
            a.c(this.mn);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.mn != null) {
            a.a(this.mn, z);
        }
    }

    public boolean isAutoMirrored() {
        if (this.mn != null) {
            a.d(this.mn);
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.mn != null) {
            a.a(this.mn, theme);
        }
    }

    public int getLayoutDirection() {
        if (this.mn != null) {
            a.j(this.mn);
        }
        return 0;
    }

    public void clearColorFilter() {
        if (this.mn != null) {
            this.mn.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public Drawable getCurrent() {
        if (this.mn != null) {
            return this.mn.getCurrent();
        }
        return super.getCurrent();
    }

    public int getMinimumWidth() {
        if (this.mn != null) {
            return this.mn.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    public int getMinimumHeight() {
        if (this.mn != null) {
            return this.mn.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    public boolean getPadding(Rect rect) {
        if (this.mn != null) {
            return this.mn.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int[] getState() {
        if (this.mn != null) {
            return this.mn.getState();
        }
        return super.getState();
    }

    public Region getTransparentRegion() {
        if (this.mn != null) {
            return this.mn.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    public void setChangingConfigurations(int i) {
        if (this.mn != null) {
            this.mn.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public boolean setState(int[] iArr) {
        if (this.mn != null) {
            return this.mn.setState(iArr);
        }
        return super.setState(iArr);
    }
}
