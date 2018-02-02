package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class co extends c {
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
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 15.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(33.0f, 66.0f);
                j.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                j.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                j.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                j.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
                j.close();
                j.moveTo(33.0f, 63.0f);
                j.cubicTo(49.568542f, 63.0f, 63.0f, 49.568542f, 63.0f, 33.0f);
                j.cubicTo(63.0f, 16.431458f, 49.568542f, 3.0f, 33.0f, 3.0f);
                j.cubicTo(16.431458f, 3.0f, 3.0f, 16.431458f, 3.0f, 33.0f);
                j.cubicTo(3.0f, 49.568542f, 16.431458f, 63.0f, 33.0f, 63.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(25.401f, 47.627f);
                j.cubicTo(20.217f, 47.627f, 16.0f, 44.08f, 16.0f, 39.72f);
                j.cubicTo(16.0f, 35.36f, 20.217f, 31.814f, 25.401f, 31.814f);
                j.cubicTo(26.23f, 31.814f, 26.901f, 32.485f, 26.901f, 33.314f);
                j.cubicTo(26.901f, 34.142f, 26.23f, 34.814f, 25.401f, 34.814f);
                j.cubicTo(21.871f, 34.814f, 19.0f, 37.015f, 19.0f, 39.72f);
                j.cubicTo(19.0f, 42.426f, 21.871f, 44.627f, 25.401f, 44.627f);
                j.cubicTo(28.931f, 44.627f, 31.802f, 42.426f, 31.802f, 39.72f);
                j.lineTo(31.802f, 26.907f);
                j.cubicTo(31.802f, 22.547f, 36.02f, 19.0f, 41.204f, 19.0f);
                j.cubicTo(46.388f, 19.0f, 50.605f, 22.547f, 50.605f, 26.907f);
                j.cubicTo(50.605f, 31.267f, 46.388f, 34.814f, 41.204f, 34.814f);
                j.cubicTo(40.375f, 34.814f, 39.704f, 34.142f, 39.704f, 33.314f);
                j.cubicTo(39.704f, 32.485f, 40.375f, 31.814f, 41.204f, 31.814f);
                j.cubicTo(44.734f, 31.814f, 47.605f, 29.612f, 47.605f, 26.907f);
                j.cubicTo(47.605f, 24.201f, 44.734f, 22.0f, 41.204f, 22.0f);
                j.cubicTo(37.674f, 22.0f, 34.802f, 24.201f, 34.802f, 26.907f);
                j.lineTo(34.802f, 39.72f);
                j.cubicTo(34.802f, 44.08f, 30.585f, 47.627f, 25.401f, 47.627f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
