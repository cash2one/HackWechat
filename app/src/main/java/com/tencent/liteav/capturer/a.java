package com.tencent.liteav.capturer;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class a implements AutoFocusCallback {
    private static final String c = a.class.getSimpleName();
    private Matrix a = new Matrix();
    private int b = 0;
    private Camera d;
    private boolean e = true;
    private int f = 15;
    private int g;
    private int h = 1;
    private int i;
    private int j;
    private int k;
    private int l;
    private SurfaceTexture m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q = false;

    public void a(SurfaceTexture surfaceTexture) {
        this.m = surfaceTexture;
    }

    public void a(boolean z) {
        this.p = z;
        if (this.d != null) {
            Parameters parameters = this.d.getParameters();
            List supportedFlashModes = parameters.getSupportedFlashModes();
            if (z) {
                if (supportedFlashModes != null && supportedFlashModes.contains("torch")) {
                    TXCLog.i(c, "set FLASH_MODE_TORCH");
                    parameters.setFlashMode("torch");
                }
            } else if (supportedFlashModes != null && supportedFlashModes.contains("off")) {
                TXCLog.i(c, "set FLASH_MODE_OFF");
                parameters.setFlashMode("off");
            }
            try {
                this.d.setParameters(parameters);
            } catch (Exception e) {
            }
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public void b(int i) {
        this.f = i;
    }

    public void a(float f, float f2) {
        if (this.q) {
            try {
                List arrayList;
                this.d.cancelAutoFocus();
                Parameters parameters = this.d.getParameters();
                if (this.n) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(a(f, f2, 2.0f), 1000));
                    parameters.setFocusAreas(arrayList);
                }
                if (this.o) {
                    arrayList = new ArrayList();
                    arrayList.add(new Area(a(f, f2, 3.0f), 1000));
                    parameters.setMeteringAreas(arrayList);
                }
                try {
                    this.d.setParameters(parameters);
                    this.d.autoFocus(this);
                } catch (Exception e) {
                }
            } catch (Exception e2) {
            }
        }
    }

    public void b(boolean z) {
        this.q = z;
    }

    private Rect a(float f, float f2, float f3) {
        int i;
        int i2 = 1000;
        float f4 = 200.0f * f3;
        if (this.e) {
            f = 1.0f - f;
        }
        for (i = 0; i < this.k / 90; i++) {
            f = (-(-(f2 - 0.5f))) + 0.5f;
            f2 = (-(f - 0.5f)) + 0.5f;
        }
        int i3 = (int) ((f * 2000.0f) - 1000.0f);
        i = (int) ((f2 * 2000.0f) - 1000.0f);
        int i4 = i3 < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i3;
        i3 = i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
        i = i4 + ((int) f4);
        int i5 = ((int) f4) + i3;
        if (i > 1000) {
            i = 1000;
        }
        if (i5 <= 1000) {
            i2 = i5;
        }
        return new Rect(i4, i3, i, i2);
    }

    public int a() {
        if (this.d == null) {
            return 0;
        }
        Parameters parameters = this.d.getParameters();
        if (parameters.getMaxZoom() <= 0 || !parameters.isZoomSupported()) {
            return 0;
        }
        return parameters.getMaxZoom();
    }

    public boolean c(int i) {
        if (this.d == null) {
            return false;
        }
        Parameters parameters = this.d.getParameters();
        if (parameters.getMaxZoom() <= 0 || !parameters.isZoomSupported()) {
            TXCLog.e(c, "camera not support zoom!");
            return false;
        } else if (i < 0 || i > parameters.getMaxZoom()) {
            TXCLog.e(c, "invalid zoom value : " + i + ", while max zoom is " + parameters.getMaxZoom());
            return false;
        } else {
            try {
                parameters.setZoom(i);
                this.d.setParameters(parameters);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    public void a(float f) {
        float f2 = 1.0f;
        float f3 = -1.0f;
        if (this.d != null) {
            if (f <= 1.0f) {
                f2 = f;
            }
            if (f2 >= -1.0f) {
                f3 = f2;
            }
            Parameters parameters = this.d.getParameters();
            int minExposureCompensation = parameters.getMinExposureCompensation();
            int maxExposureCompensation = parameters.getMaxExposureCompensation();
            if (minExposureCompensation == 0 || maxExposureCompensation == 0) {
                TXCLog.e(c, "camera not support setExposureCompensation!");
            } else {
                int d = b.a().d();
                f3 *= (float) maxExposureCompensation;
                if (d != 0 && d <= maxExposureCompensation && d >= minExposureCompensation) {
                    TXCLog.d(c, "camera setExposureCompensation: " + d);
                    parameters.setExposureCompensation(d);
                } else if (f3 <= ((float) maxExposureCompensation) && f3 >= ((float) minExposureCompensation)) {
                    TXCLog.d(c, "camera setExposureCompensation: " + f3);
                    parameters.setExposureCompensation((int) f3);
                }
            }
            try {
                this.d.setParameters(parameters);
            } catch (Exception e) {
            }
        }
    }

    public void d(int i) {
        this.h = i;
        this.k = (((this.l - 90) + (this.h * 90)) + 360) % 360;
    }

    public int c(boolean z) {
        try {
            if (this.m == null) {
                return -2;
            }
            int i;
            if (this.d != null) {
                b();
            }
            CameraInfo cameraInfo = new CameraInfo();
            int i2 = -1;
            int i3 = -1;
            for (i = 0; i < Camera.getNumberOfCameras(); i++) {
                Camera.getCameraInfo(i, cameraInfo);
                TXCLog.i(c, "camera index " + i + ", facing = " + cameraInfo.facing);
                if (cameraInfo.facing == 1) {
                    i3 = i;
                }
                if (cameraInfo.facing == 0) {
                    i2 = i;
                }
            }
            TXCLog.i(c, "camera front, id = " + i3);
            TXCLog.i(c, "camera back , id = " + i2);
            if (i3 != -1 || i2 == -1) {
                i = i3;
            } else {
                i = i2;
            }
            if (i2 != -1 || i == -1) {
                i3 = i2;
            } else {
                i3 = i;
            }
            this.e = z;
            if (this.e) {
                this.d = Camera.open(i);
            } else {
                this.d = Camera.open(i3);
            }
            Parameters parameters = this.d.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (this.q && supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                TXCLog.i(c, "support FOCUS_MODE_AUTO");
                parameters.setFocusMode("auto");
            } else if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                TXCLog.i(c, "support FOCUS_MODE_CONTINUOUS_VIDEO");
                parameters.setFocusMode("continuous-video");
            }
            if (VERSION.SDK_INT >= 14) {
                if (parameters.getMaxNumFocusAreas() > 0) {
                    this.n = true;
                }
                if (parameters.getMaxNumMeteringAreas() > 0) {
                    this.o = true;
                }
            }
            List supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            if (supportedPreviewSizes != null) {
                for (int i4 = 0; i4 < supportedPreviewSizes.size(); i4++) {
                    Size size = (Size) supportedPreviewSizes.get(i4);
                    TXCLog.i(c, String.format("camera supported preview size %dx%d", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height)}));
                }
            }
            a e = e(this.g);
            if (e == null) {
                this.d.release();
                this.d = null;
                TXCLog.d(c, "不支持的视频分辨率");
                return -3;
            }
            TXCLog.i("search", String.format("get camera supported preview size %d * %d ", new Object[]{Integer.valueOf(e.a), Integer.valueOf(e.b)}));
            this.i = e.a;
            this.j = e.b;
            parameters.setPreviewSize(e.a, e.b);
            parameters.setPreviewFrameRate(f(this.f));
            this.l = g(this.e ? i : i3);
            this.k = (((this.l - 90) + (this.h * 90)) + 360) % 360;
            this.d.setDisplayOrientation(0);
            this.d.setPreviewTexture(this.m);
            this.d.setParameters(parameters);
            this.d.startPreview();
            return 0;
        } catch (IOException e2) {
            return -1;
        } catch (Exception e3) {
            return -1;
        }
    }

    public void b() {
        if (this.d != null) {
            try {
                this.d.setPreviewCallback(null);
                this.d.stopPreview();
                this.d.release();
            } catch (Exception e) {
            } finally {
                this.d = null;
                this.m = null;
            }
        }
    }

    public int c() {
        return this.k;
    }

    public boolean d() {
        return this.e;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.j;
    }

    private a e(int i) {
        List supportedPreviewSizes = this.d.getParameters().getSupportedPreviewSizes();
        List arrayList = new ArrayList();
        switch (i) {
            case 1:
            case 2:
            case 4:
                arrayList.add(new a(this, 640, 360));
                arrayList.add(new a(this, 768, 432));
                arrayList.add(new a(this, 960, 540));
                arrayList.add(new a(this, 800, 480));
                arrayList.add(new a(this, 640, 480));
                arrayList.add(new a(this, 960, 720));
                arrayList.add(new a(this, 1280, 720));
                break;
            case 3:
                break;
            case 5:
                arrayList.add(new a(this, 960, 540));
                arrayList.add(new a(this, 960, 720));
                arrayList.add(new a(this, 1280, 720));
                arrayList.add(new a(this, 800, 480));
                arrayList.add(new a(this, 640, 360));
                arrayList.add(new a(this, 640, 480));
                break;
            case 6:
                arrayList.add(new a(this, 1280, 720));
                arrayList.add(new a(this, 1920, 1080));
                arrayList.add(new a(this, 960, 540));
                arrayList.add(new a(this, 960, 720));
                arrayList.add(new a(this, 800, 480));
                arrayList.add(new a(this, 640, 360));
                arrayList.add(new a(this, 640, 480));
                break;
            case 7:
                arrayList.add(new a(this, 1280, 720));
                arrayList.add(new a(this, 960, 540));
                arrayList.add(new a(this, 960, 720));
                arrayList.add(new a(this, 800, 480));
                arrayList.add(new a(this, 768, 432));
                arrayList.add(new a(this, 640, 360));
                arrayList.add(new a(this, 640, 480));
                break;
        }
        arrayList.add(new a(this, 480, 320));
        arrayList.add(new a(this, 640, 360));
        arrayList.add(new a(this, 640, 480));
        arrayList.add(new a(this, 768, 432));
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            a aVar = (a) arrayList.get(i2);
            for (int i3 = 0; i3 < supportedPreviewSizes.size(); i3++) {
                Size size = (Size) supportedPreviewSizes.get(i3);
                if (size.width == aVar.a && size.height == aVar.b) {
                    new StringBuilder("wanted:").append(aVar.a).append("*").append(aVar.b);
                    return aVar;
                }
            }
        }
        return null;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (z) {
            TXCLog.i(c, "AUTO focus success");
        } else {
            TXCLog.i(c, "AUTO focus failed");
        }
    }

    private int f(int i) {
        int i2 = 0;
        List supportedPreviewFrameRates = this.d.getParameters().getSupportedPreviewFrameRates();
        if (supportedPreviewFrameRates == null) {
            TXCLog.e(c, "getSupportedFPS error");
            return 1;
        }
        int intValue = ((Integer) supportedPreviewFrameRates.get(0)).intValue();
        while (i2 < supportedPreviewFrameRates.size()) {
            int intValue2 = ((Integer) supportedPreviewFrameRates.get(i2)).intValue();
            if (Math.abs(intValue2 - i) - Math.abs(intValue - i) < 0) {
                intValue = intValue2;
            }
            i2++;
        }
        TXCLog.i(c, "choose fpts=" + intValue);
        return intValue;
    }

    private int g(int i) {
        CameraInfo cameraInfo = new CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        if (cameraInfo.facing == 1) {
            return (360 - cameraInfo.orientation) % 360;
        }
        return (cameraInfo.orientation + 360) % 360;
    }
}
