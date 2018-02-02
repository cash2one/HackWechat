package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
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

public final class akv extends c {
    private final int height = e.CTRL_INDEX;
    private final int width = 111;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 111;
            case 1:
                return e.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix f = c.f(looper);
                float[] e = c.e(looper);
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
                a.setColor(-3223858);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 38.0f, 0.0f, 1.0f, 56.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(2.6086957f, 0.0f);
                j.lineTo(2.6086957f, 31.296522f);
                j.lineTo(0.0f, 31.296522f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(31.304348f, 0.0f);
                j.lineTo(31.304348f, 2.6080434f);
                j.lineTo(0.0f, 2.6080434f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(2.6086957f, 4.5479107f);
                j.lineTo(29.363997f, 31.296522f);
                j.lineTo(31.304348f, 29.356655f);
                j.lineTo(4.549048f, 2.6080434f);
                j.lineTo(2.6086957f, 2.6080434f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
