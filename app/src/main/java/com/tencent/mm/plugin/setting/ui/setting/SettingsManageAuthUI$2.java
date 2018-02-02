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

class SettingsManageAuthUI$2 implements OnItemClickListener {
    final /* synthetic */ SettingsManageAuthUI qjE;

    SettingsManageAuthUI$2(SettingsManageAuthUI settingsManageAuthUI) {
        this.qjE = settingsManageAuthUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!SettingsManageAuthUI.c(this.qjE)) {
            brj vT = SettingsManageAuthUI.d(this.qjE).vT(i);
            if (vT != null) {
                Intent intent = new Intent(this.qjE, SettingsModifyUserAuthUI.class);
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
                intent.putExtra("modify_scene", 1);
                intent.putParcelableArrayListExtra("app_auth_items", new ArrayList(Arrays.asList(userAuthItemParcelableArr)));
                this.qjE.startActivity(intent);
            }
        }
    }
}
