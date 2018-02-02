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

public final class acs extends c {
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
                a.setColor(-12206054);
                e = c.a(e, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 20.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(30.9995f, 0.0f);
                j.cubicTo(13.878777f, 0.0f, 0.0f, 11.798211f, 0.0f, 26.35247f);
                j.cubicTo(0.0f, 33.18859f, 3.0619507f, 39.415703f, 8.08287f, 44.09879f);
                j.cubicTo(6.80389f, 48.17186f, 4.4279284f, 56.0f, 4.4279284f, 56.0f);
                j.lineTo(17.250721f, 49.972893f);
                j.cubicTo(21.394655f, 51.719925f, 26.06058f, 52.70594f, 31.0005f, 52.70594f);
                j.cubicTo(48.121223f, 52.70594f, 62.0f, 40.90773f, 62.0f, 26.35147f);
                j.cubicTo(61.999f, 11.798211f, 48.120224f, 0.0f, 30.9995f, 0.0f);
                j.lineTo(30.9995f, 0.0f);
                j.lineTo(30.9995f, 0.0f);
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
