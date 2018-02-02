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

public final class aeu extends c {
    private final int height = 76;
    private final int width = 76;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 76;
            case 1:
                return 76;
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
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(72.0f, 0.0f);
                j.cubicTo(74.20914f, 0.0f, 76.0f, 1.7908609f, 76.0f, 4.0f);
                j.lineTo(76.0f, 72.0f);
                j.cubicTo(76.0f, 74.20914f, 74.20914f, 76.0f, 72.0f, 76.0f);
                j.lineTo(4.0f, 76.0f);
                j.cubicTo(1.7908609f, 76.0f, 0.0f, 74.20914f, 0.0f, 72.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-5658199);
                float[] a2 = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(11.048801f, 4.034698f);
                j.cubicTo(16.060522f, -0.743125f, 23.669407f, 1.7006466f, 29.878258f, 1.1320957f);
                j.cubicTo(29.898548f, 4.1444182f, 29.898548f, 7.146766f, 29.878258f, 10.159089f);
                j.cubicTo(26.469477f, 10.288758f, 22.959244f, 9.760106f, 19.631624f, 10.607945f);
                j.cubicTo(16.557634f, 12.134055f, 17.521427f, 15.994218f, 17.318523f, 18.737226f);
                j.cubicTo(21.549065f, 18.737226f, 25.769459f, 18.737226f, 30.0f, 18.757175f);
                j.cubicTo(29.513031f, 21.789448f, 29.005772f, 24.811745f, 28.468079f, 27.834042f);
                j.cubicTo(24.765087f, 27.844017f, 21.07224f, 27.85399f, 17.379395f, 27.863966f);
                j.cubicTo(17.328669f, 35.56434f, 17.38954f, 43.27469f, 17.348959f, 50.98504f);
                j.cubicTo(14.234388f, 51.004986f, 11.109673f, 51.004986f, 7.9951024f, 50.98504f);
                j.cubicTo(7.9545217f, 43.27469f, 8.015392f, 35.574314f, 7.964667f, 27.863966f);
                j.cubicTo(5.6515656f, 27.863966f, 3.3384643f, 27.844017f, 1.0152178f, 27.844017f);
                j.cubicTo(0.9949274f, 24.811745f, 0.9949274f, 21.779472f, 1.0152178f, 18.747202f);
                j.cubicTo(3.3384643f, 18.747202f, 5.6617107f, 18.737226f, 7.984957f, 18.727251f);
                j.cubicTo(8.14728f, 13.779861f, 6.8892775f, 7.8050885f, 11.048801f, 4.034698f);
                j.lineTo(11.048801f, 4.034698f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
