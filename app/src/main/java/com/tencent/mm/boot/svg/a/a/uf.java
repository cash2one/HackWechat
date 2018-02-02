package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class uf extends c {
    private final int height = ac.CTRL_BYTE;
    private final int width = 240;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return ac.CTRL_BYTE;
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
                i2.setColor(-7829368);
                canvas.save();
                Paint a = c.a(i2, looper);
                Path j = c.j(looper);
                j.moveTo(203.52f, 57.660694f);
                j.lineTo(203.52f, 15.384615f);
                j.lineTo(15.36f, 15.384615f);
                j.lineTo(15.36f, 105.37835f);
                j.lineTo(74.236595f, 50.650925f);
                j.lineTo(125.95681f, 97.89139f);
                j.cubicTo(122.740204f, 105.88419f, 120.96f, 114.66317f, 120.96f, 123.90788f);
                j.cubicTo(120.96f, 141.31677f, 127.86343f, 157.30098f, 139.04478f, 169.23077f);
                j.lineTo(11.193079f, 169.23077f);
                j.cubicTo(5.0091143f, 169.23077f, 0.0f, 164.20079f, 0.0f, 157.996f);
                j.lineTo(0.0f, 11.234769f);
                j.cubicTo(0.0f, 5.018827f, 5.0113125f, 0.0f, 11.193079f, 0.0f);
                j.lineTo(207.68692f, 0.0f);
                j.cubicTo(213.87088f, 0.0f, 218.88f, 5.0299807f, 218.88f, 11.234769f);
                j.lineTo(218.88f, 63.36721f);
                j.cubicTo(214.07797f, 60.88269f, 208.93094f, 58.95344f, 203.52f, 57.660694f);
                j.close();
                j.moveTo(240.0f, 123.71794f);
                j.cubicTo(240.0f, 151.75385f, 216.79105f, 175.0f, 187.52f, 175.0f);
                j.cubicTo(159.52896f, 175.0f, 136.32f, 151.75385f, 136.32f, 123.71794f);
                j.cubicTo(136.32f, 94.4f, 159.52896f, 71.15385f, 187.52f, 71.15385f);
                j.cubicTo(216.79105f, 71.15385f, 240.0f, 94.4f, 240.0f, 123.71794f);
                j.close();
                j.moveTo(185.67625f, 92.14744f);
                j.cubicTo(185.58711f, 92.14744f, 185.49799f, 92.15041f, 185.40904f, 92.15637f);
                j.cubicTo(183.20485f, 92.30395f, 181.53761f, 94.210434f, 181.68518f, 96.41464f);
                j.lineTo(183.95256f, 130.28104f);
                j.cubicTo(184.02289f, 131.33139f, 184.89539f, 132.14743f, 185.9481f, 132.14743f);
                j.lineTo(191.13371f, 132.14743f);
                j.cubicTo(192.18643f, 132.14743f, 193.05893f, 131.33139f, 193.12926f, 130.28104f);
                j.lineTo(195.39664f, 96.41464f);
                j.cubicTo(195.40259f, 96.3257f, 195.40556f, 96.23658f, 195.40556f, 96.14744f);
                j.cubicTo(195.40556f, 93.93829f, 193.6147f, 92.14744f, 191.40556f, 92.14744f);
                j.lineTo(185.67625f, 92.14744f);
                j.close();
                j.moveTo(188.16f, 155.76923f);
                j.cubicTo(192.40155f, 155.76923f, 195.84f, 152.32527f, 195.84f, 148.07692f);
                j.cubicTo(195.84f, 143.82858f, 192.40155f, 140.38461f, 188.16f, 140.38461f);
                j.cubicTo(183.91846f, 140.38461f, 180.48f, 143.82858f, 180.48f, 148.07692f);
                j.cubicTo(180.48f, 152.32527f, 183.91846f, 155.76923f, 188.16f, 155.76923f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 1);
                canvas.drawPath(j, a);
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
