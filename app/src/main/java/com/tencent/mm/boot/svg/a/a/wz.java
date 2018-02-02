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

public final class wz extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(31.0f, 26.001389f);
                j.cubicTo(31.0f, 24.896053f, 31.895857f, 24.0f, 32.99739f, 24.0f);
                j.lineTo(38.00261f, 24.0f);
                j.cubicTo(39.105736f, 24.0f, 40.0f, 24.894938f, 40.0f, 26.001389f);
                j.lineTo(40.0f, 69.99861f);
                j.cubicTo(40.0f, 71.10395f, 39.10414f, 72.0f, 38.00261f, 72.0f);
                j.lineTo(32.99739f, 72.0f);
                j.cubicTo(31.894262f, 72.0f, 31.0f, 71.105064f, 31.0f, 69.99861f);
                j.lineTo(31.0f, 26.001389f);
                j.close();
                j.moveTo(56.0f, 26.001389f);
                j.cubicTo(56.0f, 24.896053f, 56.89586f, 24.0f, 57.99739f, 24.0f);
                j.lineTo(63.00261f, 24.0f);
                j.cubicTo(64.105736f, 24.0f, 65.0f, 24.894938f, 65.0f, 26.001389f);
                j.lineTo(65.0f, 69.99861f);
                j.cubicTo(65.0f, 71.10395f, 64.10414f, 72.0f, 63.00261f, 72.0f);
                j.lineTo(57.99739f, 72.0f);
                j.cubicTo(56.894264f, 72.0f, 56.0f, 71.105064f, 56.0f, 69.99861f);
                j.lineTo(56.0f, 26.001389f);
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
