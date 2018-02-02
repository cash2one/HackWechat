package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.a;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.so;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.y;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends y implements OnClickListener {
    public static int lur = 60;
    public LinkedList<a> luq;
    private int lus = 0;
    public boolean lut = false;
    public ArrayList<String> luu = new ArrayList();
    private com.tencent.mm.aq.a.c.i luv = new 1(this);
    private Context mContext;
    private af mHandler = new af();

    public i(Context context, LinkedList<a> linkedList) {
        if (linkedList == null) {
            throw new IllegalAccessError("must has emoji banner list");
        }
        this.mContext = context;
        this.luq = new LinkedList();
        this.luq.addAll(linkedList);
    }

    public final void H(LinkedList<a> linkedList) {
        this.luq.clear();
        this.luq.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.luq == null) {
            return 0;
        }
        return this.luq.size() != 1 ? this.luq.size() * lur : 1;
    }

    public final void notifyDataSetChanged() {
        if (this.lut) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            return;
        }
        this.lus = getCount();
        super.notifyDataSetChanged();
    }

    public final int k(Object obj) {
        if (this.lus <= 0) {
            return super.k(obj);
        }
        this.lus--;
        return -2;
    }

    public final View d(int i, View view) {
        if (this.luq == null) {
            return null;
        }
        a aVar;
        int size = i % this.luq.size();
        a aVar2;
        if (view == null) {
            x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.i.dgi, null);
            aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar2 = (a) view.getTag();
            int i2 = EmojiStoreVpHeader.aT(this.mContext)[0];
            aVar2.luy.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            aVar = aVar2;
        }
        view.setTag(R.h.cdy, Integer.valueOf(size));
        view.setOnClickListener(this);
        a aVar3 = (a) this.luq.get(size);
        if (aVar3 == null) {
            x.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            return null;
        }
        String str;
        String str2;
        if (aVar3.lxn) {
            str = aVar3.lxl.wag.wah;
            if (bh.ov(aVar3.lxl.wai)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar3.lxm.wag.wah;
            str2 = aVar3.lxm.waf.vIR;
        }
        if (!(aVar3 == null || bh.ov(str))) {
            com.tencent.mm.bv.a.getDensity(this.mContext);
            EmojiInfo a = EmojiLogic.a(str2, 8, str, true);
            if (a != null) {
                aVar.luy.cR(a.ckB(), null);
            } else if (this.luu.contains(str)) {
                x.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                aVar.luy.cR("-", null);
            } else {
                o.PA().a(str, null, f.c(str2, str, str2, "BANNER"), this.luv);
                this.luu.add(str);
            }
        }
        x.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", new Object[]{Integer.valueOf(size), Integer.valueOf(i), str});
        return view;
    }

    public final void onClick(View view) {
        a aVar = (a) this.luq.get(((Integer) view.getTag(R.h.cdy)).intValue());
        if (aVar == null) {
            return;
        }
        if (aVar.lxn) {
            m.a(this.mContext, aVar.lxl, true);
            return;
        }
        so soVar = aVar.lxm.waf;
        if (soVar != null) {
            String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
            String str2 = "productId %s";
            Object[] objArr = new Object[1];
            objArr[0] = soVar == null ? "" : soVar.vIR;
            x.d(str, str2, objArr);
            g.pQN.h(11929, new Object[]{Integer.valueOf(0)});
            m.a(this.mContext, soVar, 15, -1, -1, "", 8);
        }
    }
}
