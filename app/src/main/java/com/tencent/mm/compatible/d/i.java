package com.tencent.mm.compatible.d;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.tencent.mm.compatible.d.d.a;
import com.tencent.mm.sdk.platformtools.x;

final class i implements a {
    i() {
    }

    public static int getNumberOfCameras() {
        int numberOfCameras;
        if (!q.gFU.gEf || q.gFU.gEe == -1) {
            numberOfCameras = d.getNumberOfCameras();
            x.d("CameraUtilImplConfig", "getNumberOfCameras " + numberOfCameras);
            return numberOfCameras <= 1 ? 0 : numberOfCameras;
        } else {
            numberOfCameras = q.gFU.gEe;
            x.d("CameraUtilImplConfig", "mVRCameraNum " + numberOfCameras);
            return numberOfCameras;
        }
    }

    public static a.a fG(int i) {
        a.a aVar = new a.a();
        aVar.gEB = null;
        try {
            aVar.gEB = Camera.open(i);
            if (aVar.gEB == null) {
                return null;
            }
            aVar.fFy = 0;
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.hasVRInfo " + q.gFU.gDZ);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceRotate " + q.gFU.gEa);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRFaceDisplayOrientation " + q.gFU.gEb);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackRotate " + q.gFU.gEc);
            x.d("CameraUtilImplConfig", "DeviceInfo.mCameraInfo.mVRBackDisplayOrientation " + q.gFU.gEd);
            if (getNumberOfCameras() > 1) {
                try {
                    CameraInfo cameraInfo = new CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                    x.d("CameraUtilImplConfig", "info.facing " + cameraInfo.facing);
                    if (cameraInfo.facing == 1) {
                        if (q.gFU.gDZ && q.gFU.gEa != -1) {
                            aVar.fFy = q.gFU.gEa;
                        }
                        if (q.gFU.gDZ && q.gFU.gEb != -1) {
                            aVar.gEB.setDisplayOrientation(q.gFU.gEb);
                        }
                    } else {
                        if (q.gFU.gDZ && q.gFU.gEc != -1) {
                            aVar.fFy = q.gFU.gEc;
                        }
                        if (q.gFU.gDZ && q.gFU.gEd != -1) {
                            aVar.gEB.setDisplayOrientation(q.gFU.gEd);
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("CameraUtilImplConfig", e, "", new Object[0]);
                }
            } else {
                if (q.gFU.gDZ && q.gFU.gEc != -1) {
                    aVar.fFy = q.gFU.gEc;
                }
                if (q.gFU.gDZ && q.gFU.gEd != -1) {
                    aVar.gEB.setDisplayOrientation(q.gFU.gEd);
                }
            }
            return aVar;
        } catch (Exception e2) {
            return null;
        }
    }
}
