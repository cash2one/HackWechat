package com.tencent.mm.plugin.extqlauncher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.by.h.d;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ap;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.bp;
import com.tencent.mm.z.k;
import com.tencent.mm.z.q;
import com.tencent.mm.z.s;
import com.tencent.mm.z.t;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.List;

public final class b implements ap {
    private a mbZ;
    private b mca;
    boolean mcb = false;
    private com.tencent.mm.sdk.e.m.b mcc = new 1(this);
    boolean mcd = false;
    long mce = 0;
    private final long mcf = 300000;
    private final long mcg = 4000;
    private final String mch = "fun1";
    int mci = 0;
    private af mcj = new 3(this, Looper.getMainLooper());

    private class b extends c<ly> {
        final /* synthetic */ b mck;

        private b(b bVar) {
            this.mck = bVar;
            this.xen = ly.class.getName().hashCode();
        }

        /* synthetic */ b(b bVar, byte b) {
            this(bVar);
            this.xen = ly.class.getName().hashCode();
        }

        private boolean a(ly lyVar) {
            if (!b.a(this.mck)) {
                x.e("MicroMsg.SubCoreExtQLauncher", "!isPluginInstall");
                return false;
            } else if (ac.getContext() == null) {
                x.e("MicroMsg.SubCoreExtQLauncher", "MMApplicationContext null");
                return false;
            } else {
                x.d("MicroMsg.SubCoreExtQLauncher", "GetScanCodeEvent callback flag = %s, url = %s", new Object[]{Integer.valueOf(lyVar.fDv.fDt), lyVar.fDv.scanResult});
                try {
                    switch (lyVar.fDv.fDt) {
                        case 0:
                            if (bh.ov(lyVar.fDv.scanResult) || !lyVar.fDv.scanResult.startsWith("qlauncher://")) {
                                return false;
                            }
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.setComponent(new ComponentName("com.tencent.qlauncher", "com.tencent.qlauncher.thirdpartycoop.DispatchActivity"));
                            intent.setData(Uri.parse(lyVar.fDv.scanResult));
                            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            ac.getContext().startActivity(intent);
                            lyVar.fDw.ret = 1;
                            return true;
                        default:
                            return false;
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.SubCoreExtQLauncher", "Exception in ScanCodeResultEvent, %s", new Object[]{e.getMessage()});
                    return false;
                }
            }
        }
    }

    static /* synthetic */ boolean a(b bVar) {
        if (ac.getContext() == null) {
            x.w("MicroMsg.SubCoreExtQLauncher", "isPluginInstall, ApplicationContext null");
            bVar.mcd = false;
            return false;
        } else if (System.currentTimeMillis() - bVar.mce < 300000) {
            return bVar.mcd;
        } else {
            ar.Dm().F(new Runnable(bVar) {
                final /* synthetic */ b mck;

                {
                    this.mck = r1;
                }

                public final void run() {
                    try {
                        this.mck.mce = System.currentTimeMillis();
                        List installedApplications = ac.getContext().getPackageManager().getInstalledApplications(FileUtils.S_IWUSR);
                        if (installedApplications == null) {
                            x.e("MicroMsg.SubCoreExtQLauncher", "getInstalledApplications return null");
                            this.mck.mcd = false;
                            return;
                        }
                        for (int i = 0; i < installedApplications.size(); i++) {
                            ApplicationInfo applicationInfo = (ApplicationInfo) installedApplications.get(i);
                            if (applicationInfo != null && ((bh.ou(applicationInfo.packageName).startsWith("com.tencent.qlauncher") || bh.ou(applicationInfo.packageName).startsWith("com.tencent.qqlauncher") || bh.ou(applicationInfo.packageName).startsWith("com.tencent.launcher")) && applicationInfo.metaData != null)) {
                                String string = applicationInfo.metaData.getString("qlauncher_wx_coop");
                                if (string == null || string.length() <= 0) {
                                    x.w("MicroMsg.SubCoreExtQLauncher", "qlauncher_wx_coop not found, %s, costTime = %s", new Object[]{applicationInfo.packageName, Long.valueOf(System.currentTimeMillis() - this.mck.mce)});
                                    this.mck.mcd = false;
                                } else {
                                    String[] split = string.split(",");
                                    if (split != null) {
                                        for (String ou : split) {
                                            if (bh.ou(ou).trim().equalsIgnoreCase("fun1")) {
                                                x.d("MicroMsg.SubCoreExtQLauncher", "founded qlauncher, %s", new Object[]{applicationInfo.packageName});
                                                this.mck.mcd = true;
                                                return;
                                            }
                                        }
                                    }
                                    this.mck.mcd = false;
                                }
                            }
                        }
                        x.d("MicroMsg.SubCoreExtQLauncher", "qlauncher not founded, costTime = %s", new Object[]{Long.valueOf(System.currentTimeMillis() - this.mck.mce)});
                    } catch (Exception e) {
                        x.e("MicroMsg.SubCoreExtQLauncher", "exception in getApplicationInfo, %s", new Object[]{e.getMessage()});
                        this.mck.mcd = false;
                    }
                }

                public final String toString() {
                    return super.toString() + "|isPluginInstall";
                }
            });
            return bVar.mcd;
        }
    }

    public static b aGb() {
        ar.Ha();
        b bVar = (b) bp.hY("plugin.extqlauncher");
        if (bVar != null) {
            return bVar;
        }
        Object bVar2 = new b();
        ar.Ha().a("plugin.extqlauncher", bVar2);
        return bVar2;
    }

    public final void br(boolean z) {
    }

    public final void bq(boolean z) {
        ar.Hg();
        com.tencent.mm.z.c.Fd().a(this.mcc);
        if (this.mbZ == null) {
            this.mbZ = new a();
        }
        a.xef.b(this.mbZ);
        if (this.mca == null) {
            this.mca = new b();
        }
        a.xef.b(this.mca);
    }

    public final void onAccountRelease() {
        if (this.mbZ != null) {
            a.xef.c(this.mbZ);
        }
        if (this.mca != null) {
            a.xef.c(this.mca);
        }
        ar.Hg();
        com.tencent.mm.z.c.Fd().b(this.mcc);
        this.mcj.removeMessages(0);
    }

    public static int aGc() {
        if (ar.Hj()) {
            int hv = t.hv(s.hfk);
            int FO = k.FO();
            if ((q.FW() & WXMediaMessage.THUMB_LENGTH_LIMIT) == 0) {
                return hv - FO;
            }
            return hv;
        }
        x.w("MicroMsg.SubCoreExtQLauncher", "getMMUnread account not ready");
        return 0;
    }

    public final HashMap<Integer, d> Bn() {
        return null;
    }

    public final void gd(int i) {
    }

    public final void aGd() {
        this.mcj.removeMessages(0);
        this.mcj.sendEmptyMessageDelayed(0, 4000);
    }
}
