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

public final class ald extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-499359);
                Path j = c.j(looper);
                j.moveTo(23.0f, 0.0f);
                j.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                j.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                j.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                j.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(29.85458f, 16.970005f);
                j.cubicTo(29.680027f, 15.727787f, 29.348436f, 14.533834f, 28.44f, 13.570005f);
                j.cubicTo(25.85f, 10.150005f, 20.18f, 10.140005f, 17.59f, 13.560005f);
                j.cubicTo(15.97f, 15.310005f, 16.18f, 17.790005f, 15.83f, 19.970005f);
                j.lineTo(13.0f, 19.970005f);
                j.cubicTo(13.01f, 24.310005f, 13.01f, 28.640005f, 13.01f, 32.970005f);
                j.lineTo(33.01f, 32.970005f);
                j.cubicTo(33.01f, 28.640005f, 33.01f, 24.310005f, 33.02f, 19.970005f);
                j.lineTo(31.605f, 19.970005f);
                j.lineTo(26.1f, 19.970005f);
                j.lineTo(18.83f, 19.970005f);
                j.cubicTo(18.81f, 17.350006f, 19.72f, 13.870006f, 23.0f, 13.970005f);
                j.cubicTo(25.080025f, 13.887314f, 26.22539f, 15.273373f, 26.773254f, 16.970005f);
                j.lineTo(29.85458f, 16.970005f);
                j.lineTo(29.85458f, 16.970005f);
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
