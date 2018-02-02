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

public final class oe extends c {
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
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(31.0f, 60.0f);
                j2.lineTo(31.0f, 136.9996f);
                j2.cubicTo(31.0f, 138.65668f, 32.350418f, 140.0f, 33.990707f, 140.0f);
                j2.lineTo(158.0093f, 140.0f);
                j2.cubicTo(159.66101f, 140.0f, 161.0f, 138.65442f, 161.0f, 136.9996f);
                j2.lineTo(161.0f, 60.0f);
                j2.lineTo(103.2854f, 107.40642f);
                j2.cubicTo(99.16379f, 110.791885f, 92.83887f, 110.79407f, 88.7146f, 107.40642f);
                j2.lineTo(31.0f, 60.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j2 = c.j(looper);
                j2.moveTo(32.66113f, 52.0f);
                j2.cubicTo(31.001602f, 52.0f, 30.711802f, 52.82119f, 32.017536f, 53.837048f);
                j2.lineTo(93.63985f, 101.779144f);
                j2.cubicTo(94.94393f, 102.79372f, 97.05661f, 102.795f, 98.36234f, 101.779144f);
                j2.lineTo(159.98466f, 53.837048f);
                j2.cubicTo(161.28874f, 52.822475f, 161.01111f, 52.0f, 159.34106f, 52.0f);
                j2.lineTo(32.66113f, 52.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
