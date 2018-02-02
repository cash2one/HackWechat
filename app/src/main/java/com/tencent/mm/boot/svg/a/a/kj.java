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

public final class kj extends c {
    private final int height = 115;
    private final int width = 115;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 115;
            case 1:
                return 115;
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
                canvas.save();
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                e = c.a(e, 1.0f, 0.0f, -122.0f, 0.0f, 1.0f, -1170.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 122.0f, 0.0f, 1.0f, 1170.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-5066062);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(57.391304f, 3.0f);
                j.cubicTo(87.43079f, 3.0f, 111.78261f, 27.351814f, 111.78261f, 57.391304f);
                j.cubicTo(111.78261f, 87.43079f, 87.43079f, 111.78261f, 57.391304f, 111.78261f);
                j.cubicTo(27.351814f, 111.78261f, 3.0f, 87.43079f, 3.0f, 57.391304f);
                j.cubicTo(3.0f, 27.351814f, 27.351814f, 3.0f, 57.391304f, 3.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-5066062);
                j = c.j(looper);
                j.moveTo(76.75181f, 59.59088f);
                j.lineTo(50.76934f, 76.80847f);
                j.cubicTo(49.6515f, 77.549225f, 48.144814f, 77.24353f, 47.404064f, 76.125694f);
                j.cubicTo(47.140537f, 75.72801f, 47.0f, 75.26151f, 47.0f, 74.78445f);
                j.lineTo(47.0f, 40.34926f);
                j.cubicTo(47.0f, 39.00826f, 48.087093f, 37.921165f, 49.428093f, 37.921165f);
                j.cubicTo(49.905163f, 37.921165f, 50.371662f, 38.061703f, 50.76934f, 38.32523f);
                j.lineTo(76.75181f, 55.542824f);
                j.cubicTo(77.86965f, 56.283573f, 78.17534f, 57.79026f, 77.43459f, 58.9081f);
                j.cubicTo(77.255005f, 59.179108f, 77.02282f, 59.411293f, 76.75181f, 59.59088f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
