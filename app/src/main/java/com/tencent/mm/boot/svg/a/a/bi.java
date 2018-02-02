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

public final class bi extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                i3 = c.a(i2, looper);
                i3.setColor(-855310);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(90.0f, 0.0f);
                j.lineTo(90.0f, 90.0f);
                j.lineTo(0.0f, 90.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                e = c.a(e, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 27.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(44.0f, 21.962822f);
                j2.lineTo(44.0f, 4.0f);
                j2.lineTo(4.0f, 4.0f);
                j2.lineTo(4.0f, 20.913124f);
                j2.lineTo(14.878189f, 12.518221f);
                j2.cubicTo(15.9883175f, 11.620444f, 17.771101f, 11.663985f, 18.841188f, 12.6042f);
                j2.lineTo(29.616116f, 22.07142f);
                j2.lineTo(35.061848f, 17.385994f);
                j2.cubicTo(36.17116f, 16.44265f, 37.936134f, 16.461815f, 39.013035f, 17.428202f);
                j2.lineTo(44.0f, 21.962822f);
                j2.close();
                j2.moveTo(44.0f, 29.16303f);
                j2.lineTo(44.0f, 27.369196f);
                j2.lineTo(36.995003f, 20.999496f);
                j2.lineTo(32.650444f, 24.737488f);
                j2.lineTo(34.997852f, 26.8f);
                j2.lineTo(28.937702f, 26.8f);
                j2.lineTo(16.771114f, 16.110018f);
                j2.lineTo(4.0f, 25.965727f);
                j2.lineTo(4.0f, 32.0f);
                j2.lineTo(44.0f, 32.0f);
                j2.lineTo(44.0f, 29.16303f);
                j2.close();
                j2.moveTo(-2.220446E-15f, 2.4f);
                j2.cubicTo(-2.382771E-15f, 1.0745167f, 1.0745167f, 2.4348735E-16f, 2.4f, 0.0f);
                j2.lineTo(45.6f, -2.220446E-15f);
                j2.cubicTo(46.925484f, -2.4639335E-15f, 48.0f, 1.0745167f, 48.0f, 2.4f);
                j2.lineTo(48.0f, 33.6f);
                j2.cubicTo(48.0f, 34.925484f, 46.925484f, 36.0f, 45.6f, 36.0f);
                j2.lineTo(2.4f, 36.0f);
                j2.cubicTo(1.0745167f, 36.0f, 1.623249E-16f, 34.925484f, 0.0f, 33.6f);
                j2.lineTo(-2.220446E-15f, 2.4f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
