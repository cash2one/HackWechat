package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class RangeWidget$1 implements OnClickListener {
    final /* synthetic */ RangeWidget rwx;

    RangeWidget$1(RangeWidget rangeWidget) {
        this.rwx = rangeWidget;
    }

    public final void onClick(View view) {
        Intent intent = new Intent(RangeWidget.a(this.rwx), SnsLabelUI.class);
        intent.putExtra("KLabel_range_index", RangeWidget.b(this.rwx));
        intent.putExtra("Klabel_name_list", RangeWidget.c(this.rwx));
        intent.putExtra("Kother_user_name_list", RangeWidget.d(this.rwx));
        intent.putExtra("k_sns_label_ui_style", this.rwx.style);
        RangeWidget.a(this.rwx).startActivityForResult(intent, 5);
    }
}
