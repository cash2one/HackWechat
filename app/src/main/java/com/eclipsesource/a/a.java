package com.eclipsesource.a;

public final class a {
    public static final h abt = new c("null");
    public static final h abu = new c("true");
    public static final h abv = new c("false");

    public static h bS(int i) {
        return new d(Integer.toString(i, 10));
    }

    public static h g(long j) {
        return new d(Long.toString(j, 10));
    }

    public static h K(float f) {
        if (!Float.isInfinite(f) && !Float.isNaN(f)) {
            return new d(B(Float.toString(f)));
        }
        throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }

    public static h d(double d) {
        if (!Double.isInfinite(d) && !Double.isNaN(d)) {
            return new d(B(Double.toString(d)));
        }
        throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
    }

    public static h z(String str) {
        return str == null ? abt : new g(str);
    }

    public static h aa(boolean z) {
        return z ? abu : abv;
    }

    public static h A(String str) {
        if (str == null) {
            throw new NullPointerException("string is null");
        }
        try {
            f fVar = new f(str);
            fVar.hy();
            fVar.hx();
            h hu = fVar.hu();
            fVar.hx();
            if (fVar.hB()) {
                return hu;
            }
            throw fVar.E("Unexpected character");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static String B(String str) {
        if (str.endsWith(".0")) {
            return str.substring(0, str.length() - 2);
        }
        return str;
    }
}
