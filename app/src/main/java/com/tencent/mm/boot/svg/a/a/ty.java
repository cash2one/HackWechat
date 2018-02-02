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

public final class ty extends c {
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
                a.setColor(-1150121);
                Path j = c.j(looper);
                j.moveTo(23.357143f, 31.267857f);
                j.cubicTo(25.82522f, 35.67271f, 21.368435f, 37.603485f, 19.517857f, 38.94643f);
                j.cubicTo(11.49915f, 43.23181f, 8.0f, 44.938072f, 8.0f, 46.625f);
                j.lineTo(8.0f, 50.464287f);
                j.cubicTo(8.0f, 51.156628f, 8.728162f, 52.0f, 9.535714f, 52.0f);
                j.lineTo(49.464287f, 52.0f);
                j.cubicTo(50.27184f, 52.0f, 51.0f, 51.156628f, 51.0f, 50.464287f);
                j.lineTo(51.0f, 46.625f);
                j.cubicTo(51.0f, 44.938072f, 47.50085f, 43.23181f, 39.482143f, 38.94643f);
                j.cubicTo(37.631565f, 37.603485f, 33.17478f, 35.67271f, 35.642857f, 31.267857f);
                j.cubicTo(38.24307f, 27.868282f, 40.103214f, 26.426222f, 40.25f, 20.517857f);
                j.cubicTo(40.103214f, 14.887795f, 35.947693f, 9.0f, 29.5f, 9.0f);
                j.cubicTo(23.052307f, 9.0f, 18.896786f, 14.887795f, 18.75f, 20.517857f);
                j.cubicTo(18.896786f, 26.426222f, 20.756931f, 27.868282f, 23.357143f, 31.267857f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1150121);
                j = c.j(looper);
                j.moveTo(43.0f, 35.0f);
                j.lineTo(43.0f, 24.87092f);
                j.lineTo(43.0f, 20.50185f);
                j.cubicTo(43.0f, 13.046129f, 36.955845f, 7.0f, 29.5f, 7.0f);
                j.cubicTo(24.75873f, 7.0f, 29.5f, 7.0f, 29.5f, 7.0f);
                j.cubicTo(22.040064f, 7.0f, 16.0f, 13.045625f, 16.0f, 20.50328f);
                j.cubicTo(16.0f, 20.50328f, 16.0f, 26.211f, 16.0f, 24.426191f);
                j.lineTo(16.0f, 35.0f);
                j.lineTo(43.0f, 35.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(22.200684f, 38.115723f);
                j.cubicTo(22.200684f, 38.115723f, 21.690918f, 42.961914f, 23.961914f, 45.899902f);
                j.cubicTo(26.230072f, 48.83422f, 29.463587f, 44.642944f, 29.58355f, 43.118626f);
                j.cubicTo(26.589844f, 42.558025f, 22.200684f, 38.115723f, 22.200684f, 38.115723f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, -1.0f, 0.0f, 66.79199f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                j = c.j(looper);
                j.moveTo(29.706408f, 38.115723f);
                j.cubicTo(29.706408f, 38.115723f, 29.196642f, 42.961914f, 31.467638f, 45.899902f);
                j.cubicTo(33.738636f, 48.83789f, 37.022217f, 44.632446f, 37.13452f, 43.112915f);
                j.cubicTo(34.14038f, 42.558025f, 29.706408f, 38.115723f, 29.706408f, 38.115723f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
