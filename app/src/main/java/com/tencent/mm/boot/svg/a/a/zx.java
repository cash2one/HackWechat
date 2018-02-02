package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.bs;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class zx extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                canvas.saveLayerAlpha(null, bs.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(90.0f, 180.0f);
                j.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                j.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                j.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                j.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                j.close();
                j.moveTo(103.76728f, 117.98263f);
                j.cubicTo(100.49875f, 119.62946f, 96.85723f, 120.66371f, 93.0f, 120.93096f);
                j.lineTo(93.0f, 129.0f);
                j.lineTo(93.0f, 129.0f);
                j.lineTo(107.000854f, 129.0f);
                j.cubicTo(107.552666f, 129.0f, 108.0f, 129.44336f, 108.0f, 130.00937f);
                j.lineTo(108.0f, 131.99063f);
                j.cubicTo(108.0f, 132.5481f, 107.545074f, 133.0f, 107.000854f, 133.0f);
                j.lineTo(74.999146f, 133.0f);
                j.cubicTo(74.447334f, 133.0f, 74.0f, 132.55664f, 74.0f, 131.99063f);
                j.lineTo(74.0f, 130.00937f);
                j.cubicTo(74.0f, 129.4519f, 74.454926f, 129.0f, 74.999146f, 129.0f);
                j.lineTo(89.0f, 129.0f);
                j.lineTo(89.0f, 120.93096f);
                j.lineTo(89.0f, 120.93096f);
                j.cubicTo(74.46945f, 119.92421f, 63.0f, 108.032974f, 63.0f, 93.51188f);
                j.lineTo(63.0f, 88.99816f);
                j.cubicTo(63.0f, 88.45106f, 63.451874f, 88.0f, 64.009285f, 88.0f);
                j.lineTo(65.99039f, 88.0f);
                j.cubicTo(66.55636f, 88.0f, 66.99967f, 88.45177f, 66.99967f, 89.009056f);
                j.lineTo(66.99967f, 93.36467f);
                j.cubicTo(66.99967f, 106.95095f, 78.00566f, 117.0f, 91.0f, 117.0f);
                j.cubicTo(94.46276f, 117.0f, 97.784004f, 116.298294f, 100.79325f, 115.0086f);
                j.lineTo(103.76728f, 117.98263f);
                j.lineTo(103.76728f, 117.98263f);
                j.close();
                j.moveTo(112.10175f, 111.58026f);
                j.cubicTo(116.397675f, 106.74892f, 119.0f, 100.42874f, 119.0f, 93.51188f);
                j.lineTo(119.0f, 88.99816f);
                j.cubicTo(119.0f, 88.44689f, 118.556175f, 88.0f, 117.99989f, 88.0f);
                j.lineTo(115.99589f, 88.0f);
                j.cubicTo(115.44354f, 88.0f, 114.99578f, 88.45739f, 114.99578f, 89.009056f);
                j.lineTo(114.99578f, 93.36467f);
                j.cubicTo(114.99578f, 99.441376f, 112.848305f, 104.76214f, 109.33026f, 108.80877f);
                j.lineTo(112.10175f, 111.58026f);
                j.lineTo(112.10175f, 111.58026f);
                j.close();
                j.moveTo(103.92377f, 103.40227f);
                j.cubicTo(105.85821f, 100.75579f, 107.0f, 97.49277f, 107.0f, 93.96288f);
                j.lineTo(107.0f, 63.976562f);
                j.cubicTo(107.0f, 55.14248f, 99.836555f, 47.969723f, 91.0f, 47.969723f);
                j.cubicTo(82.1615f, 47.969723f, 75.0f, 55.13623f, 75.0f, 63.976562f);
                j.lineTo(75.0f, 74.47851f);
                j.lineTo(103.92377f, 103.40227f);
                j.lineTo(103.92377f, 103.40227f);
                j.close();
                j.moveTo(95.19794f, 109.413284f);
                j.cubicTo(93.86017f, 109.776115f, 92.452736f, 109.96972f, 91.0f, 109.96972f);
                j.cubicTo(82.163445f, 109.96972f, 75.0f, 102.79697f, 75.0f, 93.96288f);
                j.lineTo(75.0f, 89.21535f);
                j.lineTo(95.19794f, 109.413284f);
                j.lineTo(95.19794f, 109.413284f);
                j.close();
                j.moveTo(117.006836f, 126.44923f);
                j.lineTo(60.164734f, 69.60712f);
                j.lineTo(62.99316f, 66.778694f);
                j.lineTo(119.835266f, 123.6208f);
                j.lineTo(117.006836f, 126.44923f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
