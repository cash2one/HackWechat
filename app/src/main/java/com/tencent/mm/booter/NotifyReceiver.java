package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock gxW = null;
    private static WakerLock gyj = null;
    private static Set<Long> gyk = new HashSet();
    private static Lock gyl = new ReentrantLock(false);
    private static byte[] gym = new byte[0];
    private static byte[] gyn = new byte[0];
    private static a gyo;
    private static boolean gyp = true;

    public static class a implements e {
        private static long gyq = 0;

        public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.ae.k r13) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:33:0x00c0 in {2, 9, 23, 26, 31, 32, 35, 37, 38, 39, 42, 53, 57, 60, 62, 64, 65, 67, 69, 71, 73, 74, 78} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r9 = this;
            r0 = r13.hashCode();
            r0 = (long) r0;
            r2 = r13.getType();
            r3 = 268369922; // 0xfff0002 float:2.5144944E-29 double:1.32592359E-315;
            if (r2 != r3) goto L_0x01a4;
        L_0x000e:
            r0 = r13;
            r0 = (com.tencent.mm.modelmulti.h) r0;
            r0 = r0.hFb;
            r2 = r0;
        L_0x0014:
            r0 = com.tencent.mm.booter.NotifyReceiver.gyl;	 Catch:{ all -> 0x00bf }
            r0.lock();	 Catch:{ all -> 0x00bf }
            r1 = com.tencent.mm.booter.NotifyReceiver.gyn;	 Catch:{ all -> 0x00bf }
            monitor-enter(r1);	 Catch:{ all -> 0x00bf }
            r4 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x00bf }
            r5 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";	 Catch:{ all -> 0x00bf }
            r0 = 4;	 Catch:{ all -> 0x00bf }
            r6 = new java.lang.Object[r0];	 Catch:{ all -> 0x00bf }
            r0 = 0;	 Catch:{ all -> 0x00bf }
            r7 = r13.getType();	 Catch:{ all -> 0x00bf }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ all -> 0x00bf }
            r6[r0] = r7;	 Catch:{ all -> 0x00bf }
            r0 = 1;	 Catch:{ all -> 0x00bf }
            r7 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00bf }
            r6[r0] = r7;	 Catch:{ all -> 0x00bf }
            r0 = 2;	 Catch:{ all -> 0x00bf }
            r7 = com.tencent.mm.booter.NotifyReceiver.gyk;	 Catch:{ all -> 0x00bf }
            r8 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00bf }
            r7 = r7.contains(r8);	 Catch:{ all -> 0x00bf }
            r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ all -> 0x00bf }
            r6[r0] = r7;	 Catch:{ all -> 0x00bf }
            r7 = 3;	 Catch:{ all -> 0x00bf }
            r0 = com.tencent.mm.booter.NotifyReceiver.gyj;	 Catch:{ all -> 0x00bf }
            if (r0 == 0) goto L_0x00ba;	 Catch:{ all -> 0x00bf }
        L_0x0055:
            r0 = com.tencent.mm.booter.NotifyReceiver.gyj;	 Catch:{ all -> 0x00bf }
            r0 = r0.isLocking();	 Catch:{ all -> 0x00bf }
        L_0x005d:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x00bf }
            r6[r7] = r0;	 Catch:{ all -> 0x00bf }
            com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ all -> 0x00bf }
            monitor-exit(r1);	 Catch:{ all -> 0x00bf }
            r0 = com.tencent.mm.booter.NotifyReceiver.gyk;	 Catch:{ all -> 0x00bf }
            r1 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x00bf }
            r0.remove(r1);	 Catch:{ all -> 0x00bf }
            r0 = com.tencent.mm.booter.NotifyReceiver.gyl;
            r0.unlock();
        L_0x0079:
            r0 = com.tencent.mm.booter.NotifyReceiver.gyl;	 Catch:{ all -> 0x00cb }
            r0.lock();	 Catch:{ all -> 0x00cb }
            r0 = com.tencent.mm.booter.NotifyReceiver.gyk;	 Catch:{ all -> 0x00cb }
            r0 = r0.isEmpty();	 Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x00d4;	 Catch:{ all -> 0x00cb }
        L_0x008a:
            r1 = com.tencent.mm.booter.NotifyReceiver.gyn;	 Catch:{ all -> 0x00cb }
            monitor-enter(r1);	 Catch:{ all -> 0x00cb }
            r0 = com.tencent.mm.booter.NotifyReceiver.gyj;	 Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x009c;	 Catch:{ all -> 0x00cb }
        L_0x0095:
            r0 = com.tencent.mm.booter.NotifyReceiver.gyj;	 Catch:{ all -> 0x00cb }
            r0.unLock();	 Catch:{ all -> 0x00cb }
        L_0x009c:
            monitor-exit(r1);	 Catch:{ all -> 0x00cb }
            r0 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x00cb }
            r1 = "all scene done, unlock wakelock.";	 Catch:{ all -> 0x00cb }
            com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x00cb }
        L_0x00a6:
            r0 = com.tencent.mm.booter.NotifyReceiver.gyl;
            r0.unlock();
        L_0x00ad:
            r0 = r13.getType();
            switch(r0) {
                case 138: goto L_0x00f0;
                default: goto L_0x00b4;
            };
        L_0x00b4:
            r0 = 7000; // 0x1b58 float:9.809E-42 double:3.4585E-320;
            r9.ax(r0);
            return;
        L_0x00ba:
            r0 = 0;
            goto L_0x005d;
        L_0x00bc:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00bf }
            throw r0;	 Catch:{ all -> 0x00bf }
        L_0x00bf:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gyl;	 Catch:{ Exception -> 0x019e }
            r1.unlock();	 Catch:{ Exception -> 0x019e }
        L_0x00c7:
            throw r0;
        L_0x00c8:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00cb }
            throw r0;	 Catch:{ all -> 0x00cb }
        L_0x00cb:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gyl;	 Catch:{ Exception -> 0x0198 }
            r1.unlock();	 Catch:{ Exception -> 0x0198 }
        L_0x00d3:
            throw r0;
        L_0x00d4:
            r0 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x00cb }
            r1 = "rest %d scene undone, keep wakelock.";	 Catch:{ all -> 0x00cb }
            r2 = 1;	 Catch:{ all -> 0x00cb }
            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x00cb }
            r3 = 0;	 Catch:{ all -> 0x00cb }
            r4 = com.tencent.mm.booter.NotifyReceiver.gyk;	 Catch:{ all -> 0x00cb }
            r4 = r4.size();	 Catch:{ all -> 0x00cb }
            r4 = java.lang.Integer.valueOf(r4);	 Catch:{ all -> 0x00cb }
            r2[r3] = r4;	 Catch:{ all -> 0x00cb }
            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ all -> 0x00cb }
            goto L_0x00a6;
        L_0x00f0:
            r0 = com.tencent.mm.kernel.g.Dh();
            r0 = r0.Cy();
            if (r0 == 0) goto L_0x00b4;
        L_0x00fa:
            r0 = android.os.Looper.myQueue();
            r1 = new com.tencent.mm.booter.NotifyReceiver$a$1;
            r1.<init>(r9);
            r0.addIdleHandler(r1);
            if (r10 != 0) goto L_0x00b4;
        L_0x0108:
            if (r11 != 0) goto L_0x00b4;
        L_0x010a:
            r0 = com.tencent.mm.z.a.EP();
            if (r0 == 0) goto L_0x00b4;
        L_0x0110:
            com.tencent.mm.kernel.g.Dk();	 Catch:{ Throwable -> 0x017f }
            r0 = com.tencent.mm.kernel.g.Dh();	 Catch:{ Throwable -> 0x017f }
            r0 = r0.gPn;	 Catch:{ Throwable -> 0x017f }
            r2 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r4 = -1;	 Catch:{ Throwable -> 0x017f }
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x017f }
            if (r1 <= 0) goto L_0x0128;	 Catch:{ Throwable -> 0x017f }
        L_0x0121:
            r2 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r4 = 1;	 Catch:{ Throwable -> 0x017f }
            r2 = r2 + r4;	 Catch:{ Throwable -> 0x017f }
            r0.hew = r2;	 Catch:{ Throwable -> 0x017f }
        L_0x0128:
            r1 = "MicroMsg.AccInfoCacheInWorker";	 Catch:{ Throwable -> 0x017f }
            r2 = "countNormalCgi :%s ";	 Catch:{ Throwable -> 0x017f }
            r3 = 1;	 Catch:{ Throwable -> 0x017f }
            r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x017f }
            r4 = 0;	 Catch:{ Throwable -> 0x017f }
            r6 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r5 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x017f }
            r3[r4] = r5;	 Catch:{ Throwable -> 0x017f }
            com.tencent.mm.sdk.platformtools.x.i(r1, r2, r3);	 Catch:{ Throwable -> 0x017f }
            r2 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r4 = 2;	 Catch:{ Throwable -> 0x017f }
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x017f }
            if (r1 == 0) goto L_0x014d;	 Catch:{ Throwable -> 0x017f }
        L_0x0145:
            r2 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r4 = 5;	 Catch:{ Throwable -> 0x017f }
            r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x017f }
            if (r1 != 0) goto L_0x00b4;	 Catch:{ Throwable -> 0x017f }
        L_0x014d:
            r1 = com.tencent.mm.plugin.report.d.pPH;	 Catch:{ Throwable -> 0x017f }
            r2 = 226; // 0xe2 float:3.17E-43 double:1.117E-321;	 Catch:{ Throwable -> 0x017f }
            r4 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r6 = 2;	 Catch:{ Throwable -> 0x017f }
            r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));	 Catch:{ Throwable -> 0x017f }
            if (r4 != 0) goto L_0x0195;	 Catch:{ Throwable -> 0x017f }
        L_0x0159:
            r4 = 37;	 Catch:{ Throwable -> 0x017f }
        L_0x015b:
            r6 = 1;	 Catch:{ Throwable -> 0x017f }
            r8 = 0;	 Catch:{ Throwable -> 0x017f }
            r1.a(r2, r4, r6, r8);	 Catch:{ Throwable -> 0x017f }
            r1 = com.tencent.mm.plugin.report.d.pPH;	 Catch:{ Throwable -> 0x017f }
            r2 = 11098; // 0x2b5a float:1.5552E-41 double:5.483E-320;	 Catch:{ Throwable -> 0x017f }
            r3 = 2;	 Catch:{ Throwable -> 0x017f }
            r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x017f }
            r4 = 0;	 Catch:{ Throwable -> 0x017f }
            r5 = 2001; // 0x7d1 float:2.804E-42 double:9.886E-321;	 Catch:{ Throwable -> 0x017f }
            r5 = java.lang.Integer.valueOf(r5);	 Catch:{ Throwable -> 0x017f }
            r3[r4] = r5;	 Catch:{ Throwable -> 0x017f }
            r4 = 1;	 Catch:{ Throwable -> 0x017f }
            r6 = r0.hew;	 Catch:{ Throwable -> 0x017f }
            r0 = java.lang.Long.valueOf(r6);	 Catch:{ Throwable -> 0x017f }
            r3[r4] = r0;	 Catch:{ Throwable -> 0x017f }
            r1.h(r2, r3);	 Catch:{ Throwable -> 0x017f }
            goto L_0x00b4;
        L_0x017f:
            r0 = move-exception;
            r1 = "MicroMsg.AccInfoCacheInWorker";
            r2 = "tryBackupToWorker Exception:%s";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bh.i(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.x.e(r1, r2, r3);
            goto L_0x00b4;
        L_0x0195:
            r4 = 38;
            goto L_0x015b;
        L_0x0198:
            r1 = move-exception;
            goto L_0x00d3;
        L_0x019b:
            r0 = move-exception;
            goto L_0x00ad;
        L_0x019e:
            r1 = move-exception;
            goto L_0x00c7;
        L_0x01a1:
            r0 = move-exception;
            goto L_0x0079;
        L_0x01a4:
            r2 = r0;
            goto L_0x0014;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.NotifyReceiver.a.a(int, int, java.lang.String, com.tencent.mm.ae.k):void");
        }

        static /* synthetic */ void a(a aVar) {
            g.Dk();
            g.Dm().F(new 3(aVar));
        }

        private void ax(long j) {
            if (aa.VJ().getBoolean("is_in_notify_mode", false)) {
                new af(Looper.myLooper()).postDelayed(new 2(this), j);
            }
        }
    }

    public static void wF() {
        x.i("MicroMsg.NotifyReceiver", "markUIShow");
        gyp = false;
        aa.VJ().edit().putBoolean("is_in_notify_mode", false).commit();
    }

    public static void wG() {
        g.CG().b(138, gyo);
        g.CG().b(39, gyo);
        g.CG().b(268369922, gyo);
        if (gyo == null) {
            gyo = new a();
        }
        g.CG().a(138, gyo);
        g.CG().a(39, gyo);
        g.CG().a(268369922, gyo);
    }

    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", new Object[]{intent});
        if (intent != null) {
            if (k.aX(context)) {
                x.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
                return;
            }
            com.tencent.mm.aj.a.hy(intent.getIntExtra("notify_respType", -1));
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            context.startService(intent2);
        }
    }
}
