package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
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

public final class in extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-9276814);
                Path j = c.j(looper);
                j.moveTo(117.3346f, 26.695942f);
                j.cubicTo(105.29833f, 14.659666f, 89.32124f, 8.030549f, 72.27494f, 8.0f);
                j.cubicTo(37.143677f, 8.0f, 8.58043f, 36.593796f, 8.549881f, 71.69451f);
                j.cubicTo(8.549881f, 82.936516f, 11.482577f, 93.87303f, 17.042482f, 103.55704f);
                j.lineTo(8.0f, 136.58043f);
                j.lineTo(41.787113f, 127.721245f);
                j.cubicTo(51.104534f, 132.79236f, 61.582817f, 135.48067f, 72.24439f, 135.48067f);
                j.lineTo(72.27494f, 135.48067f);
                j.lineTo(72.27494f, 135.48067f);
                j.cubicTo(107.375656f, 135.48067f, 135.96945f, 106.88687f, 136.0f, 71.75561f);
                j.cubicTo(136.0f, 54.739857f, 129.37088f, 38.73222f, 117.3346f, 26.695942f);
                j.lineTo(117.3346f, 26.695942f);
                j.close();
                j.moveTo(72.27494f, 124.72745f);
                j.lineTo(72.27494f, 124.72745f);
                j.cubicTo(62.743675f, 124.72745f, 53.426254f, 122.16134f, 45.30024f, 117.3346f);
                j.lineTo(43.375656f, 116.173744f);
                j.lineTo(23.335562f, 121.42816f);
                j.lineTo(28.681623f, 101.87685f);
                j.lineTo(27.429117f, 99.86062f);
                j.cubicTo(22.113604f, 91.429115f, 19.333652f, 81.684006f, 19.333652f, 71.69451f);
                j.cubicTo(19.333652f, 42.48974f, 43.100716f, 18.753222f, 72.30549f, 18.753222f);
                j.cubicTo(86.44964f, 18.753222f, 99.73843f, 24.282578f, 109.75848f, 34.272076f);
                j.cubicTo(119.74797f, 44.292126f, 125.24678f, 57.580906f, 125.24678f, 71.72506f);
                j.cubicTo(125.21623f, 100.96038f, 101.449165f, 124.72745f, 72.27494f, 124.72745f);
                j.lineTo(72.27494f, 124.72745f);
                j.close();
                j.moveTo(101.326965f, 85.04439f);
                j.cubicTo(99.73843f, 84.25012f, 91.9179f, 80.400955f, 90.45155f, 79.851074f);
                j.cubicTo(88.98521f, 79.33174f, 87.91599f, 79.0568f, 86.87733f, 80.64535f);
                j.cubicTo(85.80811f, 82.23389f, 82.75322f, 85.83866f, 81.836754f, 86.87733f);
                j.cubicTo(80.92029f, 87.94654f, 79.97327f, 88.06873f, 78.38473f, 87.27446f);
                j.cubicTo(76.79618f, 86.480194f, 71.66396f, 84.8f, 65.584724f, 79.36229f);
                j.cubicTo(60.849644f, 75.14654f, 57.672554f, 69.922676f, 56.725536f, 68.33413f);
                j.cubicTo(55.80907f, 66.74558f, 56.633892f, 65.89021f, 57.42816f, 65.09594f);
                j.cubicTo(58.130787f, 64.39332f, 59.016705f, 63.23246f, 59.810978f, 62.31599f);
                j.cubicTo(60.60525f, 61.39952f, 60.88019f, 60.727448f, 61.39952f, 59.658234f);
                j.cubicTo(61.918854f, 58.58902f, 61.67446f, 57.672554f, 61.27733f, 56.87828f);
                j.cubicTo(60.88019f, 56.08401f, 57.703102f, 48.232937f, 56.35895f, 45.055847f);
                j.cubicTo(55.075893f, 41.939857f, 53.76229f, 42.367542f, 52.784725f, 42.336994f);
                j.cubicTo(51.86826f, 42.275894f, 50.799046f, 42.275894f, 49.72983f, 42.275894f);
                j.cubicTo(48.66062f, 42.275894f, 46.949883f, 42.67303f, 45.483532f, 44.261574f);
                j.cubicTo(44.017185f, 45.85012f, 39.923626f, 49.699284f, 39.923626f, 57.550358f);
                j.cubicTo(39.923626f, 65.40143f, 45.636276f, 72.947014f, 46.43055f, 74.01623f);
                j.cubicTo(47.22482f, 75.08544f, 57.642006f, 91.154175f, 73.619095f, 98.058235f);
                j.cubicTo(77.40716f, 99.70788f, 80.37041f, 100.68544f, 82.69212f, 101.41862f);
                j.cubicTo(86.51074f, 102.64057f, 89.96277f, 102.457275f, 92.71217f, 102.06014f);
                j.cubicTo(95.76707f, 101.601906f, 102.12124f, 98.210976f, 103.46539f, 94.48401f);
                j.cubicTo(104.779f, 90.75704f, 104.779f, 87.579956f, 104.38186f, 86.907875f);
                j.cubicTo(103.984726f, 86.2358f, 102.91551f, 85.83866f, 101.326965f, 85.04439f);
                j.lineTo(101.326965f, 85.04439f);
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
