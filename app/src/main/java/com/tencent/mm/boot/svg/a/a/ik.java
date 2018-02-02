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

public final class ik extends c {
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
                j.moveTo(18.0f, 118.0f);
                j.lineTo(18.0f, 48.0f);
                j.lineTo(37.602036f, 48.0f);
                j.cubicTo(40.250168f, 42.636612f, 43.392544f, 37.607285f, 46.872543f, 34.0f);
                j.lineTo(10.101695f, 34.0f);
                j.cubicTo(6.7315254f, 34.00932f, 4.0f, 36.740845f, 4.0f, 40.0f);
                j.lineTo(4.0f, 125.89831f);
                j.cubicTo(4.0f, 129.26848f, 6.7315254f, 132.0f, 10.101695f, 132.0f);
                j.lineTo(119.932205f, 132.0f);
                j.cubicTo(123.30034f, 132.0f, 126.0339f, 129.26848f, 126.0f, 125.89831f);
                j.lineTo(126.0f, 81.6f);
                j.lineTo(112.0f, 93.62034f);
                j.lineTo(112.0f, 118.0f);
                j.lineTo(18.0f, 118.0f);
                j.close();
                j.moveTo(95.0f, 34.411526f);
                j.cubicTo(92.118645f, 34.389153f, 88.57559f, 34.372883f, 85.355934f, 34.372883f);
                j.cubicTo(57.560677f, 34.372883f, 38.688137f, 61.49085f, 38.688137f, 97.42373f);
                j.cubicTo(48.178307f, 75.376274f, 57.458984f, 64.881355f, 95.0f, 64.881355f);
                j.lineTo(95.0f, 87.254234f);
                j.lineTo(140.27118f, 49.627117f);
                j.lineTo(95.0f, 12.0f);
                j.lineTo(95.0f, 34.411526f);
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
