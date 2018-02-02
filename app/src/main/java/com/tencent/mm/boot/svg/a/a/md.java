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

public final class md extends c {
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
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(0.0f, 80.0f);
                j.cubicTo(0.0f, 35.887928f, 35.887665f, 0.0f, 80.0f, 0.0f);
                j.cubicTo(124.112335f, 0.0f, 160.0f, 35.887928f, 160.0f, 80.0f);
                j.cubicTo(160.0f, 124.112076f, 124.112335f, 160.0f, 80.0f, 160.0f);
                j.cubicTo(35.887665f, 160.0f, 0.0f, 124.112076f, 0.0f, 80.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(62.284435f, 76.0f);
                j.lineTo(88.0f, 103.0f);
                j.lineTo(57.0f, 103.0f);
                j.cubicTo(59.590897f, 99.16911f, 62.478912f, 92.10176f, 61.938694f, 79.91711f);
                j.cubicTo(62.001358f, 78.552414f, 62.116966f, 77.244446f, 62.284435f, 76.0f);
                j.moveTo(59.032513f, 80.31762f);
                j.cubicTo(59.91131f, 98.65149f, 52.0f, 103.66564f, 52.0f, 103.66564f);
                j.lineTo(52.0f, 106.0f);
                j.lineTo(96.0f, 106.0f);
                j.lineTo(60.79871f, 70.0f);
                j.cubicTo(59.848923f, 72.81619f, 59.213223f, 76.21763f, 59.032513f, 80.31762f);
                j.close();
                j.moveTo(83.02051f, 57.95267f);
                j.lineTo(83.02051f, 56.067513f);
                j.cubicTo(83.02051f, 53.063652f, 80.875374f, 51.031452f, 77.88457f, 51.031452f);
                j.cubicTo(74.90136f, 51.031452f, 73.00952f, 53.103878f, 73.00952f, 56.096867f);
                j.lineTo(73.00952f, 57.95267f);
                j.cubicTo(70.48619f, 58.716953f, 67.18386f, 60.1031f, 64.88232f, 62.578594f);
                j.lineTo(52.30372f, 50.0f);
                j.lineTo(50.0f, 52.30372f);
                j.lineTo(107.69628f, 110.0f);
                j.lineTo(110.0f, 107.69628f);
                j.lineTo(99.0663f, 96.76258f);
                j.cubicTo(97.537735f, 93.18687f, 96.3201f, 87.87494f, 96.69735f, 80.20276f);
                j.cubicTo(96.02982f, 65.39329f, 89.03693f, 59.812824f, 83.02051f, 57.95267f);
                j.close();
                j.moveTo(67.19256f, 65.0466f);
                j.lineTo(67.270584f, 64.963394f);
                j.cubicTo(68.93996f, 63.198772f, 70.999466f, 61.94311f, 73.38978f, 61.230995f);
                j.lineTo(75.99048f, 60.549137f);
                j.lineTo(75.99048f, 58.14372f);
                j.lineTo(75.99048f, 56.299133f);
                j.cubicTo(75.99048f, 55.115875f, 76.7955f, 53.989075f, 77.99451f, 53.989075f);
                j.cubicTo(79.19461f, 53.989075f, 80.000916f, 55.115875f, 80.000916f, 56.299133f);
                j.lineTo(80.000916f, 58.15777f);
                j.lineTo(80.000916f, 60.549137f);
                j.lineTo(82.40482f, 61.25477f);
                j.cubicTo(85.330345f, 62.144104f, 87.738235f, 63.84173f, 89.56147f, 66.300095f);
                j.cubicTo(92.02761f, 69.62295f, 93.42553f, 74.32356f, 93.71676f, 80.27227f);
                j.cubicTo(93.51565f, 84.521194f, 93.77281f, 88.40163f, 94.48276f, 91.88008f);
                j.lineTo(67.19256f, 65.0466f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
