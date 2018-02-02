package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static boolean a(AudioManager audioManager) {
        if (aq.vd()) {
            return false;
        }
        x.i("MicroMsg.BluetoothUtil", "stop DeviceInfo mCommonInfo getStartBluetoothSco:%s,getStopBluetoothInBU:%s ", Integer.valueOf(q.gGe.gEF), Integer.valueOf(q.gGe.gEE));
        if ((q.gGe.gEE == 1 || q.gGe.gEF == -1) && audioManager.isBluetoothScoOn()) {
            x.i("MicroMsg.BluetoothUtil", "BluetoothUtil stopBluetoothSco stack: %s", bh.cgy());
            audioManager.stopBluetoothSco();
        }
        return true;
    }
}
