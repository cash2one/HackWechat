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

public final class af extends c {
    private final int height = 16;
    private final int width = 28;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 16;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3355444);
                Path j = c.j(looper);
                j.moveTo(13.962992f, 10.188502f);
                j.cubicTo(13.08834f, 9.283867f, 12.178382f, 8.349955f, 11.50355f, 7.6751227f);
                j.lineTo(3.828427f, 8.881784E-16f);
                j.lineTo(1.0f, 2.828427f);
                j.lineTo(13.9616785f, 15.961207f);
                j.lineTo(13.994814f, 15.928072f);
                j.lineTo(14.008518f, 15.941776f);
                j.lineTo(15.711977f, 14.210909f);
                j.lineTo(16.790106f, 13.13278f);
                j.cubicTo(16.790106f, 13.13278f, 16.787266f, 13.1298f, 16.781706f, 13.123969f);
                j.lineTo(26.914213f, 2.828427f);
                j.lineTo(24.085787f, -5.3290705E-15f);
                j.lineTo(16.410664f, 7.6751227f);
                j.cubicTo(15.7343025f, 8.351483f, 14.829623f, 9.285367f, 13.962992f, 10.188502f);
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
