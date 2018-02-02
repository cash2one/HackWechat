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

public final class agf extends c {
    private final int height = 330;
    private final int width = 400;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 400;
            case 1:
                return 330;
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
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-15132133);
                e = c.a(e, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 11.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.025026262f, 19.949099f);
                j.cubicTo(-0.23524687f, 9.319578f, 9.284743f, -0.23998915f, 19.93592f, 0.029998643f);
                j.cubicTo(68.396774f, -0.019999096f, 116.85763f, 0.039998192f, 165.31848f, 0.0f);
                j.cubicTo(171.28474f, 8.539614f, 176.9607f, 17.299217f, 182.73676f, 25.978825f);
                j.cubicTo(129.51091f, 26.06882f, 76.28505f, 25.958826f, 23.059198f, 26.028822f);
                j.cubicTo(23.009146f, 87.47604f, 23.019156f, 148.92326f, 23.049187f, 210.37048f);
                j.cubicTo(34.921646f, 193.73123f, 48.996414f, 178.78192f, 64.102264f, 165.05254f);
                j.cubicTo(77.186f, 153.22307f, 91.060555f, 142.20357f, 106.04628f, 132.88399f);
                j.cubicTo(114.23488f, 127.914215f, 122.743805f, 123.184425f, 132.06358f, 120.68454f);
                j.cubicTo(140.48242f, 118.464645f, 149.3217f, 120.68454f, 157.10986f, 124.07439f);
                j.cubicTo(168.70203f, 129.39415f, 178.5924f, 137.73376f, 187.58185f, 146.65337f);
                j.cubicTo(190.42484f, 149.47324f, 193.28783f, 152.34311f, 195.4501f, 155.75296f);
                j.cubicTo(206.52171f, 172.4922f, 217.79355f, 189.10144f, 228.81511f, 205.87068f);
                j.cubicTo(217.61336f, 215.95023f, 206.15134f, 225.73979f, 194.9696f, 235.84933f);
                j.cubicTo(210.8763f, 259.95825f, 227.06328f, 283.88715f, 243.0f, 307.97607f);
                j.cubicTo(168.66199f, 308.01608f, 94.33399f, 307.99606f, 19.995983f, 307.98608f);
                j.cubicTo(9.344807f, 308.26605f, -0.22523636f, 298.7265f, 0.03503677f, 288.08698f);
                j.cubicTo(-0.015015758f, 198.71101f, -0.0050052525f, 109.33505f, 0.025026262f, 19.949099f);
                j.lineTo(0.025026262f, 19.949099f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(353.92917f, 0.018368687f);
                j.cubicTo(358.48602f, 0.04836348f, 363.25314f, -0.36156538f, 367.5496f, 1.5181084f);
                j.cubicTo(374.93066f, 4.4376016f, 380.09842f, 12.086274f, 379.9682f, 20.034895f);
                j.cubicTo(379.99826f, 107.35974f, 379.9582f, 194.69458f, 379.98825f, 282.01944f);
                j.cubicTo(379.93817f, 286.2787f, 380.33878f, 290.70792f, 378.78644f, 294.77722f);
                j.cubicTo(376.40286f, 301.56604f, 370.05334f, 306.78513f, 362.90262f, 307.74496f);
                j.cubicTo(359.6077f, 308.1249f, 356.29272f, 307.96494f, 352.99777f, 307.9749f);
                j.cubicTo(321.55066f, 307.96494f, 290.11353f, 307.98492f, 258.6664f, 307.96494f);
                j.cubicTo(242.48215f, 284.0091f, 226.44812f, 259.94327f, 210.47418f, 235.84744f);
                j.cubicTo(221.64091f, 225.7092f, 233.15817f, 215.96089f, 244.33493f, 205.84265f);
                j.cubicTo(240.80965f, 200.27362f, 236.92381f, 194.93454f, 233.44861f, 189.33551f);
                j.cubicTo(244.80563f, 180.1571f, 256.76355f, 171.5486f, 269.8632f, 164.98975f);
                j.cubicTo(276.6634f, 161.7203f, 284.17462f, 158.63084f, 291.8762f, 159.9906f);
                j.cubicTo(302.62228f, 161.67032f, 312.06644f, 167.71927f, 320.33884f, 174.4881f);
                j.cubicTo(334.82056f, 186.556f, 346.49805f, 201.58339f, 356.92368f, 217.18068f);
                j.cubicTo(356.9537f, 153.47174f, 356.96375f, 89.75279f, 356.91367f, 26.043852f);
                j.cubicTo(304.46506f, 25.983862f, 252.01643f, 26.063848f, 199.55782f, 26.003859f);
                j.cubicTo(198.15572f, 26.28381f, 197.5448f, 24.79407f, 196.84375f, 23.92422f);
                j.cubicTo(191.63594f, 15.925608f, 186.20781f, 8.066972f, 181.0f, 0.058361746f);
                j.cubicTo(238.63638f, -0.021624373f, 296.28278f, 0.058361746f, 353.92917f, 0.018368687f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
