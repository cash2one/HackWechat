package com.tencent.mm.plugin.fts;

import android.os.Process;
import android.util.Log;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabaseCorruptException;
import com.tencent.wcdb.database.SQLiteDiskIOException;
import com.tencent.wcdb.database.SQLiteException;
import java.util.concurrent.PriorityBlockingQueue;

public final class f implements l {
    a mJj = new a(this);

    private class a extends Thread {
        int mJk = Integer.MAX_VALUE;
        PriorityBlockingQueue<com.tencent.mm.plugin.fts.a.a.a> mJl = new PriorityBlockingQueue();
        volatile boolean mJm = false;
        com.tencent.mm.plugin.fts.a.a.a mJn;
        private boolean mJo;
        Runnable mJp;
        d mJq;
        boolean mJr = false;
        final /* synthetic */ f mJs;
        private int mTid = 0;

        public a(f fVar) {
            this.mJs = fVar;
            super("SearchDaemon");
        }

        final synchronized void qa(int i) {
            if (this.mJk != i && isAlive()) {
                if (i < 0) {
                    if (this.mJk >= 0) {
                        Process.setThreadPriority(this.mTid, -8);
                        this.mJk = i;
                    }
                }
                if (i >= 0) {
                    if (this.mJk < 0) {
                        Process.setThreadPriority(this.mTid, this.mJo ? 10 : 0);
                    }
                }
                this.mJk = i;
            }
        }

        public final synchronized void quit() {
            this.mJm = true;
            interrupt();
        }

        public final synchronized void fo(boolean z) {
            int i = 0;
            synchronized (this) {
                if (this.mJo != z) {
                    this.mJo = z;
                    if (this.mJk >= 0 && isAlive() && this.mTid != 0) {
                        if (this.mJo) {
                            i = 10;
                        }
                        try {
                            Process.setThreadPriority(this.mTid, i);
                            x.i("MicroMsg.FTS.FTSTaskDaemon", "*** Switch priority: " + (this.mJo ? "foreground" : "background"));
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", e, "setLowPriorityMode failed, tid=%d, p=%d", new Object[]{Integer.valueOf(this.mTid), Integer.valueOf(i)});
                        }
                    }
                }
            }
        }

