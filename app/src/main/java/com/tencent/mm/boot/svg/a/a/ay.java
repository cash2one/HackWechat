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

public final class ay extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i2.setColor(-2049700);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(86.25f, 32.25337f);
                j.lineTo(86.25f, 28.75f);
                j.cubicTo(86.25f, 26.678932f, 84.57107f, 25.0f, 82.5f, 25.0f);
                j.lineTo(7.5f, 25.0f);
                j.cubicTo(5.428932f, 25.0f, 3.75f, 26.678932f, 3.75f, 28.75f);
                j.lineTo(3.75f, 32.25337f);
                j.cubicTo(4.8531504f, 31.615229f, 6.133923f, 31.25f, 7.5f, 31.25f);
                j.lineTo(82.5f, 31.25f);
                j.cubicTo(83.86607f, 31.25f, 85.14685f, 31.615229f, 86.25f, 32.25337f);
                j.close();
                j.moveTo(3.75f, 10.0f);
                j.lineTo(29.6967f, 10.0f);
                j.cubicTo(30.691261f, 10.0f, 31.645088f, 10.395088f, 32.34835f, 11.09835f);
                j.lineTo(37.65165f, 16.40165f);
                j.cubicTo(38.35491f, 17.104912f, 39.30874f, 17.5f, 40.303303f, 17.5f);
                j.lineTo(86.25f, 17.5f);
                j.cubicTo(88.32107f, 17.5f, 90.0f, 19.178932f, 90.0f, 21.25f);
                j.lineTo(90.0f, 76.25f);
                j.cubicTo(90.0f, 78.32107f, 88.32107f, 80.0f, 86.25f, 80.0f);
                j.lineTo(3.75f, 80.0f);
                j.cubicTo(1.6789322f, 80.0f, 2.5363266E-16f, 78.32107f, 0.0f, 76.25f);
                j.lineTo(-8.881784E-16f, 13.75f);
                j.cubicTo(-1.1418111E-15f, 11.678932f, 1.6789322f, 10.0f, 3.75f, 10.0f);
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
