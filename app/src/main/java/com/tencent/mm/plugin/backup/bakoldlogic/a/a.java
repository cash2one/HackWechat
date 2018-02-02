package com.tencent.mm.plugin.backup.bakoldlogic.a;

import android.os.StatFs;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.protocal.c.bdp;
import com.tencent.mm.protocal.c.er;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static List<String> kiU = null;

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

    public static String vn(String str) {
        if (str == null) {
            return "";
        }
        String s = g.s(str.getBytes());
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

    public static String aqi() {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        return stringBuilder.append(c.FC()).append("backup/").toString();
    }

    public static void vz(String str) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupItem/");
        if (!file.exists()) {
            file.mkdirs();
        }
        file = new File(str + "backupMeida/");
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(long j, PLong pLong, PLong pLong2, String str) {
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        x.i("MicroMsg.BakUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", new Object[]{Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(j)});
        if (blockCount <= 0) {
            return false;
        }
        if (blockCount - availableBlocks < 0) {
            return false;
        }
        if (pLong.value != pLong2.value) {
        }
        pLong.value = 0;
        if (j > pLong2.value) {
            return false;
        }
        return true;
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

    public static String vA(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return aqi() + "backupMeida/" + vn(str) + str;
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
                    return e.bN(vA(((bdo) erVar.vKd.get(i2)).wJF));
                }
                i2++;
            }
            return 0;
        }
    }

    public static String a(er erVar, int i, String str) {
        if (erVar.vKh == i && erVar.vKf != null) {
            return g.s(erVar.vKf.wJD.oz);
        }
        if (!(erVar.vKe == null || erVar.vKd == null)) {
            Iterator it = erVar.vKe.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                if (((bdp) it.next()).wJH == i) {
                    String str2 = ((bdo) erVar.vKd.get(i2)).wJF;
                    if (!bh.ov(str) && !str2.endsWith(str)) {
                        i2 = (i2 + 1) + 1;
                    } else if (e.bO(vA(str2))) {
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

    public static String a(er erVar, int i) {
        return a(erVar, i, null);
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
                    String vA = vA(((bdo) erVar.vKd.get(i2)).wJF);
                    i2 = e.bN(vA);
                    if (i2 != 0 && i2 <= 1048576) {
                        return e.e(vA, 0, -1);
                    }
                    x.e("MicroMsg.BakUtil", "thumb not exist or  too big!");
                    return null;
                }
                i2++;
            }
        }
        return null;
    }

    public static boolean b(er erVar, int i, String str) {
        if (erVar.vKh != i || erVar.vKf == null) {
            String a = a(erVar, i, null);
            if (bh.ov(a)) {
                return false;
            }
            k.q(vA(a), str, false);
            return true;
        }
        byte[] bArr = erVar.vKf.wJD.oz;
        if (bArr.length <= 0) {
            return false;
        }
        e.b(str, bArr, bArr.length);
        return true;
    }

    public static int aQ(String str, int i) {
        if (!bh.ov(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BakUtil", e, "", new Object[0]);
            }
        }
        return i;
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
}
