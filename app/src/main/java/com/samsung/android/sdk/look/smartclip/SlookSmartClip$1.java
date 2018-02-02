package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.smartclip.SmartClipDataExtractionListener;

class SlookSmartClip$1 implements SmartClipDataExtractionListener {
    final /* synthetic */ SlookSmartClip this$0;

    SlookSmartClip$1(SlookSmartClip slookSmartClip) {
        this.this$0 = slookSmartClip;
    }

    public int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
        return SlookSmartClip.access$000(this.this$0).onExtractSmartClipData(view, slookSmartClipDataElement, slookSmartClipCroppedArea);
    }
}
