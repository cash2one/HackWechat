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

public final class akx extends c {
    private final int height = 40;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 40;
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
                Paint a = c.a(i2, looper);
                a.setColor(-4210753);
                a.setStrokeWidth(2.5333333f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1.2666667f, 8.866667f);
                j.cubicTo(1.2666667f, 4.6693025f, 4.6693025f, 1.2666667f, 8.866667f, 1.2666667f);
                j.lineTo(29.133333f, 1.2666667f);
                j.cubicTo(33.330696f, 1.2666667f, 36.733334f, 4.6693025f, 36.733334f, 8.866667f);
                j.lineTo(36.733334f, 29.133333f);
                j.cubicTo(36.733334f, 33.330696f, 33.330696f, 36.733334f, 29.133333f, 36.733334f);
                j.lineTo(8.866667f, 36.733334f);
                j.cubicTo(4.6693025f, 36.733334f, 1.2666667f, 33.330696f, 1.2666667f, 29.133333f);
                j.lineTo(1.2666667f, 8.866667f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                a3.setStrokeCap(Cap.ROUND);
                a3.setStrokeJoin(Join.MITER);
                Path j2 = c.j(looper);
                j2.moveTo(15.2f, 27.866667f);
                j2.lineTo(15.2f, 10.133333f);
                j2.lineTo(25.333334f, 19.05872f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
