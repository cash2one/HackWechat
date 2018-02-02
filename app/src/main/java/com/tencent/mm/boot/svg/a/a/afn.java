package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afn extends c {
    private final int height = i.CTRL_INDEX;
    private final int width = i.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return i.CTRL_INDEX;
            case 1:
                return i.CTRL_INDEX;
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
                a.setColor(-15724528);
                e = c.a(e, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(86.26f, 1.24f);
                j.cubicTo(108.45f, -1.53f, 131.55f, 3.55f, 150.45f, 15.53f);
                j.cubicTo(169.74f, 27.58f, 184.6f, 46.55f, 191.61f, 68.2f);
                j.cubicTo(198.68f, 89.68f, 198.0f, 113.61f, 189.69f, 134.65f);
                j.cubicTo(181.53f, 155.58f, 165.93f, 173.48f, 146.33f, 184.43f);
                j.cubicTo(126.15f, 195.89f, 101.83f, 199.69f, 79.1f, 195.13f);
                j.cubicTo(56.88f, 190.83f, 36.38f, 178.43f, 22.13f, 160.87f);
                j.cubicTo(8.8f, 144.64f, 0.92f, 124.01f, 0.11f, 103.02f);
                j.cubicTo(-1.0f, 79.99f, 6.41f, 56.69f, 20.62f, 38.53f);
                j.cubicTo(36.39f, 18.04f, 60.56f, 4.25f, 86.26f, 1.24f);
                j.lineTo(86.26f, 1.24f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
