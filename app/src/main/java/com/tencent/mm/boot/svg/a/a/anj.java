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

public final class anj extends c {
    private final int height = 150;
    private final int width = 24;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 150;
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
                i3 = c.a(i2, looper);
                i3.setColor(-1644826);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(24.0f, 0.0f);
                j.lineTo(24.0f, 150.0f);
                j.lineTo(0.0f, 150.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(WebView.NIGHT_MODE_COLOR);
                Path j2 = c.j(looper);
                j2.moveTo(7.0f, 66.0f);
                j2.lineTo(10.0f, 66.0f);
                j2.lineTo(10.0f, 84.0f);
                j2.lineTo(7.0f, 84.0f);
                j2.lineTo(7.0f, 66.0f);
                j2.close();
                j2.moveTo(14.0f, 66.0f);
                j2.lineTo(17.0f, 66.0f);
                j2.lineTo(17.0f, 84.0f);
                j2.lineTo(14.0f, 84.0f);
                j2.lineTo(14.0f, 66.0f);
                j2.close();
                canvas.saveLayerAlpha(null, 51, 4);
                i2 = c.a(i2, looper);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
