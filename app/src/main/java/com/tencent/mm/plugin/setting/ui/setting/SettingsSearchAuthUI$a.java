package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.modelsimple.b;
import com.tencent.mm.protocal.c.brj;
import com.tencent.mm.ui.base.h;
import java.util.List;

class SettingsSearchAuthUI$a extends BaseAdapter {
    List<brj> qjF;
    final /* synthetic */ SettingsSearchAuthUI qkQ;

    private class a {
        TextView kXX;
        Button lgD;
        TextView qjJ;
        TextView qjK;
        final /* synthetic */ SettingsSearchAuthUI$a qkS;

        private a(SettingsSearchAuthUI$a settingsSearchAuthUI$a) {
            this.qkS = settingsSearchAuthUI$a;
        }
    }

    private SettingsSearchAuthUI$a(SettingsSearchAuthUI settingsSearchAuthUI) {
        this.qkQ = settingsSearchAuthUI;
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

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = this.qkQ.getLayoutInflater().inflate(R.i.drZ, null);
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
        aVar.lgD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsSearchAuthUI$a qkS;

            public final void onClick(View view) {
                if (this.qkS.vT(i) != null) {
                    final k bVar = new b(this.qkS.vT(i).fFm, 2);
                    if (SettingsSearchAuthUI.j(this.qkS.qkQ) != null) {
                        SettingsSearchAuthUI.j(this.qkS.qkQ).dismiss();
                    }
                    g.CG().a(bVar, 0);
                    SettingsSearchAuthUI.a(this.qkS.qkQ, h.a(this.qkS.qkQ, this.qkS.qkQ.getString(R.l.dGB), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass1 qkT;

                        public final void onCancel(DialogInterface dialogInterface) {
                            g.CG().c(bVar);
                        }
                    }));
                }
            }
        });
        if (SettingsSearchAuthUI.f(this.qkQ)) {
            aVar.lgD.setVisibility(0);
        } else {
            aVar.lgD.setVisibility(8);
        }
        if (vT(i) != null) {
            aVar.kXX.setText(vT(i).hcp);
            aVar.qjJ.setText(vT(i).wSR);
            aVar.qjK.setText(SettingsSearchAuthUI.bF(vT(i).wSQ));
        }
        return view;
    }
}
