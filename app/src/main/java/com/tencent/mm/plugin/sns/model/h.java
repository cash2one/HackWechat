package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.af;
import junit.framework.Assert;

public abstract class h<Params, Progress, Result> {
    private boolean fAs = false;
    af handler = ae.aNT();

    public abstract af buO();

    public abstract Result buP();

    public final boolean m(Params... paramsArr) {
        if (this.fAs) {
            Assert.assertTrue("MicroMsg.MMAsyncTask Should construct a new Task", false);
        }
        this.fAs = true;
        af buO = buO();
        if (buO == null) {
            return false;
        }
        buO.post(new 1(this, paramsArr));
        return true;
    }

    public void onPostExecute(Result result) {
    }
}
