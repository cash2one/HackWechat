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

public final class xp extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(19.0f, 17.0f);
                j.cubicTo(26.126581f, 16.871616f, 33.05786f, 17.050594f, 40.0f, 17.0f);
                j.cubicTo(41.500694f, 16.901445f, 42.11725f, 18.681273f, 42.0f, 20.0f);
                j.cubicTo(41.888527f, 26.516483f, 42.18686f, 33.128685f, 42.0f, 40.0f);
                j.cubicTo(41.52058f, 39.96958f, 40.973637f, 40.516457f, 41.0f, 41.0f);
                j.cubicTo(33.833527f, 41.142876f, 26.932081f, 40.963898f, 20.0f, 41.0f);
                j.cubicTo(18.459415f, 41.04344f, 17.822971f, 39.293446f, 18.0f, 38.0f);
                j.cubicTo(18.121304f, 31.388632f, 17.84286f, 24.766487f, 18.0f, 18.0f);
                j.cubicTo(18.44947f, 17.925592f, 18.966581f, 17.428434f, 19.0f, 17.0f);
                j.lineTo(19.0f, 17.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(56.0f, 17.0f);
                j.cubicTo(62.90879f, 16.858274f, 69.524796f, 17.087189f, 76.0f, 17.0f);
                j.cubicTo(77.37446f, 16.828415f, 79.09561f, 17.495256f, 79.0f, 19.0f);
                j.cubicTo(79.04587f, 25.358007f, 78.95633f, 31.707926f, 79.0f, 38.0f);
                j.cubicTo(79.155304f, 39.321857f, 78.55837f, 41.07356f, 77.0f, 41.0f);
                j.cubicTo(70.64902f, 41.08351f, 64.32153f, 40.954124f, 58.0f, 41.0f);
                j.cubicTo(56.73054f, 41.103416f, 54.919846f, 40.575916f, 55.0f, 39.0f);
                j.cubicTo(55.04918f, 32.016464f, 54.840252f, 25.049469f, 55.0f, 18.0f);
                j.cubicTo(55.49688f, 17.883417f, 56.044067f, 17.395727f, 56.0f, 17.0f);
                j.lineTo(56.0f, 17.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(19.0f, 54.0f);
                j.cubicTo(26.09006f, 53.835354f, 33.019386f, 54.054123f, 40.0f, 54.0f);
                j.cubicTo(41.53171f, 53.92485f, 42.129066f, 55.704838f, 42.0f, 57.0f);
                j.cubicTo(41.94986f, 63.341885f, 42.08924f, 69.69615f, 42.0f, 76.0f);
                j.cubicTo(42.01955f, 77.57185f, 40.317085f, 78.168495f, 39.0f, 78.0f);
                j.cubicTo(32.42203f, 77.89006f, 25.77147f, 78.158554f, 19.0f, 78.0f);
                j.cubicTo(17.448309f, 76.80616f, 18.214916f, 74.61846f, 18.0f, 73.0f);
                j.cubicTo(18.13527f, 67.08086f, 17.826635f, 61.134304f, 18.0f, 55.0f);
                j.cubicTo(18.42399f, 54.96898f, 18.951654f, 54.48172f, 19.0f, 54.0f);
                j.lineTo(19.0f, 54.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(56.0f, 54.0f);
                j.cubicTo(63.38297f, 53.909332f, 70.59286f, 53.929207f, 78.0f, 54.0f);
                j.cubicTo(78.01159f, 54.505596f, 78.5486f, 55.032295f, 79.0f, 55.0f);
                j.cubicTo(79.195f, 61.193676f, 78.84694f, 67.12649f, 79.0f, 73.0f);
                j.cubicTo(78.77733f, 74.6394f, 79.54307f, 76.8257f, 78.0f, 78.0f);
                j.cubicTo(71.219376f, 78.15735f, 64.576324f, 77.88903f, 58.0f, 78.0f);
                j.cubicTo(56.67031f, 78.17722f, 54.959827f, 77.53127f, 55.0f, 76.0f);
                j.cubicTo(55.049328f, 69.104095f, 54.850433f, 62.187447f, 55.0f, 55.0f);
                j.cubicTo(55.467007f, 55.042233f, 55.984127f, 54.515533f, 56.0f, 54.0f);
                j.lineTo(56.0f, 54.0f);
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
