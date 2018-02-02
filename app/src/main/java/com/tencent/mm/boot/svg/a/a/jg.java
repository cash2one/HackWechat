package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class jg extends c {
    private final int height = GameJsApiLaunchApplication.CTRL_BYTE;
    private final int width = GameJsApiLaunchApplication.CTRL_BYTE;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return GameJsApiLaunchApplication.CTRL_BYTE;
            case 1:
                return GameJsApiLaunchApplication.CTRL_BYTE;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -449.0f, 0.0f, 1.0f, -309.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 459.0f, 0.0f, 1.0f, 319.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(10.0f);
                Path j = c.j(looper);
                j.moveTo(240.0f, 121.48148f);
                j.cubicTo(240.0f, 53.724445f, 186.27556f, 0.0f, 118.51852f, 0.0f);
                j.cubicTo(53.724445f, 0.0f, 0.0f, 53.724445f, 0.0f, 121.48148f);
                j.cubicTo(0.0f, 186.27556f, 53.724445f, 240.0f, 118.51852f, 240.0f);
                j.cubicTo(186.27556f, 240.0f, 240.0f, 186.27556f, 240.0f, 121.48148f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-1);
                j = c.j(looper);
                j.moveTo(62.89717f, 128.89716f);
                j.cubicTo(62.320534f, 128.30037f, 62.253185f, 127.272156f, 62.745144f, 126.60276f);
                j.lineTo(67.678764f, 119.88967f);
                j.cubicTo(68.17144f, 119.2193f, 69.10391f, 119.084435f, 69.767876f, 119.59332f);
                j.lineTo(100.458435f, 143.11588f);
                j.cubicTo(101.119545f, 143.62259f, 102.17168f, 143.60332f, 102.81298f, 143.06906f);
                j.lineTo(178.11874f, 80.33327f);
                j.cubicTo(178.75801f, 79.800705f, 179.75937f, 79.846115f, 180.34068f, 80.42023f);
                j.lineTo(184.92955f, 84.95216f);
                j.cubicTo(185.51743f, 85.53275f, 185.51967f, 86.470215f, 184.92761f, 87.05289f);
                j.lineTo(102.71939f, 167.95805f);
                j.cubicTo(102.13045f, 168.53767f, 101.192276f, 168.5307f, 100.60892f, 167.92696f);
                j.lineTo(62.89717f, 128.89716f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
