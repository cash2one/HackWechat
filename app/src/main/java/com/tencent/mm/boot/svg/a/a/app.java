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

public final class app extends c {
    private final int height = 696;
    private final int width = 540;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 540;
            case 1:
                return 696;
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
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                e = c.a(e, 0.70710677f, 0.70710677f, 0.10347748f, -0.70710677f, 0.70710677f, 314.05887f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(338.17682f, 421.62106f);
                j.lineTo(105.54254f, 421.62106f);
                j.cubicTo(69.57901f, 369.38614f, -1.5916157E-12f, 314.71432f, -1.5916157E-12f, 224.86458f);
                j.cubicTo(-1.5916157E-12f, 100.6753f, 99.32996f, 1.3195332E-12f, 221.85968f, 1.364242E-12f);
                j.cubicTo(344.3894f, 1.3704833E-12f, 443.71936f, 100.6753f, 443.71936f, 224.86458f);
                j.cubicTo(443.71936f, 314.71432f, 374.14035f, 369.38614f, 338.17682f, 421.62106f);
                j.close();
                j.moveTo(144.20879f, 451.20853f);
                j.lineTo(299.51056f, 451.20853f);
                j.cubicTo(305.63705f, 451.20853f, 310.60355f, 456.17606f, 310.60355f, 462.3038f);
                j.lineTo(310.60355f, 469.70065f);
                j.cubicTo(310.60355f, 475.82843f, 305.63705f, 480.79596f, 299.51056f, 480.79596f);
                j.lineTo(144.20879f, 480.79596f);
                j.cubicTo(138.0823f, 480.79596f, 133.11581f, 475.82843f, 133.11581f, 469.70065f);
                j.lineTo(133.11581f, 462.3038f);
                j.cubicTo(133.11581f, 456.17606f, 138.0823f, 451.20853f, 144.20879f, 451.20853f);
                j.close();
                j.moveTo(166.39476f, 510.3834f);
                j.lineTo(277.3246f, 510.3834f);
                j.cubicTo(283.45108f, 510.3834f, 288.41757f, 515.35095f, 288.41757f, 521.4787f);
                j.lineTo(288.41757f, 528.87555f);
                j.cubicTo(288.41757f, 535.0033f, 283.45108f, 539.9708f, 277.3246f, 539.9708f);
                j.lineTo(166.39476f, 539.9708f);
                j.cubicTo(160.26828f, 539.9708f, 155.30177f, 535.0033f, 155.30177f, 528.87555f);
                j.lineTo(155.30177f, 521.4787f);
                j.cubicTo(155.30177f, 515.35095f, 160.26828f, 510.3834f, 166.39476f, 510.3834f);
                j.close();
                j.moveTo(228.58931f, 274.01355f);
                j.cubicTo(234.95694f, 286.75146f, 253.13435f, 286.75146f, 259.50198f, 274.01355f);
                j.lineTo(288.41757f, 216.17035f);
                j.lineTo(317.33316f, 274.01355f);
                j.cubicTo(321.60043f, 282.54987f, 331.97977f, 286.0106f, 340.51608f, 281.74335f);
                j.cubicTo(349.0524f, 277.47607f, 352.51312f, 267.09674f, 348.24585f, 258.56042f);
                j.lineTo(303.87393f, 169.7981f);
                j.cubicTo(297.5063f, 157.06018f, 279.32886f, 157.06018f, 272.96124f, 169.7981f);
                j.lineTo(244.04565f, 227.64131f);
                j.lineTo(215.13005f, 169.7981f);
                j.cubicTo(208.76242f, 157.06018f, 190.58499f, 157.06018f, 184.21736f, 169.7981f);
                j.lineTo(155.30177f, 227.64131f);
                j.lineTo(126.386185f, 169.7981f);
                j.cubicTo(122.11892f, 161.2618f, 111.73958f, 157.80106f, 103.20328f, 162.06831f);
                j.cubicTo(94.66697f, 166.33559f, 91.20623f, 176.71492f, 95.473495f, 185.25122f);
                j.lineTo(139.84543f, 274.01355f);
                j.cubicTo(146.21306f, 286.75146f, 164.39049f, 286.75146f, 170.75812f, 274.01355f);
                j.lineTo(199.6737f, 216.17035f);
                j.lineTo(228.58931f, 274.01355f);
                j.close();
                canvas.saveLayerAlpha(null, 127, 4);
                i2 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, i2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
