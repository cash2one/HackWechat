package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.media.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ahw extends c {
    private final int height = 44;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 44;
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
                canvas.saveLayerAlpha(null, e.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-2928046);
                float[] a2 = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(10.666615f, 0.0f);
                j.lineTo(12.372898f, 0.0f);
                j.cubicTo(20.305622f, 0.02008788f, 25.773712f, 9.732577f, 21.51299f, 16.52228f);
                j.cubicTo(17.801077f, 23.834269f, 6.1564374f, 23.824224f, 2.4644783f, 16.502193f);
                j.cubicTo(-1.5567636f, 9.973632f, 3.2028701f, 0.87382275f, 10.666615f, 0.0f);
                j.lineTo(10.666615f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-12537567);
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(6.1586027f, 2.1373188f);
                j.cubicTo(12.047705f, -1.0015799f, 20.032927f, 2.6871262f, 21.580063f, 9.154857f);
                j.cubicTo(23.476555f, 15.432654f, 18.695402f, 22.130304f, 12.34715f, 23.0f);
                j.lineTo(9.9216385f, 23.0f);
                j.cubicTo(4.6414104f, 22.400211f, 0.359335f, 17.991756f, 0.0f, 12.673622f);
                j.lineTo(0.0f, 10.884251f);
                j.cubicTo(0.61885476f, 7.2355304f, 2.7149756f, 3.7367578f, 6.1586027f, 2.1373188f);
                j.lineTo(6.1586027f, 2.1373188f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-2511616);
                e = c.a(a2, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 21.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(1.0697373f, 12.9446945f);
                j.cubicTo(0.27009234f, 6.4077463f, 6.4773364f, 0.22063516f, 13.014434f, 1.0802338f);
                j.cubicTo(18.142157f, 1.4000845f, 22.220346f, 5.75805f, 23.0f, 10.70574f);
                j.lineTo(23.0f, 13.044648f);
                j.cubicTo(22.440248f, 18.152264f, 18.332073f, 22.260345f, 13.284314f, 23.0f);
                j.lineTo(11.015322f, 23.0f);
                j.cubicTo(5.8776026f, 22.440262f, 1.3795997f, 18.192245f, 1.0697373f, 12.9446945f);
                j.lineTo(1.0697373f, 12.9446945f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
