package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class c {
    private static final c Bq;

    interface c {
        Drawable a(CompoundButton compoundButton);

        void a(CompoundButton compoundButton, ColorStateList colorStateList);

        void a(CompoundButton compoundButton, Mode mode);
    }

    static class b implements c {
        b() {
        }

        public void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            if (compoundButton instanceof t) {
                ((t) compoundButton).e(colorStateList);
            }
        }

        public void a(CompoundButton compoundButton, Mode mode) {
            if (compoundButton instanceof t) {
                ((t) compoundButton).b(mode);
            }
        }

        public Drawable a(CompoundButton compoundButton) {
            return d.a(compoundButton);
        }
    }

    static class d extends b {
        d() {
        }

        public final void a(CompoundButton compoundButton, ColorStateList colorStateList) {
            compoundButton.setButtonTintList(colorStateList);
        }

        public final void a(CompoundButton compoundButton, Mode mode) {
            compoundButton.setButtonTintMode(mode);
        }
    }

    static class a extends d {
        a() {
        }

        public final Drawable a(CompoundButton compoundButton) {
            return compoundButton.getButtonDrawable();
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            Bq = new a();
        } else if (i >= 21) {
            Bq = new d();
        } else {
            Bq = new b();
        }
    }

    public static void a(CompoundButton compoundButton, ColorStateList colorStateList) {
        Bq.a(compoundButton, colorStateList);
    }

    public static void a(CompoundButton compoundButton, Mode mode) {
        Bq.a(compoundButton, mode);
    }

    public static Drawable a(CompoundButton compoundButton) {
        return Bq.a(compoundButton);
    }
}
