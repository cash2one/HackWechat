package com.tencent.mm.compatible.d;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.d.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g implements a {
    public static d$a$a o(Context context, int i) {
        d$a$a com_tencent_mm_compatible_d_d_a_a = new d$a$a();
        com_tencent_mm_compatible_d_d_a_a.gEB = null;
        try {
            long Wq = bh.Wq();
            x.i("MicroMsg.CameraUtil", "ashu::begin to try Call Camera.open cameraID %d", new Object[]{Integer.valueOf(i)});
            com_tencent_mm_compatible_d_d_a_a.gEB = Camera.open(i);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.open back, use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
            if (com_tencent_mm_compatible_d_d_a_a.gEB == null) {
                x.e("MicroMsg.CameraUtil", "open camera error, not exception, but camera null");
                return null;
            }
            int i2;
            CameraInfo cameraInfo = new CameraInfo();
            Wq = bh.Wq();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.getCameraInfo cameraID %d", new Object[]{Integer.valueOf(i)});
            Camera.getCameraInfo(i, cameraInfo);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.getCameraInfo back, use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
            switch (((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation()) {
                case 0:
                    i2 = 0;
                    break;
                case 1:
                    i2 = 90;
                    break;
                case 2:
                    i2 = 180;
                    break;
                case 3:
                    i2 = 270;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            if (cameraInfo.facing == 1) {
                i2 = (360 - (cameraInfo.orientation % 360)) % 360;
            } else {
                i2 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            Wq = bh.Wq();
            x.i("MicroMsg.CameraUtil", "ashu::begin to Call Camera.setDisplayOrientation %d", new Object[]{Integer.valueOf(i2)});
            com_tencent_mm_compatible_d_d_a_a.gEB.setDisplayOrientation(i2);
            x.i("MicroMsg.CameraUtil", "ashu::Call Camera.setDisplayOrientation back, use %dms", new Object[]{Long.valueOf(bh.bA(Wq))});
            com_tencent_mm_compatible_d_d_a_a.fFy = cameraInfo.orientation;
            return com_tencent_mm_compatible_d_d_a_a;
        } catch (Throwable e) {
            x.e("MicroMsg.CameraUtil", "open camera error %s", new Object[]{e.getMessage()});
            x.printErrStackTrace("MicroMsg.CameraUtil", e, "", new Object[0]);
            return null;
        }
    }
}
