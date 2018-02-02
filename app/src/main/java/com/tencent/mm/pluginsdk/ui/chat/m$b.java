package com.tencent.mm.pluginsdk.ui.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pluginsdk.ui.chat.m.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;

class m$b extends BaseAdapter {
    ArrayList<EmojiInfo> mData;
    final /* synthetic */ m vrP;

    m$b(m mVar) {
        this.vrP = mVar;
    }

    public final /* synthetic */ Object getItem(int i) {
        return oO(i);
    }

    public final int getCount() {
        return this.mData == null ? 0 : this.mData.size();
    }

    public final EmojiInfo oO(int i) {
        if (this.mData == null || this.mData.size() <= i) {
            return null;
        }
        return (EmojiInfo) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.vrP.mContext).inflate(f.lJy, null);
            c cVar2 = new c(this.vrP, view);
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        EmojiInfo oO = oO(i);
        cVar.lAo.hX = this.vrP.vrC;
        cVar.lAo.setScaleType(ScaleType.CENTER_INSIDE);
        CharSequence charSequence = "";
        if (oO != null) {
            charSequence = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().xZ(oO.Nr());
        }
        if (bh.ov(charSequence)) {
            cVar.lAo.setContentDescription(this.vrP.mContext.getString(h.eaY));
        } else {
            cVar.lAo.setContentDescription(charSequence);
        }
        if (oO == null) {
            x.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
        } else if (oO.ckv()) {
            cVar.lAo.a(EmojiInfo.bk(this.vrP.mContext, oO.getName()), oO.getName());
        } else {
            cVar.lAo.a(oO, "");
        }
        return view;
    }
}
