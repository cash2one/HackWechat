package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MMTextInputUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MMTextInputUI zlE;

    MMTextInputUI$3(MMTextInputUI mMTextInputUI) {
        this.zlE = mMTextInputUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.zlE.y(MMTextInputUI.b(this.zlE).getText());
        Intent intent = new Intent();
        intent.putExtra("key_result", MMTextInputUI.b(this.zlE).getText());
        this.zlE.setResult(-1, intent);
        this.zlE.finish();
        return true;
    }
}
