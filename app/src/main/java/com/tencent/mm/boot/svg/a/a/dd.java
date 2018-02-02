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

public final class dd extends c {
    private final int height = 63;
    private final int width = 63;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                a.setColor(-11048043);
                e = c.a(e, 1.0f, 0.0f, -131.0f, 0.0f, 1.0f, -206.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(161.0f, 261.92117f);
                j.cubicTo(148.12799f, 260.90228f, 138.0f, 250.13391f, 138.0f, 237.0f);
                j.cubicTo(138.0f, 230.57487f, 140.42381f, 224.71585f, 144.40697f, 220.28743f);
                j.lineTo(148.24004f, 223.50375f);
                j.cubicTo(144.98555f, 227.06102f, 143.0f, 231.79863f, 143.0f, 237.0f);
                j.cubicTo(143.0f, 247.27452f, 150.74763f, 255.7395f, 160.71942f, 256.8714f);
                j.lineTo(161.0f, 257.10684f);
                j.lineTo(161.0f, 253.35852f);
                j.cubicTo(161.0f, 253.00606f, 161.22818f, 252.89862f, 161.50964f, 253.09564f);
                j.lineTo(170.49036f, 259.38214f);
                j.cubicTo(170.77235f, 259.57953f, 170.77182f, 259.89862f, 170.49036f, 260.09564f);
                j.lineTo(161.50964f, 266.38214f);
                j.cubicTo(161.22765f, 266.57953f, 161.0f, 266.4615f, 161.0f, 266.11926f);
                j.lineTo(161.0f, 261.92117f);
                j.close();
                j.moveTo(161.0f, 212.07884f);
                j.cubicTo(161.65979f, 212.02661f, 162.32678f, 212.0f, 163.0f, 212.0f);
                j.cubicTo(176.80711f, 212.0f, 188.0f, 223.19289f, 188.0f, 237.0f);
                j.cubicTo(188.0f, 244.6545f, 184.55992f, 251.50551f, 179.14146f, 256.09134f);
                j.lineTo(175.24045f, 252.81801f);
                j.cubicTo(179.96123f, 249.15959f, 183.0f, 243.43468f, 183.0f, 237.0f);
                j.cubicTo(183.0f, 225.9543f, 174.0457f, 217.0f, 163.0f, 217.0f);
                j.cubicTo(162.325f, 217.0f, 161.6578f, 217.03343f, 161.0f, 217.09875f);
                j.lineTo(161.0f, 221.11926f);
                j.cubicTo(161.0f, 221.47173f, 160.77182f, 221.57916f, 160.49036f, 221.38214f);
                j.lineTo(151.50964f, 215.09564f);
                j.cubicTo(151.22765f, 214.89825f, 151.22818f, 214.57916f, 151.50964f, 214.38214f);
                j.lineTo(160.49036f, 208.09564f);
                j.cubicTo(160.77235f, 207.89825f, 161.0f, 208.01631f, 161.0f, 208.35852f);
                j.lineTo(161.0f, 212.07884f);
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
