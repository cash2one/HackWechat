package com.tencent.mm.plugin.subapp.ui.friend;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.ui.friend.FMessageConversationUI.a;

class FMessageConversationUI$5 extends BaseAdapter {
    final /* synthetic */ FMessageConversationUI rXh;

    FMessageConversationUI$5(FMessageConversationUI fMessageConversationUI) {
        this.rXh = fMessageConversationUI;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.rXh.mController.xIM).inflate(R.i.diu, null);
            aVar = new a(this.rXh, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == 0) {
            aVar.jMv.setImageResource(R.k.dyA);
            aVar.jpW.setText(R.l.eht);
        }
        return view;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final int getCount() {
        return 1;
    }
}
