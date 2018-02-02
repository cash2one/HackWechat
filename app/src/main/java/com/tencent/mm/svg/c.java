package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c {
    public abstract int b(int i, Object... objArr);

    public static void h(Looper looper) {
        if (looper != null) {
            b.d(looper);
        }
    }

    public static Paint i(Looper looper) {
        return b.a(looper, null);
    }

    public static Paint a(Paint paint, Looper looper) {
        return b.a(looper, paint);
    }

    public static float[] e(Looper looper) {
        return b.e(looper);
    }

    public static Matrix f(Looper looper) {
        return b.f(looper);
    }

    public static Path j(Looper looper) {
        return b.g(looper);
    }

    public static float[] a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (fArr != null) {
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
            fArr[4] = f5;
            fArr[5] = f6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
        }
        return fArr;
    }
}
