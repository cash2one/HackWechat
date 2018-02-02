package com.google.android.gms.analytics.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.w;

class g extends BroadcastReceiver {
    static final String aFn = g.class.getName();
    final q aFo;
    boolean aFp;
    boolean aFq;

    g(q qVar) {
        w.ag(qVar);
        this.aFo = qVar;
    }

    void mo() {
        this.aFo.mS();
        this.aFo.mU();
    }

    boolean mp() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.aFo.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (SecurityException e) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        mo();
        String action = intent.getAction();
        this.aFo.mS().c("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean mp = mp();
            if (this.aFq != mp) {
                this.aFq = mp;
                n mU = this.aFo.mU();
                mU.c("Network connectivity status changed", Boolean.valueOf(mp));
                mU.aFo.mT().d(new m$1(mU, mp));
            }
        } else if (!"com.google.analytics.RADIO_POWERED".equals(action)) {
            this.aFo.mS().e("NetworkBroadcastReceiver received unknown action", action);
        } else if (!intent.hasExtra(aFn)) {
            m mU2 = this.aFo.mU();
            mU2.au("Radio powered up");
            mU2.mJ();
        }
    }

    public final void unregister() {
        if (this.aFp) {
            this.aFo.mS().au("Unregistering connectivity change receiver");
            this.aFp = false;
            this.aFq = false;
            try {
                this.aFo.mContext.unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.aFo.mS().f("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
