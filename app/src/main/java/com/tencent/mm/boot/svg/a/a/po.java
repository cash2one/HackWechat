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

public final class po extends c {
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
                j.moveTo(36.0f, 66.0f);
                j.cubicTo(52.568542f, 66.0f, 66.0f, 52.568542f, 66.0f, 36.0f);
                j.cubicTo(66.0f, 19.431458f, 52.568542f, 6.0f, 36.0f, 6.0f);
                j.cubicTo(19.431458f, 6.0f, 6.0f, 19.431458f, 6.0f, 36.0f);
                j.cubicTo(6.0f, 52.568542f, 19.431458f, 66.0f, 36.0f, 66.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(36.0f, 66.0f);
                j.cubicTo(52.568542f, 66.0f, 66.0f, 52.568542f, 66.0f, 36.0f);
                j.cubicTo(66.0f, 19.431458f, 52.568542f, 6.0f, 36.0f, 6.0f);
                j.cubicTo(19.431458f, 6.0f, 6.0f, 19.431458f, 6.0f, 36.0f);
                j.cubicTo(6.0f, 52.568542f, 19.431458f, 66.0f, 36.0f, 66.0f);
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
                float[] a3 = c.a(e, 66.0f, 0.0f, 6.0f, 0.0f, 66.0f, 6.0f);
                f.reset();
                f.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9619, -15075}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-4819456);
                j = c.j(looper);
                j.moveTo(18.0f, 42.09661f);
                j.cubicTo(30.07f, 41.94661f, 42.14f, 41.996613f, 54.21f, 42.07661f);
                j.cubicTo(52.74f, 46.70661f, 50.15f, 51.266613f, 45.72f, 53.62661f);
                j.cubicTo(38.47f, 57.52661f, 28.39f, 56.726612f, 22.61f, 50.55661f);
                j.cubicTo(20.32f, 48.21661f, 19.13f, 45.10661f, 18.0f, 42.09661f);
                j.lineTo(18.0f, 42.09661f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-8301568);
                j = c.j(looper);
                j.moveTo(24.0f, 25.0f);
                j.cubicTo(26.209139f, 25.0f, 28.0f, 27.014719f, 28.0f, 29.5f);
                j.cubicTo(28.0f, 31.985281f, 26.209139f, 34.0f, 24.0f, 34.0f);
                j.cubicTo(21.790861f, 34.0f, 20.0f, 31.985281f, 20.0f, 29.5f);
                j.cubicTo(20.0f, 27.014719f, 21.790861f, 25.0f, 24.0f, 25.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-8301568);
                j = c.j(looper);
                j.moveTo(48.0f, 25.0f);
                j.cubicTo(50.20914f, 25.0f, 52.0f, 27.014719f, 52.0f, 29.5f);
                j.cubicTo(52.0f, 31.985281f, 50.20914f, 34.0f, 48.0f, 34.0f);
                j.cubicTo(45.79086f, 34.0f, 44.0f, 31.985281f, 44.0f, 29.5f);
                j.cubicTo(44.0f, 27.014719f, 45.79086f, 25.0f, 48.0f, 25.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
