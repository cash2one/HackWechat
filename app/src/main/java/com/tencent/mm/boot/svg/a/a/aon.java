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

public final class aon extends c {
    private final int height = 52;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 52;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-9139786);
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(19.4f, 0.0f);
                j.lineTo(45.39f, 0.0f);
                j.cubicTo(45.87f, 1.9689571f, 46.06f, 3.9878876f, 46.12f, 6.0068183f);
                j.cubicTo(51.06f, 6.086776f, 56.02f, 5.7569504f, 60.95f, 6.1567388f);
                j.cubicTo(63.61f, 6.2666807f, 65.29f, 8.605442f, 66.0f, 10.944203f);
                j.lineTo(66.0f, 43.96671f);
                j.cubicTo(65.34f, 46.72525f, 63.07f, 49.06401f, 60.08f, 48.904095f);
                j.cubicTo(42.37f, 49.06401f, 24.65f, 48.944073f, 6.93f, 48.964066f);
                j.cubicTo(3.74f, 49.293888f, 0.86f, 47.324932f, 0.0f, 44.226574f);
                j.lineTo(0.0f, 11.014166f);
                j.cubicTo(0.67f, 8.955256f, 1.89f, 6.726437f, 4.23f, 6.2966647f);
                j.cubicTo(9.06f, 5.6270194f, 13.96f, 6.1367493f, 18.82f, 6.0068183f);
                j.cubicTo(19.05f, 4.007877f, 19.27f, 2.008936f, 19.4f, 0.0f);
                j.lineTo(19.4f, 0.0f);
                j.close();
                j.moveTo(28.390493f, 10.6254015f);
                j.cubicTo(21.38109f, 12.364714f, 15.771568f, 18.70221f, 15.111625f, 25.929352f);
                j.cubicTo(14.381687f, 32.00695f, 17.28144f, 38.294464f, 22.351007f, 41.723106f);
                j.cubicTo(29.330412f, 46.68115f, 39.75952f, 45.961433f, 45.879f, 39.913822f);
                j.cubicTo(50.78858f, 35.275658f, 52.328453f, 27.618683f, 49.798668f, 21.391146f);
                j.cubicTo(46.728928f, 13.064437f, 36.919765f, 8.196362f, 28.390493f, 10.6254015f);
                j.lineTo(28.390493f, 10.6254015f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(29.357378f, 16.571178f);
                j.cubicTo(35.96738f, 14.336706f, 44.02519f, 18.905405f, 44.86392f, 25.967936f);
                j.cubicTo(45.942287f, 32.382072f, 40.450596f, 38.576748f, 34.090218f, 38.925884f);
                j.cubicTo(27.719856f, 39.68401f, 21.17975f, 34.526764f, 21.019993f, 28.002903f);
                j.cubicTo(20.69049f, 22.835684f, 24.474766f, 18.017601f, 29.357378f, 16.571178f);
                j.lineTo(29.357378f, 16.571178f);
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
