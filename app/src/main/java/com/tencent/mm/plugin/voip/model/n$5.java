package com.tencent.mm.plugin.voip.model;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;

class n$5 extends PhoneStateListener {
    final /* synthetic */ n sny;
    final /* synthetic */ TelephonyManager snz;

    n$5(n nVar, TelephonyManager telephonyManager) {
        this.sny = nVar;
        this.snz = telephonyManager;
    }

    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
        int i = 100;
        super.onSignalStrengthsChanged(signalStrength);
        String[] split = signalStrength.toString().split(" ");
        if (this.snz.getNetworkType() == 13) {
            if (split != null && split.length >= 10) {
                n.yK(Integer.parseInt(split[9]) + b.CTRL_INDEX);
            }
            this.sny.snp = "LTE";
        } else {
            int gsmSignalStrength = signalStrength.getGsmSignalStrength();
            if (signalStrength.isGsm() && gsmSignalStrength == 99) {
                n.yK(-1);
            } else {
                n.yK((int) (((float) gsmSignalStrength) * 3.2258065f));
            }
        }
        if (n.apD() <= 100) {
            i = n.apD();
        }
        n.yK(i);
        n.yK(n.apD() < 0 ? 0 : n.apD());
        n.f(this.sny);
    }
}
