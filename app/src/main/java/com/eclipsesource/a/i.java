package com.eclipsesource.a;

import java.io.Writer;

class i {
    private static final char[] abS = new char[]{'\\', '\"'};
    private static final char[] abT = new char[]{'\\', '\\'};
    private static final char[] abU = new char[]{'\\', 'n'};
    private static final char[] abV = new char[]{'\\', 'r'};
    private static final char[] abW = new char[]{'\\', 't'};
    private static final char[] abX = new char[]{'\\', 'u', '2', '0', '2', '8'};
    private static final char[] abY = new char[]{'\\', 'u', '2', '0', '2', '9'};
    private static final char[] abZ = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected final Writer aca;

    i(Writer writer) {
        this.aca = writer;
    }

    protected final void F(String str) {
        this.aca.write(str);
    }

    protected final void G(String str) {
        this.aca.write(str);
    }

    protected final void writeString(String str) {
        this.aca.write(34);
        I(str);
        this.aca.write(34);
    }

    protected void hD() {
        this.aca.write(91);
    }

    protected void hE() {
        this.aca.write(93);
    }

    protected void hF() {
        this.aca.write(44);
    }

    protected void hG() {
        this.aca.write(123);
    }

    protected void hH() {
        this.aca.write(125);
    }

    protected final void H(String str) {
        this.aca.write(34);
        I(str);
        this.aca.write(34);
    }

    protected void hI() {
        this.aca.write(58);
    }

    protected void hJ() {
        this.aca.write(44);
    }

    private void I(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            char[] cArr = charAt > '\\' ? (charAt < ' ' || charAt > ' ') ? null : charAt == ' ' ? abX : abY : charAt == '\\' ? abT : charAt > '\"' ? null : charAt == '\"' ? abS : charAt > '\u001f' ? null : charAt == '\n' ? abU : charAt == '\r' ? abV : charAt == '\t' ? abW : new char[]{'\\', 'u', '0', '0', abZ[(charAt >> 4) & 15], abZ[charAt & 15]};
            if (cArr != null) {
                this.aca.write(str, i, i2 - i);
                this.aca.write(cArr);
                i = i2 + 1;
            }
        }
        this.aca.write(str, i, length - i);
    }
}
