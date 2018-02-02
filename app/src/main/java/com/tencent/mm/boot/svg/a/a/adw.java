package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adw extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-8617594);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 50.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(53.458427f, 68.67285f);
                j.cubicTo(83.84122f, 68.67285f, 105.827965f, 35.957947f, 105.827965f, 35.957947f);
                j.cubicTo(106.46974f, 35.062405f, 106.47585f, 33.603374f, 105.81945f, 32.703407f);
                j.cubicTo(105.81945f, 32.703407f, 83.84122f, 2.4963452E-15f, 53.458427f, 0.0f);
                j.cubicTo(23.075638f, -2.4963452E-15f, 1.0888885f, 32.714905f, 1.0888885f, 32.714905f);
                j.cubicTo(0.4471118f, 33.610447f, 0.44100174f, 35.069477f, 1.0974094f, 35.969444f);
                j.cubicTo(1.0974094f, 35.969444f, 23.075642f, 68.67285f, 53.458427f, 68.67285f);
                j.close();
                j.moveTo(53.458427f, 54.626133f);
                j.cubicTo(64.858315f, 54.626133f, 74.09975f, 45.54212f, 74.09975f, 34.336426f);
                j.cubicTo(74.09975f, 23.13073f, 64.858315f, 14.04672f, 53.458427f, 14.04672f);
                j.cubicTo(42.058544f, 14.04672f, 32.817112f, 23.13073f, 32.817112f, 34.336426f);
                j.cubicTo(32.817112f, 45.54212f, 42.058544f, 54.626133f, 53.458427f, 54.626133f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(41.175587f, 25.24117f);
                j.cubicTo(39.181583f, 27.849945f, 38.0f, 31.093002f, 38.0f, 34.607468f);
                j.cubicTo(38.0f, 43.22759f, 45.10843f, 50.21493f, 53.877937f, 50.21493f);
                j.cubicTo(62.64744f, 50.21493f, 69.755875f, 43.22759f, 69.755875f, 34.607468f);
                j.cubicTo(69.755875f, 25.987343f, 62.64744f, 19.0f, 53.877937f, 19.0f);
                j.cubicTo(51.33193f, 19.0f, 48.92593f, 19.588953f, 46.793247f, 20.635828f);
                j.cubicTo(49.016388f, 21.031485f, 50.702347f, 22.943605f, 50.702347f, 25.242987f);
                j.cubicTo(50.702347f, 27.829023f, 48.56982f, 29.925226f, 45.93897f, 29.925226f);
                j.cubicTo(43.308117f, 29.925226f, 41.175587f, 27.829023f, 41.175587f, 25.242987f);
                j.cubicTo(41.175587f, 25.24238f, 41.175587f, 25.241776f, 41.175587f, 25.24117f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
