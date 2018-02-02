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

public final class up extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(-12889439);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(108.0f, 0.0f);
                j.lineTo(108.0f, 108.0f);
                j.lineTo(0.0f, 108.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 20.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(33.02322f, 0.0123782605f);
                j2.lineTo(22.661959f, 0.0123782605f);
                j2.cubicTo(9.465719f, -0.11790832f, 7.7802663f, 7.9406996f, 7.7802663f, 16.662235f);
                j2.lineTo(7.7802663f, 23.004126f);
                j2.lineTo(1.9549693f, 23.004126f);
                j2.cubicTo(0.8093274f, 22.87384f, -0.12272003f, 23.789677f, 0.01320356f, 24.920105f);
                j2.lineTo(0.01320356f, 36.415977f);
                j2.cubicTo(-0.12272003f, 37.546406f, 0.80932754f, 38.462246f, 1.9549693f, 38.33196f);
                j2.lineTo(7.7802663f, 38.33196f);
                j2.lineTo(7.7802663f, 67.07164f);
                j2.cubicTo(7.659877f, 68.20207f, 8.58804f, 69.117905f, 9.733683f, 68.987625f);
                j2.lineTo(21.597872f, 68.987625f);
                j2.cubicTo(22.743513f, 69.117905f, 23.671677f, 68.20207f, 23.306625f, 67.07164f);
                j2.lineTo(23.314392f, 38.33196f);
                j2.lineTo(33.02322f, 38.33196f);
                j2.cubicTo(34.16886f, 38.462246f, 35.10091f, 37.546406f, 34.964985f, 36.415977f);
                j2.lineTo(34.964985f, 24.920105f);
                j2.cubicTo(35.10091f, 23.789677f, 34.16886f, 22.87384f, 33.02322f, 23.004126f);
                j2.lineTo(23.30274f, 23.004126f);
                j2.lineTo(23.314392f, 17.25619f);
                j2.cubicTo(23.691093f, 14.807568f, 23.691093f, 15.206092f, 25.994028f, 15.34021f);
                j2.lineTo(32.941666f, 15.34021f);
                j2.cubicTo(33.481476f, 15.221419f, 34.05624f, 15.286563f, 34.460125f, 14.899535f);
                j2.cubicTo(34.864014f, 14.512507f, 35.097027f, 13.983697f, 34.9611f, 13.424232f);
                j2.lineTo(34.9611f, 1.9283571f);
                j2.cubicTo(35.10091f, 0.7979297f, 34.16886f, -0.11790832f, 33.02322f, 0.0123782605f);
                j2.close();
                j2.moveTo(30.94553f, 11.293663f);
                j2.lineTo(26.075583f, 11.109729f);
                j2.cubicTo(20.044458f, 11.109729f, 19.539598f, 14.340069f, 19.539598f, 17.647049f);
                j2.lineTo(19.524065f, 24.912441f);
                j2.cubicTo(19.524065f, 25.45658f, 19.741543f, 25.977726f, 20.129896f, 26.364754f);
                j2.cubicTo(20.51825f, 26.74795f, 21.04641f, 26.962538f, 21.59787f, 26.962538f);
                j2.lineTo(31.081455f, 26.962538f);
                j2.lineTo(31.081455f, 34.365883f);
                j2.lineTo(21.605639f, 34.365883f);
                j2.cubicTo(20.459995f, 34.365883f, 19.531832f, 35.28172f, 19.527948f, 36.412148f);
                j2.lineTo(19.524065f, 65.15566f);
                j2.lineTo(11.663797f, 65.15566f);
                j2.lineTo(11.663797f, 36.415977f);
                j2.cubicTo(11.663797f, 35.285553f, 10.883207f, 34.369713f, 9.733683f, 34.369713f);
                j2.lineTo(3.8967347f, 34.369713f);
                j2.lineTo(3.8967347f, 26.966372f);
                j2.lineTo(9.733683f, 26.966372f);
                j2.cubicTo(10.285144f, 26.966372f, 10.813304f, 26.751781f, 11.201657f, 26.368586f);
                j2.cubicTo(11.590011f, 25.981558f, 11.659914f, 25.460411f, 11.659914f, 24.916273f);
                j2.lineTo(11.659914f, 16.658403f);
                j2.cubicTo(11.659914f, 8.067154f, 13.419154f, 3.9746227f, 22.658075f, 3.9746227f);
                j2.lineTo(30.941647f, 3.9746227f);
                j2.lineTo(30.941647f, 11.293663f);
                j2.lineTo(30.94553f, 11.293663f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
