package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class abm extends c {
    private final int height = 96;
    private final int width = 43;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 43;
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                i2 = c.a(i2, looper);
                i3 = c.a(i3, looper);
                i2.setColor(-1);
                i3.setColor(832018327);
                i3.setStrokeWidth(1.44f);
                canvas.save();
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(21.5f, 31.0f);
                j.cubicTo(31.164984f, 31.0f, 39.0f, 38.835014f, 39.0f, 48.5f);
                j.cubicTo(39.0f, 58.164986f, 31.164984f, 66.0f, 21.5f, 66.0f);
                j.cubicTo(11.835016f, 66.0f, 4.0f, 58.164986f, 4.0f, 48.5f);
                j.cubicTo(4.0f, 38.835014f, 11.835016f, 31.0f, 21.5f, 31.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.drawPath(j, a2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
