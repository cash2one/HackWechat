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

public final class hw extends c {
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
                i2.setColor(-8617851);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(77.0f, 71.0f);
                j.lineTo(53.0f, 76.0f);
                j.lineTo(53.0f, 26.0f);
                j.lineTo(77.0f, 21.0f);
                j.lineTo(77.0f, 71.0f);
                j.close();
                j.moveTo(20.0f, 21.0f);
                j.lineTo(44.0f, 26.0f);
                j.lineTo(44.0f, 76.0f);
                j.lineTo(20.0f, 71.0f);
                j.lineTo(20.0f, 21.0f);
                j.close();
                j.moveTo(85.0f, 18.0f);
                j.cubicTo(85.0f, 14.723531f, 82.27647f, 12.0f, 79.0f, 12.0f);
                j.cubicTo(78.840515f, 12.0f, 78.76661f, 12.008562f, 79.0f, 12.0f);
                j.lineTo(79.0f, 12.0f);
                j.lineTo(79.0f, 12.0f);
                j.cubicTo(77.96046f, 12.0468645f, 77.32959f, 12.18205f, 77.0f, 12.0f);
                j.lineTo(49.0f, 18.0f);
                j.lineTo(20.0f, 12.0f);
                j.cubicTo(19.670408f, 12.18205f, 19.039543f, 12.0468645f, 18.0f, 12.0f);
                j.lineTo(18.0f, 12.0f);
                j.lineTo(18.0f, 12.0f);
                j.cubicTo(18.233389f, 12.008562f, 18.159487f, 12.0f, 18.0f, 12.0f);
                j.cubicTo(14.723531f, 12.0f, 12.0f, 14.723531f, 12.0f, 18.0f);
                j.cubicTo(12.0f, 18.159487f, 12.008562f, 18.233389f, 12.0f, 18.0f);
                j.lineTo(12.0f, 18.0f);
                j.lineTo(12.0f, 72.0f);
                j.lineTo(12.0f, 72.0f);
                j.cubicTo(12.008562f, 72.45797f, 12.0f, 72.53187f, 12.0f, 73.0f);
                j.cubicTo(12.0f, 75.96783f, 14.723531f, 78.69136f, 18.0f, 79.0f);
                j.cubicTo(18.159487f, 78.69136f, 18.233389f, 78.68279f, 18.0f, 79.0f);
                j.lineTo(18.0f, 79.0f);
                j.lineTo(49.0f, 85.0f);
                j.lineTo(79.0f, 79.0f);
                j.lineTo(79.0f, 79.0f);
                j.cubicTo(78.76661f, 78.68279f, 78.840515f, 78.69136f, 79.0f, 79.0f);
                j.cubicTo(82.27647f, 78.69136f, 85.0f, 75.96783f, 85.0f, 73.0f);
                j.cubicTo(85.0f, 72.53187f, 84.99144f, 72.45797f, 85.0f, 72.0f);
                j.lineTo(85.0f, 72.0f);
                j.lineTo(85.0f, 18.0f);
                j.lineTo(85.0f, 18.0f);
                j.cubicTo(84.99144f, 18.233389f, 85.0f, 18.159487f, 85.0f, 18.0f);
                j.lineTo(85.0f, 18.0f);
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
