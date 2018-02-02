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

public final class mr extends c {
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
                float[] a2 = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
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
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = c.a(a, looper);
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
                canvas.drawPath(j2, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 166.0f, 0.0f, 1.0f, 93.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a5 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(43.0895f, 21.9691f);
                j2.lineTo(43.0895f, 49.9671f);
                j2.lineTo(3.0895f, 49.9651f);
                j2.lineTo(3.0895f, 21.9691f);
                j2.lineTo(3.0905f, 21.9671f);
                j2.lineTo(8.9995f, 21.9671f);
                j2.lineTo(8.9995f, 18.9671f);
                j2.lineTo(3.0905f, 18.9671f);
                j2.cubicTo(1.4415f, 18.9671f, 0.0895f, 20.3111f, 0.0895f, 21.9691f);
                j2.lineTo(0.0895f, 49.9651f);
                j2.cubicTo(0.0895f, 51.6241f, 1.4335f, 52.9671f, 3.0905f, 52.9671f);
                j2.lineTo(43.0895f, 52.9671f);
                j2.cubicTo(44.7385f, 52.9671f, 46.0895f, 51.6231f, 46.0895f, 49.9651f);
                j2.lineTo(46.0895f, 21.9691f);
                j2.cubicTo(46.0895f, 20.3101f, 44.7465f, 18.9671f, 43.0895f, 18.9671f);
                j2.lineTo(36.9995f, 18.9671f);
                j2.lineTo(36.9995f, 21.9691f);
                j2.lineTo(43.0895f, 21.9691f);
                j2.lineTo(43.0895f, 21.9691f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(12.0f, 19.0f);
                j.lineTo(34.0f, 19.0f);
                j.lineTo(34.0f, 18.967f);
                j.lineTo(12.0f, 18.967f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a5 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(9.0f, 13.4978f);
                j2.lineTo(9.0f, 18.9668f);
                j2.lineTo(12.0f, 18.9668f);
                j2.lineTo(12.0f, 13.4978f);
                j2.cubicTo(12.0f, 7.7088f, 16.714f, 3.0008f, 22.508f, 3.0008f);
                j2.lineTo(23.492f, 3.0008f);
                j2.cubicTo(29.286f, 3.0008f, 34.0f, 7.7088f, 34.0f, 13.4978f);
                j2.lineTo(34.0f, 18.9668f);
                j2.lineTo(37.0f, 18.9668f);
                j2.lineTo(37.0f, 13.4978f);
                j2.cubicTo(37.0f, 6.0438f, 30.952f, -2.0E-4f, 23.492f, -2.0E-4f);
                j2.lineTo(22.508f, -2.0E-4f);
                j2.cubicTo(15.041f, -2.0E-4f, 9.0f, 6.0428f, 9.0f, 13.4978f);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a5);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(37.0f, 22.0f);
                j.lineTo(37.0f, 21.969f);
                j.lineTo(9.0f, 21.967f);
                j.lineTo(9.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(33.9997f, 19.0003f);
                j.lineTo(11.9997f, 19.0003f);
                j.lineTo(11.9997f, 18.9673f);
                j.lineTo(8.9997f, 18.9673f);
                j.lineTo(8.9997f, 21.9673f);
                j.lineTo(36.9997f, 21.9683f);
                j.lineTo(36.9997f, 18.9673f);
                j.lineTo(33.9997f, 18.9673f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}