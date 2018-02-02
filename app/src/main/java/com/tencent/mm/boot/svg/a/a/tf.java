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

public final class tf extends c {
    private final int height = 75;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -366.0f, 0.0f, 1.0f, -536.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 377.0f, 0.0f, 1.0f, 537.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 3.0846448f);
                j.cubicTo(0.0f, 1.8420041f, 1.0073593f, 0.83464485f, 2.25f, 0.83464485f);
                j.lineTo(4.6465516f, 0.83464485f);
                j.cubicTo(5.8891926f, 0.83464485f, 6.8965516f, 1.8420041f, 6.8965516f, 3.0846448f);
                j.lineTo(6.8965516f, 69.939705f);
                j.cubicTo(6.8965516f, 71.18234f, 5.8891926f, 72.189705f, 4.6465516f, 72.189705f);
                j.lineTo(2.25f, 72.189705f);
                j.cubicTo(1.0073593f, 72.189705f, 0.0f, 71.18234f, 0.0f, 69.939705f);
                j.lineTo(0.0f, 3.0846448f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(33.103447f, 3.0880115f);
                j.cubicTo(33.103447f, 1.8435115f, 34.106266f, 0.83464485f, 35.361637f, 0.83464485f);
                j.lineTo(37.74181f, 0.83464485f);
                j.cubicTo(38.988976f, 0.83464485f, 40.0f, 1.8433424f, 40.0f, 3.0880115f);
                j.lineTo(40.0f, 69.93634f);
                j.cubicTo(40.0f, 71.18084f, 38.99718f, 72.189705f, 37.74181f, 72.189705f);
                j.lineTo(35.361637f, 72.189705f);
                j.cubicTo(34.114475f, 72.189705f, 33.103447f, 71.18101f, 33.103447f, 69.93634f);
                j.lineTo(33.103447f, 3.0880115f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
