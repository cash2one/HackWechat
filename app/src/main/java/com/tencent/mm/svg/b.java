package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

final class b {
    private static a<Paint> xCe = new a();
    private static a<float[]> xCf = new a();
    private static a<Matrix> xCg = new a();
    private static a<Path> xCh = new a();
    private static final float[] xCi = new float[9];

    protected static synchronized void d(Looper looper) {
        synchronized (b.class) {
            xCe.c(looper);
            xCf.c(looper);
            xCg.c(looper);
            xCh.c(looper);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            paint2 = (Paint) xCe.cla();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            xCe.a(looper, paint2);
        }
        return paint2;
    }

    protected static synchronized float[] e(Looper looper) {
        Object obj;
        synchronized (b.class) {
            obj = (float[]) xCf.cla();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(xCi, 0, obj, 0, 9);
            }
            xCf.a(looper, obj);
        }
        return obj;
    }

    protected static synchronized Matrix f(Looper looper) {
        Matrix matrix;
        synchronized (b.class) {
            matrix = (Matrix) xCg.cla();
            if (matrix == null) {
                matrix = new Matrix();
            } else {
                matrix.reset();
            }
            xCg.a(looper, matrix);
        }
        return matrix;
    }

    protected static synchronized Path g(Looper looper) {
        Path path;
        synchronized (b.class) {
            path = (Path) xCh.cla();
            if (path == null) {
                path = new Path();
            } else {
                path.reset();
            }
            xCh.a(looper, path);
        }
        return path;
    }
}
