package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class mq extends c {
    private final int height = JsApiSetAudioState.CTRL_INDEX;
    private final int width = 378;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return JsApiSetAudioState.CTRL_INDEX;
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
                a.setColor(-13158344);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(14.0f, 226.0f);
                j.lineTo(360.0f, 226.0f);
                j.lineTo(360.0f, 14.0f);
                j.lineTo(14.0f, 14.0f);
                j.lineTo(14.0f, 226.0f);
                j.close();
                j.moveTo(13.0f, 227.0f);
                j.lineTo(361.0f, 227.0f);
                j.lineTo(361.0f, 13.0f);
                j.lineTo(13.0f, 13.0f);
                j.lineTo(13.0f, 227.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(371.0002f, 225.9932f);
                j2.cubicTo(371.0002f, 232.0622f, 366.0632f, 237.0002f, 359.9932f, 237.0002f);
                j2.lineTo(206.0002f, 237.0002f);
                j2.lineTo(206.0002f, 237.0002f);
                j2.lineTo(168.0002f, 237.0002f);
                j2.lineTo(168.0002f, 237.0002f);
                j2.lineTo(14.0062f, 237.0002f);
                j2.cubicTo(7.9382f, 237.0002f, 3.0002f, 232.0622f, 3.0002f, 225.9932f);
                j2.lineTo(3.0002f, 14.0072f);
                j2.cubicTo(3.0002f, 7.9372f, 7.9382f, 3.0002f, 14.0062f, 3.0002f);
                j2.lineTo(359.9932f, 3.0002f);
                j2.cubicTo(366.0632f, 3.0002f, 371.0002f, 7.9372f, 371.0002f, 14.0072f);
                j2.lineTo(371.0002f, 225.9932f);
                j2.close();
                j2.moveTo(256.0002f, 278.7302f);
                j2.lineTo(256.0002f, 284.0002f);
                j2.lineTo(118.0002f, 284.0002f);
                j2.lineTo(118.0002f, 278.7302f);
                j2.lineTo(171.0002f, 273.7302f);
                j2.lineTo(171.0002f, 240.0002f);
                j2.lineTo(203.0002f, 240.0002f);
                j2.lineTo(203.0002f, 273.7302f);
                j2.lineTo(256.0002f, 278.7302f);
                j2.close();
                j2.moveTo(359.9932f, 2.0E-4f);
                j2.lineTo(14.0072f, 2.0E-4f);
                j2.cubicTo(6.2762f, 2.0E-4f, 2.0E-4f, 6.2712f, 2.0E-4f, 14.0072f);
                j2.lineTo(2.0E-4f, 225.9932f);
                j2.cubicTo(2.0E-4f, 233.7342f, 6.2712f, 240.0002f, 14.0072f, 240.0002f);
                j2.lineTo(168.0002f, 240.0002f);
                j2.lineTo(168.0002f, 271.0002f);
                j2.lineTo(115.0002f, 276.0002f);
                j2.lineTo(115.0002f, 287.0002f);
                j2.lineTo(259.0002f, 287.0002f);
                j2.lineTo(259.0002f, 276.0002f);
                j2.lineTo(206.0002f, 271.0002f);
                j2.lineTo(206.0002f, 240.0002f);
                j2.lineTo(359.9932f, 240.0002f);
                j2.cubicTo(367.7242f, 240.0002f, 374.0002f, 233.7292f, 374.0002f, 225.9932f);
                j2.lineTo(374.0002f, 14.0072f);
                j2.cubicTo(374.0002f, 6.2652f, 367.7292f, 2.0E-4f, 359.9932f, 2.0E-4f);
                j2.lineTo(359.9932f, 2.0E-4f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
