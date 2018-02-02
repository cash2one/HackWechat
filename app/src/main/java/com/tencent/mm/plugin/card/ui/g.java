package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private OnClickListener inN = new 1(this);
    private boolean kKW = true;
    c kOB;
    List<CardInfo> kOM = new ArrayList();
    private boolean kTN = false;
    List<Boolean> kTO = new ArrayList();
    a kTP;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return nP(i);
    }

    public g(Context context) {
        this.kOB = new l(context, this);
        this.mContext = context;
    }

    public final int getCount() {
        return this.kOM.size();
    }

    public final CardInfo nP(int i) {
        return (CardInfo) this.kOM.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object nP = nP(i);
        nP.kKW = this.kKW;
        View a = this.kOB.a(i, view, nP);
        if (this.kTN && nP.atn()) {
            this.kOB.v(a, 0);
            if (((Boolean) this.kTO.get(i)).booleanValue()) {
                this.kOB.u(a, R.g.bAl);
            } else {
                this.kOB.u(a, R.g.bAm);
            }
            this.kOB.a(a, i, this.inN);
        } else {
            this.kOB.v(a, 8);
        }
        return a;
    }
}
