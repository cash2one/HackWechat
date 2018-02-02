package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.os.Build;
import com.tencent.mm.a.c;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.a.q;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.updater.AppUpdaterUI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;

public final class a {
    static final HashMap<String, Integer> gJg;

    static /* synthetic */ void v(String str, byte[] bArr) {
        x.e("MicroMsg.CrashUpload", "doPost : url = " + str + ", data.length = " + bArr.length);
        HttpClient defaultHttpClient = new DefaultHttpClient();
        HttpUriRequest httpPost = new HttpPost(str);
        try {
            HttpEntity byteArrayEntity = new ByteArrayEntity(bArr);
            byteArrayEntity.setContentType("binary/octet-stream");
            httpPost.setEntity(byteArrayEntity);
            String convertStreamToString = bh.convertStreamToString(defaultHttpClient.execute(httpPost).getEntity().getContent());
            if (convertStreamToString != null && convertStreamToString.length() > 0) {
                final Map y = bi.y(convertStreamToString, "Response");
                if (!(y == null || !"-1000".equalsIgnoreCase((String) y.get(".Response.retCode")) || y.get(".Response.url") == null)) {
                    new Timer().schedule(new TimerTask() {
                        public final void run() {
                            Intent intent = new Intent(ac.getContext(), AppUpdaterUI.class);
                            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            intent.putExtra("intent_extra_desc", (String) y.get(".Response.desc"));
                            intent.putExtra("intent_update_type", 999);
                            intent.putExtra("intent_extra_download_url", new String[]{(String) y.get(".Response.url")});
                            ac.getContext().startActivity(intent);
                        }
                    }, 500);
                }
            }
            x.d("MicroMsg.CrashUpload", convertStreamToString);
            x.e("MicroMsg.CrashUpload", "doPost: returnConnection = %s", new Object[]{convertStreamToString});
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.CrashUpload", e, "", new Object[0]);
            x.e("MicroMsg.CrashUpload", "doPost e type: %s, msg: %s", new Object[]{e.getClass().getSimpleName(), e.getMessage()});
        }
    }

    static {
        HashMap hashMap = new HashMap(16);
        gJg = hashMap;
        hashMap.put("exception", Integer.valueOf(10001));
        gJg.put("anr", Integer.valueOf(10002));
        gJg.put("handler", Integer.valueOf(10003));
        gJg.put("sql", Integer.valueOf(10004));
        gJg.put("permission", Integer.valueOf(10005));
        gJg.put("main_thread_watch", Integer.valueOf(10006));
    }

    public static int cef() {
        File file = new File(w.gZK + "crash/");
        if (!file.exists()) {
            x.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            x.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                public final boolean accept(File file, String str) {
                    return str.endsWith(".crashlog");
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (CharSequence split : list) {
                String[] split2 = compile.split(split);
                if (split2 != null && split2.length > 0) {
                    fm(split2[0], split2.length >= 2 ? split2[1] : "");
                }
            }
            return 1;
        }
    }

    private static int fm(String str, String str2) {
        String str3 = w.gZK + "crash/" + str + "." + str2 + ".crashini";
        long c = bh.c(com.tencent.mm.sdk.e.a.fw(str3, "count"));
        long Wp = bh.Wp() - bh.c(com.tencent.mm.sdk.e.a.fw(str3, "lasttime"));
        String str4 = w.gZK + "crash/" + str + "." + str2 + ".crashlog";
        int bN = e.bN(str4);
        x.d("MicroMsg.CrashUpload", "dkcrash count:" + c + " t:" + Wp + " len:" + bN);
        if (bN < 5242880) {
            byte[] e = e.e(str4, 0, -1);
            if (!bh.bw(e)) {
                String toLowerCase = g.s(String.format("weixin#$()%d%d", new Object[]{Integer.valueOf(d.vAz), Integer.valueOf(e.length)}).getBytes()).toLowerCase();
                e = q.q(e);
                PByteArray pByteArray = new PByteArray();
                c.a(pByteArray, e, toLowerCase.getBytes());
                com.tencent.mm.sdk.f.e.post(new 2(r1, toLowerCase, str2, str, pByteArray), "CrashUpload_upload");
            }
        }
        b.deleteFile(str4);
        new com.tencent.mm.sdk.e.a(str3).cX("count", 0);
        com.tencent.mm.sdk.e.a.h(str3, "lasttime", bh.Wp());
        return 1;
    }

    public static int a(String str, String str2, com.tencent.mm.sandbox.monitor.b.a aVar) {
        if (bh.ov(aVar.toString())) {
            return -1;
        }
        File file = new File(w.gZK + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str3 = w.gZK + "crash/" + str + "." + str2 + ".crashini";
        com.tencent.mm.sdk.e.a.h(str3, "count", bh.c(com.tencent.mm.sdk.e.a.fw(str3, "count")) + 1);
        if (bh.c(com.tencent.mm.sdk.e.a.fw(str3, "lasttime")) == 0) {
            com.tencent.mm.sdk.e.a.h(str3, "lasttime", bh.Wp());
        }
        x.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", new Object[]{w.gZK + "crash/" + str + "." + str2 + ".crashlog", Integer.valueOf(aVar.toString().length())});
        a(aVar);
        a(str3, aVar);
        return fm(str, str2);
    }

    private static void a(com.tencent.mm.sandbox.monitor.b.a aVar) {
        if (aVar.xbS) {
            File file = new File(com.tencent.mm.compatible.util.e.gZM);
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (bh.bz(file2.lastModified()) > 604800000) {
                        x.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", new Object[]{file2.getPath()});
                        file2.delete();
                    }
                }
            }
            x.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", new Object[]{com.tencent.mm.compatible.util.e.gZM + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date()) + ".txt"});
            a(r0, aVar);
        }
    }

    private static void a(String str, com.tencent.mm.sandbox.monitor.b.a aVar) {
        if (!new File(str).exists()) {
            int i = ac.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder stringBuilder = new StringBuilder();
            if (i == 0) {
                String eX = bh.eX(ac.getContext());
                if (bh.ov(eX)) {
                    stringBuilder.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                } else {
                    stringBuilder.append("uin[" + eX + "] ");
                }
            } else {
                stringBuilder.append("uin[" + o.getString(i) + "] ");
            }
            stringBuilder.append(x.cfm());
            stringBuilder.append(" BRAND:[" + Build.BRAND + "] ");
            String[] yK = com.tencent.mm.compatible.d.q.yK();
            stringBuilder.append("c1[" + yK[0] + "] ");
            stringBuilder.append("c2[" + yK[1] + "] ");
            stringBuilder.append("\n");
            e.d(str, stringBuilder.toString().getBytes());
        }
        if (e.bN(str) > 10485760) {
            b.deleteFile(str);
        }
        e.d(str, (aVar.toString() + "\n").getBytes());
    }
}
