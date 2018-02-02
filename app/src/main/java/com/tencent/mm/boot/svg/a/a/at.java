package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class at extends c {
    private final int height = 46;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-11184811);
                Path j = c.j(looper);
                j.moveTo(33.0f, 23.0f);
                j.lineTo(32.0f, 23.0f);
                j.lineTo(32.0f, 23.0f);
                j.lineTo(32.0f, 4.4975147f);
                j.cubicTo(32.0f, 3.1216204f, 30.880713f, 2.0f, 29.5f, 2.0f);
                j.cubicTo(28.109663f, 2.0f, 27.0f, 3.1181755f, 27.0f, 4.4975147f);
                j.lineTo(27.0f, 23.0f);
                j.lineTo(26.0f, 23.0f);
                j.lineTo(26.0f, 2.497515f);
                j.cubicTo(26.0f, 1.1216205f, 24.880713f, -3.5527137E-15f, 23.5f, -3.5527137E-15f);
                j.cubicTo(22.109663f, -3.5527137E-15f, 21.0f, 1.1181755f, 21.0f, 2.497515f);
                j.lineTo(21.0f, 23.0f);
                j.lineTo(21.0f, 23.0f);
                j.lineTo(20.0f, 23.0f);
                j.lineTo(20.0f, 23.0f);
                j.lineTo(20.0f, 4.4976234f);
                j.cubicTo(20.0f, 3.119065f, 18.880713f, 2.0f, 17.5f, 2.0f);
                j.cubicTo(16.109663f, 2.0f, 15.0f, 3.118224f, 15.0f, 4.4976234f);
                j.lineTo(15.0f, 23.0f);
                j.lineTo(14.0f, 23.0f);
                j.lineTo(14.0f, 7.492989f);
                j.cubicTo(14.0f, 6.1171875f, 12.880712f, 5.0f, 11.5f, 5.0f);
                j.cubicTo(10.109662f, 5.0f, 9.0f, 6.1161494f, 9.0f, 7.492989f);
                j.lineTo(9.0f, 25.753506f);
                j.lineTo(9.0f, 25.753506f);
                j.lineTo(9.0f, 33.0f);
                j.lineTo(9.07604f, 33.0f);
                j.cubicTo(9.823915f, 40.30732f, 15.996335f, 46.0f, 23.5f, 46.0f);
                j.cubicTo(31.008278f, 46.0f, 37.17619f, 40.30293f, 37.923923f, 33.0f);
                j.lineTo(37.923923f, 33.0f);
                j.lineTo(38.0f, 33.0f);
                j.lineTo(38.0f, 26.245796f);
                j.lineTo(38.0f, 17.508408f);
                j.cubicTo(38.0f, 16.115417f, 36.88071f, 15.0f, 35.5f, 15.0f);
                j.cubicTo(34.10966f, 15.0f, 33.0f, 16.123053f, 33.0f, 17.508408f);
                j.lineTo(33.0f, 23.0f);
                j.lineTo(33.0f, 23.0f);
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
