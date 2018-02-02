package com.tencent.mm.sandbox.updater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.sdk.platformtools.an;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20141015", reviewer = 20, vComment = {EType.RECEIVERCHECK})
final class UpdaterService$a extends BroadcastReceiver {
    UpdaterService$a() {
    }

    public final void onReceive(Context context, Intent intent) {
        if (UpdaterService.ceG() != null) {
            UpdaterService ceG = UpdaterService.ceG();
            boolean isWifi = an.isWifi(context);
            if (ceG.xdN.size() > 0) {
                for (a lv : ceG.xdN.values()) {
                    lv.lv(isWifi);
                }
            }
        }
    }
}
