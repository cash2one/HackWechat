package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView.a;
import com.tencent.mm.ui.ac;

class SettingsFontUI$1 implements a {
    final /* synthetic */ TextView qjp;
    final /* synthetic */ TextView qjq;
    final /* synthetic */ TextView qjr;
    final /* synthetic */ SettingsFontUI qjs;

    SettingsFontUI$1(SettingsFontUI settingsFontUI, TextView textView, TextView textView2, TextView textView3) {
        this.qjs = settingsFontUI;
        this.qjp = textView;
        this.qjq = textView2;
        this.qjr = textView3;
    }

    public final void vS(int i) {
        float f = 1.0f;
        switch (i) {
            case 0:
                f = 0.875f;
                break;
            case 2:
                f = 1.125f;
                break;
            case 3:
                f = 1.25f;
                break;
            case 4:
                f = 1.375f;
                break;
            case 5:
                f = 1.625f;
                break;
            case 6:
                f = 1.875f;
                break;
            case 7:
                f = 2.025f;
                break;
        }
        if (f != this.qjs.qjo) {
            SettingsFontUI.a(this.qjs, 1);
        } else {
            SettingsFontUI.a(this.qjs, 0);
        }
        com.tencent.mm.bv.a.h(this.qjs.mController.xIM, f);
        ac.h(this.qjs.mController.xIM, f);
        Editor edit = this.qjs.mController.xIM.getSharedPreferences(com.tencent.mm.sdk.platformtools.ac.cfs(), 0).edit();
        edit.putFloat("current_text_size_scale_key", f);
        edit.commit();
        SettingsFontUI.b(this.qjs, com.tencent.mm.bv.a.ev(this.qjs.mController.xIM));
        float eu = com.tencent.mm.bv.a.eu(this.qjs.mController.xIM);
        Context context = this.qjs.mController.xIM;
        if (eu == 0.875f) {
            SettingsFontUI.c(this.qjs, com.tencent.mm.bv.a.ab(context, R.f.bwV));
        } else if (eu == 1.125f) {
            SettingsFontUI.c(this.qjs, com.tencent.mm.bv.a.ab(context, R.f.bwR));
        } else if (eu == 1.25f) {
            SettingsFontUI.c(this.qjs, com.tencent.mm.bv.a.ab(context, R.f.bwW));
        } else if (eu == 1.375f) {
            SettingsFontUI.c(this.qjs, com.tencent.mm.bv.a.ab(context, R.f.bwM));
        } else if (eu == 1.625f || eu == 1.875f || eu == 2.025f) {
            SettingsFontUI.c(this.qjs, com.tencent.mm.bv.a.ab(context, R.f.bwN));
        }
        this.qjp.setTextSize(1, SetTextSizeUI.ao(f));
        this.qjq.setTextSize(1, SetTextSizeUI.ao(f));
        this.qjr.setTextSize(1, SetTextSizeUI.ao(f));
        float ab = ((float) com.tencent.mm.bv.a.ab(context, R.f.bum)) * com.tencent.mm.bv.a.ew(context);
        this.qjs.mController.xIT.setTextSize(0, ab);
    }
}
