package com.tencent.mm.modelstat;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.accessibility.AccessibilityCapture;
import com.tencent.mm.accessibility.AccessibilityCapture.APIProvider;
import com.tencent.mm.accessibility.AccessibilityCapture.Event;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;
import org.json.JSONArray;
import org.json.JSONObject;

public class c implements APIProvider {
    private static c hPX;
    private ak hPY = null;
    private final int hPZ = 20971520;
    private ArrayList<b> hQa = new ArrayList();
    private String hQb = null;
    private long hQc = 0;
    private ArrayList<c> hQd = new ArrayList();
    private boolean hQe = false;
    private Map<String, Boolean> hQf = new HashMap();
    private long hQg = 0;
    private long hQh = 0;
    private List<d> hQi = new ArrayList();
    private af handler = null;

    static class b implements Serializable, Comparable<b> {
        long elapsedTime = 0;
        int fut = 0;
        List<d> hQi = null;
        String hQq = null;
        long hQr;
        long time = 0;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (this.time - ((b) obj).time);
        }

        b() {
        }

        public final String toString() {
            return String.format(Locale.getDefault(), "[%s,%d,%s]", new Object[]{this.hQq, Integer.valueOf(this.fut), c.bp(this.time)});
        }
    }

    static /* synthetic */ void a(c cVar) {
        if (AccessibilityCapture.isEnable()) {
            AccessibilityCapture.disableAccessibilityCapture(ac.getContext());
        }
        if (cVar.hQa == null || cVar.hQa.size() == 0) {
            x.e("MicroMsg.ClickFlowStatReceiver", "page info array size is 0");
            return;
        }
        Pair g = cVar.g(cVar.hQa);
        cVar.hQa.clear();
        cVar.hQi.clear();
        if (g == null) {
            x.e("MicroMsg.ClickFlowStatReceiver", "report failed :getResumeList return null ");
            return;
        }
        Object str;
        int intValue = ((Integer) g.first).intValue();
        ArrayList arrayList = (ArrayList) g.second;
        int i = 0;
        if (ac.cfw() && g.Dh().Cy()) {
            g.Dh();
            if (!a.Cs()) {
                g.Dh();
                i = a.Cg();
            }
        }
        if (i == 0) {
            x.e("MicroMsg.ClickFlowStatReceiver", "report get uin failed  , maybe AccNotReady,  but report it");
        }
        long longValue = new o(i).longValue();
        if (cVar.hQb == null) {
            cVar.hQb = com.tencent.mm.loader.stub.a.gZK + "ClickFlow/";
            File file = new File(cVar.hQb);
            if (!file.exists()) {
                file.mkdir();
            }
        }
        com.tencent.mm.sdk.e.a aVar = new com.tencent.mm.sdk.e.a(cVar.hQb + "stg_20971520_" + longValue + ".cfg");
        String str2 = cVar.hQb + "ReportConfig_20971520_" + longValue + ".xml";
        if (cVar.hQd == null || cVar.hQd.size() == 0) {
            byte[] e = e.e(str2, 0, -1);
            str = e != null ? new String(e) : "";
            try {
                if (com.tencent.mm.sdk.a.b.ceK() && e.bO("/sdcard/reportConfig-android.xml")) {
                    e = e.e("/sdcard/reportConfig-android.xml", 0, -1);
                    x.w("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString: use /sdcard/reportConfig-android.xml as config, cgi config is ignored!!!");
                    str = e != null ? new String(e) : "";
                }
                if (TextUtils.isEmpty(str)) {
                    x.i("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString xml is empty and don't use /sdcard/reportConfig-android.xml");
                } else {
                    cVar.a(a.mK(str));
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e2, "", new Object[0]);
                x.e("MicroMsg.ClickFlowStatReceiver", "parseAndApplyString throwable :%s %s", new Object[]{e2.getMessage(), bh.i(e2)});
                v(15013, bh.i(e2));
            }
        }
        if (!bo(longValue)) {
            long Wo = bh.Wo();
            long a = bh.a(aVar.Wa("LAST_UPDATE_CONFIG"), 0);
            long j = a - Wo > 432000 ? 0 : a;
            str = (j <= 0 || cVar.hQg <= 0 || cVar.hQg + j < Wo) ? 1 : null;
            boolean z = str != null && cVar.hQc + 3600 < Wo;
            x.i("MicroMsg.ClickFlowStatReceiver", "readReportConfig shouldUpdate:%b now:%d lastCheckUpdateConfigDiff:%d lastUpdate:%d diff:%d  updateintval:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(Wo), Long.valueOf(Wo - cVar.hQc), Long.valueOf(j), Long.valueOf(Wo - j), Long.valueOf(cVar.hQg)});
            if (z) {
                com.tencent.mm.network.e eVar = g.Di().gPJ.hmV;
                if (eVar == null) {
                    x.d("MicroMsg.ClickFlowStatReceiver", "dispatcher is null");
                } else {
                    if (new j(new com.tencent.mm.bq.b(bh.VD(aVar.getValue("versionBuffer")))).a(eVar, new 4(cVar, aVar, str2)) == 0) {
                        cVar.hQc = Wo;
                    }
                }
            }
        }
        cVar.a(longValue, arrayList, aVar);
        cVar.a(longValue, arrayList, aVar, intValue);
        if (!bo(longValue)) {
            cVar.b(longValue, arrayList, aVar);
        }
    }

    static /* synthetic */ void a(c cVar, int i, String str, int i2, long j, long j2) {
        long Wp = bh.Wp();
        if (TextUtils.isEmpty(str) || j > Wp) {
            x.e("MicroMsg.ClickFlowStatReceiver", "writeToList page:%s  start - time = %d", new Object[]{str, Long.valueOf(Wp - j)});
            return;
        }
        b bVar = new b();
        bVar.fut = i;
        bVar.hQq = str.contains(".") ? str.substring(str.lastIndexOf(".") + 1) : str;
        if (3 == i && ((cVar.hQe || (cVar.hQf.containsKey(bVar.hQq) && ((Boolean) cVar.hQf.get(bVar.hQq)).booleanValue())) && !AccessibilityCapture.isEnable())) {
            Object obj = (d.vAs == null || !d.vAs.toLowerCase().startsWith("samsung")) ? null : 1;
            if (obj == null) {
                obj = 1;
            } else {
                int i3 = 0;
                if (ac.cfw() && g.Dk().gQN && g.Dh().Cy()) {
                    g.Dh();
                    if (!a.Cs()) {
                        g.Dh();
                        i3 = a.Cg();
                    }
                }
                obj = (i3 == 0 || !a((long) i3, 0.01f, cVar.hQh)) ? null : 1;
            }
            if (obj != null) {
                AccessibilityCapture.enableAccessibilityCapture(ac.getContext(), cVar);
            }
        }
        if (5 == i || 6 == i) {
            bVar.fut = 4;
        } else if (!(3 == i || 4 == i)) {
            x.i("MicroMsg.ClickFlowStatReceiver", "writeToList error opCode:%d  (%s)", new Object[]{Integer.valueOf(i), str});
            return;
        }
        bVar.time = j;
        bVar.elapsedTime = j2;
        cVar.hQa.add(bVar);
        x.i("MicroMsg.ClickFlowStatReceiver", "ActivityState op:%d time:%s 0x%x %s useTime:%d", new Object[]{Integer.valueOf(bVar.fut), bp(bVar.time), Integer.valueOf(i2), bVar.hQq, Long.valueOf(bh.bz(Wp))});
        if (bVar.fut == 3) {
            cVar.hPY.TG();
        } else if (bVar.fut == 4) {
            cVar.hPY.TG();
            cVar.hPY.J(5000, 5000);
        }
    }

    public static c SO() {
        if (hPX == null) {
            synchronized (c.class) {
                if (hPX == null) {
                    hPX = new c();
                }
            }
        }
        return hPX;
    }

    public void onEvent(Event event) {
        if (event != null && event.view != null && event.activity != null && event.activity.getComponentName() != null) {
            Object shortClassName = event.activity.getComponentName().getShortClassName();
            if (shortClassName.contains(".")) {
                shortClassName = shortClassName.substring(shortClassName.lastIndexOf(".") + 1);
            }
            if (this.hQe || this.hQf.containsKey(r0)) {
                d dVar = new d();
                long currentTimeMillis = System.currentTimeMillis();
                dVar.hQy = Integer.toHexString(event.view.getId());
                dVar.type = event.event.getEventType();
                dVar.time = event.elapsedTime;
                this.hQi.add(dVar);
                int[] iArr = new int[2];
                event.view.getLocationOnScreen(iArr);
                dVar.left = iArr[0];
                dVar.top = iArr[1];
                x.d("MicroMsg.ClickFlowStatReceiver", "[oneliang]id:" + dVar.hQy + ",ui:" + event.activity.getComponentName().getShortClassName() + ",left:" + dVar.left + ",top:" + dVar.top + ",time:" + dVar.time + ",cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    public void v(String str, String str2, Object... objArr) {
        x.v("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void d(String str, String str2, Object... objArr) {
        x.d("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void i(String str, String str2, Object... objArr) {
        x.i("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void e(String str, String str2, Object... objArr) {
        x.e("MicroMsg.ClickFlowStatReceiver", str2, objArr);
    }

    public void post(Runnable runnable, String str) {
        if (this.handler != null) {
            this.handler.post(runnable);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", th, str2, objArr);
    }

    private c() {
        if (com.tencent.mm.sdk.a.b.ceK()) {
            Assert.assertTrue("Error: ClickFlow internal code can only run in MM process.", ac.cfw());
        }
        HandlerThread Wf = com.tencent.mm.sdk.f.e.Wf("ClickFlow");
        Wf.start();
        this.handler = new af(Wf.getLooper());
        this.hPY = new ak(Wf.getLooper(), new 1(this), true);
    }

    public final void SP() {
        long Wp = bh.Wp();
        x.w("MicroMsg.ClickFlowStatReceiver", "commitNow return:%s time:%d", new Object[]{(Boolean) new 2(this, Boolean.valueOf(false)).b(this.handler), Long.valueOf(bh.bz(Wp))});
    }

    public final void r(Intent intent) {
        if (intent != null && intent.getAction().equals("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT")) {
            this.handler.post(new 3(this, intent));
        }
    }

    private static boolean bo(long j) {
        return j == 0;
    }

    private Pair<Integer, ArrayList<b>> g(ArrayList<b> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        long Wp = bh.Wp();
        try {
            b bVar;
            Object arrayList3 = new ArrayList();
            long j = 0;
            int i = 0;
            while (i < arrayList.size()) {
                bVar = (b) arrayList.get(i);
                if (bVar.time < 0 || bVar.time > Wp || Wp - bVar.time > 50400000) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err timestamp:%d diff:%d opcode:%d page:%s", new Object[]{Long.valueOf(bVar.time), Long.valueOf(Wp - bVar.time), Integer.valueOf(bVar.fut), bVar.hQq});
                    return null;
                }
                long j2;
                if (bVar.fut == 4) {
                    if (j < bVar.time) {
                        j2 = bVar.time;
                    }
                    j2 = j;
                } else if (bVar.fut != 3) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err Opcode:%d %s", new Object[]{Integer.valueOf(bVar.fut), bVar.hQq});
                    return null;
                } else {
                    arrayList3.add(bVar);
                    j2 = j;
                }
                i++;
                j = j2;
            }
            if (arrayList3.size() == 0) {
                return null;
            }
            Collections.sort(arrayList3);
            Collections.sort(this.hQi);
            bVar = new b();
            Iterator it = arrayList3.iterator();
            b bVar2 = bVar;
            while (it.hasNext()) {
                bVar = (b) it.next();
                if (!bVar.hQq.equals(bVar2.hQq)) {
                    a(bVar2, bVar.elapsedTime);
                    arrayList2.add(bVar);
                    bVar2.hQr = bVar.time;
                    bVar2 = bVar;
                } else if (bVar.time - bVar2.time > 10800000) {
                    x.i("MicroMsg.ClickFlowStatReceiver", "[oneliang]Duplicate resume info check,current resume info time:%s,previous resume info time:%s", new Object[]{Long.valueOf(bVar.time), Long.valueOf(bVar2.time)});
                    bVar2.time = bVar.time;
                }
            }
            if (!arrayList2.isEmpty()) {
                a((b) arrayList2.get(arrayList2.size() - 1), j);
            }
            bVar2.hQr = ((b) arrayList.get(arrayList.size() - 1)).time;
            if (((b) arrayList2.get(arrayList2.size() - 1)).time > j) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hQr = Wp;
            } else if (j > Wp) {
                ((b) arrayList2.get(arrayList2.size() - 1)).hQr = Wp;
            }
            if (((b) arrayList2.get(arrayList2.size() - 1)).hQr - ((b) arrayList2.get(0)).time > 50400000) {
                x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed Err list time");
                return null;
            }
            x.i("MicroMsg.ClickFlowStatReceiver", "getResumeList errType:%d list:%d time:%d", new Object[]{Integer.valueOf(0), Integer.valueOf(arrayList2.size()), Long.valueOf(bh.bz(Wp))});
            return Pair.create(Integer.valueOf(0), arrayList2);
        } catch (Throwable e) {
            v(15008, bh.i(e));
            x.e("MicroMsg.ClickFlowStatReceiver", "getResumeList failed %s", new Object[]{bh.i(e)});
            return null;
        }
    }

    private void a(b bVar, long j) {
        if (bVar.elapsedTime > 0) {
            int c = c(bVar.elapsedTime, 0, this.hQi.isEmpty() ? 0 : this.hQi.size() - 1);
            if (c != -1) {
                if (bVar.hQi == null) {
                    bVar.hQi = new ArrayList();
                }
                int size = this.hQi.size();
                int i = c;
                while (i < size) {
                    d dVar = (d) this.hQi.get(i);
                    if (dVar.time > bVar.elapsedTime && dVar.time <= j) {
                        bVar.hQi.add(dVar);
                    }
                    if (dVar.time < j) {
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private int c(long j, int i, int i2) {
        if (this.hQi == null || this.hQi.isEmpty()) {
            return -1;
        }
        int i3 = (i + i2) / 2;
        if (i2 - i == 0 || i2 - i == 1) {
            if (j < ((d) this.hQi.get(i2)).time) {
                return i;
            }
            return i2;
        } else if (j < ((d) this.hQi.get(i3)).time) {
            return c(j, i, i3);
        } else {
            return j > ((d) this.hQi.get(i3)).time ? c(j, i3, i2) : i3;
        }
    }

    private static void v(int i, String str) {
        com.tencent.mm.plugin.report.d.pPH.k(13328, i + ",0,0,0,0,0,0,0,0,0,0,0,0," + str);
    }

    private void a(a aVar) {
        this.hQg = aVar.hQg;
        if (this.hQg <= 0 || this.hQg > 432000) {
            this.hQg = 432000;
        }
        this.hQh = aVar.hQh;
        this.hQd.clear();
        this.hQd.addAll(aVar.hQp);
        this.hQf.clear();
        this.hQf.putAll(aVar.hQf);
        if (this.hQf.containsKey("*") && ((Boolean) this.hQf.get("*")).booleanValue()) {
            this.hQe = true;
        }
        x.i("MicroMsg.ClickFlowStatReceiver", "applyConfig OK evenCount:%d nextUpdateInterval:%d samplePeriod:%d", new Object[]{Integer.valueOf(this.hQd.size()), Long.valueOf(this.hQg), Long.valueOf(this.hQh)});
    }

    private static boolean a(long j, float f, long j2) {
        if (com.tencent.mm.sdk.a.b.ceK()) {
            return true;
        }
        if (f <= 0.0f) {
            return false;
        }
        long j3;
        boolean z;
        int i = 10000 / ((int) (10000.0f * f));
        int i2 = (int) j;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        i2 = (i2 ^ (i2 >> 16)) * 73244475;
        int i3 = ((i2 >> 16) ^ i2) % i;
        long Wo = bh.Wo();
        if (j2 == 0) {
            j3 = 259200;
        } else {
            j3 = j2;
        }
        if (i3 == ((int) ((Wo / j3) % ((long) i)))) {
            z = true;
        } else {
            z = false;
        }
        x.v("MicroMsg.ClickFlowStatReceiver", "checkRate %b uin:%s rate:%s period:%s rec:%s x:%s uinMod:%s timeMod:%s", new Object[]{Boolean.valueOf(z), Long.valueOf(j), Float.valueOf(f), Long.valueOf(j2), Integer.valueOf(i), Integer.valueOf(r5), Integer.valueOf(i3), Integer.valueOf(r1)});
        return z;
    }

    private static void a(List<b> list, c cVar, SparseArray<String> sparseArray) {
        int i = 0;
        String str = cVar.hQv;
        int i2 = -1;
        switch (str.hashCode()) {
            case -929554094:
                if (str.equals("respective")) {
                    i2 = 1;
                    break;
                }
                break;
            case 3117816:
                if (str.equals("ends")) {
                    i2 = 2;
                    break;
                }
                break;
            case 3433103:
                if (str.equals("page")) {
                    i2 = 0;
                    break;
                }
                break;
            case 379114255:
                if (str.equals("continuous")) {
                    i2 = 3;
                    break;
                }
                break;
        }
        int i3;
        int i4;
        switch (i2) {
            case 0:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: page, handle %s", new Object[]{cVar});
                sparseArray.put(cVar.hQu, bh.ou((String) sparseArray.get(cVar.hQu)) + cVar.id + ";");
                return;
            case 1:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: respective, handle %s", new Object[]{cVar});
                for (i2 = 0; i2 < list.size(); i2 = i3 + 1) {
                    i4 = 0;
                    i3 = i2;
                    while (i4 < cVar.hQw.size()) {
                        int size;
                        if (((String) ((Pair) cVar.hQw.get(i4)).first).equals(((b) list.get(i3)).hQq)) {
                            sparseArray.put(cVar.hQu, bh.ou((String) sparseArray.get(cVar.hQu)) + cVar.id + ";");
                            i4 = cVar.hQw.size();
                            size = list.size();
                        } else {
                            size = i3;
                        }
                        i4++;
                        i3 = size;
                    }
                }
                return;
            case 2:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: ends, handle %s", new Object[]{cVar});
                if (list.size() >= 2) {
                    if ((cVar.hQw.size() == 2 ? 1 : 0) == 0) {
                        x.e("MicroMsg.ClickFlowStatReceiver", "ends's pages size is not 2: " + cVar.hQw.toString());
                        return;
                    }
                    String str2 = (String) ((Pair) cVar.hQw.get(1)).first;
                    if (((b) list.get(0)).hQq.equals((String) ((Pair) cVar.hQw.get(0)).first) && ((b) list.get(list.size() - 1)).hQq.equals(str2)) {
                        sparseArray.put(cVar.hQu, bh.ou((String) sparseArray.get(cVar.hQu)) + cVar.id + ";");
                        return;
                    }
                    return;
                }
                return;
            case 3:
                x.i("MicroMsg.ClickFlowStatReceiver", "type: continuous, handle %s", new Object[]{cVar});
                List list2 = cVar.hQw;
                if (list2.size() > 0) {
                    for (i2 = list2.size() - 1; i2 < list.size(); i2 = (list2.size() - i4) + i3) {
                        i4 = list2.size() - 1;
                        i3 = i2;
                        while (((String) ((Pair) list2.get(i4)).first).equals(((b) list.get(i3)).hQq)) {
                            if (i4 == 0) {
                                i = 1;
                            } else {
                                i4--;
                                i3--;
                            }
                        }
                    }
                }
                if (i != 0) {
                    sparseArray.put(cVar.hQu, bh.ou((String) sparseArray.get(cVar.hQu)) + cVar.id + ";");
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        c cVar;
        long j2 = ((b) arrayList.get(0)).time;
        long j3 = ((b) arrayList.get(arrayList.size() - 1)).hQr;
        long Wo = bh.Wo();
        int i = 0;
        while (i < this.hQd.size()) {
            try {
                if ("app".equals(((c) this.hQd.get(i)).hQv)) {
                    cVar = (c) this.hQd.get(i);
                    break;
                }
                i++;
            } catch (Throwable e) {
                v(15004, bh.i(e));
                x.e("MicroMsg.ClickFlowStatReceiver", "report ev:1 exception : %s", new Object[]{bh.i(e)});
                return;
            }
        }
        cVar = null;
        if (cVar == null) {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip null");
            if (bo(j)) {
                a(aVar, 13604, 100001, j2, j3);
            } else {
                x.i("MicroMsg.ClickFlowStatReceiver", "type: app, event null, uin not zero");
            }
        } else if (cVar.hQs <= Wo || !a(j, cVar.hQt, this.hQh)) {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, skip %s, now:%d", new Object[]{cVar, Long.valueOf(Wo)});
        } else {
            x.i("MicroMsg.ClickFlowStatReceiver", "type: app, handle %s, now:%d", new Object[]{cVar, Long.valueOf(Wo)});
            a(aVar, cVar.hQu, cVar.id, j2, j3);
        }
    }

    private static void a(com.tencent.mm.sdk.e.a aVar, int i, int i2, long j, long j2) {
        long Wp = bh.Wp();
        if (j > j2 || j < 0 || j2 < 0 || j > Wp || j2 > Wp) {
            x.e("MicroMsg.ClickFlowStatReceiver", "reportAppInternal ErrorParam begin:%d end:%d now:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2), Long.valueOf(Wp)});
            return;
        }
        int e = bh.e(aVar.Wb("SEQ_" + i));
        aVar.cX("SEQ_" + i, e + 1);
        Wp = bh.c(aVar.Wa("LastQuit_" + i2));
        aVar.ai("LastQuit_" + i2, j2);
        if (Wp <= 0 || Wp > j) {
            Wp = j;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("t", 1).put("tbe", j / 1000).put("ten", j2 / 1000).put("in", (j2 - j) / 1000).put("lten", Wp / 1000).put("inbg", (j - Wp) / 1000);
        a(i, String.valueOf(i2), e, jSONObject.toString());
    }

    private void a(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar, int i) {
        try {
            int i2;
            long Wp = bh.Wp();
            JSONArray jSONArray = new JSONArray();
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                JSONObject jSONObject = new JSONObject();
                b bVar = (b) arrayList.get(i3);
                if (bVar.hQr < bVar.time || bVar.time < 0 || bVar.hQr < 0 || bVar.hQr > Wp || bVar.time > Wp) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "reportPage ErrorTime: [%d, %d]  now:%d ", new Object[]{Long.valueOf(bVar.time), Long.valueOf(bVar.hQr), Long.valueOf(Wp)});
                    return;
                }
                jSONObject.put("p", bVar.hQq).put("tbe", bVar.time / 1000).put("in", (bVar.hQr - bVar.time) / 1000);
                if (!(bVar.hQi == null || bVar.hQi.isEmpty())) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i4 = 0; i4 < bVar.hQi.size(); i4++) {
                        d dVar = (d) bVar.hQi.get(i4);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("w", dVar.hQy).put("t", dVar.type).put("tbp", "{" + dVar.left + ";" + dVar.top + "}");
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("wf", jSONArray2);
                }
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("t", 2).put("errt", i).put("pf", jSONArray);
            if (bo(j)) {
                int e = bh.e(aVar.Wb("SEQ_13604"));
                aVar.cX("SEQ_13604", e + 1);
                a(13604, "100002", e, jSONObject3.toString());
            }
            SparseArray sparseArray = new SparseArray();
            if (this.hQd.size() == 0) {
                x.i("MicroMsg.ClickFlowStatReceiver", "type: page, no event");
            }
            for (i2 = 0; i2 < this.hQd.size(); i2++) {
                c cVar = (c) this.hQd.get(i2);
                if (cVar.hQs > bh.Wo()) {
                    if (a(j, cVar.hQt, this.hQh)) {
                        a((List) arrayList, cVar, sparseArray);
                    }
                }
                x.i("MicroMsg.ClickFlowStatReceiver", "type: page, skip %s, now: %d", new Object[]{cVar, Long.valueOf(bh.Wo())});
            }
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                int keyAt = sparseArray.keyAt(i2);
                String str = (String) sparseArray.get(keyAt);
                int e2 = bh.e(aVar.Wb("SEQ_" + keyAt));
                aVar.cX("SEQ_" + keyAt, e2 + 1);
                a(keyAt, str, e2, jSONObject3.toString());
            }
        } catch (Throwable e3) {
            v(15005, bh.i(e3));
            x.e("MicroMsg.ClickFlowStatReceiver", "report ev:2 exception : %s", new Object[]{bh.i(e3)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(long j, ArrayList<b> arrayList, com.tencent.mm.sdk.e.a aVar) {
        long Wp = bh.Wp();
        long j2 = ((b) arrayList.get(arrayList.size() - 1)).hQr;
        if (j2 <= 0 || j2 > Wp) {
            x.e("MicroMsg.ClickFlowStatReceiver", "reportStat  ErrorTime end:%d now:%d", new Object[]{Long.valueOf(j2), Long.valueOf(Wp)});
            return;
        }
        long Wo = bh.Wo();
        String str = this.hQb + "stg_20971520_" + j + ".HashMap";
        try {
            HashMap mJ = mJ(str);
            mJ.put(Long.valueOf(j2), arrayList);
            Iterator it = mJ.entrySet().iterator();
            while (it.hasNext()) {
                if (((Long) ((Entry) it.next()).getKey()).longValue() + 259200000 < j2) {
                    it.remove();
                }
            }
            a(str, mJ);
            long j3 = com.tencent.mm.sdk.a.b.ceK() ? 180000 : 3600000;
            long a = bh.a(aVar.Wa("LAST_REPORT_STATISITIC_TIME"), 0);
            if (a + j3 > j2) {
                x.i("MicroMsg.ClickFlowStatReceiver", "type: stat, skip all, lastStatisticTime: %d, end: %d, FREQ: %d", new Object[]{Long.valueOf(a), Long.valueOf(j2), Long.valueOf(j3)});
                return;
            }
            int i;
            c cVar;
            aVar.ai("LAST_REPORT_STATISITIC_TIME", j2);
            HashMap hashMap = new HashMap();
            for (Long l : mJ.keySet()) {
                if (l.longValue() > a) {
                    hashMap.put(l, mJ.get(l));
                }
            }
            a = 0;
            long j4 = Long.MAX_VALUE;
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            HashMap hashMap4 = new HashMap();
            HashMap hashMap5 = new HashMap();
            HashMap hashMap6 = new HashMap();
            for (i = 0; i < this.hQd.size(); i++) {
                if ("pagestat".equals(((c) this.hQd.get(i)).hQv)) {
                    cVar = (c) this.hQd.get(i);
                    break;
                }
            }
            cVar = null;
            x.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] click flow session count:%s", new Object[]{Integer.valueOf(hashMap.size())});
            for (Long l2 : hashMap.keySet()) {
                long longValue;
                if (j4 > l2.longValue()) {
                    longValue = l2.longValue();
                } else {
                    longValue = j4;
                }
                x.i("MicroMsg.ClickFlowStatReceiver", "find min key,min key:%s,cur key:%s", new Object[]{Long.valueOf(longValue), l2});
                ArrayList arrayList2 = (ArrayList) hashMap.get(l2);
                long j5 = a + (((b) arrayList2.get(arrayList2.size() - 1)).hQr - ((b) arrayList2.get(0)).time);
                if (j5 < 0 || j5 > 172800000) {
                    x.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErrorTime sumInFg:%d", new Object[]{Long.valueOf(j5)});
                    return;
                }
                i = 0;
                b bVar = null;
                while (i < arrayList2.size()) {
                    b bVar2 = (b) arrayList2.get(i);
                    r9 = new Object[5];
                    r9[1] = Long.valueOf(bh.c((Long) hashMap2.get(bVar2.hQq)));
                    r9[2] = Long.valueOf(bVar2.hQr);
                    r9[3] = Long.valueOf(bVar2.time);
                    r9[4] = Long.valueOf(bVar2.hQr - bVar2.time);
                    x.v("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap page:%s old:%d  new[%d,%d,%d]", r9);
                    j4 = bVar2.hQr - bVar2.time;
                    if (j4 < 0 || j4 > 86400000) {
                        x.e("MicroMsg.ClickFlowStatReceiver", "pageIntervalMap ErrorTime [%d,%d] now:%d diff:%d", new Object[]{Long.valueOf(bVar2.time), Long.valueOf(bVar2.hQr), Long.valueOf(Wp), Long.valueOf(j4)});
                        a = 0;
                    } else {
                        a = j4;
                    }
                    hashMap2.put(bVar2.hQq, Long.valueOf(a + bh.c((Long) hashMap2.get(bVar2.hQq))));
                    hashMap3.put(bVar2.hQq, Long.valueOf(bh.c((Long) hashMap3.get(bVar2.hQq)) + 1));
                    if (bVar != null) {
                        String str2 = bVar.hQq + "," + bVar2.hQq;
                        hashMap5.put(str2, Long.valueOf(bh.c((Long) hashMap5.get(str2)) + 1));
                    }
                    if (bVar2.hQi != null) {
                        Map map;
                        if (hashMap6.containsKey(bVar2.hQq)) {
                            map = (Map) hashMap6.get(bVar2.hQq);
                        } else {
                            mJ = new HashMap();
                            hashMap6.put(bVar2.hQq, mJ);
                            Object obj = mJ;
                        }
                        for (int i2 = 0; i2 < bVar2.hQi.size(); i2++) {
                            d dVar = (d) bVar2.hQi.get(i2);
                            map.put(dVar.hQy, Long.valueOf(bh.c((Long) map.get(dVar.hQy)) + 1));
                        }
                    }
                    i++;
                    bVar = bVar2;
                }
                if (cVar != null) {
                    Iterator it2 = cVar.hQx.iterator();
                    while (it2.hasNext()) {
                        Pair pair = (Pair) it2.next();
                        String str3 = ((String) pair.first) + "," + ((String) pair.second);
                        if (hashMap5.containsKey(str3)) {
                            hashMap4.put(pair.second, hashMap5.get(str3));
                        }
                    }
                }
                j4 = longValue;
                a = j5;
            }
            long j6 = ((b) ((ArrayList) hashMap.get(Long.valueOf(j4))).get(0)).time;
            x.i("MicroMsg.ClickFlowStatReceiver", "min key:%s,tbe:%s", new Object[]{Long.valueOf(j4), Long.valueOf(j6)});
            if (j6 > Wp || j6 < 0) {
                x.e("MicroMsg.ClickFlowStatReceiver", "reportStat ErroTime tbe:%d now:%d", new Object[]{Long.valueOf(j6), Long.valueOf(Wp)});
                return;
            }
            c cVar2;
            int i3 = 0;
            while (i3 < this.hQd.size()) {
                try {
                    if ("appstat".equals(((c) this.hQd.get(i3)).hQv)) {
                        cVar2 = (c) this.hQd.get(i3);
                        break;
                    }
                    i3++;
                } catch (Throwable e) {
                    v(15006, bh.i(e));
                    x.e("MicroMsg.ClickFlowStatReceiver", "report ev:3 exception : %s", new Object[]{bh.i(e)});
                } catch (Throwable e2) {
                    com.tencent.mm.loader.stub.b.deleteFile(str);
                    System.gc();
                    x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e2, "OutOfMemoryError", new Object[0]);
                    v(15010, bh.i(e2));
                }
            }
            cVar2 = null;
            x.i("MicroMsg.ClickFlowStatReceiver", "[oneliang] end:%s,tbe:%s,sumInFg:%s", new Object[]{Long.valueOf(j2), Long.valueOf(j6), Long.valueOf(a)});
            c cVar3;
            int e3;
            JSONArray jSONArray;
            JSONObject jSONObject;
            JSONArray jSONArray2;
            Map map2;
            JSONObject jSONObject2;
            JSONObject jSONObject3;
            if (cVar2 == null || (j2 - j6) - a < 0) {
                x.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip null, event:%s, (end - tbe - sumInFg):%s", new Object[]{cVar2, Long.valueOf((j2 - j6) - a)});
                for (i3 = 0; i3 < this.hQd.size(); i3++) {
                    if (!"pagestat".equals(((c) this.hQd.get(i3)).hQv)) {
                        cVar3 = (c) this.hQd.get(i3);
                        break;
                    }
                }
                cVar3 = null;
                if (cVar3 != null) {
                    if (cVar3.hQs > Wo) {
                        if (a(j, cVar3.hQt, this.hQh)) {
                            x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                            e3 = bh.e(aVar.Wb("SEQ_" + cVar3.hQu));
                            aVar.cX("SEQ_" + cVar3.hQu, e3 + 1);
                            jSONArray = new JSONArray();
                            for (String str4 : hashMap2.keySet()) {
                                jSONObject = new JSONObject();
                                jSONObject.put("p", str4).put("in", ((Long) hashMap2.get(str4)).longValue() / 1000).put("c", hashMap3.get(str4)).put("c2", hashMap4.get(str4));
                                if (!hashMap6.containsKey(str4)) {
                                    jSONArray2 = new JSONArray();
                                    map2 = (Map) hashMap6.get(str4);
                                    for (String str42 : map2.keySet()) {
                                        jSONObject2 = new JSONObject();
                                        jSONObject2.put("w", str42).put("c", map2.get(str42));
                                        jSONArray2.put(jSONObject2);
                                    }
                                    jSONObject.put("wa", jSONArray2);
                                }
                                jSONArray.put(jSONObject);
                            }
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("t", 6).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                            a(cVar3.hQu, cVar3.id, e3, jSONObject3.toString());
                            return;
                        }
                    }
                    x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                    return;
                }
                x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
            }
            if (cVar2.hQs > Wo) {
                if (a(j, cVar2.hQt, this.hQh)) {
                    x.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, handle %s, now:%d", new Object[]{cVar2, Long.valueOf(Wo)});
                    int e4 = bh.e(aVar.Wb("SEQ_" + cVar2.hQu));
                    aVar.cX("SEQ_" + cVar2.hQu, e4 + 1);
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put("t", 5).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("in", a / 1000).put("inbg", ((j2 - j6) - a) / 1000).put("swc", hashMap.size());
                    a(cVar2.hQu, cVar2.id, e4, jSONObject4.toString());
                    for (i3 = 0; i3 < this.hQd.size(); i3++) {
                        if (!"pagestat".equals(((c) this.hQd.get(i3)).hQv)) {
                            cVar3 = (c) this.hQd.get(i3);
                            break;
                        }
                    }
                    cVar3 = null;
                    if (cVar3 != null) {
                        x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
                    }
                    if (cVar3.hQs > Wo) {
                        if (a(j, cVar3.hQt, this.hQh)) {
                            x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                            e3 = bh.e(aVar.Wb("SEQ_" + cVar3.hQu));
                            aVar.cX("SEQ_" + cVar3.hQu, e3 + 1);
                            jSONArray = new JSONArray();
                            for (String str422 : hashMap2.keySet()) {
                                jSONObject = new JSONObject();
                                jSONObject.put("p", str422).put("in", ((Long) hashMap2.get(str422)).longValue() / 1000).put("c", hashMap3.get(str422)).put("c2", hashMap4.get(str422));
                                if (!hashMap6.containsKey(str422)) {
                                    jSONArray2 = new JSONArray();
                                    map2 = (Map) hashMap6.get(str422);
                                    for (String str4222 : map2.keySet()) {
                                        jSONObject2 = new JSONObject();
                                        jSONObject2.put("w", str4222).put("c", map2.get(str4222));
                                        jSONArray2.put(jSONObject2);
                                    }
                                    jSONObject.put("wa", jSONArray2);
                                }
                                jSONArray.put(jSONObject);
                            }
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("t", 6).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                            a(cVar3.hQu, cVar3.id, e3, jSONObject3.toString());
                            return;
                        }
                    }
                    x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                    return;
                }
            }
            x.i("MicroMsg.ClickFlowStatReceiver", "type: appstat, skip %s, now:%d", new Object[]{cVar2, Long.valueOf(Wo)});
            for (i3 = 0; i3 < this.hQd.size(); i3++) {
                if (!"pagestat".equals(((c) this.hQd.get(i3)).hQv)) {
                    cVar3 = (c) this.hQd.get(i3);
                    break;
                }
            }
            cVar3 = null;
            if (cVar3 != null) {
                if (cVar3.hQs > Wo) {
                    if (a(j, cVar3.hQt, this.hQh)) {
                        x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, handle %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                        e3 = bh.e(aVar.Wb("SEQ_" + cVar3.hQu));
                        aVar.cX("SEQ_" + cVar3.hQu, e3 + 1);
                        jSONArray = new JSONArray();
                        for (String str42222 : hashMap2.keySet()) {
                            jSONObject = new JSONObject();
                            jSONObject.put("p", str42222).put("in", ((Long) hashMap2.get(str42222)).longValue() / 1000).put("c", hashMap3.get(str42222)).put("c2", hashMap4.get(str42222));
                            if (!hashMap6.containsKey(str42222)) {
                                jSONArray2 = new JSONArray();
                                map2 = (Map) hashMap6.get(str42222);
                                for (String str422222 : map2.keySet()) {
                                    jSONObject2 = new JSONObject();
                                    jSONObject2.put("w", str422222).put("c", map2.get(str422222));
                                    jSONArray2.put(jSONObject2);
                                }
                                jSONObject.put("wa", jSONArray2);
                            }
                            jSONArray.put(jSONObject);
                        }
                        jSONObject3 = new JSONObject();
                        jSONObject3.put("t", 6).put("tbe", j6 / 1000).put("ten", j2 / 1000).put("pa", jSONArray);
                        a(cVar3.hQu, cVar3.id, e3, jSONObject3.toString());
                        return;
                    }
                }
                x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip %s, now:%d", new Object[]{cVar3, Long.valueOf(Wo)});
                return;
            }
            x.i("MicroMsg.ClickFlowStatReceiver", "type: pagestat, skip null");
        } catch (Throwable e22) {
            x.e("MicroMsg.ClickFlowStatReceiver", "report ev:4 exception : %s", new Object[]{bh.i(e22)});
        } catch (Throwable e222) {
            com.tencent.mm.loader.stub.b.deleteFile(str);
            System.gc();
            x.printErrStackTrace("MicroMsg.ClickFlowStatReceiver", e222, "OutOfMemoryError", new Object[0]);
            v(15010, bh.i(e222));
        }
    }

    @SuppressLint({"UseSparseArrays"})
    private static HashMap<Long, ArrayList<b>> mJ(String str) {
        Throwable th;
        InputStream inputStream;
        FileInputStream fileInputStream = null;
        long Wp = bh.Wp();
        ObjectInputStream objectInputStream;
        try {
            File file = new File(str);
            if (!file.exists() || file.length() <= 0) {
                x.w("MicroMsg.ClickFlowStatReceiver", "readStorage not exist path[%s]", new Object[]{str});
                return new HashMap();
            }
            InputStream fileInputStream2 = new FileInputStream(file);
            try {
                objectInputStream = new ObjectInputStream(fileInputStream2);
                try {
                    HashMap<Long, ArrayList<b>> hashMap = (HashMap) objectInputStream.readObject();
                    x.i("MicroMsg.ClickFlowStatReceiver", "readStorage keys count:%d readTime:%d", new Object[]{Integer.valueOf(hashMap.size()), Long.valueOf(bh.bz(Wp))});
                    try {
                        objectInputStream.close();
                    } catch (Exception e) {
                    }
                    try {
                        fileInputStream2.close();
                        return hashMap;
                    } catch (Exception e2) {
                        return hashMap;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    inputStream = fileInputStream2;
                    if (objectInputStream != null) {
                        objectInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = null;
                inputStream = fileInputStream2;
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            objectInputStream = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private synchronized void a(String str, HashMap<Long, ArrayList<b>> hashMap) {
        Throwable e;
        FileOutputStream fileOutputStream = null;
        synchronized (this) {
            FileOutputStream fileOutputStream2;
            ObjectOutputStream objectOutputStream;
            try {
                long Wp = bh.Wp();
                fileOutputStream2 = new FileOutputStream(str);
                try {
                    objectOutputStream = new ObjectOutputStream(fileOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    objectOutputStream = null;
                    fileOutputStream = fileOutputStream2;
                    try {
                        x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", new Object[]{e.getMessage(), bh.i(e)});
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e = th;
                        fileOutputStream2 = fileOutputStream;
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    objectOutputStream = null;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
                try {
                    objectOutputStream.writeObject(hashMap);
                    fileOutputStream2.flush();
                    x.i("MicroMsg.ClickFlowStatReceiver", "writeStorage count:%d time:%d", new Object[]{Integer.valueOf(hashMap.size()), Long.valueOf(bh.bz(Wp))});
                    try {
                        objectOutputStream.close();
                    } catch (Exception e7) {
                    }
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                    }
                } catch (Exception e9) {
                    e = e9;
                    fileOutputStream = fileOutputStream2;
                    x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", new Object[]{e.getMessage(), bh.i(e)});
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th3) {
                    e = th3;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw e;
                }
            } catch (Exception e10) {
                e = e10;
                objectOutputStream = null;
                x.e("MicroMsg.ClickFlowStatReceiver", "writeStorage exception: %s [%s]", new Object[]{e.getMessage(), bh.i(e)});
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            } catch (Throwable th4) {
                e = th4;
                objectOutputStream = null;
                fileOutputStream2 = null;
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw e;
            }
        }
        return;
    }

    private static void a(int i, String str, int i2, String str2) {
        try {
            String replace = str2.replace(",", ";");
            int ceil = (int) Math.ceil(((double) replace.length()) / 6000.0d);
            for (int i3 = 0; i3 < ceil; i3++) {
                x.i("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter id:%d event[%s] [%s]", new Object[]{Integer.valueOf(i), str, str + "," + i2 + "," + i3 + "," + ceil + ",0,0,," + replace.substring(i3 * 6000, Math.min((i3 + 1) * 6000, replace.length()))});
                com.tencent.mm.plugin.report.d.pPH.a(346, 4, 1, false);
                com.tencent.mm.plugin.report.d.pPH.a(i, r11, true, true);
            }
        } catch (Throwable e) {
            v(15009, bh.i(e));
            x.e("MicroMsg.ClickFlowStatReceiver", "jsonKVReporter exception : %s", new Object[]{bh.i(e)});
        }
    }

    private static String bp(long j) {
        if (j < 100000000000L) {
            return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j * 1000));
        }
        return new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(j)) + String.format(Locale.getDefault(), ".%03d", new Object[]{Long.valueOf(j % 1000)});
    }

    private static String by(Context context) {
        int i;
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100 && (runningAppProcessInfo.processName.equals("com.tencent.mm") || runningAppProcessInfo.processName.equals("com.tencent.mm:tools"))) {
                    i = 1;
                    break;
                }
            }
        }
        i = 0;
        if (i == 0) {
            return "";
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String className;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    return "";
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        return null;
                    }
                    className = componentName.getClassName();
                    if (className.contains(".")) {
                        return className.substring(className.lastIndexOf(".") + 1);
                    }
                    return className;
                }
                return "";
            }
            className = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (className.contains(".")) {
                return className.substring(className.lastIndexOf(".") + 1);
            }
            return className;
        } catch (Throwable e) {
            x.e("MicroMsg.ClickFlowStatReceiver", "getTopActivityName Exception:%s stack:%s", new Object[]{e.getMessage(), bh.i(e)});
        }
    }
}
