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

public final class wb extends c {
    private final int height = 70;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.4922566f);
                j.cubicTo(0.46f, 1.6837293f, 3.04f, -0.3052276f, 5.88f, 0.044588927f);
                j.cubicTo(31.95f, 0.02459941f, 58.02f, 0.03459417f, 84.09f, 0.044588927f);
                j.cubicTo(86.85f, -0.31522238f, 89.24f, 1.5438027f, 90.0f, 4.1324453f);
                j.lineTo(90.0f, 61.532345f);
                j.cubicTo(89.6f, 63.73119f, 88.0f, 65.33035f, 85.92f, 66.0f);
                j.lineTo(4.35f, 66.0f);
                j.cubicTo(2.2f, 65.55024f, 0.66f, 63.94108f, 0.0f, 61.892155f);
                j.lineTo(0.0f, 4.4922566f);
                j.close();
                j.moveTo(7.0f, 14.0f);
                j.lineTo(83.0f, 14.0f);
                j.lineTo(83.0f, 26.0f);
                j.lineTo(7.0f, 26.0f);
                j.lineTo(7.0f, 14.0f);
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
