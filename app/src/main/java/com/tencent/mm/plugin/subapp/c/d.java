package com.tencent.mm.plugin.subapp.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.mm.compatible.b.j;
import com.tencent.mm.g.b.cf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.g.a;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.e;
import com.tencent.mm.z.ak;
import com.tencent.mm.z.ak.f;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.s;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements f, ap {
    private static HashMap<Integer, com.tencent.mm.by.h.d> kHz;
    private static d rWj;
    private final Set<com.tencent.mm.z.ak.d> gCl = new HashSet();
    private String gQi;
    private a kHB;
    private k rWi;
    private j rWk;
    private List<Long> rWl = new ArrayList();
    private c rWm = new 3(this);
    private c rWn = new 4(this);
    private c rWo = new 5(this);

    static {
        HashMap hashMap = new HashMap();
        kHz = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new 2());
    }

    public final void a(com.tencent.mm.z.ak.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.gCl.add(dVar);
        }
    }

    public final void b(com.tencent.mm.z.ak.d dVar) {
        x.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.gCl.remove(dVar);
        }
    }

    public final void f(String str, String str2, long j) {
        Context context = ac.getContext();
        if (context == null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            return;
        }
        try {
            boolean zt = com.tencent.mm.k.f.zt();
            boolean zr = com.tencent.mm.k.f.zr();
            x.d("MicroMsg.SubCoreVoiceRemind", "shake " + zt + "sound " + zr);
            if (!s.hb(ar.getNotification().wX())) {
                if (zt) {
                    bh.m(context, true);
                }
                if (zr) {
                    String zs = com.tencent.mm.k.f.zs();
                    Uri defaultUri = zs == e.f.gHY ? RingtoneManager.getDefaultUri(2) : Uri.parse(zs);
                    MediaPlayer jVar = new j();
                    try {
                        jVar.setDataSource(context, defaultUri);
                        jVar.setOnCompletionListener(new 1(this));
                        if (ar.Hh().getStreamVolume(5) != 0) {
                            if (ar.Hh().xR()) {
                                int streamVolume = ar.Hh().getStreamVolume(8);
                                int streamMaxVolume = ar.Hh().getStreamMaxVolume(8);
                                int streamVolume2 = ar.Hh().getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                ar.Hh().aM(8, streamMaxVolume);
                                jVar.setAudioStreamType(8);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                                ar.Hh().aM(8, streamVolume);
                                x.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", new Object[]{Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume)});
                            } else {
                                jVar.setAudioStreamType(5);
                                jVar.setLooping(true);
                                jVar.prepare();
                                jVar.setLooping(false);
                                jVar.start();
                            }
                        }
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e, "", new Object[0]);
                        jVar.release();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "relese error", new Object[0]);
                    }
                }
            } else if (zt) {
                bh.m(context, true);
            }
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e22, "", new Object[0]);
        }
        if (this.gCl == null || this.gCl.size() == 0) {
            RemindDialog.u(context, str, str2);
            return;
        }
        for (com.tencent.mm.z.ak.d m : this.gCl) {
            m.m(str2, j);
        }
    }

    public final void hL(String str) {
        ar.Hg();
        com.tencent.mm.z.c.Fd().Xa(str);
        this.rWl.clear();
        ar.Hg();
        Cursor EH = com.tencent.mm.z.c.Fa().EH(str);
        EH.moveToFirst();
        x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!EH.isAfterLast()) {
            cf auVar = new au();
            auVar.b(EH);
            long j = auVar.field_msgId;
            x.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j + " status = " + auVar.field_status);
            EH.moveToNext();
            this.rWl.add(Long.valueOf(j));
        }
        EH.close();
        ar.Hg();
        com.tencent.mm.z.c.Fa().EF(str);
    }

    public final void GS() {
        bEc().run();
    }

    public final boolean aJ(long j) {
        boolean contains = this.rWl.contains(Long.valueOf(j));
        x.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j);
        return contains;
    }

    public static d bEa() {
        ar.Ha();
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) bp.hY("plugin.subapp");
        rWj = aVar == null ? null : (d) aVar.Mi(d.class.getName());
        x.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", new Object[]{aVar, rWj, bh.cgy()});
        if (rWj == null) {
            f dVar = new d();
            rWj = dVar;
            ak.a.hfO = dVar;
            aVar.b(d.class.getName(), rWj);
        }
        return rWj;
    }

    public static k bEb() {
        g.Dh().Ct();
        if (bEa().rWi == null) {
            d bEa = bEa();
            bEa();
            if (bEa().kHB == null) {
                StringBuilder stringBuilder = new StringBuilder();
                ar.Hg();
                String stringBuilder2 = stringBuilder.append(com.tencent.mm.z.c.FB()).append("CommonOneMicroMsg.db").toString();
                bEa().kHB = com.tencent.mm.platformtools.g.a(d.class.hashCode(), stringBuilder2, kHz, false);
            }
            bEa.rWi = new k(bEa().kHB);
        }
        return bEa().rWi;
    }

    public final HashMap<Integer, com.tencent.mm.by.h.d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void bq(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        ar.Hg();
        stringBuilder.append(com.tencent.mm.z.c.FB()).append("CommonOneMicroMsg.db");
        bEb();
        com.tencent.mm.sdk.b.a.xef.b(this.rWm);
        com.tencent.mm.sdk.b.a.xef.b(this.rWn);
        com.tencent.mm.sdk.b.a.xef.b(this.rWo);
        x.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", new Object[]{Integer.valueOf(hashCode())});
    }

    public final void br(boolean z) {
        ar.Hg();
        String FC = com.tencent.mm.z.c.FC();
        if (bh.ov(FC) || bh.ov(this.gQi) || !FC.equals(this.gQi)) {
            x.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : " + FC);
            this.gQi = FC;
            File file = new File(FC);
            if (!file.exists()) {
                file.mkdirs();
            }
            ar.Hg();
            File file2 = new File(com.tencent.mm.z.c.Fz());
            if (!file2.exists()) {
                file2.mkdirs();
            }
        }
    }

    public final void onAccountRelease() {
        if (this.rWk != null) {
            this.rWk.flT = 0;
        }
        if (rWj != null) {
            x.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = rWj;
            if (dVar.kHB != null) {
                dVar.kHB.iV(dVar.hashCode());
                dVar.kHB = null;
            }
            dVar.gQi = "";
        }
        com.tencent.mm.sdk.b.a.xef.c(this.rWm);
        com.tencent.mm.sdk.b.a.xef.c(this.rWn);
        com.tencent.mm.sdk.b.a.xef.c(this.rWo);
    }

    public static j bEc() {
        g.Dh().Ct();
        if (bEa().rWk == null) {
            bEa().rWk = new j();
        }
        return bEa().rWk;
    }
}
