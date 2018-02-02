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

public final class ds extends c {
    private final int height = 60;
    private final int width = 64;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, -194.0f, 0.0f, 1.0f, -102.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(224.36317f, 150.10246f);
                j.lineTo(204.89511f, 161.91656f);
                j.lineTo(210.11502f, 139.75056f);
                j.lineTo(192.86317f, 124.88609f);
                j.lineTo(215.55734f, 123.000854f);
                j.lineTo(224.36317f, 102.0f);
                j.lineTo(233.16902f, 123.000854f);
                j.lineTo(255.86317f, 124.88609f);
                j.lineTo(238.61133f, 139.75056f);
                j.lineTo(243.83125f, 161.91656f);
                j.lineTo(224.36317f, 150.10246f);
                j.close();
                j.moveTo(224.24213f, 144.04645f);
                j.lineTo(235.99782f, 151.18034f);
                j.lineTo(232.8458f, 137.7955f);
                j.lineTo(243.26324f, 128.81966f);
                j.lineTo(229.5595f, 127.681274f);
                j.lineTo(224.24213f, 115.0f);
                j.lineTo(218.92476f, 127.681274f);
                j.lineTo(205.221f, 128.81966f);
                j.lineTo(215.63844f, 137.7955f);
                j.lineTo(212.48642f, 151.18034f);
                j.lineTo(224.24213f, 144.04645f);
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
