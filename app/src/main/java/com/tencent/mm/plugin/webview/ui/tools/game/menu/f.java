package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;

public final class f extends BaseAdapter {
    private static final String nby = (a.bnF + "Game/HvMenu/");
    private Context mContext;
    n rKE;

    public final /* synthetic */ Object getItem(int i) {
        return (o) this.rKE.ycc.get(i);
    }

    public f(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.rKE == null ? 0 : this.rKE.size();
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.i.dkM, viewGroup, false);
        a aVar = new a(this, inflate);
        o oVar = (o) this.rKE.ycc.get(i);
        if (!(oVar == null || oVar.getItemId() == -1)) {
            String charSequence = oVar.getTitle().toString();
            if (!bh.ov(charSequence)) {
                String[] split = charSequence.split("__", 2);
                if (split.length == 1) {
                    aVar.jpW.setText(split[0]);
                } else {
                    aVar.jpW.setText(split[0]);
                    charSequence = split[1];
                    if (charSequence.startsWith("http")) {
                        String str = nby + g.s(charSequence.getBytes());
                        c.a aVar2 = new c.a();
                        aVar2.hDA = true;
                        aVar2.hDC = str;
                        com.tencent.mm.aq.a.a.PH().a(charSequence, aVar.jMv, aVar2.PK());
                    } else {
                        aVar.jMv.setImageResource(ac.getResources().getIdentifier(charSequence, "drawable", ac.getPackageName()));
                    }
                }
                inflate.setTag(oVar);
                return inflate;
            }
        }
        inflate.setTag(null);
        return inflate;
    }
}
