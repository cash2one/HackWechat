package com.tencent.mm.plugin.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.ui.MMWizardActivity;

public final class a {
    public static void a(Activity activity, String str, boolean z) {
        if (z) {
            Intent intent = new Intent(activity, RoomUpgradeUI.class);
            intent.setFlags(603979776);
            intent.putExtra("room_name", str);
            Intent intent2 = new Intent();
            intent2.setClassName(activity, "com.tencent.mm.ui.account.bind.BindMobileUI");
            intent2.putExtra("is_bind_for_chatroom_upgrade", true);
            MMWizardActivity.b(activity, intent2, intent);
            return;
        }
        intent = new Intent(activity, RoomUpgradeUI.class);
        intent.setFlags(603979776);
        intent.putExtra("room_name", str);
        intent.putExtra("announce_ok", true);
        activity.startActivity(intent);
    }
}
