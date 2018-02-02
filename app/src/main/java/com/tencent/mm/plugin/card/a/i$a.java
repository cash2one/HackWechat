package com.tencent.mm.plugin.card.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.os.Build.VERSION;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class i$a {
    public BroadcastReceiver jjH;
    private BluetoothAdapter jjJ;
    final /* synthetic */ i kJj;
    private volatile boolean kJk;
    boolean kJl;
    Map<String, i$b> kJm;
    long kJn;
    Runnable kJo;
    private LeScanCallback kJp;

    private i$a(i iVar) {
        this.kJj = iVar;
        this.kJk = false;
        this.kJl = false;
        this.kJm = new ConcurrentHashMap();
        this.kJn = 3000;
        this.kJo = new Runnable(this) {
            final /* synthetic */ i$a kJq;

            {
                this.kJq = r1;
            }

            public final void run() {
                this.kJq.aui();
                this.kJq.auh();
            }
        };
        this.kJp = new 3(this);
    }

    public final void reset() {
        this.kJm.clear();
    }

    public final i$b aug() {
        i$b com_tencent_mm_plugin_card_a_i_b = new i$b("", -100, "", null);
        if (this.kJm.size() <= 0) {
            return com_tencent_mm_plugin_card_a_i_b;
        }
        i$b com_tencent_mm_plugin_card_a_i_b2 = com_tencent_mm_plugin_card_a_i_b;
        for (i$b com_tencent_mm_plugin_card_a_i_b3 : this.kJm.values()) {
            if (com_tencent_mm_plugin_card_a_i_b2.ftq >= com_tencent_mm_plugin_card_a_i_b3.ftq) {
                com_tencent_mm_plugin_card_a_i_b3 = com_tencent_mm_plugin_card_a_i_b2;
            }
            com_tencent_mm_plugin_card_a_i_b2 = com_tencent_mm_plugin_card_a_i_b3;
        }
        return com_tencent_mm_plugin_card_a_i_b2;
    }

    @TargetApi(18)
    public final void auh() {
        if (VERSION.SDK_INT < 18) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        } else if (this.kJk) {
            x.i("MicroMsg.CardLbsOrBluetooth", "already start");
        } else {
            this.kJm.clear();
            BluetoothManager bluetoothManager = (BluetoothManager) ac.getContext().getSystemService("bluetooth");
            if (bluetoothManager == null) {
                this.kJl = false;
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothManager is null");
                return;
            }
            this.kJl = true;
            this.jjJ = bluetoothManager.getAdapter();
            if (this.jjJ == null || !this.jjJ.isEnabled()) {
                this.kJl = false;
                x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
                return;
            }
            boolean startLeScan = this.jjJ.startLeScan(this.kJp);
            x.i("MicroMsg.CardLbsOrBluetooth", "startLeScan isOK:%b", new Object[]{Boolean.valueOf(startLeScan)});
            this.kJk = true;
        }
    }

    @TargetApi(18)
    public final void aui() {
        if (VERSION.SDK_INT < 18) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not support bluetooth, return");
        } else if (!this.kJk) {
            x.i("MicroMsg.CardLbsOrBluetooth", "not start");
        } else if (this.jjJ == null || !this.jjJ.isEnabled()) {
            this.kJl = false;
            x.e("MicroMsg.CardLbsOrBluetooth", "bluetoothAdapter is null or bluetoothAdapter is disable");
        } else {
            this.kJl = true;
            this.jjJ.stopLeScan(this.kJp);
            x.i("MicroMsg.CardLbsOrBluetooth", "stopLeScan");
            this.kJk = false;
        }
    }

    public static byte[] ag(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr != null) {
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i != 0) {
                    i--;
                    int i3 = i2 + 1;
                    switch (bArr[i2] & 255) {
                        case 255:
                            bArr2 = new byte[i];
                            System.arraycopy(bArr, i3, bArr2, 0, i);
                            break;
                        default:
                            break;
                    }
                    i += i3;
                }
            }
        }
        return bArr2;
    }
}
