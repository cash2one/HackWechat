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

public final class acq extends c {
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
                i2.setColor(-65794);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(77.0f, 25.0f);
                j.lineTo(19.0f, 25.0f);
                j.cubicTo(17.343f, 25.0f, 16.0f, 26.34297f, 16.0f, 27.999935f);
                j.lineTo(16.0f, 68.00007f);
                j.cubicTo(16.0f, 69.65703f, 17.343f, 71.0f, 19.0f, 71.0f);
                j.lineTo(77.0f, 71.0f);
                j.cubicTo(78.656f, 71.0f, 80.0f, 69.65703f, 80.0f, 68.00007f);
                j.lineTo(80.0f, 27.999935f);
                j.cubicTo(80.0f, 26.34297f, 78.657f, 25.0f, 77.0f, 25.0f);
                j.close();
                j.moveTo(72.77142f, 39.42813f);
                j.lineTo(49.779076f, 52.676395f);
                j.cubicTo(49.218597f, 52.999264f, 48.584373f, 53.06992f, 48.000298f, 52.935474f);
                j.cubicTo(47.414253f, 53.06992f, 46.781013f, 52.99828f, 46.22152f, 52.676395f);
                j.lineTo(23.229168f, 39.42813f);
                j.cubicTo(22.054132f, 38.750996f, 21.650982f, 37.250507f, 22.329454f, 36.07681f);
                j.lineTo(22.821102f, 35.226955f);
                j.cubicTo(23.499575f, 34.053257f, 25.004013f, 33.651886f, 26.179049f, 34.329018f);
                j.lineTo(48.000298f, 46.902115f);
                j.lineTo(69.820564f, 34.329018f);
                j.cubicTo(70.9956f, 33.651886f, 72.50004f, 34.053257f, 73.17753f, 35.226955f);
                j.lineTo(73.669174f, 36.07681f);
                j.cubicTo(74.34961f, 37.250507f, 73.94646f, 38.750996f, 72.77142f, 39.42813f);
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
