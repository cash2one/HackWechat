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

public final class anc extends c {
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
                i2.setColor(-9318371);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(47.999f, 15.0f);
                j.cubicTo(29.773f, 15.0f, 15.0f, 29.774f, 15.0f, 48.0f);
                j.cubicTo(15.0f, 66.226f, 29.773f, 81.0f, 47.999f, 81.0f);
                j.cubicTo(66.225f, 81.0f, 81.0f, 66.226f, 81.0f, 48.0f);
                j.cubicTo(81.0f, 29.774f, 66.225f, 15.0f, 47.999f, 15.0f);
                j.lineTo(47.999f, 15.0f);
                j.close();
                j.moveTo(62.0f, 31.0f);
                j.cubicTo(64.762f, 31.0f, 67.0f, 33.462f, 67.0f, 36.5f);
                j.cubicTo(67.0f, 39.538f, 64.762f, 42.0f, 62.0f, 42.0f);
                j.cubicTo(59.238f, 42.0f, 57.0f, 39.538f, 57.0f, 36.5f);
                j.cubicTo(57.0f, 33.462f, 59.238f, 31.0f, 62.0f, 31.0f);
                j.lineTo(62.0f, 31.0f);
                j.close();
                j.moveTo(35.0f, 31.0f);
                j.cubicTo(37.762f, 31.0f, 40.0f, 33.462f, 40.0f, 36.5f);
                j.cubicTo(40.0f, 39.538f, 37.762f, 42.0f, 35.0f, 42.0f);
                j.cubicTo(32.238f, 42.0f, 30.0f, 39.538f, 30.0f, 36.5f);
                j.cubicTo(30.0f, 33.462f, 32.238f, 31.0f, 35.0f, 31.0f);
                j.lineTo(35.0f, 31.0f);
                j.close();
                j.moveTo(48.0f, 71.0f);
                j.cubicTo(28.667f, 71.0f, 26.0f, 53.0f, 26.0f, 53.0f);
                j.cubicTo(26.0f, 53.0f, 40.361f, 51.0f, 48.0f, 51.0f);
                j.cubicTo(55.639f, 51.0f, 70.0f, 53.0f, 70.0f, 53.0f);
                j.cubicTo(70.0f, 53.0f, 67.333f, 71.0f, 48.0f, 71.0f);
                j.lineTo(48.0f, 71.0f);
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
