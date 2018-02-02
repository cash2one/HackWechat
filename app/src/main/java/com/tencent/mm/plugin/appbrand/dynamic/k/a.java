package com.tencent.mm.plugin.appbrand.dynamic.k;

public final class a {
    public static int bD(int i, int i2) {
        if (i == 0) {
            switch (i2) {
                case 1:
                    return 10000;
                case 2:
                    return 10001;
                default:
                    return 10002;
            }
        } else if (i != 1) {
            return Integer.MIN_VALUE;
        } else {
            switch (i2) {
                case 1:
                    return 10100;
                case 2:
                    return 10101;
                default:
                    return 10102;
            }
        }
    }

    public static int jX(int i) {
        switch (i) {
            case 10000:
            case 10100:
                return 1;
            case 10001:
            case 10101:
                return 2;
            default:
                return 0;
        }
    }
}
