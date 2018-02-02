package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.o;
import com.tencent.mm.by.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class d implements ap {
    private static final SQLiteCipherSpec lpX = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private BroadcastReceiver hGD;
    private boolean hGE = false;
    private boolean hGF = true;
    private Runnable hGH;
    private volatile BackupKit lpH;
    private volatile RecoverKit lpI;
    private volatile RepairKit lpJ;
    private volatile boolean lpK = false;
    private boolean lpL = false;
    private boolean lpM = false;
    private long lpN = 0;
    private long lpO = 600000;
    private long lpP = 0;
    private int lpQ = 10;
    private boolean lpR = false;
    final SimpleDateFormat lpS = new SimpleDateFormat("HH:mm:ss.SSS");
    private String lpT;
    private FLock lpU;
    private a lpV;
    private c lpW;

    private static long[] xw(String str) {
        Throwable e;
        long j = 0;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str + ".bcur"));
            try {
                long parseLong;
                long parseLong2;
                long parseLong3;
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong = Long.parseLong(readLine);
                } else {
                    parseLong = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong2 = Long.parseLong(readLine);
                } else {
                    parseLong2 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    parseLong3 = Long.parseLong(readLine);
                } else {
                    parseLong3 = 0;
                }
                readLine = bufferedReader.readLine();
                if (readLine != null) {
                    j = Long.parseLong(readLine);
                }
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, j};
                try {
                    bufferedReader.close();
                    return jArr;
                } catch (IOException e2) {
                    return jArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", new Object[]{str});
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", new Object[]{str});
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static boolean a(String str, long[] jArr) {
        FileWriter fileWriter;
        Throwable e;
        try {
            fileWriter = new FileWriter(str + ".bcur");
            try {
                for (long l : jArr) {
                    fileWriter.write(Long.toString(l) + "\n");
                }
                try {
                    fileWriter.close();
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", new Object[]{str});
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            x.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", new Object[]{str});
            if (fileWriter != null) {
                fileWriter.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }

    public final boolean a(boolean z, b bVar) {
        if (this.lpK) {
            x.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", new Object[]{"backup"});
            return false;
        }
        long j;
        String[] strArr;
        boolean z2;
        int i;
        com.tencent.mm.z.c Hg = ar.Hg();
        String CS = com.tencent.mm.z.c.CS();
        SQLiteDatabase ckV = com.tencent.mm.z.c.EV().ckV();
        String str = CS + ".bak";
        String str2 = str + ".tmp";
        String str3 = CS + ".sm";
        String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (FileOp.bO(str)) {
                i2 = 24;
                FileOp.x(str, str2);
            } else {
                z = false;
            }
        }
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        Cursor rawQueryWithFactory = ckV.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j = rawQueryWithFactory.getLong(0);
        } else {
            j = -1;
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = ckV.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j2 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = ckV.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j3 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = ckV.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j4 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        long[] jArr = new long[]{j, j2, j3, j4};
        long[] xw = z ? xw(CS) : null;
        if (xw == null || xw.length < 4) {
            strArr = new String[]{"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
        } else {
            strArr = new String[12];
            strArr[0] = "message";
            strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(xw[0]), Long.valueOf(jArr[0])});
            strArr[2] = "ImgInfo2";
            strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(xw[1]), Long.valueOf(jArr[1])});
            strArr[4] = "videoinfo2";
            strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(xw[2]), Long.valueOf(jArr[2])});
            strArr[6] = "EmojiInfo";
            strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(xw[3]), Long.valueOf(jArr[3])});
            strArr[8] = "conversation";
            strArr[9] = null;
            strArr[10] = "rconversation";
            strArr[11] = null;
        }
        if (xw == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.lpR) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        Runnable 1 = new 1(this, bVar, Hg, str3, z2, ckV, str4, CS, str2, xw, jArr, i, strArr, str);
        this.lpK = true;
        e.post(1, "DB Backup");
        return true;
    }

    public final synchronized boolean azD() {
        boolean z = false;
        synchronized (this) {
            this.lpK = false;
            if (this.lpH != null) {
                this.lpH.onCancel();
                z = true;
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int a(String str, b bVar) {
        Runnable 2 = new 2(this, ar.Hg(), str, bh.cgu(), bVar);
        this.lpK = true;
        ar.Dm().tS();
        ar.Dm().J(2);
        return 0;
    }

    @Deprecated
    public final synchronized int b(String str, b bVar) {
        int i = 0;
        synchronized (this) {
            com.tencent.mm.z.c Hg = ar.Hg();
            if (str == null) {
                str = com.tencent.mm.z.c.CQ();
            }
            long cgu = bh.cgu();
            File file = str == null ? null : new File(str);
            if (file == null || !file.canRead()) {
                i = -3;
            } else {
                x.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", new Object[]{Long.valueOf(file.length()), Long.valueOf(cgu)});
                if (((float) cgu) < ((float) file.length()) * DownloadHelper.SAVE_FATOR) {
                    i = -2;
                } else {
                    Runnable 3 = new 3(this, Hg, str, bVar);
                    this.lpK = true;
                    ar.Dm().tS();
                    ar.Dm().J(3);
                }
            }
        }
        return i;
    }

    @Deprecated
    public final int a(b bVar) {
        ar.Hg();
        String CQ = com.tencent.mm.z.c.CQ();
        if (CQ == null || CQ.isEmpty()) {
            return -3;
        }
        File file = new File(CQ);
        if (!file.canRead()) {
            return -3;
        }
        StringBuilder append = new StringBuilder().append(q.yE());
        ar.Hg();
        String substring = g.s(append.append(com.tencent.mm.z.c.Cg()).toString().getBytes()).substring(0, 7);
        x.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", new Object[]{Long.valueOf(file.length() * 2), Long.valueOf(bh.cgu())});
        if (bh.cgu() < file.length() * 2) {
            return -2;
        }
        ar.Dm().tS();
        ar.Dm().J(new 4(this, file, substring, bVar));
        return 0;
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bq(boolean z) {
        String readLine;
        int VI;
        a e;
        BufferedReader bufferedReader;
        Throwable th;
        t CU;
        SQLiteDatabase ckV;
        boolean z2;
        Context context;
        Intent registerReceiver;
        IntentFilter intentFilter;
        String str;
        Object[] objArr;
        File file;
        long nanoTime;
        StringBuilder append;
        File file2;
        long nanoTime2;
        String str2;
        String str3;
        Object[] objArr2;
        com.tencent.mm.plugin.report.service.g gVar;
        BufferedReader bufferedReader2 = null;
        String str4 = com.tencent.mm.kernel.g.Dj().cachePath + "account.lck";
        this.lpT = str4;
        BufferedReader bufferedReader3;
        try {
            this.lpU = new FLock(str4);
            if (this.lpU.ceT()) {
                FileWriter fileWriter = new FileWriter(str4);
                fileWriter.write(Integer.toString(Process.myPid()));
                fileWriter.close();
                x.i("MicroMsg.DuplicateDetect", "No account multiple instances detected.");
                bufferedReader3 = null;
            } else {
                bufferedReader3 = new BufferedReader(new FileReader(str4));
                try {
                    readLine = bufferedReader3.readLine();
                    VI = readLine == null ? 0 : bh.VI(readLine);
                    bufferedReader3.close();
                    if (VI != 0) {
                        if (VI != Process.myPid()) {
                            File file3 = new File("/proc/" + VI + "/status");
                            if (file3.isFile() && file3.canRead()) {
                                String readLine2;
                                bufferedReader3 = new BufferedReader(new FileReader(file3));
                                do {
                                    readLine2 = bufferedReader3.readLine();
                                    if (readLine2 != null) {
                                    }
                                    break;
                                } while (!readLine2.startsWith("State:"));
                                String[] split = readLine2.split(": \\t");
                                if (split.length > 1 && (split[1].equals("S") || split[1].equals("R"))) {
                                    throw new a("Multiple instances of WeChat with same account detected. Last PID: " + VI);
                                }
                                bufferedReader3.close();
                                x.i("MicroMsg.DuplicateDetect", "Account reentrant within same process detected.");
                            }
                        }
                    }
                    bufferedReader3 = null;
                    x.i("MicroMsg.DuplicateDetect", "Account reentrant within same process detected.");
                } catch (a e2) {
                    e = e2;
                    bufferedReader = bufferedReader3;
                    try {
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader2 = bufferedReader;
                    }
                } catch (Exception e3) {
                    th = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.DuplicateDetect", th, "Failed to initialize lock file: " + str4, new Object[0]);
                        this.lpU.unlock();
                        this.lpU = null;
                        new File(this.lpT).delete();
                        this.lpT = null;
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e4) {
                            }
                        }
                        ar.Hg();
                        CU = com.tencent.mm.z.c.CU();
                        ckV = com.tencent.mm.z.c.EV().ckV();
                        this.lpP = CU.Dm(237569);
                        this.lpQ = CU.getInt(237570, 10);
                        if (CU.getInt(237571, 0) == 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        this.lpR = z2;
                        context = ac.getContext();
                        registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                        if (registerReceiver == null) {
                            this.hGE = false;
                        } else {
                            VI = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                            if (VI != 2) {
                            }
                            z2 = true;
                            this.hGE = z2;
                        }
                        this.hGF = ((PowerManager) context.getSystemService("power")).isScreenOn();
                        this.lpV = new a(this) {
                            final /* synthetic */ d lqk;

                            {
                                this.lqk = r1;
                            }

                            public final void a(String str, l lVar) {
                                if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                                    d.azE();
                                }
                            }
                        };
                        com.tencent.mm.z.c.c.IF().c(this.lpV);
                        azE();
                        this.lpW = new 8(this);
                        com.tencent.mm.sdk.b.a.xef.b(this.lpW);
                        this.hGD = new BroadcastReceiver(this) {
                            final /* synthetic */ d lqk;

                            {
                                this.lqk = r1;
                            }

                            public final void onReceive(Context context, Intent intent) {
                                String action = intent.getAction();
                                boolean z = true;
                                switch (action.hashCode()) {
                                    case -2128145023:
                                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case -1886648615:
                                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                    case -1454123155:
                                        if (action.equals("android.intent.action.SCREEN_ON")) {
                                            z = false;
                                            break;
                                        }
                                        break;
                                    case 1019184907:
                                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                            z = true;
                                            break;
                                        }
                                        break;
                                }
                                switch (z) {
                                    case false:
                                        this.lqk.hGF = true;
                                        break;
                                    case true:
                                        this.lqk.hGF = false;
                                        break;
                                    case true:
                                        this.lqk.hGE = true;
                                        break;
                                    case true:
                                        this.lqk.hGE = false;
                                        break;
                                }
                                x.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", new Object[]{action, Boolean.valueOf(this.lqk.hGF), Boolean.valueOf(this.lqk.hGE)});
                                if (this.lqk.lpM && this.lqk.hGH == null && this.lqk.hGE && !this.lqk.hGF) {
                                    if (System.currentTimeMillis() - this.lqk.lpP < 86400000) {
                                        x.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                                        return;
                                    }
                                    z = this.lqk.lpQ < 10;
                                    this.lqk.hGH = new 2(this, z, new 1(this, z));
                                    ar.Dm().g(this.lqk.hGH, this.lqk.lpO);
                                    x.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                                    com.tencent.mm.plugin.report.service.g.pQN.h(11098, new Object[]{Integer.valueOf(10009), this.lqk.lpS.format(new Date())});
                                } else if (this.lqk.hGH != null) {
                                    ar.Dm().cfF().removeCallbacks(this.lqk.hGH);
                                    this.lqk.hGH = null;
                                    x.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                                    com.tencent.mm.plugin.report.service.g.pQN.h(11098, new Object[]{Integer.valueOf(10010), this.lqk.lpS.format(new Date())});
                                } else if (this.lqk.lpL) {
                                    this.lqk.azD();
                                    this.lqk.lpL = false;
                                }
                            }
                        };
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("android.intent.action.SCREEN_ON");
                        intentFilter.addAction("android.intent.action.SCREEN_OFF");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
                        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
                        context.registerReceiver(this.hGD, intentFilter);
                        b.a(new c(this), new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
                        str = "MicroMsg.SubCoreDBBackup";
                        str4 = "Auto database backup %s. Device status:%s interactive,%s charging.";
                        objArr = new Object[3];
                        objArr[0] = this.lpM ? "disabled" : "enabled";
                        objArr[1] = this.hGF ? " not" : "";
                        objArr[2] = this.hGE ? " not" : "";
                        x.i(str, str4, objArr);
                        readLine = ckV.getPath() + ".sm";
                        str = readLine + ".tmp";
                        file = new File(readLine);
                        if (!file.isFile()) {
                            nanoTime = System.nanoTime();
                            append = new StringBuilder().append(q.yE());
                            ar.Hg();
                            z2 = MasterInfo.save(ckV, str, g.t(append.append(com.tencent.mm.z.c.Cg()).toString().getBytes()));
                            file2 = new File(str);
                            if (z2) {
                                file.delete();
                                z2 = file2.renameTo(file);
                            } else {
                                file2.delete();
                            }
                            nanoTime2 = System.nanoTime() - nanoTime;
                            str2 = "MicroMsg.SubCoreDBBackup";
                            str3 = "Master table backup %s, elapsed %.3f";
                            objArr2 = new Object[2];
                            if (z2) {
                                str = "SUCCEEDED";
                            } else {
                                str = "FAILED";
                            }
                            objArr2[0] = str;
                            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            x.i(str2, str3, objArr2);
                            gVar = com.tencent.mm.plugin.report.service.g.pQN;
                            if (z2) {
                                nanoTime2 = 24;
                            } else {
                                nanoTime2 = 25;
                            }
                            gVar.a(181, nanoTime2, 1, false);
                        }
                        ar.Dm().g(new 6(this, com.tencent.mm.z.c.FB()), 60000);
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader3;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e5) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader2 = bufferedReader3;
                    if (bufferedReader2 != null) {
                        bufferedReader2.close();
                    }
                    throw th;
                }
            }
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e6) {
                }
            }
        } catch (a e7) {
            e = e7;
            bufferedReader = null;
            throw e;
        } catch (Exception e8) {
            th = e8;
            bufferedReader3 = null;
            x.printErrStackTrace("MicroMsg.DuplicateDetect", th, "Failed to initialize lock file: " + str4, new Object[0]);
            this.lpU.unlock();
            this.lpU = null;
            new File(this.lpT).delete();
            this.lpT = null;
            if (bufferedReader3 != null) {
                bufferedReader3.close();
            }
            ar.Hg();
            CU = com.tencent.mm.z.c.CU();
            ckV = com.tencent.mm.z.c.EV().ckV();
            this.lpP = CU.Dm(237569);
            this.lpQ = CU.getInt(237570, 10);
            if (CU.getInt(237571, 0) == 0) {
                z2 = false;
            } else {
                z2 = true;
            }
            this.lpR = z2;
            context = ac.getContext();
            registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver == null) {
                this.hGE = false;
            } else {
                VI = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                if (VI != 2) {
                }
                z2 = true;
                this.hGE = z2;
            }
            this.hGF = ((PowerManager) context.getSystemService("power")).isScreenOn();
            this.lpV = /* anonymous class already generated */;
            com.tencent.mm.z.c.c.IF().c(this.lpV);
            azE();
            this.lpW = new 8(this);
            com.tencent.mm.sdk.b.a.xef.b(this.lpW);
            this.hGD = /* anonymous class already generated */;
            intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            context.registerReceiver(this.hGD, intentFilter);
            b.a(new c(this), new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
            str = "MicroMsg.SubCoreDBBackup";
            str4 = "Auto database backup %s. Device status:%s interactive,%s charging.";
            objArr = new Object[3];
            if (this.lpM) {
            }
            objArr[0] = this.lpM ? "disabled" : "enabled";
            if (this.hGF) {
            }
            objArr[1] = this.hGF ? " not" : "";
            if (this.hGE) {
            }
            objArr[2] = this.hGE ? " not" : "";
            x.i(str, str4, objArr);
            readLine = ckV.getPath() + ".sm";
            str = readLine + ".tmp";
            file = new File(readLine);
            if (file.isFile()) {
                nanoTime = System.nanoTime();
                append = new StringBuilder().append(q.yE());
                ar.Hg();
                z2 = MasterInfo.save(ckV, str, g.t(append.append(com.tencent.mm.z.c.Cg()).toString().getBytes()));
                file2 = new File(str);
                if (z2) {
                    file2.delete();
                } else {
                    file.delete();
                    z2 = file2.renameTo(file);
                }
                nanoTime2 = System.nanoTime() - nanoTime;
                str2 = "MicroMsg.SubCoreDBBackup";
                str3 = "Master table backup %s, elapsed %.3f";
                objArr2 = new Object[2];
                if (z2) {
                    str = "FAILED";
                } else {
                    str = "SUCCEEDED";
                }
                objArr2[0] = str;
                objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                x.i(str2, str3, objArr2);
                gVar = com.tencent.mm.plugin.report.service.g.pQN;
                if (z2) {
                    nanoTime2 = 25;
                } else {
                    nanoTime2 = 24;
                }
                gVar.a(181, nanoTime2, 1, false);
            }
            ar.Dm().g(new 6(this, com.tencent.mm.z.c.FB()), 60000);
        } catch (Throwable th5) {
            th = th5;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        ar.Hg();
        CU = com.tencent.mm.z.c.CU();
        ckV = com.tencent.mm.z.c.EV().ckV();
        this.lpP = CU.Dm(237569);
        this.lpQ = CU.getInt(237570, 10);
        if (CU.getInt(237571, 0) == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.lpR = z2;
        context = ac.getContext();
        registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            VI = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            if (VI != 2 || VI == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.hGE = z2;
        } else {
            this.hGE = false;
        }
        this.hGF = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.lpV = /* anonymous class already generated */;
        com.tencent.mm.z.c.c.IF().c(this.lpV);
        azE();
        this.lpW = new 8(this);
        com.tencent.mm.sdk.b.a.xef.b(this.lpW);
        this.hGD = /* anonymous class already generated */;
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.hGD, intentFilter);
        b.a(new c(this), new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
        str = "MicroMsg.SubCoreDBBackup";
        str4 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        objArr = new Object[3];
        if (this.lpM) {
        }
        objArr[0] = this.lpM ? "disabled" : "enabled";
        if (this.hGF) {
        }
        objArr[1] = this.hGF ? " not" : "";
        if (this.hGE) {
        }
        objArr[2] = this.hGE ? " not" : "";
        x.i(str, str4, objArr);
        readLine = ckV.getPath() + ".sm";
        str = readLine + ".tmp";
        file = new File(readLine);
        if (file.isFile()) {
            nanoTime = System.nanoTime();
            append = new StringBuilder().append(q.yE());
            ar.Hg();
            z2 = MasterInfo.save(ckV, str, g.t(append.append(com.tencent.mm.z.c.Cg()).toString().getBytes()));
            file2 = new File(str);
            if (z2) {
                file.delete();
                z2 = file2.renameTo(file);
            } else {
                file2.delete();
            }
            nanoTime2 = System.nanoTime() - nanoTime;
            str2 = "MicroMsg.SubCoreDBBackup";
            str3 = "Master table backup %s, elapsed %.3f";
            objArr2 = new Object[2];
            if (z2) {
                str = "SUCCEEDED";
            } else {
                str = "FAILED";
            }
            objArr2[0] = str;
            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
            x.i(str2, str3, objArr2);
            gVar = com.tencent.mm.plugin.report.service.g.pQN;
            if (z2) {
                nanoTime2 = 24;
            } else {
                nanoTime2 = 25;
            }
            gVar.a(181, nanoTime2, 1, false);
        }
        ar.Dm().g(new 6(this, com.tencent.mm.z.c.FB()), 60000);
    }

    public final void br(boolean z) {
    }

    public final void onAccountRelease() {
        azD();
        this.lpL = false;
        if (this.hGH != null) {
            ar.Dm().cfF().removeCallbacks(this.hGH);
            this.hGH = null;
        }
        if (this.lpW != null) {
            com.tencent.mm.sdk.b.a.xef.c(this.lpW);
            this.lpW = null;
        }
        if (this.hGD != null) {
            ac.getContext().unregisterReceiver(this.hGD);
            this.hGD = null;
        }
        b.D(new String[]{"//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status"});
        if (this.lpU != null && this.lpT != null && this.lpT.length() > 0) {
            this.lpU.unlock();
            this.lpU = null;
            new File(this.lpT).delete();
            this.lpT = null;
            x.i("MicroMsg.DuplicateDetect", "Instance exited.");
        }
    }

    private static void azE() {
        com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100274");
        if (fn.isValid()) {
            Map chI = fn.chI();
            Map hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(bh.getInt((String) chI.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(bh.getInt((String) chI.get("acp"), 100)));
            f.aw(hashMap);
        }
    }

    static void azF() {
        com.tencent.mm.plugin.messenger.foundation.a.a.c Fa = com.tencent.mm.z.c.Fa();
        Fa.aZm();
        Fa.aZo();
        Fa.aZn();
        com.tencent.mm.z.c.Fd().ciC();
        o.Pw().Pg();
        t CU = com.tencent.mm.z.c.CU();
        CU.a(w.a.xny, Integer.valueOf(0));
        CU.a(w.a.xnz, Integer.valueOf(0));
        CU.a(w.a.xnA, Integer.valueOf(0));
    }

    public static void ct(Context context) {
        MMAppMgr.b(context, true);
    }

    public static void azG() {
        MMAppMgr.lW(true);
    }
}
