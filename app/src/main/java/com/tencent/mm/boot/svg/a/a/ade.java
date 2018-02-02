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

public final class ade extends c {
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
                j.moveTo(68.0f, 71.0f);
                j.lineTo(22.0f, 71.0f);
                j.lineTo(22.0f, 37.0f);
                j.lineTo(31.521f, 37.0f);
                j.cubicTo(32.823f, 34.063f, 34.368f, 31.769f, 36.079f, 30.0f);
                j.lineTo(18.0f, 30.0f);
                j.cubicTo(16.343f, 30.0f, 15.0f, 31.343f, 15.0f, 33.0f);
                j.lineTo(15.0f, 75.0f);
                j.cubicTo(15.0f, 76.657f, 16.343f, 78.0f, 18.0f, 78.0f);
                j.lineTo(72.0f, 78.0f);
                j.cubicTo(73.656f, 78.0f, 75.0f, 76.657f, 75.0f, 75.0f);
                j.lineTo(75.0f, 53.22f);
                j.lineTo(68.0f, 59.13f);
                j.lineTo(68.0f, 71.0f);
                j.lineTo(68.0f, 71.0f);
                j.close();
                j.moveTo(60.0f, 19.0f);
                j.lineTo(60.0f, 30.019f);
                j.cubicTo(58.325f, 30.008f, 56.583f, 30.0f, 55.0f, 30.0f);
                j.cubicTo(41.334f, 30.0f, 32.055f, 43.333f, 32.055f, 61.0f);
                j.cubicTo(36.721f, 50.16f, 41.284f, 45.0f, 60.0f, 45.0f);
                j.lineTo(60.0f, 56.0f);
                j.lineTo(74.452f, 43.848f);
                j.lineTo(75.0f, 44.357f);
                j.lineTo(75.0f, 43.386f);
                j.lineTo(82.0f, 37.5f);
                j.lineTo(60.0f, 19.0f);
                j.lineTo(60.0f, 19.0f);
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
