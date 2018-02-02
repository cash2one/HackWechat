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

public final class ko extends c {
    private final int height = 115;
    private final int width = 115;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                canvas.save();
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -121.0f, 0.0f, 1.0f, -1345.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(178.3913f, 1348.0f);
                j.cubicTo(208.43079f, 1348.0f, 232.7826f, 1372.3518f, 232.7826f, 1402.3914f);
                j.cubicTo(232.7826f, 1432.4309f, 208.43079f, 1456.7827f, 178.3913f, 1456.7827f);
                j.cubicTo(148.3518f, 1456.7827f, 123.99999f, 1432.4309f, 123.99999f, 1402.3914f);
                j.cubicTo(123.99999f, 1372.3518f, 148.3518f, 1348.0f, 178.3913f, 1348.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(159.752f, 1388.8737f);
                j.lineTo(188.09235f, 1388.8737f);
                j.cubicTo(189.68294f, 1388.8737f, 190.97235f, 1390.163f, 190.97235f, 1391.7535f);
                j.lineTo(190.97235f, 1413.779f);
                j.cubicTo(190.97235f, 1415.3696f, 189.68294f, 1416.659f, 188.09235f, 1416.659f);
                j.lineTo(159.752f, 1416.659f);
                j.cubicTo(158.16142f, 1416.659f, 156.872f, 1415.3696f, 156.872f, 1413.779f);
                j.lineTo(156.872f, 1391.7535f);
                j.cubicTo(156.872f, 1390.163f, 158.16142f, 1388.8737f, 159.752f, 1388.8737f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(191.872f, 1405.0277f);
                j.lineTo(191.872f, 1399.6082f);
                j.cubicTo(194.9589f, 1396.7587f, 200.73586f, 1391.5128f, 201.40533f, 1390.917f);
                j.cubicTo(202.31215f, 1390.7258f, 203.312f, 1391.1876f, 203.312f, 1391.8704f);
                j.cubicTo(203.312f, 1393.103f, 203.312f, 1411.8667f, 203.312f, 1412.8438f);
                j.cubicTo(203.312f, 1413.3955f, 202.40784f, 1414.038f, 201.40533f, 1413.797f);
                j.cubicTo(200.94202f, 1413.2876f, 195.03276f, 1407.8926f, 191.872f, 1405.0277f);
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
