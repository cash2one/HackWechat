package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.Iterator;
import java.util.LinkedList;

public final class u extends BaseAdapter {
    private Context context;
    private String fod = "";
    private LinkedList<a> hdX = new LinkedList();

    public final /* synthetic */ Object getItem(int i) {
        return rb(i);
    }

    public u(Context context) {
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a rb = rb(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.dlk, null);
            b bVar2 = new b((byte) 0);
            bVar2.jpW = (TextView) view.findViewById(R.h.cni);
            bVar2.nvs = (ViewGroup) bVar2.jpW.getParent();
            bVar2.nvt = (TextView) view.findViewById(R.h.cnh);
            bVar2.nvu = (TextView) view.findViewById(R.h.cnf);
            bVar2.nvv = (ViewGroup) bVar2.nvt.getParent();
            bVar2.nvw = (TextView) view.findViewById(R.h.cng);
            bVar2.nvx = (ViewGroup) bVar2.nvw.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (rb.type) {
            case 1:
                bVar.nvs.setVisibility(0);
                bVar.nvv.setVisibility(8);
                bVar.nvx.setVisibility(8);
                bVar.nvs.setOnClickListener(null);
                bVar.jpW.setText(rb.text);
                break;
            case 2:
                bVar.nvs.setVisibility(8);
                bVar.nvv.setVisibility(0);
                bVar.nvx.setVisibility(8);
                bVar.nvt.setText(rb.text);
                bVar.nvu.setText(rb.description);
                break;
            case 3:
                bVar.nvs.setVisibility(8);
                bVar.nvv.setVisibility(8);
                bVar.nvx.setVisibility(0);
                bVar.nvw.setTextColor(this.context.getResources().getColor(R.e.btv));
                int color = this.context.getResources().getColor(R.e.bsC);
                int indexOf = rb.text.indexOf(this.fod);
                if (indexOf < 0) {
                    bVar.nvw.setText(rb.text);
                    break;
                }
                CharSequence spannableString = new SpannableString(rb.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.fod.length() + indexOf, 33);
                bVar.nvw.setText(spannableString);
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.hdX.size();
    }

    public final a rb(int i) {
        return (a) this.hdX.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(String str, String str2, LinkedList<wq> linkedList) {
        if (!bh.cA(linkedList)) {
            this.fod = str;
            this.hdX.clear();
            if (bh.ov(str)) {
                a aVar = new a();
                aVar.type = 1;
                if (bh.ov(str2)) {
                    aVar.text = this.context.getString(R.l.cni);
                } else {
                    aVar.text = str2;
                }
                this.hdX.add(aVar);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                wq wqVar = (wq) it.next();
                a aVar2 = new a();
                aVar2.type = bh.ov(str) ? 2 : 3;
                aVar2.appId = wqVar.nfn;
                aVar2.text = wqVar.wgZ;
                aVar2.description = wqVar.vIO;
                aVar2.actionType = wqVar.wgQ;
                aVar2.nvr = wqVar.wgR;
                this.hdX.add(aVar2);
            }
            notifyDataSetChanged();
        }
    }
}
