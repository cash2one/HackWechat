package com.tencent.mm.app;

import com.tencent.mm.app.WorkerProfile.21;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.SFSContext.Statistics;
import com.tencent.mm.modelsfs.SFSContext.Statistics.BlockFile;
import com.tencent.mm.modelsfs.SFSContext.Statistics.BlockType;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class WorkerProfile$21$1 implements Runnable {
    int fgF;
    long fgG;
    Map<String, Statistics> fgH;
    final /* synthetic */ 21 fgI;

    WorkerProfile$21$1(21 21) {
        this.fgI = 21;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        if (this.fgG != 0) {
            int i = this.fgF;
            ar.Hg();
        }
        load();
        ar.Hg();
        this.fgF = c.Cg();
        if (System.currentTimeMillis() - this.fgG >= 86400000) {
            Map Rw = FileOp.Rw();
            if (this.fgH != null) {
                for (Entry entry : Rw.entrySet()) {
                    Statistics statistics = (Statistics) entry.getValue();
                    Statistics statistics2 = (Statistics) this.fgH.get(entry.getKey());
                    if (!(statistics2 == null || statistics == null)) {
                        int a = a(statistics, true);
                        int a2 = a(statistics, false);
                        g gVar = g.pQN;
                        Object[] objArr = new Object[15];
                        objArr[0] = entry.getKey();
                        objArr[1] = Long.valueOf(statistics.totalActualSize);
                        objArr[2] = Long.valueOf(statistics.blockSizeUsed);
                        objArr[3] = Long.valueOf(statistics.blockSizeEmpty);
                        objArr[4] = Long.valueOf(statistics.overflowActualSize);
                        objArr[5] = Integer.valueOf(a);
                        objArr[6] = Integer.valueOf(a2);
                        objArr[7] = Long.valueOf(statistics.totalActualSize - statistics2.totalActualSize);
                        objArr[8] = Long.valueOf(statistics.blockSizeUsed - statistics2.blockSizeUsed);
                        objArr[9] = Long.valueOf(statistics.blockSizeEmpty - statistics2.blockSizeEmpty);
                        objArr[10] = Long.valueOf(statistics.overflowActualSize - statistics2.overflowActualSize);
                        objArr[11] = Integer.valueOf(a - a(statistics2, true));
                        objArr[12] = Integer.valueOf(a2 - a(statistics2, false));
                        objArr[13] = Integer.valueOf(statistics.blockFiles.length);
                        a = 0;
                        for (BlockFile blockFile : statistics.blockFiles) {
                            if (blockFile.deleted) {
                                a++;
                            }
                        }
                        objArr[14] = Integer.valueOf(a);
                        gVar.h(12671, objArr);
                        for (a = 0; a < statistics.blockTypes.length; a++) {
                            BlockType blockType = statistics.blockTypes[a];
                            BlockType blockType2 = statistics2.blockTypes[a];
                            g.pQN.h(12672, entry.getKey(), Integer.valueOf(blockType.blockSize), Integer.valueOf(blockType.usedCount), Integer.valueOf(blockType.emptyCount), Long.valueOf(blockType.actualSize), Integer.valueOf(blockType.usedCount - blockType2.usedCount), Integer.valueOf(blockType.emptyCount - blockType2.emptyCount), Long.valueOf(blockType.actualSize - blockType2.actualSize));
                        }
                    }
                }
                this.fgH = Rw;
                try {
                    StringBuilder stringBuilder = new StringBuilder(8192);
                    stringBuilder.append("Reported SFS statistics:\n");
                    for (Entry entry2 : this.fgH.entrySet()) {
                        stringBuilder.append("===== ").append((String) entry2.getKey()).append(" =====\n").append(((Statistics) entry2.getValue()).toString()).append("\n\n");
                    }
                    x.i("MicroMsg.WorkerProfile", stringBuilder.toString());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                }
            }
            this.fgG = System.currentTimeMillis();
            this.fgH = Rw;
            save();
        }
    }

    private boolean load() {
        Throwable th;
        Throwable th2;
        ObjectInputStream objectInputStream = null;
        x.i("MicroMsg.WorkerProfile", "Load previous SFS statistics.");
        ObjectInputStream objectInputStream2;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            objectInputStream2 = new ObjectInputStream(new FileInputStream(stringBuilder.append(c.FB()).append("sfs/sfs_stats.bin").toString()));
            try {
                this.fgG = objectInputStream2.readLong();
                this.fgH = (TreeMap) objectInputStream2.readObject();
                try {
                    objectInputStream2.close();
                } catch (IOException e) {
                }
                return true;
            } catch (Exception e2) {
                objectInputStream = objectInputStream2;
                try {
                    x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
                    this.fgG = System.currentTimeMillis();
                    this.fgH = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e3) {
                        }
                    }
                    return save();
                } catch (Throwable th3) {
                    th = th3;
                    objectInputStream2 = objectInputStream;
                    th2 = th;
                    if (objectInputStream2 != null) {
                        try {
                            objectInputStream2.close();
                        } catch (IOException e4) {
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                th2 = th4;
                if (objectInputStream2 != null) {
                    objectInputStream2.close();
                }
                throw th2;
            }
        } catch (Exception e5) {
            x.e("MicroMsg.WorkerProfile", "Can't read previous SFS statistics, use default.");
            this.fgG = System.currentTimeMillis();
            this.fgH = null;
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            return save();
        } catch (Throwable th32) {
            th = th32;
            objectInputStream2 = null;
            th2 = th;
            if (objectInputStream2 != null) {
                objectInputStream2.close();
            }
            throw th2;
        }
    }

    private boolean save() {
        Throwable e;
        Throwable th;
        ObjectOutputStream objectOutputStream = null;
        x.i("MicroMsg.WorkerProfile", "Save previous SFS statistics.");
        ObjectOutputStream objectOutputStream2;
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ar.Hg();
            String stringBuilder2 = stringBuilder.append(c.FB()).append("sfs").toString();
            FileOp.mh(stringBuilder2);
            objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(stringBuilder2 + "/sfs_stats.bin"));
            try {
                Object treeMap;
                if (this.fgH != null) {
                    treeMap = new TreeMap(this.fgH);
                }
                objectOutputStream2.writeLong(this.fgG);
                objectOutputStream2.writeObject(treeMap);
                try {
                    objectOutputStream2.close();
                } catch (IOException e2) {
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "Can't read previous SFS statistics, use default.", new Object[0]);
                    if (objectOutputStream2 != null) {
                        return false;
                    }
                    try {
                        objectOutputStream2.close();
                        return false;
                    } catch (IOException e4) {
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e6) {
            e = e6;
            objectOutputStream2 = null;
            x.printErrStackTrace("MicroMsg.WorkerProfile", e, "Can't read previous SFS statistics, use default.", new Object[0]);
            if (objectOutputStream2 != null) {
                return false;
            }
            objectOutputStream2.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw th;
        }
    }

    private static int a(Statistics statistics, boolean z) {
        int i = 0;
        for (BlockType blockType : statistics.blockTypes) {
            i += z ? blockType.usedCount : blockType.emptyCount;
        }
        return i;
    }
}
