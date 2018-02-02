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

public final class ame extends c {
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
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-15028967);
                j = c.j(looper);
                j.moveTo(46.279175f, 21.000214f);
                j.lineTo(46.279175f, 44.5821f);
                j.lineTo(33.04137f, 33.706234f);
                j.lineTo(31.0f, 36.192547f);
                j.lineTo(45.37214f, 47.999035f);
                j.lineTo(31.0f, 59.806595f);
                j.lineTo(33.04137f, 62.292908f);
                j.lineTo(46.279175f, 51.41704f);
                j.lineTo(46.279175f, 75.0f);
                j.lineTo(64.73941f, 59.746555f);
                j.lineTo(50.43911f, 47.999035f);
                j.lineTo(64.73941f, 36.251514f);
                j.lineTo(46.279175f, 21.000214f);
                j.close();
                j.moveTo(49.495617f, 27.828722f);
                j.lineTo(59.68102f, 36.244007f);
                j.lineTo(49.495617f, 44.61212f);
                j.lineTo(49.495617f, 27.828722f);
                j.close();
                j.moveTo(49.495617f, 51.38595f);
                j.lineTo(59.68102f, 59.75299f);
                j.lineTo(49.495617f, 68.16935f);
                j.lineTo(49.495617f, 51.38595f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
