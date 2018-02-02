package com.tencent.mm.kernel;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.a.o;
import com.tencent.mm.by.f;
import com.tencent.mm.by.h;
import com.tencent.mm.by.h.d;
import com.tencent.mm.compatible.d.l;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ag;
import com.tencent.mm.z.by;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import junit.framework.Assert;

public final class e {
    private static HashMap<Integer, d> gwY;
    public String cachePath;
    public final s gQd = CO();
    private com.tencent.mm.kernel.api.e gQe;
    public b gQf = new b();
    b gQg = new b();
    public String gQh;
    public String gQi;
    public h gQj = null;
    public h gQk = null;
    public t gQl;
    be gQm;
    bi gQn;
    ConcurrentHashMap<Integer, String> gQo;
    boolean gQp = false;
    by gQq;
    ConcurrentHashMap<String, SharedPreferences> gQr = new ConcurrentHashMap();
    private long gQs = 0;
    private af gQt = null;
    private volatile Boolean gQu = null;
    private a gQv = new a();
    private long gQw = 0;

    private class a implements Runnable {
        final /* synthetic */ e gQy;

        private a(e eVar) {
            this.gQy = eVar;
        }

        public final void run() {
            this.gQy.CW();
        }
    }

    public static class c {
        public boolean gQA = false;
        public int gQB = 0;
    }

    static class b extends com.tencent.mm.cd.a<com.tencent.mm.by.h.a> implements com.tencent.mm.by.h.a {
        b() {
        }

