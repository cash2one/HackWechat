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

public final class agp extends c {
    private final int height = 49;
    private final int width = 56;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 56;
            case 1:
                return 49;
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
                i2.setColor(-27648);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(52.0f, 0.0f);
                j.cubicTo(53.5f, 1.0525777f, 54.73f, 2.1051555f, 56.0f, 3.0f);
                j.lineTo(56.0f, 5.0f);
                j.cubicTo(53.09f, 7.1074057f, 50.94f, 10.395458f, 49.0f, 13.0f);
                j.cubicTo(39.47f, 25.301964f, 30.39f, 37.161007f, 21.0f, 49.0f);
                j.cubicTo(13.57f, 41.7723f, 7.51f, 33.00082f, 0.0f, 26.0f);
                j.lineTo(0.0f, 24.0f);
                j.cubicTo(0.87f, 22.956219f, 1.72f, 21.643003f, 3.0f, 20.0f);
                j.cubicTo(8.66f, 25.121523f, 14.88f, 29.762888f, 21.0f, 34.0f);
                j.cubicTo(31.45f, 22.986294f, 41.91f, 11.538257f, 52.0f, 0.0f);
                j.lineTo(52.0f, 0.0f);
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
