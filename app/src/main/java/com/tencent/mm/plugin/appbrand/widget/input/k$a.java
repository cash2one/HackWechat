package com.tencent.mm.plugin.appbrand.widget.input;

final class k$a implements CharSequence {
    private CharSequence jXA;

    k$a(CharSequence charSequence) {
        this.jXA = charSequence;
    }

    public final int length() {
        return this.jXA.length();
    }

    public final char charAt(int i) {
        return '●';
    }

    public final CharSequence subSequence(int i, int i2) {
        return this.jXA.subSequence(i, i2);
    }
}
