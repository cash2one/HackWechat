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
import com.tencent.wcdb.FileUtils;

public final class fd extends c {
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
                a.setColor(-8355712);
                e = c.a(e, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 24.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(-3.5527137E-15f, 24.0f);
                j.cubicTo(8.006664f, 16.0f, 16.013329f, 8.0f, 24.0f, 3.5527137E-15f);
                j.cubicTo(25.549355f, 1.3682896f, 26.918783f, 2.8764045f, 28.0f, 4.0f);
                j.cubicTo(22.620575f, 9.877653f, 17.152853f, 15.440699f, 12.0f, 21.0f);
                j.cubicTo(23.7601f, 20.973783f, 35.875053f, 20.94382f, 48.0f, 21.0f);
                j.lineTo(48.0f, 27.0f);
                j.cubicTo(35.85506f, 27.026217f, 23.710121f, 26.996254f, 12.0f, 27.0f);
                j.cubicTo(17.11287f, 32.5593f, 22.610579f, 38.142323f, 28.0f, 44.0f);
                j.cubicTo(26.878801f, 45.133583f, 25.519367f, 46.651684f, 24.0f, 48.0f);
                j.cubicTo(15.993336f, 40.019974f, 7.9866724f, 32.019974f, -3.5527137E-15f, 24.0f);
                j.lineTo(-3.5527137E-15f, 24.0f);
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
