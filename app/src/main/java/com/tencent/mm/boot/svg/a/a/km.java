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

public final class km extends c {
    private final int height = 39;
    private final int width = 39;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a = c.a(i2, looper);
                a.setColor(-4210753);
                e = c.a(e, 1.0f, 0.0f, -267.0f, 0.0f, 1.0f, -942.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(290.74658f, 962.3673f);
                j.lineTo(281.66696f, 950.38226f);
                j.cubicTo(281.66696f, 950.38226f, 280.0749f, 947.686f, 281.897f, 946.12305f);
                j.cubicTo(285.0006f, 943.46094f, 288.86172f, 945.6186f, 292.41647f, 942.0f);
                j.cubicTo(293.6008f, 943.90704f, 293.0603f, 947.8834f, 290.84427f, 948.8545f);
                j.cubicTo(288.6282f, 949.82556f, 285.94733f, 949.9153f, 285.94733f, 949.9153f);
                j.lineTo(295.2846f, 966.53125f);
                j.lineTo(295.0269f, 966.30566f);
                j.cubicTo(295.32394f, 967.01917f, 295.48572f, 967.7877f, 295.48572f, 968.5886f);
                j.cubicTo(295.48572f, 972.3405f, 291.93597f, 975.38196f, 287.55713f, 975.38196f);
                j.cubicTo(283.1783f, 975.38196f, 279.62857f, 972.3405f, 279.62857f, 968.5886f);
                j.cubicTo(279.62857f, 964.8368f, 283.1783f, 961.7953f, 287.55713f, 961.7953f);
                j.cubicTo(288.6917f, 961.7953f, 289.77066f, 961.9995f, 290.74658f, 962.3673f);
                j.close();
                j.moveTo(278.57144f, 946.18054f);
                j.lineTo(278.57144f, 948.52997f);
                j.cubicTo(273.52835f, 951.2919f, 270.1143f, 956.6069f, 270.1143f, 962.7102f);
                j.cubicTo(270.1143f, 971.657f, 277.4504f, 978.9097f, 286.5f, 978.9097f);
                j.cubicTo(295.5496f, 978.9097f, 302.8857f, 971.657f, 302.8857f, 962.7102f);
                j.cubicTo(302.8857f, 957.0437f, 299.94287f, 952.0567f, 295.48572f, 949.1616f);
                j.lineTo(295.48572f, 946.719f);
                j.cubicTo(301.1608f, 949.8425f, 305.0f, 955.8331f, 305.0f, 962.7102f);
                j.cubicTo(305.0f, 972.8114f, 296.71725f, 981.0f, 286.5f, 981.0f);
                j.cubicTo(276.28275f, 981.0f, 268.0f, 972.8114f, 268.0f, 962.7102f);
                j.cubicTo(268.0f, 955.4142f, 272.3212f, 949.11597f, 278.57144f, 946.18054f);
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
