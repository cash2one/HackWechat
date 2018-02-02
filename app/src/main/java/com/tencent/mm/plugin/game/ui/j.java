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
import com.tencent.mm.plugin.game.model.ag;
import com.tencent.mm.plugin.game.model.ag.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.storage.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class j extends BaseAdapter {
    int DD;
    private Context mContext;
    int ndn;
    private ag noc;

    public j(Context context) {
        this.mContext = context;
    }

    public final void a(ag agVar) {
        this.noc = agVar;
        com.tencent.mm.sdk.platformtools.ag.y(new 1(this));
    }

    public final int getCount() {
        return this.noc == null ? 0 : this.noc.ndx.size();
    }

    public final Object getItem(int i) {
        return this.noc.ndx.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.DD, viewGroup, false);
            a aVar2 = new a(this, (byte) 0);
            aVar2.noe = (TextView) inflate.findViewById(R.h.clH);
            aVar2.hvY = (ImageView) inflate.findViewById(R.h.clE);
            aVar2.jMw = (TextView) inflate.findViewById(R.h.clG);
            aVar2.nof = (TextView) inflate.findViewById(R.h.clJ);
            aVar2.nog = (TextView) inflate.findViewById(R.h.clI);
            aVar2.noh = (GameDetailRankLikeView) inflate.findViewById(R.h.clF);
            aVar2.noh.ndn = this.ndn;
            f((ViewGroup) inflate);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        a aVar3 = (a) getItem(i);
        aVar.noe.setText(aVar3.ndy);
        b.a(aVar.hvY, aVar3.fDC, 0.5f, false);
        ar.Hg();
        x WO = c.EY().WO(aVar3.fDC);
        if (WO != null) {
            aVar.jMw.setText(new SpannableString(i.b(this.mContext, WO.AQ(), aVar.jMw.getTextSize())));
        } else {
            aVar.jMw.setText("");
        }
        if (bh.ov(aVar3.tag)) {
            aVar.nof.setVisibility(8);
        } else {
            aVar.nof.setVisibility(0);
            aVar.nof.setText(aVar3.tag);
        }
        if (bh.ov(aVar3.ndB)) {
            aVar.nog.setText(aVar3.mMe);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.noh;
            ag agVar = this.noc;
            gameDetailRankLikeView.noi = agVar;
            gameDetailRankLikeView.mAppId = agVar.mAppId;
            gameDetailRankLikeView.noj = (a) agVar.ndx.get(i);
            gameDetailRankLikeView.aRy();
            aVar.noh.setVisibility(0);
        } else {
            aVar.nog.setText(aVar3.ndB);
            aVar.noh.setVisibility(8);
        }
        return view;
    }

    private void f(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                f((ViewGroup) childAt);
            }
        }
    }
}
