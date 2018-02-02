package com.tencent.mm.sandbox.updater;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sandbox.updater.j.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI xcm = null;
    private Button krZ;
    private i pyk = null;
    private OnClickListener xci = new 10(this);
    private Button xcl;
    private j xcn;
    private g xco = new 1(this);
    private OnClickListener xcp = new 9(this);

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, c cVar) {
        x.d("MicroMsg.AppUpdaterUI", "showDownloadFullPackAlert()");
        i a = h.a(appUpdaterUI, appUpdaterUI.getString(R.l.ejq, new Object[]{bh.bx((long) appUpdaterUI.xcn.size)}), appUpdaterUI.getString(R.l.dGO), new 12(appUpdaterUI, cVar));
        a.setOnCancelListener(new 13(appUpdaterUI));
        a.setCanceledOnTouchOutside(false);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, String str) {
        g.pQN.a(405, 70, 1, true);
        if (appUpdaterUI.xcn.xdD) {
            g.pQN.a(614, 50, 1, false);
        }
        new af().postDelayed(new 11(appUpdaterUI, str), 300);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        g.pQN.a(405, 65, 1, true);
        h.a(appUpdaterUI, appUpdaterUI.getString(R.l.eSa), appUpdaterUI.getString(R.l.dGO), new 3(appUpdaterUI)).setOnCancelListener(new 4(appUpdaterUI));
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        g.pQN.a(405, 66, 1, true);
        h.a(appUpdaterUI, appUpdaterUI.getString(R.l.eSd), appUpdaterUI.getString(R.l.dGO), new 14(appUpdaterUI)).setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI xcq;

            {
                this.xcq = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(this.xcq);
            }
        });
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        x.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.xcn.xdE) {
            h.b(appUpdaterUI, R.l.dNn, R.l.dGO, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI xcq;

                {
                    this.xcq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    x.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (this.xcq.pyk != null && this.xcq.pyk.isShowing()) {
                        this.xcq.pyk.dismiss();
                    }
                    i.ae(this.xcq, 6);
                    if (this.xcq.xcn.xdD) {
                        g.pQN.a(614, 59, 1, true);
                        x.d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
                    }
                    this.xcq.xcn.cancel();
                    this.xcq.xcn.ac(2, true);
                    this.xcq.cel();
                }
            }, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI xcq;

                {
                    this.xcq = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.xcq.pyk != null && !this.xcq.pyk.isShowing()) {
                        this.xcq.pyk.show();
                    }
                }
            });
            return;
        }
        if (appUpdaterUI.xcn.ruR == 1) {
            i.af(appUpdaterUI, 7);
            if (appUpdaterUI.xcn.xdD) {
                g.pQN.a(614, 57, 1, true);
                x.d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        i.ae(appUpdaterUI, 6);
        appUpdaterUI.xcn.ac(2, true);
        appUpdaterUI.cel();
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        appUpdaterUI.xcn.cancel();
        appUpdaterUI.xcn.ac(2, true);
        appUpdaterUI.cel();
    }

    public static AppUpdaterUI cej() {
        return xcm;
    }

    public static void cek() {
        if (xcm != null) {
            xcm.cel();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.h(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.cei() != null && !AppInstallerUI.cei().isFinishing()) {
            x.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
        } else if (xcm == null || xcm.isFinishing() || xcm == this) {
            xcm = this;
            setContentView(R.i.empty);
            this.xcn = a.xdL;
            if (!this.xcn.ag(getIntent())) {
                x.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                cel();
            } else if (this.xcn.xcb != 999 || this.xcn.xcD == null || this.xcn.xcD.length <= 0) {
                String string;
                x.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.xcn.xcD);
                i.a aVar = new i.a(this);
                aVar.Ez(R.l.ejp);
                aVar.mi(true);
                aVar.d(new 8(this));
                if (!this.xcn.xdz || this.xcn.xdy == null) {
                    x.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.l.ejr, new Object[]{this.xcn.desc, getString(R.l.eRU), bh.bx((long) this.xcn.size)});
                } else {
                    string = getString(R.l.ejr, new Object[]{this.xcn.desc, getString(R.l.eRY), bh.bx((long) this.xcn.xdy.size)});
                }
                int i = this.xcn.xcb != 1 ? R.l.eRQ : R.l.eRT;
                aVar.YG(string);
                aVar.EC(R.l.eSc).a(false, this.xci);
                aVar.ED(i);
                this.pyk = aVar.akx();
                this.pyk.setCanceledOnTouchOutside(false);
                this.xcl = this.pyk.getButton(-1);
                this.krZ = this.pyk.getButton(-2);
                this.pyk.show();
                if (this.xcn.ruR == 1) {
                    i.af(this, 5);
                }
                if (this.xcn.xdD) {
                    g.pQN.a(614, 60, 1, false);
                }
                j jVar = this.xcn;
                g gVar = this.xco;
                if (gVar != null && !jVar.xdu.contains(gVar)) {
                    jVar.xdu.add(gVar);
                }
            } else {
                x.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new af().postDelayed(new Runnable(this) {
                    final /* synthetic */ AppUpdaterUI xcq;

                    {
                        this.xcq = r1;
                    }

                    public final void run() {
                        h.a(this.xcq, this.xcq.xcn.desc, this.xcq.getString(R.l.dGO), new 1(this)).setOnCancelListener(new 2(this));
                    }
                }, 100);
            }
        } else {
            x.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            x.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
        }
    }

    protected void onDestroy() {
        x.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.i(hashCode(), this);
        if (this.xcn != null) {
            j jVar = this.xcn;
            jVar.xdu.remove(this.xco);
        }
        if (xcm == this) {
            xcm = null;
        }
        super.onDestroy();
    }

    private void cel() {
        if (this.pyk != null && this.pyk.isShowing()) {
            this.pyk.dismiss();
        }
        finish();
    }
}
