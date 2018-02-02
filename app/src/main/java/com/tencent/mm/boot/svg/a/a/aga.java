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

public final class aga extends c {
    private final int height = 36;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                i2.setColor(-9205837);
                canvas.save();
                i3 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(9.0f, 12.0f);
                j.lineTo(36.0f, 12.0f);
                j.lineTo(36.0f, 17.0f);
                j.lineTo(9.0f, 17.0f);
                j.lineTo(9.0f, 12.0f);
                j.lineTo(9.0f, 12.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 3.0074198f);
                j2.cubicTo(0.0f, 1.3464677f, 1.3517805f, 0.0f, 3.0004442f, 0.0f);
                j2.lineTo(42.999557f, 0.0f);
                j2.cubicTo(44.656654f, 0.0f, 46.0f, 1.3455393f, 46.0f, 3.0074198f);
                j2.lineTo(46.0f, 32.99258f);
                j2.cubicTo(46.0f, 34.653534f, 44.64822f, 36.0f, 42.999557f, 36.0f);
                j2.lineTo(3.0004442f, 36.0f);
                j2.cubicTo(1.3433446f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                j2.lineTo(0.0f, 3.0074198f);
                j2.close();
                j2.moveTo(3.0666666f, 3.0f);
                j2.lineTo(43.0f, 3.0f);
                j2.lineTo(43.0f, 33.0f);
                j2.lineTo(3.0666666f, 33.0f);
                j2.lineTo(3.0666666f, 3.0f);
                j2.close();
                j2.moveTo(9.2f, 12.0f);
                j2.lineTo(37.0f, 12.0f);
                j2.lineTo(37.0f, 17.0f);
                j2.lineTo(9.2f, 17.0f);
                j2.lineTo(9.2f, 12.0f);
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
