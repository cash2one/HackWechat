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

public final class yw extends c {
    private final int height = 108;
    private final int width = 108;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                e = c.a(e, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 25.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15683841);
                Path j = c.j(looper);
                j.moveTo(58.94128f, 18.34375f);
                j.lineTo(2.708721f, 11.0f);
                j.cubicTo(1.116907f, 11.0f, -0.175f, 12.316f, -0.175f, 13.938969f);
                j.lineTo(-0.175f, 47.71875f);
                j.cubicTo(-0.175f, 49.34172f, 1.116907f, 50.65625f, 2.708721f, 50.65625f);
                j.lineTo(58.94128f, 58.0f);
                j.cubicTo(60.533092f, 58.0f, 61.825f, 56.68547f, 61.825f, 55.0625f);
                j.lineTo(61.825f, 21.28125f);
                j.cubicTo(61.825f, 19.65975f, 60.533092f, 18.34375f, 58.94128f, 18.34375f);
                j.lineTo(58.94128f, 18.34375f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-11742937);
                j = c.j(looper);
                j.moveTo(60.825f, 2.7197444f);
                j.cubicTo(60.697964f, 1.1690818f, 58.744793f, -0.117698714f, 57.168396f, 0.008567508f);
                j.lineTo(4.3879986f, 7.349033f);
                j.cubicTo(4.1931143f, 7.364639f, 4.0054483f, 7.400107f, 3.825f, 7.4497623f);
                j.lineTo(60.825f, 14.0f);
                j.lineTo(60.825f, 2.7197444f);
                j.lineTo(60.825f, 2.7197444f);
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
