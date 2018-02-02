package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aaf extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(72.0f, 144.0f);
                j.cubicTo(32.235497f, 144.0f, 0.0f, 111.7645f, 0.0f, 72.0f);
                j.cubicTo(0.0f, 32.235497f, 32.235497f, 0.0f, 72.0f, 0.0f);
                j.cubicTo(111.7645f, 0.0f, 144.0f, 32.235497f, 144.0f, 72.0f);
                j.cubicTo(144.0f, 111.7645f, 111.7645f, 144.0f, 72.0f, 144.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(42.5f, 80.0f);
                j.cubicTo(38.357864f, 80.0f, 35.0f, 76.642136f, 35.0f, 72.5f);
                j.cubicTo(35.0f, 68.357864f, 38.357864f, 65.0f, 42.5f, 65.0f);
                j.cubicTo(46.642136f, 65.0f, 50.0f, 68.357864f, 50.0f, 72.5f);
                j.cubicTo(50.0f, 76.642136f, 46.642136f, 80.0f, 42.5f, 80.0f);
                j.close();
                j.moveTo(72.5f, 80.0f);
                j.cubicTo(68.357864f, 80.0f, 65.0f, 76.642136f, 65.0f, 72.5f);
                j.cubicTo(65.0f, 68.357864f, 68.357864f, 65.0f, 72.5f, 65.0f);
                j.cubicTo(76.642136f, 65.0f, 80.0f, 68.357864f, 80.0f, 72.5f);
                j.cubicTo(80.0f, 76.642136f, 76.642136f, 80.0f, 72.5f, 80.0f);
                j.close();
                j.moveTo(102.5f, 80.0f);
                j.cubicTo(98.357864f, 80.0f, 95.0f, 76.642136f, 95.0f, 72.5f);
                j.cubicTo(95.0f, 68.357864f, 98.357864f, 65.0f, 102.5f, 65.0f);
                j.cubicTo(106.642136f, 65.0f, 110.0f, 68.357864f, 110.0f, 72.5f);
                j.cubicTo(110.0f, 76.642136f, 106.642136f, 80.0f, 102.5f, 80.0f);
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
