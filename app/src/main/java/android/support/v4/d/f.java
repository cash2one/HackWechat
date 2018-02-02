package android.support.v4.d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import java.util.Locale;

public final class f {
    public static final Locale ROOT = new Locale("", "");
    private static final a vY;
    private static String vZ = "Arab";
    private static String wa = "Hebr";

    private static class a {
        private a() {
        }

        public int getLayoutDirectionFromLocale(Locale locale) {
            if (!(locale == null || locale.equals(f.ROOT))) {
                String a = a.a(locale);
                if (a == null) {
                    switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                        case (byte) 1:
                        case (byte) 2:
                            return 1;
                        default:
                            return 0;
                    }
                } else if (a.equalsIgnoreCase(f.vZ) || a.equalsIgnoreCase(f.wa)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    private static class b extends a {
        private b() {
            super();
        }

        public final int getLayoutDirectionFromLocale(Locale locale) {
            return TextUtils.getLayoutDirectionFromLocale(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            vY = new b();
        } else {
            vY = new a();
        }
    }

    public static int getLayoutDirectionFromLocale(Locale locale) {
        return vY.getLayoutDirectionFromLocale(locale);
    }
}
