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

public final class uh extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                i2.setColor(-1);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.5f, 0.0f);
                j.lineTo(1.32f, 0.0f);
                j.cubicTo(5.04f, 3.33f, 8.42f, 7.02f, 12.0f, 10.5f);
                j.cubicTo(15.57f, 7.02f, 18.96f, 3.36f, 22.63f, 0.0f);
                j.lineTo(23.38f, 0.0f);
                j.lineTo(23.52f, 0.52f);
                j.lineTo(24.0f, 0.5f);
                j.lineTo(24.0f, 1.32f);
                j.cubicTo(20.67f, 5.04f, 16.98f, 8.42f, 13.5f, 12.0f);
                j.cubicTo(16.99f, 15.56f, 20.63f, 18.96f, 24.0f, 22.63f);
                j.lineTo(24.0f, 23.38f);
                j.lineTo(23.48f, 23.52f);
                j.lineTo(23.5f, 24.0f);
                j.lineTo(22.67f, 24.0f);
                j.cubicTo(18.96f, 20.66f, 15.58f, 16.98f, 12.0f, 13.51f);
                j.cubicTo(8.43f, 16.98f, 5.04f, 20.65f, 1.35f, 24.0f);
                j.lineTo(0.55f, 24.0f);
                j.lineTo(0.56f, 23.47f);
                j.lineTo(0.0f, 23.48f);
                j.lineTo(0.0f, 22.69f);
                j.cubicTo(3.32f, 18.96f, 7.02f, 15.59f, 10.48f, 12.0f);
                j.cubicTo(7.02f, 8.43f, 3.36f, 5.04f, 0.0f, 1.37f);
                j.lineTo(0.0f, 0.62f);
                j.lineTo(0.52f, 0.48f);
                j.lineTo(0.5f, 0.0f);
                j.lineTo(0.5f, 0.0f);
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
