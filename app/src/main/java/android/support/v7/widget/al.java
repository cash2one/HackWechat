package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v4.b.b;
import android.util.TypedValue;

final class al {
    static final int[] EMPTY_STATE_SET = new int[0];
    static final int[] FOCUSED_STATE_SET = new int[]{16842908};
    static final int[] PRESSED_STATE_SET = new int[]{16842919};
    static final int[] SELECTED_STATE_SET = new int[]{16842913};
    private static final ThreadLocal<TypedValue> Zl = new ThreadLocal();
    static final int[] Zm = new int[]{16843518};
    static final int[] Zn = new int[]{-16842919, -16842908};
    private static final int[] Zo = new int[1];
    static final int[] dX = new int[]{16842912};
    static final int[] iT = new int[]{-16842910};

    public static int i(Context context, int i) {
        Zo[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, Zo);
        try {
            int color = obtainStyledAttributes.getColor(0, 0);
            return color;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList j(Context context, int i) {
        Zo[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, Zo);
        try {
            ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(0);
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int k(Context context, int i) {
        ColorStateList j = j(context, i);
        if (j != null && j.isStateful()) {
            return j.getColorForState(iT, j.getDefaultColor());
        }
        TypedValue typedValue = (TypedValue) Zl.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            Zl.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        return a(context, i, typedValue.getFloat());
    }

    static int a(Context context, int i, float f) {
        int i2 = i(context, i);
        return b.m(i2, Math.round(((float) Color.alpha(i2)) * f));
    }
}
