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

public final class rx extends c {
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
                a.setColor(-7368817);
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 15.269435f);
                j.cubicTo(9.8166485f, 5.6009107f, 23.567987f, -0.087618165f, 37.479923f, 0.0012651015f);
                j.cubicTo(51.411938f, -0.09749408f, 65.17332f, 5.591035f, 75.0f, 15.269435f);
                j.cubicTo(73.404045f, 16.839706f, 71.79804f, 18.419853f, 70.21213f, 20.0f);
                j.cubicTo(61.65016f, 11.536338f, 49.65538f, 6.539123f, 37.5f, 6.6280065f);
                j.cubicTo(25.354658f, 6.548999f, 13.349839f, 11.526462f, 4.8079495f, 20.0f);
                j.cubicTo(3.222029f, 18.4001f, 1.5658458f, 16.869333f, 0.0f, 15.269435f);
                j.lineTo(0.0f, 15.269435f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(10.0f, 26.154007f);
                j.cubicTo(17.026365f, 19.148605f, 26.678946f, 14.890619f, 36.52973f, 15.002138f);
                j.cubicTo(46.360695f, 14.910895f, 55.983543f, 19.168882f, 63.0f, 26.143867f);
                j.cubicTo(61.42427f, 27.765959f, 59.84854f, 29.37791f, 58.27281f, 31.0f);
                j.cubicTo(52.505047f, 25.271996f, 44.616493f, 21.693258f, 36.51982f, 21.804777f);
                j.cubicTo(28.413239f, 21.68312f, 20.504862f, 25.251719f, 14.727188f, 31.0f);
                j.cubicTo(13.151459f, 29.388048f, 11.575729f, 27.776096f, 10.0f, 26.154007f);
                j.lineTo(10.0f, 26.154007f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.0f, 36.39119f);
                j.cubicTo(26.48116f, 31.299276f, 34.513546f, 28.796799f, 41.967922f, 30.564959f);
                j.cubicTo(46.1635f, 31.386234f, 49.84086f, 33.676147f, 53.0f, 36.39119f);
                j.cubicTo(51.42541f, 37.917797f, 49.880722f, 39.46373f, 48.29617f, 40.990337f);
                j.cubicTo(42.246964f, 35.08681f, 31.763002f, 35.08681f, 25.713797f, 41.0f);
                j.cubicTo(24.13921f, 39.473392f, 22.584553f, 37.917797f, 21.0f, 36.39119f);
                j.lineTo(21.0f, 36.39119f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(31.0f, 47.010326f);
                j.cubicTo(34.274048f, 44.367195f, 38.80581f, 44.26062f, 42.0f, 47.106247f);
                j.cubicTo(40.193283f, 49.088593f, 38.356625f, 51.038967f, 36.529945f, 53.0f);
                j.cubicTo(34.61343f, 51.070942f, 32.82668f, 49.01399f, 31.0f, 47.010326f);
                j.lineTo(31.0f, 47.010326f);
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
