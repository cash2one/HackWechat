package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adz extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                i2.setColor(-8617594);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(76.32146f, 92.67854f);
                j.cubicTo(84.11785f, 100.47494f, 91.50503f, 104.13172f, 94.23683f, 103.91758f);
                j.cubicTo(96.96864f, 103.70344f, 103.77161f, 99.02503f, 106.98316f, 99.0873f);
                j.cubicTo(108.526665f, 99.117226f, 118.61296f, 105.93859f, 119.83391f, 106.72726f);
                j.cubicTo(121.054855f, 107.515915f, 122.18694f, 108.43717f, 121.97407f, 109.60293f);
                j.cubicTo(121.7612f, 110.768684f, 117.32839f, 123.60948f, 106.01143f, 121.83133f);
                j.cubicTo(94.694466f, 120.05317f, 78.91704f, 107.853294f, 69.926674f, 99.073326f);
                j.lineTo(76.32146f, 92.67854f);
                j.lineTo(76.32146f, 92.67854f);
                j.close();
                j.moveTo(76.32146f, 92.67854f);
                j.cubicTo(68.52506f, 84.88215f, 64.86828f, 77.49497f, 65.08242f, 74.76317f);
                j.cubicTo(65.29656f, 72.03136f, 69.97497f, 65.22839f, 69.9127f, 62.016838f);
                j.cubicTo(69.882774f, 60.47334f, 63.06141f, 50.38704f, 62.272747f, 49.166092f);
                j.cubicTo(61.484085f, 47.945145f, 60.56283f, 46.813057f, 59.39707f, 47.02593f);
                j.cubicTo(58.231316f, 47.2388f, 45.39052f, 51.67161f, 47.168674f, 62.98857f);
                j.cubicTo(48.94683f, 74.305534f, 61.146706f, 90.08296f, 69.926674f, 99.073326f);
                j.lineTo(76.32146f, 92.67854f);
                j.lineTo(76.32146f, 92.67854f);
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
