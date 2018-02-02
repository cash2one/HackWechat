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

public final class su extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                a.setColor(-6710887);
                e = c.a(e, -6.123234E-17f, -1.0f, 40.000004f, -1.0f, 6.123234E-17f, 40.02865f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(35.94087f, 3.8626087f);
                j.cubicTo(31.874783f, -0.20347826f, 25.26261f, -0.21565217f, 21.191305f, 3.853913f);
                j.lineTo(17.493914f, 7.5513043f);
                j.lineTo(19.953043f, 10.010435f);
                j.lineTo(23.634783f, 6.330435f);
                j.cubicTo(26.356522f, 3.6086957f, 30.770435f, 3.6104348f, 33.48f, 6.321739f);
                j.cubicTo(36.19652f, 9.03826f, 36.193043f, 13.446957f, 33.471306f, 16.166956f);
                j.lineTo(27.33913f, 22.29913f);
                j.cubicTo(24.617392f, 25.02087f, 20.203478f, 25.01913f, 17.493914f, 22.307827f);
                j.lineTo(15.034782f, 24.766956f);
                j.cubicTo(19.10087f, 28.833044f, 25.713043f, 28.845217f, 29.784348f, 24.775652f);
                j.lineTo(35.949566f, 18.610435f);
                j.cubicTo(40.00522f, 14.553043f, 40.01565f, 7.9373913f, 35.94087f, 3.8626087f);
                j.lineTo(35.94087f, 3.8626087f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(23.732174f, 16.017391f);
                j.cubicTo(19.666086f, 11.951304f, 13.050435f, 11.942609f, 8.975652f, 16.017391f);
                j.lineTo(3.692174f, 21.354782f);
                j.cubicTo(-0.38434783f, 25.431305f, -0.37391305f, 32.027824f, 3.7008696f, 36.102608f);
                j.cubicTo(7.7669563f, 40.168697f, 14.37913f, 40.18261f, 18.448696f, 36.111305f);
                j.lineTo(21.184347f, 33.375652f);
                j.lineTo(18.725218f, 30.916521f);
                j.lineTo(15.876522f, 33.765217f);
                j.cubicTo(13.165217f, 36.47652f, 8.76f, 36.466087f, 6.0486956f, 33.754784f);
                j.cubicTo(3.3321738f, 31.038261f, 3.3304348f, 26.634783f, 6.038261f, 23.926956f);
                j.lineTo(11.50087f, 18.495653f);
                j.cubicTo(14.213913f, 15.782609f, 18.622608f, 15.789565f, 21.333914f, 18.50087f);
                j.cubicTo(21.44174f, 18.608696f, 21.546087f, 18.72f, 21.645218f, 18.833044f);
                j.lineTo(24.088696f, 16.389565f);
                j.cubicTo(23.972174f, 16.264347f, 23.853912f, 16.14087f, 23.732174f, 16.017391f);
                j.lineTo(23.732174f, 16.017391f);
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
