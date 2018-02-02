package com.tencent.mm.plugin.setting.ui.setting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.brj;
import java.util.List;

class SettingsManageAuthUI$a extends BaseAdapter {
    final /* synthetic */ SettingsManageAuthUI qjE;
    List<brj> qjF;

    private class a {
        TextView kXX;
        Button lgD;
        final /* synthetic */ SettingsManageAuthUI$a qjG;
        TextView qjJ;
        TextView qjK;

        private a(SettingsManageAuthUI$a settingsManageAuthUI$a) {
            this.qjG = settingsManageAuthUI$a;
        }
    }

    private SettingsManageAuthUI$a(SettingsManageAuthUI settingsManageAuthUI) {
        this.qjE = settingsManageAuthUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return vT(i);
    }

    public final int getCount() {
        if (this.qjF == null || this.qjF.isEmpty()) {
            return 0;
        }
        return this.qjF.size();
    }

    public final brj vT(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return (brj) this.qjF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.qjE.getLayoutInflater().inflate(R.i.drZ, null);
            a aVar2 = new a();
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.kXX = (TextView) view.findViewById(R.h.cMh);
        aVar.qjJ = (TextView) view.findViewById(R.h.cMi);
        aVar.qjK = (TextView) view.findViewById(R.h.cMg);
        aVar.lgD = (Button) view.findViewById(R.h.cMf);
        aVar.lgD.setOnClickListener(new 1(this, i));
        if (SettingsManageAuthUI.c(this.qjE)) {
            aVar.lgD.setVisibility(0);
        } else {
            aVar.lgD.setVisibility(8);
        }
        if (vT(i) != null) {
            aVar.kXX.setText(vT(i).hcp);
            aVar.qjJ.setText(vT(i).wSR);
            aVar.qjK.setText(SettingsManageAuthUI.bE(vT(i).wSQ));
        }
        return view;
    }
}
