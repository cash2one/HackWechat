package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.z;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class at {
    private static Method aaA;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                aaA = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    aaA.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
            }
        }
    }

    public static boolean bv(View view) {
        return z.I(view) == 1;
    }

    public static int combineMeasuredStates(int i, int i2) {
        return i | i2;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (aaA != null) {
            try {
                aaA.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
            }
        }
    }

    public static void bw(View view) {
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException e) {
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
            }
        }
    }
}
