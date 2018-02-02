package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

public class NotifyReceiver$NotifyService extends Service {
    Boolean gys = null;
    private g gyt;

    public static class InnerService extends Service {
        public void onCreate() {
            super.onCreate();
            try {
                startForeground(-1212, new Notification());
            } catch (NullPointerException e) {
                x.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", new Object[]{e});
            }
            stopSelf();
        }

        public void onDestroy() {
            stopForeground(true);
            super.onDestroy();
        }

        public IBinder onBind(Intent intent) {
            return null;
        }
    }

    private void l(android.content.Intent r14) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:69:0x02ac
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r13 = this;
        r0 = "notify_option_type";
        r1 = 0;
        r2 = r14.getIntExtra(r0, r1);
        if (r2 != 0) goto L_0x0014;
    L_0x000a:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "receiveImp invalid opcode.";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x0013:
        return;
    L_0x0014:
        r0 = com.tencent.mm.kernel.g.Dh();
        r0 = r0.Cy();
        if (r0 == 0) goto L_0x0024;
    L_0x001e:
        r0 = com.tencent.mm.kernel.a.Cs();
        if (r0 == 0) goto L_0x0052;
    L_0x0024:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "receiveImp hasSetuin:%b  isHold:%b  opcode:%d";
        r3 = 3;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = com.tencent.mm.kernel.g.Dh();
        r5 = r5.Cy();
        r5 = java.lang.Boolean.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r5 = com.tencent.mm.kernel.a.Cs();
        r5 = java.lang.Boolean.valueOf(r5);
        r3[r4] = r5;
        r4 = 2;
        r2 = java.lang.Integer.valueOf(r2);
        r3[r4] = r2;
        com.tencent.mm.sdk.platformtools.x.e(r0, r1, r3);
        goto L_0x0013;
    L_0x0052:
        r0 = com.tencent.mm.kernel.g.CG();
        r0 = r0.hmV;
        if (r0 != 0) goto L_0x0075;
    L_0x005a:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "receiveImp  opcode:%d  getDispatcher == null";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r2);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r3);
        r0 = com.tencent.mm.kernel.g.CG();
        r1 = 1;
        r0.bC(r1);
    L_0x0075:
        r0 = r13.gys;
        if (r0 != 0) goto L_0x008a;
    L_0x0079:
        r0 = com.tencent.mm.sdk.a.b.ceK();
        if (r0 == 0) goto L_0x00bd;
    L_0x007f:
        r0 = r13;
    L_0x0080:
        r1 = 0;
        r12 = r1;
        r1 = r0;
        r0 = r12;
    L_0x0084:
        r0 = java.lang.Boolean.valueOf(r0);
        r1.gys = r0;
    L_0x008a:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "handleCommand useOld:%s operationCode:%d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = r13.gys;
        r3[r4] = r5;
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r2);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r3);
        switch(r2) {
            case 1: goto L_0x00ea;
            case 2: goto L_0x017e;
            default: goto L_0x00a5;
        };
    L_0x00a5:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r3 = "invald opCode:";
        r1.<init>(r3);
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x00bd:
        r0 = com.tencent.mm.plugin.zero.b.a.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.a) r0;
        r0 = r0.zY();
        r1 = "AndroidOldNotifyReceiver";
        r0 = r0.getValue(r1);
        r1 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bh.getInt(r0, r1);
        com.tencent.mm.kernel.g.Dk();
        com.tencent.mm.kernel.g.Dh();
        r1 = com.tencent.mm.kernel.a.Cg();
        r3 = 100;
        r1 = com.tencent.mm.a.h.aJ(r1, r3);
        if (r0 <= r1) goto L_0x060d;
    L_0x00e7:
        r0 = 1;
        r1 = r13;
        goto L_0x0084;
    L_0x00ea:
        r0 = r13.gys;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x00fc;
    L_0x00f2:
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();
        r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE";
        r(r0, r1);
    L_0x00fc:
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();
        r1 = "MicroMsg.NotifyReceiver";
        r2 = "dealWithLooper";
        com.tencent.mm.sdk.platformtools.x.i(r1, r2);
        r1 = com.tencent.mm.kernel.g.Dh();
        r1 = r1.Cy();
        if (r1 == 0) goto L_0x0119;
    L_0x0113:
        r1 = com.tencent.mm.kernel.a.Cs();
        if (r1 == 0) goto L_0x0148;
    L_0x0119:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "receiveImp hasSetuin:";
        r1.<init>(r2);
        r2 = com.tencent.mm.kernel.g.Dh();
        r2 = r2.Cy();
        r1 = r1.append(r2);
        r2 = " isHold:";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.kernel.a.Cs();
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.w(r0, r1);
        goto L_0x0013;
    L_0x0148:
        r1 = com.tencent.mm.kernel.g.CG();
        r1 = r1.foreground;
        if (r1 != 0) goto L_0x015b;
    L_0x0150:
        if (r0 == 0) goto L_0x016d;
    L_0x0152:
        r0 = com.tencent.mm.sdk.platformtools.an.isWap(r0);
        if (r0 != 0) goto L_0x016d;
    L_0x0158:
        r0 = 1;
    L_0x0159:
        if (r0 != 0) goto L_0x016f;
    L_0x015b:
        r0 = com.tencent.mm.plugin.zero.b.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;
        r0 = r0.Qc();
        r1 = 2;
        r0.id(r1);
        goto L_0x0013;
    L_0x016d:
        r0 = 0;
        goto L_0x0159;
    L_0x016f:
        r0 = com.tencent.mm.kernel.g.CG();
        r1 = new com.tencent.mm.modelmulti.k;
        r1.<init>();
        r2 = 0;
        r0.a(r1, r2);
        goto L_0x0013;
    L_0x017e:
        r0 = r13.gys;
        r0 = r0.booleanValue();
        if (r0 == 0) goto L_0x0457;
    L_0x0186:
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();
        r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY";
        r(r0, r1);
        r0 = "notify_respType";
        r1 = 0;
        r3 = r14.getIntExtra(r0, r1);
        r0 = "notify_respBuf";
        r4 = r14.getByteArrayExtra(r0);
        r0 = "notify_skey";
        r5 = r14.getByteArrayExtra(r0);
        r0 = "notfiy_recv_time";
        r6 = -1;
        r6 = r14.getLongExtra(r0, r6);
        r1 = "MicroMsg.NotifyReceiver";
        r2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
        r0 = 4;
        r8 = new java.lang.Object[r0];
        r0 = 0;
        r9 = java.lang.Integer.valueOf(r3);
        r8[r0] = r9;
        r0 = 1;
        r9 = java.lang.Long.valueOf(r6);
        r8[r0] = r9;
        r9 = 2;
        if (r4 != 0) goto L_0x01f1;
    L_0x01c9:
        r0 = -1;
    L_0x01ca:
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        r0 = 3;
        r9 = com.tencent.mm.sdk.platformtools.bh.by(r5);
        r9 = com.tencent.mm.sdk.platformtools.bh.VT(r9);
        r8[r0] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r8);
        switch(r3) {
            case 39: goto L_0x03e1;
            case 138: goto L_0x02b4;
            case 268369921: goto L_0x01f3;
            case 1000000205: goto L_0x0347;
            case 2147480001: goto L_0x03f0;
            default: goto L_0x01e1;
        };
    L_0x01e1:
        r0 = com.tencent.mm.plugin.zero.PluginZero.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.zero.PluginZero) r0;
        r1 = r0.vaG;
        r2 = r13;
        r1.a(r2, r3, r4, r5, r6);
        goto L_0x0013;
    L_0x01f1:
        r0 = r4.length;
        goto L_0x01ca;
    L_0x01f3:
        r0 = com.tencent.mm.sdk.platformtools.bh.bw(r5);
        if (r0 == 0) goto L_0x0211;
    L_0x01f9:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "dkpush dealWithNotify session:";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x0211:
        r0 = com.tencent.mm.sdk.platformtools.bh.bw(r4);
        if (r0 != 0) goto L_0x021c;
    L_0x0217:
        r0 = r4.length;
        r1 = 8;
        if (r0 > r1) goto L_0x0227;
    L_0x021c:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "dkpush dealWithNotify respBuf error ";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x0227:
        r0 = 0;
        r0 = com.tencent.mm.a.n.p(r4, r0);
        r1 = 4;
        r1 = com.tencent.mm.a.n.p(r4, r1);
        r2 = r4.length;
        r2 = r2 + -8;
        if (r1 == r2) goto L_0x024f;
    L_0x0236:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "dkpush: respBuf length error len:";
        r1.<init>(r2);
        r2 = r4.length;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x024f:
        r2 = new byte[r1];
        r3 = 8;
        r8 = 0;
        java.lang.System.arraycopy(r4, r3, r2, r8, r1);
        r3 = "MicroMsg.NotifyReceiver";
        r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r0);
        r9[r10] = r11;
        r10 = 1;
        r1 = java.lang.Integer.valueOf(r1);
        r9[r10] = r1;
        r1 = 2;
        r4 = r4.length;
        r4 = java.lang.Integer.valueOf(r4);
        r9[r1] = r4;
        r1 = 3;
        r4 = java.lang.Long.valueOf(r6);
        r9[r1] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r3, r8, r9);
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ all -> 0x02ab }
        r1.lock();	 Catch:{ all -> 0x02ab }
        com.tencent.mm.modelmulti.m.a(r0, r2, r5, r6);	 Catch:{ all -> 0x02ab }
        r0 = com.tencent.mm.booter.NotifyReceiver.wM();	 Catch:{ all -> 0x02ab }
        r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x02ab }
        r0.add(r1);	 Catch:{ all -> 0x02ab }
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ all -> 0x02ab }
        r1 = "NotifyReceiver.NotifyData";	 Catch:{ all -> 0x02ab }
        s(r0, r1);	 Catch:{ all -> 0x02ab }
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();
        r0.unlock();
        goto L_0x0013;
    L_0x02a8:
        r0 = move-exception;
        goto L_0x0013;
    L_0x02ab:
        r0 = move-exception;
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x060a }
        r1.unlock();	 Catch:{ Exception -> 0x060a }
    L_0x02b3:
        throw r0;
    L_0x02b4:
        if (r4 != 0) goto L_0x0332;
    L_0x02b6:
        r0 = 7;
        r2 = r0;
    L_0x02b8:
        if (r4 != 0) goto L_0x0339;
    L_0x02ba:
        r0 = 2;
        r1 = r0;
    L_0x02bc:
        r3 = "MicroMsg.NotifyReceiver";
        r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
        r0 = 3;
        r6 = new java.lang.Object[r0];
        r0 = 0;
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        r0 = 1;
        r7 = java.lang.Integer.valueOf(r1);
        r6[r0] = r7;
        r7 = 2;
        if (r4 != 0) goto L_0x033c;
    L_0x02d6:
        r0 = -1;
    L_0x02d7:
        r0 = java.lang.Integer.valueOf(r0);
        r6[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.d(r3, r5, r6);
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ all -> 0x033e }
        r0.lock();	 Catch:{ all -> 0x033e }
        r0 = com.tencent.mm.plugin.zero.b.b.class;	 Catch:{ all -> 0x033e }
        r0 = com.tencent.mm.kernel.g.h(r0);	 Catch:{ all -> 0x033e }
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;	 Catch:{ all -> 0x033e }
        r0 = r0.Qc();	 Catch:{ all -> 0x033e }
        r2 = (long) r2;	 Catch:{ all -> 0x033e }
        r4 = "";	 Catch:{ all -> 0x033e }
        r0 = r0.a(r2, r1, r4);	 Catch:{ all -> 0x033e }
        if (r0 <= 0) goto L_0x0326;	 Catch:{ all -> 0x033e }
    L_0x02fd:
        r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x033e }
        r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x033e }
        r3 = 1;	 Catch:{ all -> 0x033e }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x033e }
        r4 = 0;	 Catch:{ all -> 0x033e }
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x033e }
        r3[r4] = r5;	 Catch:{ all -> 0x033e }
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);	 Catch:{ all -> 0x033e }
        r1 = com.tencent.mm.booter.NotifyReceiver.wM();	 Catch:{ all -> 0x033e }
        r2 = (long) r0;	 Catch:{ all -> 0x033e }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x033e }
        r1.add(r0);	 Catch:{ all -> 0x033e }
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ all -> 0x033e }
        r1 = "NotifyReceiver.dealWithNotify:MMFunc_NewSync";	 Catch:{ all -> 0x033e }
        s(r0, r1);	 Catch:{ all -> 0x033e }
    L_0x0326:
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();
        r0.unlock();
        goto L_0x0013;
    L_0x032f:
        r0 = move-exception;
        goto L_0x0013;
    L_0x0332:
        r0 = 0;
        r0 = com.tencent.mm.a.n.p(r4, r0);
        r2 = r0;
        goto L_0x02b8;
    L_0x0339:
        r0 = 1;
        r1 = r0;
        goto L_0x02bc;
    L_0x033c:
        r0 = r4.length;
        goto L_0x02d7;
    L_0x033e:
        r0 = move-exception;
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x0607 }
        r1.unlock();	 Catch:{ Exception -> 0x0607 }
    L_0x0346:
        throw r0;
    L_0x0347:
        r1 = "MicroMsg.NotifyReceiver";
        r2 = new java.lang.StringBuilder;
        r0 = "oreh on newsynccheck2 notify, notify=";
        r2.<init>(r0);
        if (r4 == 0) goto L_0x03bd;
    L_0x0354:
        r0 = 1;
    L_0x0355:
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r0);
        r1 = new com.tencent.mm.protocal.aa$b;
        r1.<init>();
        r1.E(r4);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0.lock();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = com.tencent.mm.plugin.zero.b.b.class;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = com.tencent.mm.kernel.g.h(r0);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = r0.Qc();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r2 = r1.vBW;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r4 = 1;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r1 = r1.cdK();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = r0.a(r2, r4, r1);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        if (r0 <= 0) goto L_0x03b1;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
    L_0x0388:
        r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r2 = "add scene hash to memo, hash:%d";	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r3 = 1;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r4 = 0;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r3[r4] = r5;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r1 = com.tencent.mm.booter.NotifyReceiver.wM();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r2 = (long) r0;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r1.add(r0);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r1 = "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP";	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        s(r0, r1);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
    L_0x03b1:
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x03ba }
        r0.unlock();	 Catch:{ Exception -> 0x03ba }
        goto L_0x0013;
    L_0x03ba:
        r0 = move-exception;
        goto L_0x0013;
    L_0x03bd:
        r0 = 0;
        goto L_0x0355;
    L_0x03bf:
        r0 = move-exception;
        r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r2 = "";	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r3 = 0;	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ Exception -> 0x03bf, all -> 0x03d8 }
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();
        r0.unlock();
        goto L_0x0013;
    L_0x03d5:
        r0 = move-exception;
        goto L_0x0013;
    L_0x03d8:
        r0 = move-exception;
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x0604 }
        r1.unlock();	 Catch:{ Exception -> 0x0604 }
    L_0x03e0:
        throw r0;
    L_0x03e1:
        r0 = com.tencent.mm.kernel.g.CG();
        r1 = new com.tencent.mm.modelmulti.k;
        r1.<init>();
        r2 = 0;
        r0.a(r1, r2);
        goto L_0x0013;
    L_0x03f0:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "dkpush GCM Notify";
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.plugin.zero.b.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;
        r0 = r0.Qc();
        r2 = 7;
        r1 = 13;
        r4 = "";
        r0 = r0.a(r2, r1, r4);
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ all -> 0x044e }
        r1.lock();	 Catch:{ all -> 0x044e }
        if (r0 <= 0) goto L_0x0442;	 Catch:{ all -> 0x044e }
    L_0x0419:
        r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x044e }
        r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x044e }
        r3 = 1;	 Catch:{ all -> 0x044e }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x044e }
        r4 = 0;	 Catch:{ all -> 0x044e }
        r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x044e }
        r3[r4] = r5;	 Catch:{ all -> 0x044e }
        com.tencent.mm.sdk.platformtools.x.d(r1, r2, r3);	 Catch:{ all -> 0x044e }
        r1 = com.tencent.mm.booter.NotifyReceiver.wM();	 Catch:{ all -> 0x044e }
        r2 = (long) r0;	 Catch:{ all -> 0x044e }
        r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x044e }
        r1.add(r0);	 Catch:{ all -> 0x044e }
        r0 = com.tencent.mm.sdk.platformtools.ac.getContext();	 Catch:{ all -> 0x044e }
        r1 = "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY";	 Catch:{ all -> 0x044e }
        s(r0, r1);	 Catch:{ all -> 0x044e }
    L_0x0442:
        r0 = com.tencent.mm.booter.NotifyReceiver.wL();
        r0.unlock();
        goto L_0x0013;
    L_0x044b:
        r0 = move-exception;
        goto L_0x0013;
    L_0x044e:
        r0 = move-exception;
        r1 = com.tencent.mm.booter.NotifyReceiver.wL();	 Catch:{ Exception -> 0x0601 }
        r1.unlock();	 Catch:{ Exception -> 0x0601 }
    L_0x0456:
        throw r0;
    L_0x0457:
        r0 = "notify_respType";
        r1 = 0;
        r3 = r14.getIntExtra(r0, r1);
        r0 = "notify_respBuf";
        r4 = r14.getByteArrayExtra(r0);
        r0 = "notify_skey";
        r5 = r14.getByteArrayExtra(r0);
        r0 = "notfiy_recv_time";
        r6 = -1;
        r6 = r14.getLongExtra(r0, r6);
        r1 = "MicroMsg.NotifyReceiver";
        r2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
        r0 = 4;
        r8 = new java.lang.Object[r0];
        r0 = 0;
        r9 = java.lang.Integer.valueOf(r3);
        r8[r0] = r9;
        r0 = 1;
        r9 = java.lang.Long.valueOf(r6);
        r8[r0] = r9;
        r9 = 2;
        if (r4 != 0) goto L_0x04b8;
    L_0x0490:
        r0 = -1;
    L_0x0491:
        r0 = java.lang.Integer.valueOf(r0);
        r8[r9] = r0;
        r0 = 3;
        r9 = com.tencent.mm.sdk.platformtools.bh.by(r5);
        r9 = com.tencent.mm.sdk.platformtools.bh.VT(r9);
        r8[r0] = r9;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r8);
        switch(r3) {
            case 39: goto L_0x05f2;
            case 138: goto L_0x054c;
            case 268369921: goto L_0x04ba;
            case 1000000205: goto L_0x05ba;
            case 2147480001: goto L_0x0599;
            default: goto L_0x04a8;
        };
    L_0x04a8:
        r0 = com.tencent.mm.plugin.zero.PluginZero.class;
        r0 = com.tencent.mm.kernel.g.k(r0);
        r0 = (com.tencent.mm.plugin.zero.PluginZero) r0;
        r1 = r0.vaG;
        r2 = r13;
        r1.a(r2, r3, r4, r5, r6);
        goto L_0x0013;
    L_0x04b8:
        r0 = r4.length;
        goto L_0x0491;
    L_0x04ba:
        r0 = com.tencent.mm.sdk.platformtools.bh.bw(r5);
        if (r0 == 0) goto L_0x04d8;
    L_0x04c0:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "dkpush dealWithNotify session:";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x04d8:
        r0 = com.tencent.mm.sdk.platformtools.bh.bw(r4);
        if (r0 != 0) goto L_0x04e3;
    L_0x04de:
        r0 = r4.length;
        r1 = 8;
        if (r0 > r1) goto L_0x04ee;
    L_0x04e3:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "dkpush dealWithNotify respBuf error ";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x04ee:
        r0 = 0;
        r0 = com.tencent.mm.a.n.p(r4, r0);
        r1 = 4;
        r1 = com.tencent.mm.a.n.p(r4, r1);
        r2 = r4.length;
        r2 = r2 + -8;
        if (r1 == r2) goto L_0x0516;
    L_0x04fd:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = new java.lang.StringBuilder;
        r2 = "dkpush: respBuf length error len:";
        r1.<init>(r2);
        r2 = r4.length;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x0013;
    L_0x0516:
        r2 = new byte[r1];
        r3 = 8;
        r8 = 0;
        java.lang.System.arraycopy(r4, r3, r2, r8, r1);
        r3 = "MicroMsg.NotifyReceiver";
        r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
        r9 = 4;
        r9 = new java.lang.Object[r9];
        r10 = 0;
        r11 = java.lang.Integer.valueOf(r0);
        r9[r10] = r11;
        r10 = 1;
        r1 = java.lang.Integer.valueOf(r1);
        r9[r10] = r1;
        r1 = 2;
        r4 = r4.length;
        r4 = java.lang.Integer.valueOf(r4);
        r9[r1] = r4;
        r1 = 3;
        r4 = java.lang.Long.valueOf(r6);
        r9[r1] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r3, r8, r9);
        com.tencent.mm.modelmulti.m.a(r0, r2, r5, r6);
        goto L_0x0013;
    L_0x054c:
        if (r4 != 0) goto L_0x058d;
    L_0x054e:
        r0 = 7;
        r2 = r0;
    L_0x0550:
        if (r4 != 0) goto L_0x0594;
    L_0x0552:
        r0 = 2;
        r1 = r0;
    L_0x0554:
        r3 = "MicroMsg.NotifyReceiver";
        r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
        r0 = 3;
        r6 = new java.lang.Object[r0];
        r0 = 0;
        r7 = java.lang.Integer.valueOf(r2);
        r6[r0] = r7;
        r0 = 1;
        r7 = java.lang.Integer.valueOf(r1);
        r6[r0] = r7;
        r7 = 2;
        if (r4 != 0) goto L_0x0597;
    L_0x056e:
        r0 = -1;
    L_0x056f:
        r0 = java.lang.Integer.valueOf(r0);
        r6[r7] = r0;
        com.tencent.mm.sdk.platformtools.x.i(r3, r5, r6);
        r0 = com.tencent.mm.plugin.zero.b.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;
        r0 = r0.Qc();
        r2 = (long) r2;
        r4 = "";
        r0.a(r2, r1, r4);
        goto L_0x0013;
    L_0x058d:
        r0 = 0;
        r0 = com.tencent.mm.a.n.p(r4, r0);
        r2 = r0;
        goto L_0x0550;
    L_0x0594:
        r0 = 1;
        r1 = r0;
        goto L_0x0554;
    L_0x0597:
        r0 = r4.length;
        goto L_0x056f;
    L_0x0599:
        r0 = "MicroMsg.NotifyReceiver";
        r1 = "dkpush GCM Notify";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.zero.b.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;
        r0 = r0.Qc();
        r2 = 7;
        r1 = 13;
        r4 = "";
        r0.a(r2, r1, r4);
        goto L_0x0013;
    L_0x05ba:
        r1 = "MicroMsg.NotifyReceiver";
        r2 = new java.lang.StringBuilder;
        r0 = "oreh on newsynccheck2 notify, notify=";
        r2.<init>(r0);
        if (r4 == 0) goto L_0x05f0;
    L_0x05c7:
        r0 = 1;
    L_0x05c8:
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.i(r1, r0);
        r1 = new com.tencent.mm.protocal.aa$b;
        r1.<init>();
        r0 = com.tencent.mm.plugin.zero.b.b.class;
        r0 = com.tencent.mm.kernel.g.h(r0);
        r0 = (com.tencent.mm.plugin.zero.b.b) r0;
        r0 = r0.Qc();
        r2 = r1.vBW;
        r4 = 1;
        r1 = r1.cdK();
        r0.a(r2, r4, r1);
        goto L_0x0013;
    L_0x05f0:
        r0 = 0;
        goto L_0x05c8;
    L_0x05f2:
        r0 = com.tencent.mm.kernel.g.CG();
        r1 = new com.tencent.mm.modelmulti.k;
        r1.<init>();
        r2 = 0;
        r0.a(r1, r2);
        goto L_0x0013;
    L_0x0601:
        r1 = move-exception;
        goto L_0x0456;
    L_0x0604:
        r1 = move-exception;
        goto L_0x03e0;
    L_0x0607:
        r1 = move-exception;
        goto L_0x0346;
    L_0x060a:
        r1 = move-exception;
        goto L_0x02b3;
    L_0x060d:
        r0 = r13;
        goto L_0x0080;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.NotifyReceiver$NotifyService.l(android.content.Intent):void");
    }

    public void onStart(Intent intent, int i) {
        k(intent);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        x.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
        k(intent);
        return 2;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    private void k(Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
            return;
        }
        if (com.tencent.mm.kernel.g.Dk().gQE.gQX) {
            boolean z = false;
        } else {
            x.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", new Object[]{Integer.valueOf(0)});
            if (this.gyt != null) {
                com.tencent.mm.kernel.g.Dk().b(this.gyt);
            }
            this.gyt = new 1(this, System.currentTimeMillis(), intent);
            com.tencent.mm.kernel.g.Dk().a(this.gyt);
            d.pPH.a(99, 213, 1, false);
            int i = -1;
        }
        if (i < 0) {
            x.e("MicroMsg.NotifyReceiver", "summerboot status %s", new Object[]{Integer.valueOf(-1)});
            return;
        }
        l(intent);
    }

    public void onCreate() {
        super.onCreate();
        if (VERSION.SDK_INT < 24 && !h.zj()) {
            if (VERSION.SDK_INT < 18) {
                startForeground(-1212, new Notification());
            } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                startForeground(-1212, new Notification());
                startService(new Intent(this, InnerService.class));
                x.i("MicroMsg.NotifyReceiver", "set service for mm.");
            }
            new af().postDelayed(new 2(this), ac.cft().getLong("mm_stop_service_time", 86400000));
        }
    }

    public static void eg(String str) {
        synchronized (NotifyReceiver.wH()) {
            if (NotifyReceiver.wI() == null) {
                NotifyReceiver.a(new WakerLock(ac.getContext()));
            }
        }
        NotifyReceiver.wI().lock(5000, str);
    }

    private static void r(Context context, String str) {
        synchronized (NotifyReceiver.wH()) {
            if (NotifyReceiver.wI() == null) {
                NotifyReceiver.a(new WakerLock(context));
            }
            NotifyReceiver.wI().lock(14000, str);
        }
    }

    private static void s(Context context, String str) {
        synchronized (NotifyReceiver.wJ()) {
            if (NotifyReceiver.wK() == null) {
                NotifyReceiver.b(new WakerLock(context));
            }
            NotifyReceiver.wK().lock(60000, str);
        }
    }
}
