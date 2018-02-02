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

public final class xk extends c {
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
                i3 = c.a(i2, looper);
                i3.setColor(-2565928);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(96.0f, 0.0f);
                j.lineTo(96.0f, 96.0f);
                j.lineTo(0.0f, 96.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(j, c.a(i3, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-8617851);
                Path j2 = c.j(looper);
                j2.moveTo(58.234665f, 65.333336f);
                j2.cubicTo(58.234665f, 65.333336f, 56.0f, 64.88355f, 56.0f, 62.666668f);
                j2.lineTo(56.0f, 61.333332f);
                j2.cubicTo(56.0f, 59.977333f, 57.333332f, 58.666668f, 57.333332f, 58.666668f);
                j2.cubicTo(62.017944f, 54.044582f, 65.138985f, 47.470398f, 65.13022f, 37.007732f);
                j2.cubicTo(65.12012f, 24.950094f, 58.55467f, 16.0f, 48.0f, 16.0f);
                j2.cubicTo(37.44533f, 16.0f, 30.897902f, 24.952658f, 30.908f, 37.007732f);
                j2.cubicTo(30.908f, 47.468624f, 34.000893f, 54.025047f, 38.753777f, 58.666668f);
                j2.cubicTo(38.666668f, 58.666668f, 40.0f, 59.977333f, 40.0f, 61.333332f);
                j2.lineTo(40.0f, 62.666668f);
                j2.cubicTo(40.0f, 64.88355f, 37.765335f, 65.333336f, 37.765335f, 65.333336f);
                j2.lineTo(17.333334f, 72.44444f);
                j2.cubicTo(14.228f, 73.564445f, 12.0f, 76.51822f, 12.0f, 80.0f);
                j2.lineTo(12.0f, 84.0f);
                j2.lineTo(84.0f, 84.0f);
                j2.lineTo(84.0f, 80.0f);
                j2.cubicTo(84.0f, 76.51822f, 81.77155f, 73.564445f, 78.666664f, 72.46489f);
                j2.lineTo(58.234665f, 65.333336f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
