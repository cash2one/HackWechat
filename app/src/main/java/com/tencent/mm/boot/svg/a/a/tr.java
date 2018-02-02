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

public final class tr extends c {
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
                a.setColor(-12206054);
                e = c.a(e, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(25.094501f, 1.2469155f);
                j.cubicTo(32.743237f, 3.0203025f, 39.219376f, 8.896839f, 41.072548f, 16.177034f);
                j.cubicTo(43.13704f, 22.67836f, 41.587963f, 29.62878f, 38.076664f, 35.088516f);
                j.cubicTo(34.412243f, 42.962852f, 28.066027f, 49.068085f, 21.099989f, 54.0f);
                j.cubicTo(12.755159f, 48.05386f, 5.0597496f, 40.37757f, 1.127431f, 30.11181f);
                j.cubicTo(-0.9466681f, 23.652811f, -0.27706745f, 15.399808f, 4.123315f, 9.209645f);
                j.cubicTo(9.027383f, 3.1793966f, 17.492334f, 0.06711942f, 25.094501f, 1.2469155f);
                j.close();
                j.moveTo(16.216259f, 28.788422f);
                j.cubicTo(21.350666f, 32.136604f, 29.266953f, 28.065493f, 28.989613f, 22.434635f);
                j.cubicTo(29.309687f, 16.169382f, 22.162594f, 11.960802f, 17.280704f, 15.021884f);
                j.cubicTo(11.992141f, 17.4383f, 11.564811f, 25.432486f, 16.216259f, 28.788422f);
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
