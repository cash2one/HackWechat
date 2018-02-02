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

public final class hz extends c {
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
                i2.setColor(-8683387);
                canvas.save();
                i2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(69.0f, 12.0f);
                j.lineTo(60.0f, 21.0f);
                j.lineTo(69.0f, 29.0f);
                j.lineTo(77.0f, 21.0f);
                j.lineTo(69.0f, 12.0f);
                j.close();
                j.moveTo(20.0f, 60.0f);
                j.lineTo(20.0f, 60.0f);
                j.lineTo(20.0f, 60.0f);
                j.lineTo(20.0f, 69.0f);
                j.lineTo(29.0f, 69.0f);
                j.lineTo(63.0f, 34.0f);
                j.lineTo(55.0f, 26.0f);
                j.lineTo(20.0f, 60.0f);
                j.close();
                j.moveTo(12.0f, 85.0f);
                j.lineTo(85.0f, 85.0f);
                j.lineTo(85.0f, 77.0f);
                j.lineTo(12.0f, 77.0f);
                j.lineTo(12.0f, 85.0f);
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
