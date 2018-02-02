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

public final class aa extends c {
    private final int height = 57;
    private final int width = 57;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 57;
            case 1:
                return 57;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -9.0f, 0.0f, 1.0f, -10.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, 0.70710677f, -16.991314f, -0.70710677f, 0.70710677f, 40.313557f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(43.16711f, 52.7369f);
                j.cubicTo(54.452175f, 51.26688f, 63.16711f, 41.61657f, 63.16711f, 29.93078f);
                j.cubicTo(63.16711f, 17.228231f, 52.86966f, 6.930781f, 40.16711f, 6.930781f);
                j.cubicTo(27.46456f, 6.930781f, 17.167109f, 17.228231f, 17.167109f, 29.93078f);
                j.cubicTo(17.167109f, 41.61657f, 25.882044f, 51.26688f, 37.16711f, 52.7369f);
                j.lineTo(37.16711f, 73.40037f);
                j.cubicTo(37.16711f, 73.954346f, 37.618084f, 74.403435f, 38.157887f, 74.403435f);
                j.lineTo(42.17633f, 74.403435f);
                j.cubicTo(42.723522f, 74.403435f, 43.16711f, 73.964516f, 43.16711f, 73.40037f);
                j.lineTo(43.16711f, 52.7369f);
                j.lineTo(43.16711f, 52.7369f);
                j.close();
                j.moveTo(40.16711f, 46.930782f);
                j.cubicTo(49.55595f, 46.930782f, 57.16711f, 39.319622f, 57.16711f, 29.93078f);
                j.cubicTo(57.16711f, 20.54194f, 49.55595f, 12.93078f, 40.16711f, 12.93078f);
                j.cubicTo(30.778269f, 12.93078f, 23.167109f, 20.54194f, 23.167109f, 29.93078f);
                j.cubicTo(23.167109f, 39.319622f, 30.778269f, 46.930782f, 40.16711f, 46.930782f);
                j.lineTo(40.16711f, 46.930782f);
                j.lineTo(40.16711f, 46.930782f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
