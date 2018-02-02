package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class wv extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                a.setColor(1711276032);
                Path j = c.j(looper);
                j.moveTo(90.0f, 0.0f);
                j.cubicTo(139.70563f, 0.0f, 180.0f, 40.29437f, 180.0f, 90.0f);
                j.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                j.cubicTo(40.29437f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                j.cubicTo(0.0f, 40.29437f, 40.29437f, 0.0f, 90.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(69.0f, 59.64535f);
                j.cubicTo(69.0f, 56.333775f, 71.31589f, 54.997013f, 74.19147f, 56.67054f);
                j.lineTo(126.27224f, 86.98049f);
                j.cubicTo(129.1394f, 88.649124f, 129.14781f, 91.349625f, 126.27224f, 93.023155f);
                j.lineTo(74.19147f, 123.33311f);
                j.cubicTo(71.3243f, 125.00174f, 69.0f, 123.65884f, 69.0f, 120.35829f);
                j.lineTo(69.0f, 59.64535f);
                j.close();
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                Paint a2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-855638017);
                j = c.j(looper);
                j.moveTo(90.0f, 174.0f);
                j.cubicTo(136.39192f, 174.0f, 174.0f, 136.39192f, 174.0f, 90.0f);
                j.cubicTo(174.0f, 43.60808f, 136.39192f, 6.0f, 90.0f, 6.0f);
                j.cubicTo(43.60808f, 6.0f, 6.0f, 43.60808f, 6.0f, 90.0f);
                j.cubicTo(6.0f, 136.39192f, 43.60808f, 174.0f, 90.0f, 174.0f);
                j.close();
                j.moveTo(90.0f, 180.0f);
                j.cubicTo(40.294373f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                j.cubicTo(0.0f, 40.294373f, 40.294373f, 0.0f, 90.0f, 0.0f);
                j.cubicTo(139.70563f, 0.0f, 180.0f, 40.294373f, 180.0f, 90.0f);
                j.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
