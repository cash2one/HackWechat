package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class alz extends c {
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
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(96.0f, 48.0f);
                j.cubicTo(96.0f, 21.490332f, 74.50967f, 0.0f, 48.0f, 0.0f);
                j.cubicTo(21.490332f, 0.0f, 0.0f, 21.490332f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 74.50967f, 21.490332f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(74.50967f, 96.0f, 96.0f, 74.50967f, 96.0f, 48.0f);
                j.close();
                j.moveTo(2.2325583f, 48.0f);
                j.cubicTo(2.2325583f, 22.72334f, 22.72334f, 2.2325583f, 48.0f, 2.2325583f);
                j.cubicTo(73.27666f, 2.2325583f, 93.76744f, 22.72334f, 93.76744f, 48.0f);
                j.cubicTo(93.76744f, 73.27666f, 73.27666f, 93.76744f, 48.0f, 93.76744f);
                j.cubicTo(22.72334f, 93.76744f, 2.2325583f, 73.27666f, 2.2325583f, 48.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(52.426956f, 73.07245f);
                j.cubicTo(58.93997f, 66.8784f, 63.0f, 58.12903f, 63.0f, 48.431385f);
                j.cubicTo(63.0f, 38.842663f, 59.030663f, 30.181034f, 52.645496f, 24.0f);
                j.lineTo(48.40217f, 28.243324f);
                j.cubicTo(53.701862f, 33.337967f, 57.0f, 40.499516f, 57.0f, 48.431385f);
                j.cubicTo(57.0f, 56.472187f, 53.61065f, 63.721367f, 48.182682f, 68.82818f);
                j.lineTo(52.426956f, 73.07245f);
                j.close();
                j.moveTo(42.522125f, 63.16762f);
                j.cubicTo(46.504047f, 59.511826f, 49.0f, 54.263084f, 49.0f, 48.431385f);
                j.cubicTo(49.0f, 42.708645f, 46.596447f, 37.547287f, 42.743767f, 33.90173f);
                j.lineTo(38.4988f, 38.146698f);
                j.cubicTo(41.266747f, 40.704395f, 43.0f, 44.36548f, 43.0f, 48.431385f);
                j.cubicTo(43.0f, 52.60631f, 41.17255f, 56.354416f, 38.273926f, 58.91942f);
                j.lineTo(42.522125f, 63.16762f);
                j.close();
                j.moveTo(33.30555f, 53.951042f);
                j.cubicTo(34.945602f, 52.669918f, 36.0f, 50.673786f, 36.0f, 48.431385f);
                j.cubicTo(36.0f, 46.298347f, 35.045944f, 44.38814f, 33.541275f, 43.104218f);
                j.lineTo(28.0f, 48.645496f);
                j.lineTo(33.30555f, 53.951042f);
                j.close();
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
