package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetClipboardData;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ey extends c {
    private final int height = JsApiSetClipboardData.CTRL_INDEX;
    private final int width = JsApiSetClipboardData.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiSetClipboardData.CTRL_INDEX;
            case 1:
                return JsApiSetClipboardData.CTRL_INDEX;
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
                i3 = c.a(i2, looper);
                i3.setColor(-4079167);
                canvas.save();
                i3 = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(168.0f, 0.0f);
                j.lineTo(168.0f, 168.0f);
                j.lineTo(0.0f, 168.0f);
                j.lineTo(0.0f, 0.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                j.moveTo(3.0f, 3.0f);
                j.lineTo(3.0f, 165.0f);
                j.lineTo(165.0f, 165.0f);
                j.lineTo(165.0f, 3.0f);
                j.lineTo(3.0f, 3.0f);
                j.lineTo(3.0f, 3.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-6974059);
                e = c.a(e, 1.0f, 0.0f, 33.0f, 0.0f, 1.0f, 33.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j2 = c.j(looper);
                j2.moveTo(46.0f, 0.0f);
                j2.lineTo(56.0f, 0.0f);
                j2.lineTo(56.0f, 46.0f);
                j2.lineTo(102.0f, 46.0f);
                j2.lineTo(102.0f, 56.0f);
                j2.lineTo(56.0f, 56.0f);
                j2.lineTo(56.0f, 102.0f);
                j2.lineTo(46.0f, 102.0f);
                j2.lineTo(46.0f, 56.0f);
                j2.lineTo(0.0f, 56.0f);
                j2.lineTo(0.0f, 46.0f);
                j2.lineTo(46.0f, 46.0f);
                j2.lineTo(46.0f, 0.0f);
                j2.lineTo(46.0f, 0.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
