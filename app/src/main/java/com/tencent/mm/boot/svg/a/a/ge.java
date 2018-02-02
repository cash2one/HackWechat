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

public final class ge extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                i2.setColor(-16139513);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(26.0f, 23.171574f);
                j.lineTo(33.899494f, 31.071068f);
                j.cubicTo(34.680542f, 31.852116f, 34.680542f, 33.118446f, 33.899494f, 33.899494f);
                j.cubicTo(33.118446f, 34.680542f, 31.852116f, 34.680542f, 31.071068f, 33.899494f);
                j.lineTo(22.585787f, 25.414213f);
                j.cubicTo(22.390524f, 25.218952f, 22.244078f, 24.993359f, 22.146446f, 24.752602f);
                j.cubicTo(22.055964f, 24.539213f, 22.0f, 24.276142f, 22.0f, 24.0f);
                j.lineTo(22.0f, 16.0f);
                j.cubicTo(22.0f, 14.895431f, 22.89543f, 14.0f, 24.0f, 14.0f);
                j.cubicTo(25.10457f, 14.0f, 26.0f, 14.895431f, 26.0f, 16.0f);
                j.lineTo(26.0f, 23.171574f);
                j.close();
                j.moveTo(24.727272f, 48.0f);
                j.cubicTo(10.745166f, 48.0f, 0.0f, 37.254833f, 0.0f, 24.727272f);
                j.cubicTo(0.0f, 10.745166f, 10.745166f, 0.0f, 24.727272f, 0.0f);
                j.cubicTo(37.254833f, 0.0f, 48.0f, 10.745166f, 48.0f, 24.727272f);
                j.cubicTo(48.0f, 37.254833f, 37.254833f, 48.0f, 24.727272f, 48.0f);
                j.close();
                j.moveTo(24.0f, 44.0f);
                j.cubicTo(35.045696f, 44.0f, 44.0f, 35.045696f, 44.0f, 24.0f);
                j.cubicTo(44.0f, 12.954305f, 35.045696f, 4.0f, 24.0f, 4.0f);
                j.cubicTo(12.954305f, 4.0f, 4.0f, 12.954305f, 4.0f, 24.0f);
                j.cubicTo(4.0f, 35.045696f, 12.954305f, 44.0f, 24.0f, 44.0f);
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
