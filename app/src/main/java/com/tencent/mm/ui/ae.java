package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.tencent.mm.compatible.loader.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Method;

public final class ae {
    private static Rect xNb = new Rect(0, 0, 0, 0);

    @TargetApi(21)
    public static ViewGroup a(Window window, View view) {
        ViewGroup viewGroup = null;
        if (window == null) {
            return null;
        }
        ViewGroup f = f(window);
        if (f != null) {
            return f;
        }
        if (view != null) {
            ViewParent parent = view.getParent();
            while (parent != window.getDecorView() && parent != null) {
                ViewParent viewParent = parent;
                parent = parent.getParent();
                ViewParent viewParent2 = viewParent;
            }
            f = viewGroup;
        } else {
            f = null;
        }
        if (f == null) {
            View childAt = ((ViewGroup) window.getDecorView()).getChildAt(0);
            if (childAt instanceof ViewGroup) {
                return (ViewGroup) childAt;
            }
            if (VERSION.SDK_INT >= 21) {
                window.clearFlags(Integer.MIN_VALUE);
            }
        }
        return f;
    }

    private static ViewGroup f(Window window) {
        Throwable e;
        if (VERSION.SDK_INT >= 21) {
            c cVar = new c(window, "mContentRoot", null);
            if (cVar.yW()) {
                try {
                    return (ViewGroup) cVar.get();
                } catch (NoSuchFieldException e2) {
                    e = e2;
                } catch (IllegalAccessException e3) {
                    e = e3;
                } catch (IllegalArgumentException e4) {
                    e = e4;
                }
            }
        }
        return null;
        x.printErrStackTrace("MicroMsg.UIUtils", e, "", new Object[0]);
        return null;
    }

    @TargetApi(20)
    public static boolean c(final View view, final View view2) {
        if (!d.fM(21)) {
            return true;
        }
        if (view == null || !(view instanceof ViewGroup) || view2 == null || !(view.getLayoutParams() instanceof MarginLayoutParams)) {
            return false;
        }
        view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
            public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
                ae.w(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                return view.onApplyWindowInsets(windowInsets);
            }
        });
        return true;
    }

    public static void w(int i, int i2, int i3, int i4) {
        xNb.set(i, i2, i3, i4);
    }

    public static Rect cnF() {
        return xNb;
    }

    public static int fx(Context context) {
        if (fy(context)) {
            int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                return Resources.getSystem().getDimensionPixelSize(identifier);
            }
        }
        return 0;
    }

    @TargetApi(17)
    public static boolean fy(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        Point fz = fz(context);
        return Math.max(fz.y, fz.x) > Math.max(point.y, point.x);
    }

    public static Point fz(Context context) {
        Point point = new Point();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (VERSION.SDK_INT >= 14) {
                try {
                    Method method = Display.class.getMethod("getRawHeight", new Class[0]);
                    point.x = ((Integer) Display.class.getMethod("getRawWidth", new Class[0]).invoke(defaultDisplay, new Object[0])).intValue();
                    point.y = ((Integer) method.invoke(defaultDisplay, new Object[0])).intValue();
                } catch (Exception e) {
                }
            }
            defaultDisplay.getSize(point);
        }
        return point;
    }

    public static void a(Window window) {
        if (window != null && VERSION.SDK_INT >= 21) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
    }

    public static void g(Window window) {
        if (window != null && window.getDecorView() != null && VERSION.SDK_INT >= 23) {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
    }

    public static int d(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return ((((int) ((f2 * 0.0f) + (((float) (i & 255)) * f))) & 255) << 0) | ((((((int) ((((float) ((i >> 24) & 255)) * f) + (255.0f * f2))) & 255) << 24) | ((((int) ((((float) ((i >> 16) & 255)) * f) + (0.0f * f2))) & 255) << 16)) | ((((int) ((((float) ((i >> 8) & 255)) * f) + (0.0f * f2))) & 255) << 8));
    }
}
