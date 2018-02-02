package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.c;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.j;
import com.tencent.smtt.utils.p;
import com.tencent.smtt.utils.q;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;

class v {
    private static v zYb;
    private Context mContext;
    private Handler zYc = null;
    boolean zYd = false;

    public enum a {
        TYPE_DOWNLOAD(0),
        TYPE_INSTALL(1),
        TYPE_LOAD(2),
        TYPE_DOWNLOAD_DECOUPLE(3),
        TYPE_INSTALL_DECOUPLE(4),
        TYPE_COOKIE_DB_SWITCH(5);
        
        int value;

        private a(int i) {
            this.value = i;
        }
    }

    private v(Context context) {
        this.mContext = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("TbsLogReportThread");
        handlerThread.start();
        this.zYc = new 1(this, handlerThread.getLooper());
    }

    private static String HZ(int i) {
        return i + "|";
    }

    private void a(int i, b bVar, a aVar) {
        bVar.setErrorCode(i);
        bVar.zYm = System.currentTimeMillis();
        QbSdk.zWf.lz(i);
        a(aVar, bVar);
    }

    static /* synthetic */ void a(v vVar, int i, b bVar) {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HZ(i));
        stringBuilder.append(abj(c.ab(vVar.mContext)));
        stringBuilder.append(abj(p.hW(vVar.mContext)));
        stringBuilder.append(HZ(t.cEF().ha(vVar.mContext)));
        String str2 = Build.MODEL;
        try {
            str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
        } catch (Exception e) {
            str = str2;
        }
        stringBuilder.append(abj(str));
        str = vVar.mContext.getPackageName();
        stringBuilder.append(abj(str));
        if ("com.tencent.mm".equals(str)) {
            stringBuilder.append(abj(c.bO(vVar.mContext, "com.tencent.mm.BuildInfo.CLIENT_VERSION")));
        } else {
            stringBuilder.append(HZ(c.getAppVersionCode(vVar.mContext)));
        }
        stringBuilder.append(abj(bp(b.a(bVar))));
        stringBuilder.append(abj(b.b(bVar)));
        stringBuilder.append(abj(b.c(bVar)));
        stringBuilder.append(HZ(b.d(bVar)));
        stringBuilder.append(HZ(b.e(bVar)));
        stringBuilder.append(HZ(b.f(bVar)));
        stringBuilder.append(HZ(b.g(bVar)));
        stringBuilder.append(abj(b.h(bVar)));
        stringBuilder.append(HZ(b.i(bVar)));
        stringBuilder.append(HZ(b.j(bVar)));
        stringBuilder.append(gw(b.k(bVar)));
        stringBuilder.append(gw(b.l(bVar)));
        stringBuilder.append(gw(b.m(bVar)));
        stringBuilder.append(HZ(b.n(bVar)));
        stringBuilder.append(HZ(bVar.mErrorCode));
        stringBuilder.append(abj(b.o(bVar)));
        stringBuilder.append(abj(b.p(bVar)));
        stringBuilder.append(HZ(o.gG(vVar.mContext).zXm.getInt("tbs_download_version", 0)));
        stringBuilder.append(abj(c.hP(vVar.mContext)));
        stringBuilder.append(abj("3.6.0.1140_43603"));
        stringBuilder.append(false);
        SharedPreferences cEO = vVar.cEO();
        JSONArray cEL = vVar.cEL();
        JSONArray jSONArray = new JSONArray();
        if (jSONArray.length() >= 5) {
            for (int i2 = 4; i2 > 0; i2--) {
                try {
                    jSONArray.put(cEL.get(jSONArray.length() - i2));
                } catch (Exception e2) {
                    TbsLog.e("upload", "JSONArray transform error!");
                }
            }
        } else {
            jSONArray = cEL;
        }
        jSONArray.put(stringBuilder.toString());
        Editor edit = cEO.edit();
        edit.putString("tbs_download_upload", jSONArray.toString());
        edit.commit();
        if (vVar.zYd || i != a.TYPE_LOAD.value) {
            vVar.cEN();
        }
    }

    private static String abj(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str == null) {
            str = "";
        }
        return stringBuilder.append(str).append("|").toString();
    }

    static /* synthetic */ void b(v vVar) {
        Editor edit = vVar.cEO().edit();
        edit.remove("tbs_download_upload");
        edit.commit();
    }

    private static String bp(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(j));
        } catch (Exception e) {
        }
        return str;
    }

    public static b cEJ() {
        return new b((byte) 0);
    }

    private JSONArray cEL() {
        String string = cEO().getString("tbs_download_upload", null);
        if (string == null) {
            return new JSONArray();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            if (jSONArray.length() <= 5) {
                return jSONArray;
            }
            JSONArray jSONArray2 = new JSONArray();
            int length = jSONArray.length() - 1;
            if (length <= jSONArray.length() - 5) {
                return jSONArray;
            }
            jSONArray2.put(jSONArray.get(length));
            return jSONArray2;
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    private void cEN() {
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat]");
        JSONArray cEL = cEL();
        if (cEL.length() == 0) {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] no data");
            return;
        }
        TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] jsonArray:" + cEL);
        try {
            TbsLog.i("TbsDownload", "[TbsApkDownloadStat.reportDownloadStat] response:" + g.a(q.hZ(this.mContext).Abi, cEL.toString().getBytes(ProtocolPackage.ServerEncoding), new 3(this), true) + " testcase: -1");
        } catch (Throwable th) {
        }
    }

    private static String gw(long j) {
        return j + "|";
    }

    public static v hn(Context context) {
        if (zYb == null) {
            synchronized (v.class) {
                if (zYb == null) {
                    zYb = new v(context);
                }
            }
        }
        return zYb;
    }

    public final void a(int i, String str, a aVar) {
        if (!(i == 200 || i == 220 || i == 221)) {
            TbsLog.i("TbsDownload", "error occured in installation, errorCode:" + i, true);
        }
        b cEJ = cEJ();
        cEJ.abl(str);
        a(i, cEJ, aVar);
    }

    public final void a(a aVar, b bVar) {
        try {
            b bVar2 = (b) bVar.clone();
            Message obtainMessage = this.zYc.obtainMessage();
            obtainMessage.what = 600;
            obtainMessage.arg1 = aVar.value;
            obtainMessage.obj = bVar2;
            this.zYc.sendMessage(obtainMessage);
        } catch (Throwable th) {
            TbsLog.w("upload", "[TbsLogReport.eventReport] error, message=" + th.getMessage());
        }
    }

    public final void bc(int i, String str) {
        a(i, str, a.TYPE_INSTALL);
    }

    public final void bd(int i, String str) {
        b cEJ = cEJ();
        cEJ.setErrorCode(i);
        cEJ.zYm = System.currentTimeMillis();
        cEJ.abl(str);
        a(a.TYPE_LOAD, cEJ);
    }

    public final void c(int i, Throwable th) {
        b cEJ = cEJ();
        cEJ.m(th);
        a(i, cEJ, a.TYPE_INSTALL);
    }

    public final void cEK() {
        this.zYc.sendEmptyMessage(601);
    }

    public final void cEM() {
        File file;
        ByteArrayOutputStream byteArrayOutputStream;
        File file2;
        FileInputStream fileInputStream;
        com.tencent.smtt.utils.g.a 2;
        HttpURLConnection s;
        Throwable th;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (b.hL(this.mContext) == 3) {
            String tbsLogFilePath = TbsLog.getTbsLogFilePath();
            if (tbsLogFilePath != null) {
                j.cFu();
                String cFv = j.cFv();
                String ab = c.ab(this.mContext);
                String hP = c.hP(this.mContext);
                byte[] bytes = ab.getBytes();
                byte[] bytes2 = hP.getBytes();
                try {
                    bytes = j.cFu().bL(bytes);
                    bytes2 = j.cFu().bL(bytes2);
                } catch (Exception e) {
                }
                String bytesToHex = j.bytesToHex(bytes);
                String str = q.hZ(this.mContext).Abk + bytesToHex + "&aid=" + j.bytesToHex(bytes2);
                Map hashMap = new HashMap();
                hashMap.put("Content-Type", "application/octet-stream");
                hashMap.put("Charset", "UTF-8");
                hashMap.put("QUA2", p.hW(this.mContext));
                FileInputStream fileInputStream2;
                try {
                    File file3 = new File(f.AaA);
                    new c(tbsLogFilePath, f.AaA + "/tbslog_temp.zip").cEP();
                    file = new File(f.AaA, "tbslog_temp.zip");
                    try {
                        fileInputStream2 = new FileInputStream(file);
                    } catch (Exception e2) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                            }
                        }
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (file2 != null) {
                            file2.delete();
                            bytes2 = null;
                        } else {
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + cFv;
                        2 = new 2(this);
                        if (bytes2 == null) {
                            s = g.s(bytesToHex, hashMap);
                            if (s == null) {
                                g.a(s, bytes2);
                                g.a(s, 2, false);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream2 = null;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Exception e5) {
                            }
                        }
                        if (byteArrayOutputStream2 != null) {
                            try {
                                byteArrayOutputStream2.close();
                            } catch (Exception e6) {
                            }
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                    try {
                        bytes2 = new byte[8192];
                        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = fileInputStream2.read(bytes2);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream3.write(bytes2, 0, read);
                            } catch (Exception e7) {
                                byteArrayOutputStream = byteArrayOutputStream3;
                                file2 = file;
                                fileInputStream = fileInputStream2;
                            } catch (Throwable th3) {
                                th = th3;
                                byteArrayOutputStream2 = byteArrayOutputStream3;
                            }
                        }
                        byteArrayOutputStream3.flush();
                        bytes2 = j.cFu().bL(byteArrayOutputStream3.toByteArray());
                        try {
                            fileInputStream2.close();
                        } catch (Exception e8) {
                        }
                        try {
                            byteArrayOutputStream3.close();
                        } catch (Exception e9) {
                        }
                        file.delete();
                    } catch (Exception e10) {
                        byteArrayOutputStream = null;
                        file2 = file;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (byteArrayOutputStream != null) {
                            byteArrayOutputStream.close();
                        }
                        if (file2 != null) {
                            bytes2 = null;
                        } else {
                            file2.delete();
                            bytes2 = null;
                        }
                        bytesToHex = str + "&ek=" + cFv;
                        2 = new 2(this);
                        if (bytes2 == null) {
                            s = g.s(bytesToHex, hashMap);
                            if (s == null) {
                                g.a(s, bytes2);
                                g.a(s, 2, false);
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (byteArrayOutputStream2 != null) {
                            byteArrayOutputStream2.close();
                        }
                        if (file != null) {
                            file.delete();
                        }
                        throw th;
                    }
                } catch (Exception e11) {
                    byteArrayOutputStream = null;
                    file2 = null;
                    fileInputStream = null;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (file2 != null) {
                        file2.delete();
                        bytes2 = null;
                    } else {
                        bytes2 = null;
                    }
                    bytesToHex = str + "&ek=" + cFv;
                    2 = new 2(this);
                    if (bytes2 == null) {
                        s = g.s(bytesToHex, hashMap);
                        if (s == null) {
                            g.a(s, bytes2);
                            g.a(s, 2, false);
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    file = null;
                    fileInputStream2 = null;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (byteArrayOutputStream2 != null) {
                        byteArrayOutputStream2.close();
                    }
                    if (file != null) {
                        file.delete();
                    }
                    throw th;
                }
                bytesToHex = str + "&ek=" + cFv;
                2 = new 2(this);
                if (bytes2 == null) {
                    s = g.s(bytesToHex, hashMap);
                    if (s == null) {
                        g.a(s, bytes2);
                        g.a(s, 2, false);
                    }
                }
            }
        }
    }

    final SharedPreferences cEO() {
        return this.mContext.getSharedPreferences("tbs_download_stat", 4);
    }
}
