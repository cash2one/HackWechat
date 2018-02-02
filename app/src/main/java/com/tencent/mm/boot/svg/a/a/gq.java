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

public final class gq extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                float[] a = c.a(e, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                a2.setColor(-36352);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(15.346995f, 0.5783295f);
                j.cubicTo(22.18465f, -1.1732551f, 29.903292f, 1.1388365f, 34.658615f, 6.363563f);
                j.cubicTo(39.944534f, 11.888561f, 41.47625f, 20.57642f, 38.49291f, 27.612785f);
                j.cubicTo(35.00901f, 36.751053f, 24.08678f, 42.07587f, 14.7263f, 39.2333f);
                j.cubicTo(7.2579393f, 37.361607f, 1.3813599f, 30.705584f, 0.2901382f, 23.098701f);
                j.cubicTo(-1.5319017f, 13.179729f, 5.4358993f, 2.6401947f, 15.346995f, 0.5783295f);
                j.lineTo(15.346995f, 0.5783295f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-70474);
                e = c.a(a, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a3, looper);
                j = c.j(looper);
                j.moveTo(13.42649f, 0.6276179f);
                j.cubicTo(22.175201f, -1.8918488f, 32.143734f, 3.4270253f, 34.983315f, 12.055199f);
                j.cubicTo(37.472946f, 18.893751f, 35.273273f, 27.092016f, 29.664099f, 31.721035f);
                j.cubicTo(23.984934f, 36.70998f, 15.086246f, 37.41983f, 8.687188f, 33.41068f);
                j.cubicTo(2.7280664f, 29.891422f, -0.7814165f, 22.712942f, 0.1484465f, 15.854395f);
                j.cubicTo(0.91833305f, 8.685912f, 6.4475183f, 2.3772476f, 13.42649f, 0.6276179f);
                j.lineTo(13.42649f, 0.6276179f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-36352);
                Path j2 = c.j(looper);
                j2.moveTo(15.0255995f, 27.656855f);
                j2.lineTo(15.003011f, 27.679443f);
                j2.lineTo(17.831438f, 30.50787f);
                j2.lineTo(31.450668f, 16.88864f);
                j2.lineTo(28.622242f, 14.060212f);
                j2.lineTo(17.854027f, 24.828426f);
                j2.lineTo(11.996721f, 18.971123f);
                j2.lineTo(9.168295f, 21.79955f);
                j2.lineTo(15.0255995f, 27.656855f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
