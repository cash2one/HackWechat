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

public final class pt extends c {
    private final int height = 27;
    private final int width = 27;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 27;
            case 1:
                return 27;
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
                a.setColor(-772816);
                Path j = c.j(looper);
                j.moveTo(27.0f, 13.666667f);
                j.cubicTo(27.0f, 6.044f, 20.956f, 0.0f, 13.333333f, 0.0f);
                j.cubicTo(6.044f, 0.0f, 0.0f, 6.044f, 0.0f, 13.666667f);
                j.cubicTo(0.0f, 20.956f, 6.044f, 27.0f, 13.333333f, 27.0f);
                j.cubicTo(20.956f, 27.0f, 27.0f, 20.956f, 27.0f, 13.666667f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(13.5f, 6.0f);
                j.cubicTo(14.334203f, 6.0f, 14.962531f, 6.674437f, 14.916311f, 7.5063977f);
                j.lineTo(14.5f, 15.0f);
                j.lineTo(12.5f, 15.0f);
                j.lineTo(12.083689f, 7.5063977f);
                j.cubicTo(12.037581f, 6.6764627f, 12.671573f, 6.0f, 13.5f, 6.0f);
                j.close();
                j.moveTo(13.5f, 20.0f);
                j.cubicTo(12.671573f, 20.0f, 12.0f, 19.328426f, 12.0f, 18.5f);
                j.cubicTo(12.0f, 17.671574f, 12.671573f, 17.0f, 13.5f, 17.0f);
                j.cubicTo(14.328427f, 17.0f, 15.0f, 17.671574f, 15.0f, 18.5f);
                j.cubicTo(15.0f, 19.328426f, 14.328427f, 20.0f, 13.5f, 20.0f);
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
