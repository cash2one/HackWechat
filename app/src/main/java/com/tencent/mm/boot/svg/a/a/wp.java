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

public final class wp extends c {
    private final int height = 30;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 30;
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
                i2.setColor(-1158579);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(13.68f, 0.0f);
                j.lineTo(16.09f, 0.0f);
                j.cubicTo(23.29f, 0.5f, 29.35f, 6.53f, 30.0f, 13.69f);
                j.lineTo(30.0f, 16.12f);
                j.cubicTo(29.49f, 23.29f, 23.49f, 29.33f, 16.34f, 30.0f);
                j.lineTo(13.89f, 30.0f);
                j.cubicTo(6.7f, 29.49f, 0.65f, 23.47f, 0.0f, 16.32f);
                j.lineTo(0.0f, 13.88f);
                j.cubicTo(0.52f, 6.7f, 6.53f, 0.66f, 13.68f, 0.0f);
                j.lineTo(13.68f, 0.0f);
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
