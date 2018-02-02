package com.tencent.mm.plugin.report.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.kernel.k;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.ArrayList;
import java.util.Iterator;

public class KVCommCrossProcessReceiver extends BroadcastReceiver {
    private static String className = "";
    private static Object lock = new Object();
    private static af pQm;
    private static int pQn = 10000;
    private static volatile long pQo = 10000;
    private static volatile int pQp = -1;
    private static BroadCastData pQq = new BroadCastData();

    static /* synthetic */ void a(KVCommCrossProcessReceiver kVCommCrossProcessReceiver, Intent intent) {
        try {
            switch (t.a(intent, DownloadSettingTable$Columns.TYPE, 0)) {
                case 1:
                    Bundle bundleExtra = intent.getBundleExtra("INTENT_IDKEYGROUP");
                    if (bundleExtra != null) {
                        BroadCastData broadCastData = (BroadCastData) bundleExtra.getParcelable("BUNDLE_IDKEYGROUP");
                        ArrayList arrayList = broadCastData.pQf;
                        ArrayList arrayList2 = broadCastData.pQe;
                        x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(broadCastData.pQd.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                            d.b(groupIDKeyDataInfo.pQg, groupIDKeyDataInfo.pQh);
                        }
                        Iterator it2 = arrayList2.iterator();
                        while (it2.hasNext()) {
                            StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it2.next();
                            d.b(stIDKeyDataInfo.pRd, stIDKeyDataInfo.key, stIDKeyDataInfo.value, stIDKeyDataInfo.pQh);
                        }
                        it = r7.iterator();
                        while (it.hasNext()) {
                            KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                            d.a(kVReportDataInfo.pQz, kVReportDataInfo.value, kVReportDataInfo.pQA, kVReportDataInfo.pQh);
                        }
                        break;
                    }
                    break;
                case 2:
                    x.i("MicroMsg.ReportManagerKvCheck", "KVBroadCast onReceive TYPE_ONCRASHOREXCEPTION");
                    BaseEvent.onSingalCrash(0);
                    break;
            }
            if (k.aY(ac.getContext())) {
                new af(Looper.myLooper()).postDelayed(new Runnable(kVCommCrossProcessReceiver) {
                    final /* synthetic */ KVCommCrossProcessReceiver pQr;

                    {
                        this.pQr = r1;
                    }

                    public final void run() {
                        if (k.aY(ac.getContext())) {
                            x.e("MicroMsg.ReportManagerKvCheck", "KVCommCrossProcessReceiver shut_down_weixin need to kill process");
                            x.cfl();
                            BaseEvent.onSingalCrash(0);
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, 5000);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "", new Object[0]);
        }
    }

    static {
        HandlerThread Wf = e.Wf("kv_report");
        Wf.start();
        pQm = new af(Wf.getLooper()) {
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 1) {
                    KVCommCrossProcessReceiver.bof();
                }
            }
        };
    }

    public void onReceive(Context context, final Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.ReportManagerKvCheck", "onReceive intent == null");
        } else {
            pQm.post(new Runnable(this) {
                final /* synthetic */ KVCommCrossProcessReceiver pQr;

                public final void run() {
                    x.i("MicroMsg.ReportManagerKvCheck", "summeranrt true report runnable run tid:%d", Long.valueOf(Thread.currentThread().getId()));
                    KVCommCrossProcessReceiver.a(this.pQr, intent);
                }
            });
        }
    }

    public static void bod() {
        if (100 >= 0) {
            pQo = 100;
        }
    }

    public static void boe() {
        pQp = 1000;
    }

