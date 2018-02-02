package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.e;

@a(19)
public class RemittanceResultOldUI extends RemittanceResultUI {
    private int pLT;
    private Orders pPl;
    private String pPm;
    private boolean pPn;

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return a$g.uEf;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pPl = (Orders) this.vf.getParcelable("key_orders");
        initView();
        if (this.pLT == 31) {
            String str = "";
            if (this.pPl.sNW.size() > 0) {
                str = ((Commodity) this.pPl.sNW.get(0)).fuI;
            }
            x.i("MicroMsg.RemittanceResultOldUI", "transId: %s", new Object[]{str});
            b.bnm().bnp().dP(str, this.pPm);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            bnY();
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void initView() {
        int i = 1;
        boolean z = false;
        setMMTitle(getString(a$i.uOh));
        setBackBtn(null);
        showHomeBtn(false);
        enableBackMenu(false);
        TextView textView = (TextView) findViewById(f.uwf);
        if (this.pPl != null) {
            textView.setText(e.d(this.pPl.pNX, this.pPl.paz));
        }
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo == null) {
            x.e("MicroMsg.RemittanceResultOldUI", "payInfo is null!!!");
            finish();
            return;
        }
        String str = "";
        if (payInfo.vzx != null) {
            this.pPn = payInfo.vzx.getBoolean("extinfo_key_4");
            str = payInfo.vzx.getString("extinfo_key_1");
        }
        int i2 = payInfo.fCV;
        this.pLT = i2;
        this.pPm = str;
        str = e.gu(str);
        if (i2 == 31) {
            textView = (TextView) findViewById(f.uwh);
            CharSequence string = getString(a$i.uwh, new Object[]{str});
            if (bh.ov(string)) {
                textView.setVisibility(8);
            } else {
                textView.setText(i.b(this, string, textView.getTextSize()));
                textView.setVisibility(0);
            }
            findViewById(f.uvY).setVisibility(8);
            if (this.pPl.pKL > 0.0d) {
                ((TextView) findViewById(f.uhB)).setText(getResources().getString(a$i.uOf, new Object[]{e.d(this.pPl.pKL, this.pPl.paz)}));
                findViewById(f.uhC).setVisibility(0);
            }
        } else {
            String str2 = "";
            if (payInfo.vzx != null) {
                str2 = payInfo.vzx.getString("extinfo_key_2");
            }
            if (i2 == 32 || i2 == 33) {
                str2 = str;
            } else if (bh.ov(str2)) {
                str2 = str + getString(a$i.uOl);
            } else {
                str2 = str + "（" + e.aaA(str2) + "）";
            }
            TextView textView2 = (TextView) findViewById(f.uwh);
            if (bh.ov(str2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(i.b(this, getString(a$i.uOg, new Object[]{str2}), textView2.getTextSize()));
                textView2.setVisibility(0);
            }
            if (i2 == 33 || i2 == 32) {
                View findViewById = findViewById(f.uwd);
                textView2 = (TextView) findViewById(f.uwe);
                TextView textView3 = (TextView) findViewById(f.uwc);
                CharSequence string2 = payInfo.vzx.getString("extinfo_key_3");
                CharSequence string3 = payInfo.vzx.getString("extinfo_key_8");
                if (bh.ov(string2)) {
                    findViewById.setVisibility(8);
                    boolean z2 = false;
                } else {
                    textView3.setText(i.b(this, string2, textView3.getTextSize()));
                    findViewById.setVisibility(0);
                    if (bh.ov(string3)) {
                        i2 = 1;
                    } else {
                        textView2.setText(string3);
                        i2 = 1;
                    }
                }
                View findViewById2 = findViewById(f.uwa);
                textView2 = (TextView) findViewById(f.uwb);
                textView3 = (TextView) findViewById(f.uvZ);
                string3 = payInfo.vzx.getString("extinfo_key_6");
                CharSequence string4 = payInfo.vzx.getString("extinfo_key_7");
                if (bh.ov(string4)) {
                    findViewById2.setVisibility(8);
                    i = 0;
                } else {
                    textView3.setText(i.b(this, string4, textView3.getTextSize()));
                    textView3.setVisibility(0);
                    if (!bh.ov(string3)) {
                        textView2.setText(i.b(this, string3, textView2.getTextSize()));
                    }
                }
                if (i2 == 0 && r4 == 0) {
                    findViewById(f.uvY).setVisibility(8);
                }
            } else if (!(i2 != 5 || this.pPl.sNW == null || this.pPl.sNW.get(0) == null || TextUtils.isEmpty(((Commodity) this.pPl.sNW.get(0)).pao))) {
                textView2.setText(((Commodity) this.pPl.sNW.get(0)).pao);
            }
        }
        ((Button) findViewById(f.uwg)).setOnClickListener(new 1(this));
        g.Dk();
        Object obj = g.Dj().CU().get(w.a.xoL, Boolean.valueOf(false));
        if (obj != null) {
            z = ((Boolean) obj).booleanValue();
        }
        if (z) {
            x.i("MicroMsg.RemittanceResultOldUI", "has show the finger print auth guide!");
            return;
        }
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        Bundle bundle = new Bundle();
        if (ag != null) {
            bundle = ag.msB;
        }
        if (TextUtils.isEmpty(bundle.getString("key_pwd1"))) {
            x.i("MicroMsg.RemittanceResultOldUI", "pwd is empty, not show the finger print auth guide!");
        } else if (ag != null) {
            ag.a(this, "fingerprint", ".ui.FingerPrintAuthTransparentUI", bundle);
        }
    }

    private void bnY() {
        if (this.vf.containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) this.vf.getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "remittance");
                realnameGuideHelper.b(this, bundle, new 2(this));
                this.vf.remove("key_realname_guide_helper");
                return;
            }
            return;
        }
        bnZ();
    }

    private void bnZ() {
        cCc().b(this, this.vf);
        new af().postDelayed(new Runnable(this) {
            final /* synthetic */ RemittanceResultOldUI pPB;

            {
                this.pPB = r1;
            }

            public final void run() {
                if (this.pPB.pLT == 33 || this.pPB.pLT == 32) {
                    this.pPB.finish();
                } else if (bh.ov(this.pPB.pPm) || this.pPB.pPn) {
                    this.pPB.finish();
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Chat_User", this.pPB.pPm);
                    intent.putExtra("finish_direct", false);
                    d.a(this.pPB, ".ui.chatting.ChattingUI", intent);
                }
            }
        }, 100);
    }

    protected final boolean boa() {
        return false;
    }
}
