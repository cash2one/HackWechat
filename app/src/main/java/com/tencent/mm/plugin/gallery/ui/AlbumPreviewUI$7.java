package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.c;

class AlbumPreviewUI$7 implements a$a {
    final /* synthetic */ AlbumPreviewUI mSQ;
    private OnClickListener mtg = new 1(this);

    AlbumPreviewUI$7(AlbumPreviewUI albumPreviewUI) {
        this.mSQ = albumPreviewUI;
    }

    public final View getView() {
        View inflate = View.inflate(this.mSQ.mController.xIM, R.i.dcL, null);
        inflate.setOnClickListener(this.mtg);
        TextView textView = (TextView) inflate.findViewById(R.h.cvF);
        if (c.aNE().aOi() == 2 || c.aNE().aOh() == 13) {
            textView.setText(R.l.elK);
        } else if (c.aNE().aOi() == 1) {
            textView.setText(R.l.elJ);
        }
        inflate.setLayerType(1, null);
        return inflate;
    }
}
