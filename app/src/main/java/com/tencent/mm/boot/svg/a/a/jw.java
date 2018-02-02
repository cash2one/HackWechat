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

public final class jw extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-6118750);
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(21.46737f, 1.3491559f);
                j.cubicTo(22.534445f, 0.6687394f, 23.934368f, 1.0489721f, 24.76649f, 1.919505f);
                j.cubicTo(31.795479f, 8.773701f, 35.819035f, 18.91991f, 34.859646f, 28.876005f);
                j.cubicTo(34.252686f, 36.590725f, 30.610928f, 43.825153f, 25.569244f, 49.498627f);
                j.cubicTo(22.994558f, 51.439816f, 19.705227f, 47.26726f, 22.152647f, 45.105938f);
                j.cubicTo(25.481136f, 40.99342f, 28.173298f, 36.2205f, 29.025f, 30.887236f);
                j.cubicTo(30.689245f, 22.111864f, 27.429283f, 12.856199f, 21.369473f, 6.5523405f);
                j.cubicTo(19.695438f, 5.2515445f, 19.362589f, 2.409805f, 21.46737f, 1.3491559f);
                j.lineTo(21.46737f, 1.3491559f);
                j.lineTo(21.46737f, 1.3491559f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(11.145517f, 9.512209f);
                j.cubicTo(12.139298f, 8.841187f, 13.13308f, 8.831172f, 14.12686f, 9.472148f);
                j.cubicTo(23.139763f, 17.654613f, 23.316874f, 33.448673f, 14.490918f, 41.851475f);
                j.cubicTo(12.719824f, 42.49245f, 10.663386f, 40.97013f, 11.224233f, 38.98711f);
                j.cubicTo(12.493517f, 36.503326f, 14.372846f, 34.299973f, 15.0517645f, 31.525745f);
                j.cubicTo(16.891735f, 25.586697f, 15.199356f, 18.94658f, 11.234072f, 14.309518f);
                j.cubicTo(9.905751f, 13.03758f, 9.335065f, 10.623903f, 11.145517f, 9.512209f);
                j.lineTo(11.145517f, 9.512209f);
                j.lineTo(11.145517f, 9.512209f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0777197f, 16.738579f);
                j.cubicTo(2.1650724f, 15.761997f, 4.146697f, 15.722935f, 5.1730766f, 16.806938f);
                j.cubicTo(9.786705f, 21.73867f, 10.426922f, 29.83452f, 6.0063753f, 35.068993f);
                j.cubicTo(4.268643f, 37.139343f, 0.3358808f, 35.46939f, 0.6813948f, 32.871685f);
                j.cubicTo(1.3012875f, 30.48883f, 3.912967f, 28.809113f, 3.4455068f, 26.133282f);
                j.cubicTo(3.6284258f, 22.725016f, -2.3875825f, 19.961294f, 1.0777197f, 16.738579f);
                j.lineTo(1.0777197f, 16.738579f);
                j.lineTo(1.0777197f, 16.738579f);
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
