package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public class ShakePersonalInfoUI extends MMPreference {
    private f ilB;

    public final int XB() {
        return R.o.fcx;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    public void onDestroy() {
        a.ift.um();
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle(R.l.eOy);
        this.ilB = this.yjd;
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ilB.YN("shake_item_sound");
        ar.Hg();
        if (c.CU().get(4112, null) == null) {
            ar.Hg();
            c.CU().set(4112, Boolean.valueOf(true));
        }
        ar.Hg();
        checkBoxPreference.tSw = bh.b((Boolean) c.CU().get(4112, null));
        setBackBtn(new 1(this));
        if (!com.tencent.mm.av.c.Qx()) {
            this.ilB.YO("shake_item_shake_music_list");
        }
    }

    public void onResume() {
        boolean z = false;
        super.onResume();
        if (ar.Hj()) {
            a.ift.um();
        }
        if (this.ilB.YN("shake_item_shake_tv_list") == null) {
            x.e("MicroMsg.mmui.MMPreference", "shake_tv_list preference is null");
            return;
        }
        if (bh.getInt(g.zZ().F("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        x.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : " + z);
        if (!z && !r.idk) {
            this.ilB.bk("shake_item_shake_tv_list", true);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.ibD;
        if ("shake_item_default_bgimg".equals(str)) {
            ar.Hg();
            c.CU().set(4110, Boolean.valueOf(true));
            h.bu(this, getResources().getString(R.l.eOV));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            k.a(this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            ar.Hg();
            boolean b = bh.b((Boolean) c.CU().get(4112, null));
            ar.Hg();
            c.CU().set(4112, Boolean.valueOf(!b));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            Intent intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            startActivity(intent);
        }
        if ("shake_item_histoty_list".equals(str)) {
            intent = new Intent(this, ShakeItemListUI.class);
            intent.putExtra("_key_show_type_", 100);
            intent.putExtra("_key_title_", getString(R.l.eOx));
            startActivity(intent);
        }
        if ("shake_msg_list".equals(str)) {
            intent = new Intent(this, ShakeMsgListUI.class);
            intent.putExtra("shake_msg_from", 2);
            intent.putExtra("shake_msg_list_title", getString(R.l.ePc));
            startActivity(intent);
        }
        return false;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (intent != null) {
                    Intent intent2 = new Intent();
                    intent2.putExtra("CropImageMode", 4);
                    intent2.putExtra("CropImage_Filter", true);
                    intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                    StringBuilder stringBuilder = new StringBuilder();
                    ar.Hg();
                    intent2.putExtra("CropImage_OutputPath", stringBuilder.append(c.Fi()).append("custom_shake_img_filename.jpg").toString());
                    a.ifs.a(intent2, 2, this, intent);
                    return;
                }
                return;
            case 2:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    ar.Hg();
                    c.CU().set(4110, Boolean.valueOf(false));
                    ar.Hg();
                    c.CU().set(4111, stringExtra);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
