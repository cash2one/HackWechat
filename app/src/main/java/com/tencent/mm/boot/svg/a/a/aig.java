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

public final class aig extends c {
    private final int height = 20;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 20;
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
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(18.736526f, 15.312118f);
                j.cubicTo(18.68855f, 15.287715f, 18.641708f, 15.259116f, 18.596445f, 15.226229f);
                j.lineTo(0.76661897f, 2.2721026f);
                j.cubicTo(0.31868246f, 1.9466575f, 0.21645539f, 1.3237382f, 0.5433434f, 0.87381536f);
                j.cubicTo(0.86796826f, 0.42700762f, 1.4962001f, 0.33003822f, 1.9398534f, 0.6523712f);
                j.lineTo(19.354612f, 13.3049345f);
                j.lineTo(19.457281f, 13.379528f);
                j.lineTo(19.457281f, 13.379528f);
                j.lineTo(19.559952f, 13.3049345f);
                j.lineTo(36.97471f, 0.6523712f);
                j.cubicTo(37.41836f, 0.33003822f, 38.046597f, 0.42700762f, 38.37122f, 0.87381536f);
                j.cubicTo(38.69811f, 1.3237382f, 38.595882f, 1.9466575f, 38.147945f, 2.2721026f);
                j.lineTo(20.623741f, 15.004182f);
                j.lineTo(19.49353f, 15.865662f);
                j.lineTo(18.736526f, 15.312118f);
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
