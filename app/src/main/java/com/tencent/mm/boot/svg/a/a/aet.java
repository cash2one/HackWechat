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

public final class aet extends c {
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
                j.moveTo(33.94f, 0.0f);
                j.lineTo(37.86f, 0.0f);
                j.cubicTo(45.96f, 0.56f, 53.93f, 3.66f, 59.96f, 9.15f);
                j.cubicTo(67.07f, 15.44f, 71.42f, 24.59f, 72.0f, 34.05f);
                j.lineTo(72.0f, 37.83f);
                j.cubicTo(71.46f, 47.59f, 66.85f, 57.03f, 59.39f, 63.35f);
                j.cubicTo(53.54f, 68.46f, 45.97f, 71.35f, 38.26f, 72.0f);
                j.lineTo(34.11f, 72.0f);
                j.cubicTo(25.1f, 71.45f, 16.32f, 67.55f, 10.09f, 60.97f);
                j.cubicTo(4.16f, 54.9f, 0.65f, 46.69f, 0.0f, 38.25f);
                j.lineTo(0.0f, 34.13f);
                j.cubicTo(0.55f, 24.37f, 5.18f, 14.93f, 12.65f, 8.61f);
                j.cubicTo(18.55f, 3.47f, 26.18f, 0.61f, 33.94f, 0.0f);
                j.lineTo(33.94f, 0.0f);
                j.close();
                j.moveTo(29.4f, 3.66f);
                j.cubicTo(23.12f, 4.97f, 17.2f, 8.12f, 12.68f, 12.67f);
                j.cubicTo(2.03f, 22.96f, -0.12f, 40.65f, 7.83f, 53.16f);
                j.cubicTo(16.0f, 67.24f, 35.31f, 73.15f, 49.93f, 65.9f);
                j.cubicTo(64.75f, 59.37f, 72.74f, 41.04f, 67.36f, 25.73f);
                j.cubicTo(62.61f, 10.2f, 45.28f, 0.06f, 29.4f, 3.66f);
                j.lineTo(29.4f, 3.66f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                i2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(24.0f, 24.0f);
                j2.lineTo(48.0f, 24.0f);
                j2.lineTo(48.0f, 48.0f);
                j2.lineTo(24.0f, 48.0f);
                j2.lineTo(24.0f, 24.0f);
                j2.lineTo(24.0f, 24.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
