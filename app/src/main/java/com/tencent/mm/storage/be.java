package com.tencent.mm.storage;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;

public final class be extends j {
    private t xzW = null;

    public be(t tVar) {
        this.xzW = tVar;
    }

    public final void cjT() {
        int i;
        String str = (String) this.xzW.get(77825, null);
        x.i("MicroMsg.ServerConfigInfoStorage", "hy: readConfig xml " + str);
        if (!bh.ov(str)) {
            super.Wc(str);
        }
        if (bh.ov(str)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            str = w.gZK + "deviceconfig.cfg";
            if (e.bO(str)) {
                byte[] e = e.e(str, 0, -1);
                if (bh.bw(e)) {
                    i = -2;
                } else {
                    String str2 = new String(e, Charset.defaultCharset());
                    if (bh.ov(str2)) {
                        i = -3;
                    } else {
                        x.i("MicroMsg.ServerConfigInfoStorage", "hy: read from file: %s", str2);
                        XJ(str2);
                        i = 0;
                    }
                }
            } else {
                i = -1;
            }
        } else {
            x.i("MicroMsg.ServerConfigInfoStorage", "hy: got conf from db");
            i = 0;
        }
        x.i("MicroMsg.ServerConfigInfoStorage", "hy: read from local retcode: %d", Integer.valueOf(i));
    }

    public final String cjU() {
        String str = (String) this.xzW.get(77825, null);
        x.d("MicroMsg.ServerConfigInfoStorage", "getInfoByKey xml " + str + " key 77825");
        return str;
    }

    public final int XJ(String str) {
        x.d("MicroMsg.ServerConfigInfoStorage", "dkconf info:[%s] ", str);
        this.xzW.set(77825, str);
        XL(str);
        super.Wc(str);
        return 0;
    }

    public static String cjV() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Object obj = Build.FINGERPRINT;
        if (obj != null) {
            obj = obj.replace("/", ":");
        }
        linkedHashMap.put("fingerprint", obj);
        linkedHashMap.put("manufacturer", Build.MANUFACTURER);
        linkedHashMap.put("device", Build.DEVICE);
        linkedHashMap.put("model", Build.MODEL);
        linkedHashMap.put("product", Build.PRODUCT);
        linkedHashMap.put("board", Build.BOARD);
        linkedHashMap.put("release", VERSION.RELEASE);
        linkedHashMap.put("codename", VERSION.CODENAME);
        linkedHashMap.put("incremental", VERSION.INCREMENTAL);
        linkedHashMap.put("display", Build.DISPLAY);
        String a = bh.a(linkedHashMap);
        x.d("MicroMsg.ServerConfigInfoStorage", "getLocalFingerprint  " + a);
        return a;
    }

    public static String cjW() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<deviceinfo>");
        stringBuffer.append("<MANUFACTURER name=\"");
        stringBuffer.append(Build.MANUFACTURER);
        stringBuffer.append("\">");
        stringBuffer.append("<MODEL name=\"");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_RELEASE name=\"");
        stringBuffer.append(VERSION.RELEASE);
        stringBuffer.append("\">");
        stringBuffer.append("<VERSION_INCREMENTAL name=\"");
        stringBuffer.append(VERSION.INCREMENTAL);
        stringBuffer.append("\">");
        stringBuffer.append("<DISPLAY name=\"");
        stringBuffer.append(Build.DISPLAY);
        stringBuffer.append("\">");
        stringBuffer.append("</DISPLAY></VERSION_INCREMENTAL></VERSION_RELEASE></MODEL></MANUFACTURER></deviceinfo>");
        x.d("MicroMsg.ServerConfigInfoStorage", "getFingerprint  " + stringBuffer.toString());
        return stringBuffer.toString();
    }

    public static boolean XK(String str) {
        if (bh.ov(str)) {
            return false;
        }
        try {
            if (bi.y(str, "deviceinfoconfig") == null || !g.Dh().Cy()) {
                return false;
            }
            g.Dk();
            g.Dj().CV().XJ(str);
            return true;
        } catch (Throwable e) {
            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(e));
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean XL(String str) {
        Throwable e;
        Throwable th;
        boolean z;
        File file = new File(w.gZK);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileWriter fileWriter = null;
        try {
            x.i("MicroMsg.ServerConfigInfoStorage", "writeConfigToLocalFile, path: %s, info:%s", w.gZK + "deviceconfig.cfg", str);
            FileWriter fileWriter2 = new FileWriter(w.gZK + "deviceconfig.cfg");
            try {
                fileWriter2.write(str);
                fileWriter2.close();
                try {
                    fileWriter2.close();
                    return true;
                } catch (Throwable e2) {
                    x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(e2));
                    return true;
                }
            } catch (Throwable e22) {
                fileWriter = fileWriter2;
                th = e22;
                z = false;
                try {
                    x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(th));
                    if (fileWriter != null) {
                        return z;
                    }
                    try {
                        fileWriter.close();
                        return z;
                    } catch (Throwable th2) {
                        x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(th2));
                        return z;
                    }
                } catch (Throwable th3) {
                    e22 = th3;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (Throwable th22) {
                            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(th22));
                        }
                    }
                    throw e22;
                }
            } catch (Throwable th4) {
                e22 = th4;
                fileWriter = fileWriter2;
                if (fileWriter != null) {
                    fileWriter.close();
                }
                throw e22;
            }
        } catch (Throwable e222) {
            th22 = e222;
            z = false;
            x.e("MicroMsg.ServerConfigInfoStorage", "exception:%s", bh.i(th22));
            if (fileWriter != null) {
                return z;
            }
            fileWriter.close();
            return z;
        }
    }
}
