package com.tencent.mm.plugin.backup.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.n;
import com.tencent.mm.bq.a;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.backup.a.f.b;
import com.tencent.mm.plugin.backup.h.m;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.conn.util.InetAddressUtils;

public final class g {
    private static List<String> kiU = null;

    public static <T extends a> T a(T t, byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        try {
            t.aF(bArr);
            return t;
        } catch (Throwable e) {
            x.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", new Object[]{e.getMessage(), bh.i(e)});
            return null;
        }
    }

    public static void a(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        Throwable e;
        RandomAccessFile randomAccessFile = null;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            String str2 = str + xVar.ktR;
            File file2 = new File(str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) xVar.ktT);
                randomAccessFile2.seek((long) xVar.ktU);
                randomAccessFile2.write(xVar.ksB.oz);
                try {
                    randomAccessFile2.close();
                } catch (Exception e2) {
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e;
            }
        } catch (Exception e6) {
            e = e6;
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    public static long vk(String str) {
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        if (!file.canRead()) {
            return -2;
        }
        if (file.canWrite()) {
            return file.length();
        }
        return -3;
    }

    public static void b(String str, com.tencent.mm.plugin.backup.h.x xVar) {
        if (TextUtils.isEmpty(str) || xVar == null) {
            x.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", new Object[]{str, xVar});
        } else if (TextUtils.isEmpty(xVar.ktR) || xVar.ksB == null || bh.bx(xVar.ksB.oz) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = xVar.ktR;
            objArr[1] = xVar.ksB;
            if (xVar.ksB == null) {
                str2 = "null";
            } else {
                str2 = Integer.valueOf(bh.bx(xVar.ksB.oz));
            }
            objArr[2] = str2;
            x.e(str3, str4, objArr);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long vk = vk(str + xVar.ktR);
                    File file = new File(str + xVar.ktR);
                    long length = file.exists() ? file.length() : 0;
                    int a = e.a(str, xVar.ktR, xVar.ksB.oz);
                    File file2 = new File(str + xVar.ktR);
                    if (length == (file2.exists() ? file2.length() : 0)) {
                        x.e("MicroMsg.BackupUtil", "append failed and try again:%s", new Object[]{str + xVar.ktR});
                        i = e.a(str, xVar.ktR, xVar.ksB.oz) * 10000;
                    } else {
                        i = a;
                    }
                    long vk2 = vk(str + xVar.ktR);
                    if (i != 0 || vk2 < ((long) xVar.ksB.oz.length)) {
                        x.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vk), Long.valueOf(vk2), Integer.valueOf(xVar.ksB.oz.length)});
                        i = i2;
                    } else {
                        x.d("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(vk), Long.valueOf(vk2), Integer.valueOf(xVar.ksB.oz.length)});
                        return;
                    }
                }
                return;
            }
        }
    }

    public static String cl(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            String ssid;
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                try {
                    ssid = connectionInfo.getSSID();
                } catch (Throwable e) {
                    x.e("MicroMsg.BackupUtil", "getConnectionInfo %s", new Object[]{e});
                    x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                    return "";
                }
            }
            ssid = "wifi";
            return (ssid.length() >= 2 && ssid.startsWith("\"") && ssid.endsWith("\"")) ? ssid.substring(1, ssid.length() - 1) : ssid;
        } else {
            int intValue;
            int i = 13;
            try {
                i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
                intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Throwable e2) {
                x.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e2});
                x.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
                intValue = 0;
            }
            if (intValue == i) {
                x.i("MicroMsg.BackupUtil", "getWifiName apmode");
                try {
                    return ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                } catch (Throwable e3) {
                    x.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", new Object[]{e3});
                    x.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
                }
            }
            return "";
        }
    }

    public static String aov() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("backupRecover/").toString();
    }

    public static String vl(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aov() + "backupItem/" + vn(str);
    }

    public static String vm(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aov() + "backupMeida/" + vn(str);
    }

    private static String vn(String str) {
        if (str == null) {
            return "";
        }
        String s = com.tencent.mm.a.g.s(str.getBytes());
        String str2 = "";
        String str3 = "";
        if (s.length() > 0) {
            str2 = s.charAt(0) + "/";
        }
        if (s.length() >= 2) {
            str3 = s.charAt(1) + "/";
        }
        return str2 + str3;
    }

    public static int aow() {
        Intent registerReceiver = ac.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return 100;
        }
        int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
        boolean z = intExtra == 2 || intExtra == 5;
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", new Object[]{Boolean.valueOf(z)});
        if (z) {
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra("scale", -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        x.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", new Object[]{Integer.valueOf(intExtra)});
        return intExtra;
    }

    public static boolean vo(String str) {
        int ipAddress;
        int intValue;
        Throwable e;
        String[] split = str.split("\\.");
        int u = n.u(new byte[]{(byte) (bh.getInt(split[0], 0) & 255), (byte) (bh.getInt(split[1], 0) & 255), (byte) (bh.getInt(split[2], 0) & 255), (byte) (bh.getInt(split[3], 0) & 255)});
        int u2 = n.u(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) ac.getContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            x.i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", new Object[]{str, str2});
            if ((u2 & u) == (ipAddress & u2)) {
                return true;
            }
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e});
                x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                ipAddress = 0;
                if (ipAddress == intValue) {
                    x.i("MicroMsg.BackupUtil", "matchip in apmode");
                    return ca(u2, u);
                }
                x.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
                return false;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
            x.e("MicroMsg.BackupUtil", "getWifiApState %s", new Object[]{e});
            x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            ipAddress = 0;
            if (ipAddress == intValue) {
                x.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
                return false;
            }
            x.i("MicroMsg.BackupUtil", "matchip in apmode");
            return ca(u2, u);
        }
        if (ipAddress == intValue) {
            x.i("MicroMsg.BackupUtil", "matchip in apmode");
            return ca(u2, u);
        }
        x.i("MicroMsg.BackupUtil", "apState:%d", new Object[]{Integer.valueOf(ipAddress)});
        return false;
    }

    private static boolean ca(int i, int i2) {
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        x.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", new Object[]{toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase))});
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (n.u(new byte[]{(byte) (bh.getInt(split[0], 0) & 255), (byte) (bh.getInt(split[1], 0) & 255), (byte) (bh.getInt(split[2], 0) & 255), (byte) (bh.getInt(split[3], 0) & 255)}) & i)) {
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean vp(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (bi.y(str, "msg") != null) {
            return true;
        }
        return false;
    }

    public static String a(er erVar, int i) {
        return a(erVar, i, null);
    }

    public static String a(er erVar, int i, String str) {
        if (erVar.vKh == i && erVar.vKf != null) {
            return com.tencent.mm.a.g.s(erVar.vKf.wJD.oz);
        }
        if (!(erVar.vKe == null || erVar.vKd == null)) {
            Iterator it = erVar.vKe.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bdp) it.next()).wJH == i) {
                    String str2 = ((bdo) erVar.vKd.get(i2)).wJF;
                    if (!bh.ov(str) && !str2.endsWith(str)) {
                        i2 = (i2 + 1) + 1;
                    } else if (e.bO(vm(str2) + str2)) {
                        return str2;
                    } else {
                        return null;
                    }
                }
                i2++;
            }
        }
        return null;
    }

    public static int aQ(String str, int i) {
        if (!bh.ov(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        return i;
    }

    public static boolean b(er erVar, int i, String str) {
        if (erVar.vKh == i) {
            byte[] bArr = erVar.vKf.wJD.oz;
            if (bArr.length <= 0) {
                return false;
            }
            e.b(str, bArr, bArr.length);
            return true;
        }
        String a = a(erVar, i, null);
        if (bh.ov(a)) {
            return false;
        }
        k.q(vm(a) + a, str, false);
        return true;
    }

    public static byte[] b(er erVar, int i) {
        if (erVar.vKh == i && erVar.vKf != null) {
            return erVar.vKf.wJD.oz;
        }
        if (!(erVar.vKe == null || erVar.vKd == null)) {
            Iterator it = erVar.vKe.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bdp) it.next()).wJH == i) {
                    String str = ((bdo) erVar.vKd.get(i2)).wJF;
                    str = vm(str) + str;
                    i2 = e.bN(str);
                    if (i2 != 0 && i2 <= 1048576) {
                        return e.e(str, 0, -1);
                    }
                    x.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    public static int c(er erVar, int i) {
        if (erVar.vKh == i) {
            if (erVar.vKf == null) {
                return 0;
            }
            return erVar.vKf.wJD.oz.length;
        } else if (erVar.vKe == null || erVar.vKd == null) {
            return 0;
        } else {
            Iterator it = erVar.vKe.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bdp) it.next()).wJH == i) {
                    String str = ((bdo) erVar.vKd.get(i2)).wJF;
                    return e.bN(vm(str) + str);
                }
                i2++;
            }
            return 0;
        }
    }

    public static boolean d(er erVar, int i) {
        if (erVar.vKh == i && erVar.vKf != null) {
            return true;
        }
        Iterator it = erVar.vKe.iterator();
        while (it.hasNext()) {
            if (((bdp) it.next()).wJH == i) {
                return true;
            }
        }
        return false;
    }

    public static List<String> aox() {
        if (kiU != null) {
            return kiU;
        }
        kiU = new LinkedList();
        for (Object add : s.hfr) {
            kiU.add(add);
        }
        kiU.add("weixin");
        kiU.add("weibo");
        kiU.add("qqmail");
        kiU.add("fmessage");
        kiU.add("tmessage");
        kiU.add("qmessage");
        kiU.add("qqsync");
        kiU.add("floatbottle");
        kiU.add("lbsapp");
        kiU.add("shakeapp");
        kiU.add("medianote");
        kiU.add("qqfriend");
        kiU.add("readerapp");
        kiU.add("newsapp");
        kiU.add("blogapp");
        kiU.add("facebookapp");
        kiU.add("masssendapp");
        kiU.add("meishiapp");
        kiU.add("feedsapp");
        kiU.add("voipapp");
        kiU.add("officialaccounts");
        kiU.add("helper_entry");
        kiU.add("pc_share");
        kiU.add("cardpackage");
        kiU.add("voicevoipapp");
        kiU.add("voiceinputapp");
        kiU.add("linkedinplugin");
        kiU.add("appbrandcustomerservicemsg");
        return kiU;
    }

    public static boolean a(PLong pLong, PLong pLong2, String str) {
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        x.i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[]{Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(0)});
        if (blockCount <= 0) {
            return false;
        }
        if (blockCount - availableBlocks < 0) {
            return false;
        }
        if (pLong.value == pLong2.value || str.startsWith(dataDirectory.getPath())) {
            pLong.value = 0;
        }
        if (0 > pLong2.value) {
            return false;
        }
        return true;
    }

    public static long vq(String str) {
        long j = 0;
        try {
            j = new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            x.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", new Object[]{str, bh.cgy()});
        }
        return j;
    }

    public static LinkedList<String> u(LinkedList<b> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((b) it.next()).kiP);
            }
        }
        return linkedList2;
    }

    public static String a(String str, String str2, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals("")) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        return stringBuilder.toString();
    }

    public static String[] bF(String str, String str2) {
        return str.split(str2);
    }

    public static m bH(long j) {
        m mVar = new m();
        String deviceID = q.getDeviceID(ac.getContext());
        if (deviceID == null) {
            deviceID = q.yF();
        }
        mVar.ksX = deviceID;
        mVar.ksY = Build.MANUFACTURER;
        mVar.ksZ = Build.MODEL;
        mVar.kta = "Android";
        mVar.ktb = VERSION.RELEASE;
        mVar.ktc = d.vAz;
        mVar.ktd = j;
        x.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", new Object[]{Integer.valueOf(d.vAz), Long.valueOf(j), mVar.ksX});
        return mVar;
    }
}
