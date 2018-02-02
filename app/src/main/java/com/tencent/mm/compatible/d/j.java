package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import android.os.Build;
import com.tencent.mm.compatible.d.d.a;
import com.tencent.mm.sdk.platformtools.bh;

final class j implements a {
    j() {
    }

    public static a.a ym() {
        a.a aVar = new a.a();
        try {
            aVar.gEB = Camera.open();
            aVar.fFy = 0;
            if (aVar.gEB == null) {
                return null;
            }
            if (Build.DISPLAY.startsWith("Flyme")) {
                aVar.fFy = 90;
                aVar.gEB.setDisplayOrientation(90);
            } else {
                int i;
                if (Build.MODEL.equals("M9")) {
                    String str = Build.DISPLAY;
                    if (str.substring(0, 0).equals("1")) {
                        i = -1;
                    } else {
                        String[] split = str.split("-");
                        i = (split == null || split.length < 2) ? -1 : bh.getInt(split[1], 0);
                    }
                } else {
                    i = -1;
                }
                if (i >= 7093) {
                    aVar.fFy = 90;
                    aVar.gEB.setDisplayOrientation(180);
                }
            }
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
