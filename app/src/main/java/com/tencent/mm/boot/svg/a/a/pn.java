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

public final class pn extends c {
    private final int height = 72;
    private final int width = 72;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                i3.setColor(-2565928);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(35.5f, 14.333468f);
                j.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                j.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                j.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                j.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                j.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                j.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(35.5f, 14.333468f);
                j.cubicTo(34.08226f, 12.584894f, 29.636719f, 8.0f, 22.0f, 8.0f);
                j.cubicTo(12.603008f, 8.0f, 4.999999f, 15.031532f, 5.0f, 24.0f);
                j.cubicTo(5.000001f, 34.14707f, 12.338594f, 50.355007f, 36.0f, 63.0f);
                j.cubicTo(58.78113f, 50.364376f, 66.0f, 34.127697f, 66.0f, 24.0f);
                j.cubicTo(66.0f, 15.026322f, 58.39699f, 8.0f, 49.0f, 8.0f);
                j.cubicTo(41.36328f, 8.0f, 36.91774f, 12.584894f, 35.5f, 14.333468f);
                j.close();
                Paint i4 = c.i(looper);
                i4.setFlags(385);
                i4.setStyle(Style.FILL);
                Paint i5 = c.i(looper);
                i5.setFlags(385);
                i5.setStyle(Style.STROKE);
                i4.setColor(WebView.NIGHT_MODE_COLOR);
                i5.setStrokeWidth(1.0f);
                i5.setStrokeCap(Cap.BUTT);
                i5.setStrokeJoin(Join.MITER);
                i5.setStrokeMiter(4.0f);
                i5.setPathEffect(null);
                float[] a2 = c.a(e, 66.0f, 0.0f, 4.999999f, 0.0f, 63.0f, 8.0f);
                f.reset();
                f.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-33702, -44260}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
