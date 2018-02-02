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

public final class ov extends c {
    private final int height = 270;
    private final int width = 270;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 270;
            case 1:
                return 270;
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
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(14211288);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(270.0f, 0.0f);
                j.lineTo(270.0f, 270.0f);
                j.lineTo(0.0f, 270.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15028967);
                Path j2 = c.j(looper);
                j2.moveTo(63.314346f, 140.34763f);
                j2.cubicTo(62.933258f, 139.95532f, 62.89317f, 139.27344f, 63.224213f, 138.8254f);
                j2.lineTo(69.83471f, 129.87872f);
                j2.cubicTo(70.16602f, 129.43033f, 70.79083f, 129.3384f, 71.22918f, 129.67256f);
                j2.lineTo(108.10534f, 157.78488f);
                j2.cubicTo(108.54417f, 158.11943f, 109.244865f, 158.1048f, 109.66647f, 157.75543f);
                j2.lineTo(198.3778f, 84.246925f);
                j2.cubicTo(198.80116f, 83.89612f, 199.4602f, 83.922f, 199.85126f, 84.30612f);
                j2.lineTo(206.24776f, 90.58951f);
                j2.cubicTo(206.63817f, 90.97301f, 206.63751f, 91.59433f, 206.23552f, 91.98784f);
                j2.lineTo(109.616165f, 186.56723f);
                j2.cubicTo(109.219f, 186.956f, 108.58932f, 186.95439f, 108.20701f, 186.56084f);
                j2.lineTo(63.314346f, 140.34763f);
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
