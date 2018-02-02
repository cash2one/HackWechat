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

public final class vy extends c {
    private final int height = 1334;
    private final int width = 750;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 750;
            case 1:
                return 1334;
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
                i3 = c.a(i2, looper);
                i3.setColor(-870400);
                canvas.save();
                i3 = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.0f);
                j.lineTo(750.0f, 0.0f);
                j.lineTo(750.0f, 1334.0f);
                j.lineTo(0.0f, 1334.0f);
                j.lineTo(0.0f, 0.0f);
                j.close();
                canvas.drawPath(j, i3);
                canvas.restore();
                i3 = c.a(i2, looper);
                i3.setColor(-877312);
                j = c.j(looper);
                j.moveTo(68.52344f, 1334.0f);
                j.lineTo(849.0469f, 377.4297f);
                j.lineTo(5.891446E-14f, 199.80469f);
                j.lineTo(0.0f, 1334.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.saveLayerAlpha(null, 69, 4);
                i3 = c.a(i3, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                i3 = c.a(i2, looper);
                i3.setColor(-748799);
                j = c.j(looper);
                j.moveTo(801.0469f, 102.0f);
                j.lineTo(-62.109375f, 375.08594f);
                j.lineTo(-62.109375f, 657.77344f);
                j.lineTo(785.65625f, 1323.5469f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.saveLayerAlpha(null, 39, 4);
                i3 = c.a(i3, looper);
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                i2 = c.a(i2, looper);
                i2.setColor(-25344);
                Path j2 = c.j(looper);
                j2.moveTo(-88.0f, 1217.8438f);
                j2.lineTo(903.0781f, 1441.7344f);
                j2.lineTo(855.39844f, 671.83594f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.saveLayerAlpha(null, 103, 4);
                i2 = c.a(i2, looper);
                WeChatSVGRenderC2Java.setFillType(j2, 2);
                canvas.drawPath(j2, i2);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
