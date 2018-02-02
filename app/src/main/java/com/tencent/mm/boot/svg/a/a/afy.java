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

public final class afy extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8744017);
                Path j = c.j(looper);
                j.moveTo(30.152525f, 34.384174f);
                j.cubicTo(27.020466f, 36.658646f, 23.166878f, 38.0f, 19.0f, 38.0f);
                j.cubicTo(8.50659f, 38.0f, 0.0f, 29.49341f, 0.0f, 19.0f);
                j.cubicTo(0.0f, 8.50659f, 8.50659f, 0.0f, 19.0f, 0.0f);
                j.cubicTo(29.49341f, 0.0f, 38.0f, 8.50659f, 38.0f, 19.0f);
                j.cubicTo(38.0f, 23.166878f, 36.658646f, 27.020466f, 34.384174f, 30.152525f);
                j.lineTo(45.66412f, 41.432472f);
                j.lineTo(41.432472f, 45.66412f);
                j.lineTo(30.152525f, 34.384174f);
                j.close();
                j.moveTo(19.0f, 33.0f);
                j.cubicTo(26.731987f, 33.0f, 33.0f, 26.731987f, 33.0f, 19.0f);
                j.cubicTo(33.0f, 11.268014f, 26.731987f, 5.0f, 19.0f, 5.0f);
                j.cubicTo(11.268014f, 5.0f, 5.0f, 11.268014f, 5.0f, 19.0f);
                j.cubicTo(5.0f, 26.731987f, 11.268014f, 33.0f, 19.0f, 33.0f);
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
