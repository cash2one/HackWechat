package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ij extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-9276814);
                Path j = c.j(looper);
                j.moveTo(71.998f, 42.0f);
                j.cubicTo(73.462f, 42.0f, 74.892f, 42.14f, 76.3f, 42.344f);
                j.lineTo(47.036f, 13.08f);
                j.cubicTo(33.486f, 18.83f, 22.316f, 29.098f, 15.452f, 42.018f);
                j.lineTo(71.672f, 42.018f);
                j.cubicTo(71.784f, 42.018f, 71.888f, 42.0f, 71.998f, 42.0f);
                j.lineTo(71.998f, 42.0f);
                j.close();
                j.moveTo(101.998f, 15.5f);
                j.lineTo(101.998f, 72.0f);
                j.cubicTo(101.998f, 73.43f, 101.864f, 74.826f, 101.67f, 76.202f);
                j.lineTo(130.91f, 46.96f);
                j.cubicTo(125.16f, 33.45f, 114.88f, 22.356f, 101.998f, 15.5f);
                j.lineTo(101.998f, 15.5f);
                j.close();
                j.moveTo(93.248f, 50.828f);
                j.cubicTo(94.248f, 51.83f, 95.148f, 52.924f, 95.998f, 54.058f);
                j.lineTo(95.998f, 12.674f);
                j.cubicTo(88.584f, 9.672f, 80.49f, 8.0f, 71.998f, 8.0f);
                j.cubicTo(65.474f, 8.0f, 59.19f, 9.002f, 53.26f, 10.818f);
                j.lineTo(93.26f, 50.818f);
                j.lineTo(93.248f, 50.828f);
                j.lineTo(93.248f, 50.828f);
                j.close();
                j.moveTo(54.046f, 48.018f);
                j.lineTo(12.662f, 48.018f);
                j.cubicTo(9.664f, 55.426f, 8.0f, 63.516f, 8.0f, 72.0f);
                j.cubicTo(8.0f, 78.558f, 9.014f, 84.874f, 10.848f, 90.832f);
                j.lineTo(49.742f, 51.938f);
                j.cubicTo(51.042f, 50.494f, 52.49f, 49.188f, 54.046f, 48.018f);
                j.lineTo(54.046f, 48.018f);
                j.close();
                j.moveTo(41.998f, 128.534f);
                j.lineTo(41.998f, 71.998f);
                j.cubicTo(41.998f, 70.584f, 42.13f, 69.204f, 42.32f, 67.842f);
                j.lineTo(13.114f, 97.048f);
                j.cubicTo(18.87f, 110.554f, 29.116f, 121.684f, 41.998f, 128.534f);
                j.lineTo(41.998f, 128.534f);
                j.close();
                j.moveTo(47.998f, 89.952f);
                j.lineTo(47.998f, 131.328f);
                j.cubicTo(55.412f, 134.33f, 63.508f, 135.998f, 71.998f, 135.998f);
                j.cubicTo(78.582f, 135.998f, 84.918f, 134.976f, 90.894f, 133.128f);
                j.lineTo(52.868f, 95.104f);
                j.cubicTo(51.042f, 93.594f, 49.422f, 91.852f, 47.998f, 89.952f);
                j.lineTo(47.998f, 89.952f);
                j.close();
                j.moveTo(133.18f, 53.178f);
                j.lineTo(93.896f, 92.462f);
                j.cubicTo(92.682f, 93.76f, 91.338f, 94.932f, 89.914f, 96.002f);
                j.lineTo(131.33f, 96.002f);
                j.cubicTo(134.332f, 88.588f, 136.0f, 80.492f, 136.0f, 72.002f);
                j.cubicTo(135.998f, 65.448f, 135.01f, 59.128f, 133.18f, 53.178f);
                j.lineTo(133.18f, 53.178f);
                j.close();
                j.moveTo(67.942f, 101.694f);
                j.lineTo(97.108f, 130.86f);
                j.cubicTo(110.586f, 125.1f, 121.692f, 114.862f, 128.534f, 102.0f);
                j.lineTo(71.998f, 102.0f);
                j.cubicTo(70.62f, 102.0f, 69.272f, 101.874f, 67.942f, 101.694f);
                j.lineTo(67.942f, 101.694f);
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
