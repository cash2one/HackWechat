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

public final class le extends c {
    private final int height = 22;
    private final int width = 20;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 22;
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
                Paint a = c.a(i2, looper);
                a.setColor(-12404711);
                canvas.saveLayerAlpha(null, 245, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(10.0f, 0.0f);
                j.cubicTo(13.33002f, 3.351164f, 16.779324f, 6.5837026f, 20.0f, 10.043607f);
                j.cubicTo(19.990059f, 11.556079f, 19.264414f, 12.188747f, 17.823061f, 11.951496f);
                j.cubicTo(15.129225f, 9.470251f, 12.624254f, 6.791297f, 10.00994f, 4.240854f);
                j.cubicTo(7.365805f, 6.7814116f, 4.870775f, 9.470251f, 2.1769383f, 11.951496f);
                j.cubicTo(0.73558646f, 12.188747f, 0.009940358f, 11.546193f, 0.0f, 10.043607f);
                j.cubicTo(3.2107356f, 6.5738173f, 6.6799207f, 3.351164f, 10.0f, 0.0f);
                j.lineTo(10.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(20.0f, 20.046492f);
                j.cubicTo(19.990059f, 21.54951f, 19.264414f, 22.18236f, 17.833002f, 21.95493f);
                j.cubicTo(15.129225f, 19.472971f, 12.624254f, 16.793247f, 10.00994f, 14.242071f);
                j.cubicTo(7.365805f, 16.793247f, 4.870775f, 19.472971f, 2.166998f, 21.95493f);
                j.cubicTo(0.73558646f, 22.18236f, 0.009940358f, 21.54951f, 0.0f, 20.046492f);
                j.cubicTo(3.2107356f, 16.575705f, 6.6799207f, 13.362015f, 10.0f, 10.0f);
                j.cubicTo(13.33002f, 13.352126f, 16.789265f, 16.585594f, 20.0f, 20.046492f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
