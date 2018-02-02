package com.tencent.mm.ui.account.mobile;

import android.app.Activity;
import android.database.ContentObserver;
import com.tencent.mm.pluginsdk.g.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.FileUtils;

public class MobileVerifyUI$c extends ContentObserver {
    private Activity activity;
    final /* synthetic */ MobileVerifyUI xVi;

    public MobileVerifyUI$c(MobileVerifyUI mobileVerifyUI, Activity activity) {
        this.xVi = mobileVerifyUI;
        super(af.fetchFreeHandler());
        this.activity = activity;
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        if (MobileVerifyUI.f(this.xVi) != 3) {
            x.i("MicroMsg.MobileVerifyUI", "summerper checkPermission checkSMS[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a.a(this.activity, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")), bh.cgy(), this.activity});
            if (a.a(this.activity, "android.permission.READ_SMS", FileUtils.S_IWUSR, "", "")) {
                MobileVerifyUI.j(this.xVi);
            }
        }
    }
}
