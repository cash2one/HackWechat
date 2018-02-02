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
import com.tencent.wcdb.FileUtils;

public final class adg extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-8355712);
                e = c.a(e, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 18.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(45.0f, -3.5527137E-15f);
                j.cubicTo(52.34293f, 6.1744103f, 59.681465f, 12.328806f, 67.0f, 19.0f);
                j.cubicTo(59.711456f, 24.717655f, 52.33293f, 30.822016f, 45.0f, 37.0f);
                j.cubicTo(44.9944f, 33.33381f, 45.0044f, 29.661186f, 45.0f, 26.0f);
                j.cubicTo(38.535694f, 26.158686f, 31.607079f, 26.338814f, 26.0f, 30.0f);
                j.cubicTo(21.489101f, 32.573265f, 19.119576f, 37.43674f, 17.0f, 42.0f);
                j.cubicTo(17.179964f, 31.93281f, 20.129374f, 20.864904f, 29.0f, 15.0f);
                j.cubicTo(33.266747f, 11.037884f, 39.36553f, 10.717655f, 45.0f, 11.0f);
                j.cubicTo(45.0044f, 7.345247f, 44.9944f, 3.6726234f, 45.0f, -3.5527137E-15f);
                j.lineTo(45.0f, -3.5527137E-15f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 15.0f);
                j.cubicTo(-0.25343853f, 13.1134405f, 0.9255405f, 10.966071f, 3.0f, 11.0f);
                j.cubicTo(8.92861f, 10.906144f, 14.963385f, 11.085924f, 21.0f, 11.0f);
                j.cubicTo(19.199717f, 13.133416f, 17.68103f, 15.480542f, 16.0f, 18.0f);
                j.cubicTo(13.334795f, 18.007448f, 10.177528f, 18.017435f, 7.0f, 18.0f);
                j.cubicTo(7.0302544f, 29.32359f, 7.0302544f, 40.639732f, 7.0f, 52.0f);
                j.cubicTo(22.34699f, 51.96586f, 37.663727f, 51.96586f, 53.0f, 52.0f);
                j.cubicTo(52.990456f, 48.02069f, 52.990456f, 44.065536f, 53.0f, 40.0f);
                j.cubicTo(55.30845f, 38.142788f, 57.636433f, 36.175198f, 60.0f, 34.0f);
                j.cubicTo(59.93444f, 41.508667f, 60.084312f, 48.799736f, 60.0f, 56.0f);
                j.cubicTo(59.984398f, 58.028435f, 57.91619f, 59.276905f, 56.0f, 59.0f);
                j.cubicTo(38.7328f, 58.967285f, 21.327873f, 58.9573f, 4.0f, 59.0f);
                j.cubicTo(2.144485f, 59.25693f, -0.0036548423f, 58.078373f, 0.0f, 56.0f);
                j.cubicTo(-0.033628885f, 42.34764f, 0.0662846f, 28.614458f, 0.0f, 15.0f);
                j.lineTo(0.0f, 15.0f);
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
