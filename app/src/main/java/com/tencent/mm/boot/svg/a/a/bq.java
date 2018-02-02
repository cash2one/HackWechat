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

public final class bq extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                i2.setColor(-1);
                canvas.save();
                i2 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(61.0f, 33.0f);
                j.lineTo(61.0f, 64.0f);
                j.lineTo(19.0f, 64.0f);
                j.lineTo(19.0f, 17.0f);
                j.lineTo(47.0f, 17.0f);
                j.lineTo(47.0f, 33.0f);
                j.lineTo(49.0f, 33.0f);
                j.lineTo(61.0f, 33.0f);
                j.close();
                j.moveTo(60.989494f, 29.0f);
                j.lineTo(51.0f, 18.140165f);
                j.lineTo(51.0f, 29.0f);
                j.lineTo(60.989494f, 29.0f);
                j.close();
                j.moveTo(63.0f, 68.0f);
                j.lineTo(15.0f, 68.0f);
                j.lineTo(15.0f, 66.0f);
                j.lineTo(15.0f, 15.0f);
                j.lineTo(15.0f, 13.0f);
                j.lineTo(51.0f, 13.0f);
                j.lineTo(51.0f, 13.028122f);
                j.lineTo(65.04203f, 28.0f);
                j.lineTo(65.0f, 28.010773f);
                j.lineTo(65.0f, 68.0f);
                j.lineTo(63.0f, 68.0f);
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
