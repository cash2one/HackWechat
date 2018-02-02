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

public final class hl extends c {
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
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(79.0f, 54.0f);
                j.cubicTo(78.25857f, 56.12818f, 77.36423f, 57.0f, 75.0f, 57.0f);
                j.lineTo(41.0f, 57.0f);
                j.cubicTo(38.447094f, 57.0f, 36.622643f, 55.168636f, 37.0f, 53.0f);
                j.lineTo(33.0f, 32.0f);
                j.lineTo(81.0f, 39.0f);
                j.cubicTo(81.0f, 38.81818f, 79.41102f, 50.549545f, 79.0f, 54.0f);
                j.lineTo(79.0f, 54.0f);
                j.close();
                j.moveTo(31.0f, 24.0f);
                j.lineTo(30.0f, 14.0f);
                j.lineTo(30.0f, 14.0f);
                j.cubicTo(29.09645f, 10.765857f, 26.07245f, 8.0f, 22.0f, 8.0f);
                j.lineTo(8.0f, 8.0f);
                j.lineTo(8.0f, 16.0f);
                j.lineTo(12.0f, 16.0f);
                j.lineTo(15.0f, 16.0f);
                j.lineTo(20.0f, 16.0f);
                j.cubicTo(20.94245f, 16.142857f, 21.95f, 17.155739f, 22.0f, 18.0f);
                j.lineTo(22.0f, 18.0f);
                j.lineTo(29.0f, 56.0f);
                j.lineTo(29.0f, 56.0f);
                j.cubicTo(30.31235f, 61.371452f, 34.9343f, 65.0f, 40.0f, 65.0f);
                j.lineTo(77.0f, 65.0f);
                j.cubicTo(82.3562f, 65.0f, 84.95f, 60.92857f, 85.0f, 57.0f);
                j.cubicTo(85.6574f, 54.530094f, 89.0f, 32.42857f, 89.0f, 32.0f);
                j.lineTo(31.0f, 24.0f);
                j.close();
                j.moveTo(77.0f, 73.0f);
                j.cubicTo(72.58178f, 73.0f, 69.0f, 76.58178f, 69.0f, 81.0f);
                j.cubicTo(69.0f, 85.41822f, 72.58178f, 89.0f, 77.0f, 89.0f);
                j.cubicTo(81.41822f, 89.0f, 85.0f, 85.41822f, 85.0f, 81.0f);
                j.cubicTo(85.0f, 76.58178f, 81.41822f, 73.0f, 77.0f, 73.0f);
                j.lineTo(77.0f, 73.0f);
                j.close();
                j.moveTo(36.0f, 73.0f);
                j.cubicTo(31.581778f, 73.0f, 28.0f, 76.58178f, 28.0f, 81.0f);
                j.cubicTo(28.0f, 85.41822f, 31.581778f, 89.0f, 36.0f, 89.0f);
                j.cubicTo(40.41822f, 89.0f, 44.0f, 85.41822f, 44.0f, 81.0f);
                j.cubicTo(44.0f, 76.58178f, 40.41822f, 73.0f, 36.0f, 73.0f);
                j.lineTo(36.0f, 73.0f);
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
