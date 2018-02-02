package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.cb.a$c;
import com.tencent.mm.cb.a.e;
import com.tencent.mm.cb.a.f;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p$d;
import com.tencent.mm.ui.base.p.c;
import java.util.ArrayList;
import java.util.HashMap;

public final class b {
    public Button krY = ((Button) this.lCk.findViewById(e.cBC));
    public Button krZ = ((Button) this.lCk.findViewById(e.bPo));
    public View lCk = View.inflate(this.mContext, f.zzz, null);
    public Context mContext;
    public c rKC;
    public p$d rKD;
    public n rKE = new n();
    public android.support.design.widget.c yIe = new android.support.design.widget.c(this.mContext);
    public int yIf;
    private BottomSheetBehavior yIg;
    public ListView zyd = ((ListView) this.lCk.findViewById(e.zzn));
    public View zye = this.lCk.findViewById(e.zzj);
    public TextView zyf = ((TextView) this.lCk.findViewById(e.zzk));
    public ArrayList<Integer> zyg;
    public a zyh;
    public b zyi;

    public class a extends BaseAdapter {
        private Context context;
        final /* synthetic */ b zyj;
        public HashMap<Integer, Boolean> zyk = new HashMap();
        private ArrayList<Integer> zyl;

        public a(b bVar, Context context) {
            this.zyj = bVar;
            this.context = context;
        }

        public final int getCount() {
            return this.zyj.rKE.size();
        }

        public final Object getItem(int i) {
            return this.zyj.rKE.ycc.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            o oVar = (o) this.zyj.rKE.ycc.get(i);
            LayoutInflater from = LayoutInflater.from(this.context);
            if (view == null) {
                view = from.inflate(f.zzy, null);
                a aVar2 = new a(this);
                aVar2.ztF = (LinearLayout) view.findViewById(e.zzm);
                aVar2.mSc = (CheckBox) view.findViewById(e.zzl);
                aVar2.iiq = (TextView) view.findViewById(e.crT);
                aVar2.iir = (TextView) view.findViewById(e.cru);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.iiq.setText(oVar.getTitle());
            aVar.ztF.setOnClickListener(new 1(this, i, oVar));
            if (aVar.iir != null) {
                if (oVar.qef == null || oVar.qef.length() <= 0) {
                    aVar.iir.setVisibility(8);
                } else {
                    aVar.iir.setVisibility(0);
                    aVar.iir.setText(oVar.qef);
                }
            }
            if (oVar.wPS) {
                aVar.iiq.setTextColor(this.zyj.mContext.getResources().getColor(com.tencent.mm.cb.a.b.zyL));
                aVar.iir.setTextColor(this.zyj.mContext.getResources().getColor(com.tencent.mm.cb.a.b.zyL));
                aVar.mSc.setChecked(((Boolean) this.zyk.get(Integer.valueOf(i))).booleanValue());
                aVar.mSc.setEnabled(false);
            } else {
                aVar.iiq.setTextColor(this.zyj.mContext.getResources().getColor(com.tencent.mm.cb.a.b.isB));
                aVar.iir.setTextColor(this.zyj.mContext.getResources().getColor(com.tencent.mm.cb.a.b.zyM));
                aVar.mSc.setChecked(((Boolean) this.zyk.get(Integer.valueOf(i))).booleanValue());
                aVar.mSc.setEnabled(true);
            }
            return view;
        }

        public final void czv() {
            if (this.zyj.zyg != null) {
                for (int i = 0; i < getCount(); i++) {
                    if (this.zyj.zyg.contains(Integer.valueOf(i))) {
                        this.zyk.put(Integer.valueOf(i), Boolean.valueOf(true));
                    } else {
                        this.zyk.put(Integer.valueOf(i), Boolean.valueOf(false));
                    }
                }
            }
        }

        public final ArrayList<Integer> czw() {
            if (this.zyk == null) {
                return null;
            }
            this.zyl = new ArrayList();
            for (int i = 0; i < getCount(); i++) {
                if (((Boolean) this.zyk.get(Integer.valueOf(i))).booleanValue()) {
                    this.zyl.add(Integer.valueOf(i));
                }
            }
            return this.zyl;
        }
    }

    static /* synthetic */ void a(b bVar, boolean z, ArrayList arrayList) {
        if (bVar.zyi != null) {
            bVar.zyi.hB(z);
        }
    }

    public b(Context context) {
        this.mContext = context;
        this.yIe.setContentView(this.lCk);
        this.yIf = ah.ab(this.mContext, a$c.zyS) + ah.ab(this.mContext, a$c.zyT);
        this.yIg = BottomSheetBehavior.i((View) this.lCk.getParent());
        if (this.yIg != null) {
            this.yIg.q(this.yIf);
            this.yIg.fj = false;
        }
        this.yIe.setOnDismissListener(new 1(this));
    }

    public final void hide() {
        if (this.yIe != null) {
            this.yIe.dismiss();
        }
    }
}
