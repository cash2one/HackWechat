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

public final class tx extends c {
    private final int height = 40;
    private final int width = 46;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 40;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16896);
                e = c.a(e, 1.0f, 0.0f, -149.0f, 0.0f, 1.0f, -661.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(151.0733f, 700.02264f);
                j.lineTo(151.0733f, 700.02264f);
                j.cubicTo(150.70924f, 700.02264f, 150.3521f, 699.9233f, 150.04036f, 699.7353f);
                j.cubicTo(149.09451f, 699.1648f, 148.7902f, 697.93555f, 149.36069f, 696.98975f);
                j.lineTo(149.36069f, 696.98975f);
                j.lineTo(170.08609f, 662.6272f);
                j.cubicTo(170.25401f, 662.34875f, 170.48732f, 662.1155f, 170.76575f, 661.9475f);
                j.cubicTo(171.7116f, 661.377f, 172.94083f, 661.68134f, 173.5113f, 662.6272f);
                j.lineTo(173.5113f, 662.6272f);
                j.lineTo(194.2367f, 696.98975f);
                j.cubicTo(194.42471f, 697.30145f, 194.52408f, 697.6586f, 194.52408f, 698.02264f);
                j.cubicTo(194.52408f, 699.12726f, 193.62866f, 700.02264f, 192.52408f, 700.02264f);
                j.lineTo(151.0733f, 700.02264f);
                j.close();
                j.moveTo(169.61902f, 675.9917f);
                j.lineTo(170.2866f, 687.9688f);
                j.lineTo(173.31001f, 687.9688f);
                j.lineTo(173.9776f, 675.9917f);
                j.cubicTo(174.0237f, 675.16455f, 173.39055f, 674.45667f, 172.5634f, 674.4105f);
                j.cubicTo(172.5356f, 674.409f, 172.50777f, 674.4082f, 172.47992f, 674.4082f);
                j.lineTo(171.1167f, 674.4082f);
                j.cubicTo(170.28827f, 674.4082f, 169.6167f, 675.0798f, 169.6167f, 675.9082f);
                j.cubicTo(169.6167f, 675.93604f, 169.61748f, 675.96387f, 169.61902f, 675.9917f);
                j.close();
                j.moveTo(171.79831f, 695.50244f);
                j.cubicTo(173.05064f, 695.50244f, 174.06586f, 694.4906f, 174.06586f, 693.2424f);
                j.cubicTo(174.06586f, 691.99414f, 173.05064f, 690.98224f, 171.79831f, 690.98224f);
                j.cubicTo(170.54597f, 690.98224f, 169.53076f, 691.99414f, 169.53076f, 693.2424f);
                j.cubicTo(169.53076f, 694.4906f, 170.54597f, 695.50244f, 171.79831f, 695.50244f);
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
