package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.b.a.a;
import android.support.v4.widget.c;
import android.support.v7.a.a.k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

final class g {
    private final h Pc;
    private final CompoundButton Pj;
    private ColorStateList Pk = null;
    private Mode Pl = null;
    private boolean Pm = false;
    private boolean Pn = false;
    private boolean Po;

    g(CompoundButton compoundButton, h hVar) {
        this.Pj = compoundButton;
        this.Pc = hVar;
    }

    final void b(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.Pj.getContext().obtainStyledAttributes(attributeSet, k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.Pj.setButtonDrawable(this.Pc.a(this.Pj.getContext(), resourceId, false));
                }
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTint)) {
                c.a(this.Pj, obtainStyledAttributes.getColorStateList(k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(k.CompoundButton_buttonTintMode)) {
                c.a(this.Pj, w.aX(obtainStyledAttributes.getInt(k.CompoundButton_buttonTintMode, -1)));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    final void e(ColorStateList colorStateList) {
        this.Pk = colorStateList;
        this.Pm = true;
        ex();
    }

    final void b(Mode mode) {
        this.Pl = mode;
        this.Pn = true;
        ex();
    }

    final void ew() {
        if (this.Po) {
            this.Po = false;
            return;
        }
        this.Po = true;
        ex();
    }

    private void ex() {
        Drawable a = c.a(this.Pj);
        if (a == null) {
            return;
        }
        if (this.Pm || this.Pn) {
            a = a.h(a).mutate();
            if (this.Pm) {
                a.a(a, this.Pk);
            }
            if (this.Pn) {
                a.a(a, this.Pl);
            }
            if (a.isStateful()) {
                a.setState(this.Pj.getDrawableState());
            }
            this.Pj.setButtonDrawable(a);
        }
    }

    final int aS(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = c.a(this.Pj);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
