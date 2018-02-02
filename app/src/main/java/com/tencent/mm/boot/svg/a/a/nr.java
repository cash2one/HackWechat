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

public final class nr extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i3 = c.a(i2, looper);
                i3.setColor(-352965);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(81.0f, 72.0f);
                j2.lineTo(75.0f, 72.0f);
                j2.lineTo(75.0f, 69.0f);
                j2.lineTo(81.0f, 69.0f);
                j2.lineTo(81.0f, 63.0f);
                j2.lineTo(84.0f, 63.0f);
                j2.lineTo(84.0f, 69.0f);
                j2.lineTo(90.0f, 69.0f);
                j2.lineTo(90.0f, 72.0f);
                j2.lineTo(84.0f, 72.0f);
                j2.lineTo(84.0f, 78.0f);
                j2.lineTo(81.0f, 78.0f);
                j2.lineTo(81.0f, 72.0f);
                j2.close();
                j2.moveTo(70.593575f, 84.0f);
                j2.lineTo(26.608969f, 84.0f);
                j2.cubicTo(25.016039f, 84.0f, 24.0f, 82.823204f, 24.0f, 81.33677f);
                j2.lineTo(24.0f, 77.34148f);
                j2.cubicTo(24.0f, 74.14615f, 28.882536f, 71.76532f, 39.652912f, 65.62255f);
                j2.cubicTo(42.65363f, 63.91184f, 48.8724f, 61.21774f, 44.842228f, 55.012318f);
                j2.cubicTo(41.80037f, 50.327835f, 39.20482f, 48.31566f, 39.20482f, 40.414963f);
                j2.cubicTo(39.20482f, 32.215527f, 45.00322f, 24.0f, 54.0f, 24.0f);
                j2.cubicTo(62.99678f, 24.0f, 68.79518f, 32.215527f, 68.79518f, 40.414963f);
                j2.cubicTo(68.79518f, 48.31566f, 66.19963f, 50.327835f, 63.157772f, 55.012318f);
                j2.cubicTo(60.146255f, 59.649273f, 62.85746f, 62.325607f, 65.672424f, 64.09607f);
                j2.cubicTo(64.914856f, 66.0857f, 64.5f, 68.244385f, 64.5f, 70.5f);
                j2.cubicTo(64.5f, 75.87621f, 66.85677f, 80.7018f, 70.593575f, 84.0f);
                j2.lineTo(70.593575f, 84.0f);
                j2.close();
                j2.moveTo(69.0f, 70.50122f);
                j2.cubicTo(69.0f, 71.18327f, 69.05058f, 71.8535f, 69.14821f, 72.50836f);
                j2.cubicTo(70.11773f, 79.01188f, 75.72652f, 84.0f, 82.5f, 84.0f);
                j2.cubicTo(89.95676f, 84.0f, 96.0f, 77.95676f, 96.0f, 70.50122f);
                j2.cubicTo(96.0f, 63.044464f, 89.95676f, 57.0f, 82.5f, 57.0f);
                j2.cubicTo(75.044464f, 57.0f, 69.0f, 63.044464f, 69.0f, 70.50122f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
