package com.tencent.mm.plugin.exdevice.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.z.q;

class ExdeviceProfileAffectedUserView$2 implements OnClickListener {
    final /* synthetic */ ExdeviceProfileAffectedUserView lVr;

    ExdeviceProfileAffectedUserView$2(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
        this.lVr = exdeviceProfileAffectedUserView;
    }

    public final void onClick(View view) {
        String FS = q.FS();
        if (FS != null && FS.equals(ExdeviceProfileAffectedUserView.a(this.lVr))) {
            ExdeviceProfileAffectedUserView.b(this.lVr).setVisibility(ExdeviceProfileAffectedUserView.b(this.lVr).getVisibility() == 0 ? 8 : 0);
        }
    }
}
