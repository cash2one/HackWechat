package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ql extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
                Paint i2 = c.i(looper);
                i2.setFlags(385);
                i2.setStyle(Style.FILL);
                Paint i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.STROKE);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                i3.setStrokeWidth(1.0f);
                i3.setStrokeCap(Cap.BUTT);
                i3.setStrokeJoin(Join.MITER);
                i3.setStrokeMiter(4.0f);
                i3.setPathEffect(null);
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                a.setColor(-5066062);
                a.setStrokeWidth(2.0f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.7598912f, 9.578414f);
                j.cubicTo(0.67707217f, 8.5686035f, 0.0f, 7.1293283f, 0.0f, 5.5319147f);
                j.cubicTo(0.0f, 2.4767227f, 2.4767227f, 0.0f, 5.5319147f, 0.0f);
                j.cubicTo(7.280762f, 0.0f, 8.840067f, 0.8115291f, 9.853792f, 2.078551f);
                j.cubicTo(6.0863647f, 3.10554f, 3.0613158f, 5.932576f, 1.7598912f, 9.578414f);
                j.close();
                j.moveTo(16.145893f, 2.078945f);
                j.cubicTo(17.15961f, 0.8116973f, 18.719057f, 0.0f, 20.468084f, 0.0f);
                j.cubicTo(23.523277f, 0.0f, 26.0f, 2.4767227f, 26.0f, 5.5319147f);
                j.cubicTo(26.0f, 7.1299777f, 25.322378f, 8.569773f, 24.238789f, 9.579644f);
                j.cubicTo(22.937773f, 5.9336786f, 19.913073f, 3.1063783f, 16.145893f, 2.078945f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(13.0f, 1.6595745f);
                j.cubicTo(19.263145f, 1.6595745f, 24.340425f, 6.7368555f, 24.340425f, 13.0f);
                j.cubicTo(24.340425f, 19.263145f, 19.263145f, 24.340425f, 13.0f, 24.340425f);
                j.cubicTo(6.7368555f, 24.340425f, 1.6595745f, 19.263145f, 1.6595745f, 13.0f);
                j.cubicTo(1.6595745f, 6.7368555f, 6.7368555f, 1.6595745f, 13.0f, 1.6595745f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                Path j2 = c.j(looper);
                j2.moveTo(20.265247f, 22.957447f);
                j2.lineTo(23.031206f, 25.723404f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setStrokeCap(Cap.SQUARE);
                e = c.a(a2, -1.0f, 0.0f, 8.777304f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(3.2822695f, 22.404255f);
                j.lineTo(5.4950356f, 25.723404f);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                j2 = c.j(looper);
                j2.moveTo(13.0f, 5.318182f);
                j2.lineTo(13.0f, 13.0f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.save();
                a4 = c.a(a, looper);
                a4.setStrokeCap(Cap.SQUARE);
                j2 = c.j(looper);
                j2.moveTo(13.0f, 13.0f);
                j2.lineTo(17.978724f, 15.954546f);
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
