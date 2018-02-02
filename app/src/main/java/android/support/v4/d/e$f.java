package android.support.v4.d;

import java.util.Locale;

class e$f extends e$d {
    public static final e$f vX = new e$f();

    public e$f() {
        super(null);
    }

    protected final boolean bx() {
        if (f.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }
}
