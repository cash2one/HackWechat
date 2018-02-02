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

public final class afi extends c {
    private final int height = 36;
    private final int width = 36;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
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
                i2.setColor(-3833595);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(30.0f, 18.0f);
                j.cubicTo(30.0f, 18.0f, 26.249992f, 20.250055f, 23.249962f, 23.249962f);
                j.cubicTo(20.250055f, 26.249992f, 18.0f, 30.0f, 18.0f, 30.0f);
                j.cubicTo(18.0f, 30.0f, 15.698808f, 26.198854f, 12.750039f, 23.249962f);
                j.cubicTo(9.801146f, 20.301191f, 6.0f, 18.0f, 6.0f, 18.0f);
                j.cubicTo(6.0f, 18.0f, 9.750008f, 15.749946f, 12.750039f, 12.750039f);
                j.cubicTo(15.749946f, 9.750008f, 18.0f, 6.0f, 18.0f, 6.0f);
                j.cubicTo(18.0f, 6.0f, 20.223738f, 9.723691f, 23.249962f, 12.750039f);
                j.cubicTo(26.27631f, 15.776262f, 30.0f, 18.0f, 30.0f, 18.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
