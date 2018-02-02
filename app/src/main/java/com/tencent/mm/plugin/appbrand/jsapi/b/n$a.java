package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.b.n.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class n$a implements LeScanCallback {
    private Map<String, JSONObject> jhE;
    private j jhR;
    private ak jhS = null;
    public final ParcelUuid jhT = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
    final /* synthetic */ n jhU;

    public n$a(n nVar, j jVar) {
        this.jhU = nVar;
        this.jhR = jVar;
        this.jhE = b.afS();
        this.jhS = new ak(new 1(this), false);
    }

    public final void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        b(bluetoothDevice, i, bArr);
    }

    private synchronized void b(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
        if (bluetoothDevice == null) {
            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "scan device null,return..");
        } else {
            String ou = bh.ou(bluetoothDevice.getName());
            String address = bluetoothDevice.getAddress();
            x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "onLeScan for deviceId : " + address + ",name : " + ou);
            if (!bh.ov(address)) {
                Object str;
                this.jhU.jhP = this.jhU.jhQ.optBoolean("allowDuplicatesKey");
                List<ParcelUuid> arrayList = new ArrayList();
                String T = T(bArr);
                JSONObject S = S(bArr);
                byte[] a = a(bArr, arrayList);
                if (a != null) {
                    str = new String(Base64.encode(a, 2));
                } else {
                    str = null;
                }
                JSONArray jSONArray = new JSONArray();
                for (ParcelUuid uuid : arrayList) {
                    jSONArray.put(uuid.getUuid().toString().toUpperCase());
                }
                c cVar = new c((byte) 0);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceId", address);
                    jSONObject.put("name", ou);
                    jSONObject.put("RSSI", i);
                    jSONObject.put("advertisData", str);
                    jSONObject.put("advertisServiceUUIDs", jSONArray);
                    jSONObject.put("localName", T);
                    if (S.length() != 0) {
                        jSONObject.put("serviceData", S);
                    }
                } catch (JSONException e) {
                    x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "put JSON data error : %s", new Object[]{e});
                }
                synchronized (this) {
                    if (this.jhU.jhP || !this.jhE.containsKey(address)) {
                        this.jhE.put(address, jSONObject);
                        int optInt = this.jhU.jhQ.optInt("interval");
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(jSONObject);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("devices", jSONArray2);
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e2, "", new Object[0]);
                        }
                        if (optInt > 0) {
                            if (this.jhS.cfK()) {
                                long j = (long) optInt;
                                this.jhS.J(j, j);
                                x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "start timer interval %s", new Object[]{Integer.valueOf(optInt)});
                            }
                        } else if (b.jhB) {
                            f az = cVar.az(this.jhR.mAppId, this.jhR.hashCode());
                            az.mData = jSONObject2.toString();
                            az.afs();
                        } else {
                            x.e("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "bluetooth is not init,return...");
                        }
                    } else {
                        this.jhE.put(address, jSONObject);
                        x.i("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "DuplicatesKey,deviceId : " + address);
                    }
                }
            }
        }
    }

    private JSONObject S(byte[] bArr) {
        JSONObject jSONObject = new JSONObject();
        if (bArr == null) {
            return jSONObject;
        }
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i == 0) {
                return jSONObject;
            }
            int i3 = i - 1;
            int i4 = i2 + 1;
            switch (bArr[i2] & 255) {
                case 22:
                    try {
                        x.d("MicroMsg.JsApiStartBluetoothDevicesDiscovery", "[parseServiceDataFromBytes]uuid:%s, data:%s", new Object[]{U(n(bArr, i4, 2)).getUuid().toString().toUpperCase(), new String(Base64.encode(n(bArr, i4 + 2, i3 - 2), 2))});
                        jSONObject.put(r0, r3);
                        break;
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e, "", new Object[0]);
                        break;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.JsApiStartBluetoothDevicesDiscovery", e2, "", new Object[0]);
                        break;
                    }
                default:
                    break;
            }
            i = i4 + i3;
        }
        return jSONObject;
    }

    private static String T(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        String str = "";
        int i = 0;
        while (i < bArr.length) {
            int i2 = i + 1;
            i = bArr[i] & 255;
            if (i == 0) {
                return str;
            }
            i--;
            int i3 = i2 + 1;
            switch (bArr[i2] & 255) {
                case 8:
                case 9:
                    str = new String(n(bArr, i3, i));
                    break;
                default:
                    break;
            }
            i += i3;
        }
        return str;
    }

    private byte[] a(byte[] bArr, List<ParcelUuid> list) {
        byte[] bArr2 = null;
        if (bArr != null) {
            int i = 0;
            while (i < bArr.length) {
                int i2 = i + 1;
                i = bArr[i] & 255;
                if (i != 0) {
                    byte[] bArr3;
                    int i3 = i - 1;
                    int i4 = i2 + 1;
                    switch (bArr[i2] & 255) {
                        case 2:
                        case 3:
                            a(bArr, i4, i3, 2, list);
                            bArr3 = bArr2;
                            break;
                        case 4:
                        case 5:
                            a(bArr, i4, i3, 4, list);
                            bArr3 = bArr2;
                            break;
                        case 6:
                        case 7:
                            a(bArr, i4, i3, 16, list);
                            bArr3 = bArr2;
                            break;
                        case 8:
                        case 9:
                            bArr3 = bArr2;
                            break;
                        case 255:
                            bArr3 = n(bArr, i4, i3);
                            break;
                        default:
                            bArr3 = bArr2;
                            break;
                    }
                    bArr2 = bArr3;
                    i = i4 + i3;
                }
            }
        }
        return bArr2;
    }

    private static byte[] n(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return obj;
    }

    private int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        while (i2 > 0) {
            list.add(U(n(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    private ParcelUuid U(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("uuidBytes cannot be null");
        }
        int length = bArr.length;
        if (length != 2 && length != 4 && length != 16) {
            throw new IllegalArgumentException("uuidBytes length invalid - " + length);
        } else if (length == 16) {
            ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            return new ParcelUuid(new UUID(order.getLong(8), order.getLong(0)));
        } else {
            long j;
            if (length == 2) {
                j = ((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8));
            } else {
                j = ((((long) (bArr[0] & 255)) + ((long) ((bArr[1] & 255) << 8))) + ((long) ((bArr[2] & 255) << 16))) + ((long) ((bArr[3] & 255) << 24));
            }
            return new ParcelUuid(new UUID(this.jhT.getUuid().getMostSignificantBits() + (j << 32), this.jhT.getUuid().getLeastSignificantBits()));
        }
    }
}
