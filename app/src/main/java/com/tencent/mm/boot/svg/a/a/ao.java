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

public final class ao extends c {
    private final int height = 35;
    private final int width = 38;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 35;
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
                Path j = c.j(looper);
                j.moveTo(2.0f, 0.0f);
                j.lineTo(36.0f, 0.0f);
                j.lineTo(36.0f, 34.0f);
                j.lineTo(2.0f, 34.0f);
                j.lineTo(2.0f, 0.0f);
                j.close();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3552823);
                Path j2 = c.j(looper);
                j2.moveTo(21.533342f, 1.5390043f);
                j2.cubicTo(18.496286f, 3.3171964f, 16.466658f, 6.4609146f, 16.466658f, 10.046336f);
                j2.lineTo(16.466658f, 24.953663f);
                j2.cubicTo(16.466658f, 27.638464f, 13.914593f, 29.814804f, 10.766671f, 29.814804f);
                j2.cubicTo(7.618604f, 29.814804f, 5.066686f, 27.638464f, 5.066686f, 24.953663f);
                j2.cubicTo(5.066686f, 23.043005f, 6.36239f, 21.394585f, 8.242542f, 20.600086f);
                j2.cubicTo(8.37827f, 20.542759f, 8.515754f, 20.488575f, 8.657331f, 20.440529f);
                j2.cubicTo(9.840709f, 19.954819f, 10.856035f, 19.041924f, 11.232944f, 17.982042f);
                j2.cubicTo(11.78931f, 16.417742f, 10.753362f, 15.149658f, 8.919134f, 15.149658f);
                j2.cubicTo(8.462077f, 15.149658f, 7.9984374f, 15.228689f, 7.5513253f, 15.371333f);
                j2.cubicTo(4.8933697f, 16.15236f, 2.6797478f, 17.860952f, 1.3511358f, 20.092672f);
                j2.cubicTo(0.49259856f, 21.534386f, 0.0f, 23.19059f, 0.0f, 24.953663f);
                j2.cubicTo(0.0f, 30.493301f, 4.8298936f, 35.0f, 10.766671f, 35.0f);
                j2.cubicTo(12.860947f, 35.0f, 14.811157f, 34.430172f, 16.466658f, 33.460995f);
                j2.cubicTo(19.503569f, 31.682804f, 21.533342f, 28.538937f, 21.533342f, 24.953663f);
                j2.lineTo(21.533342f, 10.046336f);
                j2.cubicTo(21.533342f, 7.361536f, 24.08526f, 5.1851964f, 27.233328f, 5.1851964f);
                j2.cubicTo(30.38125f, 5.1851964f, 32.933315f, 7.361536f, 32.933315f, 10.046336f);
                j2.cubicTo(32.933315f, 12.03872f, 31.52777f, 13.751053f, 29.51613f, 14.501845f);
                j2.cubicTo(28.218233f, 14.946692f, 27.154642f, 15.908084f, 26.749651f, 17.046844f);
                j2.cubicTo(26.19577f, 18.60411f, 27.22704f, 19.866358f, 29.05293f, 19.866358f);
                j2.cubicTo(29.466696f, 19.866358f, 29.884264f, 19.793913f, 30.291594f, 19.675516f);
                j2.cubicTo(30.358288f, 19.656956f, 30.423958f, 19.636002f, 30.490211f, 19.616243f);
                j2.cubicTo(33.125935f, 18.832373f, 35.326103f, 17.129019f, 36.64872f, 14.907476f);
                j2.cubicTo(37.507256f, 13.465614f, 38.0f, 11.809411f, 38.0f, 10.046336f);
                j2.cubicTo(38.0f, 4.506699f, 33.170105f, 0.0f, 27.233328f, 0.0f);
                j2.cubicTo(25.138906f, 0.0f, 23.188696f, 0.5696801f, 21.533342f, 1.5390043f);
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
