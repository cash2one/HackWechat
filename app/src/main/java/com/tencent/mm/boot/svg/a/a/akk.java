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

public final class akk extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(1.2f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Paint a4 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(20.06508f, 39.519398f);
                j.cubicTo(9.131414f, 39.519398f, 0.36045057f, 30.628284f, 0.36045057f, 19.814768f);
                j.cubicTo(0.36045057f, 8.881102f, 9.251564f, 0.11013767f, 20.06508f, 0.11013767f);
                j.cubicTo(30.998749f, 0.11013767f, 39.76971f, 9.001251f, 39.76971f, 19.814768f);
                j.cubicTo(39.76971f, 30.628284f, 30.998749f, 39.519398f, 20.06508f, 39.519398f);
                j.close();
                j.moveTo(20.06508f, 1.1914893f);
                j.cubicTo(9.852315f, 1.1914893f, 1.5619525f, 9.481853f, 1.5619525f, 19.694618f);
                j.cubicTo(1.5619525f, 29.907385f, 9.852315f, 38.197746f, 20.06508f, 38.197746f);
                j.cubicTo(30.277847f, 38.197746f, 38.56821f, 29.907385f, 38.56821f, 19.694618f);
                j.cubicTo(38.56821f, 9.481853f, 30.277847f, 1.1914893f, 20.06508f, 1.1914893f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a = c.a(a2, looper);
                j = c.j(looper);
                j.moveTo(25.83229f, 27.26408f);
                j.cubicTo(25.712141f, 27.26408f, 25.47184f, 27.14393f, 25.35169f, 27.023779f);
                j.lineTo(19.58448f, 20.055069f);
                j.cubicTo(19.46433f, 19.93492f, 19.46433f, 19.814768f, 19.46433f, 19.694618f);
                j.lineTo(19.46433f, 8.1602f);
                j.cubicTo(19.46433f, 7.79975f, 19.70463f, 7.559449f, 20.06508f, 7.559449f);
                j.cubicTo(20.425531f, 7.559449f, 20.665833f, 7.79975f, 20.665833f, 8.1602f);
                j.lineTo(20.665833f, 19.454317f);
                j.lineTo(26.312891f, 26.182728f);
                j.cubicTo(26.553192f, 26.423029f, 26.43304f, 26.78348f, 26.192741f, 27.023779f);
                j.cubicTo(26.07259f, 27.26408f, 25.95244f, 27.26408f, 25.83229f, 27.26408f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
