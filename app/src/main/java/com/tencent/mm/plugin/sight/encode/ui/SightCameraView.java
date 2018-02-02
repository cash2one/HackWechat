package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.d;
import com.tencent.mm.z.d.a;

public abstract class SightCameraView extends FrameLayout implements a {
    private d jtl;
    private Animation nKp;
    protected int ouX;
    private long qpU;
    protected long qxA;
    protected int qxB;
    protected boolean qxC;
    protected boolean qxD;
    protected int qxE;
    private ak qxF;
    private int qxG;
    private Runnable qxH;
    private Runnable qxI;
    protected e qxx;
    protected com.tencent.mm.plugin.sight.encode.a.a qxy;
    protected ImageView qxz;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Runnable gMQ = null;
        final /* synthetic */ SightCameraView qxJ;

        AnonymousClass4(SightCameraView sightCameraView, Runnable runnable) {
            this.qxJ = sightCameraView;
        }

        public final void run() {
        }

        public final String toString() {
            return super.toString() + "|stopRecord";
        }
    }

    protected abstract void aB(String str, boolean z);

    public abstract void at(float f);

    protected abstract void btJ();

    protected abstract int btK();

    protected abstract int btL();

    protected abstract void ig(boolean z);

    public abstract boolean isPlaying();

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        x.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.qxy == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ar.Dm().F(new AnonymousClass4(sightCameraView, null));
        sightCameraView.qxF.TG();
        sightCameraView.au(0.0f);
        sightCameraView.btM();
        sightCameraView.setKeepScreenOn(false);
    }

    public final void wp(int i) {
        this.ouX = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qxA = -1;
        this.qxB = a.qxM;
        this.qxC = false;
        this.qxD = false;
        this.ouX = 320;
        this.qxE = 6500;
        this.qpU = 0;
        this.qxF = new ak(Looper.getMainLooper(), new 1(this), true);
        this.qxG = -1;
        this.qxH = new 2(this);
        this.qxI = new 3(this);
        this.jtl = new d();
        if (com.tencent.mm.plugin.sight.base.d.bsB()) {
            inflate(getContext(), R.i.dsI, this);
        } else {
            inflate(getContext(), R.i.dsH, this);
        }
        this.qxC = false;
        this.qxD = false;
        this.qxx = new e();
        e eVar = this.qxx;
        x.i("MicroMsg.SightCamera", "init needRotate %s", new Object[]{Boolean.valueOf(false)});
        if (q.gFW.gGy) {
            eVar.qxu.otp = q.gFW.mVideoHeight;
            eVar.qxu.otq = q.gFW.mVideoWidth;
            eVar.qxu.oto = q.gFW.gGA;
        }
        eVar.qxu.otz = com.tencent.mm.compatible.d.d.getNumberOfCameras();
        eVar.qxu.fFy = 0;
        this.qxz = (ImageView) findViewById(R.h.cEa);
        btM();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void au(float f) {
        x.d("MicroMsg.SightCameraView", "update progress %f", new Object[]{Float.valueOf(f)});
        if (this.qxG < 0) {
            this.qxG = getResources().getDisplayMetrics().widthPixels;
        }
        if (f < 0.0f) {
            LayoutParams layoutParams = this.qxz.getLayoutParams();
            layoutParams.width = this.qxG;
            this.qxz.setLayoutParams(layoutParams);
        } else if (f > 1.0f) {
            r0 = (this.qxG / 2) - 1;
            r1 = this.qxz.getLayoutParams();
            r1.width = this.qxG - (r0 * 2);
            this.qxz.setLayoutParams(r1);
        } else {
            r0 = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            r1 = this.qxz.getLayoutParams();
            r1.width = this.qxG - (r0 * 2);
            this.qxz.setLayoutParams(r1);
        }
    }

    private void btM() {
        if (this.qxz.getVisibility() != 4) {
            if (this.nKp != null) {
                this.nKp.cancel();
            }
            this.qxz.setVisibility(4);
        }
    }

    protected final void aHv() {
        x.w("MicroMsg.SightCameraView", "cancel record");
        if (this.qxy == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ar.Dm().cfF().removeCallbacks(this.qxH);
        ar.Dm().F(this.qxI);
        this.qxF.TG();
        au(0.0f);
        btM();
        setKeepScreenOn(false);
    }

    protected final void btN() {
        this.jtl.a(this);
    }

    protected final void btO() {
        this.jtl.bx(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.qxC && this.qxD) {
            x.i("MicroMsg.SightCameraView", "check double click %dms", new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - this.qxA)});
            if (SystemClock.elapsedRealtime() - this.qxA < 400) {
                this.qxx.qxw.removeMessages(4354);
                e eVar = this.qxx;
                if (eVar.orS) {
                    Parameters parameters;
                    try {
                        parameters = eVar.gEB.getParameters();
                    } catch (Throwable e) {
                        x.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[]{e.getMessage()});
                        x.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        x.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[]{Boolean.valueOf(eVar.orQ), Boolean.valueOf(parameters.isZoomSupported())});
                        if (parameters.isZoomSupported()) {
                            eVar.qxw.removeMessages(4353);
                            if (eVar.orQ) {
                                eVar.qxw.osG = false;
                                eVar.qxw.orQ = false;
                                eVar.qxw.osF = e.a.d(parameters) * -1;
                                eVar.qxw.sendMessage(eVar.qxw.obtainMessage(4353, eVar.gEB));
                            } else {
                                eVar.qxw.osG = false;
                                eVar.qxw.orQ = true;
                                eVar.qxw.osF = e.a.d(parameters);
                                eVar.qxw.sendMessage(eVar.qxw.obtainMessage(4353, eVar.gEB));
                            }
                            if (!eVar.orQ) {
                                z = true;
                            }
                            eVar.orQ = z;
                        }
                    }
                } else {
                    x.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                e eVar2 = this.qxx;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int btK = btK();
                int btL = btL();
                if (!com.tencent.mm.compatible.util.d.fN(14)) {
                    eVar2.qxw.removeMessages(4354);
                    eVar2.qxw.osI = x;
                    eVar2.qxw.nJk = y;
                    eVar2.qxw.osJ = btK;
                    eVar2.qxw.osK = btL;
                    eVar2.qxw.sendMessageDelayed(eVar2.qxw.obtainMessage(4354, eVar2.gEB), 400);
                }
            }
            this.qxA = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.fN(14);
        }
        return true;
    }
}
