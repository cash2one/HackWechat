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

public final class sz extends c {
    private final int height = 20;
    private final int width = 15;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 15;
            case 1:
                return 20;
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
                canvas.save();
                c.a(i3, looper).setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -278.0f, 0.0f, 1.0f, -114.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(286.1f, 115.882835f);
                j.lineTo(286.1f, 125.12132f);
                j.lineTo(284.9f, 125.12132f);
                j.lineTo(284.9f, 115.88285f);
                j.lineTo(282.813f, 117.96985f);
                j.lineTo(281.96448f, 117.12132f);
                j.lineTo(284.7929f, 114.29289f);
                j.cubicTo(285.1834f, 113.90237f, 285.8166f, 113.90237f, 286.2071f, 114.29289f);
                j.lineTo(286.34854f, 114.43432f);
                j.lineTo(289.03552f, 117.12132f);
                j.lineTo(288.187f, 117.96985f);
                j.lineTo(286.1f, 115.882835f);
                j.close();
                j.moveTo(281.0f, 118.62132f);
                j.lineTo(281.0f, 119.82132f);
                j.lineTo(279.2f, 119.82132f);
                j.lineTo(279.2f, 132.42133f);
                j.lineTo(291.8f, 132.42133f);
                j.lineTo(291.8f, 119.82132f);
                j.lineTo(290.0f, 119.82132f);
                j.lineTo(290.0f, 118.62132f);
                j.lineTo(292.00104f, 118.62132f);
                j.cubicTo(292.55087f, 118.62132f, 293.0f, 119.06716f, 293.0f, 119.61713f);
                j.lineTo(293.0f, 132.62552f);
                j.cubicTo(293.0f, 133.1724f, 292.55417f, 133.62132f, 292.00418f, 133.62132f);
                j.lineTo(278.99582f, 133.62132f);
                j.cubicTo(278.4489f, 133.62132f, 278.0f, 133.17548f, 278.0f, 132.62552f);
                j.lineTo(278.0f, 119.61713f);
                j.cubicTo(278.0f, 119.070244f, 278.44724f, 118.62132f, 278.99896f, 118.62132f);
                j.lineTo(281.0f, 118.62132f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
