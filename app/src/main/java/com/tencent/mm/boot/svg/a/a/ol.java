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

public final class ol extends c {
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
                i3.setColor(-12206054);
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
                j2.moveTo(125.05173f, 106.30443f);
                j2.cubicTo(134.37202f, 117.3619f, 151.40338f, 137.34488f, 152.32759f, 139.00922f);
                j2.cubicTo(156.1268f, 140.24745f, 158.94827f, 137.81317f, 158.94827f, 135.69887f);
                j2.lineTo(158.94827f, 56.250595f);
                j2.cubicTo(158.94827f, 53.69053f, 155.8298f, 51.942085f, 152.32759f, 52.94025f);
                j2.cubicTo(150.75885f, 54.967968f, 134.14519f, 74.351326f, 125.05173f, 85.322044f);
                j2.lineTo(125.05173f, 106.30443f);
                j2.lineTo(125.05173f, 106.30443f);
                j2.close();
                j2.moveTo(33.051723f, 67.973175f);
                j2.cubicTo(33.051723f, 61.34662f, 38.431973f, 55.97473f, 45.052055f, 55.97473f);
                j2.lineTo(103.05139f, 55.97473f);
                j2.cubicTo(109.67899f, 55.97473f, 115.05173f, 61.34798f, 115.05173f, 67.973175f);
                j2.lineTo(115.05173f, 123.976295f);
                j2.cubicTo(115.05173f, 130.60284f, 109.67148f, 135.97473f, 103.05139f, 135.97473f);
                j2.lineTo(45.052055f, 135.97473f);
                j2.cubicTo(38.424454f, 135.97473f, 33.051723f, 130.60149f, 33.051723f, 123.976295f);
                j2.lineTo(33.051723f, 67.973175f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
