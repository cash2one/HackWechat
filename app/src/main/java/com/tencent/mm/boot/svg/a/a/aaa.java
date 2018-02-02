package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aaa extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = i.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return i.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-13327053);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(105.0f, 0.0f);
                j.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                j.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                j.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                j.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                i3 = c.a(i2, looper);
                i3.setColor(1275068416);
                canvas.save();
                a = c.a(i3, looper);
                j = c.j(looper);
                j.moveTo(105.0f, 0.0f);
                j.cubicTo(162.9899f, 0.0f, 210.0f, 47.010098f, 210.0f, 105.0f);
                j.cubicTo(210.0f, 162.9899f, 162.9899f, 210.0f, 105.0f, 210.0f);
                j.cubicTo(47.010098f, 210.0f, 0.0f, 162.9899f, 0.0f, 105.0f);
                j.cubicTo(0.0f, 47.010098f, 47.010098f, 0.0f, 105.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(96.494316f, 113.505684f);
                j.cubicTo(104.60257f, 121.61394f, 112.285225f, 125.41699f, 115.126305f, 125.19428f);
                j.cubicTo(117.967384f, 124.97158f, 125.04247f, 120.106026f, 128.38249f, 120.17079f);
                j.cubicTo(129.98773f, 120.20192f, 140.47748f, 127.296135f, 141.74727f, 128.11635f);
                j.cubicTo(143.01704f, 128.93655f, 144.19443f, 129.89465f, 143.97304f, 131.10704f);
                j.cubicTo(143.75165f, 132.31943f, 139.14153f, 145.67386f, 127.37189f, 143.82458f);
                j.cubicTo(115.60224f, 141.9753f, 99.19372f, 129.28743f, 89.84374f, 120.15626f);
                j.lineTo(96.494316f, 113.505684f);
                j.lineTo(96.494316f, 113.505684f);
                j.close();
                j.moveTo(96.494316f, 113.505684f);
                j.cubicTo(88.38606f, 105.39743f, 84.58301f, 97.714775f, 84.80572f, 94.873695f);
                j.cubicTo(85.02842f, 92.03261f, 89.893974f, 84.95753f, 89.82921f, 81.617516f);
                j.cubicTo(89.79808f, 80.01227f, 82.703865f, 69.52252f, 81.88366f, 68.25274f);
                j.cubicTo(81.063446f, 66.98295f, 80.10535f, 65.80558f, 78.89296f, 66.02696f);
                j.cubicTo(77.680565f, 66.24835f, 64.32614f, 70.858475f, 66.17542f, 82.62811f);
                j.cubicTo(68.024704f, 94.39776f, 80.71257f, 110.80628f, 89.84374f, 120.15626f);
                j.lineTo(96.494316f, 113.505684f);
                j.lineTo(96.494316f, 113.505684f);
                j.close();
                canvas.saveLayerAlpha(null, 179, 4);
                Paint a2 = c.a(i2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
