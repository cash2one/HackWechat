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

public final class jl extends c {
    private final int height = 48;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 48;
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
                i2.setColor(-5066062);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(2.0f, 0.0f);
                j.lineTo(61.0f, 0.0f);
                j.cubicTo(61.11f, 1.2f, 61.67f, 1.83f, 63.0f, 2.0f);
                j.lineTo(63.0f, 46.0f);
                j.cubicTo(61.8f, 46.1f, 61.18f, 46.66f, 61.0f, 48.0f);
                j.lineTo(2.0f, 48.0f);
                j.cubicTo(1.89f, 46.8f, 1.34f, 46.17f, 0.0f, 46.0f);
                j.lineTo(0.0f, 2.0f);
                j.cubicTo(1.2f, 1.9f, 1.82f, 1.34f, 2.0f, 0.0f);
                j.lineTo(2.0f, 0.0f);
                j.close();
                j.moveTo(6.0f, 6.0f);
                j.cubicTo(6.009992f, 14.688017f, 6.0399685f, 23.386019f, 6.0f, 32.0f);
                j.cubicTo(9.807014f, 26.681475f, 14.5433f, 21.658401f, 20.0f, 19.0f);
                j.cubicTo(23.536245f, 16.894972f, 26.683777f, 19.161846f, 29.0f, 21.0f);
                j.cubicTo(33.98805f, 25.31336f, 38.404583f, 30.196625f, 43.0f, 35.0f);
                j.cubicTo(41.642044f, 32.88292f, 40.32308f, 30.815771f, 39.0f, 29.0f);
                j.cubicTo(41.272335f, 26.441805f, 43.51058f, 23.286158f, 47.0f, 23.0f);
                j.cubicTo(51.614223f, 24.234848f, 54.332092f, 28.59883f, 57.0f, 32.0f);
                j.cubicTo(56.96003f, 23.425964f, 56.99001f, 14.707989f, 57.0f, 6.0f);
                j.lineTo(6.0f, 6.0f);
                j.lineTo(6.0f, 6.0f);
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
