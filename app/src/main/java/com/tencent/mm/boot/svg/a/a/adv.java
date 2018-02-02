package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adv extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                a.setColor(-8617594);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 50.0f, 0.0f, 1.0f, 36.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(24.867924f, 54.0f);
                j.lineTo(2.0f, 54.0f);
                j.cubicTo(1.277121f, 54.0f, 0.50183654f, 53.545902f, -1.0658141E-14f, 53.0f);
                j.cubicTo(-0.17057356f, 51.97461f, 0.02324753f, 51.06792f, 1.0f, 50.0f);
                j.lineTo(43.0f, 1.0f);
                j.cubicTo(43.767178f, 0.09632745f, 44.461952f, -0.13072085f, 45.0f, 7.1054274E-15f);
                j.cubicTo(45.696445f, 0.28127408f, 46.048306f, 0.8571648f, 46.0f, 1.0f);
                j.lineTo(42.132076f, 42.0f);
                j.lineTo(67.0f, 42.0f);
                j.cubicTo(67.66808f, 42.0f, 68.47741f, 42.454098f, 69.0f, 43.0f);
                j.cubicTo(69.17823f, 44.026894f, 68.97627f, 44.93208f, 68.0f, 46.0f);
                j.lineTo(24.0f, 95.0f);
                j.cubicTo(23.331083f, 95.90367f, 22.604643f, 96.12922f, 22.0f, 96.0f);
                j.cubicTo(21.31604f, 95.717224f, 20.949804f, 95.14284f, 21.0f, 95.0f);
                j.lineTo(24.867924f, 54.0f);
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
