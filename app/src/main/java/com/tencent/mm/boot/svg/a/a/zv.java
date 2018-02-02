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

public final class zv extends c {
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(47.9983f, 37.61686f);
                j.cubicTo(47.74289f, 37.61725f, 47.48804f, 37.71553f, 47.293037f, 37.910534f);
                j.lineTo(32.00577f, 53.1978f);
                j.cubicTo(31.617527f, 53.58605f, 31.61592f, 54.22187f, 32.007095f, 54.613045f);
                j.lineTo(34.765827f, 57.371777f);
                j.cubicTo(35.160282f, 57.76623f, 35.790627f, 57.763542f, 36.18107f, 57.373096f);
                j.lineTo(48.0f, 45.55417f);
                j.lineTo(59.81893f, 57.373096f);
                j.cubicTo(60.207176f, 57.761345f, 60.843f, 57.76295f, 61.234173f, 57.371777f);
                j.lineTo(63.992905f, 54.613045f);
                j.cubicTo(64.38736f, 54.218586f, 64.384674f, 53.588245f, 63.99423f, 53.1978f);
                j.lineTo(48.706963f, 37.910534f);
                j.cubicTo(48.513058f, 37.71663f, 48.257397f, 37.619167f, 48.0013f, 37.61891f);
                j.close();
                j.moveTo(17.0f, 20.996428f);
                j.cubicTo(17.0f, 18.78926f, 18.788675f, 17.0f, 20.996428f, 17.0f);
                j.lineTo(75.00357f, 17.0f);
                j.cubicTo(77.21074f, 17.0f, 79.0f, 18.788675f, 79.0f, 20.996428f);
                j.lineTo(79.0f, 75.00357f);
                j.cubicTo(79.0f, 77.21074f, 77.21133f, 79.0f, 75.00357f, 79.0f);
                j.lineTo(20.996428f, 79.0f);
                j.cubicTo(18.78926f, 79.0f, 17.0f, 77.21133f, 17.0f, 75.00357f);
                j.lineTo(17.0f, 20.996428f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
