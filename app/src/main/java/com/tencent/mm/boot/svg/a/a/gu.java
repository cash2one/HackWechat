package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class gu extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-9276814);
                Path j = c.j(looper);
                j.moveTo(15.052474f, 8.0f);
                j.cubicTo(11.166417f, 8.0f, 8.0f, 11.165231f, 8.0f, 15.049831f);
                j.lineTo(8.0f, 128.9022f);
                j.cubicTo(8.0f, 132.78682f, 11.166417f, 135.95204f, 15.052474f, 135.95204f);
                j.lineTo(76.365814f, 135.95204f);
                j.lineTo(76.365814f, 86.41139f);
                j.lineTo(59.670166f, 86.41139f);
                j.lineTo(59.670166f, 67.084305f);
                j.lineTo(76.365814f, 67.084305f);
                j.lineTo(76.365814f, 52.840763f);
                j.cubicTo(76.365814f, 36.295242f, 86.488754f, 27.32709f, 101.21739f, 27.32709f);
                j.cubicTo(108.26987f, 27.32709f, 114.362816f, 27.854628f, 116.13793f, 28.094418f);
                j.lineTo(116.13793f, 45.35931f);
                j.lineTo(105.91904f, 45.35931f);
                j.cubicTo(97.90704f, 45.35931f, 96.32384f, 49.147995f, 96.32384f, 54.759087f);
                j.lineTo(96.32384f, 67.084305f);
                j.lineTo(115.46627f, 67.084305f);
                j.lineTo(112.97151f, 86.41139f);
                j.lineTo(96.32384f, 86.41139f);
                j.lineTo(96.32384f, 136.0f);
                j.lineTo(128.94753f, 136.0f);
                j.cubicTo(132.83359f, 136.0f, 136.0f, 132.83476f, 136.0f, 128.95016f);
                j.lineTo(136.0f, 15.049831f);
                j.cubicTo(136.0f, 11.117272f, 132.88156f, 8.0f, 128.94753f, 8.0f);
                j.lineTo(15.052474f, 8.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
