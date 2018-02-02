package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nk extends c {
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
                c.f(looper);
                c.e(looper);
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
                i3 = c.a(i2, looper);
                i3.setColor(-921103);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(120.0f, 0.0f);
                j.lineTo(120.0f, 120.0f);
                j.lineTo(0.0f, 120.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3552823);
                Path j2 = c.j(looper);
                j2.moveTo(50.865784f, 61.30489f);
                j2.cubicTo(54.72159f, 67.43002f, 48.319912f, 70.20336f, 45.64623f, 71.743996f);
                j2.cubicTo(34.143787f, 78.28783f, 29.117647f, 80.738686f, 29.117647f, 83.92295f);
                j2.lineTo(29.117647f, 88.272575f);
                j2.cubicTo(29.117647f, 89.670944f, 30.16357f, 90.882355f, 31.727423f, 90.882355f);
                j2.lineTo(88.272575f, 90.882355f);
                j2.cubicTo(89.83643f, 90.882355f, 90.882355f, 89.670944f, 90.882355f, 88.272575f);
                j2.lineTo(90.882355f, 83.92295f);
                j2.cubicTo(90.882355f, 80.738686f, 85.85622f, 78.28783f, 74.35377f, 71.743996f);
                j2.cubicTo(71.680084f, 70.20336f, 65.27841f, 67.43002f, 69.13422f, 61.30489f);
                j2.cubicTo(72.55844f, 56.21983f, 75.23033f, 54.14847f, 75.223694f, 45.64623f);
                j2.cubicTo(75.23033f, 37.574806f, 69.26139f, 29.117647f, 60.434963f, 29.117647f);
                j2.cubicTo(50.73861f, 29.117647f, 44.769665f, 37.574806f, 44.776306f, 45.64623f);
                j2.cubicTo(44.769665f, 54.14847f, 47.44156f, 56.21983f, 50.865784f, 61.30489f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
