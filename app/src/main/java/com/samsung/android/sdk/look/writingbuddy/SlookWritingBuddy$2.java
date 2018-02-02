package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnImageWritingListener;

class SlookWritingBuddy$2 implements OnImageWritingListener {
    final /* synthetic */ SlookWritingBuddy this$0;

    SlookWritingBuddy$2(SlookWritingBuddy slookWritingBuddy) {
        this.this$0 = slookWritingBuddy;
    }

    public void onImageReceived(Bitmap bitmap) {
        SlookWritingBuddy.access$100(this.this$0).onImageReceived(bitmap);
    }
}
