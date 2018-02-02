package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.plugin.remittance.model.m;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(3)
public class RemittanceResultUI extends WalletBaseUI {
    private Orders pPl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (boa()) {
            int i;
            boolean z;
            int i2;
            PayInfo payInfo;
            b fkVar;
            uD(4);
            getWindow().setBackgroundDrawableResource(c.transparent);
            this.pPl = (Orders) this.vf.getParcelable("key_orders");
            PayInfo payInfo2 = (PayInfo) this.vf.getParcelable("key_pay_info");
            if (payInfo2 != null) {
                i = payInfo2.fCV;
            } else {
                i = 0;
            }
            if (i == 31 || i == 5) {
                z = false;
            } else {
                z = true;
            }
            String str = "MicroMsg.RemittanceResultUI";
            String str2 = "orders==null:%s, paysScene: %s, needFetchF2fData: %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.pPl == null);
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Boolean.valueOf(z);
            x.i(str, str2, objArr);
            if (this.pPl != null) {
                x.i("MicroMsg.RemittanceResultUI", "is_use_new_paid_succ_page: %s", Integer.valueOf(this.pPl.sOg));
                if (this.pPl.sOg != 1) {
                    z(RemittanceResultOldUI.class);
                } else if (z) {
                    Orders orders = this.pPl;
                    if (payInfo2 == null || payInfo2.vzx == null) {
                        z(RemittanceResultNewUI.class);
                        finish();
                    } else {
                        x.i("MicroMsg.RemittanceResultUI", "fetch f2f data");
                        String string = payInfo2.vzx.getString("extinfo_key_11");
                        String str3 = "";
                        if (orders != null && orders.sNW.size() > 0) {
                            str3 = ((Commodity) orders.sNW.get(0)).fuI;
                        }
                        int i3 = payInfo2.vzx.getInt("extinfo_key_15", 0);
                        str2 = payInfo2.vzx.getString("extinfo_key_7");
                        String string2 = payInfo2.vzx.getString("extinfo_key_3");
                        int i4 = payInfo2.vzx.getInt("extinfo_key_12", 0);
                        String string3 = payInfo2.vzx.getString("extinfo_key_13");
                        String string4 = payInfo2.vzx.getString("extinfo_key_14");
                        String string5 = payInfo2.vzx.getString("extinfo_key_16");
                        if (bh.ov(string5)) {
                            string5 = str3;
                        }
                        x.i("MicroMsg.RemittanceResultUI", "fetchF2fData, f2fid: %s, transid: %s, amount: %s, payerDesc: %s, recvDesc: %s, scanScene: %s, paySuccSign: %s, paySuccExtend: %s, channel: %s, payscene: %s", string, string5, Integer.valueOf(i3), str2, string2, Integer.valueOf(i4), string3, string4, Integer.valueOf(payInfo2.fCR), Integer.valueOf(payInfo2.fCV));
                        ji(2773);
                        int i5 = payInfo2.fCR;
                        int i6 = payInfo2.fCV;
                        l(new m(string, string5, i3, str2, string2, i5, i4, string3, string4));
                    }
                }
                i2 = 0;
                payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
                if (payInfo != null) {
                    i2 = payInfo.fCV;
                }
                if (i2 != 33 || i2 == 32 || i2 == 48 || i2 == 31) {
                    fkVar = new fk();
                    fkVar.fuG.fuH = payInfo.fuH;
                    if (i2 != 31) {
                        fkVar.fuG.type = 0;
                    } else if (i2 == 32 || i2 == 33) {
                        fkVar.fuG.type = 1;
                    }
                    if (!(this.pPl == null || this.pPl.sNW.isEmpty())) {
                        fkVar.fuG.fuI = ((Commodity) this.pPl.sNW.get(0)).fuI;
                    }
                    com.tencent.mm.sdk.b.a.xef.m(fkVar);
                }
                return;
            }
            z(RemittanceResultNewUI.class);
            finish();
            i2 = 0;
            payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
            if (payInfo != null) {
                i2 = payInfo.fCV;
            }
            if (i2 != 33) {
            }
            fkVar = new fk();
            fkVar.fuG.fuH = payInfo.fuH;
            if (i2 != 31) {
                fkVar.fuG.type = 1;
            } else {
                fkVar.fuG.type = 0;
            }
            fkVar.fuG.fuI = ((Commodity) this.pPl.sNW.get(0)).fuI;
            com.tencent.mm.sdk.b.a.xef.m(fkVar);
        }
    }

    private void z(Class<?> cls) {
        if (cCc() == null) {
            a(cls, getIntent());
        } else {
            cCc().c(this, cls, this.vf);
        }
    }

    protected boolean boa() {
        return true;
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (!(kVar instanceof m)) {
            return false;
        }
        x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, errType: %s, errCode: %s", Integer.valueOf(i), Integer.valueOf(i2));
        m mVar = (m) kVar;
        if (i == 0 && i2 == 0) {
            ky kyVar = mVar.pKB;
            x.i("MicroMsg.RemittanceResultUI", "on f2f succpage scene end, retcode: %s, retmsg: %s, exposesureInfo: %s", Integer.valueOf(kyVar.liH), kyVar.liI, kyVar.sOJ);
            if (kyVar.liH == 0) {
                try {
                    this.vf.putByteArray("key_succpage_resp", kyVar.toByteArray());
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.RemittanceResultUI", e, "pass succ page resp error: %s", e.getMessage());
                }
                z(RemittanceResultNewUI.class);
                finish();
                return true;
            }
            Toast.makeText(this, kyVar.liI, 1).show();
        }
        z(RemittanceResultNewUI.class);
        finish();
        return true;
    }

    public void onDestroy() {
        super.onDestroy();
        jj(2773);
    }

    protected int getLayoutId() {
        return -1;
    }
}
