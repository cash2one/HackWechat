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

public final class ajc extends c {
    private final int height = 96;
    private final int width = 584;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 584;
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
                i2.setColor(419430400);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 9.00051f);
                j.cubicTo(0.0f, 4.0296655f, 4.0212784f, 0.0f, 8.997707f, 0.0f);
                j.lineTo(575.0023f, 0.0f);
                j.cubicTo(579.9716f, 0.0f, 584.0f, 4.0326095f, 584.0f, 9.00051f);
                j.lineTo(584.0f, 76.99949f);
                j.cubicTo(584.0f, 81.97034f, 579.9787f, 86.0f, 575.0023f, 86.0f);
                j.lineTo(8.997707f, 86.0f);
                j.cubicTo(4.028411f, 86.0f, 0.0f, 81.96739f, 0.0f, 76.99949f);
                j.lineTo(0.0f, 9.00051f);
                j.close();
                j.moveTo(113.04867f, 96.0f);
                j.lineTo(104.0f, 86.0f);
                j.lineTo(122.09733f, 86.0f);
                j.lineTo(113.04867f, 96.0f);
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
