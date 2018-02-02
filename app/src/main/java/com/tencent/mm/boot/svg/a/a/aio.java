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

public final class aio extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(25.0f, 20.0f);
                j.cubicTo(37.355473f, 8.722359f, 58.488342f, 9.416998f, 70.0f, 22.0f);
                j.cubicTo(76.14214f, 29.279669f, 77.27532f, 39.981148f, 75.0f, 49.0f);
                j.cubicTo(73.59745f, 53.7028f, 70.824135f, 57.7901f, 67.0f, 60.0f);
                j.cubicTo(62.72287f, 62.39083f, 56.818386f, 63.6593f, 53.0f, 60.0f);
                j.cubicTo(51.738945f, 58.967968f, 51.95763f, 57.145798f, 52.0f, 56.0f);
                j.cubicTo(49.00539f, 59.008236f, 45.397095f, 61.968006f, 41.0f, 62.0f);
                j.cubicTo(36.540375f, 62.78345f, 31.83866f, 59.894154f, 31.0f, 55.0f);
                j.cubicTo(28.956001f, 48.92086f, 31.033503f, 41.934193f, 34.0f, 36.0f);
                j.cubicTo(37.434994f, 30.095116f, 44.71122f, 25.464184f, 52.0f, 28.0f);
                j.cubicTo(54.571903f, 28.957516f, 55.605682f, 31.997824f, 57.0f, 34.0f);
                j.cubicTo(57.49432f, 32.722664f, 57.86211f, 30.95083f, 58.0f, 29.0f);
                j.cubicTo(58.846188f, 29.108524f, 60.168236f, 28.967585f, 61.0f, 29.0f);
                j.cubicTo(58.4287f, 36.155594f, 56.589764f, 43.595287f, 54.0f, 51.0f);
                j.cubicTo(53.826385f, 53.45112f, 53.03117f, 56.712906f, 55.0f, 59.0f);
                j.cubicTo(58.28954f, 61.33377f, 62.613525f, 59.98476f, 66.0f, 58.0f);
                j.cubicTo(69.820175f, 55.756516f, 72.08654f, 51.24639f, 73.0f, 47.0f);
                j.cubicTo(74.61135f, 39.961014f, 74.02488f, 32.44078f, 70.0f, 27.0f);
                j.cubicTo(61.052914f, 12.155288f, 38.81668f, 10.000898f, 27.0f, 22.0f);
                j.cubicTo(18.031717f, 29.390408f, 13.956235f, 42.38722f, 17.0f, 54.0f);
                j.cubicTo(19.015799f, 58.615612f, 21.351746f, 63.528427f, 25.0f, 67.0f);
                j.cubicTo(32.176624f, 74.36078f, 43.041267f, 77.33062f, 53.0f, 75.0f);
                j.cubicTo(59.30344f, 73.78695f, 65.20792f, 70.14261f, 70.0f, 65.0f);
                j.cubicTo(70.62533f, 63.6291f, 71.95731f, 64.44455f, 73.0f, 66.0f);
                j.cubicTo(66.997154f, 72.00504f, 59.3432f, 76.927925f, 51.0f, 78.0f);
                j.cubicTo(38.468773f, 79.42461f, 24.910337f, 73.92789f, 19.0f, 63.0f);
                j.cubicTo(10.666028f, 49.353752f, 13.011916f, 30.105183f, 25.0f, 20.0f);
                j.lineTo(25.0f, 20.0f);
                j.close();
                j.moveTo(43.0f, 30.0f);
                j.cubicTo(37.254753f, 32.748024f, 34.166744f, 38.905125f, 33.0f, 45.0f);
                j.cubicTo(31.795235f, 49.12286f, 31.16956f, 54.547215f, 35.0f, 58.0f);
                j.cubicTo(37.708874f, 60.82644f, 42.684f, 60.572014f, 46.0f, 58.0f);
                j.cubicTo(50.77741f, 53.987476f, 53.34066f, 47.677723f, 55.0f, 42.0f);
                j.cubicTo(55.015854f, 38.386097f, 55.51034f, 34.7529f, 53.0f, 32.0f);
                j.cubicTo(51.16089f, 28.656858f, 46.32704f, 28.28031f, 43.0f, 30.0f);
                j.lineTo(43.0f, 30.0f);
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
