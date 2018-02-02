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

public final class kb extends c {
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
                a.setColor(-1);
                e = c.a(e, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 27.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(2.388248f, 1.4991292f);
                j.cubicTo(3.7864833f, 0.7005225f, 5.52429f, 1.1497388f, 7.062349f, 1.0f);
                j.cubicTo(20.05595f, 1.0798607f, 33.04955f, 0.9301219f, 46.04315f, 1.0698781f);
                j.cubicTo(48.050617f, 0.9401045f, 49.239117f, 3.1362731f, 48.959473f, 4.913173f);
                j.cubicTo(48.959473f, 15.664417f, 48.96946f, 26.41566f, 48.949482f, 37.15692f);
                j.cubicTo(49.22913f, 38.903873f, 48.000683f, 41.020184f, 46.063126f, 40.90039f);
                j.cubicTo(32.36042f, 41.020184f, 18.647728f, 40.920357f, 4.945021f, 40.950302f);
                j.cubicTo(3.1672647f, 41.259766f, 0.98002523f, 40.101784f, 1.0798992f, 38.095284f);
                j.cubicTo(0.9300882f, 27.403936f, 1.0798992f, 16.702606f, 1.0f, 6.001275f);
                j.cubicTo(1.049937f, 4.434009f, 0.7902647f, 2.4275095f, 2.388248f, 1.4991292f);
                j.lineTo(2.388248f, 1.4991292f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(52.016293f, 14.441051f);
                j.cubicTo(57.033634f, 10.007826f, 61.711834f, 5.170664f, 66.958595f, 1.0f);
                j.cubicTo(68.434875f, 3.0297904f, 67.87628f, 5.604898f, 67.97603f, 7.9477406f);
                j.cubicTo(67.84636f, 18.36935f, 68.1855f, 28.821257f, 67.81644f, 39.23277f);
                j.cubicTo(67.596985f, 39.667004f, 67.1581f, 40.555668f, 66.93865f, 41.0f);
                j.cubicTo(61.711834f, 36.87983f, 57.12341f, 32.002274f, 52.066166f, 27.670033f);
                j.cubicTo(51.956444f, 23.257006f, 52.016293f, 18.854076f, 52.016293f, 14.441051f);
                j.lineTo(52.016293f, 14.441051f);
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
