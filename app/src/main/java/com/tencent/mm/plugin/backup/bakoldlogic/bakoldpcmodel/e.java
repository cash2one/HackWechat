package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.k;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d.1;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.2;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.f.4;
import com.tencent.mm.plugin.backup.f.b$d;
import com.tencent.mm.plugin.backup.h.ab;
import com.tencent.mm.plugin.backup.h.q;
import com.tencent.mm.plugin.backup.h.r;
import com.tencent.mm.plugin.backup.h.s;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.z.ar;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.List;

public final class e implements b$d {
    private d kqK;
    public c kqS;
    public a kqT;
    public e kqU;
    public d kqV = new d();
    public f kqW = new f();
    com.tencent.mm.plugin.backup.bakoldlogic.c.e kqX;
    private a kqY;
    public int kqZ = -1;
    public String kra;
    public String krb;
    public int krc = -1;
    public int krd = 1;
    private boolean kre = false;

    class AnonymousClass3 implements com.tencent.mm.ae.e {
        final /* synthetic */ e krf;
        final /* synthetic */ Runnable kri;
        final /* synthetic */ Runnable krj;

        AnonymousClass3(e eVar, Runnable runnable, Runnable runnable2) {
            this.krf = eVar;
            this.kri = runnable;
            this.krj = runnable2;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar != this.krf.kqX) {
                x.w("MicroMsg.BakPcProcessMgr", "last canceded scene");
                return;
            }
            if (i == 0 && i2 == 0) {
                x.i("MicroMsg.BakPcProcessMgr", "getPcPwd OK");
                com.tencent.mm.plugin.backup.bakoldlogic.c.e eVar = (com.tencent.mm.plugin.backup.bakoldlogic.c.e) kVar;
                a.aql().kiH = eVar.krF;
                this.kri.run();
            } else {
                this.krf.Q(10010, new String("getPcPwd Fail"));
                x.i("MicroMsg.BakPcProcessMgr", "getPcPwd Fail");
                this.krj.run();
            }
            ar.CG().b(596, this);
        }
    }

    public interface b {
        void onError(int i);
    }

    public final void bH(String str, String str2) {
        this.kra = str;
        this.krb = str2;
    }

    public final synchronized void dM(boolean z) {
        this.kre = z;
    }

    public final synchronized boolean aqt() {
        return this.kre;
    }

    public final synchronized void aqu() {
        this.kqK = null;
        this.kqV.kqK = null;
        this.kqW.kqK = null;
    }

    public final synchronized void a(d dVar) {
        if (dVar == null) {
            if (this.kqK instanceof com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a) {
                x.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck BakchatBannerView null ilegal, fking return");
            }
        }
        x.d("MicroMsg.BakPcProcessMgr", "setOperatorCallbck:%s", new Object[]{dVar});
        this.kqK = dVar;
        this.kqV.kqK = dVar;
        this.kqW.kqK = dVar;
    }

    public final void aoC() {
        if (this.kqW.krn) {
            f fVar = this.kqW;
            x.i("MicroMsg.RecoverPCServer", "startMerge");
            if (fVar.kjZ) {
                x.i("MicroMsg.RecoverPCServer", "hasStartMerge , return");
                return;
            }
            fVar.kqQ = 0;
            a.aql().aqm().krd = 6;
            fVar.kjZ = true;
            com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().a(new 4(fVar));
            return;
        }
        x.e("MicroMsg.BakPcProcessMgr", "startMerge err state");
    }

    public final void pause() {
        if (this.kqZ == 1) {
            this.kqV.pause();
        } else if (this.kqZ == 6) {
            this.kqW.pause();
        }
    }

    final synchronized void Q(int i, String str) {
        x.e("MicroMsg.BakPcProcessMgr", "callbackErr type:%d,  %s", new Object[]{Integer.valueOf(i), str});
        if (i == 10006 || i == 10008) {
            x.e("MicroMsg.BakPcProcessMgr", "callbackErr socketClose");
            this.krc = -1;
            this.krd = 1;
            aqx();
            a.aql().aqn().kqC = 2;
            a.aql().aqn().HT();
            if (this.kqS != null) {
                this.kqS.onError(i);
            }
            if (this.kqT != null) {
                this.kqT.onError(i);
            }
            if (this.kqK != null) {
                this.kqK.onError(i);
            }
            if (this.kqU != null) {
                this.kqU.onError(i);
            }
        }
        if (i == 10009 || i == 10004) {
            x.e("MicroMsg.BakPcProcessMgr", "callbackErr ip not match or connect failed: %d", new Object[]{Integer.valueOf(i)});
            a.aql().aqn().kqC = 2;
            a.aql().aqn().HT();
            aqv();
        } else {
            x.d("MicroMsg.BakPcProcessMgr", "summerbak errtype:%d, authcallback[%s], operatorcallback[%s], eventCallback[%s]", new Object[]{Integer.valueOf(i), this.kqT, this.kqK, this.kqS});
            if (i == 15) {
                if (this.kqT != null) {
                    this.kqT.onError(i);
                }
                if (this.kqK != null) {
                    this.kqK.onError(i);
                }
                if (this.kqS != null) {
                    this.kqS.mV(i);
                }
            }
            if (i == -1) {
                if (this.kqT != null) {
                    this.kqT.onError(i);
                } else if (this.kqK != null) {
                    this.kqK.onError(i);
                } else if (this.kqS != null) {
                    this.kqS.mV(i);
                }
            }
        }
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        if (z && bArr != null) {
            Q(i, new String(bArr));
        }
        if (i == 10001 || i == 10002) {
            a.aql().aqn().kqC = 1;
            new com.tencent.mm.plugin.backup.bakoldlogic.c.a(a.aql().kiC, a.aql().kiD, d.aop(), a.aql().kiB).apQ();
        }
        if (i == 3) {
            this.kqZ = -1;
            ab abVar = new ab();
            try {
                abVar.aF(bArr);
                x.i("MicroMsg.BakPcProcessMgr", "recv cmd:%d (%s)", new Object[]{Integer.valueOf(abVar.ksA), mT(abVar.ksA)});
                switch (abVar.ksA) {
                    case 0:
                        if (ar.Hj()) {
                            this.kqZ = abVar.ksA;
                            if (this.kqT != null) {
                                this.kqT.aqy();
                            } else {
                                x.i("MicroMsg.BakPcProcessMgr", "authCallback is null");
                                Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
                                className.addFlags(335544320);
                                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                                className.putExtra("newPCBackup", false);
                                ac.getContext().startActivity(className);
                            }
                            this.krc = 0;
                            this.krd = 1;
                            return;
                        }
                        x.w("MicroMsg.BakPcProcessMgr", "acc is not ready, not support pcmgr's auth");
                        a(abVar.ksA, 1, null);
                        return;
                    case 1:
                        a.aql().aqo().aqp();
                        a.aql().aqn().HT();
                        Q(-1, null);
                        x.e("MicroMsg.BakPcProcessMgr", "summerback new version not support old pc backup request toast upgrade pc");
                        return;
                    case 3:
                        this.krd = 2;
                        this.krc = 3;
                        aqx();
                        a(abVar.ksA, 0, null);
                        com.tencent.mm.sdk.f.e.b(new 1(this.kqV), "BakPCServer_startBak").start();
                        return;
                    case 4:
                        this.krc = -1;
                        this.krd = 1;
                        aqx();
                        a(abVar.ksA, 0, null);
                        if (this.kqX != null) {
                            this.kqX.cancel();
                            this.kqX = null;
                        }
                        if (this.kqV != null) {
                            this.kqV.cancel();
                        }
                        if (this.kqY != null) {
                            a aVar = this.kqY;
                            x.i("MicroMsg.BakCalculator", "calculator cancel.");
                            x.d("MicroMsg.BakCalculator", "calculator cancel. stack:%s", new Object[]{bh.cgy()});
                            aVar.hnr = true;
                            this.kqY = null;
                        }
                        if (this.kqK != null) {
                            this.kqK.aqA();
                            return;
                        }
                        return;
                    case 6:
                        this.krc = 5;
                        this.krd = 4;
                        aqx();
                        this.kqZ = abVar.ksA;
                        if (this.kqS != null) {
                            this.kqS.mU(abVar.ksA);
                        } else {
                            x.i("MicroMsg.BakPcProcessMgr", "callback is null");
                        }
                        c aqn = a.aql().aqn();
                        aqn.kqF++;
                        com.tencent.mm.plugin.backup.bakoldlogic.d.b.aqJ().a(new 1(this));
                        return;
                    case 7:
                        this.krc = -1;
                        this.krd = 1;
                        aqx();
                        a(abVar.ksA, 0, null);
                        if (this.kqX != null) {
                            this.kqX.cancel();
                            this.kqX = null;
                        }
                        if (this.kqW != null) {
                            this.kqW.cancel();
                        }
                        if (this.kqK != null) {
                            this.kqK.aqA();
                            return;
                        }
                        return;
                    case 9:
                        a(abVar.ksA, 0, null);
                        if (this.kqV != null) {
                            this.kqV.pause();
                            return;
                        }
                        return;
                    case 10:
                        a(abVar.ksA, 0, null);
                        if (this.kqW != null) {
                            this.kqW.pause();
                            return;
                        }
                        return;
                    case 11:
                        a(abVar.ksA, 0, null);
                        if (this.kqV != null) {
                            this.kqV.resume();
                            return;
                        }
                        return;
                    case 12:
                        a(abVar.ksA, 0, null);
                        if (this.kqW != null) {
                            this.kqW.resume();
                            return;
                        }
                        return;
                    case 15:
                        a.aql().aqo().aqp();
                        a.aql().aqn().HT();
                        Q(15, null);
                        return;
                    case 16:
                        a(abVar.ksA, 0, null);
                        if (this.kqU != null) {
                            this.kqU.aqB();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
            }
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandReq error", new Object[0]);
        }
    }

    public static void aqv() {
        Intent className = new Intent().setClassName(ac.getContext(), "com.tencent.mm.ui.LauncherUI");
        className.addFlags(335544320);
        className.putExtra("nofification_type", "back_to_pcmgr_error_notification");
        ac.getContext().startActivity(className);
    }

    public final int aqw() {
        x.i("MicroMsg.BakPcProcessMgr", "getPCProgressPercent now progress:%d", new Object[]{Integer.valueOf(this.krd)});
        if (this.krd == 2 || this.krd == 3) {
            return this.kqV.kqP;
        }
        if (this.krd == 4 || this.krd == 5) {
            return this.kqW.krq;
        }
        if (this.krd == 6 || this.krd == 7) {
            return this.kqW.krm;
        }
        x.w("MicroMsg.BakPcProcessMgr", "wrong operatorStatus");
        return 0;
    }

    public final void mR(int i) {
        if (i == 0) {
            this.krc = 1;
        } else {
            this.krc = -1;
        }
        com.tencent.mm.plugin.backup.h.ac acVar;
        if (i == 1) {
            acVar = new com.tencent.mm.plugin.backup.h.ac();
            acVar.ksA = 0;
            acVar.ktm = i;
            try {
                x.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.ktm)});
                com.tencent.mm.plugin.backup.f.b.F(acVar.toByteArray(), 4);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
                return;
            }
        }
        q qVar = new q();
        qVar.ktx = 0;
        qVar.ktz = Build.MANUFACTURER;
        qVar.ksZ = Build.MODEL;
        qVar.kty = 0;
        qVar.ktA = VERSION.RELEASE;
        String str = w.gZK;
        if (new File(com.tencent.mm.compatible.util.e.bnD).exists() && f.ze()) {
            File file = new File(com.tencent.mm.compatible.util.e.bnF);
            if (file.exists() || file.mkdirs()) {
                str = com.tencent.mm.compatible.util.e.bnF;
            }
        }
        qVar.ktw = str;
        qVar.ktv = com.tencent.mm.z.q.FU();
        qVar.ktu = com.tencent.mm.z.q.FS();
        qVar.ktt = com.tencent.mm.protocal.d.vAz;
        try {
            PackageInfo packageInfo = ac.getContext().getPackageManager().getPackageInfo(ac.getContext().getPackageName(), 0);
            qVar.ktt = packageInfo.versionName + ";" + packageInfo.versionCode + ";" + com.tencent.mm.protocal.d.vAz;
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e2, "get packageInfo failed", new Object[0]);
        }
        n.Jz();
        Bitmap jd = com.tencent.mm.ad.d.jd(qVar.ktu);
        byte[] bArr = null;
        if (jd != null) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            jd.compress(CompressFormat.PNG, 0, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e3, "close", new Object[0]);
            }
        }
        n.Jz();
        String x = com.tencent.mm.ad.d.x(qVar.ktu, true);
        String str2 = "MicroMsg.BakPcProcessMgr";
        String str3 = ", bmHDPath:%s, bm.buf.len:%d";
        Object[] objArr = new Object[2];
        objArr[0] = x;
        objArr[1] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        x.i(str2, str3, objArr);
        if (!bh.bw(bArr)) {
            qVar.ktB = new com.tencent.mm.bq.b(bArr);
        }
        bArr = com.tencent.mm.a.e.e(x, 0, -1);
        if (!bh.bw(bArr)) {
            qVar.ktC = new com.tencent.mm.bq.b(bArr);
        }
        acVar = new com.tencent.mm.plugin.backup.h.ac();
        acVar.ksA = 0;
        acVar.ktm = i;
        acVar.kuf = qVar;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "send auth cmd resp, status:%d", new Object[]{Integer.valueOf(acVar.ktm)});
            com.tencent.mm.plugin.backup.f.b.F(acVar.toByteArray(), 4);
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e22, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void a(int i, int i2, s sVar) {
        com.tencent.mm.plugin.backup.h.ac acVar = new com.tencent.mm.plugin.backup.h.ac();
        acVar.ksA = i;
        acVar.ktm = i2;
        acVar.kui = sVar;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "send cmd resp, status:%d, cmd:%d (%s)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), mT(i)});
            com.tencent.mm.plugin.backup.f.b.F(acVar.toByteArray(), 4);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandResponse err", new Object[0]);
        }
    }

    public static void mS(int i) {
        ab abVar = new ab();
        abVar.ksA = i;
        try {
            x.i("MicroMsg.BakPcProcessMgr", "sendNormalReq cmd :%d (%s)", new Object[]{Integer.valueOf(i), mT(i)});
            com.tencent.mm.plugin.backup.f.b.F(abVar.toByteArray(), 3);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakPcProcessMgr", e, "buf to PacketCommandRequest err", new Object[0]);
        }
    }

    final synchronized void a(r rVar) {
        if (this.kqW != null) {
            this.kqW.cancel();
        }
        this.kqW = new f();
        f fVar = this.kqW;
        List list = rVar.ktD;
        List list2 = rVar.ktE;
        long j = rVar.ktl;
        fVar.krk = list;
        fVar.krl = list2;
        fVar.fvI = false;
        fVar.hnr = false;
        fVar.kqJ.clear();
        fVar.kqM = false;
        fVar.krn = false;
        fVar.kjZ = false;
        fVar.krm = 0;
        fVar.krp = 0;
        fVar.kro = j;
        com.tencent.mm.plugin.backup.bakoldlogic.c.d.setProgress(0);
        this.kqW.kqK = this.kqK;
        x.i("MicroMsg.BakPcProcessMgr", "reve textList:%d,  mediaList:%d, convDataSize:%d", new Object[]{Integer.valueOf(rVar.ktD.size()), Integer.valueOf(rVar.ktE.size()), Long.valueOf(rVar.ktl)});
        fVar = this.kqW;
        fVar.kqQ = 0;
        if (fVar.krl.size() < rVar.ktq || fVar.krk.size() < rVar.ktp) {
            com.tencent.mm.plugin.backup.f.b.a(3, new 2(fVar));
            x.i("MicroMsg.RecoverPCServer", "send restore info cmd");
            new com.tencent.mm.plugin.backup.bakoldlogic.c.b(2).apQ();
        } else {
            x.i("MicroMsg.RecoverPCServer", "startRecover start directly");
            com.tencent.mm.sdk.f.e.post(new f.1(fVar), "RecoverPCServer_recover");
        }
    }

    public static void aqx() {
        com.tencent.mm.sdk.b.a.xef.m(new lk());
    }

    private static String mT(int i) {
        switch (i) {
            case -1:
                return "COMMAND_NOT_SUPPORT";
            case 0:
                return "AUTHORIZE";
            case 1:
                return "BACKUP_INFO";
            case 2:
                return "RESTORE_INFO";
            case 3:
                return "BACKUP_START";
            case 4:
                return "BACKUP_CANCEL";
            case 5:
                return "BACKUP_FINISH";
            case 6:
                return "RESTORE_START";
            case 7:
                return "RESTORE_CANCE";
            case 8:
                return "RESTORE_FINISH";
            case 9:
                return "BACKUP_PAUSE";
            case 10:
                return "RESTORE_PAUSE";
            case 11:
                return "BACKUP_RESUME";
            case 12:
                return "RESTORE_RESUME";
            case 13:
                return "MERGE_PROGRESS";
            case 14:
                return "LOGOFF";
            case 15:
                return "EXIT";
            case 16:
                return "SHOW_BACKUP_RESTORE";
            case 17:
                return "COMMAND_WECHAT_LEAVE";
            default:
                return String.valueOf(i);
        }
    }
}
