package com.tencent.mm.sandbox.updater;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.c.i;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.h.p;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class j implements a, g {
    public String desc;
    public int fdU;
    public String fdW;
    public String fqR;
    public int fyp;
    public byte[] hZs;
    public byte[] hZu;
    public byte[] hnJ;
    private Intent intent;
    protected Context mContext;
    public int ruR;
    private Notification sbc;
    public int size;
    public int uin;
    public String[] xcD;
    public int xcb;
    public boolean xdA;
    public boolean xdB;
    public String xdC;
    public boolean xdD;
    boolean xdE;
    long xdF;
    f xdG;
    private long xdH;
    private com.tencent.mm.sandbox.b.a xdI;
    c xdt;
    ArrayList<g> xdu;
    public String[] xdv;
    public String xdw;
    public i xdx;
    public com.tencent.mm.c.i.a xdy;
    public boolean xdz;

    private static final class a {
        public static final j xdL = new j();
    }

    static /* synthetic */ void a(j jVar, int i, int i2) {
        CharSequence string = jVar.mContext.getString(R.l.dEB);
        CharSequence charSequence;
        Intent intent;
        Builder contentIntent;
        if (i < i2) {
            long j = (((long) i) * 100) / ((long) i2);
            if (j - jVar.xdH >= 1) {
                jVar.xdH = j;
                charSequence = jVar.mContext.getString(R.l.dEE) + String.valueOf(jVar.xdH) + "%";
                intent = new Intent(jVar.intent);
                intent.setClass(jVar.mContext, AppUpdaterUI.class);
                intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
                contentIntent = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728));
                contentIntent.setLargeIcon(BitmapFactory.decodeResource(jVar.mContext.getResources(), R.g.bHe));
                contentIntent.setSmallIcon(com.tencent.mm.bl.a.bXV());
                jVar.sbc = contentIntent.getNotification();
                jVar.sbc.icon = R.g.bHe;
            } else {
                return;
            }
        } else if (!jVar.xdD || e.bO(jVar.xdt.ceg())) {
            charSequence = jVar.mContext.getString(R.l.dEA);
            intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.fromFile(new File(jVar.xdt.ceg())), "application/vnd.android.package-archive");
            intent.addFlags(SQLiteDatabase.ENABLE_WRITE_AHEAD_LOGGING);
            contentIntent = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(charSequence).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728));
            contentIntent.setLargeIcon(BitmapFactory.decodeResource(jVar.mContext.getResources(), R.g.bHe));
            contentIntent.setSmallIcon(com.tencent.mm.bl.a.bXV());
            jVar.sbc = contentIntent.getNotification();
            jVar.sbc.icon = R.g.bHe;
            Notification notification = jVar.sbc;
            notification.flags |= 16;
        } else {
            x.i("MicroMsg.UpdaterManager", "do noting. wait for merge apk.");
        }
        if (!jVar.xdA) {
            ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.sbc);
        }
    }

    static /* synthetic */ void b(j jVar) {
        x.i("MicroMsg.UpdaterManager", "showDownloadFullPackNotification()");
        CharSequence string = jVar.mContext.getString(R.l.dED, new Object[]{bh.bx((long) jVar.size)});
        Intent intent = jVar.intent;
        intent.putExtra("intent_extra_force_download_full", true);
        jVar.sbc = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getService(jVar.mContext, 0, intent, 134217728)).getNotification();
        jVar.sbc.icon = R.g.bHe;
        Notification notification = jVar.sbc;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.sbc);
    }

    static /* synthetic */ void e(j jVar) {
        CharSequence string = jVar.mContext.getString(R.l.dEC);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        jVar.sbc = new Builder(jVar.mContext).setTicker(null).setWhen(System.currentTimeMillis()).setContentTitle(string).setContentText(null).setContentIntent(PendingIntent.getActivity(jVar.mContext, 0, intent, 134217728)).getNotification();
        jVar.sbc.icon = R.g.bHe;
        Notification notification = jVar.sbc;
        notification.flags |= 16;
        ((NotificationManager) jVar.mContext.getSystemService("notification")).notify(99, jVar.sbc);
    }

    private j() {
        this.xdt = null;
        this.xdu = new ArrayList(1);
        this.fyp = d.vAz;
        this.xdz = false;
        this.xdA = false;
        this.xdB = false;
        this.xdD = false;
        this.xdE = false;
        this.intent = null;
        this.sbc = null;
        this.mContext = null;
        this.xdG = new f(this);
        this.xdH = -1;
        this.xdI = new 2(this);
        this.mContext = ac.getContext();
    }

    public final void lv(boolean z) {
        x.i("MicroMsg.UpdaterManager", "summerupdate setNetStatChanged isWifi %s", new Object[]{Boolean.valueOf(z)});
        f fVar = this.xdG;
        if (fVar.mrc != z) {
            fVar.lw(true);
            fVar.mrc = z;
        }
        if (this.ruR != 2 || this.xdE) {
            x.i("MicroMsg.UpdaterManager", "downloadMode %s downloading %s", new Object[]{Integer.valueOf(this.ruR), Boolean.valueOf(this.xdE)});
        } else if (z) {
            if (ag(this.intent)) {
                lx(true);
            }
        } else if (this.xdE) {
            cancel();
        }
    }

    public final boolean af(Intent intent) {
        boolean ag = ag(intent);
        x.i("MicroMsg.UpdaterManager", "summerupdate handleCommand(Intent intent) ret need download[%b]", new Object[]{Boolean.valueOf(ag)});
        if (ag) {
            lx(false);
        }
        return ag;
    }

    public final boolean ag(Intent intent) {
        x.i("MicroMsg.UpdaterManager", "handleCommand(Intent intent)");
        if (intent == null) {
            x.i("MicroMsg.UpdaterManager", "intent == null");
            return false;
        }
        int intExtra = intent.getIntExtra("intent_update_type", 3);
        int intExtra2 = intent.getIntExtra("intent_extra_download_mode", 1);
        String stringExtra = intent.getStringExtra("intent_extra_md5");
        if (this.xdE && !stringExtra.equalsIgnoreCase(this.fqR) && this.ruR == 2) {
            cancel();
        } else if (this.xdE) {
            x.i("MicroMsg.UpdaterManager", "downloading, duplicate download request");
            return true;
        }
        i.ceA();
        reset();
        this.intent = intent;
        this.fdU = intent.getIntExtra("intent_extra_updateMode", 0);
        this.fdW = intent.getStringExtra("intent_extra_marketUrl");
        this.xdv = intent.getStringArrayExtra("intent_short_ips");
        this.fyp = intent.getIntExtra("intent_client_version", d.vAz);
        d.vAz = this.fyp;
        this.xcb = intExtra;
        this.hZs = intent.getByteArrayExtra("intent_extra_session");
        this.hnJ = intent.getByteArrayExtra("intent_extra_cookie");
        this.hZu = intent.getByteArrayExtra("intent_extra_ecdhkey");
        this.uin = intent.getIntExtra("intent_extra_uin", 0);
        this.fqR = stringExtra;
        this.desc = intent.getStringExtra("intent_extra_desc");
        this.size = intent.getIntExtra("intent_extra_size", 0);
        this.xcD = intent.getStringArrayExtra("intent_extra_download_url");
        this.ruR = intExtra2;
        this.xdB = intent.getBooleanExtra("intent_extra_force_download_full", false);
        String stringExtra2 = intent.getStringExtra("intent_extra_patchInfo");
        if (stringExtra2 != null) {
            x.i("MicroMsg.UpdaterManager", "patchXml != null");
            this.xdx = i.cj(stringExtra2);
        }
        stringExtra2 = intent.getStringExtra("intent_extra_extinfo");
        x.d("MicroMsg.UpdaterManager", "summerupdate extInfo[%s]", new Object[]{stringExtra2});
        if (!bh.ov(stringExtra2)) {
            this.xdC = (String) bi.y(stringExtra2, "extinfo").get(".extinfo.notautodownloadrange");
            x.i("MicroMsg.UpdaterManager", "summerupdate notAutoDownloadRange[%s]", new Object[]{this.xdC});
        }
        x.i("MicroMsg.UpdaterManager", "summerupdate handleCommand() downloadMode %s downloading %s", new Object[]{Integer.valueOf(intExtra2), Boolean.valueOf(this.xdE)});
        if (intExtra != 999 || this.xcD == null || this.xcD.length <= 0) {
            if (this.xcD != null) {
                for (String str : this.xcD) {
                    x.i("MicroMsg.UpdaterManager", "download url : " + str);
                }
            }
            x.i("MicroMsg.UpdaterManager", "md5 = %s , size = %s", new Object[]{stringExtra, Integer.valueOf(this.size)});
            if (stringExtra == null || this.size == 0) {
                return false;
            }
            if (intExtra == 2) {
                x.i("MicroMsg.UpdaterManager", "summerupdate handleCommandWithoutDownload recommended control[%b]", new Object[]{Boolean.valueOf(b.kK(this.xdC))});
                if (b.kK(this.xdC)) {
                    g.pQN.a(405, 78, 1, true);
                    return false;
                }
            }
            if (this.xdx != null) {
                x.i("MicroMsg.UpdaterManager", "patchInfo != null");
                stringExtra2 = p.ek(this.mContext);
                this.xdy = this.xdx.ci(stringExtra2);
                x.i("MicroMsg.UpdaterManager", "increase apkMD5 = " + stringExtra2 + " : " + (this.xdy == null ? "not match" : "match"));
            }
            x.i("MicroMsg.UpdaterManager", "forceDownloadFull : %s", new Object[]{Boolean.valueOf(this.xdB)});
            this.xdD = intent.getBooleanExtra("intent_extra_tinker_patch", false);
            if ((this.xdy == null || c.UC(stringExtra)) && !this.xdD) {
                x.i("MicroMsg.UpdaterManager", "had try to download full pack.");
            } else {
                x.i("MicroMsg.UpdaterManager", "isIncresmentUpdate");
                this.xdz = true;
            }
            stringExtra2 = i.bYY();
            if (bh.ov(stringExtra2) || stringExtra2.equals(stringExtra)) {
                return true;
            }
            i.ceB();
            return true;
        } else if (intExtra2 != 2) {
            return true;
        } else {
            x.e("MicroMsg.UpdaterManager", "error! DOWNLOAD_MODE_SLIENCE download don't go here! we must process it before start download");
            return true;
        }
    }

    public final void ceC() {
        lx(false);
    }

    private void lx(boolean z) {
        boolean z2 = true;
        x.i("MicroMsg.UpdaterManager", "download() isWifiRetry %s", new Object[]{Boolean.valueOf(z)});
        x.i("MicroMsg.UpdaterManager", "summerupdate download() downloadMode %s downloading %s", new Object[]{Integer.valueOf(this.ruR), Boolean.valueOf(this.xdE)});
        if (this.intent == null) {
            x.e("MicroMsg.UpdaterManager", "download() haven't handleCommand");
        } else if (this.xdE) {
            x.i("MicroMsg.UpdaterManager", "download() downloading, duplicate download request");
        } else if (h.getExternalStorageState().equals("mounted")) {
            if (this.ruR == 2 && !z) {
                i.af(this.mContext, 0);
            }
            String IB = c.IB(this.fqR);
            x.i("MicroMsg.UpdaterManager", IB);
            if (IB != null) {
                x.i("MicroMsg.UpdaterManager", "update package already exist.");
                ac(1, true);
                KY(IB);
                if (this.ruR == 2 && !i.UF(this.fqR)) {
                    i.a(this.fqR, this.xdw, this.desc, this.size, this.ruR, this.xcb, this.xdC);
                    return;
                }
                return;
            }
            if (this.xdB) {
                if (this.xdt != null) {
                    this.xdt.deleteTempFile();
                }
                i.ae(this.mContext, 11);
            }
            if (!this.xdB && this.xdz && this.xdx != null && this.xdy != null) {
                x.i("MicroMsg.UpdaterManager", "Incresment Update");
                i.ae(this.mContext, 5);
                if (f.aC((long) (this.size + this.xdy.size))) {
                    cancel();
                    int i = this.xdy.size;
                    String str = this.fqR;
                    int i2 = this.xcb;
                    String str2 = this.xdx.feh + this.xdy.url;
                    String str3 = this.xdy.fel;
                    String str4 = this.xdy.fek;
                    if (this.ruR != 2) {
                        z2 = false;
                    }
                    this.xdt = new c(i, str, i2, str2, str3, str4, z2);
                    ceE();
                    return;
                }
                ceD();
            } else if (f.aC((long) this.size)) {
                ceF();
            } else {
                x.e("MicroMsg.UpdaterManager", "SDCard is full");
                ceD();
            }
        } else {
            x.e("MicroMsg.UpdaterManager", "no sdcard.");
            MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo() - 86400).commit();
            ac(2, true);
            cem();
        }
    }

    public final void ac(final int i, boolean z) {
        this.xdA = z;
        new af().postDelayed(new Runnable(this) {
            final /* synthetic */ j xdK;

            public final void run() {
                ((NotificationManager) this.xdK.mContext.getSystemService("notification")).cancel(99);
                x.d("MicroMsg.UpdaterManager", "finishType == " + i);
                if (i == 2 && this.xdK.xcb == 1) {
                    Intent intent = new Intent();
                    intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
                    this.xdK.mContext.sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
                }
            }
        }, 300);
    }

    public final void cancel() {
        if (this.xdt != null) {
            this.xdE = false;
            this.xdt.cancel();
            this.xdt = null;
            this.xdF = System.currentTimeMillis();
            this.xdG.stop();
        }
    }

    private void reset() {
        cancel();
        this.fdU = 0;
        this.fdW = null;
        this.xdv = null;
        this.fyp = d.vAz;
        this.xcb = 0;
        this.hZs = null;
        this.hnJ = null;
        this.hZu = null;
        this.uin = 0;
        this.fqR = null;
        this.size = 0;
        this.desc = null;
        this.xcD = null;
        this.xdx = null;
        this.xdy = null;
        this.xdz = false;
        this.xdA = false;
        this.ruR = 0;
        this.xdB = false;
        this.intent = null;
        this.xdE = false;
        this.sbc = null;
        this.xdH = 0;
    }

    private void ceD() {
        MultiProcessSharedPreferences.getSharedPreferences(ac.getContext(), "system_config_prefs", 0).edit().putLong("recomended_update_ignore", bh.Wo() - 86400).commit();
        ac(2, true);
        cen();
    }

    private void ceE() {
        if (this.ruR == 2 && !an.isWifi(this.mContext)) {
            i.cey();
            x.i("MicroMsg.UpdaterManager", "we stop download, when silence and not wifi!");
        } else if (this.ruR == 2 && f.UE(this.fqR)) {
            x.e("MicroMsg.UpdaterManager", "the traffice is overload, not download anymore in silence mode!");
            this.xdG.stop();
        } else {
            this.xdG.cT(this.fqR, this.size);
            if (this.xdt != null) {
                ac(1, false);
                this.xdE = true;
                this.xdt.a(this.xdI);
                bxc();
                if (this.ruR == 2) {
                    i.cey();
                }
            }
        }
    }

    private void ceF() {
        cancel();
        x.i("MicroMsg.UpdaterManager", "downloadFullPack");
        i.ae(this.mContext, 7);
        if (this.xcD == null || this.xcD.length <= 0) {
            this.xdt = new b(this.size, this.fqR, this.xcb, this.uin, this.hZs, this.hnJ, this.xdv, this.ruR == 2);
            g.pQN.a(405, 77, 1, true);
        } else {
            this.xdt = new c(this.size, this.fqR, this.xcb, this.xcD, this.ruR == 2);
            g.pQN.a(405, 76, 1, true);
        }
        ceE();
    }

    public final void cj(int i, int i2) {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cj(i, i2);
        }
    }

    public final void bxc() {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).bxc();
        }
    }

    public final void KY(String str) {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).KY(str);
        }
    }

    public final void a(c cVar) {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a(cVar);
        }
    }

    public final void cem() {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cem();
        }
    }

    public final void cen() {
        Iterator it = this.xdu.iterator();
        while (it.hasNext()) {
            ((g) it.next()).cen();
        }
    }

    public final boolean isBusy() {
        if (this.xdE || System.currentTimeMillis() - this.xdF <= UpdaterService.xdO) {
            x.i("MicroMsg.UpdaterManager", "dont stop, because of updateManager.isDownloading() %s / updateManager.getIdleTimestamp() %s / System.currentTimeMillis() - updateManager.getIdleTimestamp() %s", new Object[]{Boolean.valueOf(this.xdE), Long.valueOf(this.xdF), Long.valueOf(System.currentTimeMillis() - this.xdF)});
            return true;
        }
        x.i("MicroMsg.UpdaterManager", "not busy");
        return false;
    }

    public final void onDestroy() {
        x.i("MicroMsg.UpdaterManager", "onDestroy");
        if (!this.xdE) {
            reset();
            ac(1, true);
        }
    }
}
