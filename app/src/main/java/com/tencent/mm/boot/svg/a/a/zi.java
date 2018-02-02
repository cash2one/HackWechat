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

public final class zi extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                i2.setColor(-5592406);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(28.0f, 24.0f);
                j.lineTo(34.0f, 24.0f);
                j.lineTo(34.0f, 36.0f);
                j.lineTo(28.0f, 36.0f);
                j.lineTo(28.0f, 24.0f);
                j.close();
                j.moveTo(38.0f, 24.0f);
                j.lineTo(43.0f, 24.0f);
                j.lineTo(43.0f, 36.0f);
                j.lineTo(38.0f, 36.0f);
                j.lineTo(38.0f, 24.0f);
                j.close();
                j.moveTo(47.0f, 24.0f);
                j.lineTo(51.0f, 24.0f);
                j.lineTo(51.0f, 36.0f);
                j.lineTo(47.0f, 36.0f);
                j.lineTo(47.0f, 24.0f);
                j.close();
                j.moveTo(25.763962f, 14.012434f);
                j.cubicTo(26.998892f, 12.900997f, 28.0f, 13.345539f, 28.0f, 15.00742f);
                j.lineTo(28.0f, 44.99258f);
                j.cubicTo(28.0f, 46.653534f, 27.008198f, 47.107376f, 25.763962f, 45.987564f);
                j.lineTo(10.236038f, 32.012436f);
                j.cubicTo(9.001108f, 30.900997f, 8.991803f, 29.107378f, 10.236038f, 27.987566f);
                j.lineTo(25.763962f, 14.012434f);
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
