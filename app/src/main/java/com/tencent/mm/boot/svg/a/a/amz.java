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

public final class amz extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                i2.setColor(-8286571);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(80.99659f, 75.89866f);
                j.cubicTo(80.944244f, 70.920204f, 79.92921f, 69.644585f, 63.000206f, 60.301033f);
                j.cubicTo(59.50676f, 58.372242f, 52.14093f, 55.336243f, 57.00217f, 48.349346f);
                j.cubicTo(57.38224f, 47.802f, 57.622345f, 47.250103f, 57.758896f, 46.699345f);
                j.cubicTo(60.69021f, 43.234344f, 62.82838f, 38.70993f, 62.974033f, 34.499588f);
                j.lineTo(63.001347f, 34.499588f);
                j.lineTo(63.001347f, 28.500414f);
                j.lineTo(62.930794f, 28.500414f);
                j.cubicTo(62.221863f, 18.878069f, 54.32576f, 15.0f, 48.001137f, 15.0f);
                j.cubicTo(41.66969f, 15.0f, 33.76562f, 18.660725f, 33.069206f, 28.500414f);
                j.lineTo(33.00093f, 28.500414f);
                j.lineTo(33.00093f, 34.499588f);
                j.lineTo(33.02824f, 34.499588f);
                j.cubicTo(33.173897f, 38.70993f, 35.31207f, 43.234344f, 38.243378f, 46.699345f);
                j.cubicTo(38.379932f, 47.248966f, 38.618896f, 47.802f, 39.000103f, 48.349346f);
                j.cubicTo(43.860207f, 55.336243f, 36.49438f, 58.37338f, 33.002068f, 60.301033f);
                j.cubicTo(16.073069f, 69.644585f, 15.058035f, 70.920204f, 15.00569f, 75.89866f);
                j.cubicTo(15.00569f, 75.9089f, 15.002275f, 75.919136f, 15.002275f, 75.93052f);
                j.lineTo(15.002275f, 77.06845f);
                j.cubicTo(15.002275f, 79.23848f, 16.762655f, 80.99886f, 18.933828f, 80.99886f);
                j.lineTo(77.070724f, 80.99886f);
                j.cubicTo(79.2419f, 80.99886f, 81.00227f, 79.23848f, 81.00227f, 77.06845f);
                j.lineTo(81.00227f, 75.93052f);
                j.cubicTo(81.0f, 75.92027f, 80.99659f, 75.910034f, 80.99659f, 75.89866f);
                j.lineTo(80.99659f, 75.89866f);
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
