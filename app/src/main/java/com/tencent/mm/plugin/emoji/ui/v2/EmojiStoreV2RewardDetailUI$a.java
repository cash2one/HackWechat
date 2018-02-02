package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.ui.SquareImageView;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.LinkedList;

class EmojiStoreV2RewardDetailUI$a extends BaseAdapter {
    private Bitmap feJ = null;
    int lFb;
    final /* synthetic */ EmojiStoreV2RewardDetailUI lGq;
    private LinkedList<sl> lGr;
    boolean lGs = false;
    private int lui;
    int luj;
    private Context mContext;
    private int mNumColumns = 1;

    public final /* synthetic */ Object getItem(int i) {
        return oR(i);
    }

    public EmojiStoreV2RewardDetailUI$a(EmojiStoreV2RewardDetailUI emojiStoreV2RewardDetailUI, Context context) {
        this.lGq = emojiStoreV2RewardDetailUI;
        this.mContext = context;
        this.lFb = a.aa(emojiStoreV2RewardDetailUI.mController.xIM, R.f.bwZ);
        int eA = a.eA(emojiStoreV2RewardDetailUI.mController.xIM) - (a.aa(emojiStoreV2RewardDetailUI.mController.xIM, R.f.bvv) * 2);
        int i = this.lFb;
        int aa = a.aa(emojiStoreV2RewardDetailUI.mController.xIM, R.f.bvz);
        int i2 = eA / (i + aa);
        if ((eA - (i2 * i)) - (aa * (i2 - 1)) > i) {
            i2++;
        }
        this.mNumColumns = i2;
        this.lui = a.eA(this.mContext);
        this.luj = (int) (((float) (this.lui - (this.mNumColumns * this.lFb))) / (((float) this.mNumColumns) + 1.0f));
        try {
            this.feJ = b.a(this.mContext.getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null));
        } catch (IOException e) {
            x.i("MicroMsg.emoji.EmojiStoreV2RewardDetailUI", "decode stream default avatar failed. %s", new Object[]{bh.cgy()});
        }
    }

    public final void I(LinkedList<sl> linkedList) {
        if (this.lGr == null) {
            this.lGr = new LinkedList();
        }
        if (this.lGs) {
            this.lGr.clear();
            this.lGs = false;
        }
        this.lGr.addAll(linkedList);
        notifyDataSetChanged();
    }

    public final int getCount() {
        int size = this.lGr == null ? 0 : this.lGr.size();
        if (size > 0) {
            return (int) Math.ceil((double) (((float) size) / ((float) this.mNumColumns)));
        }
        return size;
    }

    private sl oR(int i) {
        if (this.lGr != null) {
            if (i < (this.lGr == null ? 0 : this.lGr.size())) {
                return (sl) this.lGr.get(i);
            }
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        EmojiStoreV2RewardDetailUI$b emojiStoreV2RewardDetailUI$b;
        if (view == null || view.getTag() == null) {
            view = new LinearLayout(this.mContext);
            LayoutParams layoutParams = new AbsListView.LayoutParams(-1, -2);
            view.setBackgroundResource(R.g.bHb);
            view.setOrientation(0);
            view.setLayoutParams(layoutParams);
            view.setPadding(0, 0, 0, this.luj);
            emojiStoreV2RewardDetailUI$b = new EmojiStoreV2RewardDetailUI$b(this.lGq);
            emojiStoreV2RewardDetailUI$b.lup = view;
            view.setTag(emojiStoreV2RewardDetailUI$b);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                LayoutParams layoutParams2 = new LinearLayout.LayoutParams(this.lFb, this.lFb);
                layoutParams2.leftMargin = this.luj;
                emojiStoreV2RewardDetailUI$b.lup.addView(new SquareImageView(this.mContext), i2, layoutParams2);
            }
        } else {
            emojiStoreV2RewardDetailUI$b = (EmojiStoreV2RewardDetailUI$b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            SquareImageView squareImageView = (SquareImageView) emojiStoreV2RewardDetailUI$b.lup.getChildAt(i3);
            sl oR = oR((this.mNumColumns * i) + i3);
            if (oR != null) {
                squareImageView.setVisibility(0);
                if (bh.ov(oR.waN)) {
                    squareImageView.setImageBitmap(this.feJ);
                } else {
                    o.PA().a(oR.waN, squareImageView, f.o(EmojiStoreV2RewardDetailUI.c(this.lGq), oR.waN, this.lFb));
                }
            } else {
                squareImageView.setVisibility(8);
            }
        }
        return view;
    }
}
