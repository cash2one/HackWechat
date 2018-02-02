package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class wl extends c {
    private final int height = JsApiGetBackgroundAudioState.CTRL_INDEX;
    private final int width = JsApiGetBackgroundAudioState.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
            case 1:
                return JsApiGetBackgroundAudioState.CTRL_INDEX;
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 23, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(69.69f, 0.0f);
                j.lineTo(89.35f, 0.0f);
                j.cubicTo(106.27f, 2.71f, 122.64f, 9.98f, 134.93f, 22.1f);
                j.cubicTo(148.15f, 34.62f, 156.22f, 51.83f, 159.0f, 69.7f);
                j.lineTo(159.0f, 89.29f);
                j.cubicTo(156.38f, 106.0f, 149.23f, 122.14f, 137.43f, 134.4f);
                j.cubicTo(124.86f, 147.9f, 107.45f, 156.17f, 89.34f, 159.0f);
                j.lineTo(69.67f, 159.0f);
                j.cubicTo(54.38f, 156.5f, 39.5f, 150.47f, 27.73f, 140.23f);
                j.cubicTo(12.48f, 127.48f, 2.96f, 108.82f, 0.0f, 89.29f);
                j.lineTo(0.0f, 69.66f);
                j.cubicTo(2.74f, 52.26f, 10.43f, 35.46f, 23.1f, 23.05f);
                j.cubicTo(35.51f, 10.39f, 52.3f, 2.75f, 69.69f, 0.0f);
                j.lineTo(69.69f, 0.0f);
                j.close();
                j.moveTo(72.39f, 1.64f);
                j.cubicTo(50.03f, 3.41f, 29.01f, 15.72f, 16.0f, 33.9f);
                j.cubicTo(5.98f, 47.41f, 1.2f, 64.29f, 1.1f, 80.99f);
                j.cubicTo(1.79f, 91.02f, 3.49f, 101.11f, 7.59f, 110.36f);
                j.cubicTo(16.56f, 131.17f, 34.91f, 147.82f, 56.67f, 154.32f);
                j.cubicTo(67.11f, 157.23f, 78.17f, 158.89f, 88.95f, 157.08f);
                j.cubicTo(109.53f, 154.89f, 128.7f, 143.65f, 141.32f, 127.36f);
                j.cubicTo(157.73f, 106.72f, 162.16f, 77.57f, 153.09f, 52.87f);
                j.cubicTo(144.96f, 30.37f, 125.99f, 12.03f, 103.11f, 4.91f);
                j.cubicTo(93.2f, 2.07f, 82.69f, 0.28f, 72.39f, 1.64f);
                j.lineTo(72.39f, 1.64f);
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
