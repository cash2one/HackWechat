package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class mp extends c {
    private final int height = d.CTRL_INDEX;
    private final int width = 264;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 264;
            case 1:
                return d.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-13158344);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(245.998f, 169.0001f);
                j.lineTo(152.0f, 169.0001f);
                j.lineTo(152.0f, 169.0001f);
                j.lineTo(108.0f, 169.0001f);
                j.lineTo(108.0f, 169.0001f);
                j.lineTo(14.002f, 169.0001f);
                j.cubicTo(7.936f, 169.0001f, 3.0f, 164.0641f, 3.0f, 157.9971f);
                j.lineTo(3.0f, 138.0001f);
                j.lineTo(257.0f, 138.0001f);
                j.lineTo(257.0f, 157.9971f);
                j.cubicTo(257.0f, 164.0641f, 252.064f, 169.0001f, 245.998f, 169.0001f);
                j.lineTo(245.998f, 169.0001f);
                j.close();
                j.moveTo(14.002f, 3.0001f);
                j.lineTo(245.998f, 3.0001f);
                j.cubicTo(252.064f, 3.0001f, 257.0f, 7.9361f, 257.0f, 14.0021f);
                j.lineTo(257.0f, 136.0001f);
                j.lineTo(3.0f, 136.0001f);
                j.lineTo(3.0f, 14.0021f);
                j.cubicTo(3.0f, 7.9361f, 7.936f, 3.0001f, 14.002f, 3.0001f);
                j.lineTo(14.002f, 3.0001f);
                j.close();
                j.moveTo(164.703f, 197.0001f);
                j.lineTo(95.297f, 197.0001f);
                j.lineTo(107.697f, 194.5201f);
                j.lineTo(110.634f, 172.0001f);
                j.lineTo(149.366f, 172.0001f);
                j.lineTo(152.303f, 194.5201f);
                j.lineTo(164.703f, 197.0001f);
                j.close();
                j.moveTo(245.998f, 1.0E-4f);
                j.lineTo(14.002f, 1.0E-4f);
                j.cubicTo(6.266f, 1.0E-4f, 0.0f, 6.2691f, 0.0f, 14.0021f);
                j.lineTo(0.0f, 157.9971f);
                j.cubicTo(0.0f, 165.7261f, 6.269f, 172.0001f, 14.002f, 172.0001f);
                j.lineTo(107.609f, 172.0001f);
                j.lineTo(105.0f, 192.0001f);
                j.lineTo(90.0f, 195.0001f);
                j.lineTo(90.0f, 200.0001f);
                j.lineTo(170.0f, 200.0001f);
                j.lineTo(170.0f, 195.0001f);
                j.lineTo(155.0f, 192.0001f);
                j.lineTo(152.391f, 172.0001f);
                j.lineTo(245.998f, 172.0001f);
                j.cubicTo(253.734f, 172.0001f, 260.0f, 165.7311f, 260.0f, 157.9971f);
                j.lineTo(260.0f, 14.0021f);
                j.cubicTo(260.0f, 6.2741f, 253.731f, 1.0E-4f, 245.998f, 1.0E-4f);
                j.lineTo(245.998f, 1.0E-4f);
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
