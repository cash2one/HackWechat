package com.tencent.mm.plugin.address.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bm.d;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.plugin.address.a.a;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.plugin.address.model.c;
import com.tencent.mm.plugin.address.model.h;
import com.tencent.mm.plugin.address.model.l;
import com.tencent.mm.plugin.address.ui.AddrEditView.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p;
import com.tencent.mm.z.ar;
import java.util.List;
import org.xwalk.core.R$styleable;

public class WalletAddAddressUI extends MMActivity implements e, b {
    private String fDW = "";
    private Dialog ilS = null;
    private int ims = 0;
    private AddrEditView inR;
    private AddrEditView inS;
    private AddrEditView inT;
    private AddrEditView inU;
    private AddrEditView inV;
    private com.tencent.mm.plugin.address.d.b inW = null;
    private com.tencent.mm.plugin.address.d.b inX = new com.tencent.mm.plugin.address.d.b();

    static /* synthetic */ void o(WalletAddAddressUI walletAddAddressUI) {
        if (walletAddAddressUI.ims != 0) {
            x.d("MicroMsg.WalletAddAddressUI", "modify save addr " + walletAddAddressUI.inX.toString());
            a.XG().XI();
            ar.CG().a(new h(walletAddAddressUI.inX), 0);
            walletAddAddressUI.ilS = com.tencent.mm.ui.base.h.a(walletAddAddressUI, "", true, new 2(walletAddAddressUI));
            return;
        }
        x.d("MicroMsg.WalletAddAddressUI", "add save addr " + walletAddAddressUI.inX.toString());
        ar.CG().a(new c(walletAddAddressUI.inX), 0);
        walletAddAddressUI.ilS = com.tencent.mm.ui.base.h.a(walletAddAddressUI, "", true, new 3(walletAddAddressUI));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ar.CG().a(415, this);
        ar.CG().a(418, this);
        x.d("MicroMsg.WalletAddAddressUI", "index Oncreate");
        x.De(0);
        this.ims = getIntent().getIntExtra("address_id", 0);
        if (this.ims == 0) {
            setMMTitle(R.l.dCI);
        } else {
            setMMTitle(R.l.dCZ);
        }
        initView();
    }

