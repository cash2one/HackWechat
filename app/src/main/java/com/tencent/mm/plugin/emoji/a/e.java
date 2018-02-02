package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.List;

public final class e extends ArrayAdapter<EmojiGroupInfo> {
    private static final int ltP = R.i.dfI;
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int ltQ;
    public List<EmojiGroupInfo> ltR;
    private Context mContext;

    class a {
        TextView iiq;
        ImageView jCP;
        View ltS;
        ImageView ltT;
        final /* synthetic */ e ltU;

        public a(e eVar, View view) {
            this.ltU = eVar;
            this.ltT = (ImageView) view.findViewById(R.h.cdS);
            this.jCP = (ImageView) view.findViewById(R.h.cdQ);
            this.iiq = (TextView) view.findViewById(R.h.cdR);
            this.ltS = view.findViewById(R.h.cdC);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = eVar.ltQ;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public e(Context context, List<EmojiGroupInfo> list) {
        super(context, ltP, list);
        this.ltQ = context.getResources().getDimensionPixelSize(R.f.bxb);
        this.mContext = context;
        this.ltR = list;
    }

    public final void aAH() {
        if (this.ltR != null) {
            int size = this.ltR.size();
            for (int i = 0; i < size; i++) {
                ((EmojiGroupInfo) this.ltR.get(i)).field_idx = i;
            }
            i.aBE().lwM.cT(this.ltR);
            c bf = i.aBE().lwM.bf(EmojiGroupInfo.xAc, false);
            bf.field_sort = this.ltR.size() + 2;
            com.tencent.mm.storage.emotion.a aVar = i.aBE().lwM;
            if (!com.tencent.mm.storage.emotion.a.ckh()) {
                aVar = i.aBE().lwM;
                if (bf != null) {
                    x.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", bf.field_packName, Long.valueOf(bf.field_lastUseTime), Integer.valueOf(bf.field_sort));
                    aVar.a(bf);
                    aVar.b("event_update_group", 0, bh.cgy().toString());
                }
            }
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(ltP, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.iiq.setText(R.l.ebe);
        } else {
            aVar.iiq.setText(emojiGroupInfo.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(emojiGroupInfo)) {
            aVar.jCP.setImageResource(R.g.bCY);
        } else {
            o.PA().a(emojiGroupInfo.field_packIconUrl, aVar.jCP, f.cg(emojiGroupInfo.field_productID, emojiGroupInfo.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.ltS.setBackgroundResource(R.g.bBy);
        }
        view.setVisibility(0);
        return view;
    }
}
