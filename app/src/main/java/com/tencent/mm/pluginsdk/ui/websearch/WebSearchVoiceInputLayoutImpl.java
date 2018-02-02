package com.tencent.mm.pluginsdk.ui.websearch;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.VoiceInputLayout;
import com.tencent.mm.pluginsdk.ui.m;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

@TargetApi(16)
public class WebSearchVoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener ozr = new 2(this);
    private View vmf;
    private m vmg;
    private boolean vmh = false;
    private long vmi;
    private OnLongClickListener vmj = new 1(this);

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public WebSearchVoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
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
        x.d("MicroMsg.WebSearchVoiceInputLayoutImpl", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.vlD), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.vlD == 1) {
            if (z || z2) {
                if (z && !z2) {
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
                    return;
                }
                return;
            }
            bb();
        } else if (!z && !z2) {
            caz();
        } else if (z && !z2) {
            this.vmg.car();
        }
    }

    private void caH() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ WebSearchVoiceInputLayoutImpl vzr;

            {
                this.vzr = r1;
            }

            public final void run() {
                this.vzr.vmg.cau();
            }
        });
        caA();
    }

    private static boolean caI() {
        int Km = ar.CG().Km();
        return Km == 4 || Km == 6;
    }

    protected final void kX(boolean z) {
        runOnUiThread(new 4(this, true));
    }

    protected final void cJ(boolean z) {
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
}
