package com.tencent.mm.plugin.g.a.c;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.UUID;
import junit.framework.Assert;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public final class a {
    public static final UUID kzN = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public static final UUID kzO = UUID.fromString("e5b152ed-6b46-09e9-4678-665e9a972cbc");
    public final BroadcastReceiver jhN = new BroadcastReceiver(this) {
        final /* synthetic */ a kzR;

        {
            this.kzR = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                x.i("MicroMsg.exdevice.BluetoothChatManager", "------onReceive------ action  = " + action);
                BluetoothDevice bluetoothDevice;
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    if (bluetoothDevice.getBondState() != 12) {
                        this.kzR.kzP.bL(bluetoothDevice.getAddress(), bluetoothDevice.getName());
                    }
                } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    this.kzR.kzP.arl();
                } else if ("android.bluetooth.adapter.action.SCAN_MODE_CHANGED".equals(action)) {
                    a aVar;
                    switch (intent.getIntExtra("android.bluetooth.adapter.extra.SCAN_MODE", -1)) {
                        case 20:
                        case 21:
                            aVar = this.kzR.kzP;
                            return;
                        case 23:
                            aVar = this.kzR.kzP;
                            return;
                        default:
                            return;
                    }
                } else if ("android.bluetooth.device.action.ACL_DISCONNECTED".equals(action)) {
                    String address = ((BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE")).getAddress();
                    if (this.kzR.kwL.containsKey(Long.valueOf(b.zu(address)))) {
                        x.i("MicroMsg.exdevice.BluetoothChatManager", "------ACTION_ACL_DISCONNECTED------ device name = %s, device Mac = %s", bluetoothDevice.getName(), address);
                        if (this.kzR.kzP != null) {
                            this.kzR.kzP.g(b.zu(address), false);
                        }
                    }
                }
            }
        }
    };
    public HashMap<Long, b> kwL = new HashMap();
    public BluetoothAdapter kwe;
    public a kzP;
    public Context kzQ;
    public af mHandler;
    public boolean mIsInit = false;
    private Runnable mRunnable;

    public a(ag agVar) {
        this.mHandler = new af(agVar.oAt.getLooper());
        this.mRunnable = new Runnable(this) {
            final /* synthetic */ a kzR;

            {
                this.kzR = r1;
            }

            public final void run() {
                if (this.kzR.kwe.isDiscovering()) {
                    this.kzR.kwe.cancelDiscovery();
                }
            }
        };
    }

    public final boolean art() {
        Assert.assertTrue(this.mIsInit);
        if (this.kwe == null) {
            return false;
        }
        return true;
    }

    private boolean aru() {
        if (!this.kwe.isDiscovering()) {
            return true;
        }
        if (this.kwe.cancelDiscovery()) {
            this.mHandler.removeCallbacks(this.mRunnable);
            return true;
        }
        x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.cancelDiscovery Failed!!!");
        return false;
    }

    public final boolean dS(boolean z) {
        x.i("MicroMsg.exdevice.BluetoothChatManager", "scanDevices" + (z ? "true" : "false"));
        Assert.assertTrue(this.mIsInit);
        if (!art()) {
            x.e("MicroMsg.exdevice.BluetoothChatManager", "BC Unsupport!!!");
            return false;
        } else if (!z) {
            return aru();
        } else {
            if (this.kwe.isDiscovering() && !aru()) {
                return false;
            }
            if (this.kwe.startDiscovery()) {
                this.mHandler.postDelayed(this.mRunnable, 10000);
                return true;
            }
            x.e("MicroMsg.exdevice.BluetoothChatManager", "mAdapter.startDiscovery() Failed");
            return false;
        }
    }
}
