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

public final class sh extends c {
    private final int height = 72;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
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
                e = c.a(e, 1.3333334f, 0.0f, 0.0f, 0.0f, 1.3333334f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2171170);
                Path j = c.j(looper);
                j.moveTo(10.02f, 4.03f);
                j.cubicTo(16.37f, -0.03f, 25.25f, 2.32f, 30.0f, 7.82f);
                j.cubicTo(34.75f, 2.31f, 43.65f, -0.03f, 50.0f, 4.04f);
                j.cubicTo(56.64f, 8.75f, 57.4f, 18.37f, 54.62f, 25.46f);
                j.cubicTo(49.99f, 36.69f, 40.55f, 45.38f, 30.0f, 51.04f);
                j.cubicTo(19.44f, 45.38f, 10.0f, 36.68f, 5.38f, 25.44f);
                j.cubicTo(2.59f, 18.35f, 3.37f, 8.73f, 10.02f, 4.03f);
                j.moveTo(10.78f, 12.53f);
                j.cubicTo(9.05f, 17.39f, 9.87f, 23.01f, 12.63f, 27.35f);
                j.cubicTo(16.91f, 34.26f, 23.39f, 39.46f, 30.0f, 44.02f);
                j.cubicTo(35.84f, 40.01f, 41.47f, 35.49f, 45.75f, 29.79f);
                j.cubicTo(48.53f, 26.15f, 50.43f, 21.67f, 50.08f, 17.01f);
                j.cubicTo(50.12f, 13.43f, 48.4f, 9.15f, 44.52f, 8.35f);
                j.cubicTo(38.67f, 6.6f, 34.27f, 11.91f, 30.0f, 14.96f);
                j.cubicTo(26.8f, 12.47f, 23.72f, 9.6f, 19.86f, 8.15f);
                j.cubicTo(16.34f, 7.44f, 12.05f, 8.89f, 10.78f, 12.53f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
