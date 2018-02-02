package com.tencent.mm.plugin.location.model;

import com.tencent.mm.pluginsdk.r;

public final class f {
    private static double nQG = -85.0d;
    private static double nQH = -1000.0d;
    private static double nQI = -85.0d;
    private static double nQJ = -1000.0d;

    public static float w(float f, float f2) {
        if (f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) {
            return (f < 315.0f || f >= 360.0f || f2 < 0.0f || f2 > 45.0f) ? f2 : f2;
        } else {
            return f2 - 360.0f;
        }
    }

    public static float x(float f, float f2) {
        if ((f < 0.0f || f > 45.0f || f2 < 315.0f || f2 >= 360.0f) && f >= 315.0f && f < 360.0f && f2 >= 0.0f && f2 <= 45.0f) {
            return f - 360.0f;
        }
        return f;
    }

    public static double i(double d, double d2) {
        nQI = d;
        nQJ = d2;
        double atan2 = (nQG == -85.0d || nQH == -1000.0d) ? 0.0d : (Math.atan2(nQJ - nQH, nQI - nQG) * 180.0d) / 3.141592d;
        nQG = nQI;
        nQH = nQJ;
        return atan2;
    }

    public static boolean a(double d, double d2, double d3, double d4, int i, double d5) {
        if (i == 0) {
            if (d5 == 0.0d) {
                return false;
            }
            if (d5 <= 0.0d) {
                return false;
            }
        } else if (i != 1) {
            return false;
        } else {
            Object obj = (d2 == -85.0d || d == -1000.0d) ? null : (d3 == -1000.0d || d4 == -85.0d) ? null : r.d(d2, d, d4, d3) >= 5.0d ? 1 : null;
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static double l(int i, int i2, int i3, int i4) {
        return Math.sqrt((double) (((i - i3) * (i - i3)) + ((i2 - i4) * (i2 - i4))));
    }

    public static boolean m(double d) {
        return d >= 4.0d;
    }
}
