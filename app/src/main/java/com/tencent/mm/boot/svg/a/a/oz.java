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

public final class oz extends c {
    private final int height = 480;
    private final int width = 480;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-2565928);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(480.0f, 0.0f);
                j.lineTo(480.0f, 480.0f);
                j.lineTo(0.0f, 480.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(377.6f, 272.91428f);
                j2.lineTo(377.6f, 137.6f);
                j2.lineTo(102.4f, 137.6f);
                j2.lineTo(102.4f, 269.6258f);
                j2.lineTo(188.8f, 188.8f);
                j2.lineTo(288.0f, 278.4f);
                j2.lineTo(278.4f, 252.8f);
                j2.lineTo(320.0f, 220.8f);
                j2.lineTo(377.6f, 272.91428f);
                j2.close();
                j2.moveTo(86.4f, 124.594025f);
                j2.cubicTo(86.4f, 122.940475f, 87.736046f, 121.6f, 89.391014f, 121.6f);
                j2.lineTo(390.60898f, 121.6f);
                j2.cubicTo(392.26086f, 121.6f, 393.6f, 122.946335f, 393.6f, 124.594025f);
                j2.lineTo(393.6f, 355.40598f);
                j2.cubicTo(393.6f, 357.05954f, 392.26395f, 358.4f, 390.60898f, 358.4f);
                j2.lineTo(89.391014f, 358.4f);
                j2.cubicTo(87.73912f, 358.4f, 86.4f, 357.05365f, 86.4f, 355.40598f);
                j2.lineTo(86.4f, 124.594025f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
