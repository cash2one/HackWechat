package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.Set;

class a$1 implements Runnable {
    final /* synthetic */ Set nYT;
    final /* synthetic */ WeakReference nYU;
    final /* synthetic */ a nYV;

    public a$1(a aVar, Set set, WeakReference weakReference) {
        this.nYV = aVar;
        this.nYT = set;
        this.nYU = weakReference;
    }

    public final void run() {
        try {
            for (String str : this.nYT) {
                if (this.nYU.get() == null || this.nYV.kpn) {
                    x.i("AsyncSoundPool", "context = null or soundPool is stopped");
                    this.nYV.nYQ.release();
                    this.nYV.nYR.clear();
                    this.nYV.nYS.clear();
                    return;
                }
                this.nYV.nYR.put(str, Integer.valueOf(this.nYV.nYQ.load(((Context) this.nYU.get()).getResources().getAssets().openFd(str), 0)));
            }
        } catch (Exception e) {
            x.e("AsyncSoundPool", "load sound file error:" + e.getMessage());
        }
    }
}
