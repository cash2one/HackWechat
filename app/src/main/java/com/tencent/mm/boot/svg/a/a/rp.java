package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class rp extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-15683841);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(83.536f, 51.622f);
                j.cubicTo(83.706f, 50.222f, 82.506f, 49.728f, 81.518f, 49.842f);
                j.cubicTo(77.568f, 50.3f, 75.446f, 56.019f, 76.0f, 57.999f);
                j.cubicTo(76.771f, 60.757f, 74.209f, 64.999f, 72.0f, 64.999f);
                j.lineTo(43.992f, 64.999f);
                j.cubicTo(42.34f, 64.999f, 41.0f, 66.339f, 41.0f, 67.992f);
                j.lineTo(41.0f, 68.992f);
                j.cubicTo(41.0f, 70.653f, 42.346f, 71.999f, 44.007f, 71.999f);
                j.lineTo(55.412f, 71.999f);
                j.cubicTo(59.928f, 82.978f, 64.233f, 85.999f, 68.0f, 85.999f);
                j.lineTo(75.0f, 85.999f);
                j.cubicTo(82.11f, 85.999f, 86.0f, 80.155f, 86.0f, 74.999f);
                j.cubicTo(86.0f, 63.905f, 82.28f, 61.959f, 83.536f, 51.622f);
                j.lineTo(83.536f, 51.622f);
                j.close();
                j.moveTo(68.0f, 39.006f);
                j.cubicTo(68.0f, 37.345f, 66.654f, 35.999f, 64.993f, 35.999f);
                j.lineTo(52.962f, 35.999f);
                j.cubicTo(51.374f, 31.975f, 49.0f, 26.999f, 49.0f, 26.999f);
                j.cubicTo(47.568f, 23.262f, 43.749f, 22.312f, 40.952f, 22.077f);
                j.cubicTo(40.83f, 22.067f, 40.734f, 22.058f, 40.64f, 22.052f);
                j.cubicTo(40.429f, 22.029f, 40.219f, 22.0f, 40.0f, 22.0f);
                j.lineTo(34.0f, 22.0f);
                j.cubicTo(25.557f, 22.0f, 22.0f, 27.843f, 22.0f, 33.0f);
                j.cubicTo(22.0f, 44.094f, 25.721f, 46.039f, 24.465f, 56.377f);
                j.cubicTo(24.295f, 57.776f, 25.495f, 58.271f, 26.483f, 58.156f);
                j.cubicTo(30.433f, 57.698f, 32.555f, 51.98f, 32.001f, 49.999f);
                j.cubicTo(31.23f, 47.241f, 32.200043f, 45.572628f, 32.54726f, 44.979992f);
                j.cubicTo(33.241585f, 43.794914f, 34.52841f, 42.999f, 36.001f, 42.999f);
                j.lineTo(65.008f, 42.999f);
                j.cubicTo(66.661f, 42.998f, 68.0f, 41.659f, 68.0f, 40.006f);
                j.lineTo(68.0f, 39.006f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
