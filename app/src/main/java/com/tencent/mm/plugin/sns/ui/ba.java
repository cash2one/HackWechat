package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p.c;
import com.tencent.mm.ui.base.p.d;
import java.util.HashMap;

public final class ba implements OnItemClickListener {
    private LayoutInflater DF;
    private Context mContext;
    private m rKB;
    c rKC;
    d rKD;
    private n rKE;
    private a rKF;
    private HashMap<Integer, CharSequence> rKG = new HashMap();
    private HashMap<Integer, Integer> rKH = new HashMap();

    private class a extends BaseAdapter {
        final /* synthetic */ ba rKI;

        private a(ba baVar) {
            this.rKI = baVar;
        }

        public final int getCount() {
            return this.rKI.rKE.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.rKI.DF.inflate(g.qId, viewGroup, false);
                aVar = new a(this, (byte) 0);
                aVar.jpW = (TextView) view.findViewById(f.title);
                aVar.rKJ = (TextView) view.findViewById(f.qDi);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = this.rKI.rKE.getItem(i);
            aVar.jpW.setText(item.getTitle());
            if (this.rKI.rKG.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rKJ.setText((CharSequence) this.rKI.rKG.get(Integer.valueOf(item.getItemId())));
                aVar.rKJ.setVisibility(0);
            } else {
                aVar.rKJ.setVisibility(4);
            }
            if (this.rKI.rKH.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.rKJ.setTextColor(((Integer) this.rKI.rKH.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            return view;
        }
    }

    public ba(Context context) {
        this.mContext = context;
        this.DF = LayoutInflater.from(context);
        this.rKB = new m(context);
        this.rKE = new n();
    }

    public final void d(int i, CharSequence charSequence) {
        this.rKG.put(Integer.valueOf(i), charSequence);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        o oVar = (o) this.rKE.ycc.get(i);
        if (oVar.performClick()) {
            x.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.rKD != null) {
            this.rKD.onMMMenuItemSelected(oVar, i);
        }
        dismiss();
    }

    private void dismiss() {
        if (this.rKB.isShowing()) {
            this.rKB.dismiss();
        }
    }

    public final Dialog bBX() {
        if (this.rKC != null) {
            this.rKE.clear();
            this.rKE = new n();
            this.rKC.a(this.rKE);
        }
        if (this.rKE.cps()) {
            x.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            return null;
        }
        if (this.rKF == null) {
            this.rKF = new a();
        }
        this.rKB.kPo = this.rKF;
        this.rKB.vwr = this;
        this.rKB.setTitle(this.rKE.Lp);
        this.rKB.show();
        return this.rKB;
    }
}
