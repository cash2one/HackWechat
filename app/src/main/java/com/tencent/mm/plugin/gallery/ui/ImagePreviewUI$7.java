package com.tencent.mm.plugin.gallery.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView$g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ac;

class ImagePreviewUI$7 extends RecyclerView$g {
    final /* synthetic */ ImagePreviewUI mUl;

    ImagePreviewUI$7(ImagePreviewUI imagePreviewUI) {
        this.mUl = imagePreviewUI;
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        int dimension = (int) ac.getContext().getResources().getDimension(R.f.bvv);
        rect.left = dimension / 2;
        rect.bottom = dimension;
        rect.top = dimension;
        rect.right = dimension / 2;
    }
}
