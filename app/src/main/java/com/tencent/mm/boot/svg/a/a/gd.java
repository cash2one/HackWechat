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

public final class gd extends c {
    private final int height = 54;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i3, looper);
                a.setColor(-13290187);
                a.setStrokeWidth(4.0f);
                Path j = c.j(looper);
                j.moveTo(27.0f, 2.0f);
                j.cubicTo(40.80712f, 2.0f, 52.0f, 13.192881f, 52.0f, 27.0f);
                j.cubicTo(52.0f, 40.80712f, 40.80712f, 52.0f, 27.0f, 52.0f);
                j.cubicTo(13.192881f, 52.0f, 2.0f, 40.80712f, 2.0f, 27.0f);
                j.cubicTo(2.0f, 13.192881f, 13.192881f, 2.0f, 27.0f, 2.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-13290187);
                j = c.j(looper);
                j.moveTo(18.515137f, 20.405273f);
                j.lineTo(22.760254f, 20.405273f);
                j.cubicTo(22.944824f, 17.780273f, 24.77002f, 16.11914f, 27.600098f, 16.11914f);
                j.cubicTo(30.409668f, 16.11914f, 32.234863f, 17.759766f, 32.234863f, 20.015625f);
                j.cubicTo(32.234863f, 22.086914f, 31.353027f, 23.25586f, 28.871582f, 24.75293f);
                j.cubicTo(26.062012f, 26.43457f, 24.811035f, 28.280273f, 24.913574f, 31.233398f);
                j.lineTo(24.934082f, 32.791992f);
                j.lineTo(29.1792f, 32.791992f);
                j.lineTo(29.1792f, 31.561523f);
                j.cubicTo(29.1792f, 29.490234f, 29.937988f, 28.40332f, 32.583496f, 26.844727f);
                j.cubicTo(35.290527f, 25.22461f, 36.890137f, 22.989258f, 36.890137f, 19.831055f);
                j.cubicTo(36.890137f, 15.380859f, 33.239746f, 12.161133f, 27.825684f, 12.161133f);
                j.cubicTo(21.878418f, 12.161133f, 18.699707f, 15.688477f, 18.515137f, 20.405273f);
                j.close();
                j.moveTo(27.312988f, 42.47168f);
                j.cubicTo(29.199707f, 42.47168f, 30.471191f, 41.220703f, 30.471191f, 39.354492f);
                j.cubicTo(30.471191f, 37.447266f, 29.199707f, 36.19629f, 27.312988f, 36.19629f);
                j.cubicTo(25.42627f, 36.19629f, 24.134277f, 37.447266f, 24.134277f, 39.354492f);
                j.cubicTo(24.134277f, 41.220703f, 25.42627f, 42.47168f, 27.312988f, 42.47168f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
