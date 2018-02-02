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

public final class gh extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                j.moveTo(115.8f, 60.68889f);
                j.cubicTo(115.8f, 29.181868f, 90.81813f, 4.2f, 59.31111f, 4.2f);
                j.cubicTo(29.181868f, 4.2f, 4.2f, 29.181868f, 4.2f, 60.68889f);
                j.cubicTo(4.2f, 90.81813f, 29.181868f, 115.8f, 59.31111f, 115.8f);
                j.cubicTo(90.81813f, 115.8f, 115.8f, 90.81813f, 115.8f, 60.68889f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(62.12374f, 65.15995f);
                j.lineTo(60.59251f, 27.389608f);
                j.cubicTo(60.57021f, 26.839443f, 60.108807f, 26.4f, 59.561615f, 26.4f);
                j.lineTo(55.54317f, 26.4f);
                j.cubicTo(55.00337f, 26.4f, 54.53443f, 26.843063f, 54.51227f, 27.389608f);
                j.lineTo(52.833233f, 68.80597f);
                j.cubicTo(52.807594f, 69.43838f, 53.077152f, 69.998924f, 53.51898f, 70.363365f);
                j.cubicTo(53.700817f, 70.78672f, 54.031994f, 71.146774f, 54.481876f, 71.3614f);
                j.lineTo(81.584015f, 84.290726f);
                j.cubicTo(82.09355f, 84.5338f, 82.71503f, 84.33845f, 82.98967f, 83.862755f);
                j.lineTo(84.3951f, 81.42847f);
                j.cubicTo(84.6709f, 80.95077f, 84.51857f, 80.31419f, 84.05744f, 80.00215f);
                j.lineTo(62.12374f, 65.15995f);
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
