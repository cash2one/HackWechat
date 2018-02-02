package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.contact.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class qh extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = 690;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 690;
            case 1:
                return e.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1315861);
                e = c.a(e, 1.0f, 0.0f, 225.0f, 0.0f, 1.0f, 114.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(228.0f, 119.822876f);
                j.lineTo(228.0f, 12.0f);
                j.lineTo(12.0f, 12.0f);
                j.lineTo(12.0f, 119.51874f);
                j.lineTo(80.73831f, 55.335876f);
                j.lineTo(162.56027f, 130.40851f);
                j.lineTo(150.84477f, 106.321465f);
                j.lineTo(184.2155f, 80.51195f);
                j.lineTo(228.0f, 119.822876f);
                j.lineTo(228.0f, 119.822876f);
                j.close();
                j.moveTo(5.9924946f, 0.0f);
                j.cubicTo(2.6829312f, 0.0f, 0.0f, 2.6830428f, 0.0f, 6.004041f);
                j.lineTo(0.0f, 179.99596f);
                j.cubicTo(0.0f, 183.3119f, 2.6953125f, 186.0f, 5.9924946f, 186.0f);
                j.lineTo(234.0075f, 186.0f);
                j.cubicTo(237.31706f, 186.0f, 240.0f, 183.31696f, 240.0f, 179.99596f);
                j.lineTo(240.0f, 6.004041f);
                j.cubicTo(240.0f, 2.6881008f, 237.30469f, 0.0f, 234.0075f, 0.0f);
                j.lineTo(5.9924946f, 0.0f);
                j.lineTo(5.9924946f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
