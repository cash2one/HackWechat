package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bb.c;

class ContactRemarkInfoViewUI$1 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoViewUI ySk;

    ContactRemarkInfoViewUI$1(ContactRemarkInfoViewUI contactRemarkInfoViewUI) {
        this.ySk = contactRemarkInfoViewUI;
    }

    public final void onClick(View view) {
        if (ContactRemarkInfoViewUI.a(this.ySk)) {
            Intent intent = new Intent(this.ySk, ContactRemarkImagePreviewUI.class);
            intent.putExtra("Contact_User", ContactRemarkInfoViewUI.b(this.ySk));
            c.QL();
            intent.putExtra("remark_image_path", c.lO(ContactRemarkInfoViewUI.b(this.ySk)));
            intent.putExtra("view_only", true);
            this.ySk.startActivity(intent);
        }
    }
}
