package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.mm.pluginsdk.q$o;
import com.tencent.mm.sdk.platformtools.af;
import java.util.LinkedList;
import java.util.List;

public final class i {
    List<q$o> gxL = new LinkedList();
    af handler = new af(Looper.getMainLooper());

    public final void aWb() {
        Runnable 1 = new 1(this);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            1.run();
        } else {
            this.handler.post(1);
        }
    }

    public final void J(String str, int i, int i2) {
        Runnable 5 = new 5(this, str, i, i2);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            5.run();
        } else {
            this.handler.post(5);
        }
    }

    public final void rN(int i) {
        Runnable 7 = new 7(this, i);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            7.run();
        } else {
            this.handler.post(7);
        }
    }

    public final void DM(String str) {
        Runnable 8 = new 8(this, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            8.run();
        } else {
            this.handler.post(8);
        }
    }

    public final void j(int i, int i2, String str) {
        Runnable 9 = new 9(this, i, i2, str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            9.run();
        } else {
            this.handler.post(9);
        }
    }
}
