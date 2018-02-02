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

public final class xr extends c {
    private final int height = 56;
    private final int width = 40;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 56;
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
                i2.setColor(-8355712);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(0.53f, 0.0f);
                j.cubicTo(4.16f, 3.26f, 8.39f, 5.74f, 12.27f, 8.67f);
                j.cubicTo(21.58f, 15.0f, 30.72f, 21.59f, 40.0f, 27.97f);
                j.lineTo(40.0f, 27.98f);
                j.cubicTo(26.85f, 37.4f, 13.29f, 46.35f, 0.36f, 56.0f);
                j.lineTo(0.0f, 56.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
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
