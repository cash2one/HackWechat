package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiDestroyInstanceAudio;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class afh extends c {
    private final int height = JsApiDestroyInstanceAudio.CTRL_INDEX;
    private final int width = JsApiDestroyInstanceAudio.CTRL_INDEX;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return JsApiDestroyInstanceAudio.CTRL_INDEX;
            case 1:
                return JsApiDestroyInstanceAudio.CTRL_INDEX;
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
                a.setColor(-3833595);
                Path j = c.j(looper);
                j.moveTo(274.5553f, 275.0f);
                j.cubicTo(245.1193f, 272.369f, 198.0823f, 270.665f, 145.0633f, 270.665f);
                j.cubicTo(92.0443f, 270.665f, 45.0103f, 272.369f, 15.5753f, 275.0f);
                j.lineTo(15.0003f, 275.0f);
                j.cubicTo(17.6523f, 245.596f, 19.3733f, 198.364f, 19.3733f, 145.1f);
                j.cubicTo(19.3733f, 91.835f, 17.6523f, 44.606f, 15.0003f, 15.202f);
                j.lineTo(15.0003f, 15.0f);
                j.cubicTo(44.3963f, 17.66f, 91.7033f, 19.386f, 145.0633f, 19.386f);
                j.cubicTo(198.3403f, 19.386f, 245.5833f, 17.665f, 274.9893f, 15.013f);
                j.cubicTo(272.3353f, 44.414f, 270.6143f, 91.664f, 270.6143f, 144.951f);
                j.cubicTo(270.6143f, 198.306f, 272.3403f, 245.607f, 275.0003f, 275.0f);
                j.lineTo(274.5553f, 275.0f);
                j.close();
                j.moveTo(285.1083f, 144.945f);
                j.cubicTo(285.1083f, 85.51f, 287.0283f, 32.808f, 289.9883f, 0.014f);
                j.cubicTo(257.1893f, 2.973f, 204.4943f, 4.892f, 145.0703f, 4.892f);
                j.cubicTo(85.5533f, 4.892f, 32.7883f, 2.966f, 3.0E-4f, 0.0f);
                j.lineTo(3.0E-4f, 0.225f);
                j.cubicTo(2.9583f, 33.022f, 4.8773f, 85.7f, 4.8773f, 145.112f);
                j.cubicTo(4.8773f, 204.522f, 2.9583f, 257.203f, 3.0E-4f, 290.0f);
                j.lineTo(0.6413f, 290.0f);
                j.cubicTo(33.4733f, 287.066f, 85.9343f, 285.165f, 145.0703f, 285.165f);
                j.cubicTo(204.2073f, 285.165f, 256.6723f, 287.066f, 289.5043f, 290.0f);
                j.lineTo(290.0003f, 290.0f);
                j.cubicTo(287.0333f, 257.215f, 285.1083f, 204.456f, 285.1083f, 144.945f);
                j.lineTo(285.1083f, 144.945f);
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
