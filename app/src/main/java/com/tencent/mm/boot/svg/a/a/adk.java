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

public final class adk extends c {
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(57.0f, 48.0f);
                j.cubicTo(57.0f, 50.762f, 59.238f, 53.0f, 62.0f, 53.0f);
                j.cubicTo(64.762f, 53.0f, 67.0f, 50.762f, 67.0f, 48.0f);
                j.cubicTo(67.0f, 45.239f, 64.762f, 43.0f, 62.0f, 43.0f);
                j.cubicTo(59.238f, 43.0f, 57.0f, 45.239f, 57.0f, 48.0f);
                j.close();
                j.moveTo(77.0f, 25.0f);
                j.lineTo(19.0f, 25.0f);
                j.cubicTo(17.344f, 25.0f, 16.0f, 26.343f, 16.0f, 28.0f);
                j.lineTo(16.0f, 68.0f);
                j.cubicTo(16.0f, 69.657f, 17.344f, 71.0f, 19.0f, 71.0f);
                j.lineTo(77.0f, 71.0f);
                j.cubicTo(78.656f, 71.0f, 80.0f, 69.657f, 80.0f, 68.0f);
                j.lineTo(80.0f, 58.0f);
                j.lineTo(62.0f, 58.0f);
                j.cubicTo(56.477f, 58.0f, 52.0f, 53.523f, 52.0f, 48.0f);
                j.cubicTo(52.0f, 42.478f, 56.477f, 38.0f, 62.0f, 38.0f);
                j.lineTo(80.0f, 38.0f);
                j.lineTo(80.0f, 28.0f);
                j.cubicTo(80.0f, 26.344f, 78.656f, 25.0f, 77.0f, 25.0f);
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
