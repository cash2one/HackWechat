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

public final class amq extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(0);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                float[] a = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(a);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-499359);
                Path j2 = c.j(looper);
                j2.moveTo(27.0f, 0.0f);
                j2.cubicTo(41.91169f, 0.0f, 54.0f, 12.088311f, 54.0f, 27.0f);
                j2.cubicTo(54.0f, 41.91169f, 41.91169f, 54.0f, 27.0f, 54.0f);
                j2.cubicTo(12.088311f, 54.0f, 0.0f, 41.91169f, 0.0f, 27.0f);
                j2.cubicTo(0.0f, 12.088311f, 12.088311f, 0.0f, 27.0f, 0.0f);
                j2.close();
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j2 = c.j(looper);
                j2.moveTo(3.0f, 24.0f);
                j2.cubicTo(4.6568546f, 24.0f, 6.0f, 25.343145f, 6.0f, 27.0f);
                j2.cubicTo(6.0f, 28.656855f, 4.6568546f, 30.0f, 3.0f, 30.0f);
                j2.cubicTo(1.3431456f, 30.0f, 0.0f, 28.656855f, 0.0f, 27.0f);
                j2.cubicTo(0.0f, 25.343145f, 1.3431456f, 24.0f, 3.0f, 24.0f);
                j2.close();
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(i2, looper);
                Path j3 = c.j(looper);
                j3.moveTo(0.49475262f, 0.0f);
                j3.lineTo(5.4947524f, 0.0f);
                j3.lineTo(4.7095985f, 20.212122f);
                j3.lineTo(1.3290199f, 20.212122f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                canvas.drawPath(j3, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
