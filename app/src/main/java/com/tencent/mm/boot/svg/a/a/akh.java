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

public final class akh extends c {
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
                i3 = c.a(i3, looper);
                i3.setStrokeWidth(1.0f);
                Paint a = c.a(i2, looper);
                Paint a2 = c.a(i3, looper);
                a.setColor(-3223858);
                a2.setColor(-3223858);
                a2.setStrokeWidth(0.6086956f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 55.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i2 = c.a(a, looper);
                i3 = c.a(a2, looper);
                Path j = c.j(looper);
                j.moveTo(32.162163f, 34.0f);
                j.lineTo(34.0f, 32.162163f);
                j.lineTo(1.8378378f, 0.0f);
                j.lineTo(0.0f, 1.8378378f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a2 = c.a(a2, looper);
                e = c.a(e, -1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j2 = c.j(looper);
                j2.moveTo(32.162163f, 34.0f);
                j2.lineTo(34.0f, 32.162163f);
                j2.lineTo(1.8378378f, 0.0f);
                j2.lineTo(0.0f, 1.8378378f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
