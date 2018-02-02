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

public final class aie extends c {
    private final int height = 120;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                j.moveTo(60.0f, 0.0f);
                j.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                j.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                j.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                j.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(60.0f, 117.0f);
                j.cubicTo(91.48023f, 117.0f, 117.0f, 91.48023f, 117.0f, 60.0f);
                j.cubicTo(117.0f, 28.51977f, 91.48023f, 3.0f, 60.0f, 3.0f);
                j.cubicTo(28.51977f, 3.0f, 3.0f, 28.51977f, 3.0f, 60.0f);
                j.cubicTo(3.0f, 91.48023f, 28.51977f, 117.0f, 60.0f, 117.0f);
                j.close();
                j.moveTo(60.0f, 120.0f);
                j.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                j.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                j.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                j.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                j.close();
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                Paint a2 = c.a(a, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(46.5f, 38.223152f);
                j.cubicTo(46.5f, 36.562f, 47.656143f, 35.89766f, 49.079807f, 36.73782f);
                j.lineTo(85.92019f, 58.478794f);
                j.cubicTo(87.34498f, 59.31962f, 87.34386f, 60.68353f, 85.92019f, 61.52369f);
                j.lineTo(49.079807f, 83.26466f);
                j.cubicTo(47.655018f, 84.10549f, 46.5f, 83.43548f, 46.5f, 81.779335f);
                j.lineTo(46.5f, 38.223152f);
                j.close();
                canvas.saveLayerAlpha(null, d.CTRL_INDEX, 4);
                a2 = c.a(i2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
