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

public final class bp extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1710619);
                Path j = c.j(looper);
                j.moveTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.lineTo(68.0f, 87.0f);
                j.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                j.lineTo(3.0f, 90.0f);
                j.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                j.lineTo(0.0f, 3.0f);
                j.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                j.lineTo(46.0f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-2434342);
                j = c.j(looper);
                j.moveTo(68.0f, 22.0f);
                j.lineTo(49.0f, 22.0f);
                j.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                j.lineTo(46.0f, 0.0f);
                j.lineTo(68.0f, 22.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-5723992);
                j = c.j(looper);
                j.moveTo(26.177734f, 50.26172f);
                j.cubicTo(26.371094f, 46.464844f, 28.902344f, 43.441406f, 33.841797f, 43.441406f);
                j.cubicTo(38.271484f, 43.441406f, 41.29492f, 46.183594f, 41.29492f, 49.804688f);
                j.cubicTo(41.29492f, 52.564453f, 39.871094f, 54.515625f, 37.621094f, 55.86914f);
                j.cubicTo(35.38867f, 57.1875f, 34.75586f, 58.171875f, 34.75586f, 60.01758f);
                j.lineTo(34.75586f, 61.160156f);
                j.lineTo(31.679688f, 61.160156f);
                j.lineTo(31.679688f, 59.54297f);
                j.cubicTo(31.66211f, 57.222656f, 32.78711f, 55.640625f, 35.195312f, 54.19922f);
                j.cubicTo(37.234375f, 52.95117f, 38.02539f, 51.84375f, 38.02539f, 49.96289f);
                j.cubicTo(38.02539f, 47.783203f, 36.33789f, 46.183594f, 33.71875f, 46.183594f);
                j.cubicTo(31.064453f, 46.183594f, 29.376953f, 47.748047f, 29.183594f, 50.26172f);
                j.lineTo(26.177734f, 50.26172f);
                j.close();
                j.moveTo(33.226562f, 69.17578f);
                j.cubicTo(32.101562f, 69.17578f, 31.222656f, 68.296875f, 31.222656f, 67.171875f);
                j.cubicTo(31.222656f, 66.0293f, 32.101562f, 65.16797f, 33.226562f, 65.16797f);
                j.cubicTo(34.36914f, 65.16797f, 35.23047f, 66.0293f, 35.23047f, 67.171875f);
                j.cubicTo(35.23047f, 68.296875f, 34.36914f, 69.17578f, 33.226562f, 69.17578f);
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
