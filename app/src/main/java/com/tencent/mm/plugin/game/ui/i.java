package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.io.File;

public final class i extends d {
    public i(Context context) {
        super(context);
    }

    public final void cN(String str, String str2) {
        this.nlh = str;
        this.nli = str2;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof d) {
            boolean z;
            this.nbT = (d) view.getTag();
            x.i("MicsoMsg.GameClickListener", "Clicked appid = " + this.nbT.field_appId);
            aRo();
            if (this.nle == null || !this.nle.lsK) {
                z = false;
            } else {
                this.nle.lsK = false;
                if (this.nlf != null) {
                    this.nlf.field_autoInstall = true;
                    this.nlf.field_showNotification = true;
                    this.nlf.field_autoDownload = false;
                    e.c(this.nlf);
                }
                z = true;
            }
            if (g.m(this.mContext, this.nbT.field_appId)) {
                int i;
                int i2;
                if (this.nbT instanceof d) {
                    int Cl = c.Cl(this.nbT.field_packageName);
                    i = this.nbT.versionCode;
                    i2 = Cl;
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (i > i2) {
                    x.i("MicsoMsg.GameClickListener", "AppId: %s installed, local: %d, server: %d", new Object[]{this.nbT.field_appId, Integer.valueOf(i2), Integer.valueOf(i)});
                    n.a(this.nbT.fQE, this.nbT.fQJ, this.nbT.fFj, this.nbT.field_appId, this.nlg, "app_update");
                    if (this.nle.status == 1) {
                        if (!z) {
                            x.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + f.aAd().bZ(this.nle.id));
                            return;
                        }
                        return;
                    } else if (this.nle.status == 2) {
                        if (f.aAd().ca(this.nle.id)) {
                            com.tencent.mm.plugin.game.model.g.Z(this.mContext, this.nbT.field_appId);
                            ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 4, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                            return;
                        }
                        x.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
                        fD(true);
                        return;
                    } else if (this.nle.status != 3) {
                        fD(true);
                        return;
                    } else if (!com.tencent.mm.a.e.bO(this.nle.path) || c.Cm(this.nle.path) <= i2) {
                        fD(true);
                        return;
                    } else {
                        q.e(this.mContext, Uri.fromFile(new File(this.nle.path)));
                        ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 8, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                        return;
                    }
                }
                x.i("MicsoMsg.GameClickListener", "launchFromWX, appId = %s, pkg = %s, openId = %s", new Object[]{this.nbT.field_appId, this.nbT.field_packageName, this.nbT.field_openId});
                ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 3, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                aRn();
                return;
            } else if (this.nbT.aPT()) {
                c.p(this.mContext, this.nbT.nbl.niY, "game_center_hv_game");
                ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 29, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                return;
            } else {
                n.a(this.nbT.fQE, this.nbT.fQJ, this.nbT.fFj, this.nbT.field_appId, this.nlg, this.nli);
                switch (this.mStatus) {
                    case 1:
                        if (!z) {
                            x.e("MicsoMsg.GameClickListener", "pauseDownloadTask ret = " + f.aAd().bZ(this.nle.id));
                            return;
                        }
                        return;
                    case 2:
                        if (!an.isNetworkConnected(this.mContext)) {
                            Toast.makeText(this.mContext, this.mContext.getString(R.l.emh), 0).show();
                            return;
                        } else if (an.isWifi(this.mContext)) {
                            aRx();
                            return;
                        } else {
                            h.a(this.mContext, this.mContext.getString(R.l.eWB), this.mContext.getString(R.l.eWC), this.mContext.getString(R.l.eWw), this.mContext.getString(R.l.dEn), false, new 1(this), new 2(this), R.e.bui);
                            return;
                        }
                    case 3:
                        if (!bh.ov(this.nld) && com.tencent.mm.a.e.bO(this.nld) && c.cO(this.nld, this.nlf.field_md5)) {
                            aRm();
                            ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 8, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                            return;
                        }
                        fD(false);
                        return;
                    default:
                        fD(false);
                        return;
                }
            }
        }
        x.e("MicsoMsg.GameClickListener", "No AppInfo");
    }

    private void aRx() {
        if (f.aAd().ca(this.nlf.field_downloadId)) {
            com.tencent.mm.plugin.game.model.g.Z(this.mContext, this.nbT.field_appId);
            ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 4, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
            return;
        }
        x.e("MicsoMsg.GameClickListener", "resumeDownloadTask false");
        f.aAd().bX(this.nlf.field_downloadId);
        fD(false);
    }
}
