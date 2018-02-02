package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aat extends c {
    private final int height = 84;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 84;
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
                e = c.a(e, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -155.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 194.0f, 0.0f, 1.0f, 155.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 84.0f);
                j.lineTo(0.0f, 84.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                j = c.j(looper);
                j.moveTo(26.949f, 16.841825f);
                j.cubicTo(33.649f, 12.678541f, 41.638f, 10.73867f, 49.503f, 11.028203f);
                j.cubicTo(57.468f, 11.295772f, 65.408f, 13.88859f, 71.778f, 18.713806f);
                j.cubicTo(74.781f, 20.984144f, 77.423f, 23.748686f, 79.47f, 26.910585f);
                j.cubicTo(81.411f, 29.898766f, 82.805f, 33.248363f, 83.491f, 36.746723f);
                j.cubicTo(84.316f, 40.921986f, 84.131f, 45.29194f, 82.953f, 49.382343f);
                j.cubicTo(81.294f, 55.208942f, 77.656f, 60.36962f, 73.004f, 64.21442f);
                j.cubicTo(67.825f, 68.51448f, 61.43f, 71.26305f, 54.799f, 72.346306f);
                j.cubicTo(45.676f, 73.84489f, 36.002f, 72.303375f, 27.968f, 67.669846f);
                j.cubicTo(22.646f, 69.41203f, 17.323f, 71.15622f, 12.0f, 72.899414f);
                j.cubicTo(14.104f, 68.41964f, 16.21f, 63.94186f, 18.312f, 59.461086f);
                j.cubicTo(15.922f, 56.467915f, 14.079f, 53.024467f, 13.034f, 49.336414f);
                j.cubicTo(11.356f, 43.516804f, 11.74f, 37.141087f, 14.082f, 31.557093f);
                j.cubicTo(16.618f, 25.418991f, 21.327f, 20.318218f, 26.949f, 16.841825f);
                j.lineTo(26.949f, 16.841825f);
                j.close();
                j.moveTo(39.728f, 15.903339f);
                j.cubicTo(33.562f, 17.28511f, 27.702f, 20.30524f, 23.271f, 24.840925f);
                j.cubicTo(20.666f, 27.504627f, 18.584f, 30.699474f, 17.338f, 34.215805f);
                j.cubicTo(15.605f, 39.044018f, 15.557f, 44.450294f, 17.208f, 49.30746f);
                j.cubicTo(18.376f, 52.79384f, 20.372f, 55.975708f, 22.882f, 58.655384f);
                j.cubicTo(21.586f, 61.40595f, 20.294f, 64.15751f, 19.001f, 66.90907f);
                j.cubicTo(22.312f, 65.80685f, 25.624f, 64.70563f, 28.935f, 63.602406f);
                j.cubicTo(31.917f, 65.4634f, 35.193f, 66.84318f, 38.596f, 67.72276f);
                j.cubicTo(46.704f, 69.803406f, 55.538f, 69.15245f, 63.176f, 65.68704f);
                j.cubicTo(68.381f, 63.324852f, 73.04f, 59.60785f, 76.146f, 54.78263f);
                j.cubicTo(78.169f, 51.65268f, 79.492f, 48.059475f, 79.873f, 44.34846f);
                j.cubicTo(80.256f, 40.74727f, 79.764f, 37.061214f, 78.465f, 33.680668f);
                j.cubicTo(77.237f, 30.463856f, 75.308f, 27.531584f, 72.929f, 25.04759f);
                j.cubicTo(70.65f, 22.666431f, 67.965f, 20.684628f, 65.056f, 19.138123f);
                j.cubicTo(57.369f, 15.0547085f, 48.197f, 14.01239f, 39.728f, 15.903339f);
                j.lineTo(39.728f, 15.903339f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
