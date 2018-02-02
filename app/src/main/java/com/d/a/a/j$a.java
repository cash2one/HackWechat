package com.d.a.a;

protected class j$a {
    double bhB;
    double bhC;
    double bhD;
    double[] bhE = new double[2];
    double bhF;
    double bhG;
    int bhH;
    double bhI;
    double bhJ;
    int bhK;
    double bhL;
    double bhM;
    double bhN;
    int mType;

    protected j$a(int i, double d, double d2, double d3, double d4, double d5, int i2, double d6, int i3, double d7, double d8) {
        this.mType = i;
        this.bhB = d;
        this.bhC = d2;
        this.bhD = d3;
        this.bhF = d4;
        this.bhG = d5;
        this.bhH = i2;
        this.bhI = d6;
        this.bhJ = 0.0d;
        this.bhK = i3;
        this.bhL = 0.0d;
        this.bhM = d7;
        this.bhN = d8;
    }

    public final String toString() {
        return new StringBuilder(String.valueOf(String.valueOf(this.mType))).append(',').append(this.bhB).append(',').append(this.bhC).append(',').append(this.bhD).append(',').append(this.bhF).append(',').append(this.bhG).append(',').append(this.bhH).append(',').append(this.bhI).append(',').append(this.bhJ).append(',').append(this.bhK).append(',').append(this.bhM).append(',').append(this.bhN).toString();
    }
}
