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

public final class e extends c {
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
                j.moveTo(45.0f, 45.0f);
                j.lineTo(45.0f, 20.995752f);
                j.cubicTo(45.0f, 20.45077f, 45.44359f, 20.0f, 45.99078f, 20.0f);
                j.lineTo(50.00922f, 20.0f);
                j.cubicTo(50.549026f, 20.0f, 51.0f, 20.445814f, 51.0f, 20.995752f);
                j.lineTo(51.0f, 45.0f);
                j.lineTo(75.00425f, 45.0f);
                j.cubicTo(75.54923f, 45.0f, 76.0f, 45.44359f, 76.0f, 45.99078f);
                j.lineTo(76.0f, 50.00922f);
                j.cubicTo(76.0f, 50.549026f, 75.554184f, 51.0f, 75.00425f, 51.0f);
                j.lineTo(51.0f, 51.0f);
                j.lineTo(51.0f, 75.00425f);
                j.cubicTo(51.0f, 75.54923f, 50.55641f, 76.0f, 50.00922f, 76.0f);
                j.lineTo(45.99078f, 76.0f);
                j.cubicTo(45.450974f, 76.0f, 45.0f, 75.554184f, 45.0f, 75.00425f);
                j.lineTo(45.0f, 51.0f);
                j.lineTo(20.995752f, 51.0f);
                j.cubicTo(20.45077f, 51.0f, 20.0f, 50.55641f, 20.0f, 50.00922f);
                j.lineTo(20.0f, 45.99078f);
                j.cubicTo(20.0f, 45.450974f, 20.445814f, 45.0f, 20.995752f, 45.0f);
                j.lineTo(45.0f, 45.0f);
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
