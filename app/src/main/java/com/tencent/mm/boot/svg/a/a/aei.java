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

public final class aei extends c {
    private final int height = 24;
    private final int width = 30;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
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
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                canvas.save();
                i3 = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(26.0f, 0.0f);
                j.lineTo(26.0f, 20.0f);
                j.lineTo(0.0f, 20.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(24.0f, 2.0f);
                j.lineTo(2.0f, 2.0f);
                j.lineTo(2.0f, 17.0f);
                j.lineTo(24.0f, 17.0f);
                j.lineTo(24.0f, 2.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(28.0f, 23.0f);
                j.lineTo(29.0f, 23.0f);
                j.lineTo(29.0f, 3.0f);
                j.lineTo(27.0f, 3.0f);
                j.lineTo(27.0f, 21.0f);
                j.lineTo(3.0f, 21.0f);
                j.lineTo(3.0f, 23.0f);
                j.lineTo(28.0f, 23.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                Path j2 = c.j(looper);
                j2.moveTo(19.784946f, 8.898396f);
                j2.lineTo(15.462585f, 11.916007f);
                j2.lineTo(8.518518f, 6.5454545f);
                j2.lineTo(0.0f, 13.368984f);
                j2.lineTo(0.0f, 18.545454f);
                j2.lineTo(25.555555f, 18.545454f);
                j2.lineTo(25.555555f, 13.368984f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
