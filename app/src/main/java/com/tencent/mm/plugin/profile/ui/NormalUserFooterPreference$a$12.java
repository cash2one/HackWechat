package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.profile.ui.NormalUserFooterPreference.a;

class NormalUserFooterPreference$a$12 implements OnClickListener {
    final /* synthetic */ a pkC;

    NormalUserFooterPreference$a$12(a aVar) {
        this.pkC = aVar;
    }

    public final void onClick(View view) {
        a aVar;
        if (NormalUserFooterPreference.e(this.pkC.pkA)) {
            aVar = this.pkC;
            String str = NormalUserFooterPreference.a(aVar.pkA).field_username;
            Intent intent = new Intent();
            intent.addFlags(67108864);
            if (NormalUserFooterPreference.n(aVar.pkA)) {
                intent.putExtra("Chat_User", str);
                intent.putExtra("Chat_Mode", 1);
                ((Activity) aVar.pkA.mContext).setResult(-1, intent);
                return;
            }
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            com.tencent.mm.plugin.profile.a.ifs.e(intent, aVar.pkA.mContext);
            return;
        }
        aVar = this.pkC;
        Intent intent2 = new Intent();
        intent2.addFlags(67108864);
        if (NormalUserFooterPreference.n(aVar.pkA)) {
            intent2.putExtra("Chat_User", NormalUserFooterPreference.a(aVar.pkA).field_username);
            intent2.putExtra("Chat_Mode", 1);
            ((Activity) aVar.pkA.mContext).setResult(-1, intent2);
            return;
        }
        intent2.putExtra("Chat_User", NormalUserFooterPreference.a(aVar.pkA).field_username);
        intent2.putExtra("Chat_Mode", 1);
        com.tencent.mm.plugin.profile.a.ifs.e(intent2, aVar.pkA.mContext);
    }
}