        public final void run() {
            com.tencent.mm.plugin.fts.a.a.a aVar;
            Throwable th;
            Object obj;
            this.mTid = Process.myTid();
            while (true) {
                try {
                    Thread.interrupted();
                    if (this.mJm) {
                        a.aMN();
                        this.mTid = 0;
                        return;
                    }
                    this.mJn = null;
                    com.tencent.mm.plugin.fts.a.a.a aVar2 = (com.tencent.mm.plugin.fts.a.a.a) this.mJl.take();
                    if (aVar2 == null) {
                        a.aMN();
                    } else {
                        try {
                            this.mJn = aVar2;
                            qa(aVar2.getPriority());
                            String name = aVar2.getName();
                            String str;
                            try {
                                String obj2;
                                if (bh.ov(name)) {
                                    obj2 = aVar2.toString();
                                } else {
                                    obj2 = name;
                                }
                                long currentTimeMillis = System.currentTimeMillis();
                                try {
                                    String format;
                                    int size;
                                    aVar2.execute();
                                    aVar2.mLk = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mLk;
                                    e.u(aVar2.getId(), aVar2.mLk);
                                    e.v(aVar2.getId(), aVar2.mLk);
                                    if (((aVar2.mLl & 1) > 0 ? 1 : 0) != 0 && aVar2.mLk > 1000 && aVar2.mLk < 3600000) {
                                        e.u(27, aVar2.mLk);
                                        e.v(27, aVar2.mLk);
                                    }
                                    if (aVar2 instanceof com.tencent.mm.plugin.fts.a.a.f) {
                                        format = String.format("[%s][Request=%s][Result=%s] Done, %dms", new Object[]{obj2, ((com.tencent.mm.plugin.fts.a.a.f) aVar2).mLN.toString(), ((com.tencent.mm.plugin.fts.a.a.f) aVar2).mLO.toString(), Long.valueOf(aVar2.mLk)});
                                        size = r3.mLO.mMc.size();
                                    } else {
                                        format = String.format("[%s] Done, %dms", new Object[]{obj2, Long.valueOf(aVar2.mLk)});
                                        size = 0;
                                    }
                                    e.h(aVar2.getId(), aVar2.mLk, (long) size);
                                    if (aVar2.mLm == null || aVar2.mLm.size() <= 1) {
                                        try {
                                            str = "";
                                        } catch (Throwable e) {
                                            aVar = aVar2;
                                            th = e;
                                            obj = obj2;
                                        }
                                    } else {
                                        StringBuffer stringBuffer = new StringBuffer();
                                        for (int i = 1; i < aVar2.mLm.size(); i++) {
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar3 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mLm.get(i - 1);
                                            com.tencent.mm.plugin.fts.a.a.a.a aVar4 = (com.tencent.mm.plugin.fts.a.a.a.a) aVar2.mLm.get(i);
                                            stringBuffer.append("{");
                                            stringBuffer.append(aVar4.mLo);
                                            stringBuffer.append(":");
                                            stringBuffer.append(aVar4.timestamp - aVar3.timestamp);
                                            stringBuffer.append("}");
                                        }
                                        str = String.format("%s", new Object[]{stringBuffer.toString()});
                                    }
                                    if (bh.ov(str)) {
                                        str = format;
                                    } else {
                                        str = format + " " + str;
                                    }
                                    name = aVar2.ado();
                                    if (!bh.ov(name)) {
                                        str = str + " " + name;
                                    }
                                    x.i("MicroMsg.FTS.FTSTaskDaemon", str);
                                    a.aMN();
                                } catch (Exception e2) {
                                    throw e2;
                                } catch (Throwable th2) {
                                    aVar2.mLk = (System.currentTimeMillis() - currentTimeMillis) + aVar2.mLk;
                                }
                            } catch (Throwable e3) {
                                Throwable th3 = e3;
                                str = name;
                                aVar = aVar2;
                                th = th3;
                                if (aVar == null) {
                                    try {
                                        if (!(th instanceof InterruptedException)) {
                                            if (!aVar.isCancelled()) {
                                                this.mJl.put(aVar);
                                            }
                                            x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", new Object[]{obj, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mLk)});
                                        } else if (!(th instanceof SQLiteDatabaseCorruptException)) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception. \n", new Object[]{obj});
                                            if (this.mJq != null) {
                                                this.mJq.aMQ();
                                            }
                                            e.qb(18);
                                            if (!this.mJr) {
                                                g.pQN.c("FTS", aVar + ": " + Log.getStackTraceString(th), null);
                                                this.mJr = true;
                                            }
                                        } else if (!(th instanceof com.tencent.mm.plugin.fts.a.a.l)) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                            e.qb(6);
                                        } else if (!(th instanceof SQLiteDiskIOException)) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                            e.qb(7);
                                        } else if (!(th instanceof NullPointerException)) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                            e.qb(3);
                                            if (this.mJp != null) {
                                                this.mJp.run();
                                            }
                                        } else if (th instanceof SQLiteException) {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                            e.qb(5);
                                            if (this.mJp != null) {
                                                this.mJp.run();
                                            }
                                        } else {
                                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                            if (th.getMessage() == null) {
                                            }
                                            e.qb(4);
                                            if (this.mJp != null) {
                                                this.mJp.run();
                                            }
                                        }
                                        a.aMN();
                                    } catch (Throwable th4) {
                                        a.aMN();
                                    }
                                } else {
                                    a.aMN();
                                }
                            }
                        } catch (Throwable e32) {
                            aVar = aVar2;
                            th = e32;
                            obj = null;
                            if (aVar == null) {
                                a.aMN();
                            } else {
                                if (!(th instanceof InterruptedException)) {
                                    if (aVar.isCancelled()) {
                                        this.mJl.put(aVar);
                                    }
                                    x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", new Object[]{obj, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mLk)});
                                } else if (!(th instanceof SQLiteDatabaseCorruptException)) {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception. \n", new Object[]{obj});
                                    if (this.mJq != null) {
                                        this.mJq.aMQ();
                                    }
                                    e.qb(18);
                                    if (this.mJr) {
                                        g.pQN.c("FTS", aVar + ": " + Log.getStackTraceString(th), null);
                                        this.mJr = true;
                                    }
                                } else if (!(th instanceof com.tencent.mm.plugin.fts.a.a.l)) {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                    e.qb(6);
                                } else if (!(th instanceof SQLiteDiskIOException)) {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                    e.qb(7);
                                } else if (!(th instanceof NullPointerException)) {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                    e.qb(3);
                                    if (this.mJp != null) {
                                        this.mJp.run();
                                    }
                                } else if (th instanceof SQLiteException) {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                    if (th.getMessage() == null) {
                                    }
                                    e.qb(4);
                                    if (this.mJp != null) {
                                        this.mJp.run();
                                    }
                                } else {
                                    x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                                    e.qb(5);
                                    if (this.mJp != null) {
                                        this.mJp.run();
                                    }
                                }
                                a.aMN();
                            }
                        }
                    }
                } catch (Exception e4) {
                    th = e4;
                    obj = null;
                    aVar = null;
                    if (aVar == null) {
                        a.aMN();
                    } else {
                        if (!(th instanceof InterruptedException)) {
                            if (aVar.isCancelled()) {
                                this.mJl.put(aVar);
                            }
                            x.i("MicroMsg.FTS.FTSTaskDaemon", "[%s][cancelled:%b] interruputed! %dms", new Object[]{obj, Boolean.valueOf(aVar.isCancelled()), Long.valueOf(aVar.mLk)});
                        } else if (!(th instanceof SQLiteDatabaseCorruptException)) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception. \n", new Object[]{obj});
                            if (this.mJq != null) {
                                this.mJq.aMQ();
                            }
                            e.qb(18);
                            if (this.mJr) {
                                g.pQN.c("FTS", aVar + ": " + Log.getStackTraceString(th), null);
                                this.mJr = true;
                            }
                        } else if (!(th instanceof com.tencent.mm.plugin.fts.a.a.l)) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                            e.qb(6);
                        } else if (!(th instanceof SQLiteDiskIOException)) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                            e.qb(7);
                        } else if (!(th instanceof NullPointerException)) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                            e.qb(3);
                            if (this.mJp != null) {
                                this.mJp.run();
                            }
                        } else if (th instanceof SQLiteException) {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                            if (th.getMessage() == null && th.getMessage().contains("the connection is read-only")) {
                                e.qb(17);
                            } else {
                                e.qb(4);
                            }
                            if (this.mJp != null) {
                                this.mJp.run();
                            }
                        } else {
                            x.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", th, "[%s] failed with exception.\n", new Object[]{obj});
                            e.qb(5);
                            if (this.mJp != null) {
                                this.mJp.run();
                            }
                        }
                        a.aMN();
                    }
                }
            }
        }
    }

    public final boolean agj() {
        return this.mJj != null && this.mJj.isAlive();
    }

    public final void quit() {
        if (this.mJj != null && this.mJj.isAlive()) {
            this.mJj.quit();
            try {
                this.mJj.join();
            } catch (InterruptedException e) {
            }
            this.mJj = null;
            x.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(int i, com.tencent.mm.plugin.fts.a.a.a aVar) {
        if (this.mJj == null) {
            return null;
        }
        aVar.mPriority = i;
        a aVar2 = this.mJj;
        if (aVar2.mJm) {
            return aVar;
        }
        int priority = aVar.getPriority();
        aVar2.mJl.put(aVar);
        if (aVar2.mJn == null) {
            aVar2.qa(priority);
            return aVar;
        } else if (priority >= aVar2.mJk) {
            return aVar;
        } else {
            aVar2.interrupt();
            aVar2.qa(priority);
            return aVar;
        }
    }
}
