package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a$b;

final class t {
    private static final int[] lr = new int[]{a$b.colorPrimary};

    static void e(Context context) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(lr);
        if (!obtainStyledAttributes.hasValue(0)) {
            i = 1;
        }
        if (obtainStyledAttributes != null) {
            obtainStyledAttributes.recycle();
        }
        if (i != 0) {
            throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
        }
    }
}
