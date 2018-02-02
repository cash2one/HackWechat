package com.d.a.a;

import android.location.Location;

final class i {
    static i bho;
    double bhp;
    double bhq;
    float bhr;
    float bhs;
    float bht;
    float bhu;
    float bhv;
    float bhw;
    boolean bhx = false;

    i() {
    }

    final void a(double d, double d2, float f, float f2, float f3, float f4) {
        double d3;
        float[] fArr = new float[1];
        if (d2 > 179.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d, d2, d, d2 + d3, fArr);
        this.bhw = fArr[0];
        if (d > 89.0d) {
            d3 = -1.0E-5d;
        } else {
            d3 = 1.0E-5d;
        }
        Location.distanceBetween(d3 + d, d2, d, d2, fArr);
        this.bhv = fArr[0];
        this.bhp = d;
        this.bhq = d2;
        this.bhr = f2;
        this.bhs = f3;
        this.bhu = f;
        this.bht = f4;
        this.bhx = true;
    }
}
