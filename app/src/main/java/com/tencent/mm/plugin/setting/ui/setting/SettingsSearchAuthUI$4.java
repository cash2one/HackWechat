package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.setting.modelsimple.UserAuthItemParcelable;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.protocal.c.brk;
import java.util.ArrayList;
import java.util.Arrays;

class SettingsSearchAuthUI$4 implements OnItemClickListener {
    final /* synthetic */ SettingsSearchAuthUI qkQ;

    SettingsSearchAuthUI$4(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.qkQ = settingsSearchAuthUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!SettingsSearchAuthUI.f(this.qkQ)) {
            brj vT = SettingsSearchAuthUI.g(this.qkQ).vT(i);
            if (vT != null) {
                Intent intent = new Intent(this.qkQ, SettingsModifyUserAuthUI.class);
                UserAuthItemParcelable[] userAuthItemParcelableArr = (UserAuthItemParcelable[]) UserAuthItemParcelable.CREATOR.newArray(vT.wSQ.size());
                for (int i2 = 0; i2 < vT.wSQ.size(); i2++) {
                    brk com_tencent_mm_protocal_c_brk = (brk) vT.wSQ.get(i2);
                    UserAuthItemParcelable userAuthItemParcelable = new UserAuthItemParcelable();
                    userAuthItemParcelable.scope = com_tencent_mm_protocal_c_brk.scope;
                    userAuthItemParcelable.qgh = com_tencent_mm_protocal_c_brk.qgh;
                    userAuthItemParcelable.state = com_tencent_mm_protocal_c_brk.state;
                    userAuthItemParcelable.qgi = com_tencent_mm_protocal_c_brk.qgi;
                    userAuthItemParcelableArr[i2] = userAuthItemParcelable;
                }
                intent.putExtra("app_id", vT.fFm);
                intent.putExtra("app_name", vT.hcp);
                intent.putExtra("modify_scene", 2);
                intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                this.qkQ.startActivity(intent);
            }
        }
    }
}
