package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

public final class r {
    static final f EQ;

    static class b implements f {
        b() {
        }

        public void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, null, null, null);
        }

        public int c(TextView textView) {
            if (!s.EU) {
                s.ET = s.s("mMaxMode");
                s.EU = true;
            }
            if (s.ET != null && s.a(s.ET, textView) == 1) {
                if (!s.ES) {
                    s.ER = s.s("mMaximum");
                    s.ES = true;
                }
                if (s.ER != null) {
                    return s.a(s.ER, textView);
                }
            }
            return -1;
        }
    }

    static class d extends c {
        d() {
        }

        public final void a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawablesRelative(drawable, null, null, null);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            EQ = new a();
        } else if (i >= 18) {
            EQ = new d();
        } else if (i >= 17) {
            EQ = new c();
        } else if (i >= 16) {
            EQ = new e();
        } else {
            EQ = new b();
        }
    }

    public static void a(TextView textView, Drawable drawable) {
        EQ.a(textView, drawable, null, null, null);
    }

    public static int c(TextView textView) {
        return EQ.c(textView);
    }
}
