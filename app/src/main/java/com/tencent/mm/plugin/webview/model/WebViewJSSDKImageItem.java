package com.tencent.mm.plugin.webview.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public class WebViewJSSDKImageItem extends WebViewJSSDKFileItem implements Parcelable {
    public static final Creator<WebViewJSSDKImageItem> CREATOR = new 1();

    public WebViewJSSDKImageItem() {
        this.ftE = 1;
    }

    public final void bQQ() {
        if (new File(this.iLu).exists()) {
            this.jip = ai.Op(System.currentTimeMillis());
            Bitmap a = d.a(this.iLu, 640, 640, false, null, 0);
            if (a != null) {
                x.i("MicroMsg.WebViewJSSDkImageItem", "extract thumbnail bitmap");
                a = d.b(a, (float) ExifHelper.UJ(this.iLu));
                if (a != null) {
                    try {
                        d.a(a, 100, CompressFormat.JPEG, this.jip, true);
                    } catch (Exception e) {
                        x.e("MicroMsg.WebViewJSSDkImageItem", "save bitmap to file failed : %s", new Object[]{e.getMessage()});
                    }
                }
            }
            x.i("MicroMsg.WebViewJSSDkImageItem", "Thumb Path: %s", new Object[]{this.jip});
            return;
        }
        x.i("MicroMsg.WebViewJSSDkImageItem", "Original file not existed");
    }

    public final WebViewJSSDKFileItem bQM() {
        this.fus = ai.Or(this.iLu);
        bQQ();
        return this;
    }

    public final String bQN() {
        return "jpeg";
    }

    public final String bQO() {
        return SlookAirButtonRecentMediaAdapter.IMAGE_TYPE;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    protected WebViewJSSDKImageItem(Parcel parcel) {
        super(parcel);
    }
}
