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

public final class xo extends c {
    private final int height = 38;
    private final int width = 18;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 18;
            case 1:
                return 38;
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
                i2.setColor(-6710887);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(6.0f, 0.0f);
                j.cubicTo(10.03f, 6.2841287f, 13.99f, 12.663152f, 18.0f, 19.0f);
                j.cubicTo(13.97f, 25.305216f, 10.03f, 31.673697f, 6.0f, 38.0f);
                j.lineTo(0.0f, 38.0f);
                j.cubicTo(3.97f, 31.642065f, 8.0f, 25.326303f, 12.0f, 19.0f);
                j.cubicTo(8.01f, 12.673696f, 4.04f, 6.336848f, 0.0f, 0.0f);
                j.lineTo(6.0f, 0.0f);
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
