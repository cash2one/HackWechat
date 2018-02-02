package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.view.View;
import android.view.View.OnClickListener;

class AddFriendSearchPreference$1 implements OnClickListener {
    final /* synthetic */ AddFriendSearchPreference rYi;

    AddFriendSearchPreference$1(AddFriendSearchPreference addFriendSearchPreference) {
        this.rYi = addFriendSearchPreference;
    }

    public final void onClick(View view) {
        if (AddFriendSearchPreference.a(this.rYi) != null && AddFriendSearchPreference.b(this.rYi) != null && AddFriendSearchPreference.b(this.rYi).getText() != null) {
            AddFriendSearchPreference.b(this.rYi).getText().toString();
        }
    }
}
