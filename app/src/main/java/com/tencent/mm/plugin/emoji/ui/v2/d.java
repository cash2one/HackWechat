package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.aq.o;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.v;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private boolean lIr;
    private LayoutParams lIs;
    private LayoutParams lIt;
    a lIu;
    List<rw> ltR;
    private int luh;
    private int lui;
    private int luj;
    private Context mContext;
    private int mNumColumns;

    public final /* synthetic */ Object getItem(int i) {
        return oZ(i);
    }

    public d(Context context) {
        this.mNumColumns = 3;
        this.lIr = true;
        this.mNumColumns = 3;
        this.mContext = context;
        this.lui = a.eA(this.mContext);
        this.luh = this.mContext.getResources().getDimensionPixelSize(R.f.bxa);
        this.luj = (int) (((float) (this.lui - (this.mNumColumns * this.luh))) / (((float) this.mNumColumns) + 1.0f));
    }

    public final void aD(List<rw> list) {
        if (this.ltR == null) {
            this.ltR = new ArrayList();
        } else {
            this.ltR.clear();
        }
        this.ltR = list;
        notifyDataSetChanged();
    }

    private int aCQ() {
        return this.ltR == null ? 0 : this.ltR.size();
    }

    public final int getCount() {
        return this.ltR == null ? 0 : (int) Math.ceil((double) (((float) this.ltR.size()) / ((float) this.mNumColumns)));
    }

    public final rw oZ(int i) {
        if (i < 0 || i >= aCQ() || this.ltR == null) {
            return null;
        }
        return (rw) this.ltR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = v.fv(this.mContext).inflate(R.i.dgc, null);
            bVar = new b(this);
            bVar.lup = (LinearLayout) view.findViewById(R.h.crr);
            bVar.lup.setPadding(0, this.luj, 0, 0);
            view.setTag(bVar);
            for (int i2 = 0; i2 < this.mNumColumns; i2++) {
                this.lIt = new LayoutParams(-2, -2);
                this.lIt.leftMargin = this.luj;
                this.lIs = new LayoutParams(this.luh, this.luh);
                View paddingImageView = new PaddingImageView(this.mContext);
                ViewGroup.LayoutParams layoutParams = this.lIs;
                paddingImageView.addView(paddingImageView.lIo, layoutParams);
                paddingImageView.addView(paddingImageView.lIp, layoutParams);
                bVar.lup.addView(paddingImageView, i2, this.lIt);
            }
        } else {
            bVar = (b) view.getTag();
        }
        for (int i3 = 0; i3 < this.mNumColumns; i3++) {
            int i4 = (this.mNumColumns * i) + i3;
            PaddingImageView paddingImageView2 = (PaddingImageView) bVar.lup.getChildAt(i3);
            if (i4 <= aCQ() - 1) {
                rw oZ = oZ(i4);
                if (oZ != null) {
                    String stringBuilder;
                    com.tencent.mm.aq.a.a PA;
                    String str;
                    ImageView imageView;
                    String str2;
                    if (!bh.ov(oZ.pbP)) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        ar.Hg();
                        stringBuilder = stringBuilder2.append(EmojiLogic.H(c.Fp(), "", oZ.vZL)).append("_cover").toString();
                        PA = o.PA();
                        str = oZ.pbP;
                        imageView = paddingImageView2.lIo;
                        str2 = oZ.pbP;
                        PA.a(str, imageView, f.a(stringBuilder, this.luh, new Object[0]));
                    } else if (bh.ov(oZ.nfX)) {
                        x.w("MicroMsg.emoji.PreViewListGridAdapter", "this emoji has no thumb url and url. download faild");
                    } else {
                        ar.Hg();
                        stringBuilder = EmojiLogic.H(c.Fp(), "", oZ.vZL);
                        PA = i.aBe();
                        str = oZ.nfX;
                        imageView = paddingImageView2.lIo;
                        str2 = oZ.nfX;
                        PA.a(str, imageView, f.a(stringBuilder, this.luh, new Object[0]));
                    }
                    paddingImageView2.setClickable(true);
                    paddingImageView2.lIp.setBackgroundResource(R.g.bBV);
                    paddingImageView2.setOnClickListener(new 1(this, paddingImageView2, i4));
                } else {
                    paddingImageView2.lIp.setBackgroundDrawable(null);
                    o.PA().a("", paddingImageView2.lIo);
                    x.w("MicroMsg.emoji.PreViewListGridAdapter", "item is null");
                    paddingImageView2.setClickable(false);
                    paddingImageView2.setOnClickListener(null);
                }
            } else {
                paddingImageView2.lIp.setBackgroundDrawable(null);
                o.PA().a("", paddingImageView2.lIo);
                paddingImageView2.setClickable(false);
                paddingImageView2.setOnClickListener(null);
            }
        }
        return view;
    }
}
