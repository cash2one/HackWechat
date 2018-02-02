package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.d.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class l {
    private Context context;
    public Camera gEB;
    public boolean mgX = false;
    public Point mgY = null;
    public Point mgZ = null;
    private Point mha = null;
    private boolean mhb;
    public int mhc;
    private boolean mhd = false;
    private boolean mhe = true;
    public boolean mhf = false;
    public Point mhg = null;

    public l(Context context) {
        this.context = context;
    }

    public final void e(SurfaceTexture surfaceTexture) {
        if (this.mgX) {
            x.w("MicroMsg.FaceScanCamera", "in open(), previewing");
            release();
        }
        this.mhe = true;
        int numberOfCameras = Camera.getNumberOfCameras();
        int i = 0;
        while (i < numberOfCameras) {
            CameraInfo cameraInfo = new CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing != 1 || !this.mhe) {
                if (cameraInfo.facing == 0 && !this.mhe) {
                    x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                    break;
                }
                i++;
            } else {
                x.d("MicroMsg.FaceScanCamera", "hy: front Camera found");
                break;
            }
        }
        i = -1;
        long Wq = bh.Wq();
        a o = d.o(this.context, i);
        if (o == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), openCameraRes == null");
            throw new IOException();
        }
        boolean z;
        this.mhf = true;
        x.d("MicroMsg.FaceScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bA(Wq))});
        this.mhc = o.fFy;
        if (o.fFy % 180 != 0) {
            z = true;
        } else {
            z = false;
        }
        this.mhb = z;
        this.gEB = o.gEB;
        if (this.gEB == null) {
            x.e("MicroMsg.FaceScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[]{Boolean.valueOf(this.mhb)});
            throw new IOException();
        }
        String str;
        this.gEB.setPreviewTexture(surfaceTexture);
        Parameters parameters = this.gEB.getParameters();
        Point point = this.mgZ;
        Point point2 = this.mha;
        String str2 = parameters.get("preview-size-values");
        if (str2 == null) {
            str = parameters.get("preview-size-value");
        } else {
            str = str2;
        }
        Point point3 = null;
        if (str != null) {
            x.d("MicroMsg.FaceScanCamera", "preview-size-values parameter: " + str);
            point3 = a(parameters, point, false);
        }
        if (point3 == null) {
            point3 = new Point((point2.x >> 3) << 3, (point2.y >> 3) << 3);
        }
        this.mgY = point3;
        this.mhg = new Point(this.mgY);
        x.d("MicroMsg.FaceScanCamera", "getCameraResolution: " + this.mgZ + " camera:" + this.mgY + "bestVideoEncodeSize: " + this.mhg);
        parameters.setPreviewSize(this.mgY.x, this.mgY.y);
        parameters.setZoom(0);
        parameters.setSceneMode("auto");
        try {
            List<Integer> supportedPreviewFormats;
            boolean z2;
            if (parameters.getSupportedFocusModes() == null || !parameters.getSupportedFocusModes().contains("auto")) {
                x.i("MicroMsg.FaceScanCamera", "camera not support FOCUS_MODE_AUTO");
                supportedPreviewFormats = parameters.getSupportedPreviewFormats();
                z2 = false;
                for (Integer intValue : supportedPreviewFormats) {
                    i = intValue.intValue();
                    x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                    if (i == 17) {
                        z = true;
                        break;
                    }
                    if (i != 842094169) {
                        z = true;
                    } else {
                        z = z2;
                    }
                    z2 = z;
                }
                z = false;
                if (z) {
                    parameters.setPreviewFormat(17);
                } else if (z2) {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                    parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
                } else {
                    x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                    parameters.setPreviewFormat(842094169);
                }
                if (this.mhb) {
                    parameters.setRotation(this.mhc);
                }
                this.gEB.setParameters(parameters);
            }
            x.i("MicroMsg.FaceScanCamera", "set FocusMode to FOCUS_MODE_AUTO");
            parameters.setFocusMode("auto");
            supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            z2 = false;
            while (r6.hasNext()) {
                i = intValue.intValue();
                x.d("MicroMsg.FaceScanCamera", "supportedPreviewFormat: " + i);
                if (i == 17) {
                    z = true;
                    break;
                }
                if (i != 842094169) {
                    z = z2;
                } else {
                    z = true;
                }
                z2 = z;
            }
            z = false;
            if (z) {
                parameters.setPreviewFormat(17);
            } else if (z2) {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP. Use format: %s", new Object[]{supportedPreviewFormats.get(0)});
                parameters.setPreviewFormat(((Integer) supportedPreviewFormats.get(0)).intValue());
            } else {
                x.e("MicroMsg.FaceScanCamera", "Preview not support PixelFormat.YCbCr_420_SP, but hasYU12");
                parameters.setPreviewFormat(842094169);
            }
            if (this.mhb) {
                parameters.setRotation(this.mhc);
            }
            this.gEB.setParameters(parameters);
        } catch (Exception e) {
            x.e("MicroMsg.FaceScanCamera", "set focus mode error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void release() {
        x.d("MicroMsg.FaceScanCamera", "release(), previewing = [%s]", new Object[]{Boolean.valueOf(this.mgX)});
        if (this.gEB != null) {
            long Wq = bh.Wq();
            if (this.mgX) {
                this.gEB.setPreviewCallback(null);
                this.gEB.stopPreview();
                this.mgX = false;
                x.d("MicroMsg.FaceScanCamera", "stopPreview costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
            }
            Wq = bh.Wq();
            this.gEB.release();
            this.gEB = null;
            this.mhf = false;
            x.d("MicroMsg.FaceScanCamera", "camera.release() costTime=[%s]", new Object[]{Long.valueOf(bh.bA(Wq))});
        }
        this.mhd = false;
    }

    public final int aGM() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview width: %d", new Object[]{Integer.valueOf(this.mgY.x)});
        return this.mgY.x;
    }

    public final int aGN() {
        x.v("MicroMsg.FaceScanCamera", "hy: preview height: %d", new Object[]{Integer.valueOf(this.mgY.y)});
        return this.mgY.y;
    }

    private static Point a(Parameters parameters, Point point, boolean z) {
        List<Size> arrayList = new ArrayList(parameters.getSupportedPreviewSizes());
        Collections.sort(arrayList, new a((byte) 0));
        Point point2 = null;
        x.d("MicroMsg.FaceScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[]{Integer.valueOf(point.x), Integer.valueOf(point.y), Float.valueOf(((float) point.x) / ((float) point.y))});
        long eY = bh.eY(ac.getContext());
        x.d("MicroMsg.FaceScanCamera", "systemAvailableMemInMB: %d", new Object[]{Long.valueOf(eY)});
        int i = point.x;
        i = point.y;
        float f = Float.POSITIVE_INFINITY;
        for (Size size : arrayList) {
            Size size2;
            int i2 = size2.width;
            int i3 = size2.height;
            x.i("MicroMsg.FaceScanCamera", "realWidth: %d, realHeight: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            int i4 = i2 * i3;
            if (i4 >= 150400 && i4 <= 983040) {
                Object obj = i2 > i3 ? 1 : null;
                if (obj != null) {
                    i = i3;
                } else {
                    i = i2;
                }
                if (obj != null) {
                    i4 = i2;
                } else {
                    i4 = i3;
                }
                x.d("MicroMsg.FaceScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i4)});
                if (i == point.x && i4 == point.y && e(i, i4, eY)) {
                    point2 = new Point(i2, i3);
                    x.i("MicroMsg.FaceScanCamera", "Found preview size exactly matching screen size: " + point2);
                    return point2;
                }
                float f2;
                Point point3;
                float abs = Math.abs((((float) i) / ((float) i4)) - r8);
                if (abs >= f || !e(i2, i3, eY)) {
                    f2 = f;
                    point3 = point2;
                } else {
                    point3 = new Point(i2, i3);
                    f2 = abs;
                }
                x.i("MicroMsg.FaceScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[]{Float.valueOf(f2), Float.valueOf(abs), Integer.valueOf(i2), Integer.valueOf(i3)});
                point2 = point3;
                f = f2;
            }
        }
        if (point2 == null) {
            size2 = parameters.getPreviewSize();
            if (size2 != null) {
                point2 = new Point(size2.width, size2.height);
                x.i("MicroMsg.FaceScanCamera", "No suitable preview sizes, using default: " + point2);
            } else {
                x.e("MicroMsg.FaceScanCamera", "hy: can not find default size!!");
            }
        }
        x.i("MicroMsg.FaceScanCamera", "Found best approximate preview size: " + point2);
        return point2;
    }

    private static boolean e(int i, int i2, long j) {
        x.d("MicroMsg.FaceScanCamera", "dataSizeInMB: %f, availableMemInMb: %d", new Object[]{Double.valueOf(((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d), Long.valueOf(j)});
        if (((double) j) / (((((((double) i) * ((double) i2)) * 3.0d) / 2.0d) / 1024.0d) / 1024.0d) >= 5.0d) {
            return true;
        }
        return false;
    }

    public final void setPreviewCallback(PreviewCallback previewCallback) {
        if (this.gEB == null) {
            x.w("MicroMsg.FaceScanCamera", "hy: camera is null. setPreviewCallback failed");
            return;
        }
        this.gEB.addCallbackBuffer(c.mfT.h(Integer.valueOf(((aGM() * aGN()) * ImageFormat.getBitsPerPixel(this.gEB.getParameters().getPreviewFormat())) / 8)));
        this.gEB.setPreviewCallbackWithBuffer(new 1(this, previewCallback));
    }
}
