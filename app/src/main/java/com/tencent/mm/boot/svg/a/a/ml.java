package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetAudioState;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ml extends c {
    private final int height = JsApiSetAudioState.CTRL_INDEX;
    private final int width = 378;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return JsApiSetAudioState.CTRL_INDEX;
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
                a.setColor(-13092808);
                Path j = c.j(looper);
                j.moveTo(373.0f, 236.0006f);
                j.cubicTo(373.0f, 242.0656f, 368.063f, 247.0006f, 361.993f, 247.0006f);
                j.lineTo(16.007f, 247.0006f);
                j.cubicTo(9.938f, 247.0006f, 5.0f, 242.0656f, 5.0f, 236.0006f);
                j.lineTo(5.0f, 15.9996f);
                j.cubicTo(5.0f, 9.9346f, 9.938f, 5.0006f, 16.007f, 5.0006f);
                j.lineTo(361.993f, 5.0006f);
                j.cubicTo(368.063f, 5.0006f, 373.0f, 9.9346f, 373.0f, 15.9996f);
                j.lineTo(373.0f, 236.0006f);
                j.lineTo(373.0f, 236.0006f);
                j.close();
                j.moveTo(361.993f, 1.9996f);
                j.lineTo(16.007f, 1.9996f);
                j.cubicTo(8.276f, 1.9996f, 2.0f, 8.2676f, 2.0f, 15.9996f);
                j.lineTo(2.0f, 236.0006f);
                j.cubicTo(2.0f, 243.7296f, 8.271f, 249.9996f, 16.007f, 249.9996f);
                j.lineTo(361.993f, 249.9996f);
                j.cubicTo(369.724f, 249.9996f, 376.0f, 243.7326f, 376.0f, 236.0006f);
                j.lineTo(376.0f, 15.9996f);
                j.cubicTo(376.0f, 8.2696f, 369.729f, 1.9996f, 361.993f, 1.9996f);
                j.lineTo(361.993f, 1.9996f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-13092808);
                Path j2 = c.j(looper);
                j2.moveTo(243.0f, 288.0001f);
                j2.lineTo(134.0f, 288.0001f);
                j2.lineTo(134.0f, 286.5041f);
                j2.lineTo(155.712f, 282.5561f);
                j2.lineTo(159.658f, 250.0001f);
                j2.lineTo(217.342f, 250.0001f);
                j2.lineTo(221.288f, 282.5561f);
                j2.lineTo(243.0f, 286.5041f);
                j2.lineTo(243.0f, 288.0001f);
                j2.close();
                j2.moveTo(220.0f, 247.0001f);
                j2.lineTo(157.0f, 247.0001f);
                j2.lineTo(153.0f, 280.0001f);
                j2.lineTo(131.0f, 284.0001f);
                j2.lineTo(131.0f, 291.0001f);
                j2.lineTo(246.0f, 291.0001f);
                j2.lineTo(246.0f, 284.0001f);
                j2.lineTo(224.0f, 280.0001f);
                j2.lineTo(220.0f, 247.0001f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-13092808);
                j2 = c.j(looper);
                j2.moveTo(4.0f, 201.0f);
                j2.lineTo(376.0f, 201.0f);
                j2.lineTo(376.0f, 198.0f);
                j2.lineTo(4.0f, 198.0f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i3);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
