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

public final class ais extends c {
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setStrokeWidth(3.0f);
                Path j = c.j(looper);
                j.moveTo(45.0f, 11.0f);
                j.cubicTo(63.225395f, 11.0f, 78.0f, 25.774603f, 78.0f, 44.0f);
                j.cubicTo(78.0f, 62.225395f, 63.225395f, 77.0f, 45.0f, 77.0f);
                j.cubicTo(26.774603f, 77.0f, 12.0f, 62.225395f, 12.0f, 44.0f);
                j.cubicTo(12.0f, 25.774603f, 26.774603f, 11.0f, 45.0f, 11.0f);
                j.close();
                i3 = c.i(looper);
                i3.setFlags(385);
                i3.setStyle(Style.FILL);
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.STROKE);
                i3.setColor(WebView.NIGHT_MODE_COLOR);
                i4.setStrokeWidth(1.0f);
                i4.setStrokeCap(Cap.BUTT);
                i4.setStrokeJoin(Join.MITER);
                i4.setStrokeMiter(4.0f);
                i4.setPathEffect(null);
                float[] a2 = c.a(e, 66.0f, 0.0f, 12.0f, 0.0f, 66.0f, 11.0f);
                f.reset();
                f.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-11019676, -5439996}, new float[]{0.0f, 1.0f}, f, 0);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
