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

public final class wc extends c {
    private final int height = 93;
    private final int width = 93;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(3.7996218f, 0.0f);
                j.cubicTo(2.1727934f, 0.0f, 0.0f, 2.2915592f, 0.0f, 5.020509f);
                j.lineTo(0.0f, 61.501232f);
                j.cubicTo(0.0f, 64.23018f, 2.1727934f, 66.521736f, 3.7996218f, 66.521736f);
                j.lineTo(83.59168f, 66.521736f);
                j.cubicTo(85.217415f, 66.521736f, 87.391304f, 64.23018f, 87.391304f, 61.501232f);
                j.lineTo(87.391304f, 5.020509f);
                j.cubicTo(87.391304f, 2.2915592f, 85.217415f, 0.0f, 83.59168f, 0.0f);
                j.lineTo(3.7996218f, 0.0f);
                j.close();
                j.moveTo(10.302137f, 6.521739f);
                j.cubicTo(8.370235f, 6.521739f, 6.521739f, 8.363973f, 6.521739f, 10.252781f);
                j.lineTo(6.521739f, 56.26896f);
                j.cubicTo(6.521739f, 58.157764f, 8.370235f, 60.0f, 10.302137f, 60.0f);
                j.lineTo(77.089165f, 60.0f);
                j.cubicTo(79.02014f, 60.0f, 80.86957f, 58.157764f, 80.86957f, 56.26896f);
                j.lineTo(80.86957f, 10.252781f);
                j.cubicTo(80.86957f, 8.363973f, 79.02014f, 6.521739f, 77.089165f, 6.521739f);
                j.lineTo(10.302137f, 6.521739f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(13.0f, 18.0f);
                j2.lineTo(74.30435f, 18.0f);
                j2.lineTo(74.30435f, 25.826088f);
                j2.lineTo(13.0f, 25.826088f);
                j2.lineTo(13.0f, 18.0f);
                j2.close();
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
