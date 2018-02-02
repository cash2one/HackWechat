package android.support.v4.d;

class e$a implements e$c {
    public static final e$a vS = new e$a(true);
    public static final e$a vT = new e$a(false);
    private final boolean vR;

    public final int a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            switch (e.W(Character.getDirectionality(charSequence.charAt(i5)))) {
                case 0:
                    if (!this.vR) {
                        i4 = 1;
                        break;
                    }
                    return 0;
                case 1:
                    if (this.vR) {
                        i4 = 1;
                        break;
                    }
                    return 1;
                default:
                    break;
            }
        }
        if (i4 == 0) {
            return 2;
        }
        if (this.vR) {
            return 1;
        }
        return 0;
    }

    private e$a(boolean z) {
        this.vR = z;
    }
}
