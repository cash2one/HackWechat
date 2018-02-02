package com.tencent.mm.pluginsdk.k;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.SensorManager;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.mm.compatible.d.d;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public Context context;
    public int fileSize;
    public String filename;
    public int hTT;
    private boolean orQ = false;
    public MediaRecorder ouJ;
    public a qxu;
    public f viv;
    public int viw = 0;
    private final int vix = 5;
    private a viy = new a(Looper.getMainLooper());

    private static class a extends Handler {
        int jer = 0;
        boolean orQ = false;

        public a(Looper looper) {
            super(looper);
        }

        @TargetApi(8)
        public final void handleMessage(Message message) {
            Camera camera = (Camera) message.obj;
            Parameters parameters = camera.getParameters();
            int zoom = parameters.getZoom() + this.jer;
            if (this.orQ) {
                if (zoom >= parameters.getMaxZoom() / 2) {
                    zoom = parameters.getMaxZoom() / 2;
                } else {
                    sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
                }
            } else if (zoom <= 0) {
                zoom = 0;
            } else {
                sendMessageDelayed(Message.obtain(this, 4353, 0, 0, message.obj), 20);
            }
            parameters.setZoom(zoom);
            camera.setParameters(parameters);
        }
    }

    @SuppressLint({"NewApi"})
    public final void b(Surface surface, int i, int i2) {
        while (this.viv != null) {
            Camera camera = this.viv.gEB;
            if (surface == null || camera == null) {
                x.e("MicroMsg.SceneVideo", "holder or cam is null ");
                return;
            }
            int i3 = q.gGe.gFa == -1 ? i : q.gGe.gFa;
            int bZP = f.bZP();
            try {
                camera.unlock();
            } catch (Exception e) {
                x.w("MicroMsg.SceneVideo", "exception in cam.unlock() [%s]", e.getMessage());
            }
            this.ouJ = new MediaRecorder();
            this.ouJ.setCamera(camera);
            this.ouJ.setAudioSource(5);
            this.ouJ.setVideoSource(1);
            this.ouJ.setOutputFormat(2);
            this.ouJ.setVideoSize(this.qxu.mlb, this.qxu.mlc);
            this.ouJ.setVideoEncoder(2);
            this.ouJ.setAudioEncoder(3);
            if (VERSION.SDK_INT > 7) {
                this.ouJ.setVideoEncodingBitRate(this.qxu.oto);
            }
            try {
                if (q.gFW.gGy) {
                    this.ouJ.setVideoFrameRate(q.gFW.gGz);
                } else {
                    this.ouJ.setVideoFrameRate(i3);
                }
            } catch (Exception e2) {
                x.d("MicroMsg.SceneVideo", "try set fps failed: " + i3);
            }
            this.ouJ.setOutputFile(this.qxu.otx);
            this.ouJ.setPreviewDisplay(surface);
            x.d("MicroMsg.SceneVideo", "doStart camid[%s] params:\n%s", Integer.valueOf(bZP), this.qxu.toString());
            if (bZP == 0) {
                setOrientationHint(q.gGe.gEU == -1 ? 90 : q.gGe.gEU);
            } else {
                if (q.gGe.gEV == -1) {
                    i3 = 270;
                } else {
                    i3 = q.gGe.gEV;
                }
                setOrientationHint(i3);
            }
            try {
                this.ouJ.prepare();
                this.ouJ.start();
                return;
            } catch (Throwable e3) {
                x.w("MicroMsg.SceneVideo", "exception in mediaRecorder[%s] doStartCount[%s]", e3.getMessage(), Integer.valueOf(this.viw));
                x.printErrStackTrace("MicroMsg.SceneVideo", e3, "", new Object[0]);
                this.viw++;
                if (this.viw < 5) {
                    f fVar = this.viv;
                    if (i2 < 0 || i2 >= fVar.viG.size()) {
                        x.d("MicroMsg.YuvReocrder", "ret fr " + i);
                    } else {
                        x.d("MicroMsg.YuvReocrder", "ret fr " + fVar.viG.get(i2));
                        i = ((Integer) fVar.viG.get(i2)).intValue();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
        x.e("MicroMsg.SceneVideo", "yuvRecoder is null");
    }

    @TargetApi(9)
    private void setOrientationHint(int i) {
        com.tencent.mm.compatible.a.a.a(9, new 1(this, i));
    }

    public final int a(Activity activity, boolean z) {
        int line;
        this.context = activity;
        f fVar = this.viv;
        a aVar = this.qxu;
        if (aVar == null) {
            line = 0 - g.getLine();
        } else {
            fVar.viF = aVar;
            if (fVar.bgR == null && fVar.orW == null) {
                fVar.bgR = (SensorManager) activity.getSystemService("sensor");
                fVar.orW = fVar.bgR.getDefaultSensor(1);
            }
            if (z || fVar.gEB == null) {
                fVar.aZX();
                if (z) {
                    f.orT = (f.orT ^ -1) & 1;
                }
                fVar.orV = d.o(activity, f.orT);
                if (fVar.orV == null) {
                    x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                    line = 0 - g.getLine();
                } else {
                    fVar.gEB = fVar.orV.gEB;
                    fVar.viF.fFy = fVar.orV.fFy;
                    if (fVar.gEB == null) {
                        x.e("MicroMsg.YuvReocrder", "start camera FAILED!");
                        line = 0 - g.getLine();
                    }
                }
            }
            line = 0;
        }
        if (line != 0) {
            return line;
        }
        return 0;
    }

    public final int bZK() {
        this.viv.aZX();
        return 0;
    }

    public final int b(SurfaceHolder surfaceHolder) {
        return this.viv.b(surfaceHolder);
    }

    public final int aGM() {
        if (this.viv.gEB == null) {
            return 0;
        }
        return this.viv.gEB.getParameters().getPreviewSize().width;
    }

    public final int aGN() {
        if (this.viv.gEB == null) {
            return 0;
        }
        return this.viv.gEB.getParameters().getPreviewSize().height;
    }
}
