package c.t.m.g;

import java.util.Arrays;
import java.util.List;

public class cx {
    private static cx e = null;
    private float a = 0.0f;
    private float b = 0.0f;
    private float c = 100.0f;
    private boolean d = false;

    public static cx a() {
        if (e == null) {
            synchronized (cx.class) {
                if (e == null) {
                    e = new cx();
                }
            }
        }
        return e;
    }

    private cx() {
    }

    public final boolean a(List<Float> list) {
        float f = 0.0f;
        if (list.size() >= 5) {
            float[] fArr = new float[list.size()];
            for (int i = 0; i < fArr.length; i++) {
                Float f2 = (Float) list.get(i);
                fArr[i] = f2 == null ? 0.0f : f2.floatValue();
            }
            Arrays.sort(fArr);
            float[] fArr2 = new float[5];
            for (int i2 = 0; i2 < 5; i2++) {
                fArr2[i2] = fArr[(fArr.length - 1) - i2];
                f += fArr2[i2];
            }
            float f3 = f / 5.0f;
            if (this.b < f3) {
                this.b = f3;
            }
            if (this.c > f3) {
                this.c = f3;
            }
            this.a = f3;
            if (this.a - f3 > 2.0f) {
                this.d = false;
            }
            if (f3 > (this.b + this.c) / 2.0f) {
                this.d = true;
            } else if (f3 < 22.0f) {
                this.d = false;
            }
        }
        return this.d;
    }
}
