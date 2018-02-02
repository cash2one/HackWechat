package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.e;
import com.tencent.mm.plugin.g.a.e.a;
import com.tencent.mm.sdk.platformtools.x;

class ExdeviceAddDataSourceUI$4 extends BroadcastReceiver {
    final /* synthetic */ ExdeviceAddDataSourceUI lRL;

    ExdeviceAddDataSourceUI$4(ExdeviceAddDataSourceUI exdeviceAddDataSourceUI) {
        this.lRL = exdeviceAddDataSourceUI;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.i("MicroMsg.ExdeviceAddDataSourceUI", "Receive action broadcast failed...");
            return;
        }
        String action = intent.getAction();
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 12) {
                if (a.arv()) {
                    this.lRL.runOnUiThread(new Runnable(this) {
                        final /* synthetic */ ExdeviceAddDataSourceUI$4 lRO;

                        {
                            this.lRO = r1;
                        }

                        public final void run() {
                            if (!ExdeviceAddDataSourceUI.a(this.lRO.lRL) || ExdeviceAddDataSourceUI.b(this.lRO.lRL).isProviderEnabled("gps")) {
                                ExdeviceAddDataSourceUI.a(this.lRO.lRL, 3);
                                x.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                                return;
                            }
                            ExdeviceAddDataSourceUI.a(this.lRO.lRL, 4);
                        }
                    });
                    if (!ExdeviceAddDataSourceUI.a(this.lRL) || ExdeviceAddDataSourceUI.b(this.lRL).isProviderEnabled("gps")) {
                        ad.aEv();
                        e.aDX();
                    }
                }
            } else if (intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10 && !a.arv()) {
                this.lRL.runOnUiThread(new 2(this));
                ad.aEw().arf();
            }
        }
        if (!ExdeviceAddDataSourceUI.a(this.lRL) || !"android.location.MODE_CHANGED".equals(action)) {
            return;
        }
        if (ExdeviceAddDataSourceUI.b(this.lRL).isProviderEnabled("gps")) {
            this.lRL.runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceAddDataSourceUI$4 lRO;

                {
                    this.lRO = r1;
                }

                public final void run() {
                    if (a.arv()) {
                        ExdeviceAddDataSourceUI.a(this.lRO.lRL, 3);
                        x.i("MicroMsg.ExdeviceAddDataSourceUI", "Start scan...");
                        return;
                    }
                    ExdeviceAddDataSourceUI.a(this.lRO.lRL, 1);
                }
            });
            if (a.arv()) {
                ad.aEv();
                e.aDX();
                return;
            }
            return;
        }
        this.lRL.runOnUiThread(new 4(this));
        ad.aEw().arf();
    }
}
