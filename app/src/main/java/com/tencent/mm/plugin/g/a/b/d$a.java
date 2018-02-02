package com.tencent.mm.plugin.g.a.b;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.UUID;
import junit.framework.Assert;

class d$a extends af {
    private final WeakReference<d> kxt;

    public d$a(Looper looper, d dVar) {
        super(looper);
        this.kxt = new WeakReference(dVar);
    }

    public final void handleMessage(Message message) {
        boolean z = true;
        d dVar = (d) this.kxt.get();
        if (dVar == null) {
            x.e("MicroMsg.exdevice.BluetoothLESession", "null == BluetoothLESession");
            return;
        }
        byte[] ari;
        int i;
        int i2;
        switch (message.what) {
            case 0:
                x.i("MicroMsg.exdevice.BluetoothLESession", "------connectImp------");
                if (1 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connected !!!");
                    return;
                } else if (dVar.kxq == 0) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Remote device is connecting !!!");
                    return;
                } else {
                    dVar.arn();
                    if (dVar.kxf == null) {
                        dVar.kxf = dVar.kxd.connectGatt(dVar.kxe, false, dVar.kxr);
                        if (dVar.kxf == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "mDevice.connectGatt Failed!!!");
                            if (dVar.kxg != null) {
                                dVar.kxg.kwK.g(dVar.mSessionId, false);
                                return;
                            }
                            return;
                        }
                        dVar.kxq = 0;
                        dVar.mHandler.postDelayed(dVar.kxm, 10000);
                        return;
                    } else if (dVar.kxf.connect()) {
                        dVar.kxq = 0;
                        dVar.mHandler.postDelayed(dVar.kxm, 10000);
                        return;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "mBluetoothGatt.connect() Failed!!!");
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                }
            case 1:
                x.i("MicroMsg.exdevice.BluetoothLESession", "------disconnectImp------");
                if (3 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "diconnect or close is called aready, just leave");
                    return;
                }
                dVar.arn();
                if (dVar.kxf == null) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "disconnect:BluetoothGatt not found");
                    return;
                }
                dVar.kxq = 3;
                dVar.mHandler.removeCallbacks(dVar.kxm);
                dVar.mHandler.removeCallbacks(dVar.kxl);
                dVar.kxf.disconnect();
                return;
            case 2:
                x.i("MicroMsg.exdevice.BluetoothLESession", "------closeImp------");
                if (3 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Close aready, Just leave");
                    return;
                }
                dVar.arn();
                if (dVar.kxf == null) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "close:BluetoothGatt not found");
                    return;
                }
                dVar.kxq = 3;
                dVar.kxf.disconnect();
                dVar.kxf.close();
                dVar.kxf = null;
                return;
            case 3:
                x.i("MicroMsg.exdevice.BluetoothLESession", "------writeDataAsync------ length = %d", new Object[]{Integer.valueOf(((byte[]) message.obj).length)});
                if (1 != dVar.kxq) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "Not ready for write data, connectstate = %d", new Object[]{Integer.valueOf(dVar.kxq)});
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.h(dVar.mSessionId, false);
                        return;
                    }
                    return;
                }
                boolean z2 = (dVar.kxf == null || dVar.kxi == null) ? false : true;
                Assert.assertTrue(z2);
                dVar.kxo.add(ari);
                if (!dVar.kxp) {
                    if (1 != dVar.kxo.size()) {
                        z = false;
                    }
                    Assert.assertTrue(z);
                    dVar.aro();
                    return;
                }
                return;
            case 4:
                i = message.arg1;
                String str = "MicroMsg.exdevice.BluetoothLESession";
                String str2 = "------onConnectionStateChangeImp------ aState = %s";
                Object[] objArr = new Object[1];
                objArr[0] = i == 2 ? "Connected" : "Disconnected";
                x.i(str, str2, objArr);
                if (i == 2) {
                    x.i("MicroMsg.exdevice.BluetoothLESession", "PHY Connected is OK, mConnectState = %d", new Object[]{Integer.valueOf(dVar.kxq)});
                    if (3 == dVar.kxq) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Leave without discover Services");
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        return;
                    } else if (1 == dVar.kxq) {
                        x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Leave without discover Services");
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        return;
                    } else if (dVar.kxf.discoverServices()) {
                        x.i("MicroMsg.exdevice.BluetoothLESession", "start discoverServices...");
                        return;
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "discover Services start failed!!!");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                } else if (i == 0) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Disconnected from GATT server.");
                    dVar.kxq = 2;
                    dVar.mHandler.removeCallbacks(dVar.kxm);
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.g(dVar.mSessionId, false);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 5:
                BluetoothGatt bluetoothGatt = (BluetoothGatt) message.obj;
                x.i("MicroMsg.exdevice.BluetoothLESession", "onServicesDiscoveredImp, status = %d", new Object[]{Integer.valueOf(message.arg1)});
                if (3 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                    dVar.mHandler.removeCallbacks(dVar.kxm);
                    return;
                } else if (1 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                    dVar.mHandler.removeCallbacks(dVar.kxm);
                    return;
                } else if (i != 0) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "Discover services error");
                    dVar.kxq = 2;
                    dVar.mHandler.removeCallbacks(dVar.kxm);
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.g(dVar.mSessionId, false);
                        return;
                    }
                    return;
                } else {
                    BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(h.kxV));
                    if (service == null) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find service(with UUID 0xfee7)");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    dVar.kxh = service.getCharacteristic(UUID.fromString(h.kxX));
                    if (dVar.kxh == null) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec8)");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    dVar.kxi = service.getCharacteristic(UUID.fromString(h.kxW));
                    if (dVar.kxi == null) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Can't not find characteristic(with UUID 0xfec7)");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.exdevice.BluetoothLESession", "mRecvCharacteristic.getProperties = %d", new Object[]{Integer.valueOf(dVar.kxh.getProperties())});
                    if ((dVar.kxh.getProperties() & 32) == 0) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Read characteristic can not be indicated");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    x.i("MicroMsg.exdevice.BluetoothLESession", "Set read characteristic indicator");
                    d dVar2 = dVar.kxn;
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = dVar.kxh;
                    if (dVar2.kxf.setCharacteristicNotification(bluetoothGattCharacteristic, true)) {
                        BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(h.kxU));
                        if (descriptor == null) {
                            x.e("MicroMsg.exdevice.BluetoothLESession", "Can not get configure descriptor");
                            z = false;
                        } else {
                            x.i("MicroMsg.exdevice.BluetoothLESession", "Configure descriptor permissions: " + descriptor.getPermissions());
                            if (!descriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE)) {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "Can not set configure descriptor value");
                                z = false;
                            } else if (dVar2.kxf.writeDescriptor(descriptor)) {
                                dVar2.mHandler.postDelayed(dVar2.kxl, 5000);
                            } else {
                                x.e("MicroMsg.exdevice.BluetoothLESession", "Can not write configure descriptor value");
                                z = false;
                            }
                        }
                    } else {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "Unable to set indicator for read characteristic");
                        z = false;
                    }
                    if (!z) {
                        x.e("MicroMsg.exdevice.BluetoothLESession", "mSelfSession.setCharacteristicNotification Failed!!!");
                        dVar.kxq = 2;
                        dVar.mHandler.removeCallbacks(dVar.kxm);
                        if (dVar.kxg != null) {
                            dVar.kxg.kwK.g(dVar.mSessionId, false);
                            return;
                        }
                        return;
                    }
                    return;
                }
            case 6:
                Object obj = message.obj;
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDescriptorWriteImp------ status = %d", new Object[]{Integer.valueOf(message.arg1)});
                dVar.mHandler.removeCallbacks(dVar.kxl);
                dVar.mHandler.removeCallbacks(dVar.kxm);
                if (3 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Close or disconnect is Called, Just Leave");
                    return;
                } else if (1 == dVar.kxq) {
                    x.w("MicroMsg.exdevice.BluetoothLESession", "Connected is done, Just Leave");
                    return;
                } else if (i2 != 0) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "Write configure descriptor error");
                    dVar.kxq = 2;
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.g(dVar.mSessionId, false);
                        return;
                    }
                    return;
                } else {
                    dVar.kxq = 1;
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.g(dVar.mSessionId, true);
                    }
                    x.i("MicroMsg.exdevice.BluetoothLESession", "------BLE connect successfully------ mConnectState = %d", new Object[]{Integer.valueOf(dVar.kxq)});
                    return;
                }
            case 7:
                i2 = message.arg1;
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataWriteCallbackImp------ status = %d", new Object[]{Integer.valueOf(i2)});
                dVar.mHandler.removeCallbacks(dVar.kxk);
                if (i2 != 0) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "write data error: " + i2);
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.h(dVar.mSessionId, false);
                    }
                    dVar.aro();
                    return;
                }
                ari = dVar.kxj.ari();
                x.d("MicroMsg.exdevice.BluetoothLESession", "Out data dump = %s", new Object[]{b.ap(ari)});
                if (ari == null) {
                    x.i("MicroMsg.exdevice.BluetoothLESession", "write data complete");
                    if (dVar.kxg != null) {
                        dVar.kxg.kwK.h(dVar.mSessionId, true);
                    }
                    dVar.aro();
                    return;
                }
                x.i("MicroMsg.exdevice.BluetoothLESession", "write next chunk...");
                dVar.kxi.setValue(ari);
                dVar.kxf.writeCharacteristic(dVar.kxi);
                dVar.mHandler.postDelayed(dVar.kxk, 5000);
                return;
            case 8:
                ari = (byte[]) message.obj;
                x.i("MicroMsg.exdevice.BluetoothLESession", "------onDataReceiveImp------");
                if (bh.bw(ari)) {
                    x.e("MicroMsg.exdevice.BluetoothLESession", "Receive data is null or nil");
                    return;
                }
                String K = b.K(ari, ari.length);
                x.i("MicroMsg.exdevice.BluetoothLESession", "data length = %d", new Object[]{Integer.valueOf(ari.length)});
                x.d("MicroMsg.exdevice.BluetoothLESession", "data dump = %s", new Object[]{K});
                if (dVar.kxg != null) {
                    dVar.kxg.kwK.b(dVar.mSessionId, ari);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
