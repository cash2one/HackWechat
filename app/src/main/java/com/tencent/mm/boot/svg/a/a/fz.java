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

public final class fz extends c {
    private final int height = 17;
    private final int width = 17;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 17;
            case 1:
                return 17;
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
                a.setColor(-11048043);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.37097725f, 3.9374971f);
                j.lineTo(3.945679f, 3.9374971f);
                j.lineTo(8.5f, 15.0f);
                j.lineTo(0.22602811f, 4.231666f);
                j.cubicTo(0.16451833f, 4.1516128f, 0.17955074f, 4.0368533f, 0.25960392f, 3.9753437f);
                j.cubicTo(0.2915445f, 3.9508018f, 0.33069694f, 3.9374971f, 0.37097725f, 3.9374971f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(16.629023f, 3.9374971f);
                j.lineTo(13.138271f, 3.9374971f);
                j.lineTo(8.5f, 15.0f);
                j.lineTo(16.773972f, 4.231666f);
                j.cubicTo(16.835482f, 4.1516128f, 16.82045f, 4.0368533f, 16.740396f, 3.9753437f);
                j.cubicTo(16.708456f, 3.9508018f, 16.669304f, 3.9374971f, 16.629023f, 3.9374971f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(5.1944447f, 3.9374971f);
                j2.lineTo(11.805555f, 3.9374971f);
                j2.lineTo(8.5f, 15.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(4.0353537f, 2.8125f);
                j.lineTo(6.611111f, 0.0f);
                j.lineTo(3.9231226f, 5.828671E-16f);
                j.cubicTo(3.8844628f, 6.929792E-16f, 3.8467984f, 0.012256962f, 3.815543f, 0.035009228f);
                j.lineTo(0.4541331f, 2.4819179f);
                j.cubicTo(0.37251288f, 2.5413325f, 0.35451177f, 2.655664f, 0.41392648f, 2.7372842f);
                j.cubicTo(0.4483286f, 2.7845438f, 0.50325805f, 2.8125f, 0.5617129f, 2.8125f);
                j.lineTo(4.0353537f, 2.8125f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                j2 = c.j(looper);
                j2.moveTo(7.5555553f, 0.0f);
                j2.lineTo(9.444445f, 0.0f);
                j2.lineTo(11.805555f, 2.8125f);
                j2.lineTo(5.1944447f, 2.8125f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a3);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(13.150493f, 2.8125f);
                j.lineTo(10.388889f, 0.0f);
                j.lineTo(13.17345f, -2.7755576E-17f);
                j.cubicTo(13.212875f, -2.0513277E-17f, 13.251245f, 0.012746517f, 13.282832f, 0.036337905f);
                j.lineTo(16.559143f, 2.4832466f);
                j.cubicTo(16.64003f, 2.5436563f, 16.65663f, 2.6581998f, 16.596218f, 2.7390862f);
                j.cubicTo(16.561712f, 2.7852888f, 16.507427f, 2.8125f, 16.44976f, 2.8125f);
                j.lineTo(13.150493f, 2.8125f);
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
