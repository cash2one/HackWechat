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

public final class gw extends c {
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
                j.moveTo(48.0f, 80.0f);
                j.cubicTo(40.60533f, 80.0f, 33.802223f, 77.48534f, 28.383556f, 73.27333f);
                j.lineTo(73.27333f, 28.383556f);
                j.cubicTo(77.48534f, 33.802223f, 80.0f, 40.60533f, 80.0f, 48.0f);
                j.cubicTo(80.0f, 65.67289f, 65.67289f, 80.0f, 48.0f, 80.0f);
                j.moveTo(16.0f, 48.0f);
                j.cubicTo(16.0f, 30.326666f, 30.326666f, 16.0f, 48.0f, 16.0f);
                j.cubicTo(55.39467f, 16.0f, 62.197777f, 18.514668f, 67.61645f, 22.726667f);
                j.lineTo(22.726667f, 67.61645f);
                j.cubicTo(18.514668f, 62.197777f, 16.0f, 55.39467f, 16.0f, 48.0f);
                j.moveTo(70.627556f, 25.372889f);
                j.lineTo(70.62711f, 25.372444f);
                j.lineTo(70.627556f, 25.372889f);
                j.moveTo(48.0f, 8.0f);
                j.cubicTo(25.908443f, 8.0f, 8.0f, 25.908443f, 8.0f, 48.0f);
                j.cubicTo(8.0f, 70.09155f, 25.908443f, 88.0f, 48.0f, 88.0f);
                j.cubicTo(70.09155f, 88.0f, 88.0f, 70.09155f, 88.0f, 48.0f);
                j.cubicTo(88.0f, 25.908443f, 70.09155f, 8.0f, 48.0f, 8.0f);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
