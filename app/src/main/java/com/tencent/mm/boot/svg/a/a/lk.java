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

public final class lk extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(60.0f, 0.0f);
                j.lineTo(60.0f, 60.0f);
                j.lineTo(0.0f, 60.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                Paint a = c.a(i2, looper);
                a.setColor(-5592406);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 5.877551f);
                j2.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 5.877551f, 0.0f);
                j2.lineTo(42.122448f, 0.0f);
                j2.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 5.877551f);
                j2.lineTo(48.0f, 42.122448f);
                j2.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 42.122448f, 48.0f);
                j2.lineTo(5.877551f, 48.0f);
                j2.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 42.122448f);
                j2.lineTo(0.0f, 5.877551f);
                j2.lineTo(0.0f, 5.877551f);
                j2.close();
                j2.moveTo(4.0f, 5.904762f);
                j2.cubicTo(4.0f, 4.894218f, 4.89154f, 4.0f, 5.904762f, 4.0f);
                j2.lineTo(42.095238f, 4.0f);
                j2.cubicTo(43.10578f, 4.0f, 44.0f, 4.89154f, 44.0f, 5.904762f);
                j2.lineTo(44.0f, 42.095238f);
                j2.cubicTo(44.0f, 43.10578f, 43.10846f, 44.0f, 42.095238f, 44.0f);
                j2.lineTo(5.904762f, 44.0f);
                j2.cubicTo(4.894218f, 44.0f, 4.0f, 43.10846f, 4.0f, 42.095238f);
                j2.lineTo(4.0f, 5.904762f);
                j2.lineTo(4.0f, 5.904762f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j3 = c.j(looper);
                j3.moveTo(10.2f, 22.538462f);
                j3.lineTo(19.0f, 30.923077f);
                j3.lineTo(37.8f, 13.0f);
                j3.lineTo(42.0f, 17.038462f);
                j3.lineTo(19.0f, 39.0f);
                j3.lineTo(6.0f, 26.576923f);
                j3.close();
                WeChatSVGRenderC2Java.setFillType(j3, 1);
                WeChatSVGRenderC2Java.setFillType(j3, 2);
                canvas.drawPath(j3, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
