package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.provider.Settings.Secure;
import android.provider.Settings.SettingNotFoundException;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.downloader.e.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader.model.g$a;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.io.File;

public abstract class d implements OnClickListener {
    protected long jcE = -1;
    protected Context mContext;
    protected int mStatus = -1;
    protected com.tencent.mm.plugin.game.model.d nbT = null;
    protected int ndn;
    protected String nld;
    protected FileDownloadTaskInfo nle;
    protected a nlf;
    protected String nlg;
    protected String nlh;
    protected String nli;
    private String nlj = "xiaomi";

    public d(Context context) {
        this.mContext = context;
    }

    public final void qO(int i) {
        this.ndn = i;
    }

    protected final void aRm() {
        q.e(this.mContext, Uri.fromFile(new File(this.nle.path)));
    }

    protected final void aRn() {
        g.Y(this.mContext, this.nbT.field_appId);
    }

    protected final void fD(boolean z) {
        if (an.isNetworkConnected(this.mContext)) {
            ar.Hg();
            if (!c.isSDCardAvailable()) {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.emj), 0).show();
                n.aQg();
                n.a(this.nbT.field_appId, com.tencent.mm.plugin.downloader.model.d.lsb, false, null);
                return;
            } else if (f.aC(this.nbT.nbk)) {
                if (com.tencent.mm.protocal.d.vAs.toLowerCase().contains(this.nlj)) {
                    try {
                        if (Secure.getInt(this.mContext.getContentResolver(), "install_non_market_apps") == 0 && !this.mContext.getSharedPreferences("game_center_pref", 0).getBoolean("show_open_download_authority_tips", false)) {
                            h.a(this.mContext, R.l.enc, R.l.ene, R.l.enl, R.l.dEn, false, new 3(this), new 4(this));
                            this.mContext.getSharedPreferences("game_center_pref", 0).edit().putBoolean("show_open_download_authority_tips", true).commit();
                        }
                    } catch (SettingNotFoundException e) {
                        x.e("MicroMsg.CommonGameClickLinstener", "SettingNotFoundException ; %S", new Object[]{e.getMessage()});
                    }
                }
                if (bh.ov(this.nbT.fQE) || bh.ov(this.nbT.fQJ)) {
                    x.d("MicroMsg.CommonGameClickLinstener", "downloadApk: appdownloadurl is null or appmd5 is null, try gpDownload");
                    if (bh.ov(this.nbT.fQK)) {
                        x.e("MicroMsg.CommonGameClickLinstener", "downloadApk fail, gpDownloadUrl is null");
                    } else {
                        boolean aY = q.aY(this.mContext, this.nbT.fQK);
                        x.d("MicroMsg.CommonGameClickLinstener", "downloadApk with gp, ret = %b", new Object[]{Boolean.valueOf(aY)});
                    }
                    if (bh.ov(this.nbT.fQE)) {
                        n.aQg();
                        n.a(this.nbT.field_appId, com.tencent.mm.plugin.downloader.model.d.DOWNLOAD_ERR_URL_INVALID, false, null);
                    }
                    if (bh.ov(this.nbT.fQJ)) {
                        n.aQg();
                        n.a(this.nbT.field_appId, com.tencent.mm.plugin.downloader.model.d.lrY, false, null);
                        return;
                    }
                    return;
                }
                ap.a(this.mContext, this.nbT.scene, this.nbT.fFj, this.nbT.position, 4, this.nbT.field_appId, this.ndn, this.nbT.fop, this.nlh);
                if (an.isWifi(this.mContext)) {
                    fE(z);
                    return;
                }
                com.tencent.mm.plugin.report.service.g.pQN.h(14217, new Object[]{this.nbT.field_appId, Integer.valueOf(4), "", this.nbT.fQE, Integer.valueOf(2)});
                h.a(this.mContext, this.mContext.getString(R.l.eWB), this.mContext.getString(R.l.eWC), this.mContext.getString(R.l.eWw), this.mContext.getString(R.l.dEn), false, new 1(this, z), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ d nll;

                    {
                        this.nll = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        com.tencent.mm.plugin.report.service.g.pQN.h(14217, new Object[]{this.nll.nbT.field_appId, Integer.valueOf(6), "", this.nll.nbT.fQE, Integer.valueOf(2)});
                        dialogInterface.dismiss();
                        x.i("MicroMsg.CommonGameClickLinstener", "addDownloadTask not wifi, user cancel");
                    }
                }, R.e.bui);
                return;
            } else {
                Toast.makeText(this.mContext, this.mContext.getString(R.l.emi), 0).show();
                n.aQg();
                n.a(this.nbT.field_appId, com.tencent.mm.plugin.downloader.model.d.lsb, false, null);
                return;
            }
        }
        Toast.makeText(this.mContext, this.mContext.getString(R.l.emh), 0).show();
        n.aQg();
        n.a(this.nbT.field_appId, com.tencent.mm.plugin.downloader.model.d.lsa, false, null);
    }

    private void fE(boolean z) {
        long a;
        if (z) {
            n.a(this.nbT.fQE, this.nbT.fQJ, this.nbT.fFj, this.nbT.field_appId, this.nlg, "app_update");
        } else {
            n.a(this.nbT.fQE, this.nbT.fQJ, this.nbT.fFj, this.nbT.field_appId, this.nlg, this.nli);
        }
        g$a com_tencent_mm_plugin_downloader_model_g_a = new g$a();
        com_tencent_mm_plugin_downloader_model_g_a.xL(this.nbT.fQE);
        com_tencent_mm_plugin_downloader_model_g_a.xM(this.nbT.nbj);
        com_tencent_mm_plugin_downloader_model_g_a.ci(this.nbT.nbk);
        com_tencent_mm_plugin_downloader_model_g_a.xN(com.tencent.mm.pluginsdk.model.app.g.a(this.mContext, this.nbT, null));
        com_tencent_mm_plugin_downloader_model_g_a.setAppId(this.nbT.field_appId);
        com_tencent_mm_plugin_downloader_model_g_a.xO(this.nbT.fQJ);
        com_tencent_mm_plugin_downloader_model_g_a.ep(true);
        com_tencent_mm_plugin_downloader_model_g_a.ox(1);
        com_tencent_mm_plugin_downloader_model_g_a.cu(this.nbT.field_packageName);
        com_tencent_mm_plugin_downloader_model_g_a.lw(this.nbT.fFj);
        if (this.nbT.fwH == 1) {
            com.tencent.mm.plugin.downloader.model.f aAd = com.tencent.mm.plugin.downloader.model.f.aAd();
            com.tencent.mm.plugin.downloader.model.g gVar = com_tencent_mm_plugin_downloader_model_g_a.lsE;
            x.i("MicroMsg.FileDownloadManager", "addDownloadTaskByCDNDownloader, appId = %s", new Object[]{gVar.mAppId});
            if (com.tencent.mm.kernel.g.Dh().Cy()) {
                com.tencent.mm.kernel.g.Dh();
                if (!com.tencent.mm.kernel.a.Cs()) {
                    a = aAd.aAh().a(gVar);
                }
            }
            a = aAd.aAf().a(gVar);
            if (a >= 0) {
                com.tencent.mm.plugin.downloader.model.f.lsh.put(Long.valueOf(a), Long.valueOf(0));
                ac.getContext().getSharedPreferences("off_line_download_ids", 0).edit().putLong(String.valueOf(a), 0).commit();
                x.i("MicroMsg.FileDownloadManager", "Add id: %d to offline ids", new Object[]{Long.valueOf(a)});
            } else {
                x.i("MicroMsg.FileDownloadManager", "add download task to system downloader failed, use browser to download it");
                aAd.aAg().a(gVar);
            }
        } else {
            a = com.tencent.mm.plugin.downloader.model.f.aAd().a(com_tencent_mm_plugin_downloader_model_g_a.lsE);
        }
        x.i("MicroMsg.CommonGameClickLinstener", " add download task result:[%d], appid[%s]，downloaerType[%d]", new Object[]{Long.valueOf(a), this.nbT.field_appId, Integer.valueOf(this.nbT.fwH)});
        g.Z(this.mContext, this.nbT.field_appId);
    }

    protected final void aRo() {
        this.nlf = e.xE(this.nbT.field_appId);
        this.nle = com.tencent.mm.plugin.downloader.model.f.aAd().xI(this.nbT.field_appId);
        this.jcE = this.nle.id;
        this.mStatus = this.nle.status;
        this.nld = this.nle.path;
    }
}
