package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class alj extends c {
    private final int height = 72;
    private final int width = i.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return i.CTRL_INDEX;
            case 1:
                return 72;
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
                a.setColor(-11286451);
                Path j = c.j(looper);
                j.moveTo(0.0f, 12.0f);
                j.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                j.lineTo(198.0f, 0.0f);
                j.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                j.lineTo(210.0f, 60.0f);
                j.cubicTo(210.0f, 66.62742f, 204.62741f, 72.0f, 198.0f, 72.0f);
                j.lineTo(12.0f, 72.0f);
                j.cubicTo(5.3725824f, 72.0f, 0.0f, 66.62742f, 0.0f, 60.0f);
                j.lineTo(0.0f, 12.0f);
                j.close();
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(105.0f, 11.0f);
                j.cubicTo(105.0f, 6.581722f, 108.58172f, 3.0f, 113.0f, 3.0f);
                j.lineTo(199.0f, 3.0f);
                j.cubicTo(203.41827f, 3.0f, 207.0f, 6.581722f, 207.0f, 11.0f);
                j.lineTo(207.0f, 61.0f);
                j.cubicTo(207.0f, 65.41828f, 203.41827f, 69.0f, 199.0f, 69.0f);
                j.lineTo(113.0f, 69.0f);
                j.cubicTo(108.58172f, 69.0f, 105.0f, 65.41828f, 105.0f, 61.0f);
                j.lineTo(105.0f, 11.0f);
                j.close();
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
