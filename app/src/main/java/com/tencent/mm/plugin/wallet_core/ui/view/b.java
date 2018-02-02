package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class b {

    static class a implements com.tencent.mm.platformtools.j.a {
        public TextView sBV = null;
        public TextView sBW = null;
        public TextView sBX = null;
        public ImageView sBZ = null;
        public ImageView sCa = null;
        public TextView sCb = null;
        public TextView sCc = null;
        public TextView sCd = null;
        public ViewGroup sXh = null;
        public e sXi;
        public ViewGroup sXj = null;
        public TextView sXk = null;
        public ImageView sXl = null;

        a() {
        }

        public final void l(String str, Bitmap bitmap) {
            x.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.sXi != null) {
                if (str.equals(this.sXi.oPH)) {
                    this.sCa.post(new 1(this, bitmap));
                }
                if (str.equals(this.sXi.sLv) && this.sBZ != null) {
                    this.sBZ.post(new 2(this, bitmap));
                }
            }
        }
    }

    public static View a(Context context, View view, Bankcard bankcard, int i, com.tencent.mm.plugin.wallet_core.e.a aVar, boolean z) {
        a aVar2;
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            a aVar3 = new a();
            aVar3.sCa = (ImageView) view.findViewById(f.ueZ);
            aVar3.sBW = (TextView) view.findViewById(f.ufa);
            aVar3.sBX = (TextView) view.findViewById(f.ufx);
            aVar3.sBV = (TextView) view.findViewById(f.ufj);
            aVar3.sCb = (TextView) view.findViewById(f.ufi);
            aVar3.sXh = (ViewGroup) view.findViewById(f.uya);
            aVar3.sBZ = (ImageView) view.findViewById(f.ufr);
            aVar3.sCc = (TextView) view.findViewById(f.ufe);
            aVar3.sXj = (ViewGroup) view.findViewById(f.ufg);
            aVar3.sXk = (TextView) view.findViewById(f.ufd);
            aVar3.sXl = (ImageView) view.findViewById(f.ufs);
            view.setTag(aVar3);
            aVar2 = aVar3;
        } else {
            aVar2 = (a) view.getTag();
        }
        if (bankcard.field_bankcardState == 1) {
            aVar2.sCb.setVisibility(0);
        } else {
            aVar2.sCb.setVisibility(8);
        }
        if (aVar2.sXl != null) {
            if (z) {
                aVar2.sXl.setVisibility(0);
            } else {
                aVar2.sXl.setVisibility(8);
            }
        }
        aVar2.sBW.setText(bankcard.field_bankName);
        if (q.Gf()) {
            aVar2.sBX.setVisibility(8);
        } else if (!bh.ov(bankcard.field_bankcardTypeName)) {
            aVar2.sBX.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.bKO()) {
            aVar2.sBX.setText(i.uXT);
        } else if (bankcard.bKR()) {
            aVar2.sBX.setText(i.uRc);
        } else {
            aVar2.sBX.setText(i.uRr);
        }
        if (aVar2.sBV != null) {
            aVar2.sBV.setText(bankcard.field_bankcardTail);
        }
        if (bh.ov(bankcard.field_card_bottom_wording) || aVar2.sXk == null) {
            aVar2.sXj.setVisibility(8);
        } else {
            aVar2.sXk.setText(bankcard.field_card_bottom_wording);
            aVar2.sXj.setVisibility(0);
        }
        aVar.a(context, bankcard, aVar2.sCa, aVar2.sXh, aVar2.sBZ);
        if (aVar2.sCc != null) {
            o.bLq();
            String str = bankcard.field_bindSerial;
            aVar2.sCc.setVisibility(8);
        }
        return view;
    }

    public static Drawable c(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (!NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new BitmapDrawable(bitmap);
            }
            Drawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return ninePatchDrawable;
        } catch (Throwable e) {
            x.f("MicroMsg.BankcardListAdapter", e.getMessage());
            x.printErrStackTrace("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            return null;
        }
    }
}
