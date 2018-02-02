package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.traceroute.a.a;

class NetworkDiagnoseIntroUI$2 implements OnClickListener {
    final /* synthetic */ NetworkDiagnoseIntroUI sfB;

    NetworkDiagnoseIntroUI$2(NetworkDiagnoseIntroUI networkDiagnoseIntroUI) {
        this.sfB = networkDiagnoseIntroUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("title", this.sfB.getString(R.l.eAY));
        intent.putExtra("rawUrl", this.sfB.getString(R.l.eSl));
        intent.putExtra("showShare", false);
        a.ifs.j(intent, this.sfB.mController.xIM);
    }
}
