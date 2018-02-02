package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class SelectContactUI$2 implements OnClickListener {
    final /* synthetic */ String yUA;
    final /* synthetic */ SelectContactUI yUy;

    SelectContactUI$2(SelectContactUI selectContactUI, String str) {
        this.yUy = selectContactUI;
        this.yUA = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.SelectContactUI", "return the result,and create new label");
        Intent intent = new Intent();
        intent.putExtra("Select_Contact", this.yUA);
        intent.putExtra("Select_Conv_User", this.yUA);
        intent.putExtra("Select_Contact", this.yUA);
        intent.putExtra("Select_Contacts_To_Create_New_Label", this.yUA);
        this.yUy.setResult(-1, intent);
        this.yUy.finish();
    }
}
