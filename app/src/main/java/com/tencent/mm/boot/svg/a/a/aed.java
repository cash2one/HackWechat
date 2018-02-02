package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aed extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                i3.setColor(-6710887);
                canvas.save();
                Paint a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(19.74f, 0.0f);
                j.lineTo(22.04f, 0.0f);
                j.cubicTo(32.38f, 0.39f, 41.32f, 9.17f, 42.0f, 19.47f);
                j.lineTo(42.0f, 22.2f);
                j.cubicTo(41.54f, 32.57f, 32.61f, 41.47f, 22.26f, 42.0f);
                j.lineTo(19.95f, 42.0f);
                j.cubicTo(9.62f, 41.6f, 0.68f, 32.83f, 0.0f, 22.53f);
                j.lineTo(0.0f, 19.8f);
                j.cubicTo(0.47f, 9.43f, 9.4f, 0.53f, 19.74f, 0.0f);
                j.lineTo(19.74f, 0.0f);
                j.close();
                j.moveTo(20.87298f, 6.5409007f);
                j.cubicTo(18.624437f, 7.68438f, 18.225163f, 11.434167f, 20.64182f, 12.587948f);
                j.cubicTo(23.153044f, 14.081682f, 26.683468f, 11.238437f, 25.884918f, 8.477604f);
                j.cubicTo(25.58021f, 6.2627573f, 22.638191f, 5.3150086f, 20.87298f, 6.5409007f);
                j.lineTo(20.87298f, 6.5409007f);
                j.close();
                j.moveTo(19.27931f, 14.632621f);
                j.cubicTo(15.97931f, 16.242502f, 13.227586f, 19.38227f, 13.0f, 23.052f);
                j.cubicTo(14.52069f, 20.922155f, 16.051723f, 18.732317f, 18.327587f, 17.262426f);
                j.cubicTo(17.903448f, 22.822016f, 15.637931f, 28.161621f, 15.875862f, 33.761208f);
                j.cubicTo(15.875862f, 35.551075f, 17.955172f, 36.421013f, 19.51724f, 35.80106f);
                j.cubicTo(23.8f, 34.391163f, 27.048275f, 30.541447f, 28.0f, 26.30176f);
                j.cubicTo(26.272413f, 28.121624f, 24.451725f, 29.891495f, 23.044828f, 31.97134f);
                j.cubicTo(22.082758f, 26.471746f, 25.268965f, 21.192137f, 24.524137f, 15.702541f);
                j.cubicTo(23.8f, 13.502704f, 20.975863f, 13.772684f, 19.27931f, 14.632621f);
                j.lineTo(19.27931f, 14.632621f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                float[] a2 = c.a(e, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 5.0f);
                f.reset();
                f.setValues(a2);
                canvas.concat(f);
                canvas.save();
                Paint a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(8.87298f, 1.5409008f);
                j.cubicTo(10.638191f, 0.3150088f, 13.58021f, 1.2627572f, 13.884919f, 3.4776042f);
                j.cubicTo(14.683467f, 6.2384367f, 11.153045f, 9.081682f, 8.641821f, 7.587948f);
                j.cubicTo(6.225163f, 6.4341674f, 6.624437f, 2.6843798f, 8.87298f, 1.5409008f);
                j.lineTo(8.87298f, 1.5409008f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                j = c.j(looper);
                j.moveTo(7.27931f, 9.632621f);
                j.cubicTo(8.9758625f, 8.772684f, 11.8f, 8.502704f, 12.5241375f, 10.702541f);
                j.cubicTo(13.268966f, 16.192137f, 10.082759f, 21.471746f, 11.044827f, 26.97134f);
                j.cubicTo(12.451724f, 24.891495f, 14.272414f, 23.121624f, 16.0f, 21.30176f);
                j.cubicTo(15.048276f, 25.541447f, 11.8f, 29.391163f, 7.5172415f, 30.801058f);
                j.cubicTo(5.9551725f, 31.421013f, 3.8758621f, 30.551077f, 3.8758621f, 28.76121f);
                j.cubicTo(3.637931f, 23.161621f, 5.903448f, 17.822016f, 6.327586f, 12.262426f);
                j.cubicTo(4.051724f, 13.732318f, 2.5206897f, 15.922156f, 1.0f, 18.052f);
                j.cubicTo(1.2275863f, 14.38227f, 3.9793103f, 11.242501f, 7.27931f, 9.632621f);
                j.lineTo(7.27931f, 9.632621f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
