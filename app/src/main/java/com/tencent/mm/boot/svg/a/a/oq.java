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

public final class oq extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(29.73f, 4.822f);
                j.cubicTo(15.804f, 4.822f, 4.514f, 16.111f, 4.514f, 30.038f);
                j.cubicTo(4.514f, 43.965f, 15.804f, 55.253f, 29.73f, 55.253f);
                j.cubicTo(43.656f, 55.253f, 54.946f, 43.963997f, 54.946f, 30.036999f);
                j.cubicTo(54.946f, 16.11f, 43.656f, 4.822f, 29.73f, 4.822f);
                j.close();
                j.moveTo(29.73f, 53.27f);
                j.cubicTo(16.898998f, 53.27f, 6.4969997f, 42.868f, 6.4969997f, 30.037f);
                j.cubicTo(6.4969997f, 17.206001f, 16.899f, 6.805f, 29.73f, 6.805f);
                j.cubicTo(42.561f, 6.805f, 52.962997f, 17.207f, 52.962997f, 30.038f);
                j.cubicTo(52.962997f, 42.869f, 42.561f, 53.27f, 29.73f, 53.27f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(31.23f, 15.037f);
                j2.lineTo(28.23f, 15.037f);
                j2.lineTo(28.23f, 28.537f);
                j2.lineTo(14.73f, 28.537f);
                j2.lineTo(14.73f, 31.537f);
                j2.lineTo(28.23f, 31.537f);
                j2.lineTo(28.23f, 45.037f);
                j2.lineTo(31.23f, 45.037f);
                j2.lineTo(31.23f, 31.537f);
                j2.lineTo(44.73f, 31.537f);
                j2.lineTo(44.73f, 28.537f);
                j2.lineTo(31.23f, 28.537f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
