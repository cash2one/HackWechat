package com.tencent.mm.plugin.aa.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.ae.k;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.app.c;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;

public abstract class BaseAAPresenterActivity extends WalletBaseUI {
    private static final int iiI = a.fromDPToPix(ac.getContext(), 300);
    private c gSQ = new c();
    protected View iiH;

    static /* synthetic */ void a(BaseAAPresenterActivity baseAAPresenterActivity, EditText editText) {
        if (baseAAPresenterActivity.iiH != null) {
            int[] iArr = new int[2];
            editText.getLocationInWindow(iArr);
            int height = r1 - (iArr[1] + editText.getHeight());
            x.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[]{Integer.valueOf(iArr[1] + editText.getHeight()), Integer.valueOf(baseAAPresenterActivity.getWindow().getDecorView().getHeight() - baseAAPresenterActivity.getSupportActionBar().getHeight()), Integer.valueOf(height), Integer.valueOf(iiI)});
            if (height > 0 && height < iiI) {
                x.i("MicroMsg.BaseAAPresenterActivity", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[]{Integer.valueOf((iiI - height) + a.fromDPToPix(baseAAPresenterActivity, 5))});
                baseAAPresenterActivity.iiH.scrollBy(0, r0);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSQ.B(getIntent(), this);
        this.zJc = true;
    }

    public void onResume() {
        super.onResume();
        this.gSQ.Hm(2);
    }

    public void onPause() {
        super.onPause();
        this.gSQ.Hm(3);
    }

    public void onDestroy() {
        super.onDestroy();
        this.gSQ.onDestroy();
    }

    public final <T extends b<? extends com.tencent.mm.vending.app.a>> T q(Class<? extends b<? extends com.tencent.mm.vending.app.a>> cls) {
        return this.gSQ.a(this, cls);
    }

    public final <T extends com.tencent.mm.vending.app.a> T t(Class<? extends com.tencent.mm.vending.app.a> cls) {
        return this.gSQ.b(this, cls);
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final void a(View view, int i, boolean z, boolean z2) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.uwN);
        this.ofs = findViewById(f.uwM);
        View findViewById = findViewById(f.itm);
        final EditText editText = (EditText) view.findViewById(f.uyz);
        if (this.mKeyboard != null && editText != null && this.ofs != null) {
            this.ofs.setVisibility(8);
            e.setNoSystemInputOnEditText(editText);
            final boolean z3 = z;
            final boolean z4 = z2;
            final View view2 = view;
            final int i2 = i;
            editText.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ BaseAAPresenterActivity iiO;

                public final void onFocusChange(View view, boolean z) {
                    if (!view.isFocused() || z3) {
                        new af().postDelayed(new 2(this), 200);
                        return;
                    }
                    ((InputMethodManager) this.iiO.mController.xIM.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new af().postDelayed(new 1(this, view), 300);
                }
            });
            editText.setOnClickListener(new 2(this, z, editText, i));
            findViewById.setOnClickListener(new 3(this));
        }
    }

    protected final void Xa() {
        super.Xa();
        if (this.iiH != null) {
            this.iiH.scrollTo(0, 0);
        }
    }
}
