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

public final class ct extends c {
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -1463.0f, 0.0f, 1.0f, -215.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1463.0f, 0.0f, 1.0f, 215.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(8.0f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(72.0f, 52.0f);
                j.lineTo(77.1435f, 52.0f);
                j.cubicTo(80.375984f, 52.0f, 81.20154f, 50.09575f, 78.983025f, 47.746735f);
                j.lineTo(53.01697f, 20.253265f);
                j.cubicTo(50.80398f, 17.910099f, 47.201538f, 17.904251f, 44.98303f, 20.253265f);
                j.lineTo(19.016973f, 47.746735f);
                j.cubicTo(16.803982f, 50.0899f, 17.622042f, 52.0f, 20.856497f, 52.0f);
                j.lineTo(26.0f, 52.0f);
                j.lineTo(26.0f, 74.07317f);
                j.cubicTo(26.0f, 75.69759f, 27.31177f, 77.0f, 28.92992f, 77.0f);
                j.lineTo(69.070076f, 77.0f);
                j.cubicTo(70.69741f, 77.0f, 72.0f, 75.68961f, 72.0f, 74.07317f);
                j.lineTo(72.0f, 52.0f);
                j.close();
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(54.0f, 63.0f);
                j2.lineTo(54.0f, 74.0f);
                j2.lineTo(45.0f, 74.0f);
                j2.lineTo(45.0f, 63.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
