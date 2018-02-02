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

public final class ia extends c {
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
                j.moveTo(41.0f, 65.0f);
                j.cubicTo(28.297495f, 65.0f, 18.0f, 54.702503f, 18.0f, 42.0f);
                j.cubicTo(18.0f, 29.297495f, 28.297495f, 19.0f, 41.0f, 19.0f);
                j.cubicTo(53.702503f, 19.0f, 64.0f, 29.297495f, 64.0f, 42.0f);
                j.cubicTo(64.0f, 54.702503f, 53.702503f, 65.0f, 41.0f, 65.0f);
                j.lineTo(41.0f, 65.0f);
                j.close();
                j.moveTo(85.0f, 78.0f);
                j.lineTo(66.0f, 61.0f);
                j.cubicTo(70.123146f, 55.956898f, 72.5f, 49.400074f, 73.0f, 42.0f);
                j.cubicTo(72.5f, 25.006767f, 58.508797f, 11.0f, 41.0f, 11.0f);
                j.cubicTo(23.991203f, 11.0f, 10.0f, 25.006767f, 10.0f, 42.0f);
                j.cubicTo(10.0f, 59.562756f, 23.991203f, 73.56952f, 41.0f, 74.0f);
                j.cubicTo(48.358334f, 73.56952f, 54.908794f, 71.18956f, 60.0f, 67.0f);
                j.lineTo(77.0f, 86.0f);
                j.lineTo(85.0f, 78.0f);
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
