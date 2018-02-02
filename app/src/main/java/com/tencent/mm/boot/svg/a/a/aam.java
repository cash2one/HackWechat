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

public final class aam extends c {
    private final int height = 107;
    private final int width = 107;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 107;
            case 1:
                return 107;
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
                j.moveTo(33.506958f, 86.825905f);
                j.cubicTo(32.122402f, 87.74495f, 31.0f, 87.15455f, 31.0f, 85.48306f);
                j.lineTo(31.0f, 21.517584f);
                j.cubicTo(31.0f, 19.856905f, 32.125355f, 19.257656f, 33.506958f, 20.174744f);
                j.lineTo(81.20527f, 51.83624f);
                j.cubicTo(82.58983f, 52.755287f, 82.586876f, 54.24732f, 81.20527f, 55.16441f);
                j.lineTo(33.506958f, 86.825905f);
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
