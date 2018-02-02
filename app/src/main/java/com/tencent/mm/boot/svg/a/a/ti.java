package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public final class ti extends c {
    private final int height = 50;
    private final int width = 50;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 50;
            case 1:
                return 50;
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
                e = c.a(e, 1.0f, 0.0f, -289.0f, 0.0f, 1.0f, -369.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 302.0f, 0.0f, 1.0f, 370.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(0.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(0.0f, 0.6715728f, 0.6715728f, 0.0f, DownloadHelper.SAVE_FATOR, 0.0f);
                j.lineTo(2.5f, 0.0f);
                j.cubicTo(3.3284273f, 0.0f, 4.0f, 0.6715728f, 4.0f, DownloadHelper.SAVE_FATOR);
                j.lineTo(4.0f, 46.5f);
                j.cubicTo(4.0f, 47.328426f, 3.3284273f, 48.0f, 2.5f, 48.0f);
                j.lineTo(DownloadHelper.SAVE_FATOR, 48.0f);
                j.cubicTo(0.6715728f, 48.0f, 0.0f, 47.328426f, 0.0f, 46.5f);
                j.lineTo(0.0f, DownloadHelper.SAVE_FATOR);
                j.close();
                canvas.drawPath(j, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                j = c.j(looper);
                j.moveTo(20.0f, DownloadHelper.SAVE_FATOR);
                j.cubicTo(20.0f, 0.6715728f, 20.671574f, 0.0f, 21.5f, 0.0f);
                j.lineTo(22.5f, 0.0f);
                j.cubicTo(23.328426f, 0.0f, 24.0f, 0.6715728f, 24.0f, DownloadHelper.SAVE_FATOR);
                j.lineTo(24.0f, 46.5f);
                j.cubicTo(24.0f, 47.328426f, 23.328426f, 48.0f, 22.5f, 48.0f);
                j.lineTo(21.5f, 48.0f);
                j.cubicTo(20.671574f, 48.0f, 20.0f, 47.328426f, 20.0f, 46.5f);
                j.lineTo(20.0f, DownloadHelper.SAVE_FATOR);
                j.close();
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