    private static void bof() {
        Parcelable broadCastData;
        synchronized (lock) {
            broadCastData = new BroadCastData(pQq);
            BroadCastData broadCastData2 = pQq;
            broadCastData2.pQd.clear();
            broadCastData2.pQe.clear();
            broadCastData2.pQf.clear();
        }
        ArrayList arrayList = broadCastData.pQf;
        ArrayList arrayList2 = broadCastData.pQe;
        ArrayList arrayList3 = broadCastData.pQd;
        if (k.aY(ac.getContext()) || !ac.cfA()) {
            x.i("MicroMsg.ReportManagerKvCheck", "sendKVBroadcast shut_down_weixin, no need to notify worker");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GroupIDKeyDataInfo groupIDKeyDataInfo = (GroupIDKeyDataInfo) it.next();
                e.c(groupIDKeyDataInfo.pQg, groupIDKeyDataInfo.pQh);
            }
            it = arrayList2.iterator();
            while (it.hasNext()) {
                StIDKeyDataInfo stIDKeyDataInfo = (StIDKeyDataInfo) it.next();
                e.d((int) stIDKeyDataInfo.pRd, (int) stIDKeyDataInfo.key, (int) stIDKeyDataInfo.value, stIDKeyDataInfo.pQh);
            }
            it = arrayList3.iterator();
            while (it.hasNext()) {
                KVReportDataInfo kVReportDataInfo = (KVReportDataInfo) it.next();
                e.b((int) kVReportDataInfo.pQz, kVReportDataInfo.value, kVReportDataInfo.pQA, kVReportDataInfo.pQh);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
        intent.putExtra(DownloadSettingTable$Columns.TYPE, 1);
        Bundle bundle = new Bundle();
        bundle.putParcelable("BUNDLE_IDKEYGROUP", broadCastData);
        intent.putExtra("INTENT_IDKEYGROUP", bundle);
        x.d("MicroMsg.ReportManagerKvCheck", "try sendBroadcast kvdata lenght: %d, idkey data lenght:%d,group lenght:%d", Integer.valueOf(arrayList3.size()), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()));
        try {
            ac.getContext().sendBroadcast(intent);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "sendBroadcastMessageDirectly", new Object[0]);
        }
    }

    private static String getClassName() {
        if (bh.ov(className)) {
            className = ac.getPackageName() + ".plugin.report.service.KVCommCrossProcessReceiver";
        }
        return className;
    }

    public static void a(KVReportDataInfo kVReportDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive kv logid:%d, isImportant: %b,isReportNow: %b", Long.valueOf(kVReportDataInfo.pQz), Boolean.valueOf(kVReportDataInfo.pQh), Boolean.valueOf(kVReportDataInfo.pQA));
        synchronized (lock) {
            pQq.pQd.add(kVReportDataInfo);
        }
        if (pQo == 0) {
            bof();
        } else if (!pQm.hasMessages(1)) {
            pQm.sendEmptyMessageDelayed(1, pQo);
        }
    }

    public static void a(StIDKeyDataInfo stIDKeyDataInfo) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive id ID:%d, key:%d,value:%d, isImportant:%b", Long.valueOf(stIDKeyDataInfo.pRd), Long.valueOf(stIDKeyDataInfo.key), Long.valueOf(stIDKeyDataInfo.value), Boolean.valueOf(stIDKeyDataInfo.pQh));
        synchronized (lock) {
            pQq.pQe.add(stIDKeyDataInfo);
        }
        if (pQo == 0 || bog()) {
            bof();
        } else if (!pQm.hasMessages(1)) {
            pQm.sendEmptyMessageDelayed(1, pQo);
        }
    }

    public static void M(ArrayList<IDKey> arrayList) {
        x.d("MicroMsg.ReportManagerKvCheck", "receive group id size:%d, isImportant:%b", Integer.valueOf(arrayList.size()), Boolean.valueOf(false));
        synchronized (lock) {
            BroadCastData broadCastData = pQq;
            broadCastData.pQf.add(new GroupIDKeyDataInfo(arrayList, false));
        }
        if (pQo == 0 || bog()) {
            bof();
        } else if (!pQm.hasMessages(1)) {
            pQm.sendEmptyMessageDelayed(1, pQo);
        }
    }

    private static boolean bog() {
        if (pQp <= 0 || pQq == null) {
            return false;
        }
        try {
            if ((pQq.pQe.size() + pQq.pQf.size()) + pQq.pQd.size() >= pQp) {
                return true;
            }
            return false;
        } catch (Exception e) {
            x.e("MicroMsg.ReportManagerKvCheck", "checkExceedCacheItemCountLimit e = %s", e);
            return false;
        }
    }

    public static void boh() {
        if (k.aY(ac.getContext()) || !ac.cfA()) {
            x.w("MicroMsg.ReportManagerKvCheck", "sendOnCrashOrExceptionBroadCast shut_down_weixin, NO MM Process , return.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver");
        intent.setComponent(new ComponentName(ac.getPackageName(), getClassName()));
        intent.putExtra(DownloadSettingTable$Columns.TYPE, 2);
        ac.getContext().sendBroadcast(intent);
    }

    public static void boi() {
        if (pQm != null) {
            pQm.removeMessages(1);
            pQm.handleMessage(pQm.obtainMessage(1));
        }
    }
}
