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

public final class cm extends c {
    private final int height = 42;
    private final int width = 42;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                Paint a = c.a(i3, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, -275.0f, 0.0f, 1.0f, -1626.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 126.0f, 0.0f, 1.0f, 1626.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                e = c.a(e, 1.0f, 0.0f, 149.0f, 0.0f, 1.0f, 0.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                Paint a2 = c.a(i2, looper);
                i3 = c.a(a, looper);
                a2.setColor(-70474);
                i3.setColor(-36352);
                i3.setStrokeWidth(5.4f);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                a = c.a(i3, looper);
                Path j = c.j(looper);
                j.moveTo(42.0f, 21.25926f);
                j.cubicTo(42.0f, 9.401778f, 32.59822f, 0.0f, 20.74074f, 0.0f);
                j.cubicTo(9.401778f, 0.0f, 0.0f, 9.401778f, 0.0f, 21.25926f);
                j.cubicTo(0.0f, 32.59822f, 9.401778f, 42.0f, 20.74074f, 42.0f);
                j.cubicTo(32.59822f, 42.0f, 42.0f, 32.59822f, 42.0f, 21.25926f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.drawPath(j, a);
                canvas.restore();
                canvas.save();
                a3 = c.a(i2, looper);
                a3.setColor(-36352);
                j = c.j(looper);
                j.moveTo(7.1932015f, 22.069902f);
                j.cubicTo(7.0209723f, 21.90468f, 7.0013413f, 21.619408f, 7.147708f, 21.434807f);
                j.lineTo(8.144134f, 20.17808f);
                j.cubicTo(8.291237f, 19.992548f, 8.567782f, 19.95389f, 8.763619f, 20.093018f);
                j.lineTo(15.588285f, 24.941442f);
                j.cubicTo(15.783314f, 25.079996f, 16.094162f, 25.074368f, 16.278591f, 24.931952f);
                j.lineTo(33.272747f, 11.8091545f);
                j.cubicTo(33.45896f, 11.6653595f, 33.751038f, 11.677971f, 33.93421f, 11.845651f);
                j.lineTo(34.814766f, 12.651727f);
                j.cubicTo(34.993866f, 12.815679f, 34.995564f, 13.079486f, 34.821854f, 13.237947f);
                j.lineTo(16.258057f, 30.172258f);
                j.cubicTo(16.08287f, 30.332067f, 15.798551f, 30.325104f, 15.629005f, 30.162458f);
                j.lineTo(7.1932015f, 22.069902f);
                j.close();
                WeChatSVGRenderC2Java.setFillType(j, 2);
                canvas.drawPath(j, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.h(looper);
                break;
        }
        return 0;
    }
}
