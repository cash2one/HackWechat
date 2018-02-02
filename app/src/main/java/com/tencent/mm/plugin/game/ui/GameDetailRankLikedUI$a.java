package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ef;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.LinkedList;
import java.util.List;

class GameDetailRankLikedUI$a extends BaseAdapter {
    private Context mContext;
    List<ef> not = new LinkedList();

    public final /* synthetic */ Object getItem(int i) {
        return qU(i);
    }

    public GameDetailRankLikedUI$a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.not.size();
    }

    private ef qU(int i) {
        return (ef) this.not.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.i.dkc, viewGroup, false);
            a aVar2 = new a((byte) 0);
            aVar2.hvY = (ImageView) view.findViewById(R.h.clK);
            aVar2.jMw = (TextView) view.findViewById(R.h.clL);
            aVar2.nou = (TextView) view.findViewById(R.h.clM);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ef qU = qU(i);
        b.a(aVar.hvY, qU.nkp, 0.5f, false);
        ar.Hg();
        x WO = c.EY().WO(qU.nkp);
        if (WO != null) {
            aVar.jMw.setText(new SpannableString(i.b(this.mContext, WO.AQ(), aVar.jMw.getTextSize())));
        } else {
            aVar.jMw.setText("");
        }
        aVar.nou.setText(qU.nkq);
        return view;
    }
}
