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

public final class cw extends c {
    private final int height = 96;
    private final int width = 105;

    protected final int b(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 105;
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
                a.setColor(-2565928);
                e = c.a(e, 1.0f, 0.0f, -1303.0f, 0.0f, 1.0f, -1088.0f);
                f.reset();
                f.setValues(e);
                canvas.concat(f);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path j = c.j(looper);
                j.moveTo(1363.0f, 1092.5238f);
                j.cubicTo(1354.1088f, 1097.0039f, 1348.5f, 1105.5363f, 1348.0f, 1115.1428f);
                j.lineTo(1348.0f, 1155.8572f);
                j.cubicTo(1348.5f, 1163.0183f, 1341.4475f, 1168.9259f, 1333.0f, 1169.4286f);
                j.cubicTo(1324.0508f, 1168.9259f, 1317.0f, 1163.0183f, 1316.5f, 1155.8572f);
                j.cubicTo(1317.0f, 1150.5452f, 1320.5804f, 1146.0714f, 1325.5f, 1143.7937f);
                j.cubicTo(1326.1508f, 1143.7598f, 1333.0f, 1140.7778f, 1334.5f, 1136.254f);
                j.cubicTo(1335.7126f, 1132.5968f, 1331.5f, 1128.7142f, 1327.0f, 1128.7142f);
                j.cubicTo(1322.5f, 1128.7142f, 1321.0f, 1130.2222f, 1318.0f, 1131.7301f);
                j.cubicTo(1315.0f, 1133.2382f, 1310.4043f, 1136.4799f, 1306.0f, 1142.2858f);
                j.cubicTo(1304.3615f, 1146.4514f, 1303.0f, 1150.9463f, 1303.0f, 1155.8572f);
                j.cubicTo(1303.0f, 1170.7678f, 1316.3455f, 1183.0f, 1333.0f, 1183.0f);
                j.cubicTo(1338.5372f, 1183.0f, 1343.9255f, 1181.4536f, 1348.0f, 1178.4762f);
                j.cubicTo(1356.8912f, 1173.9961f, 1362.5f, 1165.4637f, 1363.0f, 1155.8572f);
                j.lineTo(1363.0f, 1115.1428f);
                j.cubicTo(1362.5f, 1107.9817f, 1369.5508f, 1102.0741f, 1378.0f, 1101.5714f);
                j.cubicTo(1386.9475f, 1102.0741f, 1394.0f, 1107.9817f, 1394.5f, 1115.1428f);
                j.cubicTo(1394.0f, 1120.6765f, 1388.5f, 1127.2063f, 1384.0f, 1128.7142f);
                j.cubicTo(1379.5f, 1130.2222f, 1378.033f, 1131.1792f, 1376.5f, 1134.746f);
                j.cubicTo(1375.3835f, 1138.496f, 1378.0f, 1142.2858f, 1384.0f, 1142.2858f);
                j.cubicTo(1384.8744f, 1142.2858f, 1390.6953f, 1141.1154f, 1396.0f, 1137.7618f);
                j.cubicTo(1399.7954f, 1135.3627f, 1403.1697f, 1131.1248f, 1405.0f, 1128.7142f);
                j.cubicTo(1406.6385f, 1124.5504f, 1408.0f, 1120.0537f, 1408.0f, 1115.1428f);
                j.cubicTo(1408.0f, 1100.2322f, 1394.6545f, 1088.0f, 1378.0f, 1088.0f);
                j.cubicTo(1372.4628f, 1088.0f, 1367.0745f, 1089.5464f, 1363.0f, 1092.5238f);
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
