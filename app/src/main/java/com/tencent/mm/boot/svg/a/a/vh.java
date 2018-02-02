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

public final class vh extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i2.setColor(-350642);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(44.999012f, 71.646385f);
                j.lineTo(18.06173f, 87.246506f);
                j.cubicTo(16.15247f, 88.35221f, 15.124873f, 87.53144f, 15.765567f, 85.41645f);
                j.lineTo(24.811031f, 55.55646f);
                j.lineTo(1.0043138f, 34.66419f);
                j.cubicTo(-0.6587564f, 33.204716f, -0.20764746f, 32.021576f, 1.9966353f, 32.021576f);
                j.lineTo(31.459358f, 32.021576f);
                j.lineTo(43.445843f, 3.5297964f);
                j.cubicTo(44.303635f, 1.4908304f, 45.69375f, 1.4893055f, 46.552185f, 3.5297964f);
                j.lineTo(58.538666f, 32.021576f);
                j.lineTo(88.00139f, 32.021576f);
                j.cubicTo(90.2125f, 32.021576f, 90.65668f, 33.204803f, 88.99371f, 34.66419f);
                j.lineTo(65.187f, 55.55646f);
                j.lineTo(74.23246f, 85.41645f);
                j.cubicTo(74.87358f, 87.53287f, 73.84428f, 88.35146f, 71.936295f, 87.246506f);
                j.lineTo(44.999012f, 71.646385f);
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
