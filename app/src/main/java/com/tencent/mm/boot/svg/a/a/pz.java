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

public final class pz extends c {
    private final int height = 30;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 30;
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
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                Path j = c.j(looper);
                j.moveTo(22.0f, 14.999688f);
                j.lineTo(7.130435f, 29.999374f);
                j.lineTo(3.826087f, 26.666111f);
                j.lineTo(15.391304f, 14.999688f);
                j.lineTo(3.0f, 3.3332639f);
                j.lineTo(6.304348f, 0.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.saveLayerAlpha(null, 51, 4);
                i2 = c.a(i2, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                Path j2 = c.j(looper);
                j2.moveTo(0.0f, 0.0f);
                j2.lineTo(24.0f, 0.0f);
                j2.lineTo(24.0f, 30.0f);
                j2.lineTo(0.0f, 30.0f);
                j2.lineTo(0.0f, 0.0f);
                j2.close();
                c.h(looper);
                break;
        }
        return 0;
    }
}
