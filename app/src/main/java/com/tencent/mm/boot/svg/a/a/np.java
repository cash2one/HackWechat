package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class np extends c {
    private final int height = ar.CTRL_INDEX;
    private final int width = ar.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ar.CTRL_INDEX;
            case 1:
                return ar.CTRL_INDEX;
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
                i3.setColor(-12953699);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(192.0f, 0.0f);
                j.lineTo(192.0f, 192.0f);
                j.lineTo(0.0f, 192.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(104.72727f, 192.0f);
                j2.lineTo(104.72727f, 117.818184f);
                j2.lineTo(80.0f, 117.818184f);
                j2.lineTo(80.0f, 87.27273f);
                j2.lineTo(104.72727f, 87.27273f);
                j2.lineTo(104.72727f, 61.090908f);
                j2.cubicTo(104.62603f, 44.320255f, 121.209656f, 29.09091f, 138.18182f, 29.09091f);
                j2.lineTo(164.36363f, 29.09091f);
                j2.lineTo(164.36363f, 58.18182f);
                j2.lineTo(148.36363f, 58.18182f);
                j2.cubicTo(137.98802f, 58.097572f, 133.74586f, 62.3439f, 133.81818f, 72.72727f);
                j2.lineTo(133.81818f, 87.27273f);
                j2.lineTo(164.36363f, 87.27273f);
                j2.lineTo(158.54546f, 117.818184f);
                j2.lineTo(133.81818f, 117.818184f);
                j2.lineTo(133.81818f, 192.0f);
                j2.lineTo(104.72727f, 192.0f);
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
