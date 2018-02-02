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

public final class ne extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-16384);
                float[] a2 = c.a(e, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 7.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(22.179684f, 20.160744f);
                j.cubicTo(25.258177f, 13.424428f, 28.385149f, 6.712214f, 31.48788f, 0.0f);
                j.cubicTo(34.69969f, 6.6881127f, 37.729702f, 13.4726305f, 40.893036f, 20.196896f);
                j.cubicTo(48.262024f, 20.67892f, 55.631012f, 21.160948f, 63.0f, 21.655024f);
                j.cubicTo(57.63082f, 26.53554f, 52.18892f, 31.34375f, 46.84398f, 36.248367f);
                j.cubicTo(48.552906f, 43.828228f, 50.24971f, 51.40809f, 51.946518f, 58.98795f);
                j.cubicTo(45.13505f, 55.228146f, 38.335705f, 51.44424f, 31.51212f, 47.708538f);
                j.cubicTo(24.688534f, 51.45629f, 17.889189f, 55.228146f, 11.077723f, 59.0f);
                j.cubicTo(12.7745285f, 51.40809f, 14.483455f, 43.828228f, 16.180262f, 36.248367f);
                j.cubicTo(11.041362f, 31.596813f, 5.963063f, 26.897058f, 0.7029627f, 22.390114f);
                j.cubicTo(0.53328204f, 22.390114f, 0.1818007f, 22.378063f, 0.0f, 22.366013f);
                j.lineTo(0.0f, 22.064747f);
                j.cubicTo(7.3083878f, 20.739176f, 14.798576f, 20.895834f, 22.179684f, 20.160744f);
                j.lineTo(22.179684f, 20.160744f);
                j.lineTo(22.179684f, 20.160744f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                e = c.a(a2, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 29.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(6.06f, 1.52f);
                j.cubicTo(13.81f, 1.24f, 21.54f, 0.83f, 29.28f, 0.5f);
                j.cubicTo(22.8f, 6.15f, 16.29f, 11.75f, 9.81f, 17.4f);
                j.lineTo(28.01f, 17.4f);
                j.cubicTo(28.01f, 17.72f, 28.0f, 18.38f, 28.0f, 18.71f);
                j.cubicTo(19.33f, 19.12f, 10.67f, 19.57f, 2.0f, 19.99f);
                j.cubicTo(8.51f, 14.35f, 15.02f, 8.71f, 21.53f, 3.07f);
                j.cubicTo(14.37f, 2.95f, 7.21f, 3.31f, 0.07f, 2.85f);
                j.cubicTo(1.78f, 1.46f, 4.0f, 1.65f, 6.06f, 1.52f);
                j.lineTo(6.06f, 1.52f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
