package android.support.v4.os;

import android.os.Bundle;

class ResultReceiver$b implements Runnable {
    final /* synthetic */ ResultReceiver vF;
    final int vG;
    final Bundle vH;

    public ResultReceiver$b(ResultReceiver resultReceiver, int i, Bundle bundle) {
        this.vF = resultReceiver;
        this.vG = i;
        this.vH = bundle;
    }

    public final void run() {
        this.vF.onReceiveResult(this.vG, this.vH);
    }
}
