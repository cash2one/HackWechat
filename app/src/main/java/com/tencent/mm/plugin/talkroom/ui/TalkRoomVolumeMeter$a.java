package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;

class TalkRoomVolumeMeter$a extends SurfaceView implements Callback {
    Paint iYm;
    int max = 100;
    float sdd = 0.0f;
    float sde = 0.0f;
    SurfaceHolder sdf = getHolder();
    Bitmap sdg;
    Bitmap sdh;
    private Bitmap sdi;
    Rect sdj;
    int sdk;
    int sdl;
    ak sdm;
    private boolean sdn = false;
    private float sdo = this.sde;
    float sdp = this.sde;
    PaintFlagsDrawFilter sdq;
    boolean sdr = false;
    private float[] sds;
    final /* synthetic */ TalkRoomVolumeMeter sdt;
    boolean started = false;
    int value = 0;

    static /* synthetic */ void a(TalkRoomVolumeMeter$a talkRoomVolumeMeter$a) {
        if (talkRoomVolumeMeter$a.sdp >= talkRoomVolumeMeter$a.sdd && talkRoomVolumeMeter$a.sdp <= talkRoomVolumeMeter$a.sde && talkRoomVolumeMeter$a.sdh != null && talkRoomVolumeMeter$a.sdg != null) {
            Canvas lockCanvas = talkRoomVolumeMeter$a.sdf.lockCanvas();
            if (lockCanvas != null && talkRoomVolumeMeter$a.sdj != null) {
                lockCanvas.setDrawFilter(talkRoomVolumeMeter$a.sdq);
                float f = talkRoomVolumeMeter$a.sdp;
                if (talkRoomVolumeMeter$a.sds == null) {
                    talkRoomVolumeMeter$a.sds = new float[]{talkRoomVolumeMeter$a.sde, talkRoomVolumeMeter$a.sde, talkRoomVolumeMeter$a.sde, talkRoomVolumeMeter$a.sde, talkRoomVolumeMeter$a.sde};
                }
                int i = 0;
                while (i < talkRoomVolumeMeter$a.sds.length - 1) {
                    talkRoomVolumeMeter$a.sds[i] = talkRoomVolumeMeter$a.sds[i + 1];
                    i++;
                }
                talkRoomVolumeMeter$a.sds[i] = f;
                talkRoomVolumeMeter$a.sdo = ((((talkRoomVolumeMeter$a.sds[0] + (talkRoomVolumeMeter$a.sds[1] * 4.0f)) + (talkRoomVolumeMeter$a.sds[2] * 6.0f)) + (talkRoomVolumeMeter$a.sds[3] * 4.0f)) + (talkRoomVolumeMeter$a.sds[4] * 1.0f)) / 16.0f;
                talkRoomVolumeMeter$a.sdj.set(0, (int) talkRoomVolumeMeter$a.sdo, talkRoomVolumeMeter$a.sdl, ((int) talkRoomVolumeMeter$a.sdo) + talkRoomVolumeMeter$a.sdk);
                lockCanvas.drawBitmap(talkRoomVolumeMeter$a.sdr ? talkRoomVolumeMeter$a.sdh : talkRoomVolumeMeter$a.sdg, null, talkRoomVolumeMeter$a.sdj, talkRoomVolumeMeter$a.iYm);
                talkRoomVolumeMeter$a.sdf.unlockCanvasAndPost(lockCanvas);
            }
        }
    }

    public TalkRoomVolumeMeter$a(TalkRoomVolumeMeter talkRoomVolumeMeter, Context context) {
        this.sdt = talkRoomVolumeMeter;
        super(context);
        this.sdf.addCallback(this);
        this.iYm = new Paint();
        this.iYm.setAntiAlias(true);
        this.sdq = new PaintFlagsDrawFilter(0, 3);
        this.sdm = new ak(new 1(this), true);
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceCreated");
        this.sdg = BitmapFactory.decodeResource(getResources(), R.g.bGO);
        this.sdi = BitmapFactory.decodeResource(getResources(), R.g.bGN);
        this.sdh = BitmapFactory.decodeResource(getResources(), R.g.bGP);
    }

    private int bFh() {
        return this.sdg == null ? 190 : this.sdg.getHeight();
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceChanged, width = " + i2 + " height = " + i3);
        this.sde = 0.0f;
        this.sdd = (float) (i3 - bFh());
        this.sdo = this.sde;
        this.sdp = this.sde;
        this.sdl = i2;
        this.sdk = bFh();
        this.sdj = new Rect(0, (int) this.sdo, this.sdl, ((int) this.sdo) + this.sdk);
        this.sdn = true;
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        x.v("MicroMsg.TalkRoomVoiceMeter", "surfaceDestroyed");
        this.sdn = false;
        this.sdm.TG();
        if (this.sdg != null) {
            this.sdg.recycle();
            this.sdg = null;
        }
        if (this.sdi != null) {
            this.sdi.recycle();
            this.sdi = null;
        }
        if (this.sdh != null) {
            this.sdh.recycle();
            this.sdh = null;
        }
    }
}
