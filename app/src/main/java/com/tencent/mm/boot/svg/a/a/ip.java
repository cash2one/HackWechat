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

public final class ip extends c {
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
                e = c.a(e, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -2054.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2697.9246f, 2114.546f);
                j.lineTo(2690.5f, 2121.9705f);
                j.lineTo(2692.6213f, 2124.0918f);
                j.lineTo(2700.046f, 2116.6672f);
                j.lineTo(2707.4705f, 2124.0918f);
                j.lineTo(2709.5918f, 2121.9705f);
                j.lineTo(2702.1672f, 2114.546f);
                j.lineTo(2709.5918f, 2107.1213f);
                j.lineTo(2707.4705f, 2105.0f);
                j.lineTo(2700.046f, 2112.4246f);
                j.lineTo(2692.6213f, 2105.0f);
                j.lineTo(2690.5f, 2107.1213f);
                j.lineTo(2697.9246f, 2114.546f);
                j.close();
                j.moveTo(2695.0f, 2156.0f);
                j.cubicTo(2666.8335f, 2156.0f, 2644.0f, 2133.1665f, 2644.0f, 2105.0f);
                j.cubicTo(2644.0f, 2076.8335f, 2666.8335f, 2054.0f, 2695.0f, 2054.0f);
                j.cubicTo(2723.1665f, 2054.0f, 2746.0f, 2076.8335f, 2746.0f, 2105.0f);
                j.cubicTo(2746.0f, 2133.1665f, 2723.1665f, 2156.0f, 2695.0f, 2156.0f);
                j.close();
                j.moveTo(2695.0f, 2153.0f);
                j.cubicTo(2668.4902f, 2153.0f, 2647.0f, 2131.5098f, 2647.0f, 2105.0f);
                j.cubicTo(2647.0f, 2078.4902f, 2668.4902f, 2057.0f, 2695.0f, 2057.0f);
                j.cubicTo(2721.5098f, 2057.0f, 2743.0f, 2078.4902f, 2743.0f, 2105.0f);
                j.cubicTo(2743.0f, 2131.5098f, 2721.5098f, 2153.0f, 2695.0f, 2153.0f);
                j.close();
                j.moveTo(2674.0f, 2081.4993f);
                j.cubicTo(2674.0f, 2080.395f, 2674.8967f, 2079.5f, 2675.9976f, 2079.5f);
                j.lineTo(2714.0024f, 2079.5f);
                j.cubicTo(2715.1057f, 2079.5f, 2716.0f, 2080.396f, 2716.0f, 2081.4993f);
                j.lineTo(2716.0f, 2128.5007f);
                j.cubicTo(2716.0f, 2129.605f, 2715.1033f, 2130.5f, 2714.0024f, 2130.5f);
                j.lineTo(2675.9976f, 2130.5f);
                j.cubicTo(2674.8943f, 2130.5f, 2674.0f, 2129.604f, 2674.0f, 2128.5007f);
                j.lineTo(2674.0f, 2081.4993f);
                j.close();
                j.moveTo(2677.0f, 2082.5f);
                j.lineTo(2713.0f, 2082.5f);
                j.lineTo(2713.0f, 2127.5f);
                j.lineTo(2677.0f, 2127.5f);
                j.lineTo(2677.0f, 2082.5f);
                j.close();
                j.moveTo(2681.5f, 2087.0f);
                j.lineTo(2696.5f, 2087.0f);
                j.lineTo(2696.5f, 2090.0f);
                j.lineTo(2681.5f, 2090.0f);
                j.lineTo(2681.5f, 2087.0f);
                j.close();
                j.moveTo(2681.5f, 2094.5f);
                j.lineTo(2696.5f, 2094.5f);
                j.lineTo(2696.5f, 2097.5f);
                j.lineTo(2681.5f, 2097.5f);
                j.lineTo(2681.5f, 2094.5f);
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
