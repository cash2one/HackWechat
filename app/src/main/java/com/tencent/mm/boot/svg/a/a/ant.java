package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ant extends c {
    private final int height = k.CTRL_BYTE;
    private final int width = k.CTRL_BYTE;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return k.CTRL_BYTE;
            case 1:
                return k.CTRL_BYTE;
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
                i3.setColor(-13917627);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(94.5f, 0.45215607f);
                j.cubicTo(146.4412f, 0.45215607f, 188.54785f, 42.558807f, 188.54785f, 94.5f);
                j.cubicTo(188.54785f, 146.4412f, 146.4412f, 188.54785f, 94.5f, 188.54785f);
                j.cubicTo(42.558807f, 188.54785f, 0.45215607f, 146.4412f, 0.45215607f, 94.5f);
                j.cubicTo(0.45215607f, 42.558807f, 42.558807f, 0.45215607f, 94.5f, 0.45215607f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(73.00249f, 72.605316f);
                j.lineTo(67.42785f, 69.406975f);
                j.lineTo(64.84446f, 73.8535f);
                j.cubicTo(56.051033f, 88.9887f, 59.218388f, 107.78604f, 71.60051f, 118.51587f);
                j.lineTo(65.47644f, 129.0566f);
                j.lineTo(76.6257f, 135.45328f);
                j.lineTo(82.74977f, 124.91256f);
                j.lineTo(82.74977f, 124.91256f);
                j.cubicTo(98.29174f, 130.20367f, 116.257065f, 123.530815f, 125.05048f, 108.395615f);
                j.lineTo(127.63388f, 103.94909f);
                j.lineTo(122.05925f, 100.75075f);
                j.lineTo(119.47585f, 105.19727f);
                j.cubicTo(111.18062f, 119.475f, 93.6396f, 124.46423f, 80.63803f, 117.004814f);
                j.cubicTo(66.5463f, 108.919945f, 62.12385f, 91.32957f, 70.41909f, 77.05184f);
                j.lineTo(73.00249f, 72.605316f);
                j.lineTo(73.00249f, 72.605316f);
                j.lineTo(73.00249f, 72.605316f);
                j.close();
                j.moveTo(118.84387f, 49.994183f);
                j.cubicTo(108.99176f, 44.341713f, 96.38864f, 47.70522f, 90.71172f, 57.476303f);
                j.lineTo(77.0684f, 80.95914f);
                j.cubicTo(71.383545f, 90.74387f, 74.75962f, 103.25695f, 84.61389f, 108.91067f);
                j.cubicTo(94.466f, 114.56313f, 107.06912f, 111.19963f, 112.74604f, 101.42854f);
                j.lineTo(126.38937f, 77.94571f);
                j.cubicTo(132.07422f, 68.16097f, 128.69815f, 55.647892f, 118.84387f, 49.994183f);
                j.lineTo(118.84387f, 49.994183f);
                j.close();
                j.moveTo(64.33125f, 132.80655f);
                j.cubicTo(64.250336f, 131.96338f, 64.78417f, 131.62376f, 65.5296f, 132.05144f);
                j.lineTo(73.98914f, 136.90495f);
                j.cubicTo(74.731895f, 137.33109f, 74.702484f, 137.96323f, 73.93026f, 138.3138f);
                j.lineTo(66.64218f, 141.62236f);
                j.cubicTo(65.86691f, 141.9743f, 65.17252f, 141.57278f, 65.09193f, 140.73293f);
                j.lineTo(64.33125f, 132.80655f);
                j.lineTo(64.33125f, 132.80655f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
