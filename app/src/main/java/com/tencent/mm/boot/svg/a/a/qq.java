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

public final class qq extends c {
    private final int height = 75;
    private final int width = 75;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
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
                a.setColor(-14105561);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 7.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(31.0f, 62.0f);
                j.cubicTo(13.879172f, 62.0f, 0.0f, 48.120827f, 0.0f, 31.0f);
                j.cubicTo(0.0f, 13.879172f, 13.879172f, 0.0f, 31.0f, 0.0f);
                j.cubicTo(48.120827f, 0.0f, 62.0f, 13.879172f, 62.0f, 31.0f);
                j.cubicTo(62.0f, 48.120827f, 48.120827f, 62.0f, 31.0f, 62.0f);
                j.close();
                j.moveTo(31.0f, 56.833332f);
                j.cubicTo(45.267357f, 56.833332f, 56.833332f, 45.267357f, 56.833332f, 31.0f);
                j.cubicTo(56.833332f, 16.732643f, 45.267357f, 5.1666665f, 31.0f, 5.1666665f);
                j.cubicTo(16.732643f, 5.1666665f, 5.1666665f, 16.732643f, 5.1666665f, 31.0f);
                j.cubicTo(5.1666665f, 45.267357f, 16.732643f, 56.833332f, 31.0f, 56.833332f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(21.958334f, 23.458334f);
                j.cubicTo(21.958334f, 22.629908f, 22.629908f, 21.958334f, 23.458334f, 21.958334f);
                j.lineTo(38.541668f, 21.958334f);
                j.cubicTo(39.370094f, 21.958334f, 40.041668f, 22.629908f, 40.041668f, 23.458334f);
                j.lineTo(40.041668f, 38.541668f);
                j.cubicTo(40.041668f, 39.370094f, 39.370094f, 40.041668f, 38.541668f, 40.041668f);
                j.lineTo(23.458334f, 40.041668f);
                j.cubicTo(22.629908f, 40.041668f, 21.958334f, 39.370094f, 21.958334f, 38.541668f);
                j.lineTo(21.958334f, 23.458334f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
