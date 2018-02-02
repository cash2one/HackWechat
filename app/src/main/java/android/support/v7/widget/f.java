package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.view.View;

final class f {
    private final h Pc;
    private an Pf;
    private an Pg;
    private an Ph;
    private final View mView;

    f(View view, h hVar) {
        this.mView = view;
        this.Pc = hVar;
    }

    final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.mView.getContext().obtainStyledAttributes(attributeSet, k.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_android_background)) {
                ColorStateList f = this.Pc.f(this.mView.getContext(), obtainStyledAttributes.getResourceId(k.ViewBackgroundHelper_android_background, -1));
                if (f != null) {
                    f(f);
                }
            }
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_backgroundTint)) {
                z.a(this.mView, obtainStyledAttributes.getColorStateList(k.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(k.ViewBackgroundHelper_backgroundTintMode)) {
                z.a(this.mView, w.aX(obtainStyledAttributes.getInt(k.ViewBackgroundHelper_backgroundTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void aR(int i) {
        f(this.Pc != null ? this.Pc.f(this.mView.getContext(), i) : null);
    }

    final void d(ColorStateList colorStateList) {
        if (this.Pg == null) {
            this.Pg = new an();
        }
        this.Pg.Zq = colorStateList;
        this.Pg.Zs = true;
        ev();
    }

    final ColorStateList bM() {
        return this.Pg != null ? this.Pg.Zq : null;
    }

    final void a(Mode mode) {
        if (this.Pg == null) {
            this.Pg = new an();
        }
        this.Pg.np = mode;
        this.Pg.Zr = true;
        ev();
    }

    final Mode bN() {
        return this.Pg != null ? this.Pg.np : null;
    }

    final void ev() {
        boolean z = false;
        Drawable background = this.mView.getBackground();
        if (background != null) {
            if (VERSION.SDK_INT == 21) {
                if (this.Ph == null) {
                    this.Ph = new an();
                }
                an anVar = this.Ph;
                anVar.Zq = null;
                anVar.Zs = false;
                anVar.np = null;
                anVar.Zr = false;
                ColorStateList ae = z.ae(this.mView);
                if (ae != null) {
                    anVar.Zs = true;
                    anVar.Zq = ae;
                }
                Mode af = z.af(this.mView);
                if (af != null) {
                    anVar.Zr = true;
                    anVar.np = af;
                }
                if (anVar.Zs || anVar.Zr) {
                    h.a(background, anVar, this.mView.getDrawableState());
                    z = true;
                }
                if (z) {
                    return;
                }
            }
            if (this.Pg != null) {
                h.a(background, this.Pg, this.mView.getDrawableState());
            } else if (this.Pf != null) {
                h.a(background, this.Pf, this.mView.getDrawableState());
            }
        }
    }

    final void f(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.Pf == null) {
                this.Pf = new an();
            }
            this.Pf.Zq = colorStateList;
            this.Pf.Zs = true;
        } else {
            this.Pf = null;
        }
        ev();
    }
}
