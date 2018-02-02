package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.text.TextUtils;
import com.tencent.mm.ae.k;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.offline.a.e;
import com.tencent.mm.plugin.offline.a.s.b;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.25;
import com.tencent.mm.plugin.offline.ui.b.2;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.m;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class c {
    Vibrator kEd;
    Activity mActivity;
    a oXF;
    m oXG;
    float oXH = 0.0f;
    int oXI = HardCoderJNI.sHCENCODEVIDEOTIMEOUT;

    static /* synthetic */ void a(c cVar) {
        x.i("MicroMsg.OfflineLogicMgr", "closeOffline");
        if (cVar.oXF != null) {
            cVar.oXF.bhj();
        }
    }

    public c(Activity activity, a aVar) {
        this.mActivity = activity;
        this.oXF = aVar;
    }

    public final void a(k kVar, int i, String str) {
        a(kVar, i, str, null);
    }

    public final void a(k kVar, int i, String str, String str2) {
        x.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        bhm();
        if (i == 409) {
            x.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + str);
            h.a(this.mActivity, str, "", getString(a$i.uXO), getString(a$i.dEn), new OnClickListener(this) {
                final /* synthetic */ c oXK;

                {
                    this.oXK = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    com.tencent.mm.pluginsdk.wallet.h.X(this.oXK.mActivity, 0);
                    x.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new 2(this));
        } else if (i == JsApiBatchGetContact.CTRL_INDEX) {
            x.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + str);
            h.a(this.mActivity, str, "", getString(a$i.uUs), getString(a$i.dEn), new 16(this), new 17(this));
        } else if (i == 413) {
            x.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + str);
            h.a(this.mActivity, str, "", getString(a$i.uXy), getString(a$i.dEn), new 3(this), new 4(this));
        } else if (i == 411) {
            if (o.bLq().bLJ() || o.bLq().bLN()) {
                x.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                return;
            }
            if (com.tencent.mm.plugin.offline.k.oWd && (this.mActivity instanceof WalletOfflineCoinPurseUI)) {
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = (WalletOfflineCoinPurseUI) this.mActivity;
                walletOfflineCoinPurseUI.oYe.setVisibility(4);
                walletOfflineCoinPurseUI.oYt.a(walletOfflineCoinPurseUI.oXW, new 25(walletOfflineCoinPurseUI), 6);
            } else {
                a.c(this.mActivity, str);
            }
            g.pQN.a(135, 1, 1, true);
        } else if (!(this.mActivity instanceof WalletBaseUI)) {
            b.b(this.mActivity, str);
        } else if (!f.a((WalletBaseUI) this.mActivity, kVar, 1000, i, str)) {
            String string;
            Context context = this.mActivity;
            if (TextUtils.isEmpty(str)) {
                string = context.getString(a$i.uXa);
            } else {
                string = str;
            }
            if (bh.ov(str2)) {
                b.b(context, string);
                return;
            }
            x.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            h.a(context, string, null, context.getResources().getString(a$i.uRv), context.getResources().getString(a$i.dFU), true, new 2(str2, context), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + kVar.getType());
        e eVar;
        if (i == 0 && i2 == 0) {
            if (!(kVar instanceof e)) {
                return false;
            }
            eVar = (e) kVar;
            Object obj = eVar.oWp;
            bhm();
            if (eVar.oWq != 0 || TextUtils.isEmpty(obj)) {
                if (!(eVar.oWq == 0 || eVar.liH == 0 || eVar.oWs != 1)) {
                    x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                    a(eVar, eVar.oWq, eVar.oWr);
                }
                return true;
            }
            a.a(this.mActivity, obj, kVar);
            this.mActivity.setResult(-1);
            this.mActivity.finish();
            return true;
        } else if (!(kVar instanceof e)) {
            return false;
        } else {
            eVar = (e) kVar;
            bhm();
            if (eVar.oWs == 1) {
                x.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(kVar, i2, str);
            }
            return true;
        }
    }

    public final void bhm() {
        if (this.oXG != null) {
            this.oXG.dismiss();
            this.oXG = null;
        }
    }

    public final void a(b bVar) {
        if (bVar != null) {
            x.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
            if ("1".equals(bVar.oXg)) {
                h.a(this.mActivity, false, bVar.oXi, "", getString(a$i.uXJ), getString(a$i.dEn), new OnClickListener(this) {
                    final /* synthetic */ c oXK;

                    {
                        this.oXK = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        a.D(this.oXK.mActivity);
                        x.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    }
                }, new 6(this));
            }
        }
    }

    public static boolean bhn() {
        com.tencent.mm.plugin.offline.k.bgX();
        if (com.tencent.mm.plugin.offline.k.bgY().oXc != null) {
            return true;
        }
        return false;
    }

    final String getString(int i) {
        return this.mActivity.getString(i);
    }
}
