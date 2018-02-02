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

public final class eg extends c {
    private final int height = 40;
    private final int width = 44;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 44;
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
                a.setColor(-9074981);
                e = c.a(e, 1.0f, 0.0f, -298.0f, 0.0f, 1.0f, -661.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(322.0f, 663.0f);
                j.cubicTo(320.0f, 664.0f, 316.5f, 668.1991f, 317.0f, 672.0f);
                j.lineTo(317.0f, 689.0f);
                j.cubicTo(316.5f, 691.797f, 313.4775f, 695.2222f, 310.0f, 695.0f);
                j.cubicTo(306.02176f, 695.2222f, 303.0f, 691.797f, 303.0f, 689.0f);
                j.cubicTo(303.0f, 686.67645f, 305.0f, 683.0f, 307.0f, 683.0f);
                j.cubicTo(309.0f, 683.0f, 311.0f, 681.0f, 310.0f, 679.0f);
                j.cubicTo(309.0f, 677.0f, 306.0f, 677.87036f, 305.0f, 678.0f);
                j.cubicTo(304.0f, 678.12964f, 300.0f, 681.0f, 299.0f, 683.0f);
                j.cubicTo(298.0f, 685.0f, 298.0f, 686.8411f, 298.0f, 689.0f);
                j.cubicTo(298.0f, 694.9784f, 302.7195f, 701.0f, 310.0f, 701.0f);
                j.cubicTo(312.23026f, 701.0f, 315.0f, 700.0f, 317.0f, 699.0f);
                j.cubicTo(319.0f, 698.0f, 322.5f, 692.8009f, 322.0f, 689.0f);
                j.lineTo(322.0f, 672.0f);
                j.cubicTo(322.5f, 669.203f, 325.52176f, 666.7778f, 329.0f, 667.0f);
                j.cubicTo(332.9775f, 666.7778f, 337.0f, 669.203f, 337.0f, 672.0f);
                j.cubicTo(337.0f, 674.41455f, 335.0f, 677.0f, 332.0f, 678.0f);
                j.cubicTo(329.0f, 679.0f, 328.0f, 680.0f, 329.0f, 682.0f);
                j.cubicTo(330.0f, 684.0f, 333.0f, 683.0f, 334.0f, 683.0f);
                j.cubicTo(335.0f, 683.0f, 339.0f, 680.0f, 340.0f, 678.0f);
                j.cubicTo(341.0f, 676.0f, 342.0f, 674.1589f, 342.0f, 672.0f);
                j.cubicTo(342.0f, 666.0216f, 336.2805f, 661.0f, 329.0f, 661.0f);
                j.cubicTo(326.76974f, 661.0f, 324.0f, 662.0f, 322.0f, 663.0f);
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
