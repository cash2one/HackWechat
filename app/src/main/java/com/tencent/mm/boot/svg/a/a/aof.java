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

public final class aof extends c {
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
                a.setColor(-12863723);
                e = c.a(e, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 18.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(20.389967f, 3.894499f);
                j.cubicTo(25.58415f, -1.7899388f, 35.671696f, -1.1471756f, 40.12385f, 5.139853f);
                j.cubicTo(45.819405f, 12.8128395f, 43.142094f, 23.930635f, 36.814816f, 30.378355f);
                j.cubicTo(35.431038f, 31.493147f, 34.297943f, 33.853294f, 36.082817f, 35.178993f);
                j.cubicTo(43.28248f, 39.40717f, 51.224163f, 43.20349f, 56.35818f, 50.052937f);
                j.cubicTo(58.89511f, 53.22658f, 58.082893f, 57.545147f, 56.659004f, 61.0f);
                j.cubicTo(38.51947f, 60.879482f, 20.369913f, 60.96987f, 2.2303803f, 60.959827f);
                j.cubicTo(1.0170672f, 57.545147f, 0.104575485f, 53.427444f, 2.4910922f, 50.293976f);
                j.cubicTo(7.5248375f, 43.32401f, 15.596879f, 39.668293f, 22.706291f, 35.289467f);
                j.cubicTo(24.63155f, 33.93364f, 23.418236f, 31.483105f, 22.044485f, 30.257837f);
                j.cubicTo(15.677098f, 23.338089f, 13.631513f, 11.226018f, 20.389967f, 3.894499f);
                j.lineTo(20.389967f, 3.894499f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(49.614113f, 20.012203f);
                j.cubicTo(57.72848f, 20.052027f, 65.83278f, 19.922604f, 73.94714f, 20.081894f);
                j.cubicTo(74.01762f, 21.694714f, 74.01762f, 23.307535f, 73.94714f, 24.920355f);
                j.cubicTo(65.63143f, 25.06969f, 57.315716f, 24.950222f, 49.0f, 25.0f);
                j.cubicTo(49.231552f, 23.3374f, 49.422832f, 21.674803f, 49.614113f, 20.012203f);
                j.lineTo(49.614113f, 20.012203f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(45.0f, 33.156006f);
                j.cubicTo(54.639053f, 32.909058f, 64.29819f, 33.007835f, 73.94729f, 33.096737f);
                j.cubicTo(74.01757f, 34.69697f, 74.01757f, 36.297203f, 73.94729f, 37.897438f);
                j.cubicTo(66.92885f, 37.92707f, 59.90037f, 38.154263f, 52.902016f, 37.818413f);
                j.cubicTo(50.191032f, 36.40586f, 47.23907f, 35.269894f, 45.0f, 33.156006f);
                j.lineTo(45.0f, 33.156006f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(62.0f, 46.0f);
                j.cubicTo(65.97941f, 46.00998f, 69.958824f, 45.98004f, 73.93823f, 46.07984f);
                j.cubicTo(74.01883f, 47.696606f, 74.01883f, 49.313374f, 73.9483f, 50.93014f);
                j.cubicTo(70.70433f, 51.02994f, 67.46036f, 50.99002f, 64.20631f, 51.0f);
                j.cubicTo(63.541393f, 49.303394f, 62.805958f, 47.636726f, 62.0f, 46.0f);
                j.lineTo(62.0f, 46.0f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
