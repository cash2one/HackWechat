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

public final class ut extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                i3 = c.a(i2, looper);
                i3.setColor(-15028967);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(55.078445f, 25.00014f);
                j2.cubicTo(39.16226f, 25.00014f, 26.207817f, 37.891388f, 26.207817f, 53.74081f);
                j2.cubicTo(26.207817f, 58.80523f, 27.541147f, 63.757267f, 30.065735f, 68.10752f);
                j2.cubicTo(30.065735f, 68.10752f, 27.28029f, 76.87909f, 26.0f, 81.53247f);
                j2.cubicTo(26.0f, 81.997284f, 26.0f, 83.03247f, 28.0f, 82.50686f);
                j2.cubicTo(29.5f, 82.03247f, 41.27883f, 79.004906f, 41.27883f, 79.004906f);
                j2.cubicTo(45.511826f, 81.29943f, 50.25455f, 82.50332f, 55.074802f, 82.50686f);
                j2.cubicTo(71.001915f, 82.50686f, 83.967285f, 69.61561f, 83.967285f, 53.766186f);
                j2.cubicTo(83.986824f, 46.13662f, 80.941284f, 38.81573f, 75.508286f, 33.43238f);
                j2.cubicTo(70.10815f, 28.012098f, 62.748436f, 24.97629f, 55.078445f, 25.00014f);
                j2.close();
                j2.moveTo(42.859886f, 74.32476f);
                j2.lineTo(41.981926f, 73.80273f);
                j2.lineTo(32.89633f, 76.16999f);
                j2.lineTo(35.322556f, 67.3571f);
                j2.lineTo(34.75425f, 66.4508f);
                j2.cubicTo(32.341713f, 62.647125f, 31.066797f, 58.238754f, 31.078484f, 53.74081f);
                j2.cubicTo(31.094553f, 40.54703f, 41.841843f, 29.857033f, 55.100304f, 29.847046f);
                j2.cubicTo(61.508305f, 29.847046f, 67.54472f, 32.34119f, 72.07295f, 36.84733f);
                j2.cubicTo(76.586525f, 41.32263f, 79.11532f, 47.407555f, 79.09662f, 53.748062f);
                j2.cubicTo(79.08569f, 66.93295f, 68.31704f, 77.6527f, 55.08573f, 77.6527f);
                j2.cubicTo(50.78394f, 77.657074f, 46.56114f, 76.506355f, 42.859886f, 74.32476f);
                j2.close();
                j2.moveTo(63.318867f, 57.424023f);
                j2.cubicTo(62.65949f, 57.18476f, 62.178616f, 57.061504f, 61.690456f, 57.786545f);
                j2.cubicTo(61.213226f, 58.500713f, 59.82525f, 60.12118f, 59.402664f, 60.60696f);
                j2.cubicTo(58.980076f, 61.081863f, 58.561134f, 61.15074f, 57.843468f, 60.78822f);
                j2.cubicTo(57.1258f, 60.425697f, 54.79065f, 59.66803f, 52.036556f, 57.221012f);
                j2.cubicTo(49.89448f, 55.317776f, 48.440933f, 52.96139f, 48.018345f, 52.247223f);
                j2.cubicTo(47.59576f, 51.53306f, 47.97099f, 51.13791f, 48.33893f, 50.786263f);
                j2.cubicTo(48.67044f, 50.467243f, 49.056595f, 49.94884f, 49.420895f, 49.528316f);
                j2.cubicTo(49.78519f, 49.10779f, 49.898125f, 48.814148f, 50.13856f, 48.32837f);
                j2.cubicTo(50.378998f, 47.85347f, 50.262424f, 47.432945f, 50.080273f, 47.070423f);
                j2.cubicTo(49.898125f, 46.7079f, 48.451862f, 43.17332f, 47.8617f, 41.73411f);
                j2.cubicTo(47.282463f, 40.32753f, 46.67773f, 40.523293f, 46.233284f, 40.497917f);
                j2.cubicTo(45.8107f, 40.476166f, 45.33347f, 40.476166f, 44.85624f, 40.476166f);
                j2.cubicTo(44.37901f, 40.476166f, 43.592125f, 40.657425f, 42.932743f, 41.37159f);
                j2.cubicTo(42.273365f, 42.08576f, 40.404514f, 43.829483f, 40.404514f, 47.364063f);
                j2.cubicTo(40.404514f, 50.898643f, 42.98739f, 54.309967f, 43.35169f, 54.795746f);
                j2.cubicTo(43.715984f, 55.27065f, 48.440933f, 62.531948f, 55.679535f, 65.63875f);
                j2.cubicTo(57.399025f, 66.37467f, 58.743282f, 66.81695f, 59.78882f, 67.157715f);
                j2.cubicTo(61.519234f, 67.7015f, 63.08936f, 67.62174f, 64.33162f, 67.44048f);
                j2.cubicTo(65.71959f, 67.23747f, 68.60119f, 65.707634f, 69.205925f, 64.02916f);
                j2.cubicTo(69.81066f, 62.350685f, 69.81066f, 60.915104f, 69.62851f, 60.617836f);
                j2.cubicTo(69.45729f, 60.298817f, 68.980064f, 60.12118f, 68.251465f, 59.755035f);
                j2.cubicTo(67.53015f, 59.396137f, 63.97825f, 57.66329f, 63.318867f, 57.424023f);
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
