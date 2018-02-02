package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class s extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c.a(i3, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3355444);
                e = c.a(e, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 19.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(15.987003f, 13.975044f);
                j.cubicTo(22.005089f, 9.323351f, 28.003181f, 4.6516933f, 34.021267f, 0.0f);
                j.lineTo(38.0f, 0.0f);
                j.lineTo(38.0f, 56.0f);
                j.cubicTo(36.340527f, 55.740463f, 34.401146f, 56.13975f, 33.03158f, 54.961853f);
                j.cubicTo(27.323397f, 50.619606f, 21.645203f, 46.247414f, 15.937019f, 41.91515f);
                j.cubicTo(11.648384f, 41.835293f, 7.339755f, 42.134758f, 3.0611162f, 41.78538f);
                j.cubicTo(1.2217014f, 41.605705f, 0.93179363f, 39.499466f, 1.0117682f, 38.032085f);
                j.cubicTo(1.0017713f, 31.314081f, 1.0017713f, 24.596079f, 1.0117682f, 17.878075f);
                j.cubicTo(0.94179046f, 16.440641f, 1.2117046f, 14.274509f, 3.0511193f, 14.144741f);
                j.cubicTo(7.3497515f, 13.735473f, 11.678374f, 14.074866f, 15.987003f, 13.975044f);
                j.lineTo(15.987003f, 13.975044f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(53.339943f, 7.6842885f);
                j.cubicTo(50.13705f, 5.6012874f, 53.26988f, 0.3937841f, 56.58287f, 2.4867043f);
                j.cubicTo(68.53366f, 9.856561f, 73.35802f, 26.480894f, 67.53276f, 39.147526f);
                j.cubicTo(65.27071f, 44.42446f, 61.207047f, 48.66982f, 56.58287f, 51.9927f);
                j.cubicTo(53.500084f, 52.151405f, 50.997826f, 49.701397f, 52.39909f, 46.68601f);
                j.cubicTo(60.506413f, 42.37122f, 65.41084f, 32.83901f, 63.689285f, 23.80275f);
                j.cubicTo(62.758446f, 17.20658f, 58.504604f, 11.681667f, 53.339943f, 7.6842885f);
                j.lineTo(53.339943f, 7.6842885f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(45.38676f, 13.448668f);
                j.cubicTo(48.04146f, 11.830107f, 49.88165f, 14.987299f, 51.44028f, 16.635832f);
                j.cubicTo(55.512833f, 20.991959f, 57.161964f, 27.55612f, 55.13072f, 33.21109f);
                j.cubicTo(53.984367f, 36.618057f, 51.44028f, 39.365616f, 48.57441f, 41.46375f);
                j.cubicTo(47.025837f, 42.682663f, 44.481747f, 41.693542f, 44.05941f, 39.805225f);
                j.cubicTo(43.808018f, 38.60629f, 44.421413f, 37.467304f, 44.652695f, 36.318325f);
                j.cubicTo(46.301826f, 35.149364f, 48.16213f, 34.02037f, 49.036972f, 32.11207f);
                j.cubicTo(51.239166f, 27.815887f, 49.348698f, 22.320776f, 45.47726f, 19.643158f);
                j.cubicTo(44.300747f, 17.834766f, 42.94323f, 14.857414f, 45.38676f, 13.448668f);
                j.lineTo(45.38676f, 13.448668f);
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
