package com.tencent.mm.plugin.wallet_index.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet.balance.a.a.q;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.HashMap;
import java.util.Map;

@a(7)
public class WalletOpenViewProxyUI extends WalletBaseUI {
    private Map<String, String> tbj = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        String stringExtra = getIntent().getStringExtra("packageExt");
        this.tbj = new HashMap();
        if (!bh.ov(stringExtra)) {
            String[] split = stringExtra.split("&");
            if (split != null && split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    if (!bh.ov(split[i])) {
                        String[] split2 = split[i].split("=");
                        if (split2.length == 2 && !bh.ov(split2[0])) {
                            this.tbj.put(split2[0], split2[1]);
                        }
                    }
                }
            }
        }
        ji(2996);
        ji(580);
        ji(385);
        if (getIntent() == null) {
            x.d("MicroMsg.WalletOpenViewProxyUI", "func[doCheckPayNetscene] intent null");
            setResult(0);
            finish();
            return;
        }
        stringExtra = (String) this.tbj.get("openview");
        String stringExtra2 = getIntent().getStringExtra("appId");
        String stringExtra3 = getIntent().getStringExtra("timeStamp");
        String stringExtra4 = getIntent().getStringExtra("nonceStr");
        String stringExtra5 = getIntent().getStringExtra("packageExt");
        String stringExtra6 = getIntent().getStringExtra("paySignature");
        if ("open_wcpay_f2f_receive_detail".equals(stringExtra)) {
            r(new u(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6));
        } else if ("open_wcpay_grouppay_detail".equals(stringExtra)) {
            Nx(stringExtra5);
        } else if ("open_wcpay_lqt_detail".equals(stringExtra)) {
            x.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui");
            if (this.tbj != null) {
                new Intent().putExtra("key_account_type", 1);
                stringExtra = (String) this.tbj.get("ecardtype");
                x.i("MicroMsg.WalletOpenViewProxyUI", "open lqt detail ui, ecardtype: %s, extradata: %s, need_open_lqb: %s", new Object[]{stringExtra, (String) this.tbj.get("extradata"), (String) this.tbj.get("need_open_lqb")});
                if (bh.getInt((String) this.tbj.get("need_open_lqb"), 0) == 1) {
                    if (bh.ov(stringExtra)) {
                        stringExtra = "WEB_DEBIT";
                    }
                    r(new q(stringExtra, stringExtra2));
                } else {
                    d.y(this.mController.xIM, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                    setResult(-1);
                    finish();
                }
            } else {
                d.y(this.mController.xIM, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
                setResult(-1);
                finish();
            }
            g.pQN.a(663, 18, 1, false);
        } else {
            String str = stringExtra2;
            String str2 = stringExtra3;
            String str3 = stringExtra4;
            String str4 = stringExtra5;
            String str5 = stringExtra6;
            r(new com.tencent.mm.plugin.wallet_core.c.a(str, str2, str3, str4, getIntent().getStringExtra("signtype"), str5, getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 4, "openWCPaySpecificView", getIntent().getIntExtra("pay_channel", 0)));
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.WalletOpenViewProxyUI", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, kVar});
        if (i != 0 || i2 != 0) {
            setResult(0);
            finish();
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.wallet_core.c.a) {
            f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
            Nx(getIntent().getStringExtra("packageExt"));
            return true;
        } else if (kVar instanceof u) {
            Nx(getIntent().getStringExtra("packageExt"));
            return true;
        } else if (!(kVar instanceof q)) {
            return false;
        } else {
            auu com_tencent_mm_protocal_c_auu = ((q) kVar).szf;
            x.i("MicroMsg.WalletOpenViewProxyUI", "on open lqb account scene end, retcode: %s, regmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_auu.kLO), com_tencent_mm_protocal_c_auu.kLP});
            if (com_tencent_mm_protocal_c_auu.kLO == 0) {
                Intent intent = new Intent();
                intent.putExtra("key_account_type", 2);
                d.b(this.mController.xIM, "wallet", ".balance.ui.lqt.WalletLqtDetailUI", intent);
                setResult(-1);
            } else {
                Toast.makeText(this, com_tencent_mm_protocal_c_auu.kLP, 1).show();
                setResult(0);
            }
            finish();
            return true;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        jj(580);
        jj(385);
        jj(2996);
    }

    protected final int getLayoutId() {
        return -1;
    }

    private void Nx(String str) {
        if (bh.ov(str)) {
            x.w("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] packageExt null or nil");
        } else {
            String str2 = (String) this.tbj.get("openview");
            if ("open_wcpay_biz_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_index_ui");
                d.y(this.mController.xIM, "mall", ".ui.MallIndexUI");
            } else if ("open_wcpay_balance_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open wallet_balance_manager_ui");
                h.Y(this.mController.xIM, 0);
            } else if ("open_wcpay_order_detail_view".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open mall_order_transaction_info_ui");
                r1 = new Intent();
                r1.putExtra("trans_id", (String) this.tbj.get("trans_id"));
                r1.putExtra("scene", 1);
                if (this.tbj.containsKey("bill_id")) {
                    r1.putExtra("bill_id", (String) this.tbj.get("bill_id"));
                }
                d.b(this.mController.xIM, "order", ".ui.MallOrderTransactionInfoUI", r1);
            } else if ("open_wcpay_f2f_receive_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_f2f_receive_detail");
                r1 = new Intent();
                r1.putExtra("key_timestamp", bh.getLong((String) this.tbj.get("fromtimestamp"), 0));
                r1.putExtra("key_from_scene", 1);
                d.b(this.mController.xIM, "collect", ".ui.CollectBillUI", r1);
                g.pQN.h(13944, new Object[]{Integer.valueOf(2)});
            } else if ("open_wcpay_grouppay_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] do open open_wcpay_grouppay_detail");
                r1 = new Intent();
                r1.putExtra("bill_no", (String) this.tbj.get("billno"));
                r1.putExtra("chatroom", (String) this.tbj.get("groupid"));
                r1.putExtra("key_sign", (String) this.tbj.get("sign"));
                r1.putExtra("key_ver", (String) this.tbj.get("ver"));
                r1.putExtra("enter_scene", 5);
                d.b(this.mController.xIM, "aa", ".ui.PaylistAAUI", r1);
            } else if ("open_wcpay_t2bc_detail".equals(str2)) {
                x.d("MicroMsg.WalletOpenViewProxyUI", "do open_wcpay_t2bc_detail");
                r1 = new Intent();
                r1.putExtra("key_transfer_bill_id", (String) this.tbj.get("transfer_bill_id"));
                r1.putExtra("key_enter_scene", 1);
                d.b(this.mController.xIM, "remittance", ".bankcard.ui.BankRemitDetailUI", r1);
            } else {
                x.d("MicroMsg.WalletOpenViewProxyUI", "func[handleOpenView] invalid target view : " + str2);
            }
        }
        setResult(-1);
        finish();
    }
}
