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

public final class hx extends c {
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
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-8683387);
                e = c.a(e, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(16.3293f, 71.9602f);
                j.cubicTo(13.4363f, 68.3632f, 11.7613f, 63.5762f, 11.7333f, 58.8262f);
                j.cubicTo(11.7123f, 55.3172f, 9.3753f, 52.2362f, 6.6693f, 48.6682f);
                j.cubicTo(6.0453f, 47.8462f, 5.4243f, 47.0262f, 4.8313f, 46.2012f);
                j.cubicTo(1.7113f, 41.8592f, 0.0413f, 36.3052f, 3.0E-4f, 30.1402f);
                j.cubicTo(-0.0897f, 16.2672f, 9.4763f, 3.9412f, 22.7473f, 0.8312f);
                j.cubicTo(31.8983f, -1.3138f, 41.2843f, 0.7372f, 48.4973f, 6.4552f);
                j.cubicTo(55.7073f, 12.1712f, 59.8433f, 20.7212f, 59.8433f, 29.9132f);
                j.cubicTo(59.8433f, 35.8332f, 58.1123f, 41.5582f, 54.8373f, 46.4712f);
                j.lineTo(47.3483f, 41.4782f);
                j.cubicTo(49.6353f, 38.0492f, 50.8433f, 34.0502f, 50.8433f, 29.9132f);
                j.cubicTo(50.8433f, 23.4862f, 47.9503f, 17.5062f, 42.9063f, 13.5082f);
                j.cubicTo(37.8603f, 9.5082f, 31.2613f, 8.0822f, 24.8013f, 9.5942f);
                j.cubicTo(15.5823f, 11.7542f, 8.9373f, 20.3702f, 9.0003f, 30.0812f);
                j.cubicTo(9.0293f, 34.3712f, 10.1153f, 38.1302f, 12.1403f, 40.9502f);
                j.cubicTo(12.6883f, 41.7122f, 13.2633f, 42.4692f, 13.8393f, 43.2292f);
                j.cubicTo(17.0523f, 47.4652f, 20.6943f, 52.2662f, 20.7333f, 58.7732f);
                j.cubicTo(20.7353f, 59.2312f, 20.9243f, 69.9922f, 31.7853f, 69.9922f);
                j.cubicTo(38.5203f, 69.9922f, 40.5293f, 65.0932f, 41.1263f, 62.1732f);
                j.cubicTo(42.2533f, 56.6692f, 38.7963f, 52.3462f, 31.1283f, 49.6692f);
                j.cubicTo(21.6763f, 46.0542f, 16.3273f, 38.8702f, 16.3273f, 29.9132f);
                j.cubicTo(16.3273f, 21.8642f, 22.0113f, 16.2422f, 30.1513f, 16.2422f);
                j.cubicTo(37.4623f, 16.2422f, 43.4103f, 22.3752f, 43.4103f, 29.9132f);
                j.cubicTo(43.4103f, 34.2002f, 41.3043f, 36.9812f, 40.5103f, 38.0272f);
                j.lineTo(32.939453f, 33.42163f);
                j.cubicTo(34.1613f, 32.040527f, 34.4103f, 31.1762f, 34.4103f, 29.9132f);
                j.cubicTo(34.4103f, 27.6672f, 33.214844f, 25.261963f, 30.0f, 25.261963f);
                j.cubicTo(26.785156f, 25.261963f, 25.3273f, 27.509521f, 25.3273f, 29.9132f);
                j.cubicTo(25.3273f, 36.4132f, 30.1173f, 39.6352f, 34.1613f, 41.1962f);
                j.cubicTo(51.8603f, 47.4082f, 50.7173f, 60.2012f, 49.9443f, 63.9782f);
                j.cubicTo(48.0473f, 73.2392f, 41.0893f, 78.9922f, 31.7853f, 78.9922f);
                j.cubicTo(23.6863f, 78.9922f, 18.9103f, 75.1682f, 16.3293f, 71.9602f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
