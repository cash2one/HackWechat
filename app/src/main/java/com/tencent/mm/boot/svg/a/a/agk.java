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

public final class agk extends c {
    private final int height = 270;
    private final int width = 270;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                i2 = c.a(i2, looper);
                i2.setColor(-1202386);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(130.84f, 0.0f);
                j.lineTo(137.49f, 0.0f);
                j.cubicTo(169.21f, 0.52f, 200.58f, 12.66f, 224.28f, 33.78f);
                j.cubicTo(252.31f, 58.19f, 269.23f, 94.64f, 270.0f, 131.79f);
                j.lineTo(270.0f, 137.24f);
                j.cubicTo(269.55f, 165.21f, 260.21f, 192.96f, 243.45f, 215.38f);
                j.cubicTo(219.22f, 248.49f, 179.23f, 269.26f, 138.21f, 270.0f);
                j.lineTo(131.99f, 270.0f);
                j.cubicTo(100.68f, 269.36f, 69.79f, 257.4f, 46.26f, 236.73f);
                j.cubicTo(17.95f, 212.27f, 0.75f, 175.62f, 0.0f, 138.21f);
                j.lineTo(0.0f, 132.68f);
                j.cubicTo(0.48f, 94.98f, 17.71f, 57.93f, 46.25f, 33.31f);
                j.cubicTo(69.47f, 12.83f, 99.93f, 0.99f, 130.84f, 0.0f);
                j.lineTo(130.84f, 0.0f);
                j.close();
                j.moveTo(71.0f, 135.0f);
                j.cubicTo(85.65116f, 149.34f, 100.32233f, 163.67f, 114.98349f, 178.0f);
                j.cubicTo(115.003494f, 166.66f, 114.98349f, 155.33f, 114.99349f, 144.0f);
                j.cubicTo(142.32567f, 143.99f, 169.66783f, 144.0f, 197.0f, 144.0f);
                j.lineTo(197.0f, 127.0f);
                j.lineTo(114.99349f, 127.0f);
                j.cubicTo(114.98349f, 115.33f, 115.003494f, 103.67f, 114.98349f, 92.0f);
                j.cubicTo(100.33233f, 106.34f, 85.65116f, 120.66f, 71.0f, 135.0f);
                j.lineTo(71.0f, 135.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
