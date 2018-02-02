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

public final class pb extends c {
    private final int height = 81;
    private final int width = 105;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 105;
            case 1:
                return 81;
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
                a.setColor(-2565928);
                e = c.a(e, 1.0f, 0.0f, -741.0f, 0.0f, 1.0f, -55.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 741.0f, 0.0f, 1.0f, 55.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(86.71151f, 34.642452f);
                j.cubicTo(85.82056f, 34.548286f, 84.91592f, 34.5f, 84.0f, 34.5f);
                j.cubicTo(75.91176f, 34.5f, 68.7032f, 38.265427f, 64.03162f, 44.138985f);
                j.cubicTo(62.99355f, 42.952747f, 62.684723f, 41.290863f, 63.354f, 39.4515f);
                j.cubicTo(64.314f, 36.816f, 66.8325f, 34.5915f, 69.906f, 33.561f);
                j.cubicTo(74.6715f, 31.824f, 78.0f, 27.861f, 78.0f, 23.25f);
                j.cubicTo(78.0f, 17.037f, 71.955f, 12.0f, 64.5f, 12.0f);
                j.cubicTo(57.0435f, 12.0f, 51.0f, 17.037f, 51.0f, 23.25f);
                j.lineTo(51.0f, 57.75f);
                j.cubicTo(51.0f, 66.048f, 46.1925f, 73.323f, 39.0f, 77.439f);
                j.cubicTo(35.079f, 79.6815f, 30.4605f, 81.0f, 25.5f, 81.0f);
                j.cubicTo(11.439f, 81.0f, 0.0f, 70.5705f, 0.0f, 57.75f);
                j.cubicTo(0.0f, 53.67f, 1.167f, 49.8375f, 3.1995f, 46.5f);
                j.cubicTo(6.3465f, 41.3355f, 11.589f, 37.3815f, 17.8695f, 35.5785f);
                j.cubicTo(17.8755f, 35.577f, 17.88f, 35.5755f, 17.8845f, 35.574f);
                j.cubicTo(18.9435f, 35.244f, 20.0415f, 35.061f, 21.1245f, 35.061f);
                j.cubicTo(25.4685f, 35.061f, 27.9225f, 37.995f, 26.604f, 41.616f);
                j.cubicTo(25.7115f, 44.0685f, 23.307f, 46.1805f, 20.5035f, 47.3055f);
                j.cubicTo(20.169f, 47.4165f, 19.8435f, 47.5425f, 19.5225f, 47.6745f);
                j.cubicTo(15.069f, 49.5135f, 12.0f, 53.328f, 12.0f, 57.75f);
                j.cubicTo(12.0f, 63.963f, 18.0435f, 69.0f, 25.5f, 69.0f);
                j.cubicTo(32.955f, 69.0f, 39.0f, 63.963f, 39.0f, 57.75f);
                j.lineTo(39.0f, 23.25f);
                j.cubicTo(39.0f, 14.952f, 43.8075f, 7.677f, 51.0f, 3.561f);
                j.cubicTo(54.921f, 1.3185f, 59.5395f, 0.0f, 64.5f, 0.0f);
                j.cubicTo(78.561f, 0.0f, 90.0f, 10.4295f, 90.0f, 23.25f);
                j.cubicTo(90.0f, 27.33f, 88.833f, 31.164f, 86.799f, 34.5f);
                j.cubicTo(86.77001f, 34.54759f, 86.74085f, 34.59507f, 86.71151f, 34.642452f);
                j.close();
                j.moveTo(105.0f, 60.0f);
                j.cubicTo(105.0f, 71.59822f, 95.59822f, 81.0f, 84.0f, 81.0f);
                j.cubicTo(72.40178f, 81.0f, 63.0f, 71.59822f, 63.0f, 60.0f);
                j.cubicTo(63.0f, 48.40178f, 72.40178f, 39.0f, 84.0f, 39.0f);
                j.cubicTo(95.59822f, 39.0f, 105.0f, 48.40178f, 105.0f, 60.0f);
                j.close();
                j.moveTo(81.30608f, 49.484344f);
                j.lineTo(83.0f, 66.0f);
                j.lineTo(85.0f, 66.0f);
                j.lineTo(86.69392f, 49.484344f);
                j.cubicTo(86.84651f, 47.996536f, 85.76411f, 46.66673f, 84.2763f, 46.514133f);
                j.cubicTo(84.1845f, 46.50472f, 84.09228f, 46.5f, 84.0f, 46.5f);
                j.cubicTo(82.50439f, 46.5f, 81.291954f, 47.712433f, 81.291954f, 49.208046f);
                j.cubicTo(81.291954f, 49.300327f, 81.29667f, 49.392544f, 81.30608f, 49.484344f);
                j.close();
                j.moveTo(84.0f, 75.0f);
                j.cubicTo(85.65685f, 75.0f, 87.0f, 73.65685f, 87.0f, 72.0f);
                j.cubicTo(87.0f, 70.34315f, 85.65685f, 69.0f, 84.0f, 69.0f);
                j.cubicTo(82.34315f, 69.0f, 81.0f, 70.34315f, 81.0f, 72.0f);
                j.cubicTo(81.0f, 73.65685f, 82.34315f, 75.0f, 84.0f, 75.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
