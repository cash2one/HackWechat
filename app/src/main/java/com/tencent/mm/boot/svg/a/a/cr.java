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

public final class cr extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                e = c.a(e, 1.0f, 0.0f, -134.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 134.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-789517);
                Path j = c.j(looper);
                j.moveTo(0.0f, 60.0f);
                j.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                j.lineTo(120.0f, 60.0f);
                j.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                j.lineTo(60.0f, 120.0f);
                j.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-3552823);
                j = c.j(looper);
                j.moveTo(51.0f, 61.0f);
                j.cubicTo(54.70148f, 67.45833f, 48.275417f, 70.24223f, 45.0f, 72.0f);
                j.cubicTo(34.045288f, 78.35749f, 29.0f, 80.81769f, 29.0f, 84.0f);
                j.lineTo(29.0f, 88.0f);
                j.cubicTo(29.0f, 89.78397f, 30.049908f, 91.0f, 32.0f, 91.0f);
                j.lineTo(88.0f, 91.0f);
                j.cubicTo(89.950096f, 91.0f, 91.0f, 89.78397f, 91.0f, 88.0f);
                j.lineTo(91.0f, 84.0f);
                j.cubicTo(91.0f, 80.81769f, 85.95471f, 78.35749f, 75.0f, 72.0f);
                j.cubicTo(71.72459f, 70.24223f, 65.29852f, 67.45833f, 69.0f, 61.0f);
                j.cubicTo(72.606285f, 56.20543f, 75.28835f, 54.126183f, 76.0f, 45.0f);
                j.cubicTo(75.28835f, 37.48938f, 69.29668f, 29.0f, 60.0f, 29.0f);
                j.cubicTo(50.703327f, 29.0f, 44.711647f, 37.48938f, 45.0f, 45.0f);
                j.cubicTo(44.711647f, 54.126183f, 47.393715f, 56.20543f, 51.0f, 61.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
