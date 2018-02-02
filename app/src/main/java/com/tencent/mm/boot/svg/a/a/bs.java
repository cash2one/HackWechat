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

public final class bs extends c {
    private final int height = 71;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 71;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 27.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(19.357758f, 25.260746f);
                j.lineTo(28.45082f, 25.260746f);
                j.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                j.lineTo(39.44799f, 11.0062475f);
                j.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                j.lineTo(11.339516f, 4.0945043E-8f);
                j.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                j.lineTo(0.34234652f, 14.160372f);
                j.lineTo(4.420356f, 14.160372f);
                j.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                j.lineTo(4.352197f, 12.010028f);
                j.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                j.lineTo(27.42606f, 4.0076337f);
                j.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                j.lineTo(35.429146f, 13.111929f);
                j.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                j.lineTo(19.357758f, 21.114323f);
                j.lineTo(19.357758f, 25.260746f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                e = c.a(a2, -1.0f, 0.0f, 40.0f, 0.0f, -1.0f, 26.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(19.357758f, 25.260746f);
                j.lineTo(28.45082f, 25.260746f);
                j.cubicTo(34.51505f, 25.260746f, 39.44799f, 20.333082f, 39.44799f, 14.254499f);
                j.lineTo(39.44799f, 11.0062475f);
                j.cubicTo(39.44799f, 4.930493f, 34.52439f, 1.2726757E-7f, 28.45082f, 1.046543E-7f);
                j.lineTo(11.339516f, 4.0945043E-8f);
                j.cubicTo(5.2752895f, 1.8366562E-8f, 0.34234652f, 4.9276648f, 0.34234652f, 11.006247f);
                j.lineTo(0.34234652f, 14.160372f);
                j.lineTo(4.420356f, 14.160372f);
                j.cubicTo(4.3753934f, 13.817222f, 4.3521967f, 13.467262f, 4.3521967f, 13.111929f);
                j.lineTo(4.352197f, 12.010028f);
                j.cubicTo(4.352197f, 7.5904274f, 7.9322853f, 4.0076337f, 12.355284f, 4.0076337f);
                j.lineTo(27.42606f, 4.0076337f);
                j.cubicTo(31.846043f, 4.0076337f, 35.429146f, 7.593756f, 35.429146f, 12.010028f);
                j.lineTo(35.429146f, 13.111929f);
                j.cubicTo(35.429146f, 17.531528f, 31.849058f, 21.114323f, 27.42606f, 21.114323f);
                j.lineTo(19.357758f, 21.114323f);
                j.lineTo(19.357758f, 25.260746f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
