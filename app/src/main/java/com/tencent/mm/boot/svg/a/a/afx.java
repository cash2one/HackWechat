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

public final class afx extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-899014);
                e = c.a(e, 1.0f, 0.0f, -218.0f, 0.0f, 1.0f, -230.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 224.0f, 0.0f, 1.0f, 236.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 24.0f);
                j.cubicTo(0.0f, 10.8f, 10.8f, 0.0f, 24.0f, 0.0f);
                j.cubicTo(37.2f, 0.0f, 48.0f, 10.8f, 48.0f, 24.0f);
                j.cubicTo(48.0f, 37.2f, 37.2f, 48.0f, 24.0f, 48.0f);
                j.cubicTo(10.8f, 48.0f, 0.0f, 37.2f, 0.0f, 24.0f);
                j.close();
                j.moveTo(4.0f, 24.0f);
                j.cubicTo(4.0f, 35.0f, 13.0f, 44.0f, 24.0f, 44.0f);
                j.cubicTo(35.0f, 44.0f, 44.0f, 35.0f, 44.0f, 24.0f);
                j.cubicTo(44.0f, 13.0f, 35.0f, 4.0f, 24.0f, 4.0f);
                j.cubicTo(13.0f, 4.0f, 4.0f, 13.0f, 4.0f, 24.0f);
                j.close();
                j.moveTo(10.0f, 24.0f);
                j.cubicTo(10.0f, 31.7f, 16.3f, 38.0f, 24.0f, 38.0f);
                j.cubicTo(31.7f, 38.0f, 38.0f, 31.7f, 38.0f, 24.0f);
                j.cubicTo(38.0f, 16.3f, 31.7f, 10.0f, 24.0f, 10.0f);
                j.cubicTo(16.3f, 10.0f, 10.0f, 16.3f, 10.0f, 24.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
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
