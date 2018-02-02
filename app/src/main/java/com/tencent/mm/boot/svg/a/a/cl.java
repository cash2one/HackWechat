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

public final class cl extends c {
    private final int height = 279;
    private final int width = 279;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                e = c.a(e, 1.0f, 0.0f, -144.0f, 0.0f, 1.0f, -69.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 69.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-3552823);
                Path j = c.j(looper);
                j.moveTo(279.0f, 141.1269f);
                j.cubicTo(279.0f, 62.751225f, 216.54533f, 0.60727614f, 137.77777f, 0.60727614f);
                j.cubicTo(62.454666f, 0.60727614f, 0.0f, 62.751225f, 0.0f, 141.1269f);
                j.cubicTo(0.0f, 216.07527f, 62.454666f, 278.2192f, 137.77777f, 278.2192f);
                j.cubicTo(216.54533f, 278.2192f, 279.0f, 216.07527f, 279.0f, 141.1269f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a = c.a(i2, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(131.70822f, 71.3711f);
                j.cubicTo(128.45819f, 71.3711f, 125.94605f, 74.00451f, 126.09674f, 77.24315f);
                j.lineTo(130.2428f, 166.35248f);
                j.cubicTo(130.31987f, 168.00896f, 131.72324f, 169.35179f, 133.37312f, 169.35179f);
                j.lineTo(145.62688f, 169.35179f);
                j.cubicTo(147.27864f, 169.35179f, 148.68036f, 168.004f, 148.7572f, 166.35248f);
                j.lineTo(152.90326f, 77.24315f);
                j.cubicTo(153.05415f, 74.00011f, 150.54134f, 71.3711f, 147.29178f, 71.3711f);
                j.lineTo(131.70822f, 71.3711f);
                j.close();
                j.moveTo(139.5f, 212.89876f);
                j.cubicTo(147.0533f, 212.89876f, 153.17647f, 206.80606f, 153.17647f, 199.29033f);
                j.cubicTo(153.17647f, 191.7746f, 147.0533f, 185.6819f, 139.5f, 185.6819f);
                j.cubicTo(131.9467f, 185.6819f, 125.82353f, 191.7746f, 125.82353f, 199.29033f);
                j.cubicTo(125.82353f, 206.80606f, 131.9467f, 212.89876f, 139.5f, 212.89876f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
