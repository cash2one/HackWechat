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

public final class aii extends c {
    private final int height = 12;
    private final int width = 64;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 12;
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
                j.moveTo(6.0f, 12.0f);
                j.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                j.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                j.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                j.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                j.close();
                j.moveTo(32.0f, 12.0f);
                j.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                j.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                j.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                j.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                j.close();
                j.moveTo(58.0f, 12.0f);
                j.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                j.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                j.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                j.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(6.0f, 12.0f);
                j.cubicTo(9.313708f, 12.0f, 12.0f, 9.313708f, 12.0f, 6.0f);
                j.cubicTo(12.0f, 2.6862915f, 9.313708f, 0.0f, 6.0f, 0.0f);
                j.cubicTo(2.6862915f, 0.0f, 0.0f, 2.6862915f, 0.0f, 6.0f);
                j.cubicTo(0.0f, 9.313708f, 2.6862915f, 12.0f, 6.0f, 12.0f);
                j.close();
                j.moveTo(32.0f, 12.0f);
                j.cubicTo(35.31371f, 12.0f, 38.0f, 9.313708f, 38.0f, 6.0f);
                j.cubicTo(38.0f, 2.6862915f, 35.31371f, 0.0f, 32.0f, 0.0f);
                j.cubicTo(28.68629f, 0.0f, 26.0f, 2.6862915f, 26.0f, 6.0f);
                j.cubicTo(26.0f, 9.313708f, 28.68629f, 12.0f, 32.0f, 12.0f);
                j.close();
                j.moveTo(58.0f, 12.0f);
                j.cubicTo(61.31371f, 12.0f, 64.0f, 9.313708f, 64.0f, 6.0f);
                j.cubicTo(64.0f, 2.6862915f, 61.31371f, 0.0f, 58.0f, 0.0f);
                j.cubicTo(54.68629f, 0.0f, 52.0f, 2.6862915f, 52.0f, 6.0f);
                j.cubicTo(52.0f, 9.313708f, 54.68629f, 12.0f, 58.0f, 12.0f);
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
                float[] a2 = c.a(e, 64.0f, 0.0f, 0.0f, 0.0f, 12.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-6556649, -9903790}, new float[]{0.0f, 1.0f}, f, 0);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
