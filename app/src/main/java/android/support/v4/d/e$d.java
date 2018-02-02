package android.support.v4.d;

import android.support.v4.d.e.c;

abstract class e$d implements d {
    private final c vV;

    protected abstract boolean bx();

    public e$d(c cVar) {
        this.vV = cVar;
    }

    public final boolean a(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        } else if (this.vV == null) {
            return bx();
        } else {
            switch (this.vV.a(charSequence, 0, i)) {
                case 0:
                    return true;
                case 1:
                    return false;
                default:
                    return bx();
            }
        }
    }
}
