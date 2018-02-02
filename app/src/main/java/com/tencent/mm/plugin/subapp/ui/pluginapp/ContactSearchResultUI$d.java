package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.m$a$a;
import com.tencent.mm.ag.y;
import com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI.a;
import com.tencent.mm.z.ar;

class ContactSearchResultUI$d implements m$a$a, Runnable {
    public String iconUrl;
    public ImageView iip;
    public TextView kEZ;
    public View kFa;
    public TextView kFb;
    private View kFe;
    a rYs = new 1(this);
    public String username;

    public ContactSearchResultUI$d() {
        y.Mn().a(this);
    }

    public final void asF() {
        if (this.iip != null) {
            ar.Dm().F(this);
        }
    }

    public final void run() {
        Bitmap kg = m.kg(this.username);
        if (kg != null) {
            ContactSearchResultUI.bEh().post(new 2(this, kg));
        } else {
            ContactSearchResultUI.bEh().post(new 3(this));
        }
    }

    public final void ki(String str) {
        if (str != null && str.equals(this.username)) {
            this.rYs.er(this.username, this.iconUrl);
            ar.Dm().g(this.rYs, 200);
        }
    }
}
