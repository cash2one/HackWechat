package com.tencent.mm.pluginsdk.ui;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.plugin.selectcontact.a$d;

class MultiSelectContactView$3 implements OnFocusChangeListener {
    final /* synthetic */ MultiSelectContactView vkE;

    MultiSelectContactView$3(MultiSelectContactView multiSelectContactView) {
        this.vkE = multiSelectContactView;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            MultiSelectContactView.e(this.vkE).setBackgroundResource(a$d.bDf);
            MultiSelectContactView.e(this.vkE).setPadding(MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE));
        } else {
            MultiSelectContactView.e(this.vkE).setBackgroundResource(a$d.bDg);
            MultiSelectContactView.e(this.vkE).setPadding(MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE), MultiSelectContactView.f(this.vkE));
        }
        if (MultiSelectContactView.g(this.vkE) != null) {
            MultiSelectContactView.g(this.vkE).cam();
        }
    }
}
