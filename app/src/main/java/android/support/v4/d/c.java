package android.support.v4.d;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

final class c {
    private static Method vJ;
    private static Method vK;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                vK = cls.getMethod("getScript", new Class[]{String.class});
                vJ = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Exception e) {
            vK = null;
            vJ = null;
        }
    }

    public static String a(Locale locale) {
        String b = b(locale);
        if (b != null) {
            return r(b);
        }
        return null;
    }

    private static String r(String str) {
        try {
            if (vK != null) {
                return (String) vK.invoke(null, new Object[]{str});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return null;
    }

    private static String b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (vJ != null) {
                return (String) vJ.invoke(null, new Object[]{locale2});
            }
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e2) {
        }
        return locale2;
    }
}
