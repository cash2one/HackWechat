package com.tencent.mm.plugin.g.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.plugin.g.a.b.a.g.a;
import com.tencent.mm.plugin.g.a.b.h;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> kxI = new HashMap();
    private static HashMap<String, Long> kyT;

    static {
        HashMap hashMap = new HashMap();
        kyT = hashMap;
        hashMap.put(h.kxY, Long.valueOf(1));
        kyT.put(h.kxZ, Long.valueOf(1));
        kyT.put(h.kya, Long.valueOf(16));
        kyT.put(h.kyb, Long.valueOf(16));
        kyT.put(h.kyc, Long.valueOf(16));
        kyT.put(h.kyd, Long.valueOf(16));
        kxI.put(h.kxV, Long.valueOf(0));
        kxI.put(h.kye, Long.valueOf(2));
        kxI.put(h.kyh, Long.valueOf(4));
        kxI.put(h.kyl, Long.valueOf(8));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean ae(byte[] bArr) {
        if (bh.bw(bArr)) {
            x.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
            return false;
        }
        int i = 0;
        while (i >= 0 && i < bArr.length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (i2 + b > bArr.length) {
                x.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(b), Integer.valueOf(bArr.length)});
                return false;
            } else if (b <= (byte) 0) {
                x.w(TAG, "current part of data's len = %d.", new Object[]{Integer.valueOf(b)});
                return false;
            } else {
                int i3 = i2 + 1;
                i = b - 1;
                switch (bArr[i2]) {
                    case (byte) -1:
                        x.i(TAG, "Manufacturer Specific Data size = %s", new Object[]{Integer.valueOf(i)});
                        x.i(TAG, "Manufacturer Specific Data = %s", new Object[]{b.ap(Arrays.copyOfRange(bArr, i3, i3 + i))});
                        break;
                    case (byte) 2:
                    case (byte) 3:
                        while (2 <= i) {
                            i2 = i3 + 1;
                            int i4 = bArr[i3] & 255;
                            i3 = i2 + 1;
                            i2 = ((bArr[i2] & 255) << 8) | i4;
                            i -= 2;
                            x.d(TAG, "find 16-bit broacast service = %s", new Object[]{String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)})});
                            if (kxI.containsKey(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)}))) {
                                return true;
                            }
                        }
                        break;
                    case (byte) 6:
                    case (byte) 7:
                        i2 = i3;
                        i3 = i;
                        while (16 <= i3) {
                            try {
                                ByteBuffer order = ByteBuffer.wrap(bArr, i2, 16).order(ByteOrder.LITTLE_ENDIAN);
                                x.d(TAG, "find 128-bit broacast service = %s", new Object[]{new UUID(order.getLong(), order.getLong()).toString()});
                                if (kxI.containsKey(new UUID(order.getLong(), order.getLong()).toString())) {
                                    return true;
                                }
                                i2 += 16;
                                i3 -= 16;
                            } catch (IndexOutOfBoundsException e) {
                                x.e("BlueToothDeviceFilter.parseUUID", e.toString());
                                i2 += 16;
                                i3 -= 16;
                            }
                        }
                        i = i2 + i3;
                        continue;
                }
                i += i3;
            }
        }
        return false;
    }

    public static String bK(long j) {
        for (String str : kxI.keySet()) {
            if (((Long) kxI.get(str)).longValue() == j) {
                return str;
            }
        }
        if (kyT.containsValue(Long.valueOf(j))) {
            return h.kxV;
        }
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.kxV) || bluetoothGattService.getCharacteristic(UUID.fromString(h.kxY)) == null) {
            l = (Long) kxI.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            x.d(TAG, "service uuid = %s, profileType = %d", new Object[]{uuid, Long.valueOf(j)});
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            l = (Long) kyT.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            i++;
            j2 = (l == null ? 0 : l.longValue()) | j2;
        }
        x.d(TAG, "wechat service, profileType = %d", new Object[]{Long.valueOf(j2)});
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        if (bluetoothGattService == null) {
            x.e(TAG, "service is null");
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kxY));
            if (characteristic == null) {
                x.e(TAG, "no step measurement characteristic found");
                return false;
            }
            properties = characteristic.getProperties();
            x.d(TAG, "step measurement characteristic properties = %d", new Object[]{Integer.valueOf(properties)});
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                x.e(TAG, "step measurement characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kxZ));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    x.e(TAG, "step target characteristic has incorrect proterties(%d)", new Object[]{Integer.valueOf(properties)});
                    return false;
                }
            }
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyf));
            if (characteristic == null) {
                x.e(TAG, "weight scale feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyg));
            if (characteristic == null) {
                x.e(TAG, "weight measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) != 0) {
                return true;
            }
            x.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
            return false;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyi));
            if (characteristic == null) {
                x.e(TAG, "heart rate measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                x.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyj));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    x.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyk));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    x.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8)});
                    return false;
                }
            }
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kym));
            if (characteristic == null) {
                x.e(TAG, "blood pressure measurement characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyo));
            if (characteristic == null) {
                x.e(TAG, "blood pressure feature characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                x.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyn));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    x.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16)});
                    return false;
                }
            }
            return true;
        } else if (0 == (a & 16)) {
            return false;
        } else {
            if (bluetoothGattService == null) {
                x.e(TAG, "service is null");
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kya));
            if (characteristic == null) {
                x.e(TAG, "light color characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyb));
            if (characteristic == null) {
                x.e(TAG, "light work state characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                x.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyc));
            if (characteristic == null) {
                x.e(TAG, "light state changed characteristic not found");
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                x.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32)});
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.kyd));
            if (characteristic == null) {
                x.e(TAG, "control point characteristic not found");
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) != 0 && (properties & 8) != 0) {
                return true;
            }
            x.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", new Object[]{Integer.valueOf(properties), Integer.valueOf(32)});
            return false;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        boolean z = false;
        if (bluetoothGattCharacteristic == null || bArr == null) {
            x.e(TAG, "characteristic or recvData is null");
            return null;
        }
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            x.e(TAG, "the characteristic has no parent service");
        }
        x.d(TAG, "recv data. uuid = %s, data = %s", new Object[]{uuid, b.ap(bArr)});
        boolean z2;
        int i;
        int i2;
        byte[] bp;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.kzv) || uuid.equalsIgnoreCase(f.kzw))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                x.e(f.TAG, "pase step data error");
                z2 = false;
            } else if (uuid == null || !(uuid.equals(f.kzv) || uuid.equals(f.kzw))) {
                x.e(f.TAG, "uuid is not correct");
                z2 = false;
            } else {
                fVar.kyq = uuid;
                i = 4;
                if ((bArr[0] & 2) != 0) {
                    i = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i += 3;
                }
                if (i > bArr.length) {
                    x.e(f.TAG, "data len is not enough");
                    z2 = false;
                } else {
                    fVar.kzx = 0;
                    i2 = 0;
                    i = 1;
                    while (i2 < 3) {
                        fVar.kzx += (bArr[i] & 255) << (i2 * 8);
                        i2++;
                        i++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.kzy = 0;
                        i2 = 0;
                        while (i2 < 3) {
                            fVar.kzy += (bArr[i] & 255) << (i2 * 8);
                            i2++;
                            i++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.kzz = 0;
                        i2 = i;
                        for (i = 0; i < 3; i++) {
                            fVar.kzz += (bArr[i2] & 255) << (i * 8);
                            i2++;
                        }
                    }
                    z2 = true;
                }
            }
            if (z2) {
                bp = b.bp(fVar);
                x.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", new Object[]{Integer.valueOf(fVar.kzx), Integer.valueOf(fVar.kzy), Integer.valueOf(fVar.kzz)});
                return bp;
            }
            x.e(TAG, "parse step data error");
            return null;
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.kyg) || uuid.equalsIgnoreCase(g.kyf))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                x.e(g.TAG, "characteristicUuid or data is null or nil");
                z2 = false;
            } else {
                gVar.kyq = uuid;
                String str;
                Object[] objArr;
                if (gVar.kyq.equalsIgnoreCase(g.kyf)) {
                    if (4 > bArr.length) {
                        x.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", new Object[]{Integer.valueOf(bArr.length)});
                        z2 = false;
                    } else {
                        gVar.kzC = new com.tencent.mm.plugin.g.a.b.a.g.c();
                        gVar.kzC.kzI = (bArr[0] & 1) != 0;
                        gVar.kzC.kzJ = (bArr[0] & 2) != 0;
                        gVar.kzC.kzK = (bArr[0] & 4) != 0;
                        gVar.kzC.kzL = (byte) ((bArr[0] & 120) >> 3);
                        gVar.kzC.kzM = (byte) (((bArr[0] & FileUtils.S_IWUSR) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.kzC.kzI ? "true" : "false";
                        objArr[1] = gVar.kzC.kzJ ? "true" : "false";
                        objArr[2] = gVar.kzC.kzK ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.kzC.kzL);
                        objArr[4] = Byte.valueOf(gVar.kzC.kzM);
                        x.d(uuid, str, objArr);
                    }
                } else if (gVar.kyq.equalsIgnoreCase(g.kyg)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i = 10;
                    } else {
                        i = 3;
                    }
                    if ((b & 4) != 0) {
                        i++;
                    }
                    if ((b & 8) != 0) {
                        i += 4;
                    }
                    if (i > bArr.length) {
                        x.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i)});
                        z2 = false;
                    } else {
                        gVar.kzD = new g.b();
                        gVar.kzD.kzE = (b & 1) != 0;
                        gVar.kzD.kzF = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.kzD.kzG = new a();
                            a aVar = gVar.kzD.kzG;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            x.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                x.e(g.TAG, "data input error");
                            } else {
                                aVar.kyN = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.kyO = bArr[5] & 255;
                                aVar.kyP = bArr[6] & 255;
                                aVar.kyQ = bArr[7] & 255;
                                aVar.kyR = bArr[8] & 255;
                                aVar.kyS = bArr[9] & 255;
                                x.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(aVar.kyN), Integer.valueOf(aVar.kyO), Integer.valueOf(aVar.kyP), Integer.valueOf(aVar.kyQ), Integer.valueOf(aVar.kyR), Integer.valueOf(aVar.kyS)});
                            }
                            i = 10;
                        } else {
                            i = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.kzD.kyG = bArr[i] & 255;
                            i++;
                        }
                        if ((b & 8) != 0) {
                            gVar.kzD.kzH = (bArr[i] & 255) + ((bArr[i + 1] & 255) << 8);
                            i += 2;
                            gVar.kzD.mHeight = ((bArr[i + 1] & 255) << 8) + (bArr[i] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.kzD.kzE ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.kzD.kzF);
                        objArr[2] = gVar.kzD.kzG == null ? "null" : "object";
                        objArr[3] = Integer.valueOf(gVar.kzD.kyG);
                        objArr[4] = Integer.valueOf(gVar.kzD.kzH);
                        objArr[5] = Integer.valueOf(gVar.kzD.mHeight);
                        x.d(uuid, str, objArr);
                    }
                }
                z2 = true;
            }
            if (z2) {
                bp = b.bp(gVar);
                x.d(TAG, "weight info. weight = %d", new Object[]{Integer.valueOf(gVar.kzD.kzF)});
                return bp;
            }
            x.e(TAG, "parse weight scale data error");
            return null;
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.kys) || uuid.equalsIgnoreCase(d.kyU) || uuid.equalsIgnoreCase(d.kyV))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.kyq = uuid;
                int length = bArr.length;
                if (dVar.kyq.equalsIgnoreCase(d.kys)) {
                    if (bArr.length < 2) {
                        x.e(d.TAG, "Received data length is not right:" + length);
                    } else {
                        int i3;
                        dVar.kzc = new d.a(dVar);
                        byte b2 = bArr[0];
                        x.d(d.TAG, "flag=" + b2);
                        if ((b2 & 1) == 1 && length >= 3) {
                            x.d(d.TAG, "Value Format = uint16");
                            dVar.kzc.kzd = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i = 3;
                        } else if (length >= 2) {
                            x.d(d.TAG, "Value Format = uint8");
                            dVar.kzc.kzd = bArr[1] & 255;
                            i = 2;
                        } else {
                            x.d(d.TAG, "receive data error");
                        }
                        x.v(d.TAG, "Data received from HR " + dVar.kzc.kzd);
                        if ((b2 & 6) == 4) {
                            x.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.kzc.kze = 1;
                        } else if ((b2 & 6) == 6) {
                            x.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.kzc.kze = 2;
                        } else {
                            x.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.kzc.kze = 0;
                        }
                        if ((b2 & 8) == 8 && length >= i + 2) {
                            x.d(d.TAG, "Energy Expend Present");
                            i3 = (bArr[i + 1] << 8) & 65280;
                            dVar.kzc.kzf = (bArr[i] & 255) + (i3 & 65280);
                            x.v("H7ConnectThread", "energyExp from HR energyExph " + i3 + " " + dVar.kzc.kzf);
                            i += 2;
                        }
                        if ((b2 & 16) == 16 && length >= i + 2) {
                            x.d(d.TAG, "RR Interval Present");
                            i3 = (bArr[i + 1] & 255) << 8;
                            dVar.kzc.kzg = (bArr[i] & 255) + (i3 & 65280);
                            x.v(d.TAG, "rrInterval from HR rrIntervalh" + i3 + " " + dVar.kzc.kzg);
                        }
                    }
                } else if (dVar.kyq.equalsIgnoreCase(d.kyU)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.kzb = "Other";
                            break;
                        case (byte) 1:
                            dVar.kzb = "Chest";
                            break;
                        case (byte) 2:
                            dVar.kzb = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.kzb = "Finger";
                            break;
                        case (byte) 4:
                            dVar.kzb = "Hand";
                            break;
                        case (byte) 5:
                            dVar.kzb = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.kzb = "Foot";
                            break;
                        default:
                            dVar.kzb = "Unknown";
                            break;
                    }
                    x.d(d.TAG, "position=" + dVar.kzb);
                }
                z = true;
            }
            if (z) {
                return b.bp(dVar);
            }
            x.e(TAG, "parse heart rate data error");
            return null;
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.kys) || uuid.equalsIgnoreCase(b.kyt) || uuid.equalsIgnoreCase(b.kyu))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.kyq = uuid;
                i = bArr.length;
                byte b3;
                if (bVar.kyq.equalsIgnoreCase(b.kys)) {
                    if (i < 7) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kyA = new b(bVar);
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.kyA.kyD = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.kyA.kyD = false;
                        }
                        bVar.kyA.kyK = b.G(bArr, 1);
                        bVar.kyA.kyL = b.G(bArr, 3);
                        bVar.kyA.kyM = b.G(bArr, 5);
                        i2 = 7;
                        if ((b3 & 2) == 0 || i < 14) {
                            x.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.kyA.kyI.H(bArr, 7);
                            i2 = 14;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.kyA.kyF = (int) b.G(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.kyA.kyF);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.kyA.kyG = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.kyA.kyG);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.kyA.kyH = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.kyA.kyH);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.kyq.equalsIgnoreCase(b.kyt)) {
                    if (i < 3) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kyB = new b.a(bVar);
                        b3 = bArr[0];
                        x.d(b.TAG, "flag=" + b3);
                        if ((b3 & 1) != 0) {
                            x.d(b.TAG, "the value unit is kPa.");
                            bVar.kyB.kyD = true;
                        } else {
                            x.d(b.TAG, "the value unit is mmHg.");
                            bVar.kyB.kyD = false;
                        }
                        bVar.kyB.kyE = b.G(bArr, 1);
                        if ((b3 & 2) == 0 || i < 10) {
                            x.d(b.TAG, "TimeStamp not Present.");
                            i2 = 3;
                        } else {
                            x.d(b.TAG, "TimeStamp Present.");
                            bVar.kyB.kyI.H(bArr, 3);
                            i2 = 10;
                        }
                        if ((b3 & 4) == 0 || i < i2 + 2) {
                            x.d(b.TAG, "PulseRate not Present.");
                        } else {
                            x.d(b.TAG, "PulseRate Present.");
                            bVar.kyB.kyF = (int) b.G(bArr, i2);
                            i2 += 2;
                            x.d(b.TAG, "PulseRate =" + bVar.kyB.kyF);
                        }
                        if ((b3 & 8) != 0) {
                            x.d(b.TAG, "UserId Present.");
                            i = i2 + 1;
                            bVar.kyB.kyG = bArr[i2];
                            x.d(b.TAG, "UserId = " + bVar.kyB.kyG);
                        } else {
                            x.d(b.TAG, "UserId not Present.");
                            i = i2;
                        }
                        if ((b3 & 16) != 0) {
                            x.d(b.TAG, "MeasurementStatus Present.");
                            bVar.kyB.kyH = (bArr[i] & 255) + (((bArr[i + 1] << 8) & 65280) & 65280);
                            x.d(b.TAG, "MeasurementStatus = " + bVar.kyB.kyH);
                        } else {
                            x.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.kyq.equalsIgnoreCase(b.kyu)) {
                    x.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i < 2) {
                        x.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.kyC = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        x.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.kyC);
                    }
                }
                z = true;
            }
            if (z) {
                return b.bp(bVar);
            }
            x.e(TAG, "parse blood pressure data error");
            return null;
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.kzi) || uuid.equalsIgnoreCase(e.kzj) || uuid.equalsIgnoreCase(e.kzk) || uuid.equalsIgnoreCase(e.kzl))) {
            x.e(TAG, "unknown characteristic uuid = %s", new Object[]{uuid});
            return null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                x.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.kyq = uuid;
                if (eVar.kyq.equalsIgnoreCase(e.kzi)) {
                    if (bArr.length != 3) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kzm = bArr[0];
                        eVar.kzn = bArr[1];
                        eVar.kzo = bArr[2];
                    }
                } else if (eVar.kyq.equalsIgnoreCase(e.kzj)) {
                    if (bArr.length != 1) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kzp = bArr[0];
                    }
                } else if (eVar.kyq.equalsIgnoreCase(e.kzk)) {
                    if (bArr.length < 2) {
                        x.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.kzq[0] = bArr[0];
                        eVar.kzq[1] = bArr[1];
                    }
                } else if (!eVar.kyq.equalsIgnoreCase(e.kzl)) {
                    x.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    x.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.kzr = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    eVar.kzt = bArr[2];
                    eVar.kzs = bArr[3];
                    if (bArr.length > 4) {
                        eVar.kzu = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.kzu, 0, bArr.length - 4);
                    } else {
                        eVar.kzu = null;
                    }
                }
                z = true;
            }
            if (z) {
                return b.bp(eVar);
            }
            x.e(TAG, "parse light data error");
            return null;
        }
    }
}
