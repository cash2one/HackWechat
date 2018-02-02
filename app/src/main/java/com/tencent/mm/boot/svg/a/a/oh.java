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

public final class oh extends c {
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
                i3.setColor(-14187817);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(44.842228f, 55.012318f);
                j2.cubicTo(48.8724f, 61.21774f, 42.65363f, 63.91184f, 39.652912f, 65.62255f);
                j2.cubicTo(28.882536f, 71.76532f, 24.0f, 74.14615f, 24.0f, 77.34148f);
                j2.lineTo(24.0f, 81.33677f);
                j2.cubicTo(24.0f, 82.823204f, 25.016039f, 84.0f, 26.608969f, 84.0f);
                j2.lineTo(81.39103f, 84.0f);
                j2.cubicTo(82.98396f, 84.0f, 84.0f, 82.823204f, 84.0f, 81.33677f);
                j2.lineTo(84.0f, 77.34148f);
                j2.cubicTo(84.0f, 74.14615f, 79.11746f, 71.76532f, 68.347084f, 65.62255f);
                j2.cubicTo(65.346375f, 63.91184f, 59.1276f, 61.21774f, 63.157772f, 55.012318f);
                j2.cubicTo(66.19963f, 50.327835f, 68.79518f, 48.31566f, 68.79518f, 40.414963f);
                j2.cubicTo(68.79518f, 32.215527f, 62.99678f, 24.0f, 54.0f, 24.0f);
                j2.cubicTo(45.00322f, 24.0f, 39.20482f, 32.215527f, 39.20482f, 40.414963f);
                j2.cubicTo(39.20482f, 48.31566f, 41.80037f, 50.327835f, 44.842228f, 55.012318f);
                j2.close();
                j2.moveTo(49.0f, 76.71384f);
                j2.lineTo(54.0f, 83.0f);
                j2.lineTo(59.0f, 76.71384f);
                j2.lineTo(54.0f, 61.0f);
                j2.lineTo(49.0f, 76.71384f);
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
