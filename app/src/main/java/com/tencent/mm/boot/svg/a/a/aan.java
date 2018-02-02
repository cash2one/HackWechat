package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class aan extends c {
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
                e = c.a(e, 1.0f, 0.0f, -335.0f, 0.0f, 1.0f, -284.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 335.0f, 0.0f, 1.0f, 284.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a = c.a(i2, looper);
                a.setColor(-2565928);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 12.0f);
                j.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                j.lineTo(198.0f, 0.0f);
                j.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                j.lineTo(210.0f, 198.0f);
                j.cubicTo(210.0f, 204.62741f, 204.62741f, 210.0f, 198.0f, 210.0f);
                j.lineTo(12.0f, 210.0f);
                j.cubicTo(5.3725824f, 210.0f, 0.0f, 204.62741f, 0.0f, 198.0f);
                j.lineTo(0.0f, 12.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-1);
                j = c.j(looper);
                j.moveTo(157.64894f, 92.3088f);
                j.lineTo(144.74844f, 105.2093f);
                j.lineTo(138.95433f, 99.41519f);
                j.lineTo(151.85483f, 86.514694f);
                j.cubicTo(159.84056f, 78.52897f, 159.70537f, 65.69745f, 151.70346f, 57.695538f);
                j.cubicTo(143.70525f, 49.697327f, 130.86548f, 49.56299f, 122.88431f, 57.544167f);
                j.lineTo(97.083305f, 83.34517f);
                j.cubicTo(89.09758f, 91.33089f, 89.232765f, 104.162415f, 97.23468f, 112.16432f);
                j.lineTo(91.50112f, 117.89788f);
                j.cubicTo(80.298676f, 106.695435f, 80.20087f, 88.6394f, 91.2892f, 77.55106f);
                j.lineTo(117.0902f, 51.75006f);
                j.cubicTo(128.17189f, 40.668373f, 146.23703f, 40.761997f, 157.43701f, 51.961983f);
                j.cubicTo(168.63947f, 63.16443f, 168.73727f, 81.22047f, 157.64894f, 92.3088f);
                j.close();
                j.moveTo(51.753483f, 117.08678f);
                j.lineTo(64.653984f, 104.18628f);
                j.lineTo(70.44809f, 109.980385f);
                j.lineTo(57.54759f, 122.88088f);
                j.cubicTo(49.56187f, 130.86661f, 49.697052f, 143.69812f, 57.698963f, 151.70004f);
                j.cubicTo(65.697174f, 159.69824f, 78.53694f, 159.83258f, 86.51812f, 151.85141f);
                j.lineTo(112.31912f, 126.05041f);
                j.cubicTo(120.30484f, 118.06469f, 120.16966f, 105.23316f, 112.16775f, 97.231255f);
                j.lineTo(117.901306f, 91.497696f);
                j.cubicTo(129.10376f, 102.70014f, 129.20155f, 120.75618f, 118.11323f, 131.84451f);
                j.lineTo(92.312225f, 157.64552f);
                j.cubicTo(81.23054f, 168.7272f, 63.165394f, 168.63358f, 51.965405f, 157.4336f);
                j.cubicTo(40.76296f, 146.23114f, 40.665154f, 128.17511f, 51.753483f, 117.08678f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
