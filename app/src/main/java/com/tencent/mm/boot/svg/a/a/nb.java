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

public final class nb extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-9473160);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 17.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(77.0f, 49.0f);
                j.lineTo(46.0f, 49.0f);
                j.lineTo(35.0f, 49.0f);
                j.lineTo(3.0f, 49.0f);
                j.lineTo(3.0f, 3.0f);
                j.lineTo(77.0f, 3.0f);
                j.lineTo(77.0f, 49.0f);
                j.close();
                j.moveTo(48.513f, 60.0f);
                j.lineTo(32.487f, 60.0f);
                j.lineTo(38.0f, 58.162f);
                j.lineTo(38.0f, 52.0f);
                j.lineTo(43.0f, 52.0f);
                j.lineTo(43.0f, 58.162f);
                j.lineTo(48.513f, 60.0f);
                j.close();
                j.moveTo(77.129f, 0.0f);
                j.lineTo(2.871f, 0.0f);
                j.cubicTo(1.289f, 0.0f, 0.0f, 1.285f, 0.0f, 2.87f);
                j.lineTo(0.0f, 49.13f);
                j.cubicTo(0.0f, 50.715f, 1.285f, 52.0f, 2.871f, 52.0f);
                j.lineTo(35.0f, 52.0f);
                j.lineTo(35.0f, 56.0f);
                j.lineTo(23.0f, 60.0f);
                j.lineTo(23.0f, 63.0f);
                j.lineTo(58.0f, 63.0f);
                j.lineTo(58.0f, 60.0f);
                j.lineTo(46.0f, 56.0f);
                j.lineTo(46.0f, 52.0f);
                j.lineTo(77.129f, 52.0f);
                j.cubicTo(78.711f, 52.0f, 80.0f, 50.715f, 80.0f, 49.13f);
                j.lineTo(80.0f, 2.87f);
                j.cubicTo(80.0f, 1.285f, 78.715f, 0.0f, 77.129f, 0.0f);
                j.lineTo(77.129f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
