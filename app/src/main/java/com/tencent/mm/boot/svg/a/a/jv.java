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

public final class jv extends c {
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
                e = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 13.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(11.145517f, 1.5122092f);
                j.cubicTo(12.139298f, 0.841187f, 13.13308f, 0.8311717f, 14.12686f, 1.4721482f);
                j.cubicTo(23.139763f, 9.6546135f, 23.316874f, 25.448673f, 14.490918f, 33.851475f);
                j.cubicTo(12.719824f, 34.49245f, 10.663386f, 32.97013f, 11.224233f, 30.987112f);
                j.cubicTo(12.493517f, 28.503328f, 14.372846f, 26.29997f, 15.0517645f, 23.525745f);
                j.cubicTo(16.891735f, 17.586697f, 15.199356f, 10.946582f, 11.234072f, 6.3095174f);
                j.cubicTo(9.905751f, 5.03758f, 9.335065f, 2.6239028f, 11.145517f, 1.5122092f);
                j.lineTo(11.145517f, 1.5122092f);
                j.lineTo(11.145517f, 1.5122092f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(1.0777197f, 8.738578f);
                j.cubicTo(2.1650724f, 7.7619977f, 4.146697f, 7.7229342f, 5.1730766f, 8.806938f);
                j.cubicTo(9.786705f, 13.738669f, 10.426922f, 21.83452f, 6.0063753f, 27.068993f);
                j.cubicTo(4.268643f, 29.139343f, 0.3358808f, 27.46939f, 0.6813948f, 24.871687f);
                j.cubicTo(1.3012875f, 22.48883f, 3.912967f, 20.809113f, 3.4455068f, 18.133282f);
                j.cubicTo(3.6284258f, 14.725016f, -2.3875825f, 11.961293f, 1.0777197f, 8.738578f);
                j.lineTo(1.0777197f, 8.738578f);
                j.lineTo(1.0777197f, 8.738578f);
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
