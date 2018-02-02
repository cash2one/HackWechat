package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.booter.MMReceivers.AlarmReceiver;
import com.tencent.mm.sdk.platformtools.x;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class MMReceivers$BootReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            new StringBuilder("system booted, pid=").append(Process.myPid());
            if (!b.q(context, "auto")) {
                AlarmReceiver.aE(context);
                x.cfk();
            }
        }
    }
}
