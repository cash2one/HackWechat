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

public final class la extends c {
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
                i2.setColor(-2763307);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(9.740437f, 16.82034f);
                j.cubicTo(15.206292f, 11.2271185f, 20.54201f, 5.501695f, 26.097961f, 0.0f);
                j.cubicTo(26.568466f, 0.4881356f, 27.519485f, 1.4745762f, 28.0f, 1.9728813f);
                j.cubicTo(22.303898f, 8.583051f, 15.887022f, 14.532204f, 10.040758f, 21.0f);
                j.cubicTo(6.677154f, 18.21356f, 3.283518f, 15.488135f, 0.0f, 12.620339f);
                j.lineTo(0.0f, 10.932203f);
                j.cubicTo(0.41043976f, 10.718644f, 1.2313193f, 10.291526f, 1.641759f, 10.088136f);
                j.cubicTo(4.3346443f, 12.335593f, 7.0275297f, 14.593221f, 9.740437f, 16.82034f);
                j.lineTo(9.740437f, 16.82034f);
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
