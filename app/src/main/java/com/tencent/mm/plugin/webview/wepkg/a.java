package com.tencent.mm.plugin.webview.wepkg;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.b;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.regex.Pattern;

public final class a {
    private static final Pattern mXS = Pattern.compile(".*#.*wechat_redirect");
    private ak fhK;
    private MMWebView juE;
    private MMActivity kaY;
    private String mXZ;
    private boolean tLp;
    private f tLq;
    private WepkgVersion tLr;
    private long tLs;
    public a tLt;
    private int tLu;
    public c tLv;
    public b tLw;
    private a tLx;

    static /* synthetic */ void a(a aVar, int i) {
        SharedPreferences sharedPreferences = aVar.kaY.getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("white_screen_times", i).commit();
        }
    }

    static /* synthetic */ void a(a aVar, boolean z) {
        x.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:" + z);
        ag.y(new 5(aVar, z));
    }

    static /* synthetic */ a c(a aVar) {
        return aVar.tLt == null ? aVar.tLx : aVar.tLt;
    }

    static /* synthetic */ int f(a aVar) {
        SharedPreferences sharedPreferences = aVar.kaY.getSharedPreferences("we_pkg_sp", 4);
        return sharedPreferences != null ? sharedPreferences.getInt("white_screen_times", 0) : 0;
    }

    static /* synthetic */ void h(a aVar) {
        SharedPreferences sharedPreferences = aVar.kaY.getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
            sharedPreferences.edit().putBoolean("disable_we_pkg", true).commit();
        }
    }

    public a(MMActivity mMActivity, MMWebView mMWebView) {
        this.tLp = false;
        this.tLs = 0;
        this.tLu = 0;
        this.fhK = new ak(new 3(this), false);
        this.tLv = new c(this);
        this.tLw = new b(this);
        this.tLx = new 4(this);
        this.kaY = mMActivity;
        this.juE = mMWebView;
    }

    public a(MMActivity mMActivity, MMWebView mMWebView, int i) {
        this(mMActivity, mMWebView);
        this.tLu = i;
        if (!WepkgMainProcessService.agP()) {
            d.a("", null);
        }
    }

    public final boolean PN(String str) {
        if (this.tLu == 0) {
            this.tLu = this.kaY.hashCode();
        }
        b.tNU.add(Integer.valueOf(this.tLu));
        this.mXZ = str;
        if (!d.Qt(this.mXZ)) {
            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mXZ, d.Qq(this.mXZ), null, 2, 0, null);
        } else if (WepkgMainProcessService.agP()) {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is live");
            this.tLq = g.Qd(this.mXZ);
            if (!(this.tLq == null || this.tLq.tMS == null)) {
                this.tLp = true;
                this.tLr = this.tLq.tMS;
            }
            d.Dm().g(new 2(this), 0);
            x.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s", new Object[]{Boolean.valueOf(this.tLp)});
            if (this.tLp && this.tLr != null) {
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mXZ, this.tLr.tNm, this.tLr.version, 1, 0, null);
            }
        } else {
            x.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is dead");
            d.a(this.mXZ, new com.tencent.mm.plugin.webview.wepkg.model.a(this) {
                final /* synthetic */ a tLy;

                {
                    this.tLy = r1;
                }

                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    if (baseWepkgProcessTask instanceof WepkgCrossProcessTask) {
                        final String str = ((WepkgCrossProcessTask) baseWepkgProcessTask).tMW;
                        d.Dm().F(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 tLz;

                            public final void run() {
                                g.Qd(str);
                                WepkgVersionManager.U(d.Qq(str), 0, this.tLz.tLy.tLu);
                            }
                        });
                    }
                }
            });
            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mXZ, d.Qq(this.mXZ), null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.Bi(10));
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "pkgid:%s,  wepkgAvailable:%b", new Object[]{d.Qq(str), Boolean.valueOf(this.tLp)});
        return this.tLp;
    }

    public final void onDestroy() {
        if (b.tNU.contains(Integer.valueOf(this.tLu))) {
            b.tNU.remove(Integer.valueOf(this.tLu));
        }
        if (b.tNU.size() == 0) {
            b.tNV.tNX.clear();
            x.i("MicroMsg.Wepkg.WePkgPlugin", "clear wepkg info in memory");
        }
    }

    public final void bUX() {
        x.i("MicroMsg.Wepkg.WePkgPlugin", "disable current wepkg");
        this.tLp = false;
    }

    public final boolean PO(String str) {
        if (mXS.matcher(bh.ou(str)).find()) {
            return false;
        }
        return this.tLp;
    }

    public final boolean bUY() {
        return this.tLr == null || !this.tLr.tNC;
    }
}
