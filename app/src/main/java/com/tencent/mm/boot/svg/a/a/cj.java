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

public final class cj extends c {
    private final int height = 18;
    private final int width = 56;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 56;
            case 1:
                return 18;
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, -507.0f, 0.0f, 1.0f, -423.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 6.123234E-17f, -1.0f, 967.0f, 1.0f, 6.123234E-17f, -103.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(535.0f, 404.0f);
                j.cubicTo(537.7558f, 404.0f, 540.0f, 406.2386f, 540.0f, 409.0f);
                j.cubicTo(540.0f, 411.7558f, 537.7614f, 414.0f, 535.0f, 414.0f);
                j.cubicTo(532.2442f, 414.0f, 530.0f, 411.7614f, 530.0f, 409.0f);
                j.cubicTo(530.0f, 406.2442f, 532.2386f, 404.0f, 535.0f, 404.0f);
                j.close();
                j.moveTo(535.0f, 423.0f);
                j.cubicTo(539.9717f, 423.0f, 544.0f, 427.02945f, 544.0f, 432.0f);
                j.cubicTo(544.0f, 436.97165f, 539.9706f, 441.0f, 535.0f, 441.0f);
                j.cubicTo(530.0283f, 441.0f, 526.0f, 436.97055f, 526.0f, 432.0f);
                j.cubicTo(526.0f, 427.02835f, 530.0294f, 423.0f, 535.0f, 423.0f);
                j.close();
                j.moveTo(535.0f, 450.0f);
                j.cubicTo(537.7558f, 450.0f, 540.0f, 452.2386f, 540.0f, 455.0f);
                j.cubicTo(540.0f, 457.7558f, 537.7614f, 460.0f, 535.0f, 460.0f);
                j.cubicTo(532.2442f, 460.0f, 530.0f, 457.7614f, 530.0f, 455.0f);
                j.cubicTo(530.0f, 452.2442f, 532.2386f, 450.0f, 535.0f, 450.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
