package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nz extends c {
    private final int height = j.CTRL_BYTE;
    private final int width = j.CTRL_BYTE;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return j.CTRL_BYTE;
            case 1:
                return j.CTRL_BYTE;
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
                i2 = c.a(i2, looper);
                i2.setColor(-686547);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(71.7024f, 113.94841f);
                j.lineTo(70.50466f, 117.91833f);
                j.cubicTo(68.771225f, 123.66382f, 71.968994f, 129.74753f, 77.638115f, 131.50388f);
                j.lineTo(96.88131f, 137.46565f);
                j.cubicTo(102.55444f, 139.22325f, 108.55855f, 135.99077f, 110.29208f, 130.24493f);
                j.lineTo(111.371895f, 126.665886f);
                j.lineTo(143.50204f, 136.96637f);
                j.cubicTo(146.29303f, 137.86111f, 148.55556f, 136.22597f, 148.55556f, 133.26476f);
                j.lineTo(148.55556f, 55.65808f);
                j.cubicTo(148.55556f, 52.718987f, 146.2936f, 51.04703f, 143.50204f, 51.92406f);
                j.lineTo(55.177776f, 79.67322f);
                j.lineTo(55.177776f, 108.65085f);
                j.lineTo(71.7024f, 113.94841f);
                j.lineTo(71.7024f, 113.94841f);
                j.close();
                j.moveTo(105.589226f, 124.81204f);
                j.lineTo(104.67921f, 127.869804f);
                j.cubicTo(103.85574f, 130.63673f, 101.00234f, 132.19417f, 98.304535f, 131.34686f);
                j.lineTo(80.01574f, 125.60284f);
                j.cubicTo(77.32027f, 124.756256f, 75.80068f, 121.823364f, 76.6236f, 119.05828f);
                j.lineTo(77.58325f, 115.833725f);
                j.lineTo(105.589226f, 124.81204f);
                j.lineTo(105.589226f, 124.81204f);
                j.close();
                j.moveTo(0.0f, 0.0f);
                j.lineTo(191.0f, 0.0f);
                j.lineTo(191.0f, 191.0f);
                j.lineTo(0.0f, 191.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(47.03692f, 77.76699f);
                j.cubicTo(44.500565f, 76.31182f, 42.444443f, 77.51847f, 42.444443f, 80.42022f);
                j.lineTo(42.444443f, 108.45738f);
                j.cubicTo(42.444443f, 111.37789f, 44.49037f, 112.57163f, 47.03692f, 111.11062f);
                j.lineTo(53.055557f, 107.65758f);
                j.lineTo(53.055557f, 81.22003f);
                j.lineTo(47.03692f, 77.76699f);
                j.lineTo(47.03692f, 77.76699f);
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
