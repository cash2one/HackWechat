package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Constructor;

public class a {
    private static boolean gPb;
    private static boolean gUi;
    private static Constructor<StaticLayout> gUj;
    private static Object gUk;

    @TargetApi(18)
    private static synchronized void El() {
        synchronized (a.class) {
            if (!gPb) {
                try {
                    Class cls;
                    if (VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        gUk = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader classLoader = a.class.getClassLoader();
                        cls = classLoader.loadClass("android.text.TextDirectionHeuristic");
                        Class loadClass = classLoader.loadClass("android.text.TextDirectionHeuristics");
                        gUk = loadClass.getField("FIRSTSTRONG_LTR").get(loadClass);
                    }
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TruncateAt.class, Integer.TYPE, Integer.TYPE});
                    gUj = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    gPb = true;
                } catch (NoSuchMethodException e) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", e);
                    gUi = true;
                    gPb = true;
                } catch (ClassNotFoundException e2) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", e2);
                    gUi = true;
                    gPb = true;
                } catch (NoSuchFieldException e3) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e3);
                    gUi = true;
                    gPb = true;
                } catch (IllegalAccessException e4) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e4);
                    gUi = true;
                    gPb = true;
                } catch (Exception e5) {
                    x.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", e5);
                    gUi = true;
                    gPb = true;
                } catch (Throwable th) {
                    gPb = true;
                }
                x.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + gUi);
            }
        }
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            El();
            if (gUi) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) gUj.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, gUk, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            El();
            if (gUi) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) gUj.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, textDirectionHeuristic, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }
}
