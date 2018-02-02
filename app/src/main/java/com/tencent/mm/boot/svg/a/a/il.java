package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class il extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = e.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return e.CTRL_INDEX;
            case 1:
                return e.CTRL_INDEX;
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
                a.setColor(-9276814);
                Path j = c.j(looper);
                j.moveTo(120.0f, 12.0f);
                j.lineTo(24.0f, 12.0f);
                j.cubicTo(17.4f, 12.0f, 12.06f, 17.4f, 12.06f, 24.0f);
                j.lineTo(12.0f, 132.0f);
                j.lineTo(36.0f, 108.0f);
                j.lineTo(120.0f, 108.0f);
                j.cubicTo(126.6f, 108.0f, 132.0f, 102.6f, 132.0f, 96.0f);
                j.lineTo(132.0f, 24.0f);
                j.cubicTo(132.0f, 17.4f, 126.6f, 12.0f, 120.0f, 12.0f);
                j.lineTo(120.0f, 12.0f);
                j.close();
                j.moveTo(108.0f, 84.0f);
                j.lineTo(36.0f, 84.0f);
                j.lineTo(36.0f, 72.0f);
                j.lineTo(108.0f, 72.0f);
                j.lineTo(108.0f, 84.0f);
                j.lineTo(108.0f, 84.0f);
                j.close();
                j.moveTo(108.0f, 66.0f);
                j.lineTo(36.0f, 66.0f);
                j.lineTo(36.0f, 54.0f);
                j.lineTo(108.0f, 54.0f);
                j.lineTo(108.0f, 66.0f);
                j.lineTo(108.0f, 66.0f);
                j.close();
                j.moveTo(108.0f, 48.0f);
                j.lineTo(36.0f, 48.0f);
                j.lineTo(36.0f, 36.0f);
                j.lineTo(108.0f, 36.0f);
                j.lineTo(108.0f, 48.0f);
                j.lineTo(108.0f, 48.0f);
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
