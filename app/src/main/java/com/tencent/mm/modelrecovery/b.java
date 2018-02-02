package com.tencent.mm.modelrecovery;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.recovery.model.RecoveryStatusItem;
import com.tencent.recovery.report.RecoveryReporter;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class b {
    public static HashMap<String, Integer> hKa;

    public static void QK() {
        List<RecoveryStatusItem> a = RecoveryReporter.a(ac.getContext(), "ProcessStatus", RecoveryStatusItem.class);
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "reportStatus " + a.size());
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (RecoveryStatusItem recoveryStatusItem : a) {
            a aVar = hashMap.containsKey(recoveryStatusItem.processName) ? (a) hashMap.get(recoveryStatusItem.processName) : new a();
            b bVar = hashMap2.containsKey(recoveryStatusItem.processName) ? (b) hashMap2.get(recoveryStatusItem.processName) : new b();
            aVar.hKb++;
            if (recoveryStatusItem.zRm == 1) {
                aVar.hKe++;
            } else {
                aVar.hKf++;
            }
            Object obj = null;
            int i;
            switch (recoveryStatusItem.zRo) {
                case 1:
                    if (recoveryStatusItem.zRm != 1) {
                        bVar.hKi++;
                        switch (recoveryStatusItem.zRp) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hKq++;
                                i = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hKm++;
                                i = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    bVar.hKh++;
                    switch (recoveryStatusItem.zRp) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hKp++;
                            i = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hKl++;
                            i = 1;
                            break;
                        default:
                            break;
                    }
                case 16:
                    if (recoveryStatusItem.zRm != 1) {
                        bVar.hKk++;
                        switch (recoveryStatusItem.zRp) {
                            case Downloads.RECV_BUFFER_SIZE /*4096*/:
                                bVar.hKs++;
                                i = 1;
                                break;
                            case 65536:
                            case 1048576:
                                bVar.hKo++;
                                i = 1;
                                break;
                            default:
                                break;
                        }
                    }
                    bVar.hKj++;
                    switch (recoveryStatusItem.zRp) {
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            bVar.hKr++;
                            i = 1;
                            break;
                        case 65536:
                        case 1048576:
                            bVar.hKn++;
                            i = 1;
                            break;
                        default:
                            break;
                    }
            }
            if (obj == null) {
                x.i("MicroMsg.Recovery.WXRecoveryReporter", "recovery statics not set exception");
            }
            hashMap.put(recoveryStatusItem.processName, aVar);
            hashMap2.put(recoveryStatusItem.processName, bVar);
        }
        i(hashMap);
        j(hashMap2);
        RecoveryReporter.bB(ac.getContext(), "ProcessStatus");
    }

    private static void i(HashMap<String, a> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hKa.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hKa.get(entry.getKey())).intValue();
                a aVar = (a) entry.getValue();
                if (aVar.hKb > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) aVar.hKb);
                    arrayList.add(iDKey);
                }
                if (aVar.hKc > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) aVar.hKc);
                    arrayList.add(iDKey);
                }
                if (aVar.hKd > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) aVar.hKd);
                    arrayList.add(iDKey);
                }
                if (aVar.hKe > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) aVar.hKe);
                    arrayList.add(iDKey);
                }
                if (aVar.hKf > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) aVar.hKf);
                    arrayList.add(iDKey);
                }
                if (aVar.hKg > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(424);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) aVar.hKg);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.pQN.a(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery generalObj %s %s", ac.Br(), hashMap.toString());
    }

    private static void j(HashMap<String, b> hashMap) {
        ArrayList arrayList = new ArrayList();
        for (Entry entry : hashMap.entrySet()) {
            if (hKa.containsKey(entry.getKey())) {
                IDKey iDKey;
                int intValue = ((Integer) hKa.get(entry.getKey())).intValue();
                b bVar = (b) entry.getValue();
                if (bVar.hKh > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 0);
                    iDKey.SetValue((long) bVar.hKh);
                    arrayList.add(iDKey);
                }
                if (bVar.hKi > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 1);
                    iDKey.SetValue((long) bVar.hKi);
                    arrayList.add(iDKey);
                }
                if (bVar.hKj > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 2);
                    iDKey.SetValue((long) bVar.hKj);
                    arrayList.add(iDKey);
                }
                if (bVar.hKk > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 3);
                    iDKey.SetValue((long) bVar.hKk);
                    arrayList.add(iDKey);
                }
                if (bVar.hKl > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 4);
                    iDKey.SetValue((long) bVar.hKl);
                    arrayList.add(iDKey);
                }
                if (bVar.hKm > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 5);
                    iDKey.SetValue((long) bVar.hKm);
                    arrayList.add(iDKey);
                }
                if (bVar.hKn > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 6);
                    iDKey.SetValue((long) bVar.hKn);
                    arrayList.add(iDKey);
                }
                if (bVar.hKo > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 7);
                    iDKey.SetValue((long) bVar.hKo);
                    arrayList.add(iDKey);
                }
                if (bVar.hKp > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 8);
                    iDKey.SetValue((long) bVar.hKp);
                    arrayList.add(iDKey);
                }
                if (bVar.hKq > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 9);
                    iDKey.SetValue((long) bVar.hKq);
                    arrayList.add(iDKey);
                }
                if (bVar.hKr > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 10);
                    iDKey.SetValue((long) bVar.hKr);
                    arrayList.add(iDKey);
                }
                if (bVar.hKs > 0) {
                    iDKey = new IDKey();
                    iDKey.SetID(JsApiInstallDownloadTask.CTRL_INDEX);
                    iDKey.SetKey(intValue + 11);
                    iDKey.SetValue((long) bVar.hKs);
                    arrayList.add(iDKey);
                }
            }
        }
        if (arrayList.size() > 0) {
            g.pQN.a(arrayList, true);
        }
        x.i("MicroMsg.Recovery.WXRecoveryReporter", "report recovery statusObj %s %s", ac.Br(), hashMap.toString());
    }

    static {
        HashMap hashMap = new HashMap();
        hKa = hashMap;
        hashMap.put(ac.getPackageName(), Integer.valueOf(0));
        hKa.put(ac.getPackageName() + ":push", Integer.valueOf(20));
        hKa.put(ac.getPackageName() + ":tools", Integer.valueOf(40));
        hKa.put(ac.getPackageName() + ":exdevice", Integer.valueOf(60));
        hKa.put(ac.getPackageName() + ":sandbox", Integer.valueOf(80));
    }
}
