package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.database.SQLiteDoneException;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class a extends AsyncTask<Void, Integer, Integer> {
    private static final String[] CONFLICT_VALUES = new String[]{"", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE"};
    private static final SQLiteCipherSpec lqx = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private String lqA;
    private String lqB;
    private String lqC;
    private List<String> lqD;
    private List<String> lqE;
    private byte[] lqF;
    private byte[] lqG;
    private boolean lqH;
    private b lqI;
    private boolean lqJ;
    private int lqK;
    private long lqL;
    private long lqM;
    private SQLiteDatabase lqy;
    private String lqz;
    public final CancellationSignal mCancellationSignal;

    public static class a {
        public String lqA;
        public String lqB;
        public String lqC;
        public List<String> lqD = new ArrayList();
        public List<String> lqE = new ArrayList();
        public byte[] lqF;
        public byte[] lqG;
        public boolean lqH;
        public b lqI;
        public String lqz;

        public final a xy(String str) {
            this.lqD.add(str);
            return this;
        }

        public final a xz(String str) {
            this.lqE.add(str);
            return this;
        }
    }

    public interface b {
        void I(int i, int i2, int i3);

        void afG();

        void azB();

        void onSuccess();

        void p(long j, long j2);
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        return azJ();
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        if (this.lqI != null) {
            switch (num.intValue()) {
                case -2:
                    this.lqI.p(this.lqM, this.lqL);
                    return;
                case 0:
                    this.lqI.onSuccess();
                    return;
                case 1:
                    this.lqI.azB();
                    return;
                default:
                    this.lqI.afG();
                    return;
            }
        }
    }

    protected final /* synthetic */ void onProgressUpdate(Object[] objArr) {
        int i = 0;
        Integer[] numArr = (Integer[]) objArr;
        if (this.lqI != null) {
            int intValue = numArr.length > 0 ? numArr[0].intValue() : 0;
            int intValue2 = numArr.length >= 2 ? numArr[1].intValue() : 0;
            if (numArr.length >= 3) {
                i = numArr[2].intValue();
            }
            this.lqI.I(intValue, intValue2, i);
        }
    }

    private a() {
        this.mCancellationSignal = new CancellationSignal();
    }

    private Integer azJ() {
        Integer valueOf;
        long uptimeMillis;
        int azL;
        Throwable th;
        ov(54);
        int i = -1;
        WakeLock newWakeLock = ((PowerManager) ac.getContext().getSystemService("power")).newWakeLock(1, "DBRecovery");
        long uptimeMillis2 = SystemClock.uptimeMillis();
        newWakeLock.acquire(1800000);
        try {
            publishProgress(new Integer[]{Integer.valueOf(1)});
            i = azK();
            if (i != 0) {
                valueOf = Integer.valueOf(i);
                switch (i) {
                    case -2:
                        ov(58);
                        break;
                    case 0:
                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                        ov(55);
                        d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                        break;
                    case 1:
                        ov(56);
                        break;
                    default:
                        ov(57);
                        break;
                }
                newWakeLock.release();
            } else {
                azL = azL();
                try {
                    publishProgress(new Integer[]{Integer.valueOf(2)});
                    i = azM();
                    if (i == 1) {
                        valueOf = Integer.valueOf(i);
                        switch (i) {
                            case -2:
                                ov(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ov(55);
                                d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                ov(56);
                                break;
                            default:
                                ov(57);
                                break;
                        }
                        newWakeLock.release();
                    } else {
                        if (i == -1) {
                            publishProgress(new Integer[]{Integer.valueOf(4)});
                            azL = azN();
                        } else {
                            azL = i;
                        }
                        if (azL == 0) {
                            publishProgress(new Integer[]{Integer.valueOf(5)});
                            i = azO();
                        } else {
                            i = azL;
                        }
                        if (i != 0) {
                            if (!this.lqH) {
                                valueOf = Integer.valueOf(i);
                                switch (i) {
                                    case -2:
                                        ov(58);
                                        break;
                                    case 0:
                                        uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                        ov(55);
                                        d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                        break;
                                    case 1:
                                        ov(56);
                                        break;
                                    default:
                                        ov(57);
                                        break;
                                }
                                newWakeLock.release();
                            }
                        }
                        publishProgress(new Integer[]{Integer.valueOf(6)});
                        i = eo(true);
                        valueOf = Integer.valueOf(i);
                        switch (i) {
                            case -2:
                                ov(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ov(55);
                                d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                ov(56);
                                break;
                            default:
                                ov(57);
                                break;
                        }
                        newWakeLock.release();
                    }
                } catch (OperationCanceledException e) {
                    try {
                        x.i("MicroMsg.DBRecoveryTask", "Recovery cancelled.");
                        eo(false);
                        try {
                            valueOf = Integer.valueOf(1);
                            ov(56);
                            newWakeLock.release();
                            return valueOf;
                        } catch (Throwable th2) {
                            th = th2;
                            i = 1;
                            switch (i) {
                                case -2:
                                    ov(58);
                                    break;
                                case 0:
                                    uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                    ov(55);
                                    d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                    break;
                                case 1:
                                    ov(56);
                                    break;
                                default:
                                    ov(57);
                                    break;
                            }
                            newWakeLock.release();
                            throw th;
                        }
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        i = azL;
                        th = th4;
                        switch (i) {
                            case -2:
                                ov(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ov(55);
                                d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                ov(56);
                                break;
                            default:
                                ov(57);
                                break;
                        }
                        newWakeLock.release();
                        throw th;
                    }
                } catch (Exception e2) {
                    i = azL;
                    try {
                        eo(false);
                        i = -1;
                        valueOf = Integer.valueOf(-1);
                        ov(57);
                        newWakeLock.release();
                        return valueOf;
                    } catch (Throwable th5) {
                        th = th5;
                        switch (i) {
                            case -2:
                                ov(58);
                                break;
                            case 0:
                                uptimeMillis = SystemClock.uptimeMillis() - uptimeMillis2;
                                ov(55);
                                d.pPH.a(181, 60, (uptimeMillis / 1000) + 1, true);
                                break;
                            case 1:
                                ov(56);
                                break;
                            default:
                                ov(57);
                                break;
                        }
                        newWakeLock.release();
                        throw th;
                    }
                }
            }
        } catch (OperationCanceledException e3) {
            azL = i;
            x.i("MicroMsg.DBRecoveryTask", "Recovery cancelled.");
            eo(false);
            valueOf = Integer.valueOf(1);
            ov(56);
            newWakeLock.release();
            return valueOf;
        } catch (Exception e4) {
            eo(false);
            i = -1;
            valueOf = Integer.valueOf(-1);
            ov(57);
            newWakeLock.release();
            return valueOf;
        }
        return valueOf;
    }

    private int azK() {
        long j = 0;
        x.i("MicroMsg.DBRecoveryTask", "Load and check database statistics.");
        if (this.lqz == null || this.lqz.isEmpty()) {
            return -1;
        }
        long j2;
        this.lqJ = false;
        this.lqK = 300000;
        if (this.lqC != null) {
            try {
                JSONObject jSONObject = new JSONObject(FileOp.bT(this.lqC));
                this.lqK = jSONObject.getInt("message");
                this.lqJ = true;
                j2 = jSONObject.getLong("dbSize");
            } catch (FileNotFoundException e) {
                x.i("MicroMsg.DBRecoveryTask", "Statistics file not found: " + this.lqC);
                j2 = 0;
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.DBRecoveryTask", e2, "Cannot read statistics from file.", new Object[0]);
            }
            if (this.lqB != null) {
                j = FileOp.me(this.lqB);
            }
            this.lqL = Math.max(j2, j);
            this.lqL += Math.max(this.lqL / 10, 67108864);
            this.lqM = xx(this.lqz);
            if (this.lqL <= this.lqM) {
                x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[]{Long.valueOf(this.lqL), Long.valueOf(this.lqM)});
                return -2;
            }
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[]{Long.valueOf(this.lqL), Long.valueOf(this.lqM), Integer.valueOf(this.lqK)});
            return 0;
        }
        j2 = 0;
        if (this.lqB != null) {
            j = FileOp.me(this.lqB);
        }
        this.lqL = Math.max(j2, j);
        this.lqL += Math.max(this.lqL / 10, 67108864);
        this.lqM = xx(this.lqz);
        if (this.lqL <= this.lqM) {
            x.i("MicroMsg.DBRecoveryTask", "Statistics check OK, required space: %d, available space %d, message count: %d", new Object[]{Long.valueOf(this.lqL), Long.valueOf(this.lqM), Integer.valueOf(this.lqK)});
            return 0;
        }
        x.e("MicroMsg.DBRecoveryTask", "Space not enough for recovery (%d required, %d available)", new Object[]{Long.valueOf(this.lqL), Long.valueOf(this.lqM)});
        return -2;
    }

    private int azL() {
        if (this.lqy != null) {
            if (this.lqy.isOpen()) {
                this.lqy.close();
            }
            this.lqy = null;
        }
        this.mCancellationSignal.throwIfCanceled();
        String str = this.lqz + '-' + bh.Dg(6);
        x.i("MicroMsg.DBRecoveryTask", "Open target database: " + str);
        try {
            this.lqy = SQLiteDatabase.openOrCreateDatabase(str, this.lqG, lqx, null, null, 1);
            DatabaseUtils.stringForQuery(this.lqy, "PRAGMA journal_mode=OFF;", null);
            this.lqy.execSQL("PRAGMA synchronous=OFF;");
            return 0;
        } catch (Throwable e) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", new Object[]{str, e.getMessage()});
            a(1, "Cannot open target database", e);
            throw e;
        }
    }

    private int eo(boolean z) {
        x.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.lqz);
        if (this.lqy == null) {
            return -1;
        }
        File file = new File(this.lqy.getPath());
        if (this.lqy.isOpen()) {
            this.lqy.close();
        }
        if (!z) {
            x.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", new Object[]{file});
            file.delete();
        } else if (!file.renameTo(new File(this.lqz))) {
            x.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", new Object[]{file, this.lqz});
            return -1;
        }
        return 0;
    }

    private int azM() {
        MasterInfo masterInfo;
        boolean z;
        RepairKit repairKit;
        OperationCanceledException e;
        Throwable th;
        RepairKit repairKit2 = null;
        this.mCancellationSignal.throwIfCanceled();
        String[] strArr = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "rconversation"};
        MasterInfo masterInfo2 = null;
        for (String str : this.lqD) {
            try {
                masterInfo2 = MasterInfo.load(str, this.lqF, strArr);
                x.i("MicroMsg.DBRecoveryTask", "Loaded saved master: " + str);
                masterInfo = masterInfo2;
                break;
            } catch (Exception e2) {
                Exception exception = e2;
                masterInfo = masterInfo2;
                x.e("MicroMsg.DBRecoveryTask", "Failed to load saved master: " + exception.getMessage());
                masterInfo2 = masterInfo;
            }
        }
        masterInfo = masterInfo2;
        if (masterInfo == null) {
            masterInfo = MasterInfo.make(strArr);
            x.w("MicroMsg.DBRecoveryTask", "Saved master not available.");
            z = false;
        } else {
            x.i("MicroMsg.DBRecoveryTask", "Use backup saved master.");
            z = true;
        }
        int[] iArr = new int[]{0};
        try {
            x.i("MicroMsg.DBRecoveryTask", "Begin repair: " + this.lqB);
            repairKit = new RepairKit(this.lqB, this.lqG, lqx, masterInfo);
            try {
                repairKit.setCallback(new 1(this, iArr));
                int output = repairKit.output(this.lqy, 0, this.mCancellationSignal);
                if (output == 0) {
                    if (repairKit.isHeaderCorrupted() && repairKit.isDataCorrupted()) {
                        throw new RuntimeException("No data is successfully recovered.");
                    }
                    x.i("MicroMsg.DBRecoveryTask", "Repair succeeded.");
                } else if (output == 1) {
                    x.i("MicroMsg.DBRecoveryTask", "Repair cancelled.");
                    this.mCancellationSignal.throwIfCanceled();
                } else {
                    throw new RuntimeException("Repair failed.");
                }
                if (this.lqJ && ((float) iArr[0]) / ((float) this.lqK) <= DownloadHelper.SAVE_FATOR) {
                    d.pPH.a(181, 181, 62, 63, this.lqK, iArr[0], true);
                }
                repairKit.release();
                return output;
            } catch (OperationCanceledException e3) {
                e = e3;
                repairKit2 = repairKit;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                    repairKit = repairKit2;
                }
            } catch (RuntimeException e4) {
                th = e4;
                try {
                    x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + th.getMessage());
                    a(2, "Failed to repair database => sm: " + z, th);
                    if (repairKit != null) {
                        repairKit.release();
                    }
                    return -1;
                } catch (Throwable th3) {
                    th = th3;
                    if (repairKit != null) {
                        repairKit.release();
                    }
                    throw th;
                }
            }
        } catch (OperationCanceledException e5) {
            e = e5;
            throw e;
        } catch (RuntimeException e6) {
            th = e6;
            repairKit = null;
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + th.getMessage());
            a(2, "Failed to repair database => sm: " + z, th);
            if (repairKit != null) {
                repairKit.release();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            repairKit = null;
            if (repairKit != null) {
                repairKit.release();
            }
            throw th;
        }
    }

    private int azN() {
        Exception exception;
        RecoverKit recoverKit;
        this.mCancellationSignal.throwIfCanceled();
        x.i("MicroMsg.DBRecoveryTask", "Begin backup recovery.");
        RecoverKit recoverKit2 = null;
        for (String str : this.lqE) {
            try {
                RecoverKit recoverKit3 = new RecoverKit(this.lqy, str, this.lqF);
                try {
                    x.i("MicroMsg.DBRecoveryTask", "Loaded backup data: " + str);
                    recoverKit2 = recoverKit3;
                } catch (Exception e) {
                    exception = e;
                    recoverKit = recoverKit3;
                    x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                    recoverKit2 = recoverKit;
                }
            } catch (Exception e2) {
                Exception exception2 = e2;
                recoverKit = recoverKit2;
                exception = exception2;
                x.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + exception.getMessage());
                recoverKit2 = recoverKit;
            }
        }
        if (recoverKit2 == null) {
            return -1;
        }
        try {
            int run = recoverKit2.run(false, this.mCancellationSignal);
            if (run == 0) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery succeeded.");
            } else if (run == 1) {
                x.i("MicroMsg.DBRecoveryTask", "Backup recovery cancelled.");
                this.mCancellationSignal.throwIfCanceled();
            } else {
                x.e("MicroMsg.DBRecoveryTask", "Backup recovery failed.");
            }
            recoverKit2.release();
            return run;
        } catch (OperationCanceledException e3) {
            throw e3;
        } catch (Throwable e4) {
            x.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e4.getMessage());
            a(4, "Failed to recover backup database", e4);
            recoverKit2.release();
            return -1;
        } catch (Throwable th) {
            recoverKit2.release();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int azO() {
        SQLiteDatabase openDatabase;
        OperationCanceledException e;
        Object obj;
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        if (this.lqA == null || this.lqA.isEmpty()) {
            return 0;
        }
        x.i("MicroMsg.DBRecoveryTask", "Begin merging old database.");
        try {
            int longForQuery = (int) DatabaseUtils.longForQuery(this.lqy, "SELECT count(*) FROM message;", null);
            long[] jArr = new long[]{DatabaseUtils.longForQuery(this.lqy, "SELECT max(msgId) FROM message;", null) + 1};
            if (jArr[0] > 1000000 && jArr[0] <= 10000000) {
                jArr[0] = 10000001;
            }
            HashMap hashMap = new HashMap(Math.max(longForQuery + (longForQuery / 2), 10240));
            openDatabase = SQLiteDatabase.openDatabase(this.lqA, this.lqG, lqx, null, 1, new 2(this), 1);
            try {
                a(openDatabase, "userinfo", 0, false, 0, null);
                this.lqy.beginTransaction();
                Object[] objArr = new Object[]{Integer.valueOf(8197), Integer.valueOf(3), ""};
                this.lqy.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(15);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "0";
                this.lqy.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                objArr[0] = Integer.valueOf(89);
                objArr[1] = Integer.valueOf(1);
                objArr[2] = "1";
                this.lqy.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                Cursor rawQueryWithFactory = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"2"}, "userinfo");
                try {
                    if (rawQueryWithFactory.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory.getInt(1));
                        objArr[2] = rawQueryWithFactory.getString(2);
                        this.lqy.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory.close();
                    rawQueryWithFactory = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT id,type,value FROM userinfo WHERE id=?", new String[]{"9"}, "userinfo");
                    if (rawQueryWithFactory.moveToFirst()) {
                        objArr[0] = Integer.valueOf(rawQueryWithFactory.getInt(0));
                        objArr[1] = Integer.valueOf(rawQueryWithFactory.getInt(1));
                        objArr[2] = rawQueryWithFactory.getString(2);
                        this.lqy.execSQL("INSERT OR REPLACE INTO userinfo (id,type,value) VALUES (?,?,?)", objArr);
                    }
                    rawQueryWithFactory.close();
                    this.lqy.setTransactionSuccessful();
                    this.lqy.endTransaction();
                    cursor2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM message LIMIT 0;", null, "message");
                    longForQuery = cursor2.getColumnIndexOrThrow("msgId");
                    cursor2.close();
                    a(openDatabase, "message", 4, true, 5, new 3(this, longForQuery, jArr, hashMap));
                    a(openDatabase, "rconversation", 5, true, 0, null);
                    cursor2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM ImgInfo2 LIMIT 0;", null, "ImgInfo2");
                    longForQuery = cursor2.getColumnIndexOrThrow("msglocalid");
                    cursor2.close();
                    a(openDatabase, "ImgInfo2", 4, true, 0, new 4(this, longForQuery, hashMap));
                    cursor2 = openDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM videoinfo2 LIMIT 0;", null, "videoinfo2");
                    longForQuery = cursor2.getColumnIndexOrThrow("msglocalid");
                    cursor2.close();
                    a(openDatabase, "videoinfo2", 4, true, 0, new 5(this, longForQuery, hashMap));
                    if (!(cursor2 == null || cursor2.isClosed())) {
                        cursor2.close();
                    }
                    if (this.lqy.inTransaction()) {
                        this.lqy.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    return 0;
                } catch (OperationCanceledException e2) {
                    e = e2;
                    obj = openDatabase;
                    cursor = rawQueryWithFactory;
                    try {
                        x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                        throw e;
                    } catch (Throwable th2) {
                        th = th2;
                        Cursor cursor3 = cursor;
                        openDatabase = cursor2;
                        cursor2 = cursor3;
                        cursor2.close();
                        if (this.lqy.inTransaction()) {
                            this.lqy.endTransaction();
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    th = e3;
                    cursor2 = rawQueryWithFactory;
                    try {
                        x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
                        a(5, "Message migration failed, ignorable: " + this.lqH, th);
                        if (!(cursor2 == null || cursor2.isClosed())) {
                            cursor2.close();
                        }
                        if (this.lqy.inTransaction()) {
                            this.lqy.endTransaction();
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        return -1;
                    } catch (Throwable th3) {
                        th = th3;
                        cursor2.close();
                        if (this.lqy.inTransaction()) {
                            this.lqy.endTransaction();
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor2 = rawQueryWithFactory;
                    if (!(cursor2 == null || cursor2.isClosed())) {
                        cursor2.close();
                    }
                    if (this.lqy.inTransaction()) {
                        this.lqy.endTransaction();
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    throw th;
                }
            } catch (OperationCanceledException e4) {
                e = e4;
                obj = openDatabase;
                cursor = null;
                x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
                throw e;
            } catch (Exception e5) {
                th = e5;
                x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
                a(5, "Message migration failed, ignorable: " + this.lqH, th);
                cursor2.close();
                if (this.lqy.inTransaction()) {
                    this.lqy.endTransaction();
                }
                if (openDatabase != null) {
                    openDatabase.close();
                }
                return -1;
            }
        } catch (OperationCanceledException e6) {
            e = e6;
            cursor = null;
            x.i("MicroMsg.DBRecoveryTask", "Message migration cancelled.");
            throw e;
        } catch (Exception e7) {
            th = e7;
            openDatabase = null;
            x.e("MicroMsg.DBRecoveryTask", "Message migration failed: " + th.getMessage());
            a(5, "Message migration failed, ignorable: " + this.lqH, th);
            cursor2.close();
            if (this.lqy.inTransaction()) {
                this.lqy.endTransaction();
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            return -1;
        } catch (Throwable th5) {
            th = th5;
            openDatabase = null;
            cursor2.close();
            if (this.lqy.inTransaction()) {
                this.lqy.endTransaction();
            }
            if (openDatabase != null) {
                openDatabase.close();
            }
            throw th;
        }
    }

    private int a(SQLiteDatabase sQLiteDatabase, String str, int i, boolean z, int i2, c cVar) {
        Cursor rawQueryWithFactory;
        Throwable th;
        SQLiteStatement compileStatement;
        try {
            String stringForQuery = DatabaseUtils.stringForQuery(sQLiteDatabase, "SELECT sql FROM sqlite_master WHERE name = ?", new String[]{str});
            if (stringForQuery == null || stringForQuery.isEmpty()) {
                throw new SQLiteDoneException();
            }
            this.lqy.execSQL(stringForQuery.replaceFirst("(?i)^CREATE TABLE (?!IF NOT EXISTS )", "CREATE TABLE IF NOT EXISTS "), null, this.mCancellationSignal);
            if (z) {
                int longForQuery = (int) DatabaseUtils.longForQuery(sQLiteDatabase, "SELECT count(*) FROM " + str, null);
                rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT * FROM " + str, null, str, this.mCancellationSignal);
                try {
                    int i3;
                    int i4;
                    String[] columnNames = rawQueryWithFactory.getColumnNames();
                    StringBuilder stringBuilder = new StringBuilder(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    stringBuilder.append("INSERT").append(CONFLICT_VALUES[i]).append(" INTO ").append(str).append(" (");
                    for (String append : columnNames) {
                        stringBuilder.append(append).append(',');
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    stringBuilder.append(" VALUES (");
                    for (i3 = 0; i3 < columnNames.length; i3++) {
                        stringBuilder.append("?,");
                    }
                    stringBuilder.setCharAt(stringBuilder.length() - 1, ')');
                    compileStatement = this.lqy.compileStatement(stringBuilder.toString());
                    i3 = 0;
                    try {
                        this.lqy.beginTransaction();
                        while (rawQueryWithFactory.moveToNext()) {
                            if (i3 % WXMediaMessage.DESCRIPTION_LENGTH_LIMIT == 0 && i2 != 0) {
                                publishProgress(new Integer[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(longForQuery)});
                            }
                            compileStatement.clearBindings();
                            for (i4 = 0; i4 < columnNames.length; i4++) {
                                switch (rawQueryWithFactory.getType(i4)) {
                                    case 0:
                                        compileStatement.bindNull(i4 + 1);
                                        break;
                                    case 1:
                                        compileStatement.bindLong(i4 + 1, rawQueryWithFactory.getLong(i4));
                                        break;
                                    case 2:
                                        compileStatement.bindDouble(i4 + 1, rawQueryWithFactory.getDouble(i4));
                                        break;
                                    case 3:
                                        compileStatement.bindString(i4 + 1, rawQueryWithFactory.getString(i4));
                                        break;
                                    case 4:
                                        compileStatement.bindBlob(i4 + 1, rawQueryWithFactory.getBlob(i4));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            if (cVar != null) {
                                cVar.a(rawQueryWithFactory, compileStatement);
                            }
                            compileStatement.executeInsert(this.mCancellationSignal);
                            i3++;
                        }
                        this.lqy.setTransactionSuccessful();
                        if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                            rawQueryWithFactory.close();
                        }
                        if (this.lqy.inTransaction()) {
                            this.lqy.endTransaction();
                        }
                        if (compileStatement == null) {
                            return i3;
                        }
                        compileStatement.close();
                        return i3;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    compileStatement = null;
                    if (!(rawQueryWithFactory == null || rawQueryWithFactory.isClosed())) {
                        rawQueryWithFactory.close();
                    }
                    if (this.lqy.inTransaction()) {
                        this.lqy.endTransaction();
                    }
                    if (compileStatement != null) {
                        compileStatement.close();
                    }
                    throw th;
                }
            }
            if (this.lqy.inTransaction()) {
                this.lqy.endTransaction();
            }
            return 0;
        } catch (SQLiteDoneException e) {
            x.e("MicroMsg.DBRecoveryTask", "There is no table named '%s' to copy.", new Object[]{str});
            if (this.lqy.inTransaction()) {
                this.lqy.endTransaction();
            }
            return -1;
        } catch (Throwable th4) {
            th = th4;
            compileStatement = null;
            rawQueryWithFactory = null;
            rawQueryWithFactory.close();
            if (this.lqy.inTransaction()) {
                this.lqy.endTransaction();
            }
            if (compileStatement != null) {
                compileStatement.close();
            }
            throw th;
        }
    }

    private static long xx(String str) {
        File file = new File(str);
        do {
            long usableSpace = file.getUsableSpace();
            if (usableSpace > 0) {
                return usableSpace;
            }
            file = file.getParentFile();
        } while (file != null);
        return 0;
    }

    private static void ov(int i) {
        d.pPH.a(181, (long) i, 1, true);
    }

    @SuppressLint({"DefaultLocale"})
    private static void a(int i, String str, Throwable th) {
        d.pPH.c("DBRepairNew", String.format("[Stage: %d] %s%s", new Object[]{Integer.valueOf(i), str, "\n" + bh.i(th)}), null);
    }
}
