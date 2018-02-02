package com.tencent.mm.plugin.mmsight.model;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.List;

class e$c extends af {
    public float nJk;
    boolean orQ = false;
    final /* synthetic */ e osA;
    int osF = 0;
    boolean osG = false;
    boolean osH = false;
    public float osI;
    public int osJ;
    public int osK;

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        float f4 = 80.0f * f3;
        float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f7 = f5 + f4;
        f4 += f6;
        RectF rectF = new RectF();
        rectF.set(f5, f6, f7, f4);
        return new Rect(sM(Math.round(rectF.left)), sM(Math.round(rectF.top)), sM(Math.round(rectF.right)), sM(Math.round(rectF.bottom)));
    }

    private static int sM(int i) {
        if (i > 1000) {
            return 1000;
        }
        return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
    }

    final void e(Camera camera) {
        if (camera == null) {
            x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
        } else if (e.osw) {
            e.osw = false;
            try {
                x.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                camera.cancelAutoFocus();
                camera.autoFocus(this.osA.osx);
            } catch (Exception e) {
                x.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                e.osw = true;
            }
        } else {
            x.w("MicroMsg.MMSightCamera", "auto focus not back");
        }
    }

    public e$c(e eVar, Looper looper) {
        this.osA = eVar;
        super(looper);
    }

    private static int b(Parameters parameters) {
        if (parameters == null) {
            return 0;
        }
        int maxZoom;
        try {
            maxZoom = parameters.getMaxZoom() / 2;
            if (maxZoom <= 0) {
                maxZoom = parameters.getMaxZoom();
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
            maxZoom = 0;
        }
        return maxZoom;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        Camera camera;
        int zoom;
        switch (message.what) {
            case 4353:
                if (!this.osH) {
                    int b;
                    camera = (Camera) message.obj;
                    Parameters parameters = camera.getParameters();
                    x.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.orQ), Integer.valueOf(this.osF), Integer.valueOf(parameters.getZoom())});
                    zoom = parameters.getZoom() + this.osF;
                    if (this.orQ) {
                        b = b(parameters);
                        if (zoom < b) {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.osG ? 10 : 20);
                            z = false;
                            b = zoom;
                        }
                    } else if (zoom <= 0) {
                        b = 0;
                    } else {
                        sendMessageDelayed(obtainMessage(4353, message.obj), this.osG ? 10 : 20);
                        z = false;
                        b = zoom;
                    }
                    parameters.setZoom(b);
                    try {
                        camera.setParameters(parameters);
                    } catch (Exception e) {
                    }
                    if (z) {
                        this.osJ = 0;
                        this.osK = 0;
                        return;
                    }
                    return;
                }
                return;
            case 4354:
                camera = (Camera) message.obj;
                if (this.osJ == 0 || this.osK == 0 || d.fN(14)) {
                    e(camera);
                    return;
                }
                float f = this.osI;
                float f2 = this.nJk;
                zoom = this.osJ;
                int i = this.osK;
                if (camera == null) {
                    x.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                    return;
                } else if (e.osw) {
                    e.osw = false;
                    try {
                        camera.cancelAutoFocus();
                        x.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i)});
                        x.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, zoom, i), a(f, f2, DownloadHelper.SAVE_FATOR, zoom, i)});
                        Parameters parameters2 = camera.getParameters();
                        List supportedFocusModes = parameters2.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                            parameters2.setFocusMode("auto");
                        }
                        if (parameters2.getMaxNumFocusAreas() > 0) {
                            supportedFocusModes = new ArrayList(1);
                            supportedFocusModes.add(new Area(r7, 1000));
                            parameters2.setFocusAreas(supportedFocusModes);
                        }
                        if (parameters2.getMaxNumMeteringAreas() > 0) {
                            supportedFocusModes = new ArrayList(1);
                            supportedFocusModes.add(new Area(r2, 1000));
                            parameters2.setMeteringAreas(supportedFocusModes);
                        }
                        camera.setParameters(parameters2);
                        camera.autoFocus(this.osA.osx);
                        return;
                    } catch (Exception e2) {
                        x.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                        e.osw = true;
                        return;
                    }
                } else {
                    x.w("MicroMsg.MMSightCamera", "auto focus not back");
                    return;
                }
            default:
                return;
        }
    }
}
