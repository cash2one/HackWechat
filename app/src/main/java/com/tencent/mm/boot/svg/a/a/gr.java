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

public final class gr extends c {
    private final int height = 242;
    private final int width = 245;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i3, looper);
                a.setColor(-3552823);
                a.setStrokeWidth(4.0f);
                Path j = c.j(looper);
                j.moveTo(123.0f, 7.0f);
                j.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                j.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                j.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                j.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-3552823);
                Path j2 = c.j(looper);
                j2.moveTo(117.133484f, 111.829056f);
                j2.lineTo(94.750854f, 89.44642f);
                j2.lineTo(94.750854f, 100.31056f);
                j2.lineTo(116.18076f, 121.74048f);
                j2.lineTo(94.750854f, 143.17038f);
                j2.lineTo(94.750854f, 154.18599f);
                j2.lineTo(117.133484f, 131.80336f);
                j2.lineTo(117.133484f, 165.4863f);
                j2.lineTo(116.812836f, 165.80695f);
                j2.lineTo(117.133484f, 165.80695f);
                j2.lineTo(117.133484f, 176.5019f);
                j2.lineTo(149.46358f, 144.17183f);
                j2.lineTo(148.58734f, 143.2956f);
                j2.lineTo(148.59369f, 143.28926f);
                j2.lineTo(127.12064f, 121.81621f);
                j2.lineTo(148.28012f, 100.65672f);
                j2.lineTo(148.23923f, 100.61583f);
                j2.lineTo(150.24332f, 98.61174f);
                j2.lineTo(117.133484f, 65.501915f);
                j2.lineTo(117.133484f, 75.7257f);
                j2.lineTo(117.133484f, 111.829056f);
                j2.close();
                j2.moveTo(124.9227f, 112.99854f);
                j2.lineTo(139.2686f, 98.65264f);
                j2.lineTo(124.9227f, 84.30673f);
                j2.lineTo(124.9227f, 112.99854f);
                j2.close();
                j2.moveTo(124.9227f, 157.6971f);
                j2.lineTo(138.53004f, 144.08975f);
                j2.lineTo(124.9227f, 130.4824f);
                j2.lineTo(124.9227f, 157.6971f);
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
