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

public final class ta extends c {
    private final int height = 16;
    private final int width = 20;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 16;
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
                e = c.a(e, 1.0f, 0.0f, -320.0f, 0.0f, 1.0f, -110.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 108.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 320.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.0f, 16.0f);
                j.lineTo(0.0f, 16.0f);
                j.lineTo(0.0f, 9.25f);
                j.lineTo(0.0f, 9.25f);
                j.cubicTo(-1.6908844E-17f, 9.111929f, 0.11192881f, 9.0f, 0.25f, 9.0f);
                j.lineTo(1.75f, 9.0f);
                j.lineTo(1.75f, 9.0f);
                j.cubicTo(1.8880712f, 9.0f, 2.0f, 9.111929f, 2.0f, 9.25f);
                j.lineTo(2.0f, 14.0f);
                j.lineTo(18.0f, 14.0f);
                j.lineTo(18.0f, 9.25f);
                j.lineTo(18.0f, 9.25f);
                j.cubicTo(18.0f, 9.111929f, 18.111929f, 9.0f, 18.25f, 9.0f);
                j.lineTo(19.75f, 9.0f);
                j.lineTo(19.75f, 9.0f);
                j.cubicTo(19.888071f, 9.0f, 20.0f, 9.111929f, 20.0f, 9.25f);
                j.lineTo(20.0f, 16.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(14.0f, 0.0f);
                j.lineTo(19.0f, 4.0f);
                j.lineTo(14.0f, 8.0f);
                j.lineTo(14.0f, 0.0f);
                j.close();
                j.moveTo(5.0f, 11.0f);
                j.cubicTo(4.9955163f, 7.91632f, 7.619254f, 2.002248f, 14.0f, 2.0f);
                j.cubicTo(13.975887f, 2.0f, 13.975887f, 3.3333333f, 14.0f, 6.0f);
                j.cubicTo(10.277842f, 6.0545654f, 7.277841f, 7.7212324f, 5.0f, 11.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
