package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.ats;
import java.util.LinkedList;

final class SDKOAuthUI$a extends BaseAdapter {
    private LayoutInflater DF;
    private LinkedList<ats> txh;

    public final /* synthetic */ Object getItem(int i) {
        return AD(i);
    }

    public SDKOAuthUI$a(Context context, LinkedList<ats> linkedList) {
        this.DF = LayoutInflater.from(context);
        this.txh = linkedList;
    }

    public final LinkedList<String> bSq() {
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < this.txh.size(); i++) {
            ats com_tencent_mm_protocal_c_ats = (ats) this.txh.get(i);
            if (com_tencent_mm_protocal_c_ats.wBO == 2 || com_tencent_mm_protocal_c_ats.wBO == 3) {
                linkedList.add(com_tencent_mm_protocal_c_ats.scope);
            }
        }
        return linkedList;
    }

    public final int getCount() {
        return this.txh == null ? 0 : this.txh.size();
    }

    private ats AD(int i) {
        return (ats) this.txh.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (this.txh == null || this.txh.size() <= 0) {
            return null;
        }
        a aVar;
        final ats AD = AD(i);
        if (view == null) {
            a aVar2 = new a((byte) 0);
            view = this.DF.inflate(R.i.drm, null, false);
            aVar2.iVL = (ImageView) view.findViewById(R.h.bKp);
            aVar2.iVM = (TextView) view.findViewById(R.h.bKo);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (AD.wBO == 1) {
            aVar.iVL.setImageResource(R.k.dyV);
        } else if (AD.wBO == 3) {
            aVar.iVL.setImageResource(R.k.dyU);
        } else {
            aVar.iVL.setImageResource(R.k.dyT);
        }
        aVar.iVM.setText(AD.desc);
        final ImageView imageView = aVar.iVL;
        aVar.iVL.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SDKOAuthUI$a txj;

            public final void onClick(View view) {
                if (AD.wBO == 2) {
                    imageView.setImageResource(R.k.dyV);
                    AD.wBO = 1;
                } else if (AD.wBO == 1) {
                    imageView.setImageResource(R.k.dyT);
                    AD.wBO = 2;
                }
            }
        });
        return view;
    }
}
