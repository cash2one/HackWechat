package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.view.View;
import android.view.View.OnClickListener;

class TMOpenSDKToMsdkManager$4 implements OnClickListener {
    final /* synthetic */ TMOpenSDKToMsdkManager this$0;

    TMOpenSDKToMsdkManager$4(TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager) {
        this.this$0 = tMOpenSDKToMsdkManager;
    }

    public void onClick(View view) {
        if (this.this$0.mAuthorizedInfo != null) {
            if (this.this$0.mContext != null) {
                this.this$0.getUserAuthorizedInfo(this.this$0.mAuthorizedInfo, this.this$0.mContext);
            }
            this.this$0.dialog.dismiss();
        }
    }
}
