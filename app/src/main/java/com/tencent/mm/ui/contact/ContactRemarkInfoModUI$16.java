package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bb.c;
import com.tencent.mm.platformtools.t;

class ContactRemarkInfoModUI$16 implements OnClickListener {
    final /* synthetic */ ContactRemarkInfoModUI ySf;

    ContactRemarkInfoModUI$16(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        this.ySf = contactRemarkInfoModUI;
    }

    public final void onClick(View view) {
        if (ContactRemarkInfoModUI.j(this.ySf)) {
            String o;
            ContactRemarkInfoModUI.k(this.ySf);
            Intent intent = new Intent(this.ySf, ContactRemarkImagePreviewUI.class);
            intent.putExtra("Contact_User", ContactRemarkInfoModUI.l(this.ySf));
            if (t.ov(ContactRemarkInfoModUI.m(this.ySf)) || ContactRemarkInfoModUI.n(this.ySf)) {
                o = ContactRemarkInfoModUI.o(this.ySf);
            } else {
                c.QL();
                o = c.lO(ContactRemarkInfoModUI.l(this.ySf));
            }
            intent.putExtra("remark_image_path", o);
            intent.putExtra("view_temp_remark_image", ContactRemarkInfoModUI.n(this.ySf));
            this.ySf.startActivityForResult(intent, 400);
        }
    }
}
