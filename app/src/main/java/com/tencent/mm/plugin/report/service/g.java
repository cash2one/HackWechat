package com.tencent.mm.plugin.report.service;

import android.util.Pair;
import com.tencent.mars.BaseEvent;
import com.tencent.mars.smc.IDKey;
import com.tencent.mars.smc.SmcLogic;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.q;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public enum g implements c {
    ;
    
    private long pQO;
    private int pQP;
    private HashMap<String, Long> pQQ;
    private int pQR;
    private int pQS;
    private long pQT;
    private int uin;

    class AnonymousClass7 implements Callable<JSONArray> {
        final /* synthetic */ List juo;
        final /* synthetic */ g pQV;

        public AnonymousClass7(g gVar, List list) {
            this.pQV = gVar;
            this.juo = list;
        }

        public final /* synthetic */ Object call() {
            JSONArray jSONArray = new JSONArray();
            for (Pair pair : this.juo) {
                JSONObject jSONObject = pair.second == null ? new JSONObject() : new JSONObject((Map) pair.second);
                jSONObject.put("info", pair.first);
                jSONArray.put(jSONObject);
            }
            return jSONArray;
        }
    }

    private g(String str) {
        this.pQO = 0;
        if (ac.cfw()) {
            com.tencent.mm.kernel.g.Dm().F(new Runnable(this) {
                final /* synthetic */ g pQV;

                {
                    this.pQV = r1;
                }

                public final void run() {
                    g.a(this.pQV);
                }
            });
            final Runnable anonymousClass2 = new Runnable(this) {
                final /* synthetic */ g pQV;

                {
                    this.pQV = r1;
                }

                public final void run() {
                    g.b(this.pQV);
                }
            };
            a.xef.a(new com.tencent.mm.sdk.b.c<lu>(this) {
                final /* synthetic */ g pQV;

                public final /* synthetic */ boolean a(b bVar) {
                    if (this.pQV.pQT <= 0) {
                        Object obj = com.tencent.mm.kernel.g.Dj().CU().get(w.a.USERINFO_CLOG_SAMPLING_REFRESH_TIME_LONG, null);
                        if (obj != null && (obj instanceof Long)) {
                            this.pQV.pQT = ((Long) obj).longValue();
                        }
                    }
                    if (System.currentTimeMillis() - this.pQV.pQT > 86400000) {
                        com.tencent.mm.kernel.g.Dm().g(anonymousClass2, 100);
                    }
                    return true;
                }
            });
            com.tencent.mm.kernel.g.CG().a(701, new e(this) {
                final /* synthetic */ g pQV;

                public final void a(int i, int i2, String str, k kVar) {
                    if (i == 0) {
                        com.tencent.mm.kernel.g.Dm().g(anonymousClass2, 5000);
                    }
                }
            });
        }
    }

    public static Object a(int i, int[] iArr, int i2, int i3) {
        return d.a(i, iArr, i2, i3);
    }

    private static void i(int i, String str, boolean z) {
        KVReportDataInfo kVReportDataInfo = new KVReportDataInfo();
        kVReportDataInfo.pQz = (long) i;
        kVReportDataInfo.value = str;
        kVReportDataInfo.pQh = false;
        kVReportDataInfo.pQA = z;
        KVCommCrossProcessReceiver.a(kVReportDataInfo);
    }

    public final void k(int i, String str) {
        if (com.tencent.mm.plugin.report.a.c.pPK) {
            a(i, str, com.tencent.mm.plugin.report.a.c.pPL, com.tencent.mm.plugin.report.a.c.pPL);
        } else {
            a(i, str, false, false);
        }
    }

    public final void a(int i, String str, boolean z, boolean z2) {
        if (!ac.cfw()) {
            i(i, str, z);
        } else if (com.tencent.mm.plugin.report.a.c.pPK) {
            d.a((long) i, str, com.tencent.mm.plugin.report.a.c.pPL, com.tencent.mm.plugin.report.a.c.pPL);
        } else {
            d.a((long) i, str, z, false);
        }
    }

    public final void h(int i, Object... objArr) {
        if (com.tencent.mm.plugin.report.a.c.pPK) {
            a(i, com.tencent.mm.plugin.report.a.c.pPL, com.tencent.mm.plugin.report.a.c.pPL, objArr);
        } else {
            a(i, false, false, objArr);
        }
    }

    public final void a(int i, boolean z, boolean z2, Object... objArr) {
        String str;
        if (objArr == null || objArr.length <= 0) {
            x.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2]).replace(',', ' ')).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            str = stringBuilder.toString();
        }
        if (com.tencent.mm.sdk.a.b.ceK()) {
            x.v("MicroMsg.ReportManagerKvCheck", "kvTypedStat id:%d [%b,%b] val:%s", Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(false), str);
        }
        if (ac.cfw()) {
            d.a((long) i, str, z, false);
        } else {
            i(i, str, z);
        }
    }

    public final boolean c(int i, com.tencent.mm.bq.a aVar) {
        try {
            aVar.getClass().getField("import_ds_").setInt(aVar, Integer.MAX_VALUE);
            long Wp = bh.Wp();
            if (Wp / 86400 != this.pQO) {
                try {
                    this.pQP = bh.getInt(new SimpleDateFormat("yyyyMMdd").format(new Date()), 0);
                } catch (Exception e) {
                }
            }
            aVar.getClass().getField("ds_").setInt(aVar, this.pQP);
            aVar.getClass().getField("uin_").setLong(aVar, ((long) this.uin) & 4294967295L);
            aVar.getClass().getField("device_").setInt(aVar, 2);
            aVar.getClass().getField("clientVersion_").setInt(aVar, com.tencent.mm.protocal.d.vAz);
            aVar.getClass().getField("time_stamp_").setLong(aVar, Wp);
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (!ac.cfw()) {
                    x.f("MicroMsg.ReportManagerKvCheck", "not in MM Process");
                    return true;
                } else if (com.tencent.mm.plugin.report.a.c.pPK) {
                    d.a((long) i, toByteArray, com.tencent.mm.plugin.report.a.c.pPL, com.tencent.mm.plugin.report.a.c.pPL);
                    return true;
                } else {
                    d.a((long) i, toByteArray, false, false);
                    return true;
                }
            } catch (IOException e2) {
                x.e("MicroMsg.ReportManagerKvCheck", "pbKVStat LocalReportPb error, %d, %s", Integer.valueOf(i), e2.toString());
                return false;
            }
        } catch (Exception e3) {
            x.e("MicroMsg.ReportManagerKvCheck", "pbKVStat  set values error, %d, %s", Integer.valueOf(i), e3.toString());
            return false;
        }
    }

    public final void d(int i, List<String> list) {
        if (com.tencent.mm.plugin.report.a.c.pPK) {
            b(i, list, com.tencent.mm.plugin.report.a.c.pPL);
        } else {
            b(i, list, false);
        }
    }

    private static void b(int i, List<String> list, boolean z) {
        String str;
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.ReportManagerKvCheck", "vals is null, use '' as value");
            str = "";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int size = list.size() - 1;
            for (int i2 = 0; i2 < size; i2++) {
                stringBuilder.append((String) list.get(i2)).append(',');
            }
            stringBuilder.append((String) list.get(size));
            str = stringBuilder.toString();
        }
        if (ac.cfw()) {
            d.a((long) i, str, z, false);
        } else {
            i(i, str, z);
        }
    }

    public final void h(long j, long j2) {
        a(j, j2, 1, false);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        if (j < 0 || j2 < 0 || j3 <= 0) {
            x.e("MicroMsg.ReportManagerKvCheck", "ID %d, key %d, value %d <0", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3));
        } else if (ac.cfw()) {
            d.b(j, j2, j3, false);
        } else {
            StIDKeyDataInfo stIDKeyDataInfo = new StIDKeyDataInfo();
            stIDKeyDataInfo.pRd = j;
            stIDKeyDataInfo.key = j2;
            stIDKeyDataInfo.value = j3;
            stIDKeyDataInfo.pQh = false;
            KVCommCrossProcessReceiver.a(stIDKeyDataInfo);
        }
    }

    public final void a(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList == null) {
            x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat lstIdKeyDataInfos == null return");
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            if (iDKey == null) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat info == null return");
                return;
            } else if (iDKey.GetID() < 0 || iDKey.GetKey() < 0) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            } else if (iDKey.GetValue() <= 0) {
                x.e("MicroMsg.ReportManagerKvCheck", "report idkeyGroupStat ID %d, key %d, value %d <0", Long.valueOf(iDKey.GetID()), Long.valueOf(iDKey.GetKey()), Long.valueOf(iDKey.GetValue()));
                return;
            }
        }
        if (ac.cfw()) {
            d.b(arrayList, false);
        } else {
            KVCommCrossProcessReceiver.M(arrayList);
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i3);
        iDKey.SetValue((long) i5);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i2);
        iDKey2.SetKey(i4);
        iDKey2.SetValue((long) i6);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        a(arrayList, z);
    }

    public final void c(int i, int i2, int i3, int i4, boolean z) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue((long) i4);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        a(arrayList, false);
    }

    public final void V(int i, int i2, int i3) {
        IDKey iDKey = new IDKey();
        iDKey.SetID(i);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i);
        iDKey2.SetKey(i3);
        iDKey2.SetValue(1);
        ArrayList arrayList = new ArrayList();
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        a(arrayList, false);
    }

    public static void bon() {
        if (ac.cfw()) {
            BaseEvent.onSingalCrash(0);
        } else {
            KVCommCrossProcessReceiver.boh();
        }
    }

    public final void dR(String str, String str2) {
        c(str, str2, null);
    }

    public final void c(String str, final String str2, final Map<String, Object> map) {
        a(str, new Callable<JSONArray>(this) {
            final /* synthetic */ g pQV;

            public final /* synthetic */ Object call() {
                return new JSONArray().put((map == null ? new JSONObject() : new JSONObject(map)).put("info", str2));
            }
        });
    }

    public final void k(String str, final List<String> list) {
        a(str, new Callable<JSONArray>(this) {
            final /* synthetic */ g pQV;

            public final /* synthetic */ Object call() {
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(new JSONObject().put("info", put));
                }
                return jSONArray;
            }
        });
    }

    public final void a(String str, Callable<JSONArray> callable) {
        Long l;
        Object obj;
        String str2;
        final long currentTimeMillis = System.currentTimeMillis();
        if (this.pQQ != null) {
            l = (Long) this.pQQ.get(str);
        } else {
            l = null;
        }
        if (l != null) {
            byte[] t = com.tencent.mm.a.g.t((str + this.uin + currentTimeMillis).getBytes());
            if (t != null && t.length == 16) {
                String str3;
                long j = (((((long) (((t[0] + t[4]) + t[8]) + t[12])) & 255) | ((((long) (((t[1] + t[5]) + t[9]) + t[13])) & 255) << 8)) | ((((long) (((t[2] + t[6]) + t[10]) + t[14])) & 255) << 16)) | ((((long) (t[15] + ((t[3] + t[7]) + t[11]))) & 255) << 24);
                if (j < l.longValue()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                str2 = "MicroMsg.cLog";
                String str4 = "[%s] Sampling %s: 0x%08x / 0x%08x";
                Object[] objArr = new Object[4];
                objArr[0] = str;
                if (obj != null) {
                    str3 = "hit";
                } else {
                    str3 = "miss";
                }
                objArr[1] = str3;
                objArr[2] = Long.valueOf(j);
                objArr[3] = l;
                x.d(str2, str4, objArr);
                if (obj == null) {
                    final Callable<JSONArray> callable2 = callable;
                    str2 = str;
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ g pQV;

                        public final void run() {
                            String str;
                            int i;
                            String str2 = null;
                            if (ac.cfw() && com.tencent.mm.kernel.g.Dh().Cy()) {
                                com.tencent.mm.kernel.g.Dh();
                                int Cg = com.tencent.mm.kernel.a.Cg();
                                if (com.tencent.mm.kernel.g.Dj().CU() != null) {
                                    str2 = q.FS();
                                }
                                str = str2;
                                i = Cg;
                            } else {
                                str = null;
                                i = 0;
                            }
                            try {
                                String string = ac.getContext().getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com");
                                JSONArray jSONArray = (JSONArray) callable2.call();
                                int length = jSONArray.length();
                                for (Cg = 0; Cg < length; Cg++) {
                                    JSONObject jSONObject = jSONArray.getJSONObject(Cg);
                                    jSONObject.put("tag", str2);
                                    jSONObject.put(OpenSDKTool4Assistant.EXTRA_UIN, i);
                                }
                                byte[] bytes = new JSONObject().put("head", new JSONObject().put("protocol_ver", 1).put("phone", com.tencent.mm.protocal.d.vAx).put("os_ver", com.tencent.mm.protocal.d.DEVICE_TYPE).put("report_time", currentTimeMillis).put("revision", bh.ou(com.tencent.mm.sdk.platformtools.e.REV))).put("items", jSONArray).toString().getBytes();
                                String toLowerCase = com.tencent.mm.a.g.s(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(com.tencent.mm.protocal.d.vAz), Integer.valueOf(bytes.length)}).getBytes()).toLowerCase();
                                bytes = com.tencent.mm.a.q.q(bytes);
                                PByteArray pByteArray = new PByteArray();
                                com.tencent.mm.a.c.a(pByteArray, bytes, toLowerCase.getBytes());
                                StringBuilder append = new StringBuilder(256).append("http://").append(string).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(com.tencent.mm.protocal.d.vAz)).append("&devicetype=").append(com.tencent.mm.protocal.d.DEVICE_TYPE).append("&filelength=").append(Cg).append("&sum=").append(toLowerCase).append("&reporttype=1&NewReportType=110");
                                if (!(str == null || str.length() == 0)) {
                                    append.append("&username=").append(str);
                                }
                                if (i != 0) {
                                    append.append("&uin=").append(i);
                                }
                                str2 = append.toString();
                                HttpClient defaultHttpClient = new DefaultHttpClient();
                                HttpUriRequest httpPost = new HttpPost(str2);
                                HttpEntity byteArrayEntity = new ByteArrayEntity(pByteArray.value);
                                byteArrayEntity.setContentType("binary/octet-stream");
                                httpPost.setEntity(byteArrayEntity);
                                x.i("MicroMsg.cLog", "POST returned: " + bh.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent()));
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.ReportManagerKvCheck", e, "Failed to upload cLog.", new Object[0]);
                            }
                        }
                    }, "ReportManager_cLog");
                }
            }
        }
        x.d("MicroMsg.cLog", "[%s] Sampling hit: (default)", str);
        obj = 1;
        if (obj == null) {
            final Callable<JSONArray> callable22 = callable;
            str2 = str;
            com.tencent.mm.sdk.f.e.post(/* anonymous class already generated */, "ReportManager_cLog");
        }
    }

    public final void eE(int i) {
        this.uin = i;
        SmcLogic.setUin((long) i);
    }
}
