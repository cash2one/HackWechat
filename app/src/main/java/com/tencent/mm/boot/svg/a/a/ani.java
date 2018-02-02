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

public final class ani extends c {
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
                i2.setColor(-12799249);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(48.11264f, 11.0f);
                j.cubicTo(29.075232f, 11.190086f, 20.986343f, 26.826294f, 20.986343f, 40.877155f);
                j.cubicTo(9.261343f, 52.839657f, 12.905231f, 69.57371f, 16.54523f, 69.57371f);
                j.cubicTo(18.859121f, 69.951294f, 22.617083f, 63.59698f, 22.617083f, 63.59698f);
                j.cubicTo(22.617083f, 63.59698f, 22.73375f, 67.556465f, 25.812454f, 71.13836f);
                j.cubicTo(22.417454f, 72.655174f, 20.195602f, 75.13793f, 20.195602f, 77.949135f);
                j.cubicTo(20.195602f, 82.57069f, 26.175417f, 86.31681f, 33.553936f, 86.31681f);
                j.cubicTo(39.042454f, 86.31681f, 43.753193f, 84.242676f, 45.80912f, 81.27888f);
                j.lineTo(50.492638f, 81.27888f);
                j.cubicTo(52.547268f, 84.242676f, 57.25801f, 86.31681f, 62.74653f, 86.31681f);
                j.cubicTo(70.12375f, 86.31681f, 76.106155f, 82.57198f, 76.106155f, 77.949135f);
                j.cubicTo(76.106155f, 75.13793f, 73.88431f, 72.65646f, 70.4893f, 71.13836f);
                j.cubicTo(73.56801f, 67.556465f, 73.68468f, 63.59698f, 73.68468f, 63.59698f);
                j.cubicTo(73.68468f, 63.59698f, 77.441345f, 69.951294f, 79.75653f, 69.57371f);
                j.cubicTo(83.39653f, 69.57241f, 87.03912f, 52.838364f, 75.31412f, 40.875862f);
                j.cubicTo(75.31412f, 26.826294f, 67.14875f, 11.181034f, 48.11264f, 11.0f);
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
