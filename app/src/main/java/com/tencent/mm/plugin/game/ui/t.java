package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.d.e$a$a;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class t extends BaseAdapter {
    Context context;
    boolean foh = false;
    ArrayList<b> lfg;
    int nds = 0;
    int nrV = 0;
    boolean nuM = false;
    int nuN = 0;
    int nuO = 0;
    int nuP = 0;
    int nuQ = 0;
    private int nuR;
    boolean nuS = false;
    boolean nuT = false;
    private ArrayList<d> nuU;

    public t(Context context) {
        this.context = context;
        this.lfg = null;
        this.nuR = context.getResources().getColor(R.e.bsC);
    }

    public final int getCount() {
        return this.lfg == null ? 0 : this.lfg.size();
    }

    public final Object getItem(int i) {
        return this.lfg.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((b) getItem(i)).type;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a((byte) 0);
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = R.i.dlm;
                    break;
                case 1:
                    i2 = R.i.dlg;
                    break;
                case 2:
                    i2 = R.i.dln;
                    break;
                case 3:
                    i2 = R.i.dll;
                    break;
                case 5:
                    i2 = R.i.dli;
                    break;
                case 6:
                    i2 = R.i.dlj;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.contentView = view.findViewById(R.h.cmu);
            aVar.nuY = (ImageView) view.findViewById(R.h.cmx);
            aVar.nuZ = (TextView) view.findViewById(R.h.cmy);
            aVar.nva = (TextView) view.findViewById(R.h.cms);
            aVar.nvb = (TextView) view.findViewById(R.h.cmv);
            aVar.nvc = (TextView) view.findViewById(R.h.cmz);
            aVar.nvd = view.findViewById(R.h.cmw);
            aVar.nve = (TextView) view.findViewById(R.h.cPb);
            aVar.nvf = (TextView) view.findViewById(R.h.bZN);
            view.setTag(aVar);
            if (!(aVar.nuZ == null || aVar.nvb == null)) {
                TextView textView = aVar.nuZ;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new 1(this, textView, aVar.nvb));
            }
        } else {
            aVar = (a) view.getTag();
        }
        e$a$a com_tencent_mm_plugin_game_d_e_a_a;
        switch (bVar.type) {
            case 0:
                aVar.nvb.setText(bVar.name);
                break;
            case 1:
                if (!bh.ov(bVar.iconUrl)) {
                    com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                    com_tencent_mm_plugin_game_d_e_a_a.hDy = false;
                    com_tencent_mm_plugin_game_d_e_a_a.hDA = false;
                    e.aRV().a(aVar.nuY, bVar.iconUrl, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                }
                a(aVar.nuZ, bVar.name);
                a(aVar.nva, bVar.nvg);
                a(aVar.nvb, bVar.iIj);
                break;
            case 2:
                if (bh.ov(bVar.iconUrl)) {
                    aVar.nuY.setVisibility(8);
                } else {
                    com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                    com_tencent_mm_plugin_game_d_e_a_a.hDy = false;
                    com_tencent_mm_plugin_game_d_e_a_a.hDA = false;
                    com_tencent_mm_plugin_game_d_e_a_a.nxt = true;
                    e.aRV().a(aVar.nuY, bVar.iconUrl, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                    aVar.nuY.setVisibility(0);
                }
                a(aVar.nuZ, bVar.name);
                a(aVar.nvb, bVar.iIj);
                if (bh.ov(bVar.hhi)) {
                    aVar.nve.setVisibility(8);
                } else {
                    aVar.nve.setText(i.a(this.context, bVar.hhi));
                    aVar.nve.setVisibility(0);
                }
                if (bVar.hVE <= 0) {
                    aVar.nvf.setVisibility(8);
                    break;
                }
                aVar.nvf.setText(b.f(this.context, bVar.hVE * 1000));
                aVar.nvf.setVisibility(0);
                break;
            case 3:
                if (!bh.ov(bVar.iconUrl)) {
                    com_tencent_mm_plugin_game_d_e_a_a = new e$a$a();
                    com_tencent_mm_plugin_game_d_e_a_a.hDy = false;
                    com_tencent_mm_plugin_game_d_e_a_a.hDA = false;
                    e.aRV().a(aVar.nuY, bVar.iconUrl, com_tencent_mm_plugin_game_d_e_a_a.aRW());
                }
                a(aVar.nuZ, bVar.name);
                a(aVar.nva, bVar.nvg);
                a(aVar.nvb, bVar.iIj);
                TextView textView2 = aVar.nvc;
                LinkedList linkedList = bVar.nvj;
                StringBuilder stringBuilder = new StringBuilder();
                if (!bh.cA(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + "\n");
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView2.setVisibility(0);
                    textView2.setText(stringBuilder.toString());
                    break;
                }
                textView2.setVisibility(8);
                break;
            case 5:
                aVar.nuY.setImageResource(R.k.dAz);
                break;
            case 6:
                break;
        }
        aVar.nuZ.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.nvm) {
                    aVar.nvd.setVisibility(0);
                    break;
                }
                aVar.nvd.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.nvn) {
                    aVar.contentView.setBackgroundResource(R.g.bBy);
                } else {
                    aVar.contentView.setBackgroundResource(R.g.bBx);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.f.bvO);
                aVar.contentView.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        return view;
    }

    private void a(TextView textView, String str) {
        if (bh.ov(str)) {
            textView.setVisibility(8);
            return;
        }
        if (this.nuU == null) {
            this.nuU = new ArrayList();
        } else {
            this.nuU.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d(this, (byte) 0);
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.nuU.add(dVar);
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        Iterator it = this.nuU.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.start < dVar2.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.nuR), dVar2.start, dVar2.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
    }
}