        public final void Db() {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.by.h.a>(this) {
                final /* synthetic */ b gQz;

                {
                    this.gQz = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.by.h.a) obj).Db();
                }
            });
        }

        public final void Dc() {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.by.h.a>(this) {
                final /* synthetic */ b gQz;

                {
                    this.gQz = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.by.h.a) obj).Dc();
                }
            });
        }

        public final void Dd() {
            a(new com.tencent.mm.cd.a.a<com.tencent.mm.by.h.a>(this) {
                final /* synthetic */ b gQz;

                {
                    this.gQz = r1;
                }

                public final /* synthetic */ void az(Object obj) {
                    ((com.tencent.mm.by.h.a) obj).Dd();
                }
            });
        }
    }

    public e(com.tencent.mm.kernel.api.e eVar) {
        a.gPk.a(this.gQd);
        String str = w.gZK + "alphahold.ini";
        x.i("MMKernel.CoreStorage", "initialize dkalpha client:%x  isapha:%b %s", Integer.valueOf(com.tencent.mm.protocal.d.vAz), Boolean.valueOf(com.tencent.mm.protocal.d.vAC), str);
        if (com.tencent.mm.protocal.d.vAC || com.tencent.mm.protocal.d.vAD) {
            String value = com.tencent.mm.sdk.e.a.getValue(str, "noneedhold");
            int i = com.tencent.mm.protocal.d.vAz;
            try {
                i = Integer.decode(BaseBuildInfo.CLIENT_VERSION).intValue();
            } catch (Throwable th) {
            }
            if (!String.valueOf(i).equals(value)) {
                x.w("MMKernel.CoreStorage", "dkalpha version need  reset to DefaultAccount , hold it! client:%x  isapha:%b", Integer.valueOf(i), Boolean.valueOf(com.tencent.mm.protocal.d.vAC));
                a.Ck();
                com.tencent.mm.sdk.e.a.ag(str, "noneedhold", String.valueOf(i));
            }
        } else {
            com.tencent.mm.loader.stub.b.deleteFile(str);
        }
        this.gQh = CT();
        this.gQe = eVar;
    }

    private static s CO() {
        x.i("MMKernel.CoreStorage", "initialize packageInfo:%s version:%x", com.tencent.mm.sdk.platformtools.e.asP(), Integer.valueOf(com.tencent.mm.protocal.d.vAz));
        File file = new File(w.gZK);
        if (!file.exists()) {
            file.mkdirs();
        }
        s sVar = new s(w.gZK + "systemInfo.cfg");
        String str = (String) sVar.get(258);
        if (str != null) {
            l.yn().set(258, str);
        }
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.h.getDataDirectory().getPath());
            x.i("MMKernel.CoreStorage", "CheckData path[%s] blocksize:%d blockcount:%d availcount:%d", r0.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
        } catch (Exception e) {
            x.e("MMKernel.CoreStorage", "check data size failed :%s", e.getMessage());
        }
        return sVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(ag agVar) {
        int i = 0;
        if (agVar == null) {
            x.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferFactory is null");
            return false;
        }
        int e = bh.e((Integer) this.gQl.get(14, null));
        int i2 = com.tencent.mm.protocal.d.vAz;
        x.d("MMKernel.CoreStorage", "tryDataTransfer, sVer = " + e + ", cVer = " + i2);
        List<com.tencent.mm.z.af> dataTransferList = agVar.getDataTransferList();
        if (dataTransferList == null) {
            x.e("MMKernel.CoreStorage", "tryDataTransfer, dataTransferList is null");
            return false;
        }
        if (r.idl > 0 && r.idm > 0) {
            x.w("MMKernel.CoreStorage", "tryDataTransfer, force data transfer");
        } else if (e == i2) {
            x.i("MMKernel.CoreStorage", "tryDataTransfer, no need to transfer, sVer = " + e + ", cVer = " + i2);
            return false;
        } else {
            boolean z = false;
            for (com.tencent.mm.z.af gN : dataTransferList) {
                z = gN.gN(e);
                if (z) {
                    break;
                }
            }
            x.d("MMKernel.CoreStorage", "tryDataTransfer, needTransfer = " + z);
            if (!z) {
                return false;
            }
        }
        x.d("MMKernel.CoreStorage", "tryDataTransfer dataTransferList size = " + dataTransferList.size());
        x.d("MMKernel.CoreStorage", "tryDataTransfer, threadId = " + Thread.currentThread().getId() + ", name = " + Thread.currentThread().getName());
        long dz = this.gQj.dz(Thread.currentThread().getId());
        for (com.tencent.mm.z.af gN2 : dataTransferList) {
            long currentTimeMillis = System.currentTimeMillis();
            gN2.transfer(e);
            gN2.hfK = System.currentTimeMillis() - currentTimeMillis;
            x.d("MicroMsg.DataTransferBase", "doTransfer, timeConsumed = " + gN2.hfK + ", tag = " + gN2.getTag());
        }
        if (!(r.idl == 0 || r.idm == 0)) {
            while (i < r.idl) {
                try {
                    Thread.sleep((long) r.idm);
                } catch (Throwable e2) {
                    x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e2));
                }
                i++;
            }
        }
        if (dz > 0) {
            this.gQj.fS(dz);
        }
        return true;
    }

    final void CP() {
        com.tencent.mm.kernel.a.c.Dt().fN(this.gQi);
        File file = new File(this.gQi + ".nomedia");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e));
            }
        }
    }

    final void fK(String str) {
        File file = new File(str + "-recovery");
        if (file.isFile()) {
            x.i("MMKernel.CoreStorage", "Recovery database found, replace original one.");
            new File(str + ".ini").delete();
            File file2 = new File(str);
            file2.delete();
            if (!file.renameTo(file2)) {
                x.e("MMKernel.CoreStorage", "Rename database file failed!");
            }
        }
        final String name = file.getName();
        File[] listFiles = file.getParentFile().listFiles(new FilenameFilter(this) {
            final /* synthetic */ e gQy;

            public final boolean accept(File file, String str) {
                return str.startsWith(name) && !str.equals(name);
            }
        });
        if (listFiles != null) {
            for (File file3 : listFiles) {
                x.i("MMKernel.CoreStorage", "Delete temporary recovery database file: " + file3.getName());
                file3.delete();
            }
        }
    }

    public final boolean a(f fVar, HashMap<Integer, d> hashMap) {
        String str = "MMKernel.CoreStorage";
        String str2 = "createtables %d %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(hashMap == null ? -1 : hashMap.size());
        objArr[1] = Boolean.valueOf(false);
        x.i(str, str2, objArr);
        com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
        if (hashMap != null && hashMap.size() > 0) {
            int i = 0;
            for (Entry entry : hashMap.entrySet()) {
                int intValue;
                Integer num = (Integer) entry.getKey();
                d dVar = (d) entry.getValue();
                str = null;
                if (!this.gQp) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (String hashCode : dVar.wg()) {
                        stringBuilder.append(hashCode.hashCode());
                    }
                    String s = g.s(stringBuilder.toString().getBytes());
                    if (this.gQo != null) {
                        str = (String) this.gQo.get(num);
                        x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions", num, str, s);
                        if (str == null || !s.equals(str)) {
                            str = s;
                        }
                    } else {
                        if (this.gQn != null) {
                            com.tencent.mm.storage.bh bhVar = null;
                            Cursor rawQuery = this.gQn.rawQuery("select * from TablesVersion where tableHash = " + num.intValue(), new String[0]);
                            if (rawQuery != null) {
                                if (rawQuery.moveToFirst()) {
                                    bhVar = new com.tencent.mm.storage.bh();
                                    bhVar.b(rawQuery);
                                }
                                rawQuery.close();
                            }
                            Object obj = bhVar == null ? null : bhVar.field_tableSQLMD5;
                            x.d("MMKernel.CoreStorage", "Create tables on %s(%s) compare with %s, using table versions storage", num, obj, s);
                            if (obj != null && s.equals(obj)) {
                            }
                        }
                        str = s;
                    }
                }
                fVar.beginTransaction();
                int i2 = i;
                for (String str3 : dVar.wg()) {
                    try {
                        fVar.execSQL(str3);
                        i2++;
                    } catch (Exception e) {
                        Matcher matcher = com.tencent.mm.by.a.xAJ.matcher(str3);
                        if (matcher == null || !matcher.matches()) {
                            x.w("MMKernel.CoreStorage", "CreateTable failed:[" + str3 + "][" + e.getMessage() + "]");
                        } else {
                            Assert.assertTrue("CreateTable failed:[" + str3 + "][" + e.getMessage() + "]", false);
                        }
                    }
                }
                fVar.endTransaction();
                if (!(this.gQp || this.gQn == null || str == null)) {
                    bi biVar = this.gQn;
                    intValue = num.intValue();
                    Assert.assertTrue(intValue != 0);
                    Assert.assertNotNull(str);
                    com.tencent.mm.storage.bh bhVar2 = new com.tencent.mm.storage.bh();
                    bhVar2.field_tableHash = intValue;
                    bhVar2.field_tableSQLMD5 = str;
                    biVar.hhp.replace("TablesVersion", "tableHash", bhVar2.vI());
                    if (!(this.gQo == null || str == null)) {
                        this.gQo.put(num, str);
                    }
                }
                i = i2;
            }
            x.i("MMKernel.CoreStorage", "createtables end sql:%d trans:%d sqlCount:%d", Long.valueOf(aVar.zi()), Long.valueOf(aVar.zi()), Integer.valueOf(i));
        }
        return true;
    }

    public final String CQ() {
        File file = new File(this.cachePath + "/ctest", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        file = new File(this.cachePath + "/corrupted", "EnMicroMsg.db");
        if (file.isFile()) {
            return file.getAbsolutePath();
        }
        String[] list = new File(this.cachePath).list(new FilenameFilter(this) {
            final /* synthetic */ e gQy;

            {
                this.gQy = r1;
            }

            public final boolean accept(File file, String str) {
                return str.startsWith("EnMicroMsg.dberr");
            }
        });
        if (list == null || list.length <= 0) {
            return null;
        }
        String str = list[0];
        for (int i = 1; i < list.length; i++) {
            String str2 = list[i];
            if (str2.compareTo(str) > 0) {
                str = str2;
            }
        }
        return this.cachePath + '/' + str;
    }

    public final void eb(String str) {
        if (this.gQk != null) {
            this.gQk.ES();
        }
        if (this.gQj != null) {
            this.gQj.eb(str);
        }
        this.gQe.onDataBaseClosed(this.gQj, this.gQk);
        this.gQp = false;
    }

    public final String CR() {
        return this.cachePath + "MicroMsg.db";
    }

    public final String CS() {
        return this.cachePath + "EnMicroMsg.db";
    }

    public final SharedPreferences fL(String str) {
        g.Dk();
        g.Dh();
        int Cg = a.Cg();
        if (Cg == 0) {
            return null;
        }
        if (this.gQr.containsKey(str)) {
            return (SharedPreferences) this.gQr.get(str);
        }
        try {
            String str2 = ac.getContext().getFilesDir().getParent() + "/shared_prefs/";
            String str3 = ac.cfs() + str + Cg + ".xml";
            String str4 = ac.cfs() + str + Cg + ".xml.bak";
            File file = new File(str2 + str3);
            if (file.exists()) {
                file.delete();
            }
            File file2 = new File(str2 + str4);
            if (file2.exists()) {
                file2.delete();
            }
        } catch (Exception e) {
        }
        SharedPreferences sharedPreferences = ac.getContext().getSharedPreferences(ac.cfs() + str + ab.UZ(Cg + ab.UZ(String.valueOf(Cg / 2))), 0);
        this.gQr.put(str, sharedPreferences);
        return sharedPreferences;
    }

    private static String CT() {
        String str = w.gZK;
        File file = new File(com.tencent.mm.compatible.util.e.bnD);
        x.i("MMKernel.CoreStorage", "summer buildSysPath sysPath[" + str + "] SDCARD_ROOT[" + com.tencent.mm.compatible.util.e.bnD + "] file.exists:" + file.exists() + " CUtil.isSDCardAvail():" + com.tencent.mm.compatible.util.f.ze());
        if (file.exists() && com.tencent.mm.compatible.util.f.ze()) {
            if (bS(com.tencent.mm.compatible.util.e.bnF)) {
                str = com.tencent.mm.compatible.util.e.bnF;
            }
            file = new File(com.tencent.mm.compatible.util.e.gHu);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gHv);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gHw);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gHx);
            if (!file.exists()) {
                file.mkdirs();
            }
            file = new File(com.tencent.mm.compatible.util.e.gHv + ".nomedia");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (Throwable e) {
                    x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e));
                }
            }
        }
        file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        x.i("MMKernel.CoreStorage", "summer buildSysPath ret sysPath: " + str);
        return str;
    }

    private static final boolean bS(String str) {
        if (bh.ov(str)) {
            x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath isNullOrNil ret false");
            return false;
        }
        File file = new File(str);
        x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath[%s], f.exists[%b], f.isDirectory[%b]", str, Boolean.valueOf(file.exists()), Boolean.valueOf(file.isDirectory()));
        if (file.exists() && file.isDirectory()) {
            x.i("MMKernel.CoreStorage", "forceMkdirs f is dir and exist ret true");
            return true;
        }
        String[] split = str.split("/");
        if (split == null || split.length < 2) {
            x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len illegal ret false");
            return false;
        }
        String str2 = "/";
        x.i("MMKernel.CoreStorage", "forceMkdirs absolutePath arr len: " + split.length);
        for (int i = 0; i < split.length; i++) {
            if (!bh.ov(split[i])) {
                str2 = str2 + "/" + split[i];
                File file2 = new File(str2);
                if (file2.isFile() && !file2.renameTo(new File(str2 + "_mmbak"))) {
                    x.i("MMKernel.CoreStorage", "forceMkdirs renameTo false ret false file[%s]", file2.getName());
                    return false;
                } else if (!(file2.exists() || file2.mkdir())) {
                    x.i("MMKernel.CoreStorage", "forceMkdirs mkdir false ret false file[%s]", file2.getName());
                    return false;
                }
            }
        }
        x.i("MMKernel.CoreStorage", "forceMkdirs false ret true");
        return true;
    }

    public final t CU() {
        g.Dk();
        g.Dh().Ct();
        return this.gQl;
    }

    public final be CV() {
        g.Dk();
        g.Dh().Ct();
        return this.gQm;
    }

    public final void CW() {
        this.gQu = Boolean.valueOf(isSDCardAvailable());
    }

    public final boolean CX() {
        if (this.gQu == null) {
            this.gQu = Boolean.valueOf(isSDCardAvailable());
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.gQw;
            if (currentTimeMillis <= 0 || currentTimeMillis >= 1000) {
                if (this.gQt == null) {
                    this.gQt = new af(g.Dm().oAt.getLooper());
                }
                this.gQt.removeCallbacksAndMessages(null);
                this.gQt.postDelayed(this.gQv, 1000);
                this.gQw = System.currentTimeMillis();
            }
        }
        return this.gQu.booleanValue();
    }

    public final boolean isSDCardAvailable() {
        boolean startsWith = this.gQh.startsWith(com.tencent.mm.compatible.util.e.bnD);
        long Wp = bh.Wp();
        long j = Wp - this.gQs;
        if (startsWith) {
            g.Dk();
            if (g.Dh().Cy() && j > 0 && j < 1000 && new File(this.gQh).exists()) {
                return true;
            }
        }
        this.gQs = Wp;
        boolean ze = com.tencent.mm.compatible.util.f.ze();
        r8 = new Object[6];
        g.Dk();
        g.Dh();
        r8[1] = o.getString(a.Cg());
        r8[2] = Long.valueOf(j);
        r8[3] = this.gQh;
        r8[4] = com.tencent.mm.compatible.util.e.bnD;
        r8[5] = Boolean.valueOf(g.Dh().Cy());
        x.i("MMKernel.CoreStorage", "isSDCardAvail:%b uin:%s toNow:%d sysPath:[%s] sdRoot:[%s], acc init:[%b]", r8);
        if (!ze) {
            return false;
        }
        if (startsWith) {
            return true;
        }
        g.Dk();
        if (!g.Dh().Cy()) {
            return true;
        }
        x.i("MMKernel.CoreStorage", "summer isSDCardAvailable accHasReady and remount");
        CY();
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void CY() {
        g.Dk();
        synchronized (g.Dh().gPj) {
            String CT = CT();
            x.i("MMKernel.CoreStorage", "remount begin uin:%d oldpath:[%s] newPath:[%s] init:[%b]", Integer.valueOf(a.Cg()), this.gQh, CT, Boolean.valueOf(g.Dh().Cy()));
            if (!bh.ov(CT)) {
                if (CT.equalsIgnoreCase(this.gQh)) {
                    try {
                        x.i("MMKernel.CoreStorage", "testSdcardWritable done ret:" + CZ());
                    } catch (Exception e) {
                        x.w("MMKernel.CoreStorage", "testSdcardWritable Exception e: " + e.getMessage());
                    }
                    try {
                        x.i("MMKernel.CoreStorage", "testSdcardReadable done ret:" + Da());
                    } catch (Exception e2) {
                        x.w("MMKernel.CoreStorage", "testSdcardReadable Exception e: " + e2.getMessage());
                    }
                    return;
                }
                x.i("MMKernel.CoreStorage", "remount resetSysPath sysPath:[%s] newSysPath:[%s] accPath:[%s] cachePath: [%s]", this.gQh, CT, this.gQi, this.cachePath);
                if (!bh.ov(CT)) {
                    this.gQh = CT;
                    StringBuilder stringBuilder = new StringBuilder("mm");
                    g.Dk();
                    g.Dh();
                    this.gQi = this.gQh + g.s(stringBuilder.append(a.Cg()).toString().getBytes()) + "/";
                    CP();
                }
                com.tencent.mm.kernel.a.c.Dt().gRr.Dp();
                x.i("MMKernel.CoreStorage", "remout isSDCardAvail :[%b] done", Boolean.valueOf(com.tencent.mm.compatible.util.f.ze()));
            }
        }
    }

    private static boolean CZ() {
        boolean canWrite;
        Exception e;
        Throwable th;
        boolean z = false;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnD.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canWrite = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canWrite();
        } catch (Exception e2) {
            x.w("MMKernel.CoreStorage", "testSdcardWritable 1 e: " + e2.getMessage());
            canWrite = false;
        }
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "test_writable");
        FileOutputStream fileOutputStream;
        try {
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write("test".getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                boolean delete = file.delete();
                try {
                    fileOutputStream.close();
                    z = delete;
                } catch (Throwable e3) {
                    x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e3));
                    z = delete;
                }
            } catch (Exception e4) {
                e = e4;
                try {
                    x.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e5));
                        }
                    }
                    x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e52) {
                            x.e("MMKernel.CoreStorage", "exception:%s", bh.i(e52));
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileOutputStream = null;
            x.w("MMKernel.CoreStorage", "testSdcardWritable 2 e: " + e.getMessage());
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
            return z;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
        x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canWrite: " + canWrite + " canTrueWrite:" + z);
        return z;
    }

    private static boolean Da() {
        boolean canRead;
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        boolean equalsIgnoreCase = com.tencent.mm.compatible.util.e.bnD.equalsIgnoreCase(absolutePath);
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        try {
            canRead = new File(Environment.getExternalStorageDirectory().getAbsolutePath()).canRead();
        } catch (Exception e) {
            Exception exception = e;
            canRead = false;
            x.w("MMKernel.CoreStorage", "testSdcardReadable 1 e: " + exception.getMessage());
        }
        File file = new File(com.tencent.mm.compatible.util.e.bnF);
        boolean exists = file.exists();
        if (exists) {
            x.i("MMKernel.CoreStorage", "testSdcardReadable testFile isDirectory:" + file.isDirectory() + " isFile:" + file.isFile());
        }
        x.i("MMKernel.CoreStorage", "testSdcardWritable primaryExtStg: " + absolutePath + " CConstants.SDCARD_ROOT: " + com.tencent.mm.compatible.util.e.bnD + " CConstants.DATAROOT_SDCARD_PATH: " + com.tencent.mm.compatible.util.e.bnF + " isPrimaryExtStg: " + equalsIgnoreCase + " mounted: " + equals + " canRead: " + canRead + " canTrueRead:" + exists);
        return exists;
    }

    static {
        HashMap hashMap = new HashMap();
        gwY = hashMap;
        hashMap.put(Integer.valueOf("CONFIG_TABLE".hashCode()), new d() {
            public final String[] wg() {
                return t.gJN;
            }
        });
        gwY.put(Integer.valueOf("TablesVersion".hashCode()), new d() {
            public final String[] wg() {
                return bi.gJN;
            }
        });
    }

    static HashMap<Integer, d> Bn() {
        HashMap<Integer, d> hashMap = new HashMap();
        hashMap.putAll(gwY);
        return hashMap;
    }
}
