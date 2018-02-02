package com.tencent.mm.plugin.appbrand.widget.e;

import com.tencent.mm.plugin.appbrand.compat.a.b.f;

public final class g {
    public static double kcM = 6378137.0d;
    final double kcN = (6.283185307179586d * kcM);

    public final f c(f fVar) {
        double abD = (fVar.abD() / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(fVar.abC()));
        return new f(abD * this.kcN, (((Math.log((1.0d + sin) / (1.0d - sin)) * 0.5d) / -6.283185307179586d) + 0.5d) * this.kcN);
    }
}
