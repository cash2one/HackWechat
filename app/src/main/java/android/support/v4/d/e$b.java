package android.support.v4.d;

class e$b implements e$c {
    public static final e$b vU = new e$b();

    public final int a(CharSequence charSequence, int i, int i2) {
        int i3 = i2 + 0;
        int i4 = 2;
        for (int i5 = 0; i5 < i3 && i4 == 2; i5++) {
            i4 = e.V(Character.getDirectionality(charSequence.charAt(i5)));
        }
        return i4;
    }

    private e$b() {
    }
}
