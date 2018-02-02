package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern qap = Pattern.compile(",");
    public Activity fAF;
    public Camera gEB;
    public Rect mbm;
    public boolean mgX = false;
    public Point mgY = null;
    public Point mgZ = null;
    public Point mha = null;
    public boolean mhb;
    public int mhc;
    public boolean mhd = false;
    public boolean osh = false;
    public int qaq = 0;
    private boolean qar;
    public Rect qas;
    private Rect qat;
    private Rect qau;
    public int qav = -1;
    private String qaw = "";
    private int qax;
    private int qay;
    private int qaz;

    public h(Activity activity, int i, boolean z) {
        Point point;
        this.fAF = activity;
        if (Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
            Display defaultDisplay = ((WindowManager) activity.getSystemService("window")).getDefaultDisplay();
            point = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        } else {
            point = ae.fz(activity);
        }
        this.mgZ = point;
        this.qar = z;
        this.qaq = i;
    }

    public final boolean isOpen() {
        if (this.gEB != null) {
            return true;
        }
        return false;
    }

    public final void vL(int i) {
        this.qaq = i;
        this.qas = null;
        this.mbm = null;
    }

    public final String getFocusMode() {
        if (this.gEB == null || !this.mgX) {
            return "";
        }
        return this.gEB.getParameters().getFocusMode();
    }

    public final void release() {
        x.d("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.mgX)});
        if (this.gEB != null) {
            long Wq = bh.Wq();
            if (this.mgX) {
                this.gEB.setPreviewCallback(null);
                this.gEB.stopPreview();
                this.mgX = false;
                x.d("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
            }
            Wq = bh.Wq();
            this.gEB.release();
            this.gEB = null;
            x.d("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
        this.osh = false;
        this.mhd = false;
        this.qav = -1;
        this.qaq = 0;
    }

    public final float bpC() {
        if (!this.mhb || this.qar) {
            return ((float) this.mha.x) / ((float) this.mgY.x);
        }
        return ((float) this.mha.x) / ((float) this.mgY.y);
    }

    public final float bpD() {
        if (!this.mhb || this.qar) {
            return ((float) this.mha.y) / ((float) this.mgY.y);
        }
        return ((float) this.mha.y) / ((float) this.mgY.x);
    }

    private float bpE() {
        if (!this.mhb || this.qar) {
            return ((float) this.mgY.x) / ((float) this.mha.x);
        }
        return ((float) this.mgY.y) / ((float) this.mha.x);
    }

    private float bpF() {
        if (!this.mhb || this.qar) {
            return ((float) this.mgY.y) / ((float) this.mha.y);
        }
        return ((float) this.mgY.x) / ((float) this.mha.y);
    }

    public final Rect a(Rect rect, int i) {
        Rect rect2 = new Rect();
        x.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s", new Object[]{rect, this.mha});
        if (!this.mhb || this.qar) {
            rect2.left = (int) (((float) rect.left) * bpE());
            rect2.right = (int) (((float) rect.right) * bpE());
            rect2.top = (int) (((float) rect.top) * bpF());
            rect2.bottom = (int) (((float) rect.bottom) * bpF());
            if (rect2.bottom > this.mgY.y) {
                rect2.bottom = this.mgY.y;
            }
            if (rect2.right > this.mgY.x) {
                rect2.right = this.mgY.x;
            }
        } else {
            x.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + this.mhb + " needLandscape = " + this.qar);
            rect2.top = (this.mgY.y - ((int) (((float) rect.width()) * bpE()))) / 2;
            rect2.bottom = rect2.top + ((int) (((float) rect.width()) * bpE()));
            rect2.left = (this.mgY.x - ((int) (((float) rect.height()) * bpF()))) / 2;
            rect2.right = rect2.left + ((int) (((float) rect.height()) * bpF()));
            if (rect2.bottom > this.mgY.y) {
                rect2.bottom = this.mgY.y;
            }
            if (rect2.right > this.mgY.x) {
                rect2.right = this.mgY.x;
            }
        }
        if (7 == i || 11 == i) {
            int width;
            if (!this.mhb || this.qar) {
                if ((((double) rect2.width()) * 1.0d) / ((double) rect2.height()) < 1.5859999656677246d) {
                    width = (int) (((float) rect2.width()) / 1.586f);
                    rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                    rect2.bottom = width + rect2.top;
                } else {
                    width = (int) (((float) rect2.height()) * 1.586f);
                    rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                    rect2.right = width + rect2.left;
                }
            } else if (((float) rect2.height()) / 1.586f < ((float) rect2.width())) {
                width = (int) (((float) rect2.height()) / 1.586f);
                rect2.left = ((rect2.left + rect2.right) / 2) - (width / 2);
                rect2.right = width + rect2.left;
            } else {
                width = (int) (((float) rect2.width()) * 1.586f);
                rect2.top = ((rect2.top + rect2.bottom) / 2) - (width / 2);
                rect2.bottom = width + rect2.top;
            }
        }
        return rect2;
    }

    public final void bpG() {
        if (this.gEB != null && !this.mhd) {
            try {
                int width;
                int height;
                Parameters parameters = this.gEB.getParameters();
                if (this.qas != null) {
                    this.qat = new Rect();
                    width = (int) ((((float) this.qas.width()) / ((float) this.mgY.x)) * 2000.0f);
                    height = (int) ((((float) this.qas.height()) / ((float) this.mgY.y)) * 2000.0f);
                    this.qat.left = (-width) / 2;
                    this.qat.right = width / 2;
                    this.qat.top = (-height) / 2;
                    this.qat.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.qat);
                }
                if (this.qas != null) {
                    this.qau = new Rect();
                    width = (int) ((((float) this.qas.width()) / ((float) this.mgY.x)) * 2000.0f);
                    height = (int) ((((float) this.qas.height()) / ((float) this.mgY.y)) * 2000.0f);
                    this.qau.left = (-width) / 2;
                    this.qau.right = width / 2;
                    this.qau.top = (-height) / 2;
                    this.qau.bottom = height / 2;
                    x.i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.qau);
                }
                if (this.qat != null && this.qau != null) {
                    List arrayList;
                    this.mhd = true;
                    if (parameters.getMaxNumMeteringAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.qau, 1000));
                        parameters.setMeteringAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support set metering area");
                    }
                    if (parameters.getMaxNumFocusAreas() > 0) {
                        arrayList = new ArrayList();
                        arrayList.add(new Area(this.qat, 1000));
                        parameters.setFocusAreas(arrayList);
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea, camera not support area focus");
                    }
                    this.gEB.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "setFocusAndMeteringArea error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public static Point a(Parameters parameters, Point point, Point point2, boolean z) {
        String str;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, z);
        }
        if (point3 == null) {
            return new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        return point3;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        arrayList.remove(0);
        Point point2 = null;
        x.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        x.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[]{Integer.valueOf(point.x * point.y), Integer.valueOf(2073600)});
        float f = Float.POSITIVE_INFINITY;
        for (Size size : arrayList) {
            Size size2;
            int i = size2.width;
            int i2 = size2.height;
            x.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            int i3 = i * i2;
            if (i3 >= 150400 && i3 <= 2073600) {
                if (i3 <= r7 || Math.min(point.x, point.y) < 720) {
                    int i4;
                    Object obj = i > i2 ? 1 : null;
                    if (obj == null || z) {
                        i4 = i;
                    } else {
                        i4 = i2;
                    }
                    if (obj == null || z) {
                        i3 = i2;
                    } else {
                        i3 = i;
                    }
                    x.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3)});
                    if (i4 == point.x && i3 == point.y) {
                        point2 = new Point(i, i2);
                        x.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                    Point point3;
                    float f2;
                    float abs = Math.abs((((float) i4) / ((float) i3)) - r6);
                    if (abs < f) {
                        point3 = new Point(i, i2);
                        f2 = abs;
                    } else {
                        f2 = f;
                        point3 = point2;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i), Integer.valueOf(i2)});
                    point2 = point3;
                    f = f2;
                }
            }
        }
        if (point2 == null) {
            size2 = parameters.getPreviewSize();
            point2 = new Point(size2.width, size2.height);
            x.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: " + point2);
        }
        x.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    public final void bpH() {
        try {
            if (this.gEB != null) {
                Parameters parameters = this.gEB.getParameters();
                String str = parameters.get("zoom-supported");
                if (bh.ov(str) || !Boolean.parseBoolean(str)) {
                    x.i("MicroMsg.scanner.ScanCamera", "not support zoom");
                    return;
                }
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    ar.Hg();
                    q.eI(c.CV().cjU());
                    x.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", new Object[]{Boolean.valueOf(q.gGe.gFd == 1), Integer.valueOf(q.gGe.gFd)});
                    if ((q.gGe.gFd == 1) && this.mgZ.x >= 720 && (this.qaq == 1 || this.qaq == 8 || this.qaq == 4)) {
                        this.qay = zoomRatios.size() / 5;
                        if (this.qay > 150) {
                            this.qay = 150;
                        }
                    } else {
                        this.qay = 0;
                    }
                    double d = 1.5d;
                    if (q.gGe.gFe != -1.0d) {
                        d = q.gGe.gFe;
                    }
                    this.qaz = (int) (((double) zoomRatios.size()) / d);
                    x.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", new Object[]{Double.valueOf(d), Integer.valueOf(this.qaz)});
                    if (this.qaz < this.qay) {
                        this.qaz = this.qay;
                    } else if (this.qaz > 400) {
                        this.qaz = 400;
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[]{Integer.valueOf(this.qay), zoomRatios.get(this.qay), Integer.valueOf(this.qaz), zoomRatios.get(this.qaz)});
                }
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "init zoom exception!", new Object[0]);
        }
    }

    public final void vM(int i) {
        if (this.gEB != null && this.mgX && i > 0) {
            try {
                Parameters parameters = this.gEB.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    int binarySearch;
                    int intValue = (int) (((double) ((Integer) zoomRatios.get(this.qax)).intValue()) * (((double) i) / 100.0d));
                    x.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue)});
                    if (intValue >= ((Integer) zoomRatios.get(this.qay)).intValue() && intValue <= ((Integer) zoomRatios.get(this.qaz)).intValue()) {
                        if (zoomRatios != null && zoomRatios.size() > 0) {
                            x.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", new Object[]{zoomRatios, Integer.valueOf(zoomRatios.size())});
                            binarySearch = Collections.binarySearch(zoomRatios, Integer.valueOf(intValue));
                            x.i("MicroMsg.scanner.ScanCamera", "insert index:%d", new Object[]{Integer.valueOf(binarySearch)});
                            if (binarySearch < 0) {
                                int i2 = -(binarySearch + 1);
                                int i3 = i2 - 1;
                                if (i2 >= 0) {
                                    if (i2 <= zoomRatios.size() - 1 && i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                        binarySearch = ((Integer) zoomRatios.get(i2)).intValue() - intValue > intValue - ((Integer) zoomRatios.get(i3)).intValue() ? i3 : i2;
                                    }
                                }
                                if (i2 >= 0 && i2 <= zoomRatios.size() - 1) {
                                    binarySearch = i2;
                                } else if (i3 >= 0 && i3 <= zoomRatios.size() - 1) {
                                    binarySearch = i3;
                                }
                            }
                        }
                        binarySearch = 0;
                    } else if (intValue < ((Integer) zoomRatios.get(this.qay)).intValue()) {
                        binarySearch = this.qay;
                    } else {
                        x.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
                        binarySearch = this.qax + ((this.qaz - this.qax) / 5);
                        if (binarySearch > this.qaz) {
                            binarySearch = this.qaz;
                        }
                    }
                    x.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", new Object[]{Integer.valueOf(binarySearch), zoomRatios.get(binarySearch)});
                    this.qax = binarySearch;
                    parameters.setZoom(binarySearch);
                    this.gEB.setParameters(parameters);
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + e.getMessage());
            }
        }
    }

    public final void vN(int i) {
        if (this.gEB != null && this.mgX) {
            try {
                Parameters parameters = this.gEB.getParameters();
                List zoomRatios = parameters.getZoomRatios();
                if (zoomRatios != null && zoomRatios.size() > 0) {
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                    switch (i) {
                        case 0:
                            this.qax = 0;
                            break;
                        case 1:
                            this.qax = this.qay;
                            break;
                        case 2:
                            if (this.qax < this.qaz) {
                                this.qax++;
                                this.qax = this.qax > this.qaz ? this.qaz : this.qax;
                                break;
                            }
                            break;
                        case 3:
                            if (this.qax > this.qay) {
                                this.qax--;
                                this.qax = this.qax < this.qay ? this.qay : this.qax;
                                break;
                            }
                            break;
                        case 4:
                            this.qax = this.qaz;
                            break;
                        case 5:
                            if (this.qax == this.qay) {
                                this.qax = this.qaz;
                                break;
                            } else {
                                this.qax = this.qay;
                                break;
                            }
                    }
                    parameters.setZoom(this.qax);
                    this.gEB.setParameters(parameters);
                    x.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(parameters.getZoom())});
                }
            } catch (Exception e) {
                x.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + e.getMessage());
            }
        }
    }

    public final int bpI() {
        if (this.gEB == null || this.gEB.getParameters() == null || this.gEB.getParameters().getZoomRatios() == null || this.gEB.getParameters().getZoomRatios().size() <= 0) {
            return 100;
        }
        return ((Integer) this.gEB.getParameters().getZoomRatios().get(this.qax)).intValue();
    }

    public static void c(Parameters parameters) {
        try {
            List<String> supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes != null) {
                x.d("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + supportedFocusModes.size());
                for (String str : supportedFocusModes) {
                    x.d("MicroMsg.scanner.ScanCamera", "supported focus modes : " + str);
                }
                if (supportedFocusModes.contains("continuous-video")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
                    parameters.setFocusMode("continuous-video");
                } else if (supportedFocusModes.contains("auto")) {
                    x.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
                    parameters.setFocusMode("auto");
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.scanner.ScanCamera", "setAutoFocus error: %s", new Object[]{e.getMessage()});
        }
    }

    public final boolean bpJ() {
        if (this.gEB != null && this.mgX) {
            try {
                Parameters parameters = this.gEB.getParameters();
                if (!bh.cA(parameters.getSupportedFlashModes()) && parameters.getSupportedFlashModes().contains("torch")) {
                    return true;
                }
                x.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "isFlashSupported error: %s", new Object[]{e.getMessage()});
            }
        }
        return false;
    }

    public final void bad() {
        x.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[]{this.gEB, Boolean.valueOf(this.mgX)});
        if (this.gEB != null && this.mgX) {
            try {
                this.osh = false;
                Parameters parameters = this.gEB.getParameters();
                if (bh.cA(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    x.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
                    return;
                }
                parameters.setFlashMode("off");
                this.gEB.setParameters(parameters);
                x.i("MicroMsg.scanner.ScanCamera", "close flash");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.scanner.ScanCamera", e, "closeFlash error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
