package android.support.v4.widget;

import android.database.ContentObserver;

class e$a extends ContentObserver {
    final /* synthetic */ e BG;

    public final boolean deliverSelfNotifications() {
        return true;
    }

    public final void onChange(boolean z) {
        this.BG.onContentChanged();
    }
}
