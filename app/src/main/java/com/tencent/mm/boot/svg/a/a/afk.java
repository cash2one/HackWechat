package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afk extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = i.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return i.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-263173);
                float[] a2 = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.7f, 33.63f);
                j.cubicTo(40.27f, 15.91f, 62.45f, 4.14f, 85.88f, 1.28f);
                j.cubicTo(108.44f, -1.63f, 131.96f, 3.59f, 151.09f, 15.93f);
                j.cubicTo(172.67f, 29.61f, 188.49f, 52.03f, 194.03f, 76.98f);
                j.cubicTo(200.74f, 105.79f, 193.44f, 137.4f, 174.77f, 160.34f);
                j.cubicTo(173.15f, 160.22f, 171.53f, 160.1f, 169.92f, 159.98f);
                j.cubicTo(183.87f, 143.67f, 192.18f, 122.51f, 192.44f, 100.99f);
                j.cubicTo(193.16f, 79.56f, 185.98f, 58.09f, 172.86f, 41.17f);
                j.cubicTo(159.56f, 23.77f, 139.95f, 11.4f, 118.6f, 6.64f);
                j.cubicTo(99.24f, 2.59f, 78.5f, 4.25f, 60.39f, 12.4f);
                j.cubicTo(38.52f, 21.96f, 20.59f, 40.16f, 11.33f, 62.16f);
                j.cubicTo(-0.62f, 90.04f, 2.12f, 123.71f, 18.58f, 149.22f);
                j.cubicTo(17.56f, 149.45f, 15.51f, 149.9f, 14.49f, 150.13f);
                j.cubicTo(3.87f, 132.83f, -1.21f, 112.21f, 0.26f, 91.96f);
                j.cubicTo(1.63f, 70.52f, 10.41f, 49.66f, 24.7f, 33.63f);
                j.lineTo(24.7f, 33.63f);
                j.lineTo(24.7f, 33.63f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(a3);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(99.0f, 198.0f);
                j.cubicTo(153.6762f, 198.0f, 198.0f, 153.6762f, 198.0f, 99.0f);
                j.cubicTo(198.0f, 44.32381f, 153.6762f, 0.0f, 99.0f, 0.0f);
                j.cubicTo(44.32381f, 0.0f, 0.0f, 44.32381f, 0.0f, 99.0f);
                j.cubicTo(0.0f, 153.6762f, 44.32381f, 198.0f, 99.0f, 198.0f);
                j.lineTo(99.0f, 198.0f);
                j.close();
                j.moveTo(99.0f, 193.0f);
                j.cubicTo(150.91476f, 193.0f, 193.0f, 150.91476f, 193.0f, 99.0f);
                j.cubicTo(193.0f, 47.08523f, 150.91476f, 5.0f, 99.0f, 5.0f);
                j.cubicTo(47.08523f, 5.0f, 5.0f, 47.08523f, 5.0f, 99.0f);
                j.cubicTo(5.0f, 150.91476f, 47.08523f, 193.0f, 99.0f, 193.0f);
                j.lineTo(99.0f, 193.0f);
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
                float[] a5 = c.a(a3, 198.0f, 0.0f, 0.0f, 0.0f, 198.0f, 0.0f);
                f.reset();
                f.setValues(a5);
                WeChatSVGRenderC2Java.setLinearGradient(a4, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1184275}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
