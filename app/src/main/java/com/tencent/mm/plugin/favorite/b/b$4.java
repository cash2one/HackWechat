package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.sdk.platformtools.x;

class b$4 implements Runnable {
    final /* synthetic */ b mrg;

    b$4(b bVar) {
        this.mrg = bVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis() - this.mrg.flU;
        if (this.mrg.flS) {
            if (currentTimeMillis >= 300000) {
                x.e("MicroMsg.Fav.FavCdnService", "klem ERR: Try Run service runningFlag:" + this.mrg.flS + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + this.mrg.flS);
            } else {
                return;
            }
        }
        x.i("MicroMsg.Fav.FavCdnService", "do run cdn job, wait time %d", new Object[]{Long.valueOf(currentTimeMillis)});
        this.mrg.flR = false;
        this.mrg.flS = true;
        this.mrg.mrd = 0;
        this.mrg.flT = 3;
        this.mrg.flY.J(100, 100);
    }

    public final String toString() {
        return super.toString() + "|run";
    }
}
