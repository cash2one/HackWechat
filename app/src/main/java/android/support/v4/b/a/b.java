package android.support.v4.b.a;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

final class b {
    static Method tW;
    static boolean tX;
    private static Method tY;
    private static boolean tZ;

    public static int j(Drawable drawable) {
        if (!tZ) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                tY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            tZ = true;
        }
        if (tY != null) {
            try {
                return ((Integer) tY.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e2) {
                tY = null;
            }
        }
        return -1;
    }
}
