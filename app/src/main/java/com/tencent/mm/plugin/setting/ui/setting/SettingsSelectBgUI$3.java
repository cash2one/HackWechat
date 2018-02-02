package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.az.j;
import com.tencent.mm.az.m;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class SettingsSelectBgUI$3 implements OnItemClickListener {
    final /* synthetic */ SettingsSelectBgUI qkZ;

    SettingsSelectBgUI$3(SettingsSelectBgUI settingsSelectBgUI) {
        this.qkZ = settingsSelectBgUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i == 0) {
            SettingsSelectBgUI.a(this.qkZ, -2);
            SettingsSelectBgUI.b(this.qkZ).Xy();
            if (!SettingsSelectBgUI.c(this.qkZ)) {
                this.qkZ.setResult(-1);
                this.qkZ.finish();
            }
        } else if (i == 1) {
            SettingsSelectBgUI.a(this.qkZ, 0);
            SettingsSelectBgUI.b(this.qkZ).Xy();
            if (!SettingsSelectBgUI.c(this.qkZ)) {
                this.qkZ.setResult(-1);
                this.qkZ.finish();
            }
        } else {
            ar.Hg();
            if (c.isSDCardAvailable()) {
                m mVar = (m) adapterView.getItemAtPosition(i - 2);
                if (mVar == null) {
                    x.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = " + i);
                    return;
                }
                n QH;
                switch (mVar.status) {
                    case 1:
                    case 2:
                        SettingsSelectBgUI.a(this.qkZ, mVar.id);
                        if (SettingsSelectBgUI.c(this.qkZ)) {
                            mVar.status = 1;
                            QH = r.QH();
                            QH.ii(mVar.fvM);
                            mVar.status = 1;
                            QH.b(mVar);
                        } else {
                            SettingsSelectBgUI.b(this.qkZ).Xy();
                        }
                        if (!SettingsSelectBgUI.c(this.qkZ)) {
                            this.qkZ.setResult(-1);
                            this.qkZ.finish();
                            return;
                        }
                        return;
                    case 3:
                        if (SettingsSelectBgUI.d(this.qkZ) != null && SettingsSelectBgUI.d(this.qkZ).hJE == mVar.id) {
                            ar.CG().c(SettingsSelectBgUI.d(this.qkZ));
                            r.QH().bi(SettingsSelectBgUI.d(this.qkZ).hJE, 1);
                            SettingsSelectBgUI.a(this.qkZ, SettingsSelectBgUI.e(this.qkZ));
                        }
                        SettingsSelectBgUI.e(mVar.id, SettingsSelectBgUI.e(this.qkZ));
                        QH = r.QH();
                        mVar.status = 4;
                        QH.b(mVar);
                        new 1(this, QH, mVar.id).sendEmptyMessageDelayed(0, 1000);
                        return;
                    case 4:
                        r.QH().bi(mVar.id, 1);
                        return;
                    case 5:
                        if (SettingsSelectBgUI.d(this.qkZ) == null) {
                            SettingsSelectBgUI.a(this.qkZ, new j(mVar.id, 1));
                            ar.CG().a(SettingsSelectBgUI.d(this.qkZ), 0);
                            return;
                        }
                        SettingsSelectBgUI.e(this.qkZ).add(new j(mVar.id, 1));
                        return;
                    default:
                        return;
                }
            }
            Toast.makeText(this.qkZ, R.l.eMS, 1).show();
        }
    }
}
