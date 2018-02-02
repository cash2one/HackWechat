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

public final class r extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 25.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(13.0f, 0.0f);
                j.lineTo(66.0f, 0.0f);
                j.lineTo(66.0f, 46.0f);
                j.lineTo(13.0f, 46.0f);
                j.lineTo(13.0f, 31.01f);
                j.cubicTo(8.67f, 28.09f, 4.34f, 25.18f, 0.0f, 22.26f);
                j.cubicTo(4.33f, 19.84f, 8.67f, 17.42f, 13.0f, 15.0f);
                j.lineTo(13.0f, 0.0f);
                j.lineTo(13.0f, 0.0f);
                j.close();
                j.moveTo(25.161922f, 17.534609f);
                j.cubicTo(21.36844f, 19.05981f, 20.87799f, 24.801746f, 24.291122f, 26.984877f);
                j.cubicTo(27.38396f, 29.397287f, 32.42859f, 27.234093f, 32.88901f, 23.396168f);
                j.cubicTo(33.799847f, 19.269152f, 28.915365f, 15.590726f, 25.161922f, 17.534609f);
                j.lineTo(25.161922f, 17.534609f);
                j.close();
                j.moveTo(48.078495f, 17.571182f);
                j.cubicTo(44.464924f, 19.145073f, 43.869072f, 24.668177f, 47.165493f, 26.89866f);
                j.cubicTo(50.279316f, 29.467098f, 55.536293f, 27.255924f, 55.930325f, 23.229467f);
                j.cubicTo(56.641506f, 19.067827f, 51.759342f, 15.591748f, 48.078495f, 17.571182f);
                j.lineTo(48.078495f, 17.571182f);
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
