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

public final class afq extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(6.0f, 0.0f);
                j.lineTo(6.0f, 13.0f);
                j.lineTo(19.0f, 13.0f);
                j.lineTo(19.0f, 0.0f);
                j.lineTo(25.0f, 0.0f);
                j.lineTo(25.0f, 32.0f);
                j.lineTo(19.0f, 32.0f);
                j.lineTo(19.0f, 18.0f);
                j.cubicTo(14.64f, 17.98f, 10.29f, 18.1f, 5.94f, 18.07f);
                j.cubicTo(5.95f, 22.71f, 6.03f, 27.36f, 6.0f, 32.0f);
                j.lineTo(0.0f, 32.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(31.0f, 0.0f);
                j2.lineTo(37.0f, 0.0f);
                j2.lineTo(37.0f, 5.0f);
                j2.lineTo(31.0f, 5.0f);
                j2.lineTo(31.0f, 0.0f);
                j2.lineTo(31.0f, 0.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(31.0f, 9.0f);
                j2.lineTo(37.0f, 9.0f);
                j2.lineTo(37.0f, 32.0f);
                j2.lineTo(31.0f, 32.0f);
                j2.lineTo(31.0f, 9.0f);
                j2.lineTo(31.0f, 9.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
