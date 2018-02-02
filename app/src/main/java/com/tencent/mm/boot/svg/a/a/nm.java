package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nm extends c {
    private final int height = ar.CTRL_INDEX;
    private final int width = ar.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ar.CTRL_INDEX;
            case 1:
                return ar.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-14187817);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(192.0f, 0.0f);
                j.lineTo(192.0f, 192.0f);
                j.lineTo(0.0f, 192.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(56.891357f, 44.8f);
                j2.cubicTo(54.926315f, 44.8f, 53.333332f, 46.40846f, 53.333332f, 48.354576f);
                j2.lineTo(53.333332f, 143.64542f);
                j2.cubicTo(53.333332f, 145.60857f, 54.924335f, 147.2f, 56.891357f, 147.2f);
                j2.lineTo(135.10864f, 147.2f);
                j2.cubicTo(137.07368f, 147.2f, 138.66667f, 145.59154f, 138.66667f, 143.64542f);
                j2.lineTo(138.66667f, 48.354576f);
                j2.cubicTo(138.66667f, 46.391438f, 137.07567f, 44.8f, 135.10864f, 44.8f);
                j2.lineTo(56.891357f, 44.8f);
                j2.lineTo(56.891357f, 44.8f);
                j2.close();
                j2.moveTo(64.0f, 76.8f);
                j2.lineTo(64.0f, 83.2f);
                j2.lineTo(108.8f, 83.2f);
                j2.lineTo(108.8f, 76.8f);
                j2.lineTo(64.0f, 76.8f);
                j2.lineTo(64.0f, 76.8f);
                j2.close();
                j2.moveTo(64.0f, 89.6f);
                j2.lineTo(64.0f, 96.0f);
                j2.lineTo(87.46667f, 96.0f);
                j2.lineTo(87.46667f, 89.6f);
                j2.lineTo(64.0f, 89.6f);
                j2.lineTo(64.0f, 89.6f);
                j2.close();
                j2.moveTo(64.0f, 102.4f);
                j2.lineTo(64.0f, 108.8f);
                j2.lineTo(91.73333f, 108.8f);
                j2.lineTo(91.73333f, 102.4f);
                j2.lineTo(64.0f, 102.4f);
                j2.lineTo(64.0f, 102.4f);
                j2.close();
                j2.moveTo(70.4f, 55.466667f);
                j2.cubicTo(73.93463f, 55.466667f, 76.8f, 58.33163f, 76.8f, 61.865753f);
                j2.cubicTo(76.8f, 65.39988f, 73.93463f, 68.26667f, 70.4f, 68.26667f);
                j2.cubicTo(66.86537f, 68.26667f, 64.0f, 65.39988f, 64.0f, 61.865753f);
                j2.cubicTo(64.0f, 58.33163f, 66.86537f, 55.466667f, 70.4f, 55.466667f);
                j2.lineTo(70.4f, 55.466667f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
