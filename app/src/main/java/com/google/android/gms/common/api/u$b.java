package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;

class u$b implements Runnable {
    final /* synthetic */ u aLW;
    private final int aLX;
    private final ConnectionResult aLY;

    public u$b(u uVar, int i, ConnectionResult connectionResult) {
        this.aLW = uVar;
        this.aLX = i;
        this.aLY = connectionResult;
    }

    public final void run() {
        if (u.a(this.aLW) && !u.b(this.aLW)) {
            u.c(this.aLW);
            u.a(this.aLW, this.aLX);
            u.a(this.aLW, this.aLY);
            if (this.aLY.nQ()) {
                try {
                    this.aLY.a(this.aLW.getActivity(), ((this.aLW.getActivity().getSupportFragmentManager().aT().indexOf(this.aLW) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    u.d(this.aLW);
                }
            } else if (e.df(this.aLY.aJD)) {
                e.a(this.aLY.aJD, this.aLW.getActivity(), this.aLW, this.aLW);
            } else {
                u.a(this.aLW, this.aLX, this.aLY);
            }
        }
    }
}
