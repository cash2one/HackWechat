package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aic extends c {
    private final int height = 54;
    private final int width = 54;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.f(looper);
                c.e(looper);
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
                i2 = c.a(i2, looper);
                i2.setColor(-8683387);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(35.48387f, 28.66256f);
                j.lineTo(35.48387f, 37.66291f);
                j.cubicTo(35.48387f, 38.4582f, 34.83916f, 39.10291f, 34.043873f, 39.10291f);
                j.lineTo(6.44f, 39.10291f);
                j.cubicTo(5.64471f, 39.10291f, 5.0f, 38.4582f, 5.0f, 37.66291f);
                j.lineTo(5.0f, 16.157227f);
                j.cubicTo(5.0f, 15.361936f, 5.64471f, 14.717226f, 6.44f, 14.717226f);
                j.lineTo(34.043873f, 14.717226f);
                j.cubicTo(34.83916f, 14.717226f, 35.48387f, 15.361936f, 35.48387f, 16.157227f);
                j.lineTo(35.48387f, 25.287582f);
                j.cubicTo(38.18783f, 22.945694f, 46.986294f, 14.808152f, 47.822582f, 14.082182f);
                j.cubicTo(48.88459f, 13.782787f, 50.0f, 14.307455f, 50.0f, 15.557618f);
                j.lineTo(50.0f, 38.42688f);
                j.cubicTo(50.0f, 39.543766f, 48.99135f, 40.27374f, 47.822582f, 39.902317f);
                j.cubicTo(47.261726f, 39.311028f, 38.312565f, 31.01308f, 35.48387f, 28.66256f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
