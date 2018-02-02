package com.tencent.mm.pluginsdk.k;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.d.a.a;
import com.tencent.mm.compatible.d.h;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f implements SensorEventListener {
    static int orT = 0;
    SensorManager bgR;
    Camera gEB = null;
    private boolean orS = false;
    a orV;
    Sensor orW;
    private float orX = 0.0f;
    private float orY = 0.0f;
    private float orZ = 0.0f;
    private PreviewCallback qxv = null;
    private SurfaceHolder sdf = null;
    a viF;
    List<Integer> viG = new ArrayList();
    private boolean viH = true;
    private boolean viI = true;
    private AutoFocusCallback viJ = new 1(this);

    public static int bZP() {
        return orT;
    }

    public final void aZX() {
        if (!(this.bgR == null || this.orW == null)) {
            this.bgR.unregisterListener(this);
        }
        if (this.gEB != null) {
            x.d("MicroMsg.YuvReocrder", "release camera");
            this.gEB.setPreviewCallback(null);
            this.gEB.stopPreview();
            this.gEB.release();
            this.gEB = null;
            this.orS = false;
        }
    }

    @TargetApi(9)
    private static void e(Parameters parameters) {
        int i = Integer.MIN_VALUE;
        if (q.gFU.gEg <= 0 && VERSION.SDK_INT >= 9) {
            List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
            if (supportedPreviewFpsRange != null && supportedPreviewFpsRange.size() != 0) {
                int size = supportedPreviewFpsRange.size();
                int i2 = 0;
                int i3 = Integer.MIN_VALUE;
                while (i2 < size) {
                    int i4;
                    int[] iArr = (int[]) supportedPreviewFpsRange.get(i2);
                    if (iArr != null && iArr.length > 1) {
                        int i5 = iArr[0];
                        i4 = iArr[1];
                        x.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", Integer.valueOf(i2), Integer.valueOf(i5), Integer.valueOf(i4));
                        if (i5 >= 0 && i4 >= i5 && i4 >= i) {
                            i = i5;
                            i2++;
                            i3 = i;
                            i = i4;
                        }
                    }
                    i4 = i;
                    i = i3;
                    i2++;
                    i3 = i;
                    i = i4;
                }
                x.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", Integer.valueOf(i3), Integer.valueOf(i));
                if (i3 != Integer.MAX_VALUE && i != Integer.MAX_VALUE) {
                    try {
                        parameters.setPreviewFpsRange(i3, i);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
                    }
                }
            }
        }
    }

    public final int b(SurfaceHolder surfaceHolder) {
        if (this.orS) {
            return 0;
        }
        if (surfaceHolder == null) {
            return 0 - g.getLine();
        }
        try {
            List supportedVideoSizes;
            List supportedPreviewSizes;
            this.sdf = surfaceHolder;
            Parameters parameters = this.gEB.getParameters();
            a aVar = this.viF;
            x.d("MicroMsg.YuvReocrder", "getFitRecordSize");
            int i = Integer.MAX_VALUE;
            if (VERSION.SDK_INT >= 11) {
                h hVar = new h();
                supportedVideoSizes = parameters.getSupportedVideoSizes();
            } else {
                supportedVideoSizes = null;
            }
            if (supportedVideoSizes == null) {
                x.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
                com.tencent.mm.compatible.d.g gVar = new com.tencent.mm.compatible.d.g();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
            } else {
                supportedPreviewSizes = supportedVideoSizes;
            }
            Size previewSize;
            if (supportedPreviewSizes != null) {
                int i2 = 0;
                boolean z = false;
                while (i2 < supportedPreviewSizes.size()) {
                    int i3;
                    boolean z2;
                    int i4 = ((Size) supportedPreviewSizes.get(i2)).height;
                    int i5 = ((Size) supportedPreviewSizes.get(i2)).width;
                    x.d("MicroMsg.YuvReocrder", "supp w:" + i5 + " h:" + i4);
                    int i6 = i4 * i5;
                    if ((((aVar.fFy == 0 || aVar.fFy == 180) && i4 >= aVar.otp && i5 >= aVar.otq) || ((aVar.fFy == 90 || aVar.fFy == 270) && i5 >= aVar.otp && i4 >= aVar.otq)) && i6 < i) {
                        aVar.mlb = i5;
                        aVar.mlc = i4;
                        i3 = i6;
                        z2 = true;
                    } else {
                        z2 = z;
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                    z = z2;
                }
                if (!z) {
                    previewSize = parameters.getPreviewSize();
                    aVar.mlc = previewSize.height;
                    aVar.mlb = previewSize.width;
                }
            } else {
                previewSize = parameters.getPreviewSize();
                aVar.mlc = previewSize.height;
                aVar.mlb = previewSize.width;
            }
            x.d("MicroMsg.YuvReocrder", " rotate:" + aVar.fFy + " w:" + aVar.mlb + " h:" + aVar.mlc);
            parameters.setPreviewSize(this.viF.mlb, this.viF.mlc);
            e(parameters);
            Collection supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            this.viG.clear();
            this.viG.addAll(supportedPreviewFrameRates);
            parameters.setPreviewFormat(17);
            supportedVideoSizes = parameters.getSupportedFocusModes();
            if (supportedVideoSizes != null) {
                if (d.fO(9) && true == supportedVideoSizes.contains("continuous-video")) {
                    x.i("MicroMsg.YuvReocrder", "support continous-video");
                    this.viH = false;
                    parameters.setFocusMode("continuous-video");
                } else if (!supportedVideoSizes.contains("auto")) {
                    x.i("MicroMsg.YuvReocrder", "don't support auto");
                    this.viH = false;
                }
            }
            this.gEB.setParameters(parameters);
            this.gEB.setPreviewDisplay(surfaceHolder);
            this.gEB.startPreview();
            if (!(this.bgR == null || this.orW == null || !this.viH)) {
                this.bgR.registerListener(this, this.orW, 2);
            }
            this.orS = true;
            return 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.YuvReocrder", e, "", new Object[0]);
            x.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + e.getMessage());
            return 0 - g.getLine();
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if ((Math.abs(this.orX - f) > 2.0f || Math.abs(this.orY - f2) > 2.0f || Math.abs(this.orZ - f3) > 2.0f) && this.gEB != null && this.viI && true == this.viH) {
            try {
                x.d("MicroMsg.YuvReocrder", "auto focus");
                this.gEB.autoFocus(this.viJ);
                this.viI = false;
            } catch (Exception e) {
                x.d("MicroMsg.YuvReocrder", "auto focus failed");
            }
        }
        this.orX = f;
        this.orY = f2;
        this.orZ = f3;
    }
}
