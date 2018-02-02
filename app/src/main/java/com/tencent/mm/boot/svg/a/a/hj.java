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

public final class hj extends c {
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
                i2.setColor(-8683387);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(79.0f, 66.0f);
                j.cubicTo(79.0f, 69.816f, 77.14933f, 73.0f, 73.0f, 73.0f);
                j.lineTo(71.0f, 73.0f);
                j.cubicTo(68.790665f, 73.0f, 67.0f, 71.209335f, 67.0f, 69.0f);
                j.cubicTo(67.0f, 66.790665f, 68.790665f, 65.0f, 71.0f, 65.0f);
                j.lineTo(79.0f, 65.0f);
                j.lineTo(79.0f, 66.0f);
                j.close();
                j.moveTo(88.0f, 63.0f);
                j.lineTo(88.0f, 56.0f);
                j.lineTo(88.0f, 56.0f);
                j.lineTo(88.0f, 56.0f);
                j.lineTo(88.0f, 53.0f);
                j.cubicTo(87.62795f, 46.030872f, 82.82739f, 40.0f, 74.0f, 40.0f);
                j.cubicTo(65.76251f, 40.0f, 60.369316f, 44.77833f, 60.0f, 52.0f);
                j.lineTo(60.0f, 52.0f);
                j.lineTo(69.0f, 52.0f);
                j.cubicTo(69.03787f, 49.75115f, 70.876205f, 48.206196f, 74.0f, 48.0f);
                j.cubicTo(77.81914f, 48.206196f, 79.44887f, 50.382885f, 79.0f, 53.0f);
                j.lineTo(79.0f, 56.0f);
                j.lineTo(79.0f, 56.0f);
                j.lineTo(79.0f, 56.0f);
                j.lineTo(71.0f, 56.0f);
                j.cubicTo(64.02007f, 56.401913f, 59.0f, 61.49816f, 59.0f, 69.0f);
                j.lineTo(59.0f, 69.0f);
                j.cubicTo(59.0f, 75.9452f, 64.09324f, 80.99727f, 71.0f, 81.0f);
                j.lineTo(72.0f, 81.0f);
                j.cubicTo(75.0855f, 80.99727f, 77.94593f, 80.10591f, 80.0f, 79.0f);
                j.cubicTo(80.66957f, 80.370995f, 80.938614f, 81.0f, 81.0f, 81.0f);
                j.lineTo(89.0f, 81.0f);
                j.cubicTo(89.0f, 81.0f, 87.63159f, 77.32937f, 88.0f, 63.0f);
                j.lineTo(88.0f, 63.0f);
                j.close();
                j.moveTo(22.0f, 56.0f);
                j.lineTo(28.0f, 32.0f);
                j.lineTo(34.0f, 56.0f);
                j.lineTo(22.0f, 56.0f);
                j.close();
                j.moveTo(36.0f, 16.0f);
                j.lineTo(32.0f, 16.0f);
                j.lineTo(24.0f, 16.0f);
                j.lineTo(24.0f, 16.0f);
                j.lineTo(10.0f, 73.0f);
                j.lineTo(6.0f, 73.0f);
                j.lineTo(6.0f, 81.0f);
                j.lineTo(22.0f, 81.0f);
                j.lineTo(22.0f, 73.0f);
                j.lineTo(18.0f, 73.0f);
                j.lineTo(20.0f, 65.0f);
                j.lineTo(37.0f, 65.0f);
                j.lineTo(39.0f, 73.0f);
                j.lineTo(35.0f, 73.0f);
                j.lineTo(35.0f, 81.0f);
                j.lineTo(55.0f, 81.0f);
                j.lineTo(55.0f, 73.0f);
                j.lineTo(51.0f, 73.0f);
                j.lineTo(36.0f, 16.0f);
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
