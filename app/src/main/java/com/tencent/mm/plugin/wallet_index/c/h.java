package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.t;
import java.util.ArrayList;
import java.util.regex.Pattern;

public final class h extends c<sz> implements e {
    int taq;
    int tar;
    gw tas;
    lm tat;
    long tau;
    public c tav;
    public c<lm> taw;

    public h() {
        this.tar = 0;
        this.tav = new 1(this);
        this.taw = new 2(this);
        this.xen = sz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        sz szVar = (sz) bVar;
        p.cBw();
        if (szVar instanceof sz) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onPayEnd, isOk = " + (szVar.fLs.result == -1));
            a.xef.c(this);
            if (szVar.fLs.result != -1) {
                return true;
            }
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (szVar.fLs.intent == null || szVar.fLs.intent.getIntExtra("pay_channel", 0) != 13) {
                d.a(ac.getContext(), ".ui.LauncherUI", intent);
                return true;
            }
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "channel is MMPAY_CHANNEL_SCAN_QRCODE_IMAGE_CHANNEL ，return org page");
            return true;
        }
        x.f("MicroMsg.WalletGetA8KeyRedirectListener", "mismatched event");
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof l) {
            long currentTimeMillis = System.currentTimeMillis() - this.tau;
            g.pQN.h(11170, new Object[]{Integer.valueOf(233), Integer.valueOf(0), Long.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(an.getNetType(ac.getContext())), ""});
            h(i, i2, currentTimeMillis);
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(233, this);
            if (i == 0 && i2 == 0) {
                cs(((l) kVar).RE(), this.tar);
                return;
            }
            if (bh.ov(str)) {
                str = this.tas.fxb.context.getString(i.uXa);
            }
            com.tencent.mm.ui.base.h.a(this.tas.fxb.context, str, "", new OnClickListener(this) {
                final /* synthetic */ h tax;

                {
                    this.tax = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.tax.tas.fqI != null) {
                        this.tax.tas.fxc.ret = 1;
                        this.tax.tas.fqI.run();
                    }
                }
            });
        } else if (kVar instanceof com.tencent.mm.wallet_core.tenpay.model.k) {
            x.d("MicroMsg.WalletGetA8KeyRedirectListener", "native auth, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            com.tencent.mm.kernel.g.Dk();
            com.tencent.mm.kernel.g.Di().gPJ.b(385, this);
            if (i == 0 && i2 == 0 && "0".equals(((com.tencent.mm.wallet_core.tenpay.model.k) kVar).zIu)) {
                t.j(this.taq, ((com.tencent.mm.wallet_core.tenpay.model.k) kVar).fuH, i2);
                com.tencent.mm.wallet_core.tenpay.model.k kVar2 = (com.tencent.mm.wallet_core.tenpay.model.k) kVar;
                PayInfo payInfo = new PayInfo();
                payInfo.fCV = this.taq;
                payInfo.fuH = kVar2.fuH;
                payInfo.appId = kVar2.appId;
                payInfo.tan = kVar2.tan;
                payInfo.fqV = kVar2.fqV;
                payInfo.fCR = kVar2.fCR;
                x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay native, payInfo: %s", new Object[]{payInfo.toString()});
                com.tencent.mm.pluginsdk.wallet.h.a(this.tat.fCP.context, payInfo, 0);
                if (this.tat.fqI != null) {
                    this.tat.fCQ.ret = 1;
                    this.tat.fqI.run();
                    return;
                }
                return;
            }
            if (bh.ov(str)) {
                if (bh.ov(((com.tencent.mm.wallet_core.tenpay.model.k) kVar).jcO)) {
                    str = this.tat.fCP.context.getString(i.uXa);
                } else {
                    str = ((com.tencent.mm.wallet_core.tenpay.model.k) kVar).jcO;
                }
            }
            t.j(this.taq, "", i2);
            com.tencent.mm.ui.base.h.a(this.tat.fCP.context, str, "", new 4(this));
        } else {
            x.i("MicroMsg.WalletGetA8KeyRedirectListener", "other scene");
        }
    }

    private void cs(String str, int i) {
        String str2 = null;
        x.d("MicroMsg.WalletGetA8KeyRedirectListener", "startPay reqKey = " + str);
        PayInfo payInfo = new PayInfo();
        payInfo.fCV = this.taq;
        Object obj = null;
        for (String str3 : str.replace("http://p.qq.com?", "").split("&")) {
            if (str3.startsWith("errcode=")) {
                obj = str3.replace("errcode=", "");
            } else if (str3.startsWith("errmsg=")) {
                str2 = str3.replace("errmsg=", "");
            } else if (str3.startsWith("reqkey=")) {
                payInfo.fuH = str3.replace("reqkey=", "");
            } else if (str3.startsWith("uuid=")) {
                payInfo.ned = str3.replace("uuid=", "");
            } else if (str3.startsWith("appid=")) {
                payInfo.appId = str3.replace("appid=", "");
            } else if (str3.startsWith("appsource=")) {
                payInfo.tan = str3.replace("appsource=", "");
            } else if (str3.startsWith("productid=")) {
                payInfo.fqV = str3.replace("productid=", "");
            }
        }
        payInfo.fCR = i;
        if ("0".equals(obj)) {
            com.tencent.mm.pluginsdk.wallet.h.a(this.tas.fxb.context, payInfo, 0);
            if (this.tas.fqI != null) {
                this.tas.fxc.ret = 1;
                this.tas.fqI.run();
            }
        } else {
            if (bh.ov(str2)) {
                str2 = this.tas.fxb.context.getString(i.uXa);
            }
            com.tencent.mm.ui.base.h.a(this.tas.fxb.context, str2, "", new 5(this));
        }
        if (!TextUtils.isEmpty(obj) && Pattern.compile("[0-9]*").matcher(obj).matches()) {
            h(0, Integer.valueOf(obj).intValue(), 0);
        }
    }

    private void h(int i, int i2, long j) {
        IDKey iDKey;
        int i3 = 132;
        if (this.taq == 1) {
            i3 = 163;
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(i3);
        iDKey2.SetValue(1);
        iDKey2.SetKey(26);
        arrayList.add(iDKey2);
        if (!(i == 0 && i2 == 0)) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            iDKey2.SetKey(8);
            if (i2 < 0) {
                iDKey.SetKey(9);
            } else if (i2 > 0) {
                iDKey.SetKey(10);
            }
        }
        if (this.taq == 4 && j > 0) {
            iDKey2 = new IDKey();
            iDKey2.SetID(i3);
            iDKey2.SetValue(1);
            iDKey = new IDKey();
            iDKey.SetID(i3);
            iDKey.SetValue(1);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(i3);
            iDKey3.SetValue((long) ((int) j));
            iDKey2.SetKey(0);
            if (j <= 1000) {
                iDKey.SetKey(1);
                iDKey3.SetKey(4);
            } else if (j > 1000 && j <= 3000) {
                iDKey.SetKey(2);
                iDKey3.SetKey(5);
            } else if (j > 3000) {
                iDKey.SetKey(3);
                iDKey3.SetKey(6);
            }
            arrayList.add(iDKey2);
            arrayList.add(iDKey);
            arrayList.add(iDKey3);
        }
        g.pQN.a(arrayList, true);
    }
}
