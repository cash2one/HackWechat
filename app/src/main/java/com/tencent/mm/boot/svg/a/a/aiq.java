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

public final class aiq extends c {
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
                j.moveTo(45.0f, 12.0f);
                j.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                j.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                j.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                j.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(45.0f, 12.0f);
                j.cubicTo(63.225395f, 12.0f, 78.0f, 26.774603f, 78.0f, 45.0f);
                j.cubicTo(78.0f, 63.225395f, 63.225395f, 78.0f, 45.0f, 78.0f);
                j.cubicTo(26.774603f, 78.0f, 12.0f, 63.225395f, 12.0f, 45.0f);
                j.cubicTo(12.0f, 26.774603f, 26.774603f, 12.0f, 45.0f, 12.0f);
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
                float[] a3 = c.a(e, 66.0f, 0.0f, 12.0f, 0.0f, 66.0f, 12.0f);
                f.reset();
                f.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-10560163, -5768183}, new float[]{0.0f, 1.0f}, f, 0);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(38.250305f, 53.508274f);
                j2.lineTo(29.74203f, 45.0f);
                j2.lineTo(25.49939f, 49.24264f);
                j2.lineTo(38.22731f, 61.970562f);
                j2.lineTo(38.283035f, 61.914837f);
                j2.lineTo(38.30603f, 61.93783f);
                j2.lineTo(64.62193f, 35.62193f);
                j2.lineTo(60.37929f, 31.37929f);
                j2.lineTo(38.250305f, 53.508274f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
