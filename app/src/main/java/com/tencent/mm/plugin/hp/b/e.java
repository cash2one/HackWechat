package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.modelmulti.n$a;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.hp.a.a.1;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.c.bns;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Random;

public final class e implements o {
    final b nAL;
    private long nAM;

    public e(b bVar) {
        this.nAL = bVar;
        f.aAd();
        c.a(this);
    }

    public final boolean fN(boolean z) {
        boolean z2;
        a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.nAL.toString());
        b bVar = this.nAL;
        if (bVar.nBk.intValue() > 4 || bVar.nBk.intValue() <= 0) {
            x.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", bVar.nBk, Integer.valueOf(1), Integer.valueOf(4));
            g.pQN.a(614, 24, 1, false);
            z2 = false;
        } else {
            if (bVar.aSI()) {
                if (TextUtils.isEmpty(bVar.nBq)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                    g.pQN.a(614, 25, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nBo)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                    g.pQN.a(614, 26, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nBp)) {
                    x.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                    g.pQN.a(614, 27, 1, false);
                    z2 = false;
                }
            }
            z2 = true;
        }
        if (z2) {
            int i;
            if (this.nAL.nBk.intValue() == 3) {
                i = 1;
            } else {
                z2 = false;
            }
            if (i != 0) {
                final Context context = ac.getContext();
                final com.tencent.tinker.lib.e.a ip = com.tencent.tinker.lib.e.a.ip(context);
                if (ip.AiH) {
                    a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                    n nVar = new n(ac.getContext(), new n$a(this) {
                        final /* synthetic */ e nAN;

                        public final void bO(boolean z) {
                            if (!z) {
                                a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
                                ShareTinkerInternals.iH(context);
                                ip.aSE();
                                Process.killProcess(Process.myPid());
                            }
                        }
                    });
                    SharePatchInfo.a(ip.AiD, new SharePatchInfo(ip.AiG.AiL, "00000000000000000000000000000000", Build.FINGERPRINT, "odex"), ip.AiE);
                } else {
                    a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                }
                return true;
            } else if (!this.nAL.aSI()) {
                return true;
            } else {
                a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", this.nAL.nBn, this.nAL.aSK());
                Context context2 = ac.getContext();
                if (this.nAL.nBn.intValue() == 2 && an.isMobile(ac.getContext()) && this.nAL.aSJ()) {
                    if (com.tencent.mm.plugin.hp.tinker.g.ag(context2, this.nAL.nBq)) {
                        g.pQN.a(614, 44, 1, false);
                        x.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.nAL.nBq);
                    } else {
                        if (this.nAL.nBm.intValue() == 2) {
                            i.a(ac.getContext().getString(R.l.ejp), ac.getContext().getString(R.l.ejr, new Object[]{this.nAL.aSK(), ac.getContext().getString(R.l.eRY), bh.bx((long) this.nAL.fileSize)}), ac.getContext().getString(R.l.eSc), new 1(this), ac.getContext().getString(R.l.eRQ), new 2(this, context2));
                        } else if (this.nAL.nBm.intValue() == 3) {
                            String string;
                            x.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                            if (bh.ov(this.nAL.aSK())) {
                                string = context2.getString(R.l.eSe);
                            } else {
                                string = this.nAL.aSK();
                            }
                            bns com_tencent_mm_protocal_c_bns = new bns();
                            com_tencent_mm_protocal_c_bns.nBq = this.nAL.nBq;
                            com_tencent_mm_protocal_c_bns.title = context2.getString(R.l.ejp);
                            com_tencent_mm_protocal_c_bns.wQB = context2.getString(R.l.eSc);
                            com_tencent_mm_protocal_c_bns.nwc = context2.getString(R.l.eRQ);
                            com_tencent_mm_protocal_c_bns.nBr = this.nAL.nBr;
                            com_tencent_mm_protocal_c_bns.nBs = this.nAL.nBs;
                            com_tencent_mm_protocal_c_bns.jIM = this.nAL.fileSize;
                            com_tencent_mm_protocal_c_bns.nBo = this.nAL.nBo;
                            com_tencent_mm_protocal_c_bns.fel = this.nAL.nBp;
                            com_tencent_mm_protocal_c_bns.versionCode = this.nAL.versionCode;
                            com_tencent_mm_protocal_c_bns.wQA = p.RP(this.nAL.nBr);
                            com_tencent_mm_protocal_c_bns.fpb = string;
                            p.a(com_tencent_mm_protocal_c_bns);
                        }
                        a.rg(4);
                    }
                } else if (this.nAL.aSH() && !com.tencent.mm.plugin.hp.tinker.g.ag(context2, this.nAL.nBq)) {
                    fO(z);
                }
                return true;
            }
        }
        a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
        return false;
    }

    final void fO(boolean z) {
        if (!h.getExternalStorageState().equals("mounted")) {
            x.e("Tinker.SyncResponseProcessor", "no sdcard.");
            g.pQN.a(614, 50, 1, false);
        } else if (!com.tencent.mm.compatible.util.f.aC((long) this.nAL.fileSize)) {
            x.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            g.pQN.a(614, 51, 1, false);
            if (this.nAL.nBm.intValue() == 3) {
                g.pQN.a(614, 55, 1, false);
            }
        } else if (this.nAL.nBm.intValue() == 3 && !bh.ov(this.nAL.nBr) && com.tencent.mm.a.e.bO(p.RP(this.nAL.nBr)) && com.tencent.mm.c.a.ch(p.RP(this.nAL.nBr))) {
            String string;
            Context context = ac.getContext();
            if (bh.ov(this.nAL.aSK())) {
                string = context.getString(R.l.eSe);
            } else {
                string = this.nAL.aSK();
            }
            bns com_tencent_mm_protocal_c_bns = new bns();
            com_tencent_mm_protocal_c_bns.nBq = this.nAL.nBq;
            com_tencent_mm_protocal_c_bns.title = context.getString(R.l.ejp);
            com_tencent_mm_protocal_c_bns.wQB = context.getString(R.l.epy);
            com_tencent_mm_protocal_c_bns.nwc = context.getString(R.l.eRQ);
            com_tencent_mm_protocal_c_bns.nBr = this.nAL.nBr;
            com_tencent_mm_protocal_c_bns.nBs = this.nAL.nBs;
            com_tencent_mm_protocal_c_bns.jIM = this.nAL.fileSize;
            com_tencent_mm_protocal_c_bns.nBo = this.nAL.nBo;
            com_tencent_mm_protocal_c_bns.fel = this.nAL.nBp;
            com_tencent_mm_protocal_c_bns.versionCode = this.nAL.versionCode;
            com_tencent_mm_protocal_c_bns.wQA = p.RP(this.nAL.nBr);
            com_tencent_mm_protocal_c_bns.fpb = string;
            p.a(com_tencent_mm_protocal_c_bns);
            x.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.nAL.nBr);
        } else if (this.nAL.nBm.intValue() == 2) {
            aSA();
        } else if (z) {
            aSA();
            com.tencent.mm.plugin.hp.tinker.g.g(ac.getContext(), 0);
            g.pQN.a(76, 1, 1, false);
        } else {
            int i = this.nAL.fileSize / this.nAL.nBu;
            int nextInt = new Random().nextInt(this.nAL.nBw);
            x.i("Tinker.SyncResponseProcessor", "delay download time:%s time count:%s randonStart:%s", Integer.valueOf(i), Integer.valueOf(r1), Integer.valueOf(nextInt));
            g.pQN.a(794, (long) nextInt, 1, false);
            if (nextInt == 0) {
                aSA();
                g.pQN.a(76, 1, 1, false);
            }
            com.tencent.mm.plugin.hp.tinker.g.g(ac.getContext(), System.currentTimeMillis() + ((long) ((i * nextInt) * 1000)));
        }
    }

    private void aSA() {
        p.bZf();
        p.bZg();
        com.tencent.mm.plugin.downloader.model.g.a aVar = new com.tencent.mm.plugin.downloader.model.g.a();
        aVar.xL(this.nAL.nBo);
        aVar.xN(this.nAL.nBq);
        aVar.xO(this.nAL.nBp);
        aVar.ep(false);
        aVar.er(true);
        aVar.ox(2);
        aVar.eq(false);
        this.nAM = f.aAd().a(aVar.lsE);
        x.i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.nAM));
        g.pQN.a(614, 2, 1, false);
        if (an.isWifi(ac.getContext())) {
            g.pQN.a(614, 7, 1, false);
        } else {
            g.pQN.a(614, 8, 1, false);
        }
        if (this.nAL.nBm.intValue() == 3) {
            g.pQN.a(614, 56, 1, false);
            x.d("Tinker.SyncResponseProcessor", "boots download start silent.");
        }
    }

    public final void onTaskStarted(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskStarted");
    }

    public final void c(long j, String str, boolean z) {
        x.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j), str, Boolean.valueOf(z));
        if (this.nAM != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.nAM), Long.valueOf(j));
            return;
        }
        b.ri(2);
        Context context = ac.getContext();
        File file = new File(str);
        ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
        if (this.nAL.nBm.intValue() != 2 || shareSecurityCheck.ak(file)) {
            File file2;
            String absolutePath;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                file2 = null;
            } else {
                file2 = new File(applicationInfo.dataDir, "tinker_server");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    String name = file.getName();
                    for (File file3 : listFiles) {
                        if (!file3.getName().equals(name)) {
                            SharePatchFileUtil.ag(file3);
                        }
                    }
                }
            }
            switch (this.nAL.nBm.intValue()) {
                case 1:
                    x.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    com.tencent.tinker.lib.e.c.bU(context, file.getAbsolutePath());
                    break;
                case 3:
                    absolutePath = file.getAbsolutePath();
                    b bVar = this.nAL;
                    x.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, bVar.nBr);
                    ar.Dm().F(new 1(p.RP(bVar.nBr), context, absolutePath, bVar));
                    break;
            }
            b bVar2 = this.nAL;
            if (bVar2.aSJ()) {
                absolutePath = b.a(bVar2.nBl, 2);
            } else {
                absolutePath = "";
            }
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", absolutePath).apply();
        } else {
            a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            b.rj(2);
            g.pQN.a(614, 31, 1, false);
            if (this.nAL.nBm.intValue() == 3) {
                g.pQN.a(614, 54, 1, false);
                x.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
            }
        }
        f.aAd();
        c.b(this);
    }

    public final void c(long j, int i, boolean z) {
        x.w("Tinker.SyncResponseProcessor", "onTaskFailed");
        if (this.nAM != j) {
            x.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.nAM), Long.valueOf(j));
            return;
        }
        b.rj(2);
        if (this.nAL.nBm.intValue() == 3) {
            g.pQN.a(614, 51, 1, false);
        }
        f.aAd();
        c.b(this);
    }

    public final void onTaskRemoved(long j) {
        x.i("Tinker.SyncResponseProcessor", "onTaskRemoved");
        f.aAd();
        c.b(this);
    }

    public final void onTaskPaused(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskPaused");
    }

    public final void ck(long j) {
        x.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged");
    }

    public final void k(long j, String str) {
        x.d("Tinker.SyncResponseProcessor", "onTaskResumed");
    }
}
