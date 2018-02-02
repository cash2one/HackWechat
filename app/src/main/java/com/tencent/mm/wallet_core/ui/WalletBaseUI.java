package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.h;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.z.q;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;

public abstract class WalletBaseUI extends MMActivity implements d {
    public static final int iiI = a.fromDPToPix(ac.getContext(), 270);
    private static h zJa = null;
    public MyKeyboardWindow mKeyboard;
    public a ofE;
    public View ofs;
    public Bundle vf = new Bundle();
    private OnMenuItemClickListener yzu;
    private c zIX = null;
    public g zIY = null;
    private e zIZ = null;
    private OnMenuItemClickListener zJb;
    public boolean zJc = false;

    public abstract boolean d(int i, int i2, String str, k kVar);

    public final String bJQ() {
        if (this.vf == null) {
            return "";
        }
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo != null) {
            return payInfo.fuH;
        }
        return "";
    }

    public void aXc() {
        x.d("MicroMsg.WalletBaseUI", "cancelforceScene");
        this.zIY.aXc();
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!com.tencent.mm.kernel.g.Dh().Cy()) {
            x.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
            com.tencent.mm.ui.base.h.a(this, getString(i.uOF), "", false, new 1(this));
        }
        this.zIY = new g(this, this);
        this.zIY.ji(385);
        this.zIY.ji(1518);
        x.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
        c ag = com.tencent.mm.wallet_core.a.ag(this);
        if (ag != null) {
            this.zIY.gOs = ag.aKG();
        }
        x.d("MicroMsg.WalletBaseUI", "proc " + ag);
        this.vf = com.tencent.mm.wallet_core.a.af(this);
        if (this.vf == null) {
            this.vf = new Bundle();
        }
        this.zIY.vf = this.vf;
        if (aYj() && !com.tencent.mm.wallet_core.a.ae(this)) {
            x.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
        }
        if (getLayoutId() > 0) {
            String str = "";
            if (!bh.ov(str)) {
                setMMSubTitle(str);
            }
        }
        setBackBtn(new 3(this));
        this.zIZ = cCd();
        if (this.zIZ != null && this.zIZ.p(new Object[0])) {
            uD(4);
        } else if (getLayoutId() <= 0) {
            uD(4);
        } else if (aYf()) {
            uD(4);
        } else {
            uD(0);
        }
    }

    public final int cBY() {
        return this.mController.contentView.getVisibility();
    }

    public final void setBackBtn(OnMenuItemClickListener onMenuItemClickListener) {
        this.yzu = onMenuItemClickListener;
        super.setBackBtn(onMenuItemClickListener);
    }

    public final void addTextOptionMenu(int i, String str, OnMenuItemClickListener onMenuItemClickListener) {
        this.zJb = onMenuItemClickListener;
        super.addTextOptionMenu(i, str, onMenuItemClickListener);
    }

    public final void a(String str, OnMenuItemClickListener onMenuItemClickListener, int i) {
        this.zJb = onMenuItemClickListener;
        super.a(0, str, onMenuItemClickListener, i);
    }

    public void onResume() {
        super.onResume();
        if (n.cBq()) {
            k bVar;
            if (q.Gf()) {
                bVar = new b();
            } else {
                bVar = new m();
            }
            this.zIY.a(bVar, false);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        this.zIY.jj(385);
        this.zIY.jj(1518);
    }

    public void b(int i, int i2, String str, k kVar, boolean z) {
        x.d("MicroMsg.WalletBaseUI", "errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        TenpaySecureEditText.setSalt(n.cBr());
        if (kVar instanceof h) {
            h hVar = (h) kVar;
            zJa = hVar;
            if (this.vf != null) {
                if (hVar.sLY > 0) {
                    this.vf.putInt("key_is_gen_cert", hVar.sLY);
                }
                if (hVar.sMa > 0) {
                    this.vf.putInt("key_is_hint_crt", hVar.sMa);
                }
                if (hVar.sMc > 0) {
                    this.vf.putInt("key_is_ignore_cert", hVar.sMc);
                }
                if (!bh.ov(hVar.sLZ)) {
                    this.vf.putString("key_crt_token", hVar.sLZ);
                }
                if (!bh.ov(hVar.sMb)) {
                    this.vf.putString("key_crt_wording", hVar.sMb);
                }
            }
        }
        j(i, i2, str, kVar);
        f.a(this, i, i2, str, kVar, z);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        cCd().onActivityResult(i, i2, intent);
    }

    public void uw(int i) {
    }

    public boolean j(int i, int i2, String str, k kVar) {
        return true;
    }

    public boolean aYj() {
        return true;
    }

    public boolean aYi() {
        return false;
    }

    public boolean aYf() {
        if (getLayoutId() > 0 && !this.zIY.aXd()) {
            return false;
        }
        return true;
    }

    public boolean bKa() {
        return false;
    }

    public final void cBZ() {
        PayInfo payInfo = (PayInfo) this.vf.getParcelable("key_pay_info");
        if (payInfo == null) {
            payInfo = (PayInfo) getIntent().getParcelableExtra("key_pay_info");
        }
        if (payInfo != null && !bh.ov(payInfo.ned)) {
            this.zIY.a(new com.tencent.mm.wallet_core.c.d(payInfo.ned, payInfo.fuH), true, 1);
            payInfo.ned = null;
        }
    }

    public boolean Xd() {
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.ofs != null && this.ofs.isShown()) {
                Xa();
                return true;
            } else if (bKa()) {
                aWs();
                showDialog(1000);
                return true;
            } else if (this.yzu != null && Xd()) {
                this.yzu.onMenuItemClick(null);
                return true;
            } else if (this.zJb != null) {
                this.zJb.onMenuItemClick(null);
                return true;
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public final boolean akK() {
        if (this.yzu != null) {
            this.yzu.onMenuItemClick(null);
            return true;
        } else if (this.zJb == null) {
            return super.akK();
        } else {
            this.zJb.onMenuItemClick(null);
            return true;
        }
    }

    public Dialog onCreateDialog(int i) {
        x.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + i);
        switch (i) {
            case 1000:
                int b;
                c ag = com.tencent.mm.wallet_core.a.ag(this);
                if (ag != null) {
                    b = ag.b((MMActivity) this, 1);
                } else {
                    b = -1;
                }
                if (b != -1) {
                    return com.tencent.mm.ui.base.h.a(this, true, getString(b), "", getString(i.dHd), getString(i.dFR), new 4(this), new 5(this));
                }
                if (ag != null) {
                    ag.b((Activity) this, this.vf);
                } else {
                    finish();
                }
                return super.onCreateDialog(i);
            default:
                return super.onCreateDialog(i);
        }
    }

    public final void e(View view, int i, boolean z) {
        a(view, i, z, true);
    }

    public void a(View view, int i, boolean z, boolean z2) {
        b(view, i, z, true);
    }

    @TargetApi(14)
    public final void b(View view, int i, boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
        this.ofs = findViewById(f.uwM);
        View findViewById = findViewById(f.itm);
        EditText editText = (EditText) view.findViewById(f.uyz);
        if (this.mKeyboard != null && editText != null && this.ofs != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 6(this, z, z2, view, editText, i));
            editText.setOnClickListener(new 7(this, z, i, editText));
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WalletBaseUI zJd;

                {
                    this.zJd = r1;
                }

                public final void onClick(View view) {
                    this.zJd.Xa();
                }
            });
        }
    }

    public final boolean nJ(boolean z) {
        if (zJa == null || (!zJa.bhc() && !z)) {
            return false;
        }
        this.zIY.a(zJa, true);
        return true;
    }

    public static void cCa() {
        f.cCa();
    }

    public void Xa() {
        if (this.ofs != null && this.ofs.isShown()) {
            this.ofs.setVisibility(8);
            if (this.ofE != null) {
                this.ofE.hA(false);
            }
        }
    }

    public final void cCb() {
        if (this.ofs != null && !this.ofs.isShown()) {
            this.ofs.setVisibility(0);
            if (this.ofE != null) {
                this.ofE.hA(true);
            }
        }
    }

    public final void HB(int i) {
        this.mKeyboard.setXMode(i);
    }

    public final c cCc() {
        if (this.zIX == null) {
            this.zIX = com.tencent.mm.wallet_core.a.ag(this);
        }
        return this.zIX;
    }

    public final e cCd() {
        if (this.zIZ == null) {
            c cCc = cCc();
            if (cCc != null) {
                this.zIZ = cCc.a((MMActivity) this, this.zIY);
            }
            if (this.zIZ == null) {
                this.zIZ = new 9(this, this, this.zIY);
            }
        }
        return this.zIZ;
    }

    public final CharSequence um(int i) {
        if (this.zIZ == null) {
            return null;
        }
        return this.zIZ.um(i);
    }

    public void bJx() {
        cCc().a((Activity) this, 0, this.vf);
    }

    public final void ji(int i) {
        this.zIY.ji(i);
    }

    public final void jj(int i) {
        this.zIY.jj(i);
    }

    public final void b(k kVar, boolean z) {
        cCe();
        this.zIY.a(kVar, z, 1);
    }

    public final void l(k kVar) {
        cCe();
        this.zIY.a(kVar, true, 1);
    }

    public final void r(k kVar) {
        cCe();
        this.zIY.a(kVar, true);
    }

    public void cCe() {
        c cCc = cCc();
        if (cCc != null) {
            this.zIY.vf = cCc.msB;
        }
    }

    public void uD(int i) {
        super.uD(i);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getBooleanExtra("key_process_is_end", false) && !intent.getBooleanExtra("key_process_is_stay", true)) {
            setIntent(intent);
            Bundle extras = getIntent().getExtras();
            int i = (extras == null || !extras.containsKey("key_process_result_code")) ? 0 : extras.getInt("key_process_result_code", 0);
            if (i == -1) {
                x.i("MicroMsg.WalletBaseUI", "process end ok!");
                setResult(-1, getIntent());
            } else {
                x.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
                setResult(0, getIntent());
            }
            finish();
        }
    }

    public final void a(View view, View view2, int i) {
        if (view != null) {
            int[] iArr = new int[2];
            view2.getLocationInWindow(iArr);
            int eB = (a.eB(this) - r0) - a.fromDPToPix(this, 30);
            x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + view2.getHeight()), Integer.valueOf(a.eB(this)), Integer.valueOf(eB), Integer.valueOf(iiI)});
            if (eB > 0 && eB < iiI) {
                x.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf(iiI - eB)});
                view.post(new 2(this, view, r0));
            }
        }
    }
}
