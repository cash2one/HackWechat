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

public final class uu extends c {
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-16139513);
                Path j = c.j(looper);
                j.moveTo(0.0f, 1.9916575f);
                j.cubicTo(0.0f, 0.89169544f, 0.89889205f, 0.0f, 1.9916575f, 0.0f);
                j.lineTo(43.008343f, 0.0f);
                j.cubicTo(44.108303f, 0.0f, 45.0f, 0.89889205f, 45.0f, 1.9916575f);
                j.lineTo(45.0f, 43.008343f);
                j.cubicTo(45.0f, 44.108303f, 44.10111f, 45.0f, 43.008343f, 45.0f);
                j.lineTo(1.9916575f, 45.0f);
                j.cubicTo(0.89169544f, 45.0f, 0.0f, 44.10111f, 0.0f, 43.008343f);
                j.lineTo(0.0f, 1.9916575f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                i2 = c.a(i2, looper);
                i2.setColor(-1);
                j = c.j(looper);
                j.moveTo(31.0f, 29.0f);
                j.lineTo(27.0f, 29.0f);
                j.lineTo(27.0f, 27.0f);
                j.lineTo(31.0f, 27.0f);
                j.lineTo(31.0f, 23.0f);
                j.lineTo(33.0f, 23.0f);
                j.lineTo(33.0f, 27.0f);
                j.lineTo(37.0f, 27.0f);
                j.lineTo(37.0f, 29.0f);
                j.lineTo(33.0f, 29.0f);
                j.lineTo(33.0f, 33.0f);
                j.lineTo(31.0f, 33.0f);
                j.lineTo(31.0f, 29.0f);
                j.close();
                j.moveTo(25.730555f, 35.0f);
                j.lineTo(6.130553f, 35.0f);
                j.cubicTo(5.440284f, 35.0f, 5.0f, 34.490055f, 5.0f, 33.845936f);
                j.lineTo(5.0f, 32.11464f);
                j.cubicTo(5.0f, 30.729998f, 7.1157656f, 29.698303f, 11.782929f, 27.036438f);
                j.cubicTo(13.08324f, 26.29513f, 15.77804f, 25.127686f, 14.031632f, 22.438671f);
                j.cubicTo(12.713493f, 20.408728f, 11.588755f, 19.536785f, 11.588755f, 16.113152f);
                j.cubicTo(11.588755f, 12.560062f, 14.101395f, 9.0f, 18.0f, 9.0f);
                j.cubicTo(21.898605f, 9.0f, 24.411245f, 12.560062f, 24.411245f, 16.113152f);
                j.cubicTo(24.411245f, 19.536785f, 23.286507f, 20.408728f, 21.968369f, 22.438671f);
                j.cubicTo(20.814322f, 24.215603f, 21.599625f, 25.328108f, 22.640343f, 26.092281f);
                j.cubicTo(22.548069f, 26.631046f, 22.5f, 27.184908f, 22.5f, 27.75f);
                j.cubicTo(22.5f, 29.225077f, 22.827538f, 30.623629f, 23.413855f, 31.876896f);
                j.cubicTo(23.971626f, 33.069145f, 24.763592f, 34.129913f, 25.730555f, 35.0f);
                j.close();
                j.moveTo(24.0f, 28.125736f);
                j.cubicTo(24.0f, 28.536228f, 24.030445f, 28.939606f, 24.089201f, 29.333736f);
                j.cubicTo(24.672707f, 33.24789f, 28.048365f, 36.25f, 32.125f, 36.25f);
                j.cubicTo(36.612865f, 36.25f, 40.25f, 32.612865f, 40.25f, 28.125736f);
                j.cubicTo(40.25f, 23.637873f, 36.612865f, 20.0f, 32.125f, 20.0f);
                j.cubicTo(27.637873f, 20.0f, 24.0f, 23.637873f, 24.0f, 28.125736f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
