package com.tencent.mars.comm;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

public class NetStatusUtil$StrengthListener extends PhoneStateListener {
    public void onSignalStrengthsChanged(SignalStrength signalStrength) {
        super.onSignalStrengthsChanged(signalStrength);
        if (signalStrength.isGsm()) {
            NetStatusUtil.access$002(signalStrength.getGsmSignalStrength());
        } else {
            NetStatusUtil.access$002(signalStrength.getCdmaDbm());
        }
    }
}
