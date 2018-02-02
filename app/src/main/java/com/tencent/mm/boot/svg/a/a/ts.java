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

public final class ts extends c {
    private final int height = 30;
    private final int width = 55;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 55;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 4.0f);
                j.cubicTo(0.0f, 1.7908609f, 1.7908609f, 0.0f, 4.0f, 0.0f);
                j.lineTo(30.0f, 0.0f);
                j.cubicTo(32.20914f, 0.0f, 34.0f, 1.7908609f, 34.0f, 4.0f);
                j.lineTo(34.0f, 26.0f);
                j.cubicTo(34.0f, 28.209139f, 32.20914f, 30.0f, 30.0f, 30.0f);
                j.lineTo(4.0f, 30.0f);
                j.cubicTo(1.7908609f, 30.0f, 0.0f, 28.209139f, 0.0f, 26.0f);
                j.lineTo(0.0f, 4.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(38.71698f, 13.0f);
                j.cubicTo(43.57647f, 8.820671f, 48.100197f, 4.1560574f, 54.0f, 1.0f);
                j.cubicTo(54.131836f, 10.646817f, 54.07152f, 20.353184f, 54.0f, 30.0f);
                j.lineTo(52.981133f, 30.0f);
                j.cubicTo(47.165295f, 25.652977f, 41.495552f, 21.266256f, 35.660378f, 17.0f);
                j.cubicTo(34.679802f, 14.844969f, 37.29351f, 13.584531f, 38.71698f, 13.0f);
                j.lineTo(38.71698f, 13.0f);
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
