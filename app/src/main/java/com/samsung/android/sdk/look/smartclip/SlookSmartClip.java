package com.samsung.android.sdk.look.smartclip;

import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.smartclip.SmartClipMetaUtils;

public final class SlookSmartClip {
    private static final String TAG = "SmartClip";
    private DataExtractionListener mDataExtractionListener = null;
    private Slook mSlook = new Slook();
    private View mView = null;

    public SlookSmartClip(View view) {
        this.mView = view;
    }

    public final void addMetaTag(SlookSmartClipMetaTag slookSmartClipMetaTag) {
        if (isSupport(1)) {
            SmartClipMetaUtils.addMetaTag(this.mView, slookSmartClipMetaTag);
        }
    }

    public final void removeMetaTag(String str) {
        if (isSupport(1)) {
            SmartClipMetaUtils.removeMetaTag(this.mView, str);
        }
    }

    public final void clearAllMetaTag() {
        if (isSupport(1)) {
            SmartClipMetaUtils.clearAllMetaTag(this.mView);
        }
    }

    public final void setDataExtractionListener(DataExtractionListener dataExtractionListener) {
        if (isSupport(1)) {
            this.mDataExtractionListener = dataExtractionListener;
            SmartClipMetaUtils.setDataExtractionListener(this.mView, new 1(this));
        }
    }

    public final int extractDefaultSmartClipData(SlookSmartClipDataElement slookSmartClipDataElement, SlookSmartClipCroppedArea slookSmartClipCroppedArea) {
        if (isSupport(1)) {
            return SmartClipMetaUtils.extractDefaultSmartClipData(this.mView, slookSmartClipDataElement, slookSmartClipCroppedArea);
        }
        return 0;
    }

    private boolean isSupport(int i) {
        if (this.mSlook.isFeatureEnabled(2)) {
            return true;
        }
        return false;
    }
}
