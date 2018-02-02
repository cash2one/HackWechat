package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.bg.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Set;

public abstract class VoiceInputLayout extends LinearLayout {
    af jzN = new 1(this);
    private final ak kEu = new ak(new 4(this), true);
    public int vlD = 1;
    public b vlX = null;
    private f vlY;
    protected boolean vlZ = false;
    int vma = 3000;
    int vmb = 10000;
    public a vmc;
    private af vmd = new 3(this);

    public interface a {
        void caB();
    }

    public interface b {
        void af(int i, int i2, int i3);

        void b(String[] strArr, Set<String> set);

        void caC();

        void caD();

        void caE();

        void caF();

        void caG();
    }

    public abstract void BT(int i);

    public abstract void cJ(boolean z);

    public abstract void kX(boolean z);

    public abstract void onReset();

    public final void kW(boolean z) {
        this.vlZ = z;
    }

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void cay() {
        if (com.tencent.mm.p.a.aW(getContext()) || com.tencent.mm.p.a.aU(getContext())) {
            x.d("MicroMsg.VoiceInputLayout", "voip is running, cann't record voice");
            onReset();
            return;
        }
        x.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.aZ(getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.g.a.aZ(getContext(), "android.permission.RECORD_AUDIO")) {
            x.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.vlD));
            if (this.vlD == 1) {
                this.vlD = 2;
                if (this.vlX != null) {
                    this.vlX.caC();
                }
                this.kEu.J(50, 50);
                kX(true);
                this.vlY = new f(new 2(this));
                f fVar = this.vlY;
                x.i("MicroMsg.SceneVoiceInputAddr", "start record");
                e.b(new com.tencent.mm.bg.f.a(fVar, (byte) 0), "SceneVoiceInputAddr_record", 10);
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.g.a.g((Activity) getContext(), "android.permission.RECORD_AUDIO");
        }
    }

    public final void caz() {
        x.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.vlD));
        if (this.vlD != 1) {
            this.vlD = 1;
            if (this.vlX != null) {
                this.vlX.caE();
            }
            if (this.vlY != null) {
                this.vlY.al(true);
            }
            onReset();
        }
    }

    public final void bb() {
        x.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.vlD));
        if (this.vlD != 1 && this.vlD == 2) {
            this.vlD = 3;
            if (this.vlX != null) {
                this.vlX.caD();
            }
            if (this.kEu != null) {
                this.kEu.TG();
            }
            this.jzN.removeMessages(0);
            this.jzN.sendEmptyMessageDelayed(0, (long) this.vma);
            this.jzN.sendEmptyMessageDelayed(1, (long) this.vmb);
            cJ(true);
            if (this.vlY != null) {
                this.vlY.aL(true);
            }
        }
    }

    public final void caA() {
        ae(12, -1, -1);
    }

    public final void ae(int i, int i2, int i3) {
        x.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.vlD = 1;
        onReset();
        if (this.vlX != null) {
            this.vlX.af(i, i2, i3);
        }
    }

    public final void reset(boolean z) {
        x.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.vlD));
        if (this.vlD != 1) {
            this.vlD = 1;
            onReset();
            if (z && this.vlX != null) {
                this.vlX.caF();
            }
        }
    }
}
