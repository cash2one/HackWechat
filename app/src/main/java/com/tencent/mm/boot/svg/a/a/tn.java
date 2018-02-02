package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.media.f;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class tn extends c {
    private final int height = f.CTRL_INDEX;
    private final int width = f.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return f.CTRL_INDEX;
            case 1:
                return f.CTRL_INDEX;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(0.0f, 40.0f);
                j.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                j.lineTo(176.0f, 0.0f);
                j.cubicTo(198.09138f, 0.0f, 216.0f, 17.90861f, 216.0f, 40.0f);
                j.lineTo(216.0f, 176.0f);
                j.cubicTo(216.0f, 198.09138f, 198.09138f, 216.0f, 176.0f, 216.0f);
                j.lineTo(40.0f, 216.0f);
                j.cubicTo(17.90861f, 216.0f, 0.0f, 198.09138f, 0.0f, 176.0f);
                j.lineTo(0.0f, 40.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
