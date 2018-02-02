package com.tencent.mm.plugin.appbrand.appstorage;

import android.annotation.TargetApi;
import android.support.annotation.Keep;
import android.system.Os;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.j.d;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;

@Keep
public final class AppBrandLocalMediaObjectManager {
    private static final Collection<a> MEDIA_OBJECT_INFO_HANDLERS;
    private static final AppBrandLocalMediaObject Nil = new 3();
    public static final String OBJECT_NAME_PREFIX = "wxfile://";
    static final String OBJECT_ROOT_DIR_PATH;
    static final String PREFIX_STORE_FILE = "store_";
    static final String PREFIX_TEMP_FILE = "tmp_";
    static final String SUFFIX_PERMANENT_FILE = ".dat";
    static final String SUFFIX_TEMP_FILE = ".tmp";
    private static final String TAG = "MicroMsg.AppBrand.LocalMediaObjectManager";

    private interface a {
        AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject);

        AppBrandLocalMediaObject aN(String str, String str2);

        AppBrandLocalMediaObject aO(String str, String str2);

        com.tencent.mm.vending.j.a x(String str, String str2, String str3);
    }

    private static final class c implements a {
        private c() {
        }

        public final String toString() {
            return "V2MediaObjectInfoHandler";
        }

        public final AppBrandLocalMediaObject aN(String str, String str2) {
            String str3 = null;
            if (!str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) && !str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE)) {
                return str3;
            }
            String SX = s.SX(str2);
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            if (!bh.ov(SX)) {
                replaceFirst = replaceFirst.replaceFirst("." + SX, "");
            }
            if (bh.ov(replaceFirst)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                str3 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObject, decrypt exp ", new Object[0]);
            }
            if (bh.ov(str3)) {
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, get empty decrypted string");
                return AppBrandLocalMediaObjectManager.Nil;
            }
            String[] split = str3.split("\\|");
            if (split == null || split.length != 2) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            str3 = str2.startsWith(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE) ? AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE : AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE;
            String str4 = AppBrandLocalMediaObjectManager.getParentDir(str) + str3 + replaceFirst;
            long j = bh.getLong(split[0], 0);
            String str5 = split[1];
            if (!str5.equalsIgnoreCase(SX)) {
                return AppBrandLocalMediaObjectManager.Nil;
            }
            try {
                if (j != AppBrandLocalMediaObjectManager.getCRC(str4)) {
                    x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, exactCRC32(%d) != fileCRC32(%d), localId(%s), appId(%s)", new Object[]{Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(str4)), Long.valueOf(j), str2, str});
                    return AppBrandLocalMediaObjectManager.Nil;
                }
                AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
                appBrandLocalMediaObject.fus = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).toString();
                appBrandLocalMediaObject.hhZ = str4;
                appBrandLocalMediaObject.mimeType = s.SV(str5);
                appBrandLocalMediaObject.iHG = str3.equalsIgnoreCase(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
                File file = new File(appBrandLocalMediaObject.hhZ);
                appBrandLocalMediaObject.iHH = file.lastModified();
                appBrandLocalMediaObject.ieE = file.length();
                return appBrandLocalMediaObject;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "retrieveMediaObject, getCRC exp = %s", new Object[]{bh.i(e2)});
                return AppBrandLocalMediaObjectManager.Nil;
            }
        }

        public final AppBrandLocalMediaObject a(AppBrandLocalMediaObject appBrandLocalMediaObject) {
            if (appBrandLocalMediaObject == null) {
                return null;
            }
            String replaceFirst = appBrandLocalMediaObject.hhZ.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            if (!i.aP(appBrandLocalMediaObject.hhZ, replaceFirst)) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject2.hhZ = replaceFirst;
            appBrandLocalMediaObject2.fus = appBrandLocalMediaObject.fus.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE);
            appBrandLocalMediaObject2.ieE = appBrandLocalMediaObject.ieE;
            appBrandLocalMediaObject2.iHF = appBrandLocalMediaObject.iHF;
            appBrandLocalMediaObject2.iHH = new File(appBrandLocalMediaObject2.hhZ).lastModified();
            appBrandLocalMediaObject2.mimeType = appBrandLocalMediaObject.mimeType;
            appBrandLocalMediaObject2.iHG = true;
            return appBrandLocalMediaObject2;
        }

        public final com.tencent.mm.vending.j.a x(String str, String str2, String str3) {
            String az = bh.az(str3, "unknown");
            try {
                String access$600;
                Long valueOf = Long.valueOf(AppBrandLocalMediaObjectManager.getCRC(str2));
                try {
                    access$600 = AppBrandLocalMediaObjectManager.encrypt(String.format(Locale.US, "%d|%s", new Object[]{valueOf, az}), str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "attachMediaObject, enc exp = ", new Object[0]);
                    access$600 = null;
                }
                if (bh.ov(access$600)) {
                    return null;
                }
                access$600 = new StringBuilder(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE).append(access$600).toString();
                String str4 = AppBrandLocalMediaObjectManager.getParentDir(str) + access$600;
                String stringBuilder = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(access$600).append(bh.ov(az) ? "" : "." + az).toString();
                x.d("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, return localId = %s, filePath = %s", new Object[]{stringBuilder, str4});
                com.tencent.mm.vending.j.a dVar = new d();
                dVar.zDa = new Object[]{stringBuilder, str4, az};
                return (d) dVar;
            } catch (Throwable e2) {
                x.e("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", "attachMediaObject, get crc exp = %s", new Object[]{bh.i(e2)});
                return null;
            }
        }

        public final AppBrandLocalMediaObject aO(String str, String str2) {
            String access$300;
            String replaceFirst = str2.replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_STORE_FILE, "").replaceFirst(AppBrandLocalMediaObjectManager.PREFIX_TEMP_FILE, "");
            try {
                access$300 = AppBrandLocalMediaObjectManager.decrypt(replaceFirst, str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.LocalMediaObjectManager.V2Handler", e, "retrieveMediaObjectByRealFileName, dec exp = ", new Object[0]);
                access$300 = null;
            }
            if (bh.ov(access$300)) {
                return null;
            }
            String[] split = access$300.split("\\|");
            if (split == null || split.length != 2) {
                return null;
            }
            access$300 = split[1];
            access$300 = new StringBuilder(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX).append(str2).append(bh.ov(access$300) ? "" : "." + access$300).toString();
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.fus = access$300;
            appBrandLocalMediaObject.hhZ = AppBrandLocalMediaObjectManager.getParentDir(str) + str2;
            appBrandLocalMediaObject.iHF = replaceFirst;
            appBrandLocalMediaObject.iHG = true;
            File file = new File(appBrandLocalMediaObject.hhZ);
            appBrandLocalMediaObject.iHH = file.lastModified();
            appBrandLocalMediaObject.ieE = file.length();
            return appBrandLocalMediaObject;
        }
    }

    private AppBrandLocalMediaObjectManager() {
    }

    static {
        String str = e.bnF;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        OBJECT_ROOT_DIR_PATH = str + "wxafiles/";
        Collection linkedList = new LinkedList();
        linkedList.add(new c());
        MEDIA_OBJECT_INFO_HANDLERS = Collections.unmodifiableCollection(linkedList);
    }

    @Keep
    public static String genMediaFilePath(String str, String str2) {
        if (bh.ov(str) || bh.ov(str2)) {
            return null;
        }
        return getParentDir(str) + str2;
    }

    @TargetApi(21)
    private static void symlinkOs(String str, String str2) {
        b bVar = new b((byte) 0);
        Os.symlink(str, str2);
    }

    private static boolean createLocalFileLink(boolean z, String str, String str2) {
        if (z && i.aP(str, str2)) {
            return true;
        }
        if (z || !k.fp(str, str2)) {
            return false;
        }
        return true;
    }

    public static void clear(String str) {
        if (!bh.ov(str)) {
            com.tencent.mm.a.e.bP(getParentDirWithoutCheckExistence(str));
        }
    }

    public static List<AppBrandLocalMediaObject> listStoredFiles(String str) {
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles == null || listStoredRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listStoredRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    private static File[] listStoredRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new 1());
        }
        return null;
    }

    private static File[] listTmpRawFiles(String str) {
        File file = new File(getParentDir(str));
        if (file.exists() && file.isDirectory()) {
            return file.listFiles(new 2());
        }
        return null;
    }

    public static List<AppBrandLocalMediaObject> listTmpFiles(String str) {
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles == null || listTmpRawFiles.length <= 0) {
            return null;
        }
        List<AppBrandLocalMediaObject> linkedList = new LinkedList();
        for (File name : listTmpRawFiles) {
            AppBrandLocalMediaObject infoByRealFileName = getInfoByRealFileName(str, name.getName());
            if (infoByRealFileName != null) {
                linkedList.add(infoByRealFileName);
            }
        }
        return linkedList;
    }

    public static long getTmpFilesOccupation(String str) {
        long j = 0;
        File[] listTmpRawFiles = listTmpRawFiles(str);
        if (listTmpRawFiles != null && listTmpRawFiles.length > 0) {
            int i = 0;
            while (i < listTmpRawFiles.length) {
                long length = listTmpRawFiles[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static long getStoredFilesOccupation(String str) {
        long j = 0;
        File[] listStoredRawFiles = listStoredRawFiles(str);
        if (listStoredRawFiles != null && listStoredRawFiles.length > 0) {
            int i = 0;
            while (i < listStoredRawFiles.length) {
                long length = listStoredRawFiles[i].length() + j;
                i++;
                j = length;
            }
        }
        return j;
    }

    public static AppBrandLocalVideoObject attachVideo(String str, String str2) {
        return (AppBrandLocalVideoObject) attachCast(str, str2, AppBrandLocalVideoObject.class, "mp4", false);
    }

    private static <T extends AppBrandLocalMediaObject> T attachCast(String str, String str2, Class<T> cls, String str3, boolean z) {
        if (bh.ov(str) || !com.tencent.mm.a.e.bO(str2)) {
            return null;
        }
        String nilAs = nilAs(s.SX(str2), str3);
        com.tencent.mm.vending.j.a aVar = null;
        for (a x : MEDIA_OBJECT_INFO_HANDLERS) {
            aVar = x.x(str, str2, nilAs);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.vending.j.a aVar2 = aVar;
        if (aVar2 == null || aVar2.size() < 2) {
            String str4 = TAG;
            nilAs = "attachCast, no handler return correct info, attach.size = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(aVar2 == null ? -1 : aVar2.size());
            x.e(str4, nilAs, objArr);
            return null;
        }
        try {
            T t = (AppBrandLocalMediaObject) cls.newInstance();
            t.fus = (String) aVar2.get(0);
            t.mimeType = s.SV(nilAs);
            t.hhZ = (String) aVar2.get(1);
            if (bh.ov(t.hhZ)) {
                x.e(TAG, "attachCast appId %s, Null Or Nil fileFullPath");
                return null;
            }
            t.iHF = bh.az((String) aVar2.get(3), bh.az(nilAs, "unknown"));
            if (!createLocalFileLink(z, str2, t.hhZ)) {
                return null;
            }
            File file = new File(t.hhZ);
            t.ieE = file.length();
            t.iHH = file.lastModified();
            return t;
        } catch (Throwable e) {
            x.printErrStackTrace(TAG, e, "", new Object[0]);
            return null;
        }
    }

    private static String nilAs(String str, String str2) {
        return bh.ov(str) ? str2 : str;
    }

    public static AppBrandLocalMediaObject attach(String str, String str2) {
        return attach(str, str2, null, false);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, boolean z) {
        return attach(str, str2, null, z);
    }

    public static AppBrandLocalMediaObject attach(String str, String str2, String str3, boolean z) {
        return attachCast(str, str2, AppBrandLocalMediaObject.class, str3, z);
    }

    private static String getParentDirWithoutCheckExistence(String str) {
        return OBJECT_ROOT_DIR_PATH + str + "/";
    }

    private static String getParentDir(String str) {
        String parentDirWithoutCheckExistence = getParentDirWithoutCheckExistence(str);
        i.Qu(parentDirWithoutCheckExistence);
        try {
            new File(parentDirWithoutCheckExistence, ".nomedia").createNewFile();
        } catch (Exception e) {
        }
        return parentDirWithoutCheckExistence;
    }

    private static String encrypt(String str, String str2) {
        return bh.by(new com.tencent.mm.platformtools.s().encrypt(str.getBytes(), str2.getBytes()));
    }

    private static String decrypt(String str, String str2) {
        byte[] VD = bh.VD(str);
        com.tencent.mm.platformtools.s sVar = new com.tencent.mm.platformtools.s();
        byte[] bytes = str2.getBytes();
        int length = VD.length;
        sVar.preCrypt = 0;
        sVar.crypt = 0;
        sVar.key = bytes;
        bytes = new byte[8];
        if (length % 8 != 0 || length < 16) {
            bytes = null;
        } else {
            sVar.prePlain = sVar.decipher(VD, 0);
            if (sVar.prePlain == null) {
                bytes = null;
            } else {
                sVar.pos = sVar.prePlain[0] & 7;
                int i = (length - sVar.pos) - 10;
                if (i < 0) {
                    bytes = null;
                } else {
                    for (int i2 = 0; i2 < 8; i2++) {
                        bytes[i2] = (byte) 0;
                    }
                    sVar.out = new byte[i];
                    sVar.preCrypt = 0;
                    sVar.crypt = 8;
                    sVar.contextStart = 8;
                    sVar.pos++;
                    sVar.padding = 1;
                    while (sVar.padding <= 2) {
                        if (sVar.pos < 8) {
                            sVar.pos++;
                            sVar.padding++;
                        }
                        if (sVar.pos == 8) {
                            if (!sVar.decrypt8Bytes(VD, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = VD;
                        }
                    }
                    byte[] bArr = bytes;
                    int i3 = 0;
                    while (i != 0) {
                        if (sVar.pos < 8) {
                            sVar.out[i3] = (byte) (bArr[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]);
                            i3++;
                            i--;
                            sVar.pos++;
                        }
                        if (sVar.pos == 8) {
                            sVar.preCrypt = sVar.crypt - 8;
                            if (!sVar.decrypt8Bytes(VD, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bArr = VD;
                        }
                    }
                    sVar.padding = 1;
                    bytes = bArr;
                    while (sVar.padding < 8) {
                        if (sVar.pos < 8) {
                            if ((bytes[(sVar.preCrypt + 0) + sVar.pos] ^ sVar.prePlain[sVar.pos]) != 0) {
                                bytes = null;
                                break;
                            }
                            sVar.pos++;
                        }
                        if (sVar.pos == 8) {
                            sVar.preCrypt = sVar.crypt;
                            if (!sVar.decrypt8Bytes(VD, 0, length)) {
                                bytes = null;
                                break;
                            }
                            bytes = VD;
                        }
                        sVar.padding++;
                    }
                    bytes = sVar.out;
                }
            }
        }
        if (bh.ov(str)) {
            return null;
        }
        return new String(bytes);
    }

    public static AppBrandLocalMediaObject markPermanent(String str, AppBrandLocalMediaObject appBrandLocalMediaObject) {
        AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
        for (a a : MEDIA_OBJECT_INFO_HANDLERS) {
            appBrandLocalMediaObject2 = a.a(appBrandLocalMediaObject);
            if (appBrandLocalMediaObject2 != null) {
                break;
            }
        }
        return appBrandLocalMediaObject2;
    }

    private static AppBrandLocalMediaObject getInfoByRealFileName(String str, String str2) {
        AppBrandLocalMediaObject appBrandLocalMediaObject = null;
        if (!bh.ov(str) && !bh.ov(str2)) {
            for (a aO : MEDIA_OBJECT_INFO_HANDLERS) {
                appBrandLocalMediaObject = aO.aO(str, str2);
                if (appBrandLocalMediaObject != null) {
                    break;
                }
            }
        }
        return appBrandLocalMediaObject;
    }

    @Deprecated
    public static AppBrandLocalMediaObject getItemByLocalId(String str, String str2) {
        if (bh.ov(str2) || !str2.startsWith(OBJECT_NAME_PREFIX) || bh.ov(str)) {
            x.e(TAG, "getItemByLocalId, invalid args, localId(%s), appId(%s) ", new Object[]{str2, str});
            return null;
        } else if (str2.startsWith("wxfile://usr")) {
            File pQ = new e(o.getString(((com.tencent.mm.plugin.appbrand.appstorage.a.a) g.h(com.tencent.mm.plugin.appbrand.appstorage.a.a.class)).pY(str)), str).pQ(str2);
            if (pQ == null || !pQ.exists() || !pQ.isFile()) {
                return null;
            }
            AppBrandLocalMediaObject appBrandLocalMediaObject = new AppBrandLocalMediaObject();
            appBrandLocalMediaObject.fus = str2;
            appBrandLocalMediaObject.hhZ = pQ.getAbsolutePath();
            appBrandLocalMediaObject.mimeType = s.SW(str2);
            appBrandLocalMediaObject.iHG = true;
            appBrandLocalMediaObject.ieE = pQ.length();
            appBrandLocalMediaObject.iHH = pQ.lastModified();
            return appBrandLocalMediaObject;
        } else {
            AppBrandLocalMediaObject aN;
            String substring = str2.substring(9);
            AppBrandLocalMediaObject appBrandLocalMediaObject2 = null;
            for (a aN2 : MEDIA_OBJECT_INFO_HANDLERS) {
                aN = aN2.aN(str, substring);
                if (aN != null) {
                    x.i(TAG, "getItemByLocalId, handled by %s, result = %s", new Object[]{aN2.toString(), aN});
                    break;
                }
                appBrandLocalMediaObject2 = aN;
            }
            aN = appBrandLocalMediaObject2;
            if (Nil != aN) {
                return aN;
            }
            return null;
        }
    }

    @Keep
    @Deprecated
    public static String getFilePathByLocalId(String str, String str2) {
        AppBrandLocalMediaObject itemByLocalId = getItemByLocalId(str, str2);
        return itemByLocalId == null ? null : itemByLocalId.hhZ;
    }

    private static long getCRC(String str) {
        Closeable fileInputStream = new FileInputStream(str);
        Closeable checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        do {
        } while (checkedInputStream.read(new byte[2048]) >= 0);
        long value = checkedInputStream.getChecksum().getValue();
        bh.d(checkedInputStream);
        bh.d(fileInputStream);
        return value;
    }
}
