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

public final class jy extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                canvas.saveLayerAlpha(null, 38, 4);
                Paint a = c.a(i2, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(18.0743f, 25.9257f);
                j.cubicTo(21.81657f, 29.66797f, 25.362413f, 31.423225f, 26.673681f, 31.320438f);
                j.cubicTo(27.98495f, 31.217651f, 31.250372f, 28.972013f, 32.791916f, 29.001904f);
                j.cubicTo(33.5328f, 29.01627f, 38.37422f, 32.290524f, 38.960274f, 32.669083f);
                j.cubicTo(39.54633f, 33.047638f, 40.089733f, 33.48984f, 39.987553f, 34.049404f);
                j.cubicTo(39.885376f, 34.608967f, 37.757626f, 40.772552f, 32.325485f, 39.919037f);
                j.cubicTo(26.893343f, 39.06552f, 19.320179f, 33.20958f, 15.004804f, 28.995195f);
                j.lineTo(18.0743f, 25.9257f);
                j.lineTo(18.0743f, 25.9257f);
                j.close();
                j.moveTo(18.0743f, 25.9257f);
                j.cubicTo(14.33203f, 22.18343f, 12.576774f, 18.637587f, 12.679562f, 17.326319f);
                j.cubicTo(12.782349f, 16.01505f, 15.027987f, 12.749629f, 14.998096f, 11.208082f);
                j.cubicTo(14.983731f, 10.467202f, 11.709476f, 5.625779f, 11.330918f, 5.0397243f);
                j.cubicTo(10.952361f, 4.45367f, 10.510159f, 3.9102678f, 9.950595f, 4.012446f);
                j.cubicTo(9.391031f, 4.1146235f, 3.2274485f, 6.2423735f, 4.080963f, 11.674515f);
                j.cubicTo(4.9344783f, 17.106657f, 10.790419f, 24.679821f, 15.004804f, 28.995195f);
                j.lineTo(18.0743f, 25.9257f);
                j.lineTo(18.0743f, 25.9257f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(39.25f, 16.954916f);
                j.cubicTo(39.652576f, 17.12634f, 40.0f, 16.78943f, 40.0f, 16.273945f);
                j.lineTo(40.0f, 7.7189007f);
                j.cubicTo(40.0f, 7.1419024f, 39.615803f, 6.899748f, 39.25f, 7.03793f);
                j.cubicTo(39.033016f, 7.2903256f, 36.0f, 10.012693f, 36.0f, 10.012693f);
                j.lineTo(36.0f, 13.939582f);
                j.cubicTo(36.0f, 13.939582f, 39.103306f, 16.747684f, 39.25f, 16.954916f);
                j.close();
                j.moveTo(22.0f, 8.47057f);
                j.cubicTo(22.0f, 8.210681f, 22.25619f, 8.0f, 22.570713f, 8.0f);
                j.lineTo(33.429287f, 8.0f);
                j.cubicTo(33.744484f, 8.0f, 34.0f, 8.209868f, 34.0f, 8.47057f);
                j.lineTo(34.0f, 15.52943f);
                j.cubicTo(34.0f, 15.789319f, 33.743813f, 16.0f, 33.429287f, 16.0f);
                j.lineTo(22.570713f, 16.0f);
                j.cubicTo(22.255516f, 16.0f, 22.0f, 15.790132f, 22.0f, 15.52943f);
                j.lineTo(22.0f, 8.47057f);
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
