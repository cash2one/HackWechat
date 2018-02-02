package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import com.tencent.mm.bg.e;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.4;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends com.tencent.mm.ui.tools.p {
    private VoiceSearchLayout qcc;
    public boolean vyU = true;
    int vyV;
    int vyW;
    a vyX;
    private a vyY = new 1(this);

    public p(byte b) {
        super(true, true);
    }

    public final void a(a aVar) {
        this.vyX = aVar;
        this.zms = aVar;
    }

    public final void o(VoiceSearchLayout voiceSearchLayout) {
        this.qcc = voiceSearchLayout;
        this.vyW = 1;
        if (1 == this.vyW) {
            this.vyV = 2;
        } else {
            this.vyV = 1;
        }
    }

    public final void cancel() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do cancel");
        if (this.qcc != null) {
            this.qcc.caz();
        }
        if (this.zmr != null) {
            this.zmr.np(true);
            this.zmr.nq(true);
        }
    }

    protected final boolean ccM() {
        boolean z = false;
        String str = "MicroMsg.VoiceSearchViewHelper";
        String str2 = "check has voice search, Enable %B, layout is null ? %B";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(this.vyU);
        if (this.qcc == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        return this.vyU;
    }

    protected final void ccN() {
        x.d("MicroMsg.VoiceSearchViewHelper", "do require voice search");
        if (this.zmr != null) {
            this.zmr.np(false);
            this.zmr.nq(false);
        }
        if (this.qcc != null && this.qcc.getVisibility() == 8) {
            x.d("MicroMsg.VoiceSearchViewHelper", "do voice search layout start");
            VoiceSearchLayout voiceSearchLayout = this.qcc;
            int i = this.vyW;
            x.i("MicroMsg.VoiceSearchLayout", "summerper checkPermission checkMicrophone[%b]", Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.aZ(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")));
            if (com.tencent.mm.pluginsdk.g.a.aZ(voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO")) {
                boolean z;
                x.d("MicroMsg.VoiceSearchLayout", "doStart " + voiceSearchLayout.fAs);
                voiceSearchLayout.vmA = i;
                voiceSearchLayout.fAs = true;
                voiceSearchLayout.vmz = false;
                if (voiceSearchLayout.vmx != null) {
                    voiceSearchLayout.vmx.caN();
                }
                voiceSearchLayout.setVisibility(0);
                voiceSearchLayout.kEu.J(50, 50);
                voiceSearchLayout.a(true, null);
                voiceSearchLayout.vmK = 0;
                voiceSearchLayout.vmE = new e(new 4(voiceSearchLayout), i);
                e eVar = voiceSearchLayout.vmE;
                x.i("MicroMsg.SceneVoiceAddr", "start record");
                if (eVar.hYh == 0 && an.is2G(ac.getContext())) {
                    z = true;
                } else {
                    z = false;
                }
                eVar.hYs = z;
                x.i("MicroMsg.SceneVoiceAddr", "mEnableAmrMode: %b", Boolean.valueOf(eVar.hYs));
                com.tencent.mm.sdk.f.e.post(new e.a(eVar), "SceneVoiceAddr_record");
            } else if (voiceSearchLayout.getContext() instanceof Activity) {
                com.tencent.mm.pluginsdk.g.a.g((Activity) voiceSearchLayout.getContext(), "android.permission.RECORD_AUDIO");
            }
        }
    }

    public final void a(Activity activity, Menu menu) {
        super.a(activity, menu);
        if (this.qcc != null) {
            this.qcc.vmx = this.vyY;
        }
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 == i) {
            boolean z = this.qcc != null && this.qcc.getVisibility() == 0;
            x.d("MicroMsg.VoiceSearchViewHelper", "on back key down, try hide voice search panel, it is visiable[%B]", Boolean.valueOf(z));
            cancel();
            if (z) {
                return true;
            }
        }
        x.d("MicroMsg.VoiceSearchViewHelper", "not match key code, pass to super");
        return super.onKeyDown(i, keyEvent);
    }

    protected final void ccO() {
        cancel();
    }
}
