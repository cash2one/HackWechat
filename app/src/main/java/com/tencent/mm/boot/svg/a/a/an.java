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

public final class an extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                i3 = c.a(i2, looper);
                i3.setColor(-9342607);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(22.7f, 0.0f);
                j.lineTo(25.07f, 0.0f);
                j.cubicTo(37.02f, 0.35f, 47.45f, 10.65f, 48.0f, 22.58f);
                j.lineTo(48.0f, 25.35f);
                j.cubicTo(47.49f, 37.13f, 37.36f, 47.34f, 25.6f, 48.0f);
                j.lineTo(22.6f, 48.0f);
                j.cubicTo(10.77f, 47.46f, 0.55f, 37.22f, 0.0f, 25.4f);
                j.lineTo(0.0f, 22.73f);
                j.cubicTo(0.46f, 10.81f, 10.8f, 0.49f, 22.7f, 0.0f);
                j.lineTo(22.7f, 0.0f);
                j.close();
                j.moveTo(22.0f, 12.0f);
                j.cubicTo(22.171429f, 17.652987f, 22.37143f, 23.305975f, 22.571428f, 28.958961f);
                j.cubicTo(23.514286f, 28.97948f, 24.457144f, 28.98974f, 25.409523f, 29.0f);
                j.cubicTo(25.52381f, 23.326494f, 25.77143f, 17.663246f, 26.0f, 12.0f);
                j.cubicTo(24.666666f, 12.01026f, 23.333334f, 12.01026f, 22.0f, 12.0f);
                j.lineTo(22.0f, 12.0f);
                j.close();
                j.moveTo(23.251102f, 31.157341f);
                j.cubicTo(22.210506f, 31.45582f, 21.597021f, 33.081738f, 22.303694f, 33.977173f);
                j.cubicTo(22.948242f, 35.658073f, 25.883654f, 35.14752f, 25.953545f, 33.31738f);
                j.cubicTo(26.302998f, 31.817135f, 24.610088f, 30.544678f, 23.251102f, 31.157341f);
                j.lineTo(23.251102f, 31.157341f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.cubicTo(1.3333334f, 0.010259505f, 2.6666667f, 0.010259505f, 4.0f, 0.0f);
                j.cubicTo(3.7714286f, 5.6632466f, 3.5238094f, 11.326493f, 3.4095237f, 17.0f);
                j.cubicTo(2.4571428f, 16.98974f, 1.5142857f, 16.97948f, 0.5714286f, 16.958961f);
                j.cubicTo(0.37142858f, 11.305975f, 0.17142858f, 5.6529875f, 0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
