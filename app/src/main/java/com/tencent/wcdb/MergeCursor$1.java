package com.tencent.wcdb;

import android.database.DataSetObserver;

class MergeCursor$1 extends DataSetObserver {
    final /* synthetic */ MergeCursor this$0;

    MergeCursor$1(MergeCursor mergeCursor) {
        this.this$0 = mergeCursor;
    }

    public void onChanged() {
        this.this$0.mPos = -1;
    }

    public void onInvalidated() {
        this.this$0.mPos = -1;
    }
}
