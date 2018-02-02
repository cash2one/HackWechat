package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class io extends c {
    private final int height = 102;
    private final int width = 102;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1910.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2695.0f, 2012.0f);
                j.cubicTo(2666.8335f, 2012.0f, 2644.0f, 1989.1665f, 2644.0f, 1961.0f);
                j.cubicTo(2644.0f, 1932.8335f, 2666.8335f, 1910.0f, 2695.0f, 1910.0f);
                j.cubicTo(2723.1665f, 1910.0f, 2746.0f, 1932.8335f, 2746.0f, 1961.0f);
                j.cubicTo(2746.0f, 1989.1665f, 2723.1665f, 2012.0f, 2695.0f, 2012.0f);
                j.close();
                j.moveTo(2695.0f, 2009.0f);
                j.cubicTo(2668.4902f, 2009.0f, 2647.0f, 1987.5096f, 2647.0f, 1961.0f);
                j.cubicTo(2647.0f, 1934.4904f, 2668.4902f, 1913.0f, 2695.0f, 1913.0f);
                j.cubicTo(2721.5098f, 1913.0f, 2743.0f, 1934.4904f, 2743.0f, 1961.0f);
                j.cubicTo(2743.0f, 1987.5096f, 2721.5098f, 2009.0f, 2695.0f, 2009.0f);
                j.close();
                j.moveTo(2670.963f, 1965.1285f);
                j.cubicTo(2670.7703f, 1964.9377f, 2670.7505f, 1964.6127f, 2670.9253f, 1964.3942f);
                j.lineTo(2672.8416f, 1961.9998f);
                j.cubicTo(2673.0134f, 1961.785f, 2673.332f, 1961.7294f, 2673.5615f, 1961.8812f);
                j.lineTo(2686.488f, 1970.4324f);
                j.cubicTo(2686.9482f, 1970.7368f, 2687.674f, 1970.7001f, 2688.0981f, 1970.3591f);
                j.lineTo(2720.3496f, 1944.4258f);
                j.cubicTo(2720.5632f, 1944.254f, 2720.9004f, 1944.2769f, 2721.0906f, 1944.4653f);
                j.lineTo(2722.4705f, 1945.8309f);
                j.cubicTo(2722.6663f, 1946.0247f, 2722.6665f, 1946.3383f, 2722.4734f, 1946.5293f);
                j.lineTo(2688.0308f, 1980.6161f);
                j.cubicTo(2687.639f, 1981.0037f, 2687.0027f, 1981.0023f, 2686.6143f, 1980.618f);
                j.lineTo(2670.963f, 1965.1285f);
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
