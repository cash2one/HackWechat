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
import com.tencent.wcdb.FileUtils;

public final class aer extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-9276814);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(33.9f, 0.0f);
                j.lineTo(38.04f, 0.0f);
                j.cubicTo(46.52f, 0.64f, 54.84f, 4.06f, 60.93f, 10.05f);
                j.cubicTo(67.46f, 16.26f, 71.4f, 24.96f, 72.0f, 33.92f);
                j.lineTo(72.0f, 38.04f);
                j.cubicTo(71.41f, 47.03f, 67.47f, 55.74f, 60.93f, 61.95f);
                j.cubicTo(54.9f, 67.87f, 46.7f, 71.29f, 38.32f, 72.0f);
                j.lineTo(33.95f, 72.0f);
                j.cubicTo(25.01f, 71.39f, 16.3f, 67.52f, 10.12f, 61.0f);
                j.cubicTo(4.16f, 54.92f, 0.64f, 46.69f, 0.0f, 38.23f);
                j.lineTo(0.0f, 33.93f);
                j.cubicTo(0.66f, 23.3f, 6.2f, 13.1f, 14.85f, 6.87f);
                j.cubicTo(20.36f, 2.78f, 27.09f, 0.58f, 33.9f, 0.0f);
                j.lineTo(33.9f, 0.0f);
                j.close();
                j.moveTo(29.45f, 3.65f);
                j.cubicTo(21.99f, 5.18f, 15.07f, 9.34f, 10.31f, 15.3f);
                j.cubicTo(1.3f, 26.14f, 0.57f, 42.84f, 8.63f, 54.42f);
                j.cubicTo(17.32f, 67.89f, 36.42f, 73.03f, 50.65f, 65.55f);
                j.cubicTo(65.31f, 58.67f, 72.85f, 40.15f, 67.11f, 24.99f);
                j.cubicTo(62.07f, 9.86f, 45.05f, 0.15f, 29.45f, 3.65f);
                j.lineTo(29.45f, 3.65f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(26.01f, 19.02f);
                j.cubicTo(35.34f, 24.67f, 44.66f, 30.33f, 53.98f, 36.0f);
                j.cubicTo(44.68f, 41.69f, 35.33f, 47.31f, 26.03f, 53.0f);
                j.cubicTo(25.97f, 41.67f, 26.01f, 30.34f, 26.01f, 19.02f);
                j.lineTo(26.01f, 19.02f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
