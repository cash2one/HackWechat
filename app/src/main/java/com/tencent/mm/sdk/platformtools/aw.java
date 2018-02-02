package com.tencent.mm.sdk.platformtools;

import android.os.Environment;
import android.os.StatFs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class aw {
    static String[] xhJ = new String[]{"sysfs", "rootfs", "binfmt_misc", "anon_inodefs", "bdev", "proc", "cgroup", "tmpfs", "debugfs", "sockfs", "pipefs", "rpc_pipefs", "devpts", "ramfs", "fuseblk", "fusectl", "selinuxfs"};
    static String[] xhK = new String[]{"vfat", "exfat", "fuse", "sdcardfs"};
    static String[] xhL = new String[]{"/mnt/secure", "/mnt/asec", "/mnt/obb", "/dev/mapper", "/data/"};
    static String[] xhM = new String[]{"/dev/block/vold"};

    public static class a {
        public boolean bpI;
        public String xhN;
        public String xhO;
        public String xhP;
        public long xhQ;
        public long xhR;
        public long xhS;
        public long xhT;
        a xhU;

        public final String toString() {
            return "{DevName=" + this.xhN + ", MountDir=" + this.xhO + ", FileSystem=" + this.xhP + ", TotalBlocks=" + this.xhQ + ", FreeBlocks=" + this.xhR + ", AvailableBlocks=" + this.xhS + ", BlockSize=" + this.xhT + ", Shared=" + (this.xhU != null) + "}";
        }

        public final boolean equals(Object obj) {
            a aVar = (a) obj;
            if (this.xhT != aVar.xhT) {
                return false;
            }
            long j = this.xhQ - aVar.xhQ;
            long j2 = this.xhR - aVar.xhR;
            long j3 = this.xhS - aVar.xhS;
            if (Math.abs(j - j2) > 4 || Math.abs(j - j3) > 4 || Math.abs(j2 - j3) > 4) {
                return false;
            }
            return true;
        }
    }

    private static ArrayList<a> cfY() {
        Throwable e;
        Exception e2;
        ArrayList<a> arrayList = new ArrayList();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        String[] split = readLine.split("\\s+");
                        if (split == null || split.length < 3) {
                            x.e("MicroMsg.SdcardUtil", "splite failed for line: " + readLine);
                        } else {
                            a aVar = new a();
                            aVar.xhN = split[0];
                            aVar.xhO = split[1];
                            aVar.xhP = split[2];
                            arrayList.add(aVar);
                        }
                    } else {
                        try {
                            break;
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                }
            }
            bufferedReader.close();
        } catch (Exception e5) {
            e2 = e5;
            bufferedReader = null;
            try {
                x.e("MicroMsg.SdcardUtil", "parseProcMounts", e2);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e32) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                    }
                }
                return arrayList;
            } catch (Throwable th) {
                e32 = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable e6) {
                        x.printErrStackTrace("MicroMsg.SdcardUtil", e6, "", new Object[0]);
                    }
                }
                throw e32;
            }
        } catch (Throwable th2) {
            e32 = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e32;
        }
        return arrayList;
    }

    private static void a(a aVar) {
        try {
            StatFs statFs = new StatFs(aVar.xhO);
            aVar.xhT = (long) statFs.getBlockSize();
            aVar.xhS = (long) statFs.getAvailableBlocks();
            aVar.xhQ = (long) statFs.getBlockCount();
            aVar.xhR = (long) statFs.getFreeBlocks();
        } catch (IllegalArgumentException e) {
            x.e("MicroMsg.SdcardUtil", "statFsForStatMountParse", e);
        }
    }

    private static boolean b(a aVar) {
        FileOutputStream fileOutputStream;
        boolean delete;
        IOException e;
        Throwable e2;
        File file = new File(aVar.xhO, "test_writable");
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                delete = file.delete();
                try {
                    fileOutputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SdcardUtil", e3, "", new Object[0]);
                }
            } catch (IOException e4) {
                e = e4;
                try {
                    x.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.xhO);
                    if (fileOutputStream == null) {
                        delete = false;
                    } else {
                        try {
                            fileOutputStream.close();
                            delete = false;
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.SdcardUtil", e22, "", new Object[0]);
                            delete = false;
                        }
                    }
                    aVar.bpI = delete;
                    return delete;
                } catch (Throwable th) {
                    e22 = th;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e32) {
                            x.printErrStackTrace("MicroMsg.SdcardUtil", e32, "", new Object[0]);
                        }
                    }
                    throw e22;
                }
            }
        } catch (IOException e5) {
            e = e5;
            fileOutputStream = null;
            x.e("MicroMsg.SdcardUtil", "createNewFile: " + e.getMessage() + " dir: " + aVar.xhO);
            if (fileOutputStream == null) {
                fileOutputStream.close();
                delete = false;
            } else {
                delete = false;
            }
            aVar.bpI = delete;
            return delete;
        } catch (Throwable th2) {
            e22 = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e22;
        }
        aVar.bpI = delete;
        return delete;
    }

    private static a cfZ() {
        a aVar;
        ArrayList cfY = cfY();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        Iterator it = cfY.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xhO.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xhO = absolutePath;
            aVar.xhN = "Unknown";
            aVar.xhP = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    private static a cga() {
        a aVar;
        ArrayList cfY = cfY();
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = cfY.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.xhO.equals(absolutePath)) {
                break;
            }
        }
        aVar = null;
        if (aVar == null) {
            aVar = new a();
            aVar.xhO = absolutePath;
            aVar.xhN = "Unknown";
            aVar.xhP = "Unknown";
        }
        a(aVar);
        return aVar;
    }

    public static ArrayList<a> cgb() {
        int i;
        int size;
        ArrayList<a> cfY = cfY();
        int size2 = cfY.size();
        List asList = Arrays.asList(xhK);
        List<String> asList2 = Arrays.asList(xhL);
        List<String> asList3 = Arrays.asList(xhM);
        for (int i2 = size2 - 1; i2 >= 0; i2--) {
            a aVar = (a) cfY.get(i2);
            if (asList.contains(aVar.xhP)) {
                i = 0;
                for (String startsWith : asList2) {
                    i = aVar.xhO.startsWith(startsWith) | i;
                }
                if (i != 0) {
                    cfY.remove(i2);
                    x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir1: " + aVar.xhO);
                } else if (aVar.xhP.equals("fuse") || aVar.xhP.equals("sdcardfs")) {
                    if (aVar.xhN.startsWith("/data/")) {
                        cfY.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad mount dir2: " + aVar.xhN);
                    }
                } else if (!(aVar.xhP.equals("fuse") || aVar.xhP.equals("sdcardfs"))) {
                    i = 0;
                    for (String startsWith2 : asList3) {
                        i = aVar.xhN.startsWith(startsWith2) | i;
                    }
                    if (i == 0) {
                        cfY.remove(i2);
                        x.d("MicroMsg.SdcardUtil", "Remove with bad device name: " + aVar.xhN);
                    }
                }
            } else {
                cfY.remove(i2);
                x.d("MicroMsg.SdcardUtil", "Remove with filesystem mismatch: " + aVar.xhP);
            }
        }
        String path = Environment.getExternalStorageDirectory().getPath();
        for (size = cfY.size() - 1; size >= 0; size--) {
            aVar = (a) cfY.get(size);
            if (aVar.xhO.equals(path)) {
                cfY.remove(size);
                cfY.add(0, aVar);
                size2 = 1;
                break;
            }
        }
        size2 = 0;
        if (size2 == 0) {
            aVar = new a();
            aVar.xhO = path;
            aVar.xhP = "unknown";
            aVar.xhN = "unknown";
            cfY.add(0, aVar);
        }
        for (size = cfY.size() - 1; size >= 0; size--) {
            aVar = (a) cfY.get(size);
            File file = new File(aVar.xhO);
            if (!file.exists() || !file.isDirectory()) {
                x.d("MicroMsg.SdcardUtil", "Directory verify failed: " + aVar);
                cfY.remove(size);
            }
        }
        for (size = cfY.size() - 1; size >= 0; size--) {
            aVar = (a) cfY.get(size);
            if (!b(aVar)) {
                x.d("MicroMsg.SdcardUtil", "Directory testPermissionForStatMountParse failed: " + aVar);
                cfY.remove(size);
            }
        }
        ArrayList arrayList = new ArrayList();
        while (!cfY.isEmpty()) {
            i = cfY.size() - 1;
            a aVar2 = (a) cfY.remove(0);
            while (i >= 0) {
                aVar = (a) cfY.get(i);
                if (aVar2.xhN.equals(aVar.xhN)) {
                    cfY.remove(i);
                    x.d("MicroMsg.SdcardUtil", "Duplicate with same DevName:" + aVar2.xhN);
                    if (!aVar2.bpI && aVar.bpI) {
                        x.d("MicroMsg.SdcardUtil", "Keep the writable one, discard the unwritable one");
                        i--;
                        aVar2 = aVar;
                    }
                }
                aVar = aVar2;
                i--;
                aVar2 = aVar;
            }
            arrayList.add(aVar2);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((a) it.next());
        }
        cfY.clear();
        while (!arrayList.isEmpty()) {
            aVar2 = (a) arrayList.remove(0);
            cfY.add(aVar2);
            for (i = arrayList.size() - 1; i >= 0; i--) {
                aVar = (a) arrayList.get(i);
                if (aVar2.equals(aVar)) {
                    x.d("MicroMsg.SdcardUtil", "Duplicate:" + aVar2.toString() + "---" + aVar.toString());
                    arrayList.remove(i);
                }
            }
        }
        return cfY;
    }

    public static long cgc() {
        a cfZ = cfZ();
        return cfZ.xhT * cfZ.xhS;
    }

    public static long cgd() {
        a cga = cga();
        return cga.xhT * cga.xhS;
    }

    public static boolean cge() {
        a aVar;
        boolean z;
        a aVar2 = null;
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList cfY = cfY();
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        String absolutePath2 = Environment.getExternalStorageDirectory().getAbsolutePath();
        Iterator it = cfY.iterator();
        a aVar3 = null;
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar3 == null && aVar.xhO.equals(absolutePath)) {
                if (aVar2 != null) {
                    aVar3 = aVar;
                    break;
                }
                aVar3 = aVar;
            } else {
                if (aVar2 == null && aVar.xhO.equals(absolutePath2)) {
                    if (aVar3 != null) {
                        aVar2 = aVar;
                        break;
                    }
                }
                aVar = aVar2;
                aVar2 = aVar;
            }
        }
        if (aVar3 != null && aVar2 == null && !bh.ov(absolutePath2) && absolutePath2.contains("emulated")) {
            String substring = absolutePath2.substring(absolutePath2.lastIndexOf(47) + 1);
            x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage multiuser uid[%s][%d]", substring, Integer.valueOf(bh.getInt(substring, -1)));
            if (bh.getInt(substring, -1) != -1) {
                absolutePath = absolutePath2.substring(0, (absolutePath2.length() - substring.length()) - 1);
                if (!bh.ov(absolutePath)) {
                    Iterator it2 = cfY.iterator();
                    while (it2.hasNext()) {
                        aVar = (a) it2.next();
                        if (aVar.xhO.equals(absolutePath)) {
                            break;
                        }
                    }
                }
            }
        }
        aVar = aVar2;
        if (!(aVar3 == null || aVar == null)) {
            a(aVar3);
            a(aVar);
            x.d("MicroMsg.SdcardUtil", "hasUnRemovableStorage stats dataStatMountParse[%s] storageStatMountParse[%s]", aVar3, aVar);
            if ((aVar.xhP.equals("fuse") || aVar.xhP.equals("sdcardfs") || aVar.xhP.equals("esdfs")) && aVar3.xhQ >= aVar.xhQ && aVar.xhQ > 0 && aVar3.xhT >= aVar.xhT && aVar.xhT > 0 && aVar3.xhS >= aVar.xhS) {
                z = true;
                x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return z;
            }
        }
        z = false;
        x.i("MicroMsg.SdcardUtil", "hasUnRemovableStorage ret[%b], take[%d]ms", Boolean.valueOf(z), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return z;
    }

    public static String Vn(String str) {
        String str2 = "";
        if (bh.ov(str)) {
            return str2;
        }
        ArrayList cfY = cfY();
        Iterator it = cfY.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (str.equals(aVar.xhO)) {
                str2 = aVar.xhP;
                break;
            }
        }
        x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] is [%s]", str, str2);
        if (!bh.ov(str2) || !str.contains("emulated")) {
            return str2;
        }
        String substring = str.substring(str.lastIndexOf(47) + 1);
        x.i("MicroMsg.SdcardUtil", "getFileSystem multiuser uid[%s][%d]", substring, Integer.valueOf(bh.getInt(substring, -1)));
        if (bh.getInt(substring, -1) == -1) {
            return str2;
        }
        String substring2 = str.substring(0, (str.length() - substring.length()) - 1);
        if (bh.ov(substring2)) {
            return str2;
        }
        Iterator it2 = cfY.iterator();
        while (it2.hasNext()) {
            aVar = (a) it2.next();
            if (substring2.equals(aVar.xhO)) {
                x.i("MicroMsg.SdcardUtil", "getFileSystem[%s] fix[%s] is [%s]", str, substring2, aVar.xhP);
                return aVar.xhP;
            }
        }
        return str2;
    }
}
