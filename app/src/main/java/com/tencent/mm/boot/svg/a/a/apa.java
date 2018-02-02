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

public final class apa extends c {
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
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -127.0f, 0.0f, 1.0f, -128.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 127.0f, 0.0f, 1.0f, 128.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-9276814);
                e = c.a(e, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(78.0f, 47.0f);
                j.cubicTo(78.0f, 68.53911f, 60.539104f, 86.0f, 39.0f, 86.0f);
                j.cubicTo(17.460896f, 86.0f, 0.0f, 68.53911f, 0.0f, 47.0f);
                j.cubicTo(0.0f, 29.647755f, 11.332416f, 14.942338f, 27.0f, 9.880997f);
                j.lineTo(27.0f, 18.408052f);
                j.cubicTo(15.838201f, 23.098259f, 8.0f, 34.133774f, 8.0f, 47.0f);
                j.cubicTo(8.0f, 64.12083f, 21.879173f, 78.0f, 39.0f, 78.0f);
                j.cubicTo(56.120827f, 78.0f, 70.0f, 64.12083f, 70.0f, 47.0f);
                j.cubicTo(70.0f, 34.133774f, 62.1618f, 23.098259f, 51.0f, 18.408056f);
                j.lineTo(51.0f, 9.880997f);
                j.cubicTo(66.66759f, 14.942338f, 78.0f, 29.647755f, 78.0f, 47.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(35.0f, 2.0f);
                j.cubicTo(35.0f, 0.89543045f, 35.89543f, 0.0f, 37.0f, 0.0f);
                j.lineTo(42.0f, 0.0f);
                j.cubicTo(43.10457f, 0.0f, 44.0f, 0.89543045f, 44.0f, 2.0f);
                j.lineTo(44.0f, 28.0f);
                j.cubicTo(44.0f, 29.10457f, 43.10457f, 30.0f, 42.0f, 30.0f);
                j.lineTo(37.0f, 30.0f);
                j.cubicTo(35.89543f, 30.0f, 35.0f, 29.10457f, 35.0f, 28.0f);
                j.lineTo(35.0f, 2.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
