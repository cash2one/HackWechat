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

public final class yv extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i2.setColor(-15683841);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(87.115f, 33.87689f);
                j.cubicTo(87.115f, 30.632847f, 84.48362f, 28.0f, 81.23811f, 28.0f);
                j.lineTo(26.876888f, 28.0f);
                j.cubicTo(23.631376f, 28.0f, 21.0f, 30.632847f, 21.0f, 33.87689f);
                j.lineTo(21.0f, 75.01658f);
                j.cubicTo(21.0f, 78.26209f, 23.631376f, 80.892f, 26.876888f, 80.892f);
                j.lineTo(81.23811f, 80.892f);
                j.cubicTo(84.48362f, 80.892f, 87.115f, 78.26209f, 87.115f, 75.01658f);
                j.lineTo(87.115f, 66.199776f);
                j.lineTo(72.422775f, 66.199776f);
                j.cubicTo(65.931755f, 66.199776f, 60.669f, 60.937023f, 60.669f, 54.446f);
                j.cubicTo(60.669f, 47.954975f, 65.931755f, 42.692223f, 72.422775f, 42.692223f);
                j.lineTo(87.115f, 42.692223f);
                j.lineTo(87.115f, 33.87689f);
                j.lineTo(87.115f, 33.87689f);
                j.close();
                j.moveTo(66.54589f, 54.446f);
                j.cubicTo(66.54589f, 57.69298f, 69.17727f, 60.322887f, 72.422775f, 60.322887f);
                j.cubicTo(75.66829f, 60.322887f, 78.29967f, 57.69298f, 78.29967f, 54.446f);
                j.cubicTo(78.29967f, 51.20049f, 75.66829f, 48.56911f, 72.422775f, 48.56911f);
                j.cubicTo(69.17727f, 48.56911f, 66.54589f, 51.20049f, 66.54589f, 54.446f);
                j.lineTo(66.54589f, 54.446f);
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
