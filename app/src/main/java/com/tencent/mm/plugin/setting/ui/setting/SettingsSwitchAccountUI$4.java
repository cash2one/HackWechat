package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.z.bq;

class SettingsSwitchAccountUI$4 implements c {
    final /* synthetic */ SettingsSwitchAccountUI qlm;

    SettingsSwitchAccountUI$4(SettingsSwitchAccountUI settingsSwitchAccountUI) {
        this.qlm = settingsSwitchAccountUI;
    }

    public final void Jc(final String str) {
        h.a(this.qlm, this.qlm.getString(R.l.eNm, new Object[]{((SwitchAccountModel) SettingsSwitchAccountUI.c(this.qlm).get(str)).username}), this.qlm.getString(R.l.dGO), this.qlm.getString(R.l.dHd), this.qlm.getString(R.l.dFR), new OnClickListener(this) {
            final /* synthetic */ SettingsSwitchAccountUI$4 qlo;

            public final void onClick(DialogInterface dialogInterface, int i) {
                x.i("MicroMsg.SettingsSwitchAccountUI", "delete %s", new Object[]{str});
                SettingsSwitchAccountUI.a(this.qlo.qlm, true);
                bq.hhK.hZ(str);
                SettingsSwitchAccountUI.c(this.qlo.qlm).remove(str);
                SwitchAccountGridView d = SettingsSwitchAccountUI.d(this.qlo.qlm);
                String str = str;
                if (d.qnd.contains(str)) {
                    int indexOf = d.qnd.indexOf(str);
                    d.qnd.remove(str);
                    d.qne.remove(indexOf);
                    d.qnf.remove(indexOf);
                }
                SettingsSwitchAccountUI.d(this.qlo.qlm).brm();
                SettingsSwitchAccountUI.e(this.qlo.qlm);
                if (SettingsSwitchAccountUI.a(this.qlo.qlm) != 0) {
                    return;
                }
                if (bq.hhK.HV().size() > 0) {
                    g.pQN.h(14978, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
                    return;
                }
                g.pQN.h(14978, new Object[]{Integer.valueOf(0), Integer.valueOf(3)});
            }
        }, null);
    }
}
