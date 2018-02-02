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

public final class lb extends c {
    private final int height = 21;
    private final int width = 28;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 21;
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
                i2.setColor(-15679443);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(9.74392f, 16.81017f);
                j.cubicTo(15.2217455f, 11.2271185f, 20.549356f, 5.4915257f, 26.107296f, 0.0f);
                j.cubicTo(26.587982f, 0.4881356f, 27.529327f, 1.4745762f, 28.0f, 1.9728813f);
                j.cubicTo(22.341917f, 8.60339f, 15.872675f, 14.481356f, 10.084406f, 21.0f);
                j.cubicTo(6.679542f, 18.254238f, 3.304721f, 15.477966f, 0.0f, 12.620339f);
                j.lineTo(0.0f, 10.901695f);
                j.cubicTo(0.41058657f, 10.698305f, 1.241774f, 10.301695f, 1.6623749f, 10.098305f);
                j.cubicTo(4.346209f, 12.345762f, 7.030043f, 14.60339f, 9.74392f, 16.81017f);
                j.lineTo(9.74392f, 16.81017f);
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
