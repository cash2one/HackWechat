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

public final class jb extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                i2 = c.a(i3, looper);
                i2.setStrokeWidth(1.0f);
                i2.setStrokeCap(Cap.SQUARE);
                Paint a = c.a(i2, looper);
                a.setColor(-14624737);
                a.setStrokeWidth(7.5f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 13.5f, 0.0f, 1.0f, 13.5f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.6666667f, 0.6666667f);
                j.lineTo(14.956543f, 14.956543f);
                j.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, -1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j2 = c.j(looper);
                j2.moveTo(0.6666667f, 0.6666667f);
                j2.lineTo(14.956543f, 14.956543f);
                j2.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
