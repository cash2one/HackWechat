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

public final class h extends c {
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
                i2.setColor(-8617594);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(48.0f, 30.0f);
                j.cubicTo(45.238575f, 30.0f, 43.0f, 27.761423f, 43.0f, 25.0f);
                j.cubicTo(43.0f, 22.238577f, 45.238575f, 20.0f, 48.0f, 20.0f);
                j.cubicTo(50.761425f, 20.0f, 53.0f, 22.238577f, 53.0f, 25.0f);
                j.cubicTo(53.0f, 27.761423f, 50.761425f, 30.0f, 48.0f, 30.0f);
                j.close();
                j.moveTo(48.0f, 53.0f);
                j.cubicTo(45.238575f, 53.0f, 43.0f, 50.761425f, 43.0f, 48.0f);
                j.cubicTo(43.0f, 45.238575f, 45.238575f, 43.0f, 48.0f, 43.0f);
                j.cubicTo(50.761425f, 43.0f, 53.0f, 45.238575f, 53.0f, 48.0f);
                j.cubicTo(53.0f, 50.761425f, 50.761425f, 53.0f, 48.0f, 53.0f);
                j.close();
                j.moveTo(48.0f, 76.0f);
                j.cubicTo(45.238575f, 76.0f, 43.0f, 73.76142f, 43.0f, 71.0f);
                j.cubicTo(43.0f, 68.23858f, 45.238575f, 66.0f, 48.0f, 66.0f);
                j.cubicTo(50.761425f, 66.0f, 53.0f, 68.23858f, 53.0f, 71.0f);
                j.cubicTo(53.0f, 73.76142f, 50.761425f, 76.0f, 48.0f, 76.0f);
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
