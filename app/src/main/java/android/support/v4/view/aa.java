package android.support.v4.view;

import android.view.View;
import java.lang.reflect.Field;

final class aa {
    private static Field yq;
    private static boolean yr;
    private static Field ys;
    private static boolean yt;

    static int S(View view) {
        if (!yr) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinWidth");
                yq = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            yr = true;
        }
        if (yq != null) {
            try {
                return ((Integer) yq.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static int T(View view) {
        if (!yt) {
            try {
                Field declaredField = View.class.getDeclaredField("mMinHeight");
                ys = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            yt = true;
        }
        if (ys != null) {
            try {
                return ((Integer) ys.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }
}
