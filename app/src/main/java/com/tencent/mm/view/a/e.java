package com.tencent.mm.view.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.aq.a.a.c;
import com.tencent.mm.aq.o;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.m.a$d;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.io.File;
import java.util.ArrayList;

public final class e extends BaseAdapter {
    public static final String lxr = File.separator;
    private Context mContext;
    public ArrayList<EmojiGroupInfo> mData = new ArrayList();
    private com.tencent.mm.view.f.a zDs;
    c zEz = null;

    class a {
        ImageView fvf;
        final /* synthetic */ e zEA;

        public a(e eVar, View view) {
            this.zEA = eVar;
            this.fvf = (ImageView) view.findViewById(com.tencent.mm.plugin.m.a.e.lJs);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return Hr(i);
    }

    public e(Context context, com.tencent.mm.view.f.a aVar) {
        this.mContext = context;
        this.zDs = aVar;
        com.tencent.mm.aq.a.a.c.a aVar2 = new com.tencent.mm.aq.a.a.c.a();
        aVar2.hDy = true;
        aVar2.hDF = 4;
        aVar2.hDT = a$d.lJc;
        aVar2.hDG = this.zDs.zGt;
        aVar2.hDG = this.zDs.zGt;
        this.zEz = aVar2.PK();
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public final EmojiGroupInfo Hr(int i) {
        if (this.mData == null || this.mData.isEmpty() || this.mData.size() < i) {
            return null;
        }
        return (EmojiGroupInfo) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(f.lJC, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo Hr = Hr(i);
        if (Hr == null) {
            aVar.fvf.setVisibility(8);
            aVar.fvf.setTag("");
            x.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "emoji group info is null. position:%d", new Object[]{Integer.valueOf(i)});
        } else {
            aVar.fvf.setVisibility(0);
            if ("TAG_DEFAULT_TAB".equals(Hr.field_productID)) {
                if (((h) g.Dg().CN()).DS()) {
                    o.PA().a(com.tencent.mm.plugin.m.a.g.lJH, aVar.fvf, this.zEz);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(com.tencent.mm.plugin.m.a.g.lJH, aVar.fvf, this.zEz);
                }
                aVar.fvf.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.m.a.h.lJO));
            } else if (String.valueOf(EmojiGroupInfo.xAc).equals(Hr.field_productID)) {
                if (((h) g.Dg().CN()).DS()) {
                    o.PA().a(com.tencent.mm.plugin.m.a.g.lJG, aVar.fvf, this.zEz);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(com.tencent.mm.plugin.m.a.g.lJG, aVar.fvf, this.zEz);
                }
                aVar.fvf.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.m.a.h.lJQ));
            } else if (String.valueOf(EmojiGroupInfo.xAb).equals(Hr.field_productID)) {
                if (((h) g.Dg().CN()).DS()) {
                    o.PA().a(a$d.lJh, aVar.fvf, this.zEz);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(a$d.lJh, aVar.fvf, this.zEz);
                }
                aVar.fvf.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.m.a.h.ebe));
            } else if ("TAG_STORE_MANEGER_TAB".equals(Hr.field_productID)) {
                if (((h) g.Dg().CN()).DS()) {
                    o.PA().a(com.tencent.mm.plugin.m.a.g.lJI, aVar.fvf, this.zEz);
                } else {
                    ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(com.tencent.mm.plugin.m.a.g.lJI, aVar.fvf, this.zEz);
                }
                aVar.fvf.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.m.a.h.eLm));
            } else {
                String str;
                if (com.tencent.mm.view.f.a.d(Hr)) {
                    str = G(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().FC() + "emoji/", Hr.field_productID, "") + "_panel_enable";
                    com.tencent.mm.aq.a.a.c.a aVar3 = new com.tencent.mm.aq.a.a.c.a();
                    aVar3.hDC = str;
                    aVar3.hDy = true;
                    aVar3.hDT = a$d.lJc;
                    aVar3.hDF = 1;
                    aVar3.hDG = this.zDs.zGt;
                    aVar3.hDG = this.zDs.zGt;
                    ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(str, aVar.fvf, aVar3.PK());
                } else {
                    str = Hr.field_packGrayIconUrl;
                    String G = G(((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().FC() + "emoji/", Hr.field_productID, str);
                    com.tencent.mm.aq.a.a.c.a aVar4 = new com.tencent.mm.aq.a.a.c.a();
                    aVar4.hDC = G;
                    aVar4.hDy = true;
                    aVar4.hDA = true;
                    aVar4.hDT = a$d.lJc;
                    aVar4.hDJ = true;
                    aVar4.hDG = this.zDs.zGt;
                    aVar4.hDG = this.zDs.zGt;
                    c PK = aVar4.PK();
                    if (bh.ov(str)) {
                        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a("", aVar.fvf, PK);
                        x.i("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "empty url.");
                    } else {
                        ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getProvider().aBe().a(str, aVar.fvf, PK);
                    }
                }
                if (bh.ov(Hr.field_packName)) {
                    aVar.fvf.setContentDescription(this.mContext.getString(com.tencent.mm.plugin.m.a.h.eaY));
                } else {
                    aVar.fvf.setContentDescription(Hr.field_packName);
                }
            }
            aVar.fvf.setBackgroundResource(a$d.lJc);
            aVar.fvf.setPadding(this.zDs.zGu, this.zDs.zGu, this.zDs.zGu, this.zDs.zGu);
            if (i == this.zDs.cAZ()) {
                aVar.fvf.setSelected(true);
            } else {
                aVar.fvf.setSelected(false);
            }
        }
        return view;
    }

    private static String G(String str, String str2, String str3) {
        if (bh.ov(str2) && bh.ov(str3)) {
            x.w("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String str4;
        if (bh.ov(str2) && bh.ov(str3)) {
            x.e("MicroMsg.emoji.SmileyPanel.SmileyTabAdapter", "[cpan] product id and url are null.");
            str4 = null;
        } else {
            str4 = bh.ov(str3) ? com.tencent.mm.a.g.s(str2.getBytes()) : com.tencent.mm.a.g.s(str3.getBytes());
        }
        if (bh.ov(str4)) {
            return null;
        }
        if (bh.ov(str2)) {
            return str + str4;
        }
        return str + str2 + lxr + str4;
    }
}
