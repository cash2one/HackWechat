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

public final class afr extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                e = c.a(e, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 8.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(40.739872f, 0.951031f);
                j.cubicTo(42.90053f, -1.4607488f, 46.528423f, 1.1793065f, 46.95051f, 3.7101865f);
                j.cubicTo(47.27209f, 5.1890144f, 45.9556f, 6.2311416f, 45.05114f, 7.1938686f);
                j.cubicTo(36.941135f, 15.133884f, 28.891432f, 23.153301f, 20.801529f, 31.113167f);
                j.cubicTo(19.515184f, 32.60192f, 17.123386f, 32.065968f, 16.058132f, 30.616915f);
                j.cubicTo(11.405182f, 25.892607f, 6.5914383f, 21.327097f, 1.9485373f, 16.592863f);
                j.cubicTo(-1.2271264f, 13.724532f, 4.350384f, 8.295546f, 7.24466f, 11.362377f);
                j.cubicTo(11.103695f, 15.084259f, 14.862233f, 18.905392f, 18.701168f, 22.6372f);
                j.cubicTo(26.077553f, 15.44156f, 33.33334f, 8.116896f, 40.739872f, 0.951031f);
                j.lineTo(40.739872f, 0.951031f);
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
