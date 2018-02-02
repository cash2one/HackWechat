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

public final class yx extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 20.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-499359);
                Path j = c.j(looper);
                j.moveTo(31.785f, 36.737f);
                j.lineTo(31.785f, 67.704f);
                j.lineTo(59.785f, 52.121f);
                j.lineTo(59.785f, 19.704f);
                j.lineTo(31.785f, 36.737f);
                j.lineTo(31.785f, 36.737f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-16384);
                j = c.j(looper);
                j.moveTo(-0.215f, 51.722668f);
                j.lineTo(28.785f, 67.704f);
                j.lineTo(28.785f, 36.736355f);
                j.lineTo(-0.215f, 19.704f);
                j.lineTo(-0.215f, 51.722668f);
                j.lineTo(-0.215f, 51.722668f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                a2.setColor(-12799249);
                Path j2 = c.j(looper);
                j2.moveTo(30.079521f, -0.296f);
                j2.lineTo(1.785f, 15.418f);
                j2.cubicTo(1.785f, 15.418f, 28.857569f, 31.506f, 30.285f, 32.704f);
                j2.cubicTo(31.01162f, 32.435f, 58.785f, 15.418f, 58.785f, 15.418f);
                j2.lineTo(30.079521f, -0.296f);
                j2.lineTo(30.079521f, -0.296f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
