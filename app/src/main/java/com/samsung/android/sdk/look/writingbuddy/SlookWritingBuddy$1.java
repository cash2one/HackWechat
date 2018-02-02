package com.samsung.android.sdk.look.writingbuddy;

import com.samsung.android.writingbuddy.WritingBuddyImpl.OnTextWritingListener;

class SlookWritingBuddy$1 implements OnTextWritingListener {
    final /* synthetic */ SlookWritingBuddy this$0;

    SlookWritingBuddy$1(SlookWritingBuddy slookWritingBuddy) {
        this.this$0 = slookWritingBuddy;
    }

    public void onTextReceived(CharSequence charSequence) {
        SlookWritingBuddy.access$000(this.this$0).onTextReceived(charSequence);
    }
}
