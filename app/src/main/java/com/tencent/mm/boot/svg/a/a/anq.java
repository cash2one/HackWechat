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

public final class anq extends c {
    private final int height = 36;
    private final int width = 36;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                a.setColor(-5066062);
                e = c.a(e, 1.0f, 0.0f, -353.0f, 0.0f, 1.0f, -131.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 353.0f, 0.0f, 1.0f, 131.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(17.67213f, 35.34426f);
                j.cubicTo(7.912082f, 35.34426f, 0.0f, 27.432177f, 0.0f, 17.67213f);
                j.cubicTo(0.0f, 7.912082f, 7.912082f, 0.0f, 17.67213f, 0.0f);
                j.cubicTo(27.432177f, 0.0f, 35.34426f, 7.912082f, 35.34426f, 17.67213f);
                j.cubicTo(35.34426f, 27.432177f, 27.432177f, 35.34426f, 17.67213f, 35.34426f);
                j.close();
                j.moveTo(7.0619354f, 18.702524f);
                j.cubicTo(7.0080047f, 18.810345f, 7.0291414f, 18.94058f, 7.1144037f, 19.02581f);
                j.lineTo(7.1144037f, 19.02581f);
                j.lineTo(13.854528f, 25.76321f);
                j.cubicTo(13.963866f, 25.872507f, 14.141094f, 25.872507f, 14.250432f, 25.76321f);
                j.lineTo(14.250508f, 25.763287f);
                j.lineTo(28.901352f, 11.118186f);
                j.cubicTo(28.901379f, 11.118161f, 28.901403f, 11.118136f, 28.901428f, 11.118111f);
                j.cubicTo(29.010754f, 11.008743f, 29.01072f, 10.831457f, 28.901352f, 10.722131f);
                j.lineTo(28.901278f, 10.722207f);
                j.lineTo(28.675867f, 10.496883f);
                j.lineTo(28.392729f, 10.213852f);
                j.cubicTo(28.291279f, 10.112441f, 28.129597f, 10.104101f, 28.018251f, 10.194535f);
                j.lineTo(28.018251f, 10.194535f);
                j.lineTo(14.218084f, 21.40289f);
                j.cubicTo(14.120261f, 21.48234f, 13.981415f, 21.48665f, 13.878853f, 21.41342f);
                j.lineTo(8.123317f, 17.303892f);
                j.cubicTo(8.111442f, 17.295412f, 8.098921f, 17.287874f, 8.08587f, 17.281345f);
                j.cubicTo(7.9475665f, 17.212168f, 7.7793694f, 17.268206f, 7.7101912f, 17.40651f);
                j.lineTo(7.7101912f, 17.40651f);
                j.lineTo(7.0619354f, 18.702524f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
