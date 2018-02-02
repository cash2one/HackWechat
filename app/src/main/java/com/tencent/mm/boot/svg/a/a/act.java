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

public final class act extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(47.9995f, 20.0f);
                j.cubicTo(30.878777f, 20.0f, 17.0f, 31.79821f, 17.0f, 46.35247f);
                j.cubicTo(17.0f, 53.18859f, 20.06195f, 59.415703f, 25.08287f, 64.098785f);
                j.cubicTo(23.80389f, 68.17186f, 21.427929f, 76.0f, 21.427929f, 76.0f);
                j.lineTo(34.25072f, 69.97289f);
                j.cubicTo(38.394653f, 71.719925f, 43.06058f, 72.70594f, 48.0005f, 72.70594f);
                j.cubicTo(65.12122f, 72.70594f, 79.0f, 60.90773f, 79.0f, 46.35147f);
                j.cubicTo(78.999f, 31.79821f, 65.120224f, 20.0f, 47.9995f, 20.0f);
                j.lineTo(47.9995f, 20.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
