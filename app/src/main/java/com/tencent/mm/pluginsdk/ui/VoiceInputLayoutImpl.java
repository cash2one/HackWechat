package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.bq.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener ozr = new 2(this);
    private View vmf;
    private m vmg;
    private boolean vmh = false;
    private long vmi;
    private OnLongClickListener vmj = new 1(this);

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.vmf = inflate(context, R.i.dty, this).findViewById(R.h.cWY);
        this.vmf.setLayerType(1, null);
        this.vmg = new m(context);
        this.vmf.setBackground(this.vmg);
        this.vmf.setEnabled(true);
        this.vmf.setOnTouchListener(this.ozr);
        this.vmf.setOnLongClickListener(this.vmj);
        reset(true);
        if (!isInEditMode() && !caI()) {
            caH();
        }
    }

    public final void O(boolean z, boolean z2) {
        x.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.vlD), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.vlD == 1) {
            if (z || z2) {
                if (z && !z2) {
                    Z(4, this.vmh);
                    Z(this.vlD, this.vmh);
                    this.vmg.car();
                }
            } else if (caI()) {
                cay();
            } else {
                caH();
            }
        } else if (this.vlD == 2) {
            if (z2) {
                this.vmg.car();
                caz();
                if (this.vmc != null) {
                    this.vmc.caB();
                }
                Z(5, this.vmh);
                return;
            }
            if (z) {
                Z(4, this.vmh);
            }
            Z(this.vlD, this.vmh);
            bb();
        } else if (!z && !z2) {
            Z(this.vlD, this.vmh);
            caz();
        } else if (z && !z2) {
            Z(4, this.vmh);
            Z(this.vlD, this.vmh);
            this.vmg.car();
        }
    }

    private void caH() {
        runOnUiThread(new 3(this));
        caA();
    }

    private static boolean caI() {
        int Km = ar.CG().Km();
        return Km == 4 || Km == 6;
    }

    protected final void kX(boolean z) {
        runOnUiThread(new Runnable(this, true) {
            final /* synthetic */ VoiceInputLayoutImpl vmk;

            public final void run() {
                this.vmk.vmg.kU(true);
            }
        });
    }

    protected final void cJ(boolean z) {
        if (!z) {
            Z(17, false);
        }
        runOnUiThread(new 5(this));
    }

    protected final void onReset() {
        runOnUiThread(new 6(this));
    }

    protected final void BT(int i) {
        runOnUiThread(new 7(this, i));
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            ag.y(runnable);
        } else {
            runnable.run();
        }
    }

    private void Z(int i, boolean z) {
        a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.vlZ) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.vmh || this.vmi == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = bh.bA(this.vmi);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.vmh || this.vmi == 0)) {
                voiceInputBehavior.longClickTime = bh.bA(this.vmi);
            }
        }
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.pQN.c(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
        x.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
    }
}
