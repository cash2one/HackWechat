package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.appbrand.jsapi.share.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class VoicePrintVolumeMeter extends View {
    static int nVA = 20;
    private static int sig = Color.rgb(240, 250, 235);
    private static int sih = Color.rgb(i.CTRL_INDEX, 240, 200);
    private static int sii = 100;
    private static float sip = DownloadHelper.SAVE_FATOR;
    private static float siq = 2.0f;
    private static float sir = 0.1f;
    private static float sis = 0.05f;
    private Paint fC;
    private Context mContext;
    boolean mIsPlaying = false;
    float mVolume = -1.0f;
    View nVo;
    private int sic = -1;
    private int sid = -1;
    ag sie = null;
    ak sif = null;
    private float sij = 0.0f;
    private float sik = 0.0f;
    private float sil = 0.0f;
    private float sim = 0.0f;
    private float sin = 0.0f;
    private float sio = 0.0f;
    boolean sit = true;

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        if (voicePrintVolumeMeter.mIsPlaying) {
            if (voicePrintVolumeMeter.sit) {
                voicePrintVolumeMeter.sin *= sir + 1.0f;
                voicePrintVolumeMeter.sio = voicePrintVolumeMeter.sin * sip;
            } else {
                voicePrintVolumeMeter.sin *= 1.0f - sis;
                voicePrintVolumeMeter.sio = voicePrintVolumeMeter.sin * sip;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.fC = new Paint();
        this.sie = new ag("VoicePrintVolumeMeter");
        this.sif = new ak(this.sie.oAt.getLooper(), new 1(this), true);
    }

    final void bFT() {
        if (this.nVo != null && this.nVo.getVisibility() != 8) {
            int[] iArr = new int[2];
            this.nVo.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
                return;
            }
            int width = this.nVo.getWidth();
            int height = this.nVo.getHeight();
            if (height == 0 || width == 0) {
                x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
                return;
            }
            this.sic = iArr[0] + (width / 2);
            this.sid = (iArr[1] + (height / 2)) - a.fromDPToPix(this.mContext, 25);
            x.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[]{Integer.valueOf(this.sic), Integer.valueOf(this.sid)});
            this.sij = ((float) width) / 2.0f;
            this.sik = this.sij * sip;
            this.sil = this.sij * siq;
            this.sim = this.sik * siq;
            this.sio = this.sik;
            this.sin = this.sij;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mIsPlaying) {
            if (this.sic == -1 || this.sid == -1) {
                bFT();
            }
            this.fC.setAlpha(sii);
            if (this.sio > this.sim) {
                this.sio = this.sim;
            }
            if (this.sio < this.sik) {
                this.sio = this.sik;
            }
            this.fC.setColor(sig);
            canvas.drawCircle((float) this.sic, (float) this.sid, this.sio, this.fC);
            if (this.sin > this.sil) {
                this.sin = this.sil;
            }
            if (this.sin < this.sij) {
                this.sin = this.sij;
            }
            this.fC.setColor(sih);
            canvas.drawCircle((float) this.sic, (float) this.sid, this.sin, this.fC);
        }
    }

    public final void stop() {
        reset();
        this.mIsPlaying = false;
        this.sif.TG();
        postInvalidate();
    }

    public final void reset() {
        this.sit = false;
        this.mVolume = -1.0f;
        this.mIsPlaying = false;
        this.sin = 0.0f;
        this.sio = 0.0f;
        postInvalidate();
    }
}
