package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qs extends c {
    private final int height = a.CTRL_INDEX;
    private final int width = a.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return a.CTRL_INDEX;
            case 1:
                return a.CTRL_INDEX;
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
                a.setColor(-10589839);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(64.43f, 0.0f);
                j.lineTo(70.36f, 0.0f);
                j.cubicTo(86.61f, 0.76f, 102.53f, 7.46f, 114.22f, 18.81f);
                j.cubicTo(126.68f, 30.6f, 134.12f, 47.3f, 135.0f, 64.4f);
                j.lineTo(135.0f, 70.04f);
                j.cubicTo(134.31f, 87.59f, 126.58f, 104.75f, 113.69f, 116.7f);
                j.cubicTo(102.12f, 127.7f, 86.53f, 134.17f, 70.61f, 135.0f);
                j.lineTo(64.61f, 135.0f);
                j.cubicTo(48.61f, 134.24f, 32.93f, 127.74f, 21.3f, 116.69f);
                j.cubicTo(8.43f, 104.77f, 0.74f, 87.65f, 0.0f, 70.15f);
                j.lineTo(0.0f, 64.68f);
                j.cubicTo(0.8f, 47.25f, 8.47f, 30.21f, 21.28f, 18.33f);
                j.cubicTo(32.87f, 7.3f, 48.48f, 0.83f, 64.43f, 0.0f);
                j.lineTo(64.43f, 0.0f);
                j.close();
                j.moveTo(52.66f, 42.66f);
                j.cubicTo(44.71f, 48.71f, 41.53f, 59.9f, 44.75f, 69.31f);
                j.cubicTo(48.78f, 81.4f, 57.88f, 91.02f, 67.52f, 99.0f);
                j.cubicTo(77.11f, 90.99f, 86.23f, 81.41f, 90.25f, 69.31f);
                j.cubicTo(93.47f, 59.92f, 90.3f, 48.73f, 82.36f, 42.67f);
                j.cubicTo(74.01f, 35.84f, 61.01f, 35.84f, 52.66f, 42.66f);
                j.lineTo(52.66f, 42.66f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(63.25f, 50.28f);
                j.cubicTo(69.49f, 47.7f, 77.27f, 51.6f, 79.0f, 58.1f);
                j.cubicTo(81.0f, 64.22f, 77.06f, 71.37f, 70.86f, 73.02f);
                j.cubicTo(64.78f, 74.97f, 57.7f, 71.09f, 56.01f, 64.96f);
                j.cubicTo(54.11f, 59.14f, 57.5f, 52.33f, 63.25f, 50.28f);
                j.lineTo(63.25f, 50.28f);
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
