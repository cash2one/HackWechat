package com.tencent.mm.plugin.report.service;

import android.content.Context;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class e {
    private static String filePath = (getAppFilePath() + "/kvcomm/exception/");
    private static Byte pQB = new Byte((byte) 0);

    static {
        if (!com.tencent.mm.a.e.bO(filePath)) {
            com.tencent.mm.a.e.bS(filePath);
        }
    }

    private static String getAppFilePath() {
        String str = null;
        Context context = ac.getContext();
        if (context != null) {
            try {
                File filesDir = context.getFilesDir();
                if (!filesDir.exists()) {
                    filesDir.createNewFile();
                }
                str = filesDir.toString();
            } catch (Exception e) {
                x.e("MicroMsg.ReportManagerKvCheck", e.getMessage());
            }
        }
        return str;
    }

    public static void bok() {
        if (com.tencent.mm.a.e.bO(filePath)) {
            File[] listFiles = new File(filePath).listFiles();
            if (listFiles == null) {
                x.e("MicroMsg.ReportManagerKvCheck", "list file fail, filePath:" + filePath);
                return;
            }
            synchronized (pQB) {
                for (File file : listFiles) {
                    if (file == null) {
                        x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, file is null");
                    } else {
                        String absolutePath = file.getAbsolutePath();
                        int i = 0;
                        int bN = com.tencent.mm.a.e.bN(absolutePath);
                        x.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filename:" + file.getAbsolutePath() + ", filelenth:" + bN);
                        while (i < bN) {
                            byte[] d = com.tencent.mm.a.e.d(absolutePath, i, 4);
                            if (d == null) {
                                x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_len fail. delete file:" + absolutePath);
                                break;
                            }
                            i += 4;
                            int aG = aG(d);
                            byte[] d2 = com.tencent.mm.a.e.d(absolutePath, i, aG);
                            if (d2 == null) {
                                x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, get obj_data fail. delete file:" + absolutePath);
                                break;
                            }
                            int i2 = i + aG;
                            boolean z;
                            if (!absolutePath.contains(".statictis")) {
                                b bVar;
                                if (!absolutePath.contains(".monitor")) {
                                    if (!absolutePath.contains(".group_monitor")) {
                                        x.e("MicroMsg.ReportManagerKvCheck", "invalid filename:" + absolutePath);
                                        break;
                                    }
                                    a aVar = new a();
                                    try {
                                        aVar.aF(d2);
                                        ArrayList arrayList = new ArrayList();
                                        z = false;
                                        Iterator it = aVar.pQi.iterator();
                                        while (it.hasNext()) {
                                            bVar = (b) it.next();
                                            IDKey iDKey = new IDKey(bVar.fgt, bVar.pQj, bVar.pQk);
                                            boolean z2 = bVar.pQl;
                                            arrayList.add(iDKey);
                                            x.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, idkeyGroupStat, id:" + bVar.fgt + ", key:" + bVar.pQj + ", value:" + bVar.pQk + ", isImportant" + z2);
                                            z = z2;
                                        }
                                        g.pQN.a(arrayList, z);
                                    } catch (IOException e) {
                                        x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e.getMessage());
                                        i = i2;
                                    }
                                } else {
                                    bVar = new b();
                                    try {
                                        bVar.aF(d2);
                                        long j = (long) bVar.fgt;
                                        long j2 = (long) bVar.pQj;
                                        long j3 = (long) bVar.pQk;
                                        boolean z3 = bVar.pQl;
                                        x.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportidkey, id:" + j + ", key:" + j2 + ", value:" + j3 + ", isImportant" + z3);
                                        g.pQN.a(j, j2, j3, z3);
                                    } catch (IOException e2) {
                                        x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(idkey), IOException:" + e2.getMessage());
                                        i = i2;
                                    }
                                }
                            } else {
                                c cVar = new c();
                                try {
                                    cVar.aF(d2);
                                    aG = cVar.pQs;
                                    String str = cVar.pQt;
                                    boolean z4 = cVar.pQl;
                                    z = cVar.pQu;
                                    x.i("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, reportkvcomm, logid:" + aG + ", value:" + str + ", isReportNow:" + z + ", isImportant" + z4);
                                    g.pQN.a(aG, str, z, z4);
                                } catch (IOException e22) {
                                    x.e("MicroMsg.ReportManagerKvCheck", "loadFilesToReport(kvcomm), IOException:" + e22.getMessage());
                                    i = i2;
                                }
                            }
                            x.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, curLen:" + i2);
                            i = i2;
                        }
                        x.d("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, read to end, deletefile:" + absolutePath);
                        b.deleteFile(absolutePath);
                    }
                }
            }
            return;
        }
        x.w("MicroMsg.ReportManagerKvCheck", "loadFilesToReport, filepath:" + filePath + " not exist.");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(int i, String str, boolean z, boolean z2) {
        if (com.tencent.mm.a.e.bO(filePath)) {
            x.i("MicroMsg.ReportManagerKvCheck", "saveKVcommData, logId:" + i + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z);
            String bol = bol();
            if ("MM".equals(bol)) {
                x.e("MicroMsg.ReportManagerKvCheck", "error path, invalid processname:" + bol + ", logId:" + i + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z);
                return;
            }
            bol = filePath + bol + ".statictis";
            c cVar = new c();
            cVar.pQs = i;
            cVar.pQt = str;
            cVar.pQl = z2;
            cVar.pQu = z;
            try {
                byte[] toByteArray = cVar.toByteArray();
                if (toByteArray == null) {
                    x.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, null == temp.");
                    return;
                }
                synchronized (pQB) {
                    if (com.tencent.mm.a.e.d(bol, vy(toByteArray.length)) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write obj_len to file:" + bol + " fail.");
                        return;
                    } else if (com.tencent.mm.a.e.d(bol, toByteArray) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, write object to file:" + bol + " fail.");
                    }
                }
            } catch (IOException e) {
                x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.ReportManagerKvCheck", "saveKVcommData, filepath:" + filePath + " not exist , logId:" + i + ", val:" + str + ", isImportant:" + z2 + ", reportnow:" + z);
    }

    public static void d(int i, int i2, int i3, boolean z) {
        x.i("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
        if (com.tencent.mm.a.e.bO(filePath)) {
            String bol = bol();
            if ("MM".equals(bol)) {
                x.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + bol + ", id:" + i + ", key:" + i2 + ", val:" + i3 + ", isImportant:" + z);
                return;
            }
            bol = filePath + bol + ".monitor";
            b bVar = new b();
            bVar.fgt = i;
            bVar.pQj = i2;
            bVar.pQk = i3;
            bVar.pQl = z;
            try {
                byte[] toByteArray = bVar.toByteArray();
                if (toByteArray == null) {
                    x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, null == temp.");
                    return;
                }
                synchronized (pQB) {
                    if (com.tencent.mm.a.e.d(bol, vy(toByteArray.length)) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write obj_len to file:" + bol + " fail.");
                        return;
                    }
                    if (com.tencent.mm.a.e.d(bol, toByteArray) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, write object to file:" + bol + " fail.");
                    }
                    x.d("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, fileLength:" + com.tencent.mm.a.e.bN(bol));
                    return;
                }
            } catch (IOException e) {
                x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, IOException, detail:" + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.ReportManagerKvCheck", "saveIDKeyData, filepath:" + filePath + " not exist , Id:" + i + ", key:" + i2 + ", value:" + i3 + ", isImportant:" + z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c(ArrayList<IDKey> arrayList, boolean z) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            IDKey iDKey = (IDKey) it.next();
            x.i("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, id:" + iDKey.GetID() + ", key:" + iDKey.GetKey() + ", value:" + iDKey.GetValue() + ", isImportant:" + z);
        }
        if (com.tencent.mm.a.e.bO(filePath)) {
            String bol = bol();
            if ("MM".equals(bol)) {
                x.e("MicroMsg.ReportManagerKvCheck", "error path, current processname:" + bol);
                return;
            }
            String str = filePath + bol + ".group_monitor";
            a aVar = new a();
            aVar.ksO = arrayList.size();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                iDKey = (IDKey) it2.next();
                b bVar = new b();
                bVar.fgt = (int) iDKey.GetID();
                bVar.pQj = (int) iDKey.GetKey();
                bVar.pQk = (int) iDKey.GetValue();
                bVar.pQl = z;
                aVar.pQi.add(bVar);
            }
            try {
                byte[] toByteArray = aVar.toByteArray();
                if (toByteArray == null) {
                    x.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, null == temp.");
                    return;
                }
                synchronized (pQB) {
                    if (com.tencent.mm.a.e.d(str, vy(toByteArray.length)) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write obj_len to file:" + str + " fail.");
                        return;
                    } else if (com.tencent.mm.a.e.d(str, toByteArray) != 0) {
                        x.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, write object to file:" + str + " fail.");
                    }
                }
            } catch (IOException e) {
                x.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, IOException, detail:" + e.getMessage());
                return;
            }
        }
        x.e("MicroMsg.ReportManagerKvCheck", "saveGroupIDKeyData, filepath:" + filePath + " not exist ");
    }

    private static String bol() {
        String Br = ac.Br();
        if (Br == null || Br.length() == 0) {
            return "MM";
        }
        String[] split = Br.split(":");
        if (split.length <= 1) {
            return "MM";
        }
        return split[1];
    }

    private static byte[] vy(int i) {
        return new byte[]{(byte) ((i >> 24) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 8) & 255), (byte) (i & 255)};
    }

    private static int aG(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (i < 4) {
            i2 += (bArr[i] & 255) << ((3 - i) * 8);
            i++;
        }
        return i2;
    }
}
