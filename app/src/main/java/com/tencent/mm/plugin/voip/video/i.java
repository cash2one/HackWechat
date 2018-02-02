package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.x;

public final class i {
    public static g suQ;
    public static int suR = -1;
    public static int suS = -1;
    public static int suT = 0;
    public static int suU = 0;
    public static int suV = 0;
    public static boolean suW = true;

    public static boolean bII() {
        if (q.gFU.gDT && q.gFU.gDS == 8) {
            return false;
        }
        return true;
    }

    private static boolean bIJ() {
        try {
            if (Class.forName("android.hardware.Camera").getDeclaredMethod("getNumberOfCameras", null) != null) {
                return true;
            }
            x.d("GetfcMethod", "GetfcMethod is null");
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.CameraUtil", "find getNumberOfCameras failed: " + e.getMessage());
            return false;
        }
    }

    public static void dH(Context context) {
        if (suQ == null) {
            suQ = new g("*");
            boolean bIJ = bIJ();
            suW = bIJ;
            if (!bIJ || q.gFU.gDR) {
                if (suW && q.gFU.gDR) {
                    bIK();
                }
                if (q.gFU.gDR) {
                    suQ.gDQ = q.gFU.gDQ;
                }
                if (q.gFU.gDY) {
                    if (q.gFU.gDX.gEx != 0) {
                        suQ.stz = true;
                    } else {
                        suQ.stz = false;
                    }
                }
                if (q.gFU.gDW) {
                    if (q.gFU.gDV.gEx != 0) {
                        suQ.sty = true;
                    } else {
                        suQ.sty = false;
                    }
                }
                if (q.gFU.gDW && q.gFU.gDV.gEy >= 0) {
                    suQ.stA = q.gFU.gDV.gEy;
                    suT = suQ.stA;
                }
                if (q.gFU.gDY && q.gFU.gDX.gEy >= 0) {
                    suQ.stB = q.gFU.gDX.gEy;
                    suU = suQ.stB;
                }
                if (q.gFU.gDW) {
                    if (suQ.stC == null) {
                        suQ.stC = new Point(0, 0);
                    }
                    suQ.stC = new Point(q.gFU.gDV.width, q.gFU.gDV.height);
                }
                if (q.gFU.gDY) {
                    if (suQ.stD == null) {
                        suQ.stD = new Point(0, 0);
                    }
                    suQ.stD = new Point(q.gFU.gDX.width, q.gFU.gDX.height);
                }
                if (q.gFU.gDY && q.gFU.gDX.fps != 0) {
                    suQ.stx = q.gFU.gDX.fps;
                }
                if (q.gFU.gDW && q.gFU.gDV.fps != 0) {
                    suQ.stx = q.gFU.gDV.fps;
                }
                PackageManager packageManager = context.getPackageManager();
                if (!(q.gFU.gDR || packageManager.hasSystemFeature("android.hardware.camera"))) {
                    suQ.gDQ = 0;
                    suQ.sty = false;
                    suQ.stz = false;
                }
            } else {
                bIK();
            }
            if (q.gFU.ana) {
                suV = q.gFU.gDU;
            }
            x.i("MicroMsg.CameraUtil", "gCameraNum:" + suQ.gDQ + "\ngIsHasFrontCamera:" + suQ.sty + "\ngIsHasBackCamera:" + suQ.stz + "\ngFrontCameraId:" + suR + "\ngBackCameraId:" + suS + "\ngBackOrientation:" + suQ.stB + "\ngFrontOrientation:" + suQ.stA + "\ngBestFps:" + suQ.stx + "\ngFacePreviewSize:" + suQ.stC + "\ngNonFacePreviewSize:" + suQ.stD + "\ngFaceCameraIsRotate180:" + suT + "\ngMainCameraIsRotate180:" + suU + "\ngCameraFormat:" + suV + "\ngFaceNotRotate:SDK:" + VERSION.SDK_INT + "\n");
        }
    }

    private static void bIK() {
        suQ.gDQ = Camera.getNumberOfCameras();
        CameraInfo cameraInfo = new CameraInfo();
        int i = 0;
        while (i < suQ.gDQ) {
            try {
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 1) {
                    suR = i;
                    suQ.stA = cameraInfo.orientation;
                    suQ.sty = true;
                } else if (cameraInfo.facing == 0) {
                    suS = i;
                    suQ.stB = cameraInfo.orientation;
                    suQ.stz = true;
                }
                i++;
            } catch (Exception e) {
                x.e("MicroMsg.CameraUtil", "get camera info error: %s", new Object[]{e.getMessage()});
            }
        }
        String property = System.getProperty("ro.media.enc.camera.platform", null);
        boolean equalsIgnoreCase = property == null ? false : property.equalsIgnoreCase("Mediatek");
        if (suQ.stA == 270 || (equalsIgnoreCase && suQ.stA == 0)) {
            suT = 1;
        } else {
            suT = 0;
        }
        if (suQ.stB == 270 || (equalsIgnoreCase && suQ.stB == 0)) {
            suU = 1;
        } else {
            suU = 0;
        }
    }
}
