package com.tencent.mm.plugin.emoji.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.bdo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class EmojiStoreDetailUI$a extends BaseAdapter {
    final /* synthetic */ EmojiStoreDetailUI lDM;

    public EmojiStoreDetailUI$a(EmojiStoreDetailUI emojiStoreDetailUI) {
        this.lDM = emojiStoreDetailUI;
    }

    public int getCount() {
        return EmojiStoreDetailUI.b(this.lDM) == null ? 0 : EmojiStoreDetailUI.b(this.lDM).wax;
    }

    public Object getItem(int i) {
        if (EmojiStoreDetailUI.b(this.lDM) == null || EmojiStoreDetailUI.b(this.lDM).waH == null || EmojiStoreDetailUI.b(this.lDM).waH.size() <= 0 || EmojiStoreDetailUI.b(this.lDM).waH.get(i) == null || ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i)).wCX == null) {
            return null;
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks get preview : %d", new Object[]{Integer.valueOf(i)});
        String a = EmojiStoreDetailUI.a(this.lDM);
        String str = ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i)).wCX;
        a.getDensity(EmojiStoreDetailUI.p(this.lDM));
        EmojiInfo a2 = EmojiLogic.a(a, 8, str, false);
        if (a2 == null) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "detail preview emoji is null.");
            o.PA().a(((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i)).wCX, null, f.b(EmojiStoreDetailUI.a(this.lDM), ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i)).wCX, Integer.valueOf(i)), EmojiStoreDetailUI.z(this.lDM), EmojiStoreDetailUI.A(this.lDM), null, null, null, null);
        } else {
            g.pQN.k(10930, EmojiStoreDetailUI.a(this.lDM) + ",0");
            if (e.aAR().isEnable()) {
                a2.field_reserved4 = EmojiInfo.xAz;
            }
        }
        oQ(i);
        return a2;
    }

    private void oQ(int i) {
        int[] iArr = new int[]{i - 1, i + 1, i - 4, i + 4};
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[i2];
            if (EmojiStoreDetailUI.b(this.lDM) != null && i3 >= 0 && i3 < EmojiStoreDetailUI.b(this.lDM).waG) {
                ar.Hg();
                if (!com.tencent.mm.a.e.bO(EmojiLogic.G(c.Fp(), EmojiStoreDetailUI.a(this.lDM), ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i3)).wCX))) {
                    o.PA().a(((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i3)).wCX, null, f.b(EmojiStoreDetailUI.a(this.lDM), ((avh) EmojiStoreDetailUI.b(this.lDM).waH.get(i3)).wCX, Integer.valueOf(i3)), EmojiStoreDetailUI.z(this.lDM), EmojiStoreDetailUI.A(this.lDM), null, null, null, null);
                }
            }
        }
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreDetailUI.c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(EmojiStoreDetailUI.p(this.lDM)).inflate(R.i.dfJ, null);
            EmojiStoreDetailUI.c cVar2 = new EmojiStoreDetailUI.c(this.lDM, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (EmojiStoreDetailUI.c) view.getTag();
        }
        if (EmojiStoreDetailUI.q(this.lDM).zEh) {
            cVar.lDP.setBackgroundResource(R.g.bGr);
        } else {
            cVar.lDP.setBackgroundDrawable(null);
        }
        String str = "";
        if (EmojiStoreDetailUI.b(this.lDM).way != null) {
            str = n.a((bdo) EmojiStoreDetailUI.b(this.lDM).way.get(i));
        }
        o.PA().a(str, cVar.lDP, f.cg(EmojiStoreDetailUI.a(this.lDM), str));
        return view;
    }
}
