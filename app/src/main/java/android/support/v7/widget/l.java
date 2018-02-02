package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.a.a.a;
import android.support.v7.a.a.k;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class l {
    private static final int[] Qf = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] Qg = new int[]{a.textAllCaps};
    final TextView Qh;
    private an Qi;
    private an Qj;
    private an Qk;
    private an Ql;

    static l d(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new m(textView);
        }
        return new l(textView);
    }

    l(TextView textView) {
        this.Qh = textView;
    }

    void b(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.Qh.getContext();
        h ey = h.ey();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Qf, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.Qi = a(context, ey, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.Qj = a(context, ey, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.Qk = a(context, ey, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.Ql = a(context, ey, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.Qh.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, k.TextAppearance);
                if (obtainStyledAttributes2.hasValue(k.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(k.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, Qg, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                setAllCaps(z);
            }
        }
    }

    final void h(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, Qg);
        if (obtainStyledAttributes.hasValue(0)) {
            setAllCaps(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    private void setAllCaps(boolean z) {
        this.Qh.setTransformationMethod(z ? new android.support.v7.e.a(this.Qh.getContext()) : null);
    }

    void eA() {
        if (this.Qi != null || this.Qj != null || this.Qk != null || this.Ql != null) {
            Drawable[] compoundDrawables = this.Qh.getCompoundDrawables();
            a(compoundDrawables[0], this.Qi);
            a(compoundDrawables[1], this.Qj);
            a(compoundDrawables[2], this.Qk);
            a(compoundDrawables[3], this.Ql);
        }
    }

    final void a(Drawable drawable, an anVar) {
        if (drawable != null && anVar != null) {
            h.a(drawable, anVar, this.Qh.getDrawableState());
        }
    }

    protected static an a(Context context, h hVar, int i) {
        ColorStateList f = hVar.f(context, i);
        if (f == null) {
            return null;
        }
        an anVar = new an();
        anVar.Zs = true;
        anVar.Zq = f;
        return anVar;
    }
}
