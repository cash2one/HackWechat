package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ap;
import com.tencent.mm.plugin.game.model.bj;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.z;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.k;
import java.util.Set;

public final class e {
    private static Object lock = new Object();
    private Context mContext;
    private Dialog mZK;
    int ndn = 0;
    String nlh = null;
    private i nlt = null;
    private w nlu = null;
    private r nlv = null;
    private v nlw = null;
    OnClickListener nlx = null;
    private int nly = 3000;
    private ak nlz = new ak(Looper.getMainLooper(), new 1(this), false);

    public e(Context context) {
        this.mContext = context;
    }

    public final void a(d dVar, o oVar) {
        if (dVar == null || oVar == null) {
            x.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            return;
        }
        View view = new View(this.mContext);
        view.setTag(dVar);
        x.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", new Object[]{Integer.valueOf(dVar.status), Integer.valueOf(oVar.mode), Integer.valueOf(oVar.status)});
        if (g.m(this.mContext, dVar.field_appId) || dVar.aPT()) {
            oVar.mode = 1;
        }
        if (oVar.mode == 3) {
            bj.aQY();
            int g = bj.g(this.mContext, "com.tencent.android.qqdownloader", dVar.fQT);
            x.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", new Object[]{Integer.valueOf(g), Integer.valueOf(dVar.fQT)});
            if (g == -1 || g == 1 || g == 2) {
                oVar.mode = 1;
            }
        }
        FileDownloadTaskInfo xI;
        switch (dVar.status) {
            case 0:
            case 3:
            case 4:
                c BW = SubCoreGameCenter.aRd().BW(dVar.field_appId);
                if (BW != null) {
                    x.i("MicroMsg.GameActionBtnHandler", "delete msg, appid = " + BW.field_appId);
                    SubCoreGameCenter.aRd().a(BW, new String[0]);
                }
                switch (oVar.mode) {
                    case 3:
                        xI = f.aAd().xI(dVar.field_appId);
                        if (xI != null && xI.id > 0) {
                            f.aAd().bX(xI.id);
                        }
                        if (this.nlu == null) {
                            this.nlu = new w(this.mContext);
                        }
                        w wVar = this.nlu;
                        int i = this.ndn;
                        String str = this.nlh;
                        wVar.ndn = i;
                        wVar.nlh = str;
                        this.nlu.onClick(view);
                        break;
                    case 4:
                        if (!bh.ov(dVar.fQK)) {
                            x.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            q.aY(this.mContext, dVar.fQK);
                            ap.a(this.mContext, dVar.scene, dVar.fFj, dVar.position, 25, dVar.field_appId, this.ndn, dVar.fop, this.nlh);
                            break;
                        }
                        break;
                    default:
                        x.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", new Object[]{Integer.valueOf(oVar.mode)});
                        if (this.nlt == null) {
                            this.nlt = new i(this.mContext);
                        }
                        this.nlt.qO(this.ndn);
                        this.nlt.cN(this.nlh, "");
                        this.nlt.onClick(view);
                        break;
                }
                if (dVar.nbb) {
                    Set cM = com.tencent.mm.plugin.game.model.g.cM(this.mContext);
                    if (!a(cM, dVar.field_appId)) {
                        if (oVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dku, null);
                            ((LinearLayout) inflate.findViewById(R.h.cwg)).setGravity(17);
                            TextView textView = (TextView) inflate.findViewById(R.h.cwf);
                            TextView textView2 = (TextView) inflate.findViewById(R.h.cwj);
                            ((ImageView) inflate.findViewById(R.h.cwi)).setBackgroundResource(R.g.bBM);
                            textView.setText(R.l.emn);
                            textView2.setText(R.l.emm);
                            this.mZK = new k(this.mContext, R.m.eYN);
                            this.mZK.setContentView(inflate);
                            this.mZK.setCancelable(true);
                            this.mZK.setCanceledOnTouchOutside(true);
                            this.mZK.show();
                            long j = (long) this.nly;
                            this.nlz.J(j, j);
                        }
                        SubCoreGameCenter.aRg();
                        z.b(dVar.field_appId, 1, 0, null, null);
                        cM.add(dVar.field_appId);
                        this.mContext.getSharedPreferences("game_center_pref", 0).edit().putStringSet("show_download_gift_tips", cM).commit();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                if (this.nlw == null) {
                    this.nlw = new v(this.mContext);
                    this.nlw.nvZ = this.nlx;
                }
                this.nlw.ndn = this.ndn;
                this.nlw.onClick(view);
                ap.a(this.mContext, dVar.scene, dVar.fFj, dVar.position, 9, dVar.field_appId, this.ndn, dVar.fop, this.nlh);
                return;
            case 2:
                xI = f.aAd().xI(dVar.field_appId);
                if (xI != null && xI.id > 0) {
                    f.aAd().bX(xI.id);
                }
                if (this.nlv == null) {
                    this.nlv = new r(this.mContext);
                }
                this.nlv.kFm = this.ndn;
                this.nlv.ntU = dVar.fQO;
                this.nlv.onClick(view);
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ProgressBar progressBar, Button button, d dVar, o oVar) {
        if (progressBar != null && button != null) {
            button.setEnabled(true);
            button.setVisibility(0);
            if (g.a(this.mContext, dVar)) {
                if (dVar.versionCode <= com.tencent.mm.plugin.game.d.c.Cl(dVar.field_packageName)) {
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    if (dVar.scene == 12) {
                        button.setText(R.l.elZ);
                    } else {
                        button.setText(R.l.emy);
                    }
                } else if (oVar.status == 1) {
                    progressBar.setVisibility(0);
                    progressBar.setProgress(oVar.progress);
                    button.setVisibility(8);
                } else {
                    if (dVar.scene == 12) {
                        button.setText(R.l.emb);
                    } else {
                        button.setText(R.l.elQ);
                    }
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                }
                x.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", new Object[]{dVar.field_appId, Integer.valueOf(r0), Integer.valueOf(dVar.versionCode)});
            } else if (dVar.aPT()) {
                button.setVisibility(0);
                progressBar.setVisibility(8);
                if (dVar.scene == 12) {
                    button.setText(R.l.elZ);
                } else {
                    button.setText(R.l.emy);
                }
            } else {
                switch (dVar.status) {
                    case 0:
                        if (oVar == null) {
                            button.setVisibility(8);
                            progressBar.setVisibility(8);
                            return;
                        }
                        switch (oVar.status) {
                            case 0:
                                if (dVar.scene == 12) {
                                    if (dVar.nbb) {
                                        if (!a(com.tencent.mm.plugin.game.model.g.cM(this.mContext), dVar.field_appId)) {
                                            button.setText(R.l.emg);
                                        }
                                    }
                                    button.setText(R.l.emu);
                                } else {
                                    button.setText(R.l.emt);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 1:
                                if (oVar.mode != 3) {
                                    if (oVar.mode == 1) {
                                        progressBar.setProgress(oVar.progress);
                                        button.setVisibility(8);
                                        progressBar.setVisibility(0);
                                        break;
                                    }
                                }
                                button.setText(R.l.emw);
                                break;
                            case 2:
                                if (dVar.scene == 12) {
                                    button.setText(R.l.emf);
                                } else {
                                    button.setText(R.l.emv);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 3:
                                if (dVar.scene == 12) {
                                    button.setText(R.l.ems);
                                } else {
                                    button.setText(R.l.emr);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            default:
                                break;
                        }
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    case 1:
                        if (!dVar.naU) {
                            button.setText(R.l.elN);
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        }
                        button.setEnabled(false);
                        button.setText(R.l.elO);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    case 2:
                        button.setText(R.l.elM);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    case 3:
                        if (oVar != null) {
                            switch (oVar.status) {
                                case 0:
                                    button.setText(R.l.elL);
                                    break;
                                case 1:
                                    if (oVar.mode != 3) {
                                        if (oVar.mode == 1) {
                                            progressBar.setProgress(oVar.progress);
                                            button.setVisibility(8);
                                            progressBar.setVisibility(0);
                                            break;
                                        }
                                    }
                                    button.setText(R.l.emw);
                                    break;
                                    break;
                                case 2:
                                    if (dVar.scene == 12) {
                                        button.setText(R.l.emf);
                                    } else {
                                        button.setText(R.l.emv);
                                    }
                                    button.setVisibility(0);
                                    progressBar.setVisibility(8);
                                    break;
                                case 3:
                                    if (dVar.scene != 12) {
                                        button.setText(R.l.emr);
                                        break;
                                    } else {
                                        button.setText(R.l.ems);
                                        break;
                                    }
                                default:
                                    break;
                            }
                            button.setVisibility(0);
                            progressBar.setVisibility(8);
                            break;
                        }
                        button.setText(R.l.elL);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        return;
                    case 4:
                        button.setText(R.l.elP);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    default:
                        button.setVisibility(8);
                        progressBar.setVisibility(8);
                        break;
                }
                x.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", new Object[]{dVar.field_appId, Integer.valueOf(dVar.status), button.getText()});
            }
        }
    }

    private static boolean a(Set<String> set, String str) {
        if (set == null || set.isEmpty() || !set.contains(str)) {
            return false;
        }
        return true;
    }
}
