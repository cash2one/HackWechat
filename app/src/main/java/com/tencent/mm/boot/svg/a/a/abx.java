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

public final class abx extends c {
    private final int height = 73;
    private final int width = 68;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 68;
            case 1:
                return 73;
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
                canvas.saveLayerAlpha(null, bs.CTRL_INDEX, 4);
                i2 = c.a(i2, looper);
                i2.setColor(-12414890);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(19.8f, 13.5f);
                j.lineTo(7.014761f, 13.5f);
                j.cubicTo(5.1207285f, 13.5f, 3.6f, 15.027811f, 3.6f, 16.91246f);
                j.lineTo(3.6f, 29.7f);
                j.lineTo(7.2f, 29.7f);
                j.lineTo(7.2f, 20.517391f);
                j.cubicTo(7.2f, 18.630018f, 8.731914f, 17.1f, 10.622746f, 17.1f);
                j.lineTo(19.8f, 17.1f);
                j.lineTo(19.8f, 13.5f);
                j.close();
                j.moveTo(47.7f, 13.5f);
                j.lineTo(60.485237f, 13.5f);
                j.cubicTo(62.37116f, 13.5f, 63.9f, 15.027175f, 63.9f, 16.91246f);
                j.lineTo(63.9f, 29.7f);
                j.lineTo(60.3f, 29.7f);
                j.lineTo(60.3f, 20.517391f);
                j.cubicTo(60.3f, 18.629005f, 58.767586f, 17.1f, 56.877254f, 17.1f);
                j.lineTo(47.7f, 17.1f);
                j.lineTo(47.7f, 13.5f);
                j.close();
                j.moveTo(63.9f, 43.2f);
                j.lineTo(63.9f, 55.987537f);
                j.cubicTo(63.9f, 57.87219f, 62.379272f, 59.4f, 60.485237f, 59.4f);
                j.lineTo(47.7f, 59.4f);
                j.lineTo(47.7f, 55.8f);
                j.lineTo(56.877254f, 55.8f);
                j.cubicTo(58.768085f, 55.8f, 60.3f, 54.26998f, 60.3f, 52.38261f);
                j.lineTo(60.3f, 43.2f);
                j.lineTo(63.9f, 43.2f);
                j.close();
                j.moveTo(19.8f, 59.4f);
                j.lineTo(7.014761f, 59.4f);
                j.cubicTo(5.1288404f, 59.4f, 3.6f, 57.872826f, 3.6f, 55.987537f);
                j.lineTo(3.6f, 43.2f);
                j.lineTo(7.2f, 43.2f);
                j.lineTo(7.2f, 52.38261f);
                j.cubicTo(7.2f, 54.270996f, 8.732416f, 55.8f, 10.622746f, 55.8f);
                j.lineTo(19.8f, 55.8f);
                j.lineTo(19.8f, 59.4f);
                j.close();
                j.moveTo(20.108116f, 36.142143f);
                j.cubicTo(19.937948f, 35.946686f, 19.946568f, 35.64093f, 20.131533f, 35.45503f);
                j.lineTo(20.838032f, 34.74497f);
                j.cubicTo(21.021133f, 34.560947f, 21.341198f, 34.526764f, 21.565907f, 34.677326f);
                j.lineTo(28.990614f, 39.65209f);
                j.cubicTo(29.209509f, 39.79875f, 29.55232f, 39.78469f, 29.761065f, 39.61685f);
                j.lineTo(49.556328f, 23.700794f);
                j.cubicTo(49.76294f, 23.53467f, 50.077003f, 23.547306f, 50.261967f, 23.733206f);
                j.lineTo(50.968468f, 24.443266f);
                j.cubicTo(51.151566f, 24.627289f, 51.159294f, 24.928797f, 50.980556f, 25.12167f);
                j.cubicTo(50.980556f, 25.12167f, 44.03342f, 32.66838f, 40.34348f, 35.788235f);
                j.cubicTo(37.325737f, 39.566574f, 29.73397f, 46.481808f, 29.73397f, 46.481808f);
                j.cubicTo(29.54232f, 46.65754f, 29.251432f, 46.644333f, 29.07884f, 46.44609f);
                j.lineTo(20.108116f, 36.142143f);
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
