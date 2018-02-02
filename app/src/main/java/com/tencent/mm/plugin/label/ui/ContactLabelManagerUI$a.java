package com.tencent.mm.plugin.label.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bv.a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

class ContactLabelManagerUI$a extends BaseAdapter {
    ArrayList<z> mData;
    final /* synthetic */ ContactLabelManagerUI nPj;

    ContactLabelManagerUI$a(ContactLabelManagerUI contactLabelManagerUI) {
        this.nPj = contactLabelManagerUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return rJ(i);
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public final z rJ(int i) {
        return (this.mData == null || i > this.mData.size()) ? null : (z) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.nPj).inflate(R.i.deP, viewGroup, false);
            cVar = new c(view);
            LayoutParams layoutParams = cVar.nQg.getLayoutParams();
            layoutParams.height = (int) (((float) a.ab(this.nPj, R.f.bvR)) * a.ex(this.nPj));
            cVar.nQg.setLayoutParams(layoutParams);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        z rJ = rJ(i);
        cVar.nQe.setText(i.c(this.nPj.mController.xIM, rJ.field_labelName, ContactLabelManagerUI.l(this.nPj)));
        if (ContactLabelManagerUI.j(this.nPj) == null || !ContactLabelManagerUI.j(this.nPj).containsKey(Integer.valueOf(rJ.field_labelID))) {
            cVar.nQf.setVisibility(0);
            cVar.nQf.setText("(0)");
        } else {
            cVar.nQf.setVisibility(0);
            cVar.nQf.setText("(" + ContactLabelManagerUI.j(this.nPj).get(Integer.valueOf(rJ.field_labelID)) + ")");
        }
        return view;
    }
}
