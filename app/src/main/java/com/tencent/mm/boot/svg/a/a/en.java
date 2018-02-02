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

public final class en extends c {
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
                Paint a = c.a(i2, looper);
                a.setColor(-8617594);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 57.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(64.0f, 39.599926f);
                j.lineTo(64.0f, 49.099926f);
                j.cubicTo(64.0f, 51.073624f, 62.65501f, 52.407425f, 61.0f, 52.099926f);
                j.lineTo(3.0f, 52.099926f);
                j.cubicTo(1.3414615f, 52.407425f, 0.0f, 51.07877f, 0.0f, 49.099926f);
                j.lineTo(0.0f, 5.0999255f);
                j.cubicTo(0.0f, 3.094035f, 1.3449905f, 1.760234f, 3.0f, 2.0999255f);
                j.lineTo(61.0f, 2.0999255f);
                j.cubicTo(62.65854f, 1.760234f, 64.0f, 3.0888903f, 64.0f, 5.0999255f);
                j.lineTo(64.0f, 14.099925f);
                j.lineTo(64.0f, 39.599926f);
                j.close();
                j.moveTo(70.0f, 35.62607f);
                j.cubicTo(77.765816f, 42.808117f, 88.73977f, 53.013004f, 90.0f, 54.099926f);
                j.cubicTo(91.91545f, 54.66846f, 94.0f, 53.152363f, 94.0f, 51.099926f);
                j.lineTo(94.0f, 3.0999255f);
                j.cubicTo(94.0f, 0.7384861f, 91.694824f, -0.35120907f, 90.0f, 0.09992552f);
                j.cubicTo(88.3209f, 1.3646963f, 77.58243f, 11.272879f, 70.0f, 17.971575f);
                j.lineTo(70.0f, 35.62607f);
                j.close();
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
