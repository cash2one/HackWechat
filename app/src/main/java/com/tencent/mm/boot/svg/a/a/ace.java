package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ace extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(51.362026f, 6.0f);
                j.lineTo(61.99543f, 6.0f);
                j.cubicTo(64.20043f, 6.0f, 66.0f, 7.7952905f, 66.0f, 10.009893f);
                j.lineTo(66.0f, 49.99011f);
                j.cubicTo(66.0f, 52.205948f, 64.20709f, 54.0f, 61.99543f, 54.0f);
                j.lineTo(4.0045705f, 54.0f);
                j.cubicTo(1.7995698f, 54.0f, 0.0f, 52.20471f, 0.0f, 49.99011f);
                j.lineTo(0.0f, 10.009893f);
                j.cubicTo(0.0f, 7.7940526f, 1.7929074f, 6.0f, 4.0045705f, 6.0f);
                j.lineTo(14.637975f, 6.0f);
                j.lineTo(21.0f, 0.0f);
                j.lineTo(45.0f, 0.0f);
                j.lineTo(51.362026f, 6.0f);
                j.lineTo(51.362026f, 6.0f);
                j.close();
                j.moveTo(33.0f, 48.0f);
                j.cubicTo(44.045696f, 48.0f, 53.0f, 39.045696f, 53.0f, 28.0f);
                j.cubicTo(53.0f, 16.954306f, 44.045696f, 8.0f, 33.0f, 8.0f);
                j.cubicTo(21.954306f, 8.0f, 13.0f, 16.954306f, 13.0f, 28.0f);
                j.cubicTo(13.0f, 39.045696f, 21.954306f, 48.0f, 33.0f, 48.0f);
                j.lineTo(33.0f, 48.0f);
                j.close();
                j.moveTo(33.0f, 41.0f);
                j.cubicTo(40.179703f, 41.0f, 46.0f, 35.179703f, 46.0f, 28.0f);
                j.cubicTo(46.0f, 20.8203f, 40.179703f, 15.0f, 33.0f, 15.0f);
                j.cubicTo(25.8203f, 15.0f, 20.0f, 20.8203f, 20.0f, 28.0f);
                j.cubicTo(20.0f, 35.179703f, 25.8203f, 41.0f, 33.0f, 41.0f);
                j.lineTo(33.0f, 41.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
