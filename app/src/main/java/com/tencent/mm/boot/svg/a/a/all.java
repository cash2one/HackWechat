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

public final class all extends c {
    private final int height = 52;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 52;
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
                a.setColor(-4534078);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(31.0f, 6.0f);
                j.cubicTo(32.539345f, 3.7781641f, 34.441322f, 1.8890821f, 36.0f, 0.0f);
                j.cubicTo(43.293613f, 6.9936233f, 47.35049f, 16.770628f, 47.0f, 27.0f);
                j.cubicTo(46.814297f, 36.18396f, 42.433674f, 45.40831f, 36.0f, 52.0f);
                j.cubicTo(33.69267f, 50.060677f, 31.821043f, 48.1314f, 30.0f, 46.0f);
                j.cubicTo(35.007866f, 41.29855f, 38.376797f, 34.676716f, 39.0f, 28.0f);
                j.cubicTo(39.520008f, 19.584154f, 36.30283f, 11.455072f, 31.0f, 6.0f);
                j.lineTo(31.0f, 6.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(23.0f, 13.0f);
                j.cubicTo(24.986967f, 11.330923f, 26.594074f, 9.670524f, 28.0f, 8.0f);
                j.cubicTo(33.15886f, 13.376049f, 35.837368f, 21.009834f, 35.0f, 28.0f);
                j.cubicTo(34.181564f, 34.009544f, 31.386173f, 39.031242f, 28.0f, 43.0f);
                j.cubicTo(26.116812f, 41.299103f, 24.538925f, 39.598206f, 23.0f, 38.0f);
                j.cubicTo(29.632965f, 31.40758f, 29.837507f, 19.693665f, 23.0f, 13.0f);
                j.lineTo(23.0f, 13.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(7.0f, 15.0f);
                j.cubicTo(13.824487f, 12.176701f, 21.437187f, 17.153526f, 22.0f, 24.0f);
                j.cubicTo(22.804081f, 30.548067f, 16.49841f, 36.811485f, 10.0f, 36.0f);
                j.cubicTo(3.6775446f, 35.425156f, -1.1115723f, 29.012133f, 0.0f, 23.0f);
                j.cubicTo(0.96371174f, 19.158218f, 3.7872953f, 15.866932f, 7.0f, 15.0f);
                j.lineTo(7.0f, 15.0f);
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
