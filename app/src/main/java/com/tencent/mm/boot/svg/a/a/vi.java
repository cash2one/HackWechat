package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class vi extends c {
    private final int height = a.CTRL_INDEX;
    private final int width = 450;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 450;
            case 1:
                return a.CTRL_INDEX;
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
                canvas.saveLayerAlpha(null, 7, 4);
                i2 = c.a(i2, looper);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(70.67984f, 150.63449f);
                j.cubicTo(67.97303f, 110.35668f, 80.40884f, 71.12603f, 108.708755f, 42.23457f);
                j.cubicTo(166.09906f, -16.355326f, 266.9981f, -10.238467f, 334.07306f, 55.896957f);
                j.cubicTo(401.14804f, 122.03238f, 408.999f, 223.14223f, 351.6087f, 281.73212f);
                j.cubicTo(320.71915f, 313.26736f, 277.22516f, 326.05713f, 233.18497f, 320.83246f);
                j.cubicTo(228.70084f, 330.40506f, 222.63911f, 339.28018f, 214.97217f, 347.10776f);
                j.cubicTo(173.24408f, 389.71017f, 99.76736f, 385.15027f, 50.85731f, 336.92297f);
                j.cubicTo(1.947269f, 288.69565f, -3.8748572f, 215.06361f, 37.85323f, 172.46121f);
                j.cubicTo(47.367443f, 162.74765f, 58.53215f, 155.48589f, 70.67984f, 150.63449f);
                j.close();
                j.moveTo(70.67984f, 150.63449f);
                j.cubicTo(73.46225f, 192.0373f, 92.244995f, 234.54659f, 126.2444f, 268.06973f);
                j.cubicTo(157.21716f, 298.60867f, 195.40207f, 316.3501f, 233.18497f, 320.83246f);
                j.cubicTo(253.10619f, 278.3053f, 241.89159f, 222.01225f, 201.96808f, 182.64603f);
                j.cubicTo(164.20978f, 145.41478f, 111.81031f, 134.20828f, 70.67984f, 150.63449f);
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
