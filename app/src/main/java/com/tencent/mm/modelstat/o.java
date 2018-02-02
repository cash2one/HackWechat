package com.tencent.mm.modelstat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mm.ae.u;
import com.tencent.mm.compatible.d.w;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bbh;
import com.tencent.mm.protocal.c.bbi;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class o {
    private static ak fhK = new ak(g.Dm().oAt.getLooper(), new 4(), false);
    private static final byte[] gSF = new byte[0];
    private static float hSA = 0.0f;
    private static float hSB = 0.0f;
    private static int hSC = 0;
    private static int hSD = 0;
    private static long hSE = 0;
    private static String hSF = "";
    private static long hSt = 86400000;
    private static HashMap<String, Long> hSu = new HashMap();
    private static String hSv = null;
    private static long hSw = Long.MAX_VALUE;
    private static int hSx = 0;
    private static long hSy = 0;
    private static long hSz = 0;

    static /* synthetic */ void iD(int i) {
        long Wp = bh.Wp();
        if (hSy <= 0 || Wp - hSy <= 5000) {
            String[] iB = iB(i);
            if (iB == null || iB.length != 4 || bh.ov(iB[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bz(Wp)), Float.valueOf(0.0f), Float.valueOf(0.0f), Integer.valueOf(0), Long.valueOf(0), iB[0]});
            Wp = bh.bz(hSy);
            if (Wp > 600000 || Wp < 0) {
                Wp = 0;
            }
            com.tencent.mm.plugin.report.service.g.pQN.k(11747, iB[0] + "1,0.0" + ",0.0" + ",0" + ",0" + "," + (b.foreground ? "1" : String.valueOf(Wp)) + "," + iB[1] + "," + iB[2] + "," + iB[3]);
            g.Dj().CU().a(a.xnK, Long.valueOf(bh.Wp()));
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report (reportKV) at  background :%d diff:%d", new Object[]{Long.valueOf(hSy), Long.valueOf(Wp - hSy)});
    }

    public static void bA(Context context) {
        if (context == null) {
            try {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver ctx == null");
                return;
            } catch (Throwable th) {
                x.e("MicroMsg.NetTypeReporter", "registerReceiver : %s", new Object[]{bh.i(th)});
                return;
            }
        }
        BroadcastReceiver aVar = new a((byte) 0);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.supplicant.CONNECTION_CHANGE");
        intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(aVar, intentFilter);
        x.i("MicroMsg.NetTypeReporter", "registerReceiver finish");
    }

    private static boolean h(ArrayList<String> arrayList) {
        FileInputStream fileInputStream;
        Throwable e;
        Iterator it;
        boolean z;
        long bz;
        boolean z2;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        FileOutputStream fileOutputStream2;
        ObjectOutputStream objectOutputStream2 = null;
        if (arrayList.size() == 0) {
            x.w("MicroMsg.NetTypeReporter", "checkBssidShouldReport no value in list.");
            return false;
        }
        String str;
        if (bh.ov(hSv)) {
            hSv = g.Dj().cachePath + "bssidcache.bin";
        }
        if (hSu.size() == 0) {
            ObjectInputStream objectInputStream;
            try {
                fileInputStream = new FileInputStream(hSv);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        hSu = (HashMap) objectInputStream.readObject();
                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport read file size:%d", new Object[]{Integer.valueOf(hSu.size())});
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e2)});
                            hSu = new HashMap();
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e2)});
                            hSu = new HashMap();
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e22)});
                                    hSu = new HashMap();
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(hSu.size()), hSv});
                            com.tencent.mm.loader.stub.b.deleteFile(hSv);
                            it = arrayList.iterator();
                            z = false;
                            while (it.hasNext()) {
                                str = (String) it.next();
                                bz = bh.bz(bh.bZ(hSu.get(str)));
                                x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str, Long.valueOf(bz)});
                                if (bz > 0) {
                                }
                                hSu.put(str, Long.valueOf(bh.Wp()));
                                z2 = true;
                                z = z2;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(hSv);
                                try {
                                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                                    try {
                                        objectOutputStream.writeObject(hSu);
                                        fileOutputStream.flush();
                                        x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(hSu.size())});
                                        try {
                                            objectOutputStream.close();
                                            fileOutputStream.close();
                                        } catch (Throwable e222) {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e222)});
                                        }
                                    } catch (Exception e4) {
                                        e222 = e4;
                                        objectOutputStream2 = objectOutputStream;
                                        fileOutputStream2 = fileOutputStream;
                                        try {
                                            x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e222)});
                                            if (objectOutputStream2 != null) {
                                                try {
                                                    objectOutputStream2.close();
                                                } catch (Throwable e2222) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e2222)});
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                fileOutputStream2.close();
                                            }
                                            return z;
                                        } catch (Throwable th) {
                                            e2222 = th;
                                            fileOutputStream = fileOutputStream2;
                                            objectOutputStream = objectOutputStream2;
                                            if (objectOutputStream != null) {
                                                try {
                                                    objectOutputStream.close();
                                                } catch (Throwable e5) {
                                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e5)});
                                                    throw e2222;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw e2222;
                                        }
                                    } catch (Throwable th2) {
                                        e2222 = th2;
                                        if (objectOutputStream != null) {
                                            objectOutputStream.close();
                                        }
                                        if (fileOutputStream != null) {
                                            fileOutputStream.close();
                                        }
                                        throw e2222;
                                    }
                                } catch (Exception e6) {
                                    e2222 = e6;
                                    fileOutputStream2 = fileOutputStream;
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e2222)});
                                    if (objectOutputStream2 != null) {
                                        objectOutputStream2.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    return z;
                                } catch (Throwable th3) {
                                    e2222 = th3;
                                    objectOutputStream = null;
                                    if (objectOutputStream != null) {
                                        objectOutputStream.close();
                                    }
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    throw e2222;
                                }
                            } catch (Exception e7) {
                                e2222 = e7;
                                fileOutputStream2 = null;
                                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport write err:%s", new Object[]{bh.i(e2222)});
                                if (objectOutputStream2 != null) {
                                    objectOutputStream2.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                }
                                return z;
                            } catch (Throwable th4) {
                                e2222 = th4;
                                objectOutputStream = null;
                                fileOutputStream = null;
                                if (objectOutputStream != null) {
                                    objectOutputStream.close();
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                throw e2222;
                            }
                            return z;
                        } catch (Throwable th5) {
                            e2222 = th5;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e52) {
                                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e52)});
                                    hSu = new HashMap();
                                    throw e2222;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e8) {
                    e2222 = e8;
                    objectInputStream = null;
                    x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e2222)});
                    hSu = new HashMap();
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(hSu.size()), hSv});
                    com.tencent.mm.loader.stub.b.deleteFile(hSv);
                    it = arrayList.iterator();
                    z = false;
                    while (it.hasNext()) {
                        str = (String) it.next();
                        bz = bh.bz(bh.bZ(hSu.get(str)));
                        x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str, Long.valueOf(bz)});
                        if (bz > 0) {
                        }
                        hSu.put(str, Long.valueOf(bh.Wp()));
                        z2 = true;
                        z = z2;
                    }
                    fileOutputStream = new FileOutputStream(hSv);
                    objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(hSu);
                    fileOutputStream.flush();
                    x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(hSu.size())});
                    objectOutputStream.close();
                    fileOutputStream.close();
                    return z;
                } catch (Throwable th6) {
                    e2222 = th6;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e9) {
                e2222 = e9;
                objectInputStream = null;
                fileInputStream = null;
                x.e("MicroMsg.NetTypeReporter", "checkBssidShouldReport read err:%s", new Object[]{bh.i(e2222)});
                hSu = new HashMap();
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(hSu.size()), hSv});
                com.tencent.mm.loader.stub.b.deleteFile(hSv);
                it = arrayList.iterator();
                z = false;
                while (it.hasNext()) {
                    str = (String) it.next();
                    bz = bh.bz(bh.bZ(hSu.get(str)));
                    x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str, Long.valueOf(bz)});
                    if (bz > 0) {
                    }
                    hSu.put(str, Long.valueOf(bh.Wp()));
                    z2 = true;
                    z = z2;
                }
                fileOutputStream = new FileOutputStream(hSv);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(hSu);
                fileOutputStream.flush();
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(hSu.size())});
                objectOutputStream.close();
                fileOutputStream.close();
                return z;
            } catch (Throwable th7) {
                e2222 = th7;
                objectInputStream = null;
                fileInputStream = null;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e2222;
            }
            if (hSu.size() <= 0 || hSu.size() > 1000) {
                x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport remove size:%d  file:%s", new Object[]{Integer.valueOf(hSu.size()), hSv});
                com.tencent.mm.loader.stub.b.deleteFile(hSv);
            }
        }
        it = arrayList.iterator();
        z = false;
        while (it.hasNext()) {
            str = (String) it.next();
            bz = bh.bz(bh.bZ(hSu.get(str)));
            x.d("MicroMsg.NetTypeReporter", "checkBssidShouldReport report bssid:%s diff:%d", new Object[]{str, Long.valueOf(bz)});
            if (bz > 0 || bz > hSt) {
                hSu.put(str, Long.valueOf(bh.Wp()));
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        if (z && hSu.size() > 0) {
            fileOutputStream = new FileOutputStream(hSv);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hSu);
            fileOutputStream.flush();
            x.i("MicroMsg.NetTypeReporter", "checkBssidShouldReport write file size:%d", new Object[]{Integer.valueOf(hSu.size())});
            objectOutputStream.close();
            fileOutputStream.close();
        }
        return z;
    }

    private static String[] iB(int i) {
        Throwable th;
        x.i("MicroMsg.NetTypeReporter", "dkNetTypeRead scene:%d fg:%b time:%d diff:%d", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hSy), Long.valueOf(bh.bz(hSy))});
        if (i <= 0) {
            x.e("MicroMsg.NetTypeReporter", "ERROR PARAM: scene:%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        Context context = ac.getContext();
        if (context == null) {
            x.e("MicroMsg.NetTypeReporter", "ERROR Context is null scene:%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int yV;
        x.i("MicroMsg.NetTypeReporter", "read scene:%d foreground:%b", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground)});
        int i2 = 0;
        try {
            yV = w.yV();
        } catch (Throwable e) {
            x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bh.i(e)});
            yV = i2;
        }
        x.i("MicroMsg.NetTypeReporter", "get netType :%d", new Object[]{Integer.valueOf(yV)});
        String str = "";
        String str2 = "";
        String str3 = "";
        String networkOperatorName;
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            int i3 = 0;
            ArrayList arrayList = new ArrayList();
            stringBuffer.append(connectionInfo.getSSID());
            stringBuffer2.append(connectionInfo.getBSSID());
            String bssid = connectionInfo.getBSSID();
            arrayList.add(bssid);
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null) {
                Collections.sort(scanResults, new 1());
                int i4 = 20;
                for (ScanResult scanResult : scanResults) {
                    if (!(scanResult == null || bh.ov(scanResult.BSSID))) {
                        if (!scanResult.BSSID.equals(bssid)) {
                            int i5 = i4 - 1;
                            if (i4 <= 0) {
                                break;
                            }
                            stringBuffer.append("|");
                            stringBuffer.append(bh.ou(scanResult.SSID).replace("|", "").replace(" ", ""));
                            stringBuffer2.append("|");
                            stringBuffer2.append(bh.ou(scanResult.BSSID).replace("|", "").replace(" ", ""));
                            arrayList.add(scanResult.BSSID);
                            stringBuffer3.append("|");
                            stringBuffer3.append(scanResult.level);
                            i4 = i5;
                        } else {
                            i3 = scanResult.level;
                        }
                    }
                }
            }
            i2 = i3;
            if (i >= 2000 || h(arrayList)) {
                str = stringBuffer.toString();
                str2 = stringBuffer2.toString();
                str3 = i2 + stringBuffer3.toString();
                x.d("MicroMsg.NetTypeReporter", "get wifi :[%s] [%s]", new Object[]{str2, str});
                String str4 = "";
                try {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        networkOperatorName = telephonyManager.getNetworkOperatorName();
                    } else {
                        networkOperatorName = str4;
                    }
                    str4 = networkOperatorName;
                } catch (Throwable e2) {
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bh.i(e2)});
                }
                x.i("MicroMsg.NetTypeReporter", "get ispName: %s", new Object[]{str4});
                String str5 = "";
                String str6 = "";
                String str7 = "";
                String str8 = "";
                String str9 = "";
                try {
                    List eU = an.eU(context);
                    for (int i6 = 0; i6 < eU.size(); i6++) {
                        an.a aVar = (an.a) eU.get(i6);
                        str5 = bh.az(aVar.xgP, "");
                        str6 = bh.az(aVar.xgQ, "");
                        if (str7.length() > 0 && !bh.ov(aVar.xgS)) {
                            str7 = str7 + "|";
                        }
                        if (!bh.ov(aVar.xgS)) {
                            str7 = str7 + aVar.xgS;
                        }
                        if (str8.length() > 0 && !bh.ov(aVar.xgR)) {
                            str8 = str8 + "|";
                        }
                        if (!bh.ov(aVar.xgR)) {
                            str8 = str8 + aVar.xgR;
                        }
                        if (str9.length() > 0) {
                            str9 = str9 + "|";
                        }
                        StringBuilder append = new StringBuilder().append(str9);
                        if (bh.ov(aVar.xgV)) {
                            networkOperatorName = "0";
                        } else {
                            networkOperatorName = aVar.xgV;
                        }
                        str9 = append.append(networkOperatorName).toString();
                    }
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                } catch (Throwable e22) {
                    th = e22;
                    networkOperatorName = str9;
                    str9 = str8;
                    str8 = str7;
                    str7 = str6;
                    str6 = str5;
                    x.e("MicroMsg.NetTypeReporter", "getNetType : %s", new Object[]{bh.i(th)});
                }
                x.d("MicroMsg.NetTypeReporter", "mcc:%s mnc:%s cell:%s", new Object[]{str6, str7, str8});
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(bh.Wo()).append(",");
                stringBuilder.append(i).append(",");
                stringBuilder.append(yV).append(",");
                stringBuilder.append(str.replace(",", " ")).append(",");
                stringBuilder.append(mM(str2.replace(",", " "))).append(",");
                stringBuilder.append(str4.replace(",", " ")).append(",");
                stringBuilder.append(mM(str6.replace(",", " "))).append(",");
                stringBuilder.append(mM(str7.replace(",", " "))).append(",");
                stringBuilder.append(mM(str8.replace(",", " "))).append(",");
                if (Ta() < 0) {
                    return null;
                }
                return new String[]{Ta() + "," + stringBuilder.toString(), mM(str3), mM(str9), mM(networkOperatorName)};
            }
            x.w("MicroMsg.NetTypeReporter", "checkBssid: find all report already  , give up. scene:%d ", new Object[]{Integer.valueOf(i)});
            return null;
        } catch (Throwable e222) {
            th = e222;
            networkOperatorName = str2;
            str2 = str;
            x.e("MicroMsg.NetTypeReporter", "getWifiInfo : %s", new Object[]{bh.i(th)});
            str = str2;
            str2 = networkOperatorName;
        }
    }

    private static String mM(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && ((c < 'A' || c > 'Z') && ((c < '0' || c > '9') && c != '|' && c != '-' && c != ' ' && c != ':'))) {
                return "";
            }
        }
        return str;
    }

    private static long Ta() {
        long a;
        synchronized (gSF) {
            try {
                a = bh.a((Long) g.Dj().CU().get(a.xnJ, null), 1);
                g.Dj().CU().a(a.xnJ, Long.valueOf(1 + a));
                g.Dj().CU().lH(true);
                long a2 = bh.a((Long) g.Dj().CU().get(a.xnJ, null), 1);
                x.i("MicroMsg.NetTypeReporter", "incSeq after write  old:%d new:%d", new Object[]{Long.valueOf(a), Long.valueOf(a2)});
            } catch (Throwable e) {
                x.e("MicroMsg.NetTypeReporter", "incSeq :%s", new Object[]{bh.i(e)});
                return -1;
            }
        }
        return a;
    }

    private static void a(int i, float f, float f2, int i2, long j) {
        long Wp = bh.Wp();
        if (hSy <= 0 || Wp - hSy <= 5000) {
            String[] iB = iB(i);
            if (iB == null || iB.length != 4 || bh.ov(iB[0])) {
                x.e("MicroMsg.NetTypeReporter", "report get failed val");
                return;
            }
            x.d("MicroMsg.NetTypeReporter", "report scene:%d time:%d lon:%f lat:%f pre:%d scanuse:%d [%s]", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bz(Wp)), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(j), iB[0]});
            com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
            aVar.hmj = new bbh();
            aVar.hmk = new bbi();
            aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
            aVar.hmi = 716;
            com.tencent.mm.ae.b JZ = aVar.JZ();
            bbh com_tencent_mm_protocal_c_bbh = (bbh) JZ.hmg.hmo;
            com_tencent_mm_protocal_c_bbh.vOf = d.vAt;
            com_tencent_mm_protocal_c_bbh.vOg = d.vAs;
            com_tencent_mm_protocal_c_bbh.vOh = d.vAv;
            com_tencent_mm_protocal_c_bbh.vOi = d.vAw;
            com_tencent_mm_protocal_c_bbh.vOj = com.tencent.mm.sdk.platformtools.w.cfi();
            com_tencent_mm_protocal_c_bbh.wuu = 11747;
            Wp = bh.bz(hSy);
            if (Wp > 600000 || Wp < 0) {
                Wp = 0;
            }
            com_tencent_mm_protocal_c_bbh.pQt = iB[0] + "0," + f + "," + f2 + "," + i2 + "," + j + "," + (b.foreground ? "1" : String.valueOf(Wp)) + "," + iB[1] + "," + iB[2] + "," + iB[3];
            u.a(JZ, new 2(bh.Wp(), com_tencent_mm_protocal_c_bbh, iB, f, f2, i2, j), true);
            return;
        }
        x.e("MicroMsg.NetTypeReporter", "never  report  at  background :%d diff:%d", new Object[]{Long.valueOf(hSy), Long.valueOf(Wp - hSy)});
    }

    public static void w(int i, String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new bbh();
        aVar.hmk = new bbi();
        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
        aVar.hmi = 716;
        com.tencent.mm.ae.b JZ = aVar.JZ();
        bbh com_tencent_mm_protocal_c_bbh = (bbh) JZ.hmg.hmo;
        com_tencent_mm_protocal_c_bbh.vOf = d.vAt;
        com_tencent_mm_protocal_c_bbh.vOg = d.vAs;
        com_tencent_mm_protocal_c_bbh.vOh = d.vAv;
        com_tencent_mm_protocal_c_bbh.vOi = d.vAw;
        com_tencent_mm_protocal_c_bbh.vOj = com.tencent.mm.sdk.platformtools.w.cfi();
        com_tencent_mm_protocal_c_bbh.wuu = i;
        com_tencent_mm_protocal_c_bbh.pQt = str;
        x.i("MicroMsg.NetTypeReporter", "reportCgi logId:%d, value:%s", new Object[]{Integer.valueOf(i), str});
        u.a(JZ, new 3(bh.Wp(), com_tencent_mm_protocal_c_bbh));
    }

    private static void b(int i, float f, float f2, int i2, long j) {
        try {
            x.i("MicroMsg.NetTypeReporter", "checkTimeReport scene:%d diff:%d  time:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bz(hSw)), Long.valueOf(hSw)});
            if (i > MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || bh.bz(hSw) > 300000) {
                x.i("MicroMsg.NetTypeReporter", "force Run, scene:%d diff:%d time:%d ", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bz(hSw)), Long.valueOf(hSw)});
                hSx = i;
                hSw = Long.MAX_VALUE;
                a(i, f, f2, i2, j);
                return;
            }
            if (hSw == Long.MAX_VALUE) {
                hSw = bh.Wp() + 60000;
            }
            hSx = i;
            fhK.J(60000, 60000);
        } catch (Throwable th) {
            x.e("MicroMsg.NetTypeReporter", "checkTimeReport error: %s", new Object[]{bh.i(th)});
        }
    }

    public static void bV(boolean z) {
        if (z) {
            hSy = 0;
        } else if (!fhK.cfK()) {
            x.i("MicroMsg.NetTypeReporter", "setToForeground user turn to background run report now");
            hSy = bh.Wp();
            fhK.J(0, 0);
        }
    }

    public static synchronized void a(int i, float f, float f2, int i2) {
        synchronized (o.class) {
            if (i < MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN || f == 0.0f || f2 == 0.0f) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, invalid args, scene = %d, lon = %f, lat = %f, pre = %d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
            } else if (bh.bz(hSE) < 60000) {
                x.e("MicroMsg.NetTypeReporter", "reportGps, hit lastReportGpsLimit, request dropped, scene = %d, lon = %f, lat = %f, pre = %d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2)});
            } else {
                x.i("MicroMsg.NetTypeReporter", "reportGps scene:%d lon:%f lat:%f pre:%d last:%d", new Object[]{Integer.valueOf(i), Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Long.valueOf(bh.bz(hSE))});
                hSE = bh.Wp();
                hSD = i;
                hSz = bh.Wp();
                hSC = i2;
                hSA = f2;
                hSB = f;
                try {
                    ((WifiManager) ac.getContext().getSystemService("wifi")).startScan();
                    g.Dm().g(new 5(), 5000);
                } catch (Throwable e) {
                    x.e("MicroMsg.NetTypeReporter", "reportGps :%s", new Object[]{bh.i(e)});
                }
            }
        }
    }

    public static synchronized void iC(int i) {
        synchronized (o.class) {
            x.i("MicroMsg.NetTypeReporter", "run scene:%d foreground:%b lastGpsTime:%d lastbssid:%s", new Object[]{Integer.valueOf(i), Boolean.valueOf(b.foreground), Long.valueOf(hSz), hSF});
            if (i == 1005) {
                try {
                    if (hSz > 0) {
                        x.d("MicroMsg.NetTypeReporter", "report gps scene:%d lastscene:%d [%f,%f,%d] lastGpsTime", new Object[]{Integer.valueOf(i), Integer.valueOf(hSD), Float.valueOf(hSB), Float.valueOf(hSA), Integer.valueOf(hSC), Long.valueOf(hSz)});
                        long bz = bh.bz(hSz);
                        int i2 = hSD;
                        float f = hSA;
                        float f2 = hSB;
                        int i3 = hSC;
                        hSz = 0;
                        hSA = 0.0f;
                        hSB = 0.0f;
                        hSC = 0;
                        hSD = 0;
                        b(i2, f2, f, i3, bz);
                    }
                } catch (Throwable th) {
                    x.e("MicroMsg.NetTypeReporter", "run :%s", new Object[]{bh.i(th)});
                }
            }
            if (!b.foreground) {
                x.w("MicroMsg.NetTypeReporter", "run is not foreground give up %d ", new Object[]{Integer.valueOf(i)});
            } else if (i == 3) {
                String bssid = ((WifiManager) ac.getContext().getSystemService("wifi")).getConnectionInfo().getBSSID();
                x.d("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_BSSID_CHANGE %s %s ", new Object[]{Integer.valueOf(i), bssid, hSF});
                if (!(bh.ov(bssid) || bssid.equals(hSF))) {
                    hSF = bssid;
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else if (i == 4) {
                x.i("MicroMsg.NetTypeReporter", "run scene:%d SCENE_TO_FOREGROUND_TIMEOUT  diff:%d", new Object[]{Integer.valueOf(i), Long.valueOf(bh.bz(bh.a((Long) g.Dj().CU().get(a.xnK, null), 0)))});
                if (bh.bz(bh.a((Long) g.Dj().CU().get(a.xnK, null), 0)) >= 21600000) {
                    b(i, 0.0f, 0.0f, 0, 0);
                }
            } else {
                b(i, 0.0f, 0.0f, 0, 0);
            }
        }
    }
}
