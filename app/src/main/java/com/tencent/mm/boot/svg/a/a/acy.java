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

public final class acy extends c {
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
                j.moveTo(78.0f, 23.0f);
                j.lineTo(18.0f, 23.0f);
                j.cubicTo(16.344f, 23.0f, 15.0f, 24.343f, 15.0f, 26.0f);
                j.lineTo(15.0f, 70.0f);
                j.cubicTo(15.0f, 71.657f, 16.344f, 73.0f, 18.0f, 73.0f);
                j.lineTo(78.0f, 73.0f);
                j.cubicTo(79.656f, 73.0f, 81.0f, 71.657f, 81.0f, 70.0f);
                j.lineTo(81.0f, 26.0f);
                j.cubicTo(81.0f, 24.343f, 79.656f, 23.0f, 78.0f, 23.0f);
                j.close();
                j.moveTo(76.0f, 59.0f);
                j.cubicTo(73.152f, 54.088184f, 68.083f, 47.354908f, 63.744f, 47.354908f);
                j.cubicTo(62.005f, 47.354908f, 58.828f, 49.3773f, 55.663f, 52.12908f);
                j.cubicTo(56.991f, 55.097874f, 58.811f, 58.14101f, 58.8f, 58.14101f);
                j.cubicTo(57.888f, 58.14101f, 55.199f, 53.835007f, 55.199f, 53.835007f);
                j.cubicTo(55.026f, 53.55973f, 54.844f, 53.290478f, 54.659f, 53.026253f);
                j.cubicTo(54.605f, 53.07548f, 54.552f, 53.123703f, 54.498f, 53.17293f);
                j.cubicTo(51.521f, 49.35821f, 45.061f, 40.19967f, 39.359f, 40.19967f);
                j.cubicTo(35.016f, 40.19967f, 24.034f, 50.0655f, 20.0f, 57.164474f);
                j.lineTo(20.0f, 28.0f);
                j.lineTo(76.0f, 28.0f);
                j.lineTo(76.0f, 59.0f);
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
