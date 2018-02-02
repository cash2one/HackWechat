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

public final class ku extends c {
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
                e = c.a(e, 1.0f, 0.0f, -1580.0f, 0.0f, 1.0f, -201.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-16139513);
                a2.setStrokeWidth(6.0f);
                Path j = c.j(looper);
                j.moveTo(1583.0f, 259.5f);
                j.cubicTo(1583.0f, 228.84819f, 1607.8481f, 204.0f, 1638.5f, 204.0f);
                j.lineTo(1638.5f, 204.0f);
                j.cubicTo(1669.1519f, 204.0f, 1694.0f, 228.84819f, 1694.0f, 259.5f);
                j.lineTo(1694.0f, 259.5f);
                j.cubicTo(1694.0f, 290.1518f, 1669.1519f, 315.0f, 1638.5f, 315.0f);
                j.lineTo(1638.5f, 315.0f);
                j.cubicTo(1607.8481f, 315.0f, 1583.0f, 290.1518f, 1583.0f, 259.5f);
                j.lineTo(1583.0f, 259.5f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(i2, looper);
                a2.setColor(-16139513);
                j = c.j(looper);
                j.moveTo(1646.8911f, 288.9778f);
                j.lineTo(1641.9794f, 284.06616f);
                j.cubicTo(1647.6785f, 277.75735f, 1651.1661f, 269.28784f, 1651.1661f, 259.97653f);
                j.cubicTo(1651.1661f, 250.72066f, 1647.7198f, 242.29657f, 1642.0809f, 235.9998f);
                j.lineTo(1646.9929f, 231.0878f);
                j.cubicTo(1653.8218f, 238.65639f, 1658.0f, 248.81223f, 1658.0f, 259.97653f);
                j.cubicTo(1658.0f, 271.1963f, 1653.7802f, 281.3975f, 1646.8911f, 288.9778f);
                j.close();
                j.moveTo(1635.4944f, 277.58115f);
                j.lineTo(1630.5815f, 272.66824f);
                j.cubicTo(1633.7931f, 269.45828f, 1635.7898f, 264.95837f, 1635.7898f, 259.97653f);
                j.cubicTo(1635.7898f, 255.05014f, 1633.8373f, 250.595f, 1630.6882f, 247.39249f);
                j.lineTo(1635.6002f, 242.48047f);
                j.cubicTo(1639.9392f, 246.95483f, 1642.6238f, 253.14172f, 1642.6238f, 259.97653f);
                j.cubicTo(1642.6238f, 266.8668f, 1639.8955f, 273.09854f, 1635.4944f, 277.58115f);
                j.close();
                j.moveTo(1624.436f, 266.5228f);
                j.cubicTo(1626.1627f, 264.90756f, 1627.2474f, 262.57294f, 1627.2474f, 259.97653f);
                j.cubicTo(1627.2474f, 257.43564f, 1626.2086f, 255.14546f, 1624.5459f, 253.53485f);
                j.lineTo(1617.997f, 260.08374f);
                j.lineTo(1624.436f, 266.5228f);
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
