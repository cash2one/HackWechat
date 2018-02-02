package com.tencent.mm.plugin.emoji.ui;

import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aq.a.a.c.a;
import com.tencent.mm.aq.o;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.10;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c;
import com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.List;

class EmojiCustomUI$b extends BaseAdapter {
    final /* synthetic */ EmojiCustomUI lBU;
    private ArrayList<EmojiInfo> lCd;
    private Animation lCe;

    public final /* synthetic */ Object getItem(int i) {
        return oO(i);
    }

    public EmojiCustomUI$b(EmojiCustomUI emojiCustomUI) {
        this.lBU = emojiCustomUI;
        this.lCe = AnimationUtils.loadAnimation(emojiCustomUI, R.a.bqq);
        this.lCe.setInterpolator(new LinearInterpolator());
    }

    public final int getCount() {
        return aCQ() + aCP();
    }

    private int aCP() {
        if (aCQ() <= 0 || (aCQ() + 1) % 5 != 0) {
            return 2;
        }
        return 1;
    }

    public final int aCQ() {
        return this.lCd == null ? 0 : this.lCd.size();
    }

    public final EmojiInfo oO(int i) {
        if (i < aCQ() && this.lCd != null) {
            return (EmojiInfo) this.lCd.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        int aCP;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.lBU.mController.xIM).inflate(R.i.dfC, null);
            view.setVisibility(0);
            d dVar2 = new d(view);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            view.setVisibility(0);
            dVar = (d) view.getTag();
        }
        if (EmojiCustomUI.k(this.lBU) == c.lCi || EmojiCustomUI.k(this.lBU) == c.lCg) {
            aCP = aCP();
        } else {
            aCP = aCP() - 1;
        }
        if (i < getCount() - aCP) {
            if (i % 5 == 0) {
                dVar.lCk.setBackgroundResource(R.g.bBR);
            } else {
                dVar.lCk.setBackgroundResource(R.g.bBU);
            }
        } else if (i == getCount() - aCP) {
            dVar.lCk.setBackgroundResource(R.g.bBT);
        } else {
            dVar.lCk.setBackgroundColor(0);
        }
        dVar.lCl.clearAnimation();
        switch (10.lBY[EmojiCustomUI.k(this.lBU) - 1]) {
            case 1:
                if (i == (getCount() - aCP()) + 1) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                } else if (i == aCQ()) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageResource(R.k.dyv);
                } else {
                    a(dVar.lCl, (EmojiInfo) this.lCd.get(i));
                }
                dVar.lCm.setVisibility(8);
                break;
            case 2:
                if (i != (getCount() - aCP()) + 1) {
                    if (i != aCQ()) {
                        EmojiInfo emojiInfo = (EmojiInfo) this.lCd.get(i);
                        a(dVar.lCl, emojiInfo);
                        if (emojiInfo.field_catalog != EmojiGroupInfo.xAc) {
                            dVar.lCm.setVisibility(0);
                            dVar.lCm.setChecked(EmojiCustomUI.l(this.lBU).contains(emojiInfo.Nr()));
                            break;
                        }
                    }
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                } else {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                }
            case 3:
                if (i == (getCount() - aCP()) + 1) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                } else if (i == aCQ()) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageResource(R.g.bEN);
                    dVar.lCl.startAnimation(this.lCe);
                } else {
                    a(dVar.lCl, (EmojiInfo) this.lCd.get(i));
                }
                dVar.lCm.setVisibility(8);
                break;
            case 4:
                if (i == (getCount() - aCP()) + 1) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                } else if (i == aCQ()) {
                    o.PA().a("", dVar.lCl);
                    dVar.lCl.setImageBitmap(null);
                } else {
                    a(dVar.lCl, (EmojiInfo) this.lCd.get(i));
                }
                dVar.lCm.setVisibility(8);
                break;
        }
        dVar.lCm.setVisibility(8);
        return view;
    }

    public final boolean aCR() {
        ar.Hg();
        if (com.tencent.mm.z.c.isSDCardAvailable()) {
            com.tencent.mm.storage.emotion.d dVar = i.aBE().lwL;
            List arrayList = new ArrayList();
            Cursor a = dVar.gJP.a("select * from EmojiInfo where catalog=? order by reserved3 asc", new String[]{EmojiGroupInfo.xAd}, 2);
            if (a.moveToFirst()) {
                do {
                    com.tencent.mm.plugin.emoji.d.aAl();
                    EmojiInfo emojiInfo = new EmojiInfo(com.tencent.mm.plugin.emoji.d.aAm());
                    emojiInfo.b(a);
                    arrayList.add(emojiInfo);
                } while (a.moveToNext());
            }
            a.close();
            this.lCd = (ArrayList) arrayList;
        } else {
            this.lCd = new ArrayList();
        }
        if (EmojiCustomUI.k(this.lBU) == c.lCg) {
            int size = EmojiCustomUI.l(this.lBU) == null ? 0 : EmojiCustomUI.l(this.lBU).size();
            this.lBU.setMMTitle(this.lBU.getString(R.l.eae, new Object[]{Integer.valueOf(size)}));
        } else {
            this.lBU.setMMTitle(this.lBU.getString(R.l.dZK, new Object[]{Integer.valueOf(this.lCd.size())}));
        }
        return true;
    }

    private void a(ImageView imageView, EmojiInfo emojiInfo) {
        imageView.setImageBitmap(null);
        String ckB = emojiInfo.ckB();
        String str = ckB + "_cover";
        a aVar = new a();
        aVar.hDF = 1;
        aVar.hDM = true;
        aVar.fvC = str;
        aVar.hDC = ckB;
        aVar.hEd = new Object[]{emojiInfo};
        aVar.hEc = true;
        com.tencent.mm.aq.a.a.c PK = aVar.PK();
        o.PA().a(ckB, imageView, PK, null, EmojiCustomUI.m(this.lBU), EmojiCustomUI.n(this.lBU));
    }
}
