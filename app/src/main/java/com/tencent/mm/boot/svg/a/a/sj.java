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

public final class sj extends c {
    private final int height = 48;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 48;
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
                i2.setColor(-7503);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(21.993774f, 38.0f);
                j.lineTo(51.00044f, 38.0f);
                j.cubicTo(52.66516f, 38.0f, 54.0f, 36.6579f, 54.0f, 35.00234f);
                j.lineTo(54.0f, 2.99766f);
                j.cubicTo(54.0f, 1.3524401f, 52.65705f, 0.0f, 51.00044f, 0.0f);
                j.lineTo(2.9995608f, 0.0f);
                j.cubicTo(1.3348389f, 0.0f, 0.0f, 1.342098f, 0.0f, 2.99766f);
                j.lineTo(0.0f, 35.00234f);
                j.cubicTo(0.0f, 36.64756f, 1.3429492f, 38.0f, 2.9995608f, 38.0f);
                j.lineTo(9.0f, 38.0f);
                j.lineTo(9.0f, 47.950085f);
                j.lineTo(21.993774f, 38.0f);
                j.close();
                j.moveTo(19.0f, 32.0f);
                j.lineTo(48.0f, 32.0f);
                j.lineTo(48.0f, 6.0f);
                j.lineTo(6.0f, 6.0f);
                j.lineTo(6.0f, 32.0f);
                j.lineTo(15.0f, 32.0f);
                j.lineTo(15.0f, 36.0f);
                j.lineTo(19.0f, 32.0f);
                j.lineTo(19.0f, 32.0f);
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
