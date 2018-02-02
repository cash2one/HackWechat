package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class aly extends c {
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
                e = c.a(e, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(51.0f, 45.0f);
                j.lineTo(51.0f, 20.995752f);
                j.cubicTo(51.0f, 20.45077f, 50.55641f, 20.0f, 50.00922f, 20.0f);
                j.lineTo(45.99078f, 20.0f);
                j.cubicTo(45.450974f, 20.0f, 45.0f, 20.445814f, 45.0f, 20.995752f);
                j.lineTo(45.0f, 45.0f);
                j.lineTo(20.995752f, 45.0f);
                j.cubicTo(20.45077f, 45.0f, 20.0f, 45.44359f, 20.0f, 45.99078f);
                j.lineTo(20.0f, 50.00922f);
                j.cubicTo(20.0f, 50.549026f, 20.445814f, 51.0f, 20.995752f, 51.0f);
                j.lineTo(45.0f, 51.0f);
                j.lineTo(45.0f, 75.00425f);
                j.cubicTo(45.0f, 75.54923f, 45.44359f, 76.0f, 45.99078f, 76.0f);
                j.lineTo(50.00922f, 76.0f);
                j.cubicTo(50.549026f, 76.0f, 51.0f, 75.554184f, 51.0f, 75.00425f);
                j.lineTo(51.0f, 51.0f);
                j.lineTo(75.00425f, 51.0f);
                j.cubicTo(75.54923f, 51.0f, 76.0f, 50.55641f, 76.0f, 50.00922f);
                j.lineTo(76.0f, 45.99078f);
                j.cubicTo(76.0f, 45.450974f, 75.554184f, 45.0f, 75.00425f, 45.0f);
                j.lineTo(51.0f, 45.0f);
                j.close();
                j.moveTo(48.551723f, 2.2325583f);
                j.cubicTo(22.886942f, 2.2325583f, 2.2325583f, 22.56116f, 2.2325583f, 47.448277f);
                j.cubicTo(2.2325583f, 73.27646f, 22.723429f, 93.76744f, 48.551723f, 93.76744f);
                j.cubicTo(73.43785f, 93.76744f, 93.76744f, 73.112335f, 93.76744f, 47.448277f);
                j.cubicTo(93.76744f, 22.722431f, 73.277176f, 2.2325583f, 48.551723f, 2.2325583f);
                j.lineTo(48.551723f, 0.0f);
                j.cubicTo(74.50971f, 5.9487298E-15f, 96.0f, 21.488955f, 96.0f, 47.448277f);
                j.cubicTo(96.0f, 74.50933f, 74.50971f, 96.0f, 48.551723f, 96.0f);
                j.cubicTo(21.490286f, 96.0f, 0.0f, 74.50933f, 0.0f, 47.448277f);
                j.cubicTo(0.0f, 21.488955f, 21.490286f, 5.9487298E-15f, 48.551723f, 5.9487298E-15f);
                j.lineTo(48.551723f, 2.2325583f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(419430400);
                j = c.j(looper);
                j.moveTo(48.0f, 0.0f);
                j.cubicTo(74.509674f, 0.0f, 96.0f, 21.49033f, 96.0f, 48.0f);
                j.cubicTo(96.0f, 74.509674f, 74.509674f, 96.0f, 48.0f, 96.0f);
                j.cubicTo(21.49033f, 96.0f, 0.0f, 74.509674f, 0.0f, 48.0f);
                j.cubicTo(0.0f, 21.49033f, 21.49033f, 0.0f, 48.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
