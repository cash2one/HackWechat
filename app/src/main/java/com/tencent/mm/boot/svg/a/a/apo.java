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

public final class apo extends c {
    private final int height = 265;
    private final int width = 222;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 222;
            case 1:
                return 265;
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
                canvas.saveLayerAlpha(null, 25, 4);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 0.6293204f, -0.777146f, 114.51628f, 0.777146f, 0.6293204f, 1.1047013f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(129.8682f, 161.8563f);
                j.lineTo(40.530926f, 161.8563f);
                j.cubicTo(26.720047f, 141.8038f, 1.1368684E-12f, 120.81583f, 1.1368684E-12f, 86.32336f);
                j.cubicTo(1.1368684E-12f, 38.648285f, 38.14514f, -1.409827E-12f, 85.199554f, -1.3926638E-12f);
                j.cubicTo(132.25397f, -1.3902678E-12f, 170.39911f, 38.648285f, 170.39911f, 86.32336f);
                j.cubicTo(170.39911f, 120.81583f, 143.67906f, 141.8038f, 129.8682f, 161.8563f);
                j.close();
                j.moveTo(55.37971f, 173.21463f);
                j.lineTo(115.0194f, 173.21463f);
                j.cubicTo(117.37212f, 173.21463f, 119.27938f, 175.12161f, 119.27938f, 177.47401f);
                j.lineTo(119.27938f, 180.3136f);
                j.cubicTo(119.27938f, 182.66599f, 117.37212f, 184.57297f, 115.0194f, 184.57297f);
                j.lineTo(55.37971f, 184.57297f);
                j.cubicTo(53.026993f, 184.57297f, 51.11973f, 182.66599f, 51.11973f, 180.3136f);
                j.lineTo(51.11973f, 177.47401f);
                j.cubicTo(51.11973f, 175.12161f, 53.026993f, 173.21463f, 55.37971f, 173.21463f);
                j.close();
                j.moveTo(63.899666f, 195.9313f);
                j.lineTo(106.49944f, 195.9313f);
                j.cubicTo(108.852165f, 195.9313f, 110.75942f, 197.83829f, 110.75942f, 200.19069f);
                j.lineTo(110.75942f, 203.03027f);
                j.cubicTo(110.75942f, 205.38266f, 108.852165f, 207.28964f, 106.49944f, 207.28964f);
                j.lineTo(63.899666f, 207.28964f);
                j.cubicTo(61.546947f, 207.28964f, 59.63969f, 205.38266f, 59.63969f, 203.03027f);
                j.lineTo(59.63969f, 200.19069f);
                j.cubicTo(59.63969f, 197.83829f, 61.546947f, 195.9313f, 63.899666f, 195.9313f);
                j.close();
                j.moveTo(87.99253f, 105.08893f);
                j.cubicTo(90.35236f, 109.80792f, 97.08666f, 109.80792f, 99.446495f, 105.08893f);
                j.lineTo(110.75942f, 82.46626f);
                j.lineTo(122.07235f, 105.08893f);
                j.cubicTo(123.65404f, 108.25185f, 127.500305f, 109.5337f, 130.66322f, 107.95201f);
                j.cubicTo(133.82616f, 106.37032f, 135.108f, 102.524055f, 133.52632f, 99.36113f);
                j.lineTo(116.486404f, 65.286125f);
                j.cubicTo(114.12657f, 60.567127f, 107.39227f, 60.567127f, 105.03244f, 65.286125f);
                j.lineTo(93.71951f, 87.90878f);
                j.lineTo(82.406586f, 65.286125f);
                j.cubicTo(80.04675f, 60.567127f, 73.31245f, 60.567127f, 70.95262f, 65.286125f);
                j.lineTo(59.63969f, 87.90878f);
                j.lineTo(48.32676f, 65.286125f);
                j.cubicTo(46.745075f, 62.1232f, 42.898808f, 60.84135f, 39.73588f, 62.42304f);
                j.cubicTo(36.572956f, 64.00472f, 35.29111f, 67.85099f, 36.872795f, 71.013916f);
                j.lineTo(53.91271f, 105.08893f);
                j.cubicTo(56.272537f, 109.80792f, 63.00684f, 109.80792f, 65.36667f, 105.08893f);
                j.lineTo(76.6796f, 82.46626f);
                j.lineTo(87.99253f, 105.08893f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
