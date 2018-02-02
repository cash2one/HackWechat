package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class a {
    static final b tV;

    interface b {
        void a(Drawable drawable, float f, float f2);

        void a(Drawable drawable, int i);

        void a(Drawable drawable, int i, int i2, int i3, int i4);

        void a(Drawable drawable, ColorStateList colorStateList);

        void a(Drawable drawable, Theme theme);

        void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void a(Drawable drawable, Mode mode);

        void a(Drawable drawable, boolean z);

        void b(Drawable drawable, int i);

        void c(Drawable drawable);

        boolean d(Drawable drawable);

        int e(Drawable drawable);

        boolean f(Drawable drawable);

        ColorFilter g(Drawable drawable);

        Drawable h(Drawable drawable);

        int j(Drawable drawable);
    }

    static class a implements b {
        a() {
        }

        public void c(Drawable drawable) {
        }

        public void a(Drawable drawable, boolean z) {
        }

        public boolean d(Drawable drawable) {
            return false;
        }

        public void a(Drawable drawable, float f, float f2) {
        }

        public void a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void a(Drawable drawable, int i) {
            if (drawable instanceof l) {
                ((l) drawable).setTint(i);
            }
        }

        public void a(Drawable drawable, ColorStateList colorStateList) {
            if (drawable instanceof l) {
                ((l) drawable).setTintList(colorStateList);
            }
        }

        public void a(Drawable drawable, Mode mode) {
            if (drawable instanceof l) {
                ((l) drawable).setTintMode(mode);
            }
        }

        public Drawable h(Drawable drawable) {
            return !(drawable instanceof l) ? new d(drawable) : drawable;
        }

        public void b(Drawable drawable, int i) {
        }

        public int j(Drawable drawable) {
            return 0;
        }

        public int e(Drawable drawable) {
            return 0;
        }

        public void a(Drawable drawable, Theme theme) {
        }

        public boolean f(Drawable drawable) {
            return false;
        }

        public ColorFilter g(Drawable drawable) {
            return null;
        }

        public void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    static class c extends a {
        c() {
        }

        public Drawable h(Drawable drawable) {
            return !(drawable instanceof l) ? new e(drawable) : drawable;
        }
    }

    static class d extends c {
        d() {
        }

        public final void c(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        public Drawable h(Drawable drawable) {
            return !(drawable instanceof l) ? new f(drawable) : drawable;
        }
    }

    static class e extends d {
        e() {
        }

        public void b(Drawable drawable, int i) {
            if (!b.tX) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    b.tW = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                }
                b.tX = true;
            }
            if (b.tW != null) {
                try {
                    b.tW.invoke(drawable, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    b.tW = null;
                }
            }
        }

        public int j(Drawable drawable) {
            int j = b.j(drawable);
            return j >= 0 ? j : 0;
        }
    }

    static class f extends e {
        f() {
        }

        public final void a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public final boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public Drawable h(Drawable drawable) {
            return !(drawable instanceof l) ? new g(drawable) : drawable;
        }

        public final int e(Drawable drawable) {
            return drawable.getAlpha();
        }
    }

    static class g extends f {
        g() {
        }

        public final void a(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        public final void a(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }

        public final void a(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        public final void a(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public final void a(Drawable drawable, Mode mode) {
            drawable.setTintMode(mode);
        }

        public Drawable h(Drawable drawable) {
            return !(drawable instanceof l) ? new h(drawable) : drawable;
        }

        public final void a(Drawable drawable, Theme theme) {
            drawable.applyTheme(theme);
        }

        public final boolean f(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public final ColorFilter g(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public final void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class h extends g {
        h() {
        }

        public final void b(Drawable drawable, int i) {
            drawable.setLayoutDirection(i);
        }

        public final int j(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public final Drawable h(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            tV = new h();
        } else if (i >= 21) {
            tV = new g();
        } else if (i >= 19) {
            tV = new f();
        } else if (i >= 17) {
            tV = new e();
        } else if (i >= 11) {
            tV = new d();
        } else if (i >= 5) {
            tV = new c();
        } else {
            tV = new a();
        }
    }

    public static void c(Drawable drawable) {
        tV.c(drawable);
    }

    public static void a(Drawable drawable, boolean z) {
        tV.a(drawable, z);
    }

    public static boolean d(Drawable drawable) {
        return tV.d(drawable);
    }

    public static void a(Drawable drawable, float f, float f2) {
        tV.a(drawable, f, f2);
    }

    public static void a(Drawable drawable, int i, int i2, int i3, int i4) {
        tV.a(drawable, i, i2, i3, i4);
    }

    public static void a(Drawable drawable, int i) {
        tV.a(drawable, i);
    }

    public static void a(Drawable drawable, ColorStateList colorStateList) {
        tV.a(drawable, colorStateList);
    }

    public static void a(Drawable drawable, Mode mode) {
        tV.a(drawable, mode);
    }

    public static int e(Drawable drawable) {
        return tV.e(drawable);
    }

    public static void a(Drawable drawable, Theme theme) {
        tV.a(drawable, theme);
    }

    public static boolean f(Drawable drawable) {
        return tV.f(drawable);
    }

    public static ColorFilter g(Drawable drawable) {
        return tV.g(drawable);
    }

    public static void a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        tV.a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable h(Drawable drawable) {
        return tV.h(drawable);
    }

    public static <T extends Drawable> T i(Drawable drawable) {
        if (drawable instanceof c) {
            return ((c) drawable).bn();
        }
        return drawable;
    }

    public static void b(Drawable drawable, int i) {
        tV.b(drawable, i);
    }

    public static int j(Drawable drawable) {
        return tV.j(drawable);
    }
}
