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

public final class uw extends c {
    private final int height = 75;
    private final int width = 75;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                i2.setColor(-15028967);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(37.5f, 45.0f);
                j.cubicTo(41.642136f, 45.0f, 45.0f, 41.642136f, 45.0f, 37.5f);
                j.cubicTo(45.0f, 33.357864f, 41.642136f, 30.0f, 37.5f, 30.0f);
                j.cubicTo(33.357864f, 30.0f, 30.0f, 33.357864f, 30.0f, 37.5f);
                j.cubicTo(30.0f, 41.642136f, 33.357864f, 45.0f, 37.5f, 45.0f);
                j.close();
                j.moveTo(64.5f, 45.0f);
                j.cubicTo(68.642136f, 45.0f, 72.0f, 41.642136f, 72.0f, 37.5f);
                j.cubicTo(72.0f, 33.357864f, 68.642136f, 30.0f, 64.5f, 30.0f);
                j.cubicTo(60.357864f, 30.0f, 57.0f, 33.357864f, 57.0f, 37.5f);
                j.cubicTo(57.0f, 41.642136f, 60.357864f, 45.0f, 64.5f, 45.0f);
                j.close();
                j.moveTo(10.5f, 45.0f);
                j.cubicTo(14.642136f, 45.0f, 18.0f, 41.642136f, 18.0f, 37.5f);
                j.cubicTo(18.0f, 33.357864f, 14.642136f, 30.0f, 10.5f, 30.0f);
                j.cubicTo(6.3578644f, 30.0f, 3.0f, 33.357864f, 3.0f, 37.5f);
                j.cubicTo(3.0f, 41.642136f, 6.3578644f, 45.0f, 10.5f, 45.0f);
                j.close();
                j.moveTo(37.5f, 72.0f);
                j.cubicTo(41.642136f, 72.0f, 45.0f, 68.642136f, 45.0f, 64.5f);
                j.cubicTo(45.0f, 60.357864f, 41.642136f, 57.0f, 37.5f, 57.0f);
                j.cubicTo(33.357864f, 57.0f, 30.0f, 60.357864f, 30.0f, 64.5f);
                j.cubicTo(30.0f, 68.642136f, 33.357864f, 72.0f, 37.5f, 72.0f);
                j.close();
                j.moveTo(64.5f, 72.0f);
                j.cubicTo(68.642136f, 72.0f, 72.0f, 68.642136f, 72.0f, 64.5f);
                j.cubicTo(72.0f, 60.357864f, 68.642136f, 57.0f, 64.5f, 57.0f);
                j.cubicTo(60.357864f, 57.0f, 57.0f, 60.357864f, 57.0f, 64.5f);
                j.cubicTo(57.0f, 68.642136f, 60.357864f, 72.0f, 64.5f, 72.0f);
                j.close();
                j.moveTo(10.5f, 72.0f);
                j.cubicTo(14.642136f, 72.0f, 18.0f, 68.642136f, 18.0f, 64.5f);
                j.cubicTo(18.0f, 60.357864f, 14.642136f, 57.0f, 10.5f, 57.0f);
                j.cubicTo(6.3578644f, 57.0f, 3.0f, 60.357864f, 3.0f, 64.5f);
                j.cubicTo(3.0f, 68.642136f, 6.3578644f, 72.0f, 10.5f, 72.0f);
                j.close();
                j.moveTo(37.5f, 18.0f);
                j.cubicTo(41.642136f, 18.0f, 45.0f, 14.642136f, 45.0f, 10.5f);
                j.cubicTo(45.0f, 6.3578644f, 41.642136f, 3.0f, 37.5f, 3.0f);
                j.cubicTo(33.357864f, 3.0f, 30.0f, 6.3578644f, 30.0f, 10.5f);
                j.cubicTo(30.0f, 14.642136f, 33.357864f, 18.0f, 37.5f, 18.0f);
                j.close();
                j.moveTo(64.5f, 18.0f);
                j.cubicTo(68.642136f, 18.0f, 72.0f, 14.642136f, 72.0f, 10.5f);
                j.cubicTo(72.0f, 6.3578644f, 68.642136f, 3.0f, 64.5f, 3.0f);
                j.cubicTo(60.357864f, 3.0f, 57.0f, 6.3578644f, 57.0f, 10.5f);
                j.cubicTo(57.0f, 14.642136f, 60.357864f, 18.0f, 64.5f, 18.0f);
                j.close();
                j.moveTo(10.5f, 18.0f);
                j.cubicTo(14.642136f, 18.0f, 18.0f, 14.642136f, 18.0f, 10.5f);
                j.cubicTo(18.0f, 6.3578644f, 14.642136f, 3.0f, 10.5f, 3.0f);
                j.cubicTo(6.3578644f, 3.0f, 3.0f, 6.3578644f, 3.0f, 10.5f);
                j.cubicTo(3.0f, 14.642136f, 6.3578644f, 18.0f, 10.5f, 18.0f);
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
