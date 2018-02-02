package com.tencent.mm.plugin.collect.b;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bq.b;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.g.a.br;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.collect.a.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g extends c<br> implements e {
    private static final String lij = (com.tencent.mm.compatible.util.e.bnF + "wallet/voice/");
    private static final b lik = b.Tl("元");
    private MediaPlayer lil;
    private MediaPlayer lim;
    public ConcurrentLinkedQueue<b> lin;
    private boolean lio;
    private int lip;
    private int liq;
    private long lir;
    private WeakReference<ArrayList<String>> lis;

    static /* synthetic */ void e(g gVar) {
        x.i("MicroMsg.F2fRcvVoiceListener", "reset user vol: %s", new Object[]{Integer.valueOf(gVar.lip)});
        f.xG().aM(3, gVar.lip);
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        br brVar = (br) bVar;
        x.i("MicroMsg.F2fRcvVoiceListener", "feeType: %s, source: %s, tradeNo: %s", new Object[]{brVar.fpN.fpP, Integer.valueOf(brVar.fpN.cOY), brVar.fpN.fpQ});
        long j = brVar.fpN.fpS;
        if (j > 60000) {
            x.i("MicroMsg.F2fRcvVoiceListener", "delay over 1min: %s, tradeNo: %s", new Object[]{Long.valueOf(j), brVar.fpN.fpQ});
            if (j <= 120000) {
                com.tencent.mm.plugin.report.service.g.pQN.a(699, 3, 1, false);
            } else if (j <= 300000) {
                com.tencent.mm.plugin.report.service.g.pQN.a(699, 4, 1, false);
            } else if (j <= 600000) {
                com.tencent.mm.plugin.report.service.g.pQN.a(699, 5, 1, false);
            } else if (j <= 1800000) {
                com.tencent.mm.plugin.report.service.g.pQN.a(699, 6, 1, false);
            } else {
                com.tencent.mm.plugin.report.service.g.pQN.a(699, 7, 1, false);
            }
        }
        k iVar;
        if (brVar.fpN.fpR.equals("wx_f2f")) {
            a.ayE();
            boolean ayG = a.ayG();
            x.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[]{Integer.valueOf(brVar.fpN.fpO), Boolean.valueOf(ayG)});
            if (!xs(brVar.fpN.fpQ)) {
                if (brVar.fpN.cOY == 0) {
                    com.tencent.mm.plugin.report.service.g.pQN.a(699, 8, 1, false);
                } else {
                    com.tencent.mm.plugin.report.service.g.pQN.a(699, 9, 1, false);
                }
                iVar = new i(brVar.fpN.fpO, lik, brVar.fpN.fpQ);
                com.tencent.mm.kernel.g.Dk();
                com.tencent.mm.kernel.g.Di().gPJ.a(iVar, 0);
            }
        } else if (brVar.fpN.fpR.equals("wx_md")) {
            iVar = new n(brVar.fpN.fpO, lik, brVar.fpN.fpQ);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.a(iVar, 0);
        } else {
            x.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[]{brVar.fpN.fpR});
        }
        return false;
    }

    public g() {
        this.lio = false;
        this.xen = br.class.getName().hashCode();
    }

    private List<String> ayJ() {
        if (this.lis == null || this.lis.get() == null) {
            x.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
            this.lis = new WeakReference(new ArrayList(bh.fs((String) com.tencent.mm.kernel.g.Dj().CU().get(w.a.xxF, ""), ",")));
        }
        return (List) this.lis.get();
    }

    private synchronized boolean xs(String str) {
        boolean z;
        if (bh.ov(str)) {
            x.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[]{str});
            z = true;
        } else {
            List subList;
            List ayJ = ayJ();
            for (String equals : ayJ()) {
                if (equals.equals(str)) {
                    x.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[]{str});
                    z = true;
                    break;
                }
            }
            ayJ.add(str);
            if (ayJ.size() > 3) {
                x.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
                int size = ayJ.size();
                subList = ayJ.subList(size - 3, size);
            } else {
                subList = ayJ;
            }
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xxF, bh.d(subList, ","));
            z = false;
        }
        return z;
    }

    private static boolean l(String str, byte[] bArr) {
        com.tencent.mm.kernel.g.Dk();
        if (!com.tencent.mm.kernel.g.Dj().isSDCardAvailable()) {
            x.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
            return false;
        } else if (FileOp.j(str, bArr) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ayK() {
        x.i("MicroMsg.F2fRcvVoiceListener", "delete files");
        return com.tencent.mm.a.e.bP(lij);
    }

    private synchronized void ayL() {
        boolean z = false;
        synchronized (this) {
            if (System.currentTimeMillis() - this.lir > 10000) {
                x.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[]{Long.valueOf(this.lir)});
                this.lio = false;
            }
            if (this.lio) {
                x.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
            } else {
                this.lio = true;
                this.lir = System.currentTimeMillis();
                b bVar = (b) this.lin.poll();
                f xG = f.xG();
                int streamMaxVolume = xG.getStreamMaxVolume(3);
                this.lip = xG.getStreamVolume(3);
                this.liq = Math.round(((float) streamMaxVolume) * 0.4f);
                x.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[]{Integer.valueOf(this.lip), Integer.valueOf(streamMaxVolume), Integer.valueOf(this.liq)});
                if (VERSION.SDK_INT >= 23) {
                    z = xG.gCe.isStreamMute(3);
                    x.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[]{Boolean.valueOf(z)});
                }
                if (this.lip > 0 && this.lip < this.liq && !r1) {
                    xG.aM(3, this.liq);
                }
                if (bVar != null) {
                    int i = i.uIR;
                    if (bVar.liz == 2) {
                        i = i.uLZ;
                    }
                    if (bh.ov(bVar.fileName)) {
                        this.lil = a.a(ac.getContext(), i, new 4(this), new OnErrorListener(this) {
                            final /* synthetic */ g liu;

                            {
                                this.liu = r1;
                            }

                            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                x.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
                                g.e(this.liu);
                                this.liu.lio = false;
                                this.liu.lil = null;
                                return false;
                            }
                        });
                        com.tencent.mm.plugin.report.service.g.pQN.a(699, 2, 1, false);
                    } else {
                        x.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[]{Integer.valueOf(r2)});
                        this.lil = a.a(ac.getContext(), i, new 1(this, bVar), new 2(this));
                        if (this.lil != null) {
                            x.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[]{Integer.valueOf(this.lil.getDuration())});
                            ag.h(new 3(this), (long) (r0 + 1000));
                        }
                    }
                } else {
                    this.lio = false;
                }
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        File file;
        String str2;
        b bVar;
        if (kVar instanceof i) {
            i iVar = (i) kVar;
            b bVar2;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{iVar});
                bVar2 = new b(this, (byte) 0);
                bVar2.liz = 1;
                bVar2.fpQ = iVar.fpQ;
                this.lin.add(bVar2);
                ayL();
            } else if (iVar.liD.liH == 0) {
                file = new File(lij);
                if (file.exists() || file.mkdirs()) {
                    str2 = lij + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (l(str2, iVar.liD.vTT.oz)) {
                        bVar = new b(this, (byte) 0);
                        bVar.fileName = str2;
                        bVar.fvx = iVar.liD.vTS;
                        bVar.liz = 1;
                        bVar.fpQ = iVar.fpQ;
                        this.lin.add(bVar);
                        ayL();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            } else if (iVar.liD.liH <= 100) {
                x.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
                bVar2 = new b(this, (byte) 0);
                bVar2.liz = 1;
                bVar2.fpQ = iVar.fpQ;
                this.lin.add(bVar2);
                ayL();
            } else {
                x.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
            }
        } else if (kVar instanceof n) {
            n nVar = (n) kVar;
            if (i != 0 || i2 != 0) {
                x.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[]{nVar});
            } else if (nVar.liX.liH == 0) {
                file = new File(lij);
                if (file.exists() || file.mkdirs()) {
                    str2 = lij + UUID.randomUUID().toString() + ".tmp";
                    x.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[]{str2});
                    if (l(str2, nVar.liX.vTT.oz)) {
                        bVar = new b(this, (byte) 0);
                        bVar.fileName = str2;
                        bVar.fvx = nVar.liX.vTS;
                        bVar.liz = 2;
                        this.lin.add(bVar);
                        ayL();
                        return;
                    }
                    x.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
                    return;
                }
                x.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            }
        }
    }
}
