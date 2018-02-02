package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.a;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class kz extends c {
    private final int height = a.CTRL_INDEX;
    private final int width = 300;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 300;
            case 1:
                return a.CTRL_INDEX;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-921103);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(300.0f, 0.0f);
                j.lineTo(300.0f, 136.0f);
                j.lineTo(0.0f, 136.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3552823);
                e = c.a(e, 1.0f, 0.0f, 111.0f, 0.0f, 1.0f, 39.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 3.004289f);
                j2.cubicTo(0.0f, 1.345066f, 1.3380457f, 0.0f, 3.0004263f, 0.0f);
                j2.lineTo(75.99957f, 0.0f);
                j2.cubicTo(77.65666f, 0.0f, 79.0f, 1.3527762f, 79.0f, 3.004289f);
                j2.lineTo(79.0f, 53.995712f);
                j2.cubicTo(79.0f, 55.654934f, 77.66196f, 57.0f, 75.99957f, 57.0f);
                j2.lineTo(3.0004263f, 57.0f);
                j2.cubicTo(1.3433366f, 57.0f, 0.0f, 55.647224f, 0.0f, 53.995712f);
                j2.lineTo(0.0f, 3.004289f);
                j2.close();
                j2.moveTo(4.0f, 4.0f);
                j2.lineTo(75.0f, 4.0f);
                j2.lineTo(75.0f, 53.0f);
                j2.lineTo(4.0f, 53.0f);
                j2.lineTo(4.0f, 4.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j3 = c.j(looper);
                j3.moveTo(60.92106f, 30.279995f);
                j3.lineTo(50.039062f, 38.768322f);
                j3.lineTo(53.85942f, 46.690155f);
                j3.lineTo(27.17777f, 22.0f);
                j3.lineTo(2.0f, 45.710293f);
                j3.lineTo(2.0f, 56.5f);
                j3.lineTo(77.96154f, 56.5f);
                j3.lineTo(77.96154f, 45.710293f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 2);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
