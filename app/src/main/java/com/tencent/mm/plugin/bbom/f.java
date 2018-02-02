package com.tencent.mm.plugin.bbom;

import android.app.Service;
import android.content.IntentFilter;
import com.tencent.mm.booter.TrafficStatsReceiver;
import com.tencent.mm.modelfriend.AddrBookObserver;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.plugin.zero.a.a;

public final class f implements a {
    private TrafficStatsReceiver kvA;
    private AddrBookObserver kvy;
    private WatchDogPushReceiver kvz;

    public final void a(Service service) {
        this.kvy = new AddrBookObserver(service);
        service.getContentResolver().registerContentObserver(com.tencent.mm.pluginsdk.a.bXW(), true, this.kvy);
        this.kvz = new WatchDogPushReceiver();
        service.registerReceiver(this.kvz, new IntentFilter("com.tencent.mm.WatchDogPushReceiver"));
        this.kvA = new TrafficStatsReceiver();
        service.registerReceiver(this.kvA, new IntentFilter("com.tencent.mm.TrafficStatsReceiver"));
        TrafficStatsReceiver.aF(service);
    }

    public final void b(Service service) {
        service.getContentResolver().unregisterContentObserver(this.kvy);
        service.unregisterReceiver(this.kvz);
        service.unregisterReceiver(this.kvA);
        TrafficStatsReceiver.aG(service);
    }
}
