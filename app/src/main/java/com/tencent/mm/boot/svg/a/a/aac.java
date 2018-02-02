package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aac extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.saveLayerAlpha(null, bs.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(90.0f, 180.0f);
                j.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                j.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                j.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                j.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                j.close();
                j.moveTo(44.0f, 67.99653f);
                j.cubicTo(44.0f, 66.34159f, 45.34499f, 65.0f, 46.99624f, 65.0f);
                j.lineTo(104.00376f, 65.0f);
                j.cubicTo(105.65854f, 65.0f, 107.0f, 66.33738f, 107.0f, 67.99653f);
                j.lineTo(107.0f, 112.00347f);
                j.cubicTo(107.0f, 113.65841f, 105.65501f, 115.0f, 104.00376f, 115.0f);
                j.lineTo(46.99624f, 115.0f);
                j.cubicTo(45.34146f, 115.0f, 44.0f, 113.66262f, 44.0f, 112.00347f);
                j.lineTo(44.0f, 67.99653f);
                j.close();
                j.moveTo(131.5f, 116.79712f);
                j.cubicTo(133.91545f, 117.568535f, 136.0f, 116.05244f, 136.0f, 113.73276f);
                j.lineTo(136.0f, 66.235054f);
                j.cubicTo(136.0f, 63.63856f, 133.69482f, 62.548866f, 131.5f, 63.170685f);
                j.cubicTo(130.19809f, 64.306465f, 119.559074f, 74.1768f, 112.0f, 81.05712f);
                j.lineTo(112.0f, 98.72812f);
                j.cubicTo(119.74342f, 105.702545f, 130.61983f, 115.864586f, 131.5f, 116.79712f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
