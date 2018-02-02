package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.o;

public class c extends o<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private com.tencent.mm.plugin.card.base.c kOB;
    private int kQi;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (CardInfo) obj;
        if (obj == null) {
            obj = new CardInfo();
        }
        if (cursor.isClosed()) {
            x.e("MicroMsg.CardAdapter", "cursor is closed!");
        } else {
            obj.b(cursor);
        }
        return obj;
    }

    public c(Context context, int i) {
        super(context, new CardInfo());
        this.kQi = i;
        lU(true);
        this.kOB = new l(context, this);
    }

    public void Xy() {
        x.v("MicroMsg.CardAdapter", "resetCursor");
        Cursor nH = am.auA().nH(this.kQi);
        if (nH != null) {
            this.count = nH.getCount();
            x.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(nH);
        notifyDataSetChanged();
    }

    protected void Xz() {
        aUn();
        Xy();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return this.kOB.a(i, view, (CardInfo) getItem(i));
    }

    public void release() {
        aUn();
        this.kOB.release();
        this.kOB = null;
    }
}
