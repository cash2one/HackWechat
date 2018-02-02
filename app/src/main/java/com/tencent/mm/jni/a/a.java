package com.tencent.mm.jni.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.g.a.nj;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    private static SparseArray<b> gOf = new SparseArray();
    private static final byte[] gOg = new byte[0];
    private static af mHandler = new af(Looper.getMainLooper());

    private static class a implements Runnable {
        private WakerLock gOh = null;

        public a(WakerLock wakerLock) {
            this.gOh = wakerLock;
        }

        public final void run() {
            synchronized (a.gOg) {
                b bVar = (b) a.gOf.get(this.gOh.hashCode());
                if (bVar != null) {
                    String str = "MicroMsg.WakeLockManager";
                    String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(this.gOh.hashCode());
                    objArr[1] = Integer.valueOf(this.gOh.innerWakeLockHashCode());
                    objArr[2] = this.gOh.getCreatePosStackLine();
                    Collection<a> values = bVar.gOk.values();
                    StringBuilder stringBuilder = new StringBuilder();
                    Object obj = 1;
                    for (a aVar : values) {
                        if (obj != null) {
                            obj = null;
                        } else {
                            stringBuilder.append(',');
                        }
                        if (aVar.gOm != 0) {
                            stringBuilder.append('{').append(aVar.gOl).append(',').append(SystemClock.elapsedRealtime() - aVar.gOm).append('}');
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append("<empty>");
                    }
                    objArr[3] = stringBuilder.toString();
                    x.w(str, str2, objArr);
                } else {
                    x.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.gOh.hashCode()), Integer.valueOf(this.gOh.innerWakeLockHashCode()), this.gOh.getCreatePosStackLine(), "#lost-trace-state#");
                }
                this.gOh.unLock();
            }
        }
    }

    private static class b {
        volatile boolean gOi = false;
        a gOj = null;
        Map<String, a> gOk = new HashMap();

        private static class a {
            public String gOl = null;
            public long gOm = 0;

            public a(String str, long j) {
                this.gOl = str;
                this.gOm = j;
            }
        }

        public b(WakerLock wakerLock) {
            this.gOj = new a(wakerLock);
        }
    }

    private static class c {
        private static long fgG = 0;
        private static int gOn = 0;
        private static long gOo = 0;
        private static HashMap<String, a> gOp = null;
        private static final byte[] gOq = new byte[0];
        private static BroadcastReceiver gOr = null;

        private static class a implements Externalizable {
            public String gOl;
            public String gOs;
            public String gOt;
            public boolean gOu;
            public int gOv;
            public int gOw;
            public long gOx;
            public long gOy;
            public AtomicInteger gOz;

            private a() {
                this.gOs = "";
                this.gOl = "";
                this.gOt = "";
                this.gOu = false;
                this.gOv = 0;
                this.gOw = 0;
                this.gOx = 0;
                this.gOy = 0;
                this.gOz = new AtomicInteger(0);
            }

            public final void readExternal(ObjectInput objectInput) {
                synchronized (c.gOq) {
                    this.gOs = objectInput.readUTF();
                    this.gOl = objectInput.readUTF();
                    this.gOv = objectInput.readInt();
                    this.gOw = objectInput.readInt();
                    this.gOx = objectInput.readLong();
                    this.gOt = "";
                    this.gOu = false;
                    this.gOy = 0;
                    this.gOz = new AtomicInteger(0);
                }
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                synchronized (c.gOq) {
                    objectOutput.writeUTF(this.gOs);
                    objectOutput.writeUTF(this.gOl);
                    objectOutput.writeInt(this.gOv);
                    objectOutput.writeInt(this.gOw);
                    objectOutput.writeLong(this.gOx);
                }
            }
        }

        public static void BR() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            if (gOn == 0) {
                gOn = Process.myPid();
                gOr = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        String action = intent.getAction();
                        if (!bh.ov(action)) {
                            int intExtra = intent.getIntExtra("pid", 0);
                            if (intExtra != 0) {
                                String stringExtra = intent.getStringExtra("processName");
                                if (!bh.ov(stringExtra) && stringExtra.equals(bh.r(ac.getContext(), intExtra))) {
                                    String stringExtra2 = intent.getStringExtra("traceMsg");
                                    long longExtra = intent.getLongExtra("tick", 0);
                                    if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                                        c.b(stringExtra, stringExtra2, longExtra);
                                    } else if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                                        c.c(stringExtra, stringExtra2, longExtra);
                                    }
                                }
                            }
                        }
                    }
                };
                synchronized (gOq) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(new File(ac.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            fgG = objectInputStream3.readLong();
                            gOp = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                fgG = SystemClock.elapsedRealtime();
                                gOp = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                ac.getContext().registerReceiver(gOr, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
                                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ac.Br());
                            } catch (Throwable th2) {
                                objectInputStream2 = objectInputStream;
                                th = th2;
                                if (objectInputStream2 != null) {
                                    try {
                                        objectInputStream2.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                objectInputStream2.close();
                            }
                            throw th;
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        x.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        fgG = SystemClock.elapsedRealtime();
                        gOp = new HashMap();
                        if (objectInputStream != null) {
                            objectInputStream.close();
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        ac.getContext().registerReceiver(gOr, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
                        x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ac.Br());
                    } catch (Throwable th4) {
                        th = th4;
                        if (objectInputStream2 != null) {
                            objectInputStream2.close();
                        }
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                ac.getContext().registerReceiver(gOr, intentFilter, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION, null);
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ac.Br());
            }
        }

        public static void detach() {
            if (gOn > 0) {
                ac.getContext().unregisterReceiver(gOr);
                BT();
                gOn = 0;
                x.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", ac.Br());
            }
        }

        public static void fo(String str) {
            m(str, true);
        }

        public static void fp(String str) {
            m(str, false);
        }

        private static void m(String str, boolean z) {
            int myPid = Process.myPid();
            String Br = ac.Br();
            if (myPid == gOn) {
                if (z) {
                    b(Br, str, SystemClock.elapsedRealtime());
                } else {
                    c(Br, str, SystemClock.elapsedRealtime());
                }
            } else if (z) {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", Br);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                ac.getContext().sendBroadcast(r2, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
            } else {
                r2 = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                r2.putExtra("pid", myPid);
                r2.putExtra("processName", Br);
                r2.putExtra("traceMsg", str);
                r2.putExtra("tick", SystemClock.elapsedRealtime());
                ac.getContext().sendBroadcast(r2, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
            }
        }

        private static void b(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            synchronized (gOq) {
                a aVar = (a) gOp.get(str3);
                if (aVar == null) {
                    aVar = new a();
                    aVar.gOs = str;
                    aVar.gOl = str2;
                    aVar.gOx = 0;
                    aVar.gOv = 0;
                    aVar.gOw = 0;
                    gOp.put(str3, aVar);
                }
                if (aVar.gOz.getAndIncrement() == 0) {
                    aVar.gOy = j;
                    aVar.gOt = an.getNetTypeString(ac.getContext());
                    aVar.gOu = com.tencent.mm.sdk.a.b.foreground;
                }
            }
        }

        private static void c(String str, String str2, long j) {
            String str3 = str + "_" + str2;
            long j2 = 0;
            synchronized (gOq) {
                a aVar = (a) gOp.get(str3);
                if (aVar != null && aVar.gOz.get() > 0) {
                    aVar.gOv++;
                    if (aVar.gOz.decrementAndGet() == 0) {
                        j2 = j - aVar.gOy;
                        aVar.gOx += j2;
                        aVar.gOw++;
                    }
                }
                long j3 = j2;
            }
            BS();
            j2 = SystemClock.elapsedRealtime();
            if (j3 >= 14000 || j2 - gOo >= 3600000) {
                x.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                BT();
                gOo = j2;
            }
        }

        private static void BS() {
            synchronized (gOq) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - fgG >= 21600000) {
                    if (!gOp.isEmpty()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (Entry value : gOp.entrySet()) {
                            a aVar = (a) value.getValue();
                            if (aVar.gOw > 0) {
                                stringBuilder.setLength(0);
                                stringBuilder.append(aVar.gOs).append(',').append(aVar.gOl.replace(",", "##")).append(',').append(aVar.gOw).append(',').append(aVar.gOv).append(',').append(aVar.gOx).append(',').append(aVar.gOu ? 1 : 0).append(',').append(aVar.gOt);
                                String stringBuilder2 = stringBuilder.toString();
                                com.tencent.mm.sdk.b.b njVar = new nj();
                                njVar.fFs.fFt = stringBuilder2;
                                com.tencent.mm.sdk.b.a.xef.m(njVar);
                                x.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                            }
                        }
                        gOp.clear();
                    }
                    fgG = elapsedRealtime;
                }
            }
        }

        private static void BT() {
            Throwable e;
            synchronized (gOq) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    File file = new File(ac.getContext().getCacheDir(), "wakelock");
                    if (FileOp.mh(file.getAbsolutePath())) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(file, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(fgG);
                            objectOutputStream2.writeObject(gOp);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e5) {
                                    }
                                }
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                                objectOutputStream.close();
                            }
                            throw e;
                        }
                    } else {
                        throw new IOException("failed to call FileOp.mkdirs(" + file.getAbsolutePath() + ")");
                    }
                } catch (IOException e6) {
                    e = e6;
                    x.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                }
            }
        }
    }

    public static void BN() {
        c.BR();
    }

    public static void BO() {
        c.detach();
    }

    public static void a(WakerLock wakerLock, String str) {
        synchronized (gOg) {
            b bVar = (b) gOf.get(wakerLock.hashCode());
            if (bVar == null) {
                bVar = new b(wakerLock);
                gOf.put(wakerLock.hashCode(), bVar);
            }
            if (!bVar.gOk.containsKey(str)) {
                bVar.gOk.put(str, new a(str, SystemClock.elapsedRealtime()));
            }
            c.fo(str);
            af afVar = mHandler;
            if (!bVar.gOi) {
                bVar.gOi = true;
                afVar.postDelayed(bVar.gOj, 60000);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        synchronized (gOg) {
            b bVar = (b) gOf.get(wakerLock.hashCode());
            if (bVar != null) {
                af afVar = mHandler;
                if (bVar.gOi) {
                    bVar.gOi = false;
                    afVar.removeCallbacks(bVar.gOj);
                }
                for (a aVar : bVar.gOk.values()) {
                    c.fp(aVar.gOl);
                }
                bVar.gOk.clear();
            }
        }
    }
}
