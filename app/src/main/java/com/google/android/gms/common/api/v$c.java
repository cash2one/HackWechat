package com.google.android.gms.common.api;

import android.content.IntentSender.SendIntentException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;

class v$c implements Runnable {
    private final int aLX;
    private final ConnectionResult aLY;
    final /* synthetic */ v aMb;

    public v$c(v vVar, int i, ConnectionResult connectionResult) {
        this.aMb = vVar;
        this.aLX = i;
        this.aLY = connectionResult;
    }

    public final void run() {
        if (this.aLY.nQ()) {
            try {
                this.aLY.a(this.aMb.getActivity(), ((this.aMb.getActivity().getSupportFragmentManager().aT().indexOf(this.aMb) + 1) << 16) + 1);
            } catch (SendIntentException e) {
                v.a(this.aMb);
            }
        } else if (e.df(this.aLY.aJD)) {
            e.a(this.aLY.aJD, this.aMb.getActivity(), this.aMb, this.aMb);
        } else {
            v.a(this.aMb, this.aLX, this.aLY);
        }
    }
}
