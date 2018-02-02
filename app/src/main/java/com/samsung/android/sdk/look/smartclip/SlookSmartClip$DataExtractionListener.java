package com.samsung.android.sdk.look.smartclip;

import android.view.View;

public interface SlookSmartClip$DataExtractionListener {
    public static final int EXTRACTION_DEFAULT = 1;
    public static final int EXTRACTION_DISCARD = 0;

    int onExtractSmartClipData(View view, SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea);
}
