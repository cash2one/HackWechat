package com.tencent.mm.plugin.luckymoney.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wxpay.a.g;
import java.util.List;

class LuckyMoneyMyRecordUI$a extends BaseAdapter {
    int atq;
    List<String> oip;
    final /* synthetic */ LuckyMoneyMyRecordUI oiq;

    LuckyMoneyMyRecordUI$a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        this.oiq = luckyMoneyMyRecordUI;
    }

    public final /* synthetic */ Object getItem(int i) {
        return kC(i);
    }

    public final int getCount() {
        return this.oip.size();
    }

    public final String kC(int i) {
        return (String) this.oip.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.oiq.mController.xIM).inflate(g.uFe, viewGroup, false);
        checkedTextView.setText(kC(i));
        if (i == this.atq) {
            checkedTextView.setChecked(true);
        } else {
            checkedTextView.setChecked(false);
        }
        return checkedTextView;
    }
}
