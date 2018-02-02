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

public final class aox extends c {
    private final int height = 50;
    private final int width = 34;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 34;
            case 1:
                return 50;
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
                a.setColor(-3815995);
                e = c.a(e, 1.0f, 0.0f, -945.0f, 0.0f, 1.0f, -405.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(948.125f, 426.5625f);
                j.lineTo(948.125f, 432.50198f);
                j.cubicTo(948.125f, 440.09482f, 954.28107f, 446.25f, 961.875f, 446.25f);
                j.cubicTo(969.46893f, 446.25f, 975.625f, 440.09482f, 975.625f, 432.50198f);
                j.lineTo(975.625f, 426.5625f);
                j.lineTo(977.99774f, 426.5625f);
                j.cubicTo(978.41595f, 426.5625f, 978.75f, 426.89874f, 978.75f, 427.31354f);
                j.lineTo(978.75f, 432.3685f);
                j.cubicTo(978.75f, 440.96136f, 972.1874f, 448.0379f, 963.75f, 448.9606f);
                j.lineTo(963.75f, 451.875f);
                j.lineTo(971.42896f, 451.875f);
                j.cubicTo(971.84674f, 451.875f, 972.1875f, 452.21368f, 972.1875f, 452.63147f);
                j.lineTo(972.1875f, 454.24353f);
                j.cubicTo(972.1875f, 454.66556f, 971.8479f, 455.0f, 971.42896f, 455.0f);
                j.lineTo(952.32104f, 455.0f);
                j.cubicTo(951.90326f, 455.0f, 951.5625f, 454.66132f, 951.5625f, 454.24353f);
                j.lineTo(951.5625f, 452.63147f);
                j.cubicTo(951.5625f, 452.20944f, 951.9021f, 451.875f, 952.32104f, 451.875f);
                j.lineTo(960.0f, 451.875f);
                j.lineTo(960.0f, 448.9606f);
                j.cubicTo(951.5626f, 448.0379f, 945.0f, 440.96136f, 945.0f, 432.3685f);
                j.lineTo(945.0f, 427.30655f);
                j.cubicTo(945.0f, 426.89603f, 945.3368f, 426.5625f, 945.75226f, 426.5625f);
                j.lineTo(948.125f, 426.5625f);
                j.close();
                j.moveTo(961.875f, 405.0f);
                j.cubicTo(967.05383f, 405.0f, 971.25f, 409.20065f, 971.25f, 414.38242f);
                j.lineTo(971.25f, 431.86758f);
                j.cubicTo(971.25f, 437.05624f, 967.0527f, 441.25f, 961.875f, 441.25f);
                j.cubicTo(956.69617f, 441.25f, 952.5f, 437.04935f, 952.5f, 431.86758f);
                j.lineTo(952.5f, 414.38242f);
                j.cubicTo(952.5f, 409.19376f, 956.6973f, 405.0f, 961.875f, 405.0f);
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
