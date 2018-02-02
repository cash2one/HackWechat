package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Bitmap;

class CategoryWithTitlePreference$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ CategoryWithTitlePreference pUX;

    CategoryWithTitlePreference$1(CategoryWithTitlePreference categoryWithTitlePreference, Bitmap bitmap) {
        this.pUX = categoryWithTitlePreference;
        this.jsN = bitmap;
    }

    public final void run() {
        CategoryWithTitlePreference.a(this.pUX).setImageBitmap(this.jsN);
        CategoryWithTitlePreference.a(this.pUX).setVisibility(0);
        if (CategoryWithTitlePreference.b(this.pUX) != null) {
            CategoryWithTitlePreference.b(this.pUX).notifyDataSetChanged();
        }
    }
}