    public final void initView() {
        a.XG().XH();
        MMScrollView mMScrollView = (MMScrollView) findViewById(R.h.cYz);
        mMScrollView.a(mMScrollView, mMScrollView);
        this.inR = (AddrEditView) findViewById(R.h.bJk);
        this.inS = (AddrEditView) findViewById(R.h.bJg);
        this.inT = (AddrEditView) findViewById(R.h.bJh);
        this.inU = (AddrEditView) findViewById(R.h.bJr);
        this.inV = (AddrEditView) findViewById(R.h.bJm);
        this.inR.imN = this;
        this.inS.imN = this;
        this.inT.imN = this;
        this.inU.imN = this;
        this.inV.imN = this;
        this.inR.imM = new 1(this);
        this.inS.imM = new AddrEditView.a(this) {
            final /* synthetic */ WalletAddAddressUI inY;

            {
                this.inY = r1;
            }

            public final void onClick() {
                x.i("MicroMsg.WalletAddAddressUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.g.a.a(this.inY, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                if (com.tencent.mm.pluginsdk.g.a.a(this.inY, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                    this.inY.XT();
                }
            }
        };
        this.inS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletAddAddressUI inY;

            {
                this.inY = r1;
            }

            public final void onClick(View view) {
                this.inY.startActivityForResult(new Intent(this.inY, WalletMultiRcptSelectUI.class), 1);
            }
        });
        if (this.ims != 0) {
            this.inW = a.XG().jh(this.ims);
            this.inR.oO(this.inW.imp);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(this.inW.imk)) {
                stringBuilder.append(this.inW.imk);
            }
            if (!TextUtils.isEmpty(this.inW.iml)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.inW.iml);
            }
            if (!TextUtils.isEmpty(this.inW.imm)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.inW.imm);
            }
            this.inS.oO(stringBuilder.toString());
            this.inT.oO(this.inW.imo);
            this.inU.oO(this.inW.imn);
            this.inV.oO(this.inW.imq);
        }
        setBackBtn(new 10(this));
        a(0, getString(R.l.dGx), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletAddAddressUI inY;

            {
                this.inY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.inY.XK()) {
                    if (this.inY.ims != 0) {
                        this.inY.inW = a.XG().jh(this.inY.ims);
                        x.d("MicroMsg.WalletAddAddressUI", "get addr " + this.inY.inW.toString());
                        WalletAddAddressUI.a(this.inY.inW, this.inY.inX);
                    } else {
                        this.inY.inW = new com.tencent.mm.plugin.address.d.b();
                    }
                    String text = this.inY.inR.getText();
                    String text2 = this.inY.inS.getText();
                    String text3 = this.inY.inT.getText();
                    String text4 = this.inY.inU.getText();
                    String text5 = this.inY.inV.getText();
                    String[] split = text2.split(" ");
                    if (split.length > 0) {
                        this.inY.inX.imk = split[0];
                    }
                    if (split.length >= 2) {
                        this.inY.inX.iml = split[1];
                    }
                    if (split.length >= 3) {
                        this.inY.inX.imm = split[2];
                    } else {
                        this.inY.inX.imm = "";
                    }
                    this.inY.inX.imo = text3;
                    this.inY.inX.imp = text;
                    this.inY.inX.imq = text5;
                    this.inY.inX.imn = text4;
                    if (!bh.ov(this.inY.fDW)) {
                        this.inY.inX.imr = this.inY.fDW;
                    }
                    WalletAddAddressUI.o(this.inY);
                }
                return true;
            }
        }, p.b.xJz);
        XK();
    }

    public void onDestroy() {
        super.onDestroy();
        ar.CG().b(415, this);
        ar.CG().b(418, this);
        l XG = a.XG();
        x.i("MicroMsg.WalletAddrMgr", "clean data");
        for (List clear : XG.imc.values()) {
            clear.clear();
        }
        for (List clear2 : XG.imd.values()) {
            clear2.clear();
        }
        XG.imb.clear();
        XG.imc.clear();
        XG.imd.clear();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    str = intent.getStringExtra("karea_result");
                    if (!bh.ov(str)) {
                        x.d("MicroMsg.WalletAddAddressUI", "AREA_RESULT:" + str);
                        this.inS.oO(str);
                    }
                    str = intent.getStringExtra("kpost_code");
                    if (!bh.ov(str)) {
                        x.d("MicroMsg.WalletAddAddressUI", "post:" + str);
                        this.inU.oO(str);
                    }
                    this.fDW = intent.getStringExtra("kwcode");
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        x.d("MicroMsg.WalletAddAddressUI", "uri == null");
                        return;
                    }
                    String str2;
                    String[] b = com.tencent.mm.pluginsdk.a.b(getBaseContext(), data);
                    if (b == null || b.length != 2) {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.dDv), "", true);
                        str2 = null;
                    } else {
                        str = b[0];
                        str2 = b[1];
                    }
                    this.inR.oO(str);
                    this.inV.oO(str2);
                    if (PhoneNumberUtils.isGlobalPhoneNumber(str2)) {
                        XK();
                        return;
                    } else {
                        com.tencent.mm.ui.base.h.b(this, getString(R.l.dDv), "", true);
                        return;
                    }
                }
                return;
            case 3:
                if (i2 == -1) {
                    Addr addr = (Addr) intent.getParcelableExtra("key_pick_addr");
                    if (addr != null) {
                        x.d("MicroMsg.WalletAddAddressUI", "addr: " + addr.toString());
                        if (addr != null) {
                            StringBuilder stringBuilder;
                            if (a.XG().u(addr.hxv, addr.hxx, addr.hxy)) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append(addr.hxv);
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hxx);
                                if (!TextUtils.isEmpty(addr.hxy)) {
                                    stringBuilder.append(" ");
                                    stringBuilder.append(addr.hxy);
                                }
                                this.inS.oO(stringBuilder.toString());
                            } else {
                                this.inS.oO("");
                            }
                            stringBuilder = new StringBuilder();
                            if (!TextUtils.isEmpty(addr.hxz)) {
                                stringBuilder.append(addr.hxz);
                            }
                            if (!TextUtils.isEmpty(addr.hxA)) {
                                stringBuilder.append(addr.hxA);
                            }
                            if (!TextUtils.isEmpty(addr.hxB)) {
                                stringBuilder.append(addr.hxB);
                            }
                            if (!TextUtils.isEmpty(addr.hxD)) {
                                stringBuilder.append(" ");
                                stringBuilder.append(addr.hxD);
                            }
                            if (!bh.ov(addr.hxD) || bh.ov(addr.hxu)) {
                                this.inT.oO(stringBuilder.toString());
                            } else {
                                this.inT.oO(addr.hxu);
                            }
                            RcptItem t = a.XG().t(addr.hxv, addr.hxx, addr.hxy);
                            if (t != null) {
                                this.inU.oO(t.ilY);
                                this.fDW = t.code;
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.WalletAddAddressUI", "MallRecharge pay result : cancel");
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dtR;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.ilS != null) {
            this.ilS.dismiss();
        }
        if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.address.d.a aVar = a.XG().ima;
            if (aVar.imi.size() > 0) {
                a(this.inX, this.inW);
                com.tencent.mm.plugin.address.d.b bVar = (com.tencent.mm.plugin.address.d.b) aVar.imi.getFirst();
                if (bVar != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
                } else {
                    setResult(0);
                }
            } else {
                setResult(0);
            }
            finish();
            return;
        }
        switch (i2) {
            case -3104:
            case -3103:
            case -3102:
                com.tencent.mm.ui.base.h.a(this, str, "", new 13(this));
                return;
            case -3100:
                com.tencent.mm.ui.base.h.a(this, R.l.dCH, 0, false, new 12(this));
                return;
            default:
                com.tencent.mm.ui.base.h.a(this, R.l.dCF, 0, false, new 14(this));
                return;
        }
    }

    private boolean XK() {
        boolean z = false;
        boolean z2 = true;
        if (!this.inR.XO()) {
            z2 = false;
        }
        if (!this.inT.XO()) {
            z2 = false;
        }
        if (!this.inS.XO()) {
            z2 = false;
        }
        if (!this.inU.XO()) {
            z2 = false;
        }
        if (this.inV.XO()) {
            z = z2;
        }
        enableOptionMenu(z);
        return z;
    }

    public final void XL() {
        XK();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        XM();
        return true;
    }

    private void XM() {
        int i;
        int i2 = 1;
        int i3 = R.l.dCL;
        if (this.ims == 0) {
            i3 = R.l.dCK;
        }
        if (this.inR.XP()) {
            i = 1;
        } else {
            i = 0;
        }
        if (this.inT.XP()) {
            i = 1;
        }
        if (this.inS.XP()) {
            i = 1;
        }
        if (this.inU.XP()) {
            i = 1;
        }
        if (!this.inV.XP()) {
            i2 = i;
        }
        if (i2 != 0) {
            com.tencent.mm.ui.base.h.a(this, i3, R.l.dGO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ WalletAddAddressUI inY;

                {
                    this.inY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.inY.setResult(0);
                    this.inY.finish();
                }
            }, null);
            return;
        }
        setResult(0);
        finish();
    }

    private void XS() {
        startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 2);
    }

    private void XT() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.inS.getText())) {
            stringBuilder.append(this.inS.getText());
        }
        if (!TextUtils.isEmpty(this.inT.getText())) {
            stringBuilder.append(this.inT.getText());
        }
        Intent intent = new Intent();
        intent.putExtra("wallet_address", stringBuilder.toString());
        intent.putExtra("map_view_type", 8);
        d.b(this, "location", ".ui.RedirectUI", intent, 3);
    }

    private static void a(com.tencent.mm.plugin.address.d.b bVar, com.tencent.mm.plugin.address.d.b bVar2) {
        if (bVar != null && bVar2 != null) {
            bVar2.id = bVar.id;
            bVar2.imk = bVar.imk;
            bVar2.iml = bVar.iml;
            bVar2.imm = bVar.imm;
            bVar2.imo = bVar.imo;
            bVar2.imp = bVar.imp;
            bVar2.imq = bVar.imq;
            bVar2.imn = bVar.imn;
            bVar2.imr = bVar.imr;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        x.i("MicroMsg.WalletAddAddressUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case R$styleable.AppCompatTheme_homeAsUpIndicator /*48*/:
                if (iArr[0] == 0) {
                    XS();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezO), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 4(this), new 5(this));
                    return;
                }
            case 64:
                if (iArr[0] == 0) {
                    XT();
                    return;
                } else {
                    com.tencent.mm.ui.base.h.a(this, getString(R.l.ezP), getString(R.l.ezT), getString(R.l.est), getString(R.l.cancel), false, new 6(this), new 7(this));
                    return;
                }
            default:
                return;
        }
    }
}
