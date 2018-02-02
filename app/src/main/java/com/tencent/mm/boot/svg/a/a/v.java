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

public final class v extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, -245.0f, 0.0f, 1.0f, -283.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 245.0f, 0.0f, 1.0f, 283.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(2113929216);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(45.0f, 27.0f);
                j2.cubicTo(47.761425f, 27.0f, 50.0f, 24.761423f, 50.0f, 22.0f);
                j2.cubicTo(50.0f, 19.238577f, 47.761425f, 17.0f, 45.0f, 17.0f);
                j2.cubicTo(42.238575f, 17.0f, 40.0f, 19.238577f, 40.0f, 22.0f);
                j2.cubicTo(40.0f, 24.761423f, 42.238575f, 27.0f, 45.0f, 27.0f);
                j2.close();
                j2.moveTo(45.0f, 50.0f);
                j2.cubicTo(47.761425f, 50.0f, 50.0f, 47.761425f, 50.0f, 45.0f);
                j2.cubicTo(50.0f, 42.238575f, 47.761425f, 40.0f, 45.0f, 40.0f);
                j2.cubicTo(42.238575f, 40.0f, 40.0f, 42.238575f, 40.0f, 45.0f);
                j2.cubicTo(40.0f, 47.761425f, 42.238575f, 50.0f, 45.0f, 50.0f);
                j2.close();
                j2.moveTo(45.0f, 73.0f);
                j2.cubicTo(47.761425f, 73.0f, 50.0f, 70.76142f, 50.0f, 68.0f);
                j2.cubicTo(50.0f, 65.23858f, 47.761425f, 63.0f, 45.0f, 63.0f);
                j2.cubicTo(42.238575f, 63.0f, 40.0f, 65.23858f, 40.0f, 68.0f);
                j2.cubicTo(40.0f, 70.76142f, 42.238575f, 73.0f, 45.0f, 73.0f);
                j2.close();
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
