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

public final class sc extends c {
    private final int height = 46;
    private final int width = 66;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 46;
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
                i2.setColor(-9537135);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(66.0f, 0.0f);
                j.lineTo(66.0f, 46.0f);
                j.lineTo(12.0f, 46.0f);
                j.cubicTo(12.01f, 41.1f, 11.99f, 36.19f, 12.01f, 31.29f);
                j.cubicTo(8.14f, 28.86f, 0.15407985f, 23.0f, 0.15407985f, 23.0f);
                j.cubicTo(3.3064237f, 20.753471f, 8.0f, 17.27f, 12.0f, 14.71f);
                j.cubicTo(11.99f, 9.81f, 12.01f, 4.9f, 12.0f, 0.0f);
                j.lineTo(66.0f, 0.0f);
                j.close();
                j.moveTo(25.162472f, 17.326578f);
                j.cubicTo(21.008757f, 18.444845f, 19.530993f, 24.33572f, 22.736143f, 27.251204f);
                j.cubicTo(25.651731f, 30.486193f, 31.642666f, 28.988512f, 32.69108f, 24.765055f);
                j.cubicTo(34.268692f, 20.401814f, 29.5059f, 15.709083f, 25.162472f, 17.326578f);
                j.lineTo(25.162472f, 17.326578f);
                j.close();
                j.moveTo(49.15318f, 17.331114f);
                j.cubicTo(45.00983f, 18.449194f, 43.542187f, 24.3291f, 46.71709f, 27.234114f);
                j.cubicTo(49.622425f, 30.478544f, 55.602825f, 29.011063f, 56.681095f, 24.798294f);
                j.cubicTo(58.288513f, 20.435783f, 53.516174f, 15.693925f, 49.15318f, 17.331114f);
                j.lineTo(49.15318f, 17.331114f);
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
