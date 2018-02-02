package com.tencent.mm.pluginsdk.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.af;
import junit.framework.Assert;

public abstract class l<Params, Progress, Result> {
    private boolean fAs = false;
    af handler = new af(Looper.getMainLooper());

    public abstract af buO();

    public abstract Result buP();

    public final boolean m(Params... paramsArr) {
        if (this.fAs) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fAs = true;
        n(paramsArr);
        af buO = buO();
        if (buO == null) {
            return false;
        }
        buO.post(new 1(this, paramsArr));
        return true;
    }

    public void n(Params... paramsArr) {
    }

    public void onPostExecute(Result result) {
    }
}
