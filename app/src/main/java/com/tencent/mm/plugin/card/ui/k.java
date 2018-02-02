package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.ui.view.aa;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class k extends c {
    private final String TAG = "MicroMsg.CardTicketAdapter";
    private int count = 0;
    private c kOB;
    private int kQi;
    private ArrayList<CardInfo> kVA;
    private final String kVw = "PRIVATE_TICKET_TITLE";
    private final String kVx = "PRIVATE_INVOICE_TITLE";
    private ArrayList<CardInfo> kVy;
    private ArrayList<CardInfo> kVz;

    public final /* synthetic */ Object getItem(int i) {
        return nP(i);
    }

    public k(Context context, int i) {
        super(context, i);
        this.kQi = i;
        this.kOB = new aa(context, this);
        this.kVy = new ArrayList();
        this.kVz = new ArrayList();
        this.kVA = new ArrayList();
    }

    private void awn() {
        this.kVy.clear();
        this.kVz.clear();
        this.kVA.clear();
        for (int i = 0; i < this.count; i++) {
            CardInfo cardInfo = (CardInfo) super.getItem(i);
            if (cardInfo != null) {
                if (cardInfo.atm()) {
                    this.kVA.add(cardInfo);
                } else {
                    this.kVz.add(cardInfo);
                }
            }
        }
        if (!this.kVz.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_TICKET_TITLE";
            this.kVy.add(cardInfo);
            this.kVy.addAll(this.kVz);
        }
        if (!this.kVA.isEmpty()) {
            cardInfo = new CardInfo();
            cardInfo.field_card_id = "PRIVATE_INVOICE_TITLE";
            this.kVy.add(cardInfo);
            this.kVy.addAll(this.kVA);
        }
        this.count = this.kVy.size();
    }

    public final void Xy() {
        x.v("MicroMsg.CardTicketAdapter", "resetCursor");
        Cursor nH = am.auA().nH(this.kQi);
        if (nH != null) {
            this.count = nH.getCount();
            x.v("MicroMsg.CardTicketAdapter", "card count:" + this.count);
        }
        setCursor(nH);
        awn();
        notifyDataSetChanged();
    }

    protected final void Xz() {
        aUn();
        Xy();
    }

    private CardInfo nP(int i) {
        return (CardInfo) this.kVy.get(i);
    }

    public final int getItemViewType(int i) {
        CardInfo nP = nP(i);
        if (nP.field_card_id.equals("PRIVATE_TICKET_TITLE") || nP.field_card_id.equals("PRIVATE_INVOICE_TITLE")) {
            return 0;
        }
        if (nP.atm()) {
            return 2;
        }
        return 1;
    }

    public final int getCount() {
        if (this.kVy.isEmpty()) {
            return super.getCount();
        }
        return this.kVy.size();
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kOB.a(i, view, nP(i));
    }

    public final void release() {
        aUn();
        this.kOB.release();
        this.kOB = null;
    }
}
