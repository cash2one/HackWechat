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

public final class kt extends c {
    private final int height = 117;
    private final int width = 117;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 117;
            case 1:
                return 117;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -1420.0f, 0.0f, 1.0f, -201.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(1423.0f, 259.5f);
                j.cubicTo(1423.0f, 228.84819f, 1447.8481f, 204.0f, 1478.5f, 204.0f);
                j.lineTo(1478.5f, 204.0f);
                j.cubicTo(1509.1519f, 204.0f, 1534.0f, 228.84819f, 1534.0f, 259.5f);
                j.lineTo(1534.0f, 259.5f);
                j.cubicTo(1534.0f, 290.1518f, 1509.1519f, 315.0f, 1478.5f, 315.0f);
                j.lineTo(1478.5f, 315.0f);
                j.cubicTo(1447.8481f, 315.0f, 1423.0f, 290.1518f, 1423.0f, 259.5f);
                j.lineTo(1423.0f, 259.5f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(1475.762f, 276.99985f);
                j.cubicTo(1480.2301f, 272.53815f, 1483.0f, 266.33554f, 1483.0f, 259.47748f);
                j.cubicTo(1483.0f, 252.50348f, 1480.1356f, 246.20723f, 1475.5338f, 241.7303f);
                j.lineTo(1470.5934f, 246.6707f);
                j.cubicTo(1473.9595f, 249.87605f, 1476.0616f, 254.42805f, 1476.0616f, 259.47748f);
                j.cubicTo(1476.0616f, 264.41092f, 1474.0549f, 268.86954f, 1470.8234f, 272.06125f);
                j.lineTo(1475.762f, 276.99985f);
                j.close();
                j.moveTo(1464.6487f, 265.88657f);
                j.cubicTo(1466.3352f, 264.2836f, 1467.3888f, 262.0052f, 1467.3888f, 259.47748f);
                j.cubicTo(1467.3888f, 256.83368f, 1466.2362f, 254.46259f, 1464.4122f, 252.85182f);
                j.lineTo(1458.0131f, 259.251f);
                j.lineTo(1464.6487f, 265.88657f);
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
