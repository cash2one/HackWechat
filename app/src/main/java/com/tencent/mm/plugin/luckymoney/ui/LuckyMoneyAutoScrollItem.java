package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.widget.ListView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> ofU;
    private int jSo;
    private Context mContext;
    private a ofO;
    private long ofP;
    int ofQ;
    private CountDownTimer ofR;
    private int ofS;
    b ofT;

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.jSo + 1;
        luckyMoneyAutoScrollItem.jSo = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        ofU = sparseArray;
        sparseArray.put(0, Integer.valueOf(e.udi));
        ofU.put(1, Integer.valueOf(e.udj));
        ofU.put(2, Integer.valueOf(e.udk));
        ofU.put(3, Integer.valueOf(e.udl));
        ofU.put(4, Integer.valueOf(e.udm));
        ofU.put(5, Integer.valueOf(e.udn));
        ofU.put(6, Integer.valueOf(e.udo));
        ofU.put(7, Integer.valueOf(e.udp));
        ofU.put(8, Integer.valueOf(e.udq));
        ofU.put(9, Integer.valueOf(e.udr));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.ofO = null;
        this.ofP = 900;
        this.ofQ = 0;
        this.jSo = 0;
        this.ofT = null;
        this.mContext = context;
        this.ofO = new a(this, (byte) 0);
        setAdapter(this.ofO);
        this.ofS = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        x.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[]{Integer.valueOf(this.ofS)});
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void aXv() {
        if (this.ofR != null) {
            this.ofR.cancel();
        }
        ag.y(new 1(this, ((long) (this.ofQ * 50)) + this.ofP));
    }
}
