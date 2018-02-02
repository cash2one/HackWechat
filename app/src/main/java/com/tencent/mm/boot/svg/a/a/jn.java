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

public final class jn extends c {
    private final int height = 60;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 60;
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
                i2.setColor(-2565928);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(41.408173f, 42.897102f);
                j.cubicTo(41.20714f, 42.543682f, 40.927578f, 42.21132f, 40.650383f, 42.022015f);
                j.lineTo(40.28045f, 41.76938f);
                j.lineTo(38.0f, 39.48893f);
                j.lineTo(38.0f, 27.0f);
                j.lineTo(37.967194f, 27.0f);
                j.lineTo(37.967194f, 27.0f);
                j.cubicTo(37.54229f, 20.544485f, 33.03346f, 15.204463f, 27.0f, 13.539232f);
                j.lineTo(27.0f, 13.539232f);
                j.lineTo(27.0f, 12.001665f);
                j.cubicTo(27.0f, 10.33902f, 25.656855f, 9.0f, 24.0f, 9.0f);
                j.cubicTo(22.346518f, 9.0f, 21.0f, 10.343891f, 21.0f, 12.001665f);
                j.lineTo(21.0f, 13.132172f);
                j.cubicTo(18.522533f, 13.46226f, 16.236237f, 14.397065f, 14.294383f, 15.783313f);
                j.lineTo(5.9233284f, 7.4122577f);
                j.cubicTo(5.1494994f, 6.638429f, 3.8807518f, 6.6303186f, 3.1032145f, 7.407856f);
                j.lineTo(2.407856f, 8.103214f);
                j.cubicTo(1.627709f, 8.883362f, 1.6322894f, 10.14336f, 2.412258f, 10.923328f);
                j.lineTo(42.400352f, 50.911423f);
                j.cubicTo(43.17418f, 51.68525f, 44.44293f, 51.69336f, 45.220467f, 50.915825f);
                j.lineTo(45.915825f, 50.220467f);
                j.cubicTo(46.695972f, 49.44032f, 46.69139f, 48.18032f, 45.911423f, 47.400352f);
                j.lineTo(41.408173f, 42.897102f);
                j.close();
                j.moveTo(31.48893f, 47.0f);
                j.lineTo(18.014584f, 47.0f);
                j.lineTo(8.999534f, 47.0f);
                j.lineTo(8.999534f, 47.0f);
                j.lineTo(6.606894f, 47.0f);
                j.cubicTo(5.497854f, 47.0f, 4.788665f, 46.126583f, 5.0140424f, 45.049168f);
                j.lineTo(5.3250933f, 43.56219f);
                j.cubicTo(5.4382153f, 43.021416f, 5.897074f, 42.33107f, 6.349618f, 42.022015f);
                j.lineTo(8.0f, 40.894924f);
                j.lineTo(8.0f, 27.0f);
                j.lineTo(8.0328045f, 27.0f);
                j.cubicTo(8.099805f, 25.982077f, 8.268347f, 24.991888f, 8.528398f, 24.039469f);
                j.lineTo(31.48893f, 47.0f);
                j.lineTo(31.48893f, 47.0f);
                j.close();
                j.moveTo(29.0f, 49.0f);
                j.cubicTo(29.0f, 51.761425f, 26.761423f, 54.0f, 24.0f, 54.0f);
                j.cubicTo(21.238577f, 54.0f, 19.0f, 51.761425f, 19.0f, 49.0f);
                j.lineTo(29.0f, 49.0f);
                j.lineTo(29.0f, 49.0f);
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
