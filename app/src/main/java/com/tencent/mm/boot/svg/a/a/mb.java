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

public final class mb extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 80.0f);
                j.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                j.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                j.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                j.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-11711155);
                j = c.j(looper);
                j.moveTo(63.284435f, 77.0f);
                j.lineTo(89.0f, 104.0f);
                j.lineTo(58.0f, 104.0f);
                j.cubicTo(60.590897f, 100.16911f, 63.478912f, 93.10176f, 62.938694f, 80.91711f);
                j.cubicTo(63.001358f, 79.552414f, 63.116966f, 78.244446f, 63.284435f, 77.0f);
                j.moveTo(60.032513f, 81.31762f);
                j.cubicTo(60.91131f, 99.65149f, 53.0f, 104.66564f, 53.0f, 104.66564f);
                j.lineTo(53.0f, 107.0f);
                j.lineTo(97.0f, 107.0f);
                j.lineTo(61.79871f, 71.0f);
                j.cubicTo(60.848923f, 73.81619f, 60.213223f, 77.21763f, 60.032513f, 81.31762f);
                j.close();
                j.moveTo(84.02051f, 58.95267f);
                j.lineTo(84.02051f, 57.067513f);
                j.cubicTo(84.02051f, 54.063652f, 81.875374f, 52.031452f, 78.88457f, 52.031452f);
                j.cubicTo(75.90136f, 52.031452f, 74.00952f, 54.103878f, 74.00952f, 57.096867f);
                j.lineTo(74.00952f, 58.95267f);
                j.cubicTo(71.48619f, 59.716953f, 68.18386f, 61.1031f, 65.88232f, 63.578594f);
                j.lineTo(53.30372f, 51.0f);
                j.lineTo(51.0f, 53.30372f);
                j.lineTo(108.69628f, 111.0f);
                j.lineTo(111.0f, 108.69628f);
                j.lineTo(100.0663f, 97.76258f);
                j.cubicTo(98.537735f, 94.18687f, 97.3201f, 88.87494f, 97.69735f, 81.20276f);
                j.cubicTo(97.02982f, 66.39329f, 90.03693f, 60.812824f, 84.02051f, 58.95267f);
                j.close();
                j.moveTo(68.19256f, 66.0466f);
                j.lineTo(68.270584f, 65.963394f);
                j.cubicTo(69.93996f, 64.19877f, 71.999466f, 62.94311f, 74.38978f, 62.230995f);
                j.lineTo(76.99048f, 61.549137f);
                j.lineTo(76.99048f, 59.14372f);
                j.lineTo(76.99048f, 57.299133f);
                j.cubicTo(76.99048f, 56.115875f, 77.7955f, 54.989075f, 78.99451f, 54.989075f);
                j.cubicTo(80.19461f, 54.989075f, 81.000916f, 56.115875f, 81.000916f, 57.299133f);
                j.lineTo(81.000916f, 59.15777f);
                j.lineTo(81.000916f, 61.549137f);
                j.lineTo(83.40482f, 62.25477f);
                j.cubicTo(86.330345f, 63.144104f, 88.738235f, 64.84173f, 90.56147f, 67.300095f);
                j.cubicTo(93.02761f, 70.62295f, 94.42553f, 75.32356f, 94.71676f, 81.27227f);
                j.cubicTo(94.51565f, 85.521194f, 94.77281f, 89.40163f, 95.48276f, 92.88008f);
                j.lineTo(68.19256f, 66.0466f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
