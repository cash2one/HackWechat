package com.google.android.gms.wearable;

import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.w.a;
import java.util.List;

class WearableListenerService$a extends a {
    boolean bdI = false;
    final /* synthetic */ WearableListenerService bdJ;

    WearableListenerService$a(WearableListenerService wearableListenerService) {
        this.bdJ = wearableListenerService;
        this.bdI = wearableListenerService instanceof zzj;
    }

    public final void a(DataHolder dataHolder) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onDataItemChanged: ").append(WearableListenerService.a(this.bdJ)).append(": ").append(dataHolder);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                dataHolder.close();
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 1(this, dataHolder));
        }
    }

    public final void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onEntityUpdate: ").append(amsEntityUpdateParcelable);
        }
        if (this.bdI) {
            WearableListenerService.b(this.bdJ);
            zzj com_google_android_gms_wearable_zzj = (zzj) this.bdJ;
            synchronized (WearableListenerService.c(this.bdJ)) {
                if (WearableListenerService.d(this.bdJ)) {
                    return;
                }
                WearableListenerService.e(this.bdJ).post(new 8(this, com_google_android_gms_wearable_zzj, amsEntityUpdateParcelable));
            }
        }
    }

    public final void a(AncsNotificationParcelable ancsNotificationParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onNotificationReceived: ").append(ancsNotificationParcelable);
        }
        if (this.bdI) {
            WearableListenerService.b(this.bdJ);
            zzj com_google_android_gms_wearable_zzj = (zzj) this.bdJ;
            synchronized (WearableListenerService.c(this.bdJ)) {
                if (WearableListenerService.d(this.bdJ)) {
                    return;
                }
                WearableListenerService.e(this.bdJ).post(new 7(this, com_google_android_gms_wearable_zzj, ancsNotificationParcelable));
            }
        }
    }

    public final void a(CapabilityInfoParcelable capabilityInfoParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onConnectedCapabilityChanged: ").append(capabilityInfoParcelable);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 6(this, capabilityInfoParcelable));
        }
    }

    public final void a(ChannelEventParcelable channelEventParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onChannelEvent: ").append(channelEventParcelable);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 9(this, channelEventParcelable));
        }
    }

    public final void a(MessageEventParcelable messageEventParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onMessageReceived: ").append(messageEventParcelable);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 2(this, messageEventParcelable));
        }
    }

    public final void a(NodeParcelable nodeParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onPeerConnected: ").append(WearableListenerService.a(this.bdJ)).append(": ").append(nodeParcelable);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 3(this, nodeParcelable));
        }
    }

    public final void b(NodeParcelable nodeParcelable) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onPeerDisconnected: ").append(WearableListenerService.a(this.bdJ)).append(": ").append(nodeParcelable);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 4(this, nodeParcelable));
        }
    }

    public final void u(List<NodeParcelable> list) {
        if (Log.isLoggable("WearableLS", 3)) {
            new StringBuilder("onConnectedNodes: ").append(WearableListenerService.a(this.bdJ)).append(": ").append(list);
        }
        WearableListenerService.b(this.bdJ);
        synchronized (WearableListenerService.c(this.bdJ)) {
            if (WearableListenerService.d(this.bdJ)) {
                return;
            }
            WearableListenerService.e(this.bdJ).post(new 5(this, list));
        }
    }
}
