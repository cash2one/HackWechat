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

public final class agm extends c {
    private final int height = 186;
    private final int width = 186;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                a.setColor(-15683841);
                Path j = c.j(looper);
                j.moveTo(186.0f, 94.14815f);
                j.cubicTo(186.0f, 41.636444f, 144.36356f, 0.0f, 91.85185f, 0.0f);
                j.cubicTo(41.636444f, 0.0f, 0.0f, 41.636444f, 0.0f, 94.14815f);
                j.cubicTo(0.0f, 144.36356f, 41.636444f, 186.0f, 91.85185f, 186.0f);
                j.cubicTo(144.36356f, 186.0f, 186.0f, 144.36356f, 186.0f, 94.14815f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(96.53957f, 101.59992f);
                j.lineTo(93.96079f, 37.990128f);
                j.cubicTo(93.93903f, 37.45337f, 93.475f, 37.0f, 92.925255f, 37.0f);
                j.lineTo(84.91605f, 37.0f);
                j.cubicTo(84.37632f, 37.0f, 83.90268f, 37.443295f, 83.880516f, 37.990128f);
                j.lineTo(81.00167f, 109.00153f);
                j.cubicTo(80.974144f, 109.68064f, 81.28838f, 110.28124f, 81.79111f, 110.64247f);
                j.cubicTo(81.98214f, 110.944756f, 82.25776f, 111.19843f, 82.60479f, 111.36398f);
                j.lineTo(129.58261f, 133.77519f);
                j.cubicTo(130.08742f, 134.016f, 130.7105f, 133.8202f, 130.98582f, 133.34332f);
                j.lineTo(133.9888f, 128.14203f);
                j.cubicTo(134.26079f, 127.67092f, 134.11714f, 127.02809f, 133.66052f, 126.71911f);
                j.lineTo(96.53957f, 101.59992f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
