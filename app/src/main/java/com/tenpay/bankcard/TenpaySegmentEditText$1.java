package com.tenpay.bankcard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class TenpaySegmentEditText$1 implements OnClickListener {
    final /* synthetic */ TenpaySegmentEditText this$0;
    final /* synthetic */ EditText val$edit;

    TenpaySegmentEditText$1(TenpaySegmentEditText tenpaySegmentEditText, EditText editText) {
        this.this$0 = tenpaySegmentEditText;
        this.val$edit = editText;
    }

    public void onClick(View view) {
        if (TenpaySegmentEditText.access$000(this.this$0) != null) {
            TenpaySegmentEditText.access$000(this.this$0).onClick(view);
        }
        if (TenpaySegmentEditText.access$100(this.this$0)) {
            this.this$0.setFocusable(true);
            this.val$edit.requestFocus();
            TenpaySegmentEditText.access$102(this.this$0, false);
        }
    }
}
