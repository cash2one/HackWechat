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

public final class ahx extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-3750202);
                canvas.save();
                float[] a2 = c.a(e, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(9.666615f, 0.0f);
                j.lineTo(11.372898f, 0.0f);
                j.cubicTo(19.305622f, 0.02008788f, 24.773712f, 9.732577f, 20.51299f, 16.52228f);
                j.cubicTo(16.801077f, 23.834269f, 5.1564374f, 23.824224f, 1.4644784f, 16.502193f);
                j.cubicTo(-2.5567636f, 9.973632f, 2.2028701f, 0.87382275f, 9.666615f, 0.0f);
                j.lineTo(9.666615f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                a3 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(6.1586027f, 1.137319f);
                j.cubicTo(12.047705f, -2.00158f, 20.032927f, 1.687126f, 21.580063f, 8.154857f);
                j.cubicTo(23.476555f, 14.432654f, 18.695402f, 21.130304f, 12.34715f, 22.0f);
                j.lineTo(9.9216385f, 22.0f);
                j.cubicTo(4.6414104f, 21.400211f, 0.359335f, 16.991756f, 0.0f, 11.673622f);
                j.lineTo(0.0f, 9.884251f);
                j.cubicTo(0.61885476f, 6.2355304f, 2.7149756f, 2.7367578f, 6.1586027f, 1.137319f);
                j.lineTo(6.1586027f, 1.137319f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                e = c.a(a2, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 22.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a4 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.069737285f, 11.9446945f);
                j.cubicTo(-0.7299077f, 5.4077463f, 5.4773364f, -0.7793648f, 12.014434f, 0.080233835f);
                j.cubicTo(17.142157f, 0.4000845f, 21.220346f, 4.75805f, 22.0f, 9.70574f);
                j.lineTo(22.0f, 12.044648f);
                j.cubicTo(21.440248f, 17.152264f, 17.332073f, 21.260345f, 12.284314f, 22.0f);
                j.lineTo(10.015322f, 22.0f);
                j.cubicTo(4.8776026f, 21.440262f, 0.3795997f, 17.192245f, 0.069737285f, 11.9446945f);
                j.lineTo(0.069737285f, 11.9446945f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a4);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
