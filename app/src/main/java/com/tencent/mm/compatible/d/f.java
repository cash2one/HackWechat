package com.tencent.mm.compatible.d;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.d.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

final class f implements a {
    f() {
    }

    @TargetApi(8)
    public static a.a fG(int i) {
        a.a aVar = new a.a();
        try {
            aVar.gEB = Camera.open();
            aVar.fFy = 90;
            if (aVar.gEB == null) {
                return null;
            }
            int i2;
            int i3;
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            switch (((WindowManager) ac.getContext().getSystemService("window")).getDefaultDisplay().getRotation()) {
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
                i3 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
            } else {
                i3 = ((cameraInfo.orientation - i2) + 360) % 360;
            }
            x.d("MicroMsg.CameraUtil.CameraUtilImpl22", "CameraUtilImpl22, open camera, info.orientation: %d, degrees: %d, result:%d", new Object[]{Integer.valueOf(cameraInfo.orientation), Integer.valueOf(i2), Integer.valueOf(i3)});
            aVar.gEB.setDisplayOrientation(i3);
            return aVar;
        } catch (Exception e) {
            return null;
        }
    }
}
