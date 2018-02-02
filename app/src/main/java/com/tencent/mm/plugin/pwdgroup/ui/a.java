package com.tencent.mm.plugin.pwdgroup.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.un;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.HashMap;
import java.util.LinkedList;

public final class a extends BaseAdapter {
    private LinkedList<un> lGr = new LinkedList();
    private Context mContext;
    private Animation nKp;
    private Animation pmw;
    private Animation pmx;
    private HashMap<String, Boolean> pmy = new HashMap();

    public a(Context context) {
        this.mContext = context;
        this.nKp = AnimationUtils.loadAnimation(this.mContext, R.a.bpO);
        this.pmx = AnimationUtils.loadAnimation(this.mContext, R.a.bpO);
        this.pmw = AnimationUtils.loadAnimation(this.mContext, R.a.bpP);
        this.nKp.setInterpolator(new AccelerateDecelerateInterpolator());
        this.pmx.setInterpolator(new AccelerateInterpolator());
        this.pmw.setInterpolator(new AccelerateDecelerateInterpolator());
        this.nKp.setDuration(300);
        this.pmx.setDuration(1000);
        this.pmw.setDuration(1000);
    }

    public final void H(LinkedList<un> linkedList) {
        this.lGr = linkedList;
        if (this.lGr != null && this.lGr.size() > 0) {
            int size = this.lGr.size();
            for (int i = 0; i < size; i++) {
                String a = a((un) this.lGr.get(i));
                if (!this.pmy.containsKey(a)) {
                    this.pmy.put(a, Boolean.valueOf(false));
                }
            }
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.lGr == null ? 1 : this.lGr.size() + 1;
    }

    public final Object getItem(int i) {
        if (this.lGr != null && i < this.lGr.size()) {
            return this.lGr.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.dhq, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        un unVar = (un) getItem(i);
        if (unVar != null) {
            if (bh.ov(unVar.kub)) {
                aVar.jpW.setText(unVar.ksU);
            } else {
                aVar.jpW.setText(unVar.kub);
            }
            if (bh.ov(unVar.ksU)) {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jMv, unVar.wcv);
            } else {
                com.tencent.mm.plugin.pwdgroup.b.a.a(aVar.jMv, unVar.ksU);
            }
            String a = a(unVar);
            view.clearAnimation();
            if (this.pmy.containsKey(a) && !((Boolean) this.pmy.get(a)).booleanValue()) {
                view.startAnimation(this.nKp);
                this.pmy.put(a, Boolean.valueOf(true));
            }
        }
        if (i + 1 == getCount()) {
            aVar.jpW.setText("");
            aVar.jMv.setImageResource(R.g.byx);
            if (view != null) {
                this.pmx.setAnimationListener(new 1(this, view));
                this.pmw.setAnimationListener(new 2(this, view));
                view.startAnimation(this.pmx);
            }
        }
        return view;
    }

    private static String a(un unVar) {
        if (unVar == null) {
            return "";
        }
        if (bh.ov(unVar.ksU)) {
            return unVar.wcv;
        }
        return unVar.ksU;
    }
}
