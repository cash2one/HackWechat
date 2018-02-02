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

public final class tp extends c {
    private final int height = 32;
    private final int width = 20;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 32;
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
                i2 = c.a(i2, looper);
                i2.setColor(-2565928);
                Path j = c.j(looper);
                j.moveTo(15.773302f, 11.530662f);
                j.lineTo(4.2426405f, -1.7763568E-15f);
                j.lineTo(0.0f, 4.2426405f);
                j.lineTo(11.530662f, 15.773302f);
                j.lineTo(0.027727231f, 27.276237f);
                j.lineTo(4.270368f, 31.518877f);
                j.lineTo(20.021301f, 15.767945f);
                j.lineTo(15.77866f, 11.525304f);
                j.lineTo(15.773302f, 11.530662f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
