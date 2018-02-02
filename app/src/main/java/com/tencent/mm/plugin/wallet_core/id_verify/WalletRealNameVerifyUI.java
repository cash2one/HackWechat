package com.tencent.mm.plugin.wallet_core.id_verify;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.id_verify.model.d;
import com.tencent.mm.plugin.wallet_core.id_verify.model.g;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView$a;
import com.tencent.mm.wallet_core.ui.formview.a;
import com.tencent.mm.wallet_core.ui.formview.a.b;

public class WalletRealNameVerifyUI extends WalletBaseUI implements OnClickListener, WalletFormView$a {
    private String countryCode;
    private String hhw;
    private String hhx;
    private Button lRZ;
    private TextView nMP;
    private Profession[] sIM;
    private WalletFormView sJE;
    private WalletFormView sJF;
    private WalletFormView sJG;
    private WalletFormView sJH;
    private CheckBox sJI;
    private TextView sJJ;
    private ElementQuery sJK;
    private Profession sJL;
    private boolean sJM = false;
    private boolean sJN = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zIY.ji(1616);
        this.sJK = (ElementQuery) this.vf.getParcelable("elemt_query");
        initView();
        r(new g());
    }

    public void onDestroy() {
        this.zIY.jj(1616);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(i.uVB);
        this.lRZ = (Button) findViewById(a$f.cAg);
        this.sJE = (WalletFormView) findViewById(a$f.urM);
        this.sJF = (WalletFormView) findViewById(a$f.uhu);
        this.sJG = (WalletFormView) findViewById(a$f.utG);
        this.sJH = (WalletFormView) findViewById(a$f.utF);
        this.sJJ = (TextView) findViewById(a$f.ula);
        this.sJE.zJH = this;
        this.sJF.zJH = this;
        this.sJG.zJH = this;
        this.sJH.zJH = this;
        this.sJE.setFocusable(true);
        this.sJE.pEi.setVisibility(8);
        a.c(this.sJF);
        b bVar = this.sJF.zJJ;
        if (bVar instanceof a.a) {
            ((a.a) bVar).HG(1);
        }
        this.sJG.setOnClickListener(new 1(this));
        this.sJH.setOnClickListener(new 2(this));
        this.lRZ.setOnClickListener(new 3(this));
        e(this.sJF, 1, false);
        setBackBtn(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI sJO;

            {
                this.sJO = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ((a) this.sJO.cCc()).d(this.sJO, 0);
                this.sJO.finish();
                return true;
            }
        });
        this.sJI = (CheckBox) findViewById(a$f.uex);
        this.nMP = (TextView) findViewById(a$f.uew);
        this.sJI.setChecked(true);
        this.sJI.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ WalletRealNameVerifyUI sJO;

            {
                this.sJO = r1;
            }

            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    this.sJO.lRZ.setEnabled(true);
                    this.sJO.lRZ.setClickable(true);
                    return;
                }
                this.sJO.lRZ.setEnabled(false);
                this.sJO.lRZ.setClickable(false);
            }
        });
        this.nMP.setOnClickListener(new 6(this));
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response fail");
        } else if (kVar instanceof d) {
            c cCc = cCc();
            Bundle bundle = null;
            if (cCc != null) {
                bundle = cCc.msB;
            }
            String str2 = ((d) kVar).token;
            x.i("MicroMsg.WalletRealNameVerifyUI", "NetSceneRealNameVerify response succ");
            if (cCc == null) {
                return true;
            }
            bundle.putString("key_real_name_token", str2);
            bundle.putString("key_country_code", this.countryCode);
            bundle.putString("key_province_code", this.hhx);
            bundle.putString("key_city_code", this.hhw);
            bundle.putParcelable("key_profession", this.sJL);
            cCc.a(this, 0, bundle);
            return true;
        } else if (kVar instanceof g) {
            g gVar = (g) kVar;
            this.sJM = gVar.sIK == 1;
            if (gVar.sIL == 1) {
                z = true;
            }
            this.sJN = z;
            if (!this.sJN) {
                this.sJG.setVisibility(8);
            }
            if (!this.sJM) {
                this.sJH.setVisibility(8);
            }
            if (this.sJM || this.sJN) {
                this.sJJ.setText(i.uVz);
            }
            this.sIM = gVar.sKc;
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.uFI;
    }

    public void onClick(View view) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1) {
            if (i2 == -1) {
                this.sJL = (Profession) intent.getParcelableExtra("key_select_profession");
                this.sJG.setText(this.sJL.sKd);
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no choose!");
        } else if (i != 2) {
        } else {
            if (i2 == -1) {
                String stringExtra = intent.getStringExtra("CountryName");
                String stringExtra2 = intent.getStringExtra("ProviceName");
                String stringExtra3 = intent.getStringExtra("CityName");
                this.countryCode = intent.getStringExtra("Country");
                this.hhx = intent.getStringExtra("Contact_Province");
                this.hhw = intent.getStringExtra("Contact_City");
                StringBuilder stringBuilder = new StringBuilder();
                if (!bh.ov(stringExtra)) {
                    stringBuilder.append(stringExtra);
                }
                if (!bh.ov(stringExtra2)) {
                    stringBuilder.append(" ").append(stringExtra2);
                }
                if (!bh.ov(stringExtra3)) {
                    stringBuilder.append(" ").append(stringExtra3);
                }
                this.sJH.setText(stringBuilder.toString());
                return;
            }
            x.i("MicroMsg.WalletRealNameVerifyUI", "no area choose!");
        }
    }

    public final void hx(boolean z) {
        boolean z2;
        x.d("MicroMsg.WalletRealNameVerifyUI", "check info");
        String text = this.sJE.getText();
        String text2 = this.sJF.getText();
        if (bh.ov(text)) {
            z2 = false;
        } else if (bh.ov(text2)) {
            z2 = false;
        } else {
            if (this.sJM) {
                z2 = (bh.ov(this.countryCode) && bh.ov(this.hhx) && bh.ov(this.hhw)) ? false : true;
                if (!z2) {
                    z2 = false;
                }
            }
            z2 = (this.sJN && this.sJL == null) ? false : true;
        }
        if (z2) {
            this.lRZ.setEnabled(true);
            this.lRZ.setClickable(true);
            return;
        }
        this.lRZ.setEnabled(false);
        this.lRZ.setClickable(false);
    }
}
