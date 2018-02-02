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

public final class hg extends c {
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
                j.moveTo(72.0f, 44.0f);
                j.lineTo(47.0f, 44.0f);
                j.lineTo(47.0f, 52.0f);
                j.lineTo(72.0f, 52.0f);
                j.lineTo(72.0f, 60.0f);
                j.lineTo(87.39076f, 48.0f);
                j.lineTo(72.0f, 36.0f);
                j.lineTo(72.0f, 44.0f);
                j.close();
                j.moveTo(80.0f, 26.0f);
                j.lineTo(80.0f, 23.990396f);
                j.cubicTo(80.0f, 17.382257f, 74.62726f, 12.0f, 67.99965f, 12.0f);
                j.lineTo(28.00035f, 12.0f);
                j.cubicTo(21.373957f, 12.0f, 16.0f, 17.368282f, 16.0f, 23.990396f);
                j.lineTo(16.0f, 72.009605f);
                j.cubicTo(16.0f, 78.617744f, 21.37274f, 84.0f, 28.00035f, 84.0f);
                j.lineTo(67.99965f, 84.0f);
                j.cubicTo(74.626045f, 84.0f, 80.0f, 78.631714f, 80.0f, 72.009605f);
                j.lineTo(80.0f, 70.0f);
                j.lineTo(72.0f, 70.0f);
                j.lineTo(72.0f, 71.995094f);
                j.cubicTo(72.0f, 74.20694f, 70.20595f, 76.0f, 67.990105f, 76.0f);
                j.lineTo(28.009893f, 76.0f);
                j.cubicTo(25.79529f, 76.0f, 24.0f, 74.2002f, 24.0f, 71.995094f);
                j.lineTo(24.0f, 24.004908f);
                j.cubicTo(24.0f, 21.793058f, 25.794052f, 20.0f, 28.009893f, 20.0f);
                j.lineTo(67.990105f, 20.0f);
                j.cubicTo(70.20471f, 20.0f, 72.0f, 21.799795f, 72.0f, 24.004908f);
                j.lineTo(72.0f, 26.0f);
                j.lineTo(80.0f, 26.0f);
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
