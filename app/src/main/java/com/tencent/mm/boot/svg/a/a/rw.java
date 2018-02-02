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

public final class rw extends c {
    private final int height = 78;
    private final int width = 78;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 78;
            case 1:
                return 78;
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
                i2.setColor(-1776412);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(39.0f, 78.0f);
                j.cubicTo(60.539104f, 78.0f, 78.0f, 60.539104f, 78.0f, 39.0f);
                j.cubicTo(78.0f, 17.460896f, 60.539104f, 0.0f, 39.0f, 0.0f);
                j.cubicTo(17.460896f, 0.0f, 0.0f, 17.460896f, 0.0f, 39.0f);
                j.cubicTo(0.0f, 60.539104f, 17.460896f, 78.0f, 39.0f, 78.0f);
                j.close();
                j.moveTo(39.0f, 73.0f);
                j.cubicTo(57.777683f, 73.0f, 73.0f, 57.777683f, 73.0f, 39.0f);
                j.cubicTo(73.0f, 20.222319f, 57.777683f, 5.0f, 39.0f, 5.0f);
                j.cubicTo(20.222319f, 5.0f, 5.0f, 20.222319f, 5.0f, 39.0f);
                j.cubicTo(5.0f, 57.777683f, 20.222319f, 73.0f, 39.0f, 73.0f);
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
