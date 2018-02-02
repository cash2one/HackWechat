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

public final class hi extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                j.moveTo(11.0f, 67.75325f);
                j.lineTo(11.0f, 67.75325f);
                j.lineTo(11.0f, 63.701298f);
                j.cubicTo(11.007332f, 66.43168f, 12.668421f, 69.08772f, 15.0f, 70.792206f);
                j.lineTo(15.0f, 70.792206f);
                j.lineTo(43.0f, 87.0f);
                j.cubicTo(43.626083f, 86.7779f, 43.811207f, 86.89193f, 44.0f, 87.0f);
                j.lineTo(44.0f, 53.57143f);
                j.lineTo(11.0f, 34.324677f);
                j.lineTo(11.0f, 67.75325f);
                j.close();
                j.moveTo(52.0f, 53.57143f);
                j.lineTo(52.0f, 87.0f);
                j.cubicTo(52.188793f, 86.89292f, 52.373917f, 86.77946f, 53.0f, 87.0f);
                j.lineTo(81.0f, 70.792206f);
                j.lineTo(81.0f, 70.792206f);
                j.cubicTo(83.33158f, 69.17696f, 84.99267f, 66.53409f, 85.0f, 63.701298f);
                j.lineTo(85.0f, 68.766235f);
                j.lineTo(85.0f, 68.766235f);
                j.lineTo(85.0f, 34.324677f);
                j.lineTo(52.0f, 53.57143f);
                j.close();
                j.moveTo(53.0f, 10.012987f);
                j.cubicTo(51.805397f, 9.510585f, 50.266872f, 9.0f, 49.0f, 9.0f);
                j.cubicTo(46.95472f, 9.0f, 45.416195f, 9.510585f, 44.0f, 10.012987f);
                j.lineTo(16.0f, 27.233767f);
                j.lineTo(48.0f, 46.48052f);
                j.lineTo(81.0f, 27.233767f);
                j.lineTo(53.0f, 10.012987f);
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
