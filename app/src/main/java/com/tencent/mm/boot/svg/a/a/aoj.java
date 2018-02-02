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

public final class aoj extends c {
    private final int height = 240;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-407039);
                Path j = c.j(looper);
                j.moveTo(120.0f, 0.0f);
                j.cubicTo(186.27417f, 0.0f, 240.0f, 53.72583f, 240.0f, 120.0f);
                j.cubicTo(240.0f, 186.27417f, 186.27417f, 240.0f, 120.0f, 240.0f);
                j.cubicTo(53.72583f, 240.0f, 0.0f, 186.27417f, 0.0f, 120.0f);
                j.cubicTo(0.0f, 53.72583f, 53.72583f, 0.0f, 120.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(120.0f, 21.0f);
                j.cubicTo(174.6762f, 21.0f, 219.0f, 65.32381f, 219.0f, 120.0f);
                j.cubicTo(219.0f, 174.6762f, 174.6762f, 219.0f, 120.0f, 219.0f);
                j.cubicTo(65.32381f, 219.0f, 21.0f, 174.6762f, 21.0f, 120.0f);
                j.cubicTo(21.0f, 65.32381f, 65.32381f, 21.0f, 120.0f, 21.0f);
                j.close();
                canvas.saveLayerAlpha(null, 102, 4);
                canvas.drawPath(j, c.a(a, looper));
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-407039);
                Path j2 = c.j(looper);
                j2.moveTo(125.57143f, 108.0f);
                j2.lineTo(142.28572f, 72.0f);
                j2.lineTo(159.0f, 72.0f);
                j2.lineTo(142.28572f, 108.0f);
                j2.lineTo(159.0f, 108.0f);
                j2.lineTo(159.0f, 123.0f);
                j2.lineTo(126.0f, 123.0f);
                j2.lineTo(126.0f, 135.0f);
                j2.lineTo(159.0f, 135.0f);
                j2.lineTo(159.0f, 150.0f);
                j2.lineTo(126.0f, 150.0f);
                j2.lineTo(126.0f, 171.0f);
                j2.lineTo(114.0f, 171.0f);
                j2.lineTo(114.0f, 150.0f);
                j2.lineTo(81.0f, 150.0f);
                j2.lineTo(81.0f, 135.0f);
                j2.lineTo(114.0f, 135.0f);
                j2.lineTo(114.0f, 123.0f);
                j2.lineTo(81.0f, 123.0f);
                j2.lineTo(81.0f, 108.0f);
                j2.lineTo(97.71429f, 108.0f);
                j2.lineTo(81.0f, 72.0f);
                j2.lineTo(97.71429f, 72.0f);
                j2.lineTo(114.42857f, 108.0f);
                j2.lineTo(125.57143f, 108.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
