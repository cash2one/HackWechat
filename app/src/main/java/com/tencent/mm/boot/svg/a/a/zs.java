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

public final class zs extends c {
    private final int height = 24;
    private final int width = 120;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 24;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(60.0f, 24.0f);
                j.cubicTo(66.62742f, 24.0f, 72.0f, 18.627417f, 72.0f, 12.0f);
                j.cubicTo(72.0f, 5.372583f, 66.62742f, 0.0f, 60.0f, 0.0f);
                j.cubicTo(53.37258f, 0.0f, 48.0f, 5.372583f, 48.0f, 12.0f);
                j.cubicTo(48.0f, 18.627417f, 53.37258f, 24.0f, 60.0f, 24.0f);
                j.close();
                j.moveTo(12.0f, 24.0f);
                j.cubicTo(18.627417f, 24.0f, 24.0f, 18.627417f, 24.0f, 12.0f);
                j.cubicTo(24.0f, 5.372583f, 18.627417f, 0.0f, 12.0f, 0.0f);
                j.cubicTo(5.372583f, 0.0f, 0.0f, 5.372583f, 0.0f, 12.0f);
                j.cubicTo(0.0f, 18.627417f, 5.372583f, 24.0f, 12.0f, 24.0f);
                j.close();
                j.moveTo(108.0f, 24.0f);
                j.cubicTo(114.62742f, 24.0f, 120.0f, 18.627417f, 120.0f, 12.0f);
                j.cubicTo(120.0f, 5.372583f, 114.62742f, 0.0f, 108.0f, 0.0f);
                j.cubicTo(101.37258f, 0.0f, 96.0f, 5.372583f, 96.0f, 12.0f);
                j.cubicTo(96.0f, 18.627417f, 101.37258f, 24.0f, 108.0f, 24.0f);
                j.close();
                canvas.saveLayerAlpha(null, 76, 4);
                i3 = c.a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                a2 = c.a(a, looper);
                a2.setColor(-1);
                j = c.j(looper);
                j.moveTo(60.0f, 0.0f);
                j.cubicTo(66.62742f, 0.0f, 72.0f, 5.3725824f, 72.0f, 12.0f);
                j.cubicTo(72.0f, 18.627419f, 66.62742f, 24.0f, 60.0f, 24.0f);
                j.cubicTo(53.37258f, 24.0f, 48.0f, 18.627419f, 48.0f, 12.0f);
                j.cubicTo(48.0f, 5.3725824f, 53.37258f, 0.0f, 60.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.drawPath(j, c.a(a2, looper));
                canvas.restore();
                a = c.a(a, looper);
                a.setColor(-1);
                j = c.j(looper);
                j.moveTo(12.0f, 0.0f);
                j.cubicTo(18.627419f, 0.0f, 24.0f, 5.3725824f, 24.0f, 12.0f);
                j.cubicTo(24.0f, 18.627419f, 18.627419f, 24.0f, 12.0f, 24.0f);
                j.cubicTo(5.3725824f, 24.0f, 0.0f, 18.627419f, 0.0f, 12.0f);
                j.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                j.close();
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.drawPath(j, c.a(a, looper));
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
