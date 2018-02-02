package com.tencent.mm.plugin.sight.encode.ui;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.bv.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.List;

class e$a extends af {
    static boolean osw = true;
    static AutoFocusCallback osx = new 1();
    float nJk;
    boolean orQ = false;
    int osF = 0;
    boolean osG = false;
    boolean osH = false;
    float osI;
    int osJ;
    int osK;

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        int intValue = Float.valueOf(((float) a.fromDPToPix(ac.getContext(), 72)) * f3).intValue();
        RectF rectF = new RectF();
        rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
        return new Rect(sM(Math.round(rectF.left)), sM(Math.round(rectF.top)), sM(Math.round(rectF.right)), sM(Math.round(rectF.bottom)));
    }

    private static int sM(int i) {
        if (i > 1000) {
            return 1000;
        }
        return i < DownloadResult.CODE_UNDEFINED ? DownloadResult.CODE_UNDEFINED : i;
    }

    static void f(Camera camera) {
        if (camera == null) {
            x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
        }
        if (osw) {
            osw = false;
            try {
                camera.autoFocus(osx);
                return;
            } catch (Exception e) {
                x.w("MicroMsg.SightCamera", "autofocus fail, exception %s", new Object[]{e.getMessage()});
                osw = true;
                return;
            }
        }
        x.w("MicroMsg.SightCamera", "auto focus not back");
    }

    public e$a(Looper looper) {
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
            x.e("MicroMsg.SightCamera", "get target zoom value error: %s", new Object[]{e.getMessage()});
            maxZoom = 0;
        }
        return maxZoom;
    }

    static int d(Parameters parameters) {
        int b = b(parameters) / 6;
        if (b <= 0) {
            return 1;
        }
        return b;
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        Camera camera;
        switch (message.what) {
            case 4353:
                if (!this.osH) {
                    int b;
                    camera = (Camera) message.obj;
                    Parameters parameters = camera.getParameters();
                    x.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", new Object[]{Boolean.valueOf(this.orQ), Integer.valueOf(this.osF), Integer.valueOf(parameters.getZoom())});
                    int zoom = parameters.getZoom() + this.osF;
                    if (this.orQ) {
                        b = b(parameters);
                        if (zoom < b) {
                            long j;
                            Message obtainMessage = obtainMessage(4353, message.obj);
                            if (this.osG) {
                                j = 10;
                            } else {
                                j = 20;
                            }
                            sendMessageDelayed(obtainMessage, j);
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
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                    }
                    if (z) {
                        this.osJ = 0;
                        this.osK = 0;
                        sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                        return;
                    }
                    return;
                }
                return;
            case 4354:
                camera = (Camera) message.obj;
                if (this.osJ == 0 || this.osJ == 0 || d.fN(14)) {
                    f(camera);
                    return;
                }
                float f = this.osI;
                float f2 = this.nJk;
                int i = this.osJ;
                int i2 = this.osK;
                if (camera == null) {
                    x.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                }
                if (osw) {
                    osw = false;
                    try {
                        x.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)});
                        x.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", new Object[]{a(f, f2, 1.0f, i, i2), a(f, f2, DownloadHelper.SAVE_FATOR, i, i2)});
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
                        camera.autoFocus(osx);
                        return;
                    } catch (Exception e2) {
                        x.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", new Object[]{e2.getMessage()});
                        osw = true;
                        return;
                    }
                }
                x.w("MicroMsg.SightCamera", "auto focus not back");
                return;
            default:
                return;
        }
    }
}
