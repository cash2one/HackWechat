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

public final class pd extends c {
    private final int height = 36;
    private final int width = 20;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 36;
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
                a.setColor(-6710887);
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.21f, 2.83f);
                j.cubicTo(1.15f, 1.89f, 2.09f, 0.94f, 3.03f, 0.0f);
                j.cubicTo(8.69f, 5.66f, 14.34f, 11.31f, 19.99f, 16.97f);
                j.cubicTo(14.34f, 22.63f, 8.69f, 28.29f, 3.03f, 33.94f);
                j.cubicTo(2.09f, 33.0f, 1.15f, 32.06f, 0.21f, 31.12f);
                j.cubicTo(4.91f, 26.39f, 9.64f, 21.7f, 14.33f, 16.97f);
                j.cubicTo(9.64f, 12.25f, 4.91f, 7.55f, 0.21f, 2.83f);
                j.lineTo(0.21f, 2.83f);
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
