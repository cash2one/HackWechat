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
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class anl extends c {
    private final int height = 27;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 27;
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
                e = c.a(e, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, DownloadHelper.SAVE_FATOR);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                i3 = c.a(i2, looper);
                i3.setColor(-1);
                Path j = c.j(looper);
                j.moveTo(0.0f, 0.5f);
                j.lineTo(26.0f, 0.5f);
                j.lineTo(26.0f, 24.5f);
                j.lineTo(0.0f, 24.5f);
                j.lineTo(0.0f, 0.5f);
                j.close();
                j.moveTo(2.0f, 2.5f);
                j.lineTo(2.0f, 22.5f);
                j.lineTo(24.0f, 22.5f);
                j.lineTo(24.0f, 2.5f);
                j.lineTo(2.0f, 2.5f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, i3);
                canvas.restore();
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 27.363636f, 0.0f, 1.0f, 1.090909f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.restore();
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-1);
                Path j2 = c.j(looper);
                j2.moveTo(31.008236f, 11.565939f);
                j2.lineTo(31.002834f, 13.579968f);
                j2.lineTo(39.986187f, 19.714403f);
                j2.lineTo(39.997097f, 5.3252935f);
                j2.lineTo(31.008236f, 11.565939f);
                j2.close();
                j2.moveTo(29.011042f, 10.51777f);
                j2.lineTo(42.0f, DownloadHelper.SAVE_FATOR);
                j2.lineTo(41.983315f, 23.5f);
                j2.lineTo(29.0f, 14.634123f);
                j2.lineTo(29.011042f, 10.51777f);
                j2.close();
                WeChatSVGRenderC2Java.setFillType(j2, 1);
                canvas.drawPath(j2, a);
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
