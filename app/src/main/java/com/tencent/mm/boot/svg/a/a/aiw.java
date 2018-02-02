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

public final class aiw extends c {
    private final int height = 36;
    private final int width = 22;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 36;
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
                j.moveTo(10.0f, 0.0f);
                j.lineTo(11.59f, 0.0f);
                j.cubicTo(14.44f, 4.26f, 18.06f, 8.06f, 22.0f, 11.34f);
                j.lineTo(22.0f, 11.75f);
                j.cubicTo(19.0f, 11.97f, 16.0f, 12.05f, 13.0f, 12.02f);
                j.cubicTo(13.05f, 20.01f, 12.89f, 28.01f, 13.09f, 36.0f);
                j.lineTo(9.0f, 36.0f);
                j.lineTo(9.0f, 12.03f);
                j.cubicTo(6.0f, 12.04f, 3.0f, 11.98f, 0.0f, 11.77f);
                j.lineTo(0.0f, 11.38f);
                j.cubicTo(3.84f, 8.02f, 7.68f, 4.33f, 10.39f, 0.0f);
                j.lineTo(10.0f, 0.0f);
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
