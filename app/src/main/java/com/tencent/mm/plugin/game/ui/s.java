package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.g.b.af;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.q;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class s extends BaseAdapter {
    private Context mContext;
    LinkedList<a> ntV;
    List<a> ntW;
    int ntX = 0;
    String ntY;
    a ntZ;
    GameRankFooter nua;
    boolean nub = false;
    boolean nuc = false;
    int nud = 0;

    static final class b {
        public TextView nue;
        public ImageView nuf;
        public ImageView nug;
        public TextView nuh;
        public TextView nui;
        public ImageView nuj;

        b() {
        }
    }

    public s(Context context, GameRankFooter gameRankFooter) {
        this.mContext = context;
        this.ntV = new LinkedList();
        this.ntW = new LinkedList();
        this.ntY = q.FS();
        this.nua = gameRankFooter;
    }

    public final void S(LinkedList<a> linkedList) {
        int i = 25;
        if (linkedList.size() == 0) {
            x.i("MicroMsg.GameRankAdapter", "Null or empty rank info");
            return;
        }
        this.ntV.clear();
        this.ntV.addAll(linkedList);
        if (this.ntV.size() <= 25) {
            i = this.ntV.size();
        }
        this.ntX = i;
        this.ntW = this.ntV.subList(0, this.ntX);
        this.nud = 0;
        if (this.ntV != null && this.ntV.size() > 0) {
            Iterator it = this.ntV.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                this.nud++;
                if (!bh.ov(aVar.fDC) && aVar.fDC.equals(this.ntY)) {
                    this.ntZ = aVar;
                    break;
                }
            }
        }
        if (this.ntX == this.ntV.size()) {
            this.nua.aRL();
            this.nuc = true;
        } else {
            this.nua.aRK();
        }
        if (this.nub || this.nud <= this.ntX) {
            this.nua.aRM();
        } else if (this.ntZ != null) {
            this.nua.a(this.ntZ);
        } else {
            this.nua.aRM();
        }
    }

    public final int getCount() {
        return this.ntW.size();
    }

    public final Object getItem(int i) {
        return this.ntW.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.mContext, R.i.dld, null);
            bVar.nue = (TextView) view.findViewById(R.h.cFo);
            bVar.nuf = (ImageView) view.findViewById(R.h.cFn);
            bVar.nug = (ImageView) view.findViewById(R.h.cUh);
            bVar.nuh = (TextView) view.findViewById(R.h.cUj);
            bVar.nui = (TextView) view.findViewById(R.h.cUn);
            bVar.nuj = (ImageView) view.findViewById(R.h.cUi);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        a aVar = (a) getItem(i);
        ar.Hg();
        af WO = c.EY().WO(aVar.fDC);
        if (WO != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.nug, WO.field_username);
            bVar.nuh.setText(new SpannableString(i.b(this.mContext, WO.AQ(), bVar.nuh.getTextSize())));
        }
        bVar.nui.setText(bh.formatNumber(aVar.mMe));
        switch (aVar.ndy) {
            case 1:
                bVar.nue.setVisibility(8);
                bVar.nuf.setVisibility(0);
                bVar.nuf.setImageResource(R.g.bCO);
                break;
            case 2:
                bVar.nue.setVisibility(8);
                bVar.nuf.setVisibility(0);
                bVar.nuf.setImageResource(R.g.bGq);
                break;
            case 3:
                bVar.nue.setVisibility(8);
                bVar.nuf.setVisibility(0);
                bVar.nuf.setImageResource(R.g.bAa);
                break;
            default:
                bVar.nue.setVisibility(0);
                bVar.nuf.setVisibility(8);
                bVar.nue.setText(aVar.ndy);
                break;
        }
        switch (aVar.level) {
            case 1:
                bVar.nuj.setVisibility(0);
                bVar.nuj.setImageResource(R.g.bCJ);
                break;
            case 2:
                bVar.nuj.setVisibility(0);
                bVar.nuj.setImageResource(R.g.bCK);
                break;
            case 3:
                bVar.nuj.setVisibility(0);
                bVar.nuj.setImageResource(R.g.bCL);
                break;
            case 4:
                bVar.nuj.setVisibility(0);
                bVar.nuj.setImageResource(R.g.bCM);
                break;
            default:
                bVar.nuj.setVisibility(8);
                break;
        }
        if (i == 0) {
            if (getCount() == 1) {
                if (Ci(aVar.fDC)) {
                    view.setBackgroundResource(R.g.bDW);
                } else {
                    view.setBackgroundResource(R.g.bDV);
                }
            } else if (Ci(aVar.fDC)) {
                view.setBackgroundResource(R.g.bEc);
            } else {
                view.setBackgroundResource(R.g.bEb);
            }
        } else if (i != getCount() - 1) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
            if (Ci(aVar.fDC)) {
                view.setBackgroundResource(R.g.bEa);
            } else {
                view.setBackgroundResource(R.g.bDZ);
            }
        } else if (Ci(aVar.fDC)) {
            if (this.nuc) {
                view.setBackgroundResource(R.g.bDY);
            } else {
                view.setBackgroundResource(R.g.bEa);
            }
        } else if (this.nuc) {
            view.setBackgroundResource(R.g.bDX);
        } else {
            view.setBackgroundResource(R.g.bDZ);
        }
        return view;
    }

    private boolean Ci(String str) {
        if (bh.ov(str) || bh.ov(this.ntY)) {
            return false;
        }
        boolean equals = this.ntY.equals(str);
        this.nub = equals;
        return equals;
    }
}
