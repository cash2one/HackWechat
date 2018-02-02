package com.tencent.rtmp.sharp.jni;

import android.content.Intent;
import java.util.ArrayList;

class TraeAudioManager$2 implements Runnable {
    final /* synthetic */ ArrayList a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ TraeAudioManager d;

    TraeAudioManager$2(TraeAudioManager traeAudioManager, ArrayList arrayList, String str, String str2) {
        this.d = traeAudioManager;
        this.a = arrayList;
        this.b = str;
        this.c = str2;
    }

    public void run() {
        Intent intent = new Intent();
        intent.setAction(TraeAudioManager.ACTION_TRAEAUDIOMANAGER_NOTIFY);
        intent.putExtra(TraeAudioManager.PARAM_OPERATION, TraeAudioManager.NOTIFY_DEVICELIST_UPDATE);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_AVAILABLEDEVICE_LIST, (String[]) this.a.toArray(new String[0]));
        intent.putExtra(TraeAudioManager.EXTRA_DATA_CONNECTEDDEVICE, this.b);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_PREV_CONNECTEDDEVICE, this.c);
        intent.putExtra(TraeAudioManager.EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME, this.d._deviceConfigManager.d());
        if (this.d._context != null) {
            this.d._context.sendBroadcast(intent);
        }
    }
}
