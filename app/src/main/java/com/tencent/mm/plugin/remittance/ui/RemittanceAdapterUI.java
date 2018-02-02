package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.ad.b;
import com.tencent.mm.ad.n;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.pluginsdk.wallet.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.z.ak;

@a(7)
public class RemittanceAdapterUI extends WalletBaseUI {
    public String gAb = null;
    public int irz;
    protected int ofD;
    public boolean pLL = false;
    protected com.tencent.mm.plugin.wallet.a pLM = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        uD(8);
        this.irz = getIntent().getIntExtra("scene", 0);
        this.gAb = getIntent().getStringExtra("receiver_name");
        this.ofD = getIntent().getIntExtra("pay_channel", -1);
        this.pLM = com.tencent.mm.plugin.wallet.a.X(getIntent());
        if (this.ofD == -1) {
            c cCc = cCc();
            if (cCc != null) {
                this.ofD = cCc.msB.getInt("pay_channel", -1);
            }
        }
        if (this.irz == 1) {
            this.pLL = true;
            bnG();
        } else if (this.irz == 3) {
            ji(580);
            if (getIntent() == null) {
                x.d("MicroMsg.RemittanceAdapterUI", "func[doCheckPayNetscene] intent null");
                setResult(0);
                finish();
                return;
            }
            k aVar = new com.tencent.mm.plugin.wallet_core.c.a(getIntent().getStringExtra("appId"), getIntent().getStringExtra("timeStamp"), getIntent().getStringExtra("nonceStr"), getIntent().getStringExtra("packageExt"), getIntent().getStringExtra("signtype"), getIntent().getStringExtra("paySignature"), getIntent().getStringExtra(SlookSmartClipMetaTag.TAG_TYPE_URL), 3, "getTransferMoneyRequest", getIntent().getIntExtra("pay_channel", 0));
            aVar.gOs = "RemittanceProcess";
            r(aVar);
        } else if (this.irz == 2) {
            if (bh.ov(this.gAb)) {
                x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.irz);
                finish();
                return;
            }
            c(this.gAb, 31, null);
        } else if (this.irz != 5 && this.irz != 6) {
            c(null, 31, null);
        } else if (bh.ov(this.gAb)) {
            x.w("MicroMsg.RemittanceAdapterUI", "Username empty & finish. scene=" + this.irz);
            finish();
        } else {
            String str = this.gAb;
            x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.irz + ", name=" + str);
            Intent intent = new Intent();
            com.tencent.mm.plugin.wallet.a.a(this.pLM, intent);
            intent.setClass(this, RemittanceOSRedirect.class);
            intent.putExtra("receiver_name", str);
            intent.putExtra("scene", this.irz);
            intent.putExtra("pay_scene", 31);
            intent.putExtra("pay_channel", this.ofD);
            startActivity(intent);
            setResult(-1);
            finish();
        }
    }

    public void bnG() {
        k uVar = new u(this.gAb, this.ofD);
        uVar.gOs = "RemittanceProcess";
        b(uVar, false);
    }

    public void onDestroy() {
        if (this.irz == 3) {
            jj(580);
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        if (this.pLL) {
            x.d("MicroMsg.RemittanceAdapterUI", "back press but lock");
            return;
        }
        x.d("MicroMsg.RemittanceAdapterUI", "back press not lock");
        finish();
    }

    public boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof u) {
            this.pLL = false;
        }
        if (i != 0 || i2 != 0) {
            setResult(0);
            h.bu(this, str);
            finish();
            return true;
        } else if (kVar instanceof u) {
            final u uVar = (u) kVar;
            String str2 = uVar.pLn;
            this.gAb = uVar.username;
            if (bh.ov(this.gAb) && bh.ov(str2)) {
                x.d("MicroMsg.RemittanceAdapterUI", "Username empty & fishsh. scene=" + this.irz);
                finish();
                return true;
            }
            if (this.irz == 1) {
                if (uVar.scene == 33) {
                    this.pLM = com.tencent.mm.plugin.wallet.a.cp(this.gAb, 2);
                    this.pLM.aK(20, getIntent().getStringExtra("receiver_name"));
                } else {
                    this.pLM = com.tencent.mm.plugin.wallet.a.cp(this.gAb, 3);
                    this.pLM.aK(10, getIntent().getStringExtra("receiver_name"));
                }
            }
            final Intent intent = new Intent();
            intent.putExtra("fee", uVar.ljg);
            intent.putExtra("desc", uVar.desc);
            intent.putExtra("scan_remittance_id", uVar.pLe);
            intent.putExtra("receiver_true_name", e.aaA(uVar.pLd));
            intent.putExtra("receiver_tips", uVar.pLf);
            intent.putExtra("rcvr_new_desc", uVar.pLg);
            intent.putExtra("payer_desc", uVar.pLh);
            intent.putExtra("rcvr_open_id", uVar.pLn);
            if (uVar.pLj == 1) {
                intent.putExtra("busi_type", uVar.pLj);
                intent.putExtra("rcvr_ticket", uVar.pLi);
                intent.putExtra("mch_name", uVar.pLk);
                intent.putExtra("mch_photo", uVar.pLl);
                intent.putExtra("mch_type", uVar.pLo);
                intent.putExtra("mch_time", uVar.pLm);
                intent.putExtra("rcvr_open_id", uVar.pLn);
                intent.putExtra("get_pay_wifi", uVar.pLp);
                if (uVar.pLq != null) {
                    intent.putExtra("BusiRemittanceResp", uVar.pLq);
                }
            }
            g.Dk();
            com.tencent.mm.storage.x WN = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).EY().WN(this.gAb);
            b.I(this.gAb, 3);
            if (WN != null || this.gAb.equals("")) {
                c(this.gAb, uVar.scene, intent);
            } else {
                x.d("MicroMsg.RemittanceAdapterUI", "Receiver in contactStg and try to get contact");
                final long Wp = bh.Wp();
                ak.a.hfL.a(this.gAb, "", new ak.b.a(this) {
                    final /* synthetic */ RemittanceAdapterUI pLP;

                    public final void v(String str, boolean z) {
                        if (z) {
                            x.v("MicroMsg.RemittanceAdapterUI", "getContact suc; cost=" + (bh.Wp() - Wp) + " ms");
                            b.I(str, 3);
                            n.JS().iY(str);
                        } else {
                            x.w("MicroMsg.RemittanceAdapterUI", "getContact failed");
                        }
                        this.pLP.c(this.pLP.gAb, uVar.scene, intent);
                    }
                });
            }
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.wallet_core.c.a)) {
            return false;
        } else {
            f.Ta(((com.tencent.mm.plugin.wallet_core.c.a) kVar).bKH());
            c(null, 31, null);
            return true;
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void c(String str, int i, Intent intent) {
        Intent intent2;
        x.i("MicroMsg.RemittanceAdapterUI", "startRemittanceUI scene=" + this.irz + ", name=" + str);
        if (intent != null) {
            intent2 = new Intent(intent);
        } else {
            intent2 = new Intent();
        }
        com.tencent.mm.plugin.wallet.a.a(this.pLM, intent2);
        if (intent2.getIntExtra("busi_type", 0) == 1) {
            intent2.setClass(this, RemittanceBusiUI.class);
        } else {
            intent2.setClass(this, RemittanceUI.class);
        }
        intent2.putExtra("receiver_name", str);
        intent2.putExtra("scene", this.irz);
        intent2.putExtra("pay_scene", i);
        intent2.putExtra("pay_channel", this.ofD);
        startActivity(intent2);
        setResult(-1);
        finish();
    }
}
