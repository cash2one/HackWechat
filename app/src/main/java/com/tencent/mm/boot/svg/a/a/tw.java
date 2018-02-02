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

public final class tw extends c {
    private final int height = 33;
    private final int width = 33;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 33;
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
                e = c.a(e, 1.0f, 0.0f, -226.0f, 0.0f, 1.0f, -665.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                a = c.a(a, looper);
                e = c.a(e, 0.70710677f, -0.70710677f, 553.11835f, 0.70710677f, 0.70710677f, 28.051147f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Path j = c.j(looper);
                j.moveTo(244.19849f, 680.1985f);
                j.lineTo(244.19849f, 660.6985f);
                j.lineTo(241.19849f, 660.6985f);
                j.lineTo(241.19849f, 680.1985f);
                j.lineTo(221.69849f, 680.1985f);
                j.lineTo(221.69849f, 683.1985f);
                j.lineTo(241.19849f, 683.1985f);
                j.lineTo(241.19849f, 702.6985f);
                j.lineTo(244.19849f, 702.6985f);
                j.lineTo(244.19849f, 683.1985f);
                j.lineTo(263.6985f, 683.1985f);
                j.lineTo(263.6985f, 680.1985f);
                j.lineTo(244.19849f, 680.1985f);
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
