package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.a;

public abstract class l$b {
    public l$a qnR;
    protected boolean qnS = false;
    protected long qnT = l.qnN;
    private af qnU = new af(new a(this) {
        final /* synthetic */ l$b qnV;

        {
            this.qnV = r1;
        }

        public final boolean handleMessage(Message message) {
            if (!(message.what != l.qnO || this.qnV.qnS || this.qnV.qnR == null)) {
                this.qnV.qnR.d(null, 5);
            }
            return false;
        }
    });

    public abstract void init();

    public abstract void pause();

    public abstract void reset();

    public abstract void resume();

    public abstract void start();

    public l$b(l$a com_tencent_mm_plugin_shake_b_l_a) {
        this.qnR = com_tencent_mm_plugin_shake_b_l_a;
    }

    public void brp() {
        reset();
        this.qnR = null;
    }
}
