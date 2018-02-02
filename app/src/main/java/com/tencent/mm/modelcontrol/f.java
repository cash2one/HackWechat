package com.tencent.mm.modelcontrol;

public final class f implements Comparable {
    public int hui;
    public int huj;
    public int huk;
    public int hul;
    public int hum;
    public int hun;
    public int huo;

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.hui = i;
        this.huj = i2;
        this.huk = i3;
        this.hul = i4;
        this.hum = i5;
        this.hun = i6;
        this.huo = i7;
    }

    public final int compareTo(Object obj) {
        if (obj == null || !(obj instanceof f)) {
            return 0;
        }
        return this.hui - ((f) obj).hui;
    }
}
