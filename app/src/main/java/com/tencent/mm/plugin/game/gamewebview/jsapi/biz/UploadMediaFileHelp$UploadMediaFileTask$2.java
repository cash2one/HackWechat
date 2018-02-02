package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.UploadMediaFileHelp.UploadMediaFileTask;

class UploadMediaFileHelp$UploadMediaFileTask$2 implements Creator<UploadMediaFileTask> {
    UploadMediaFileHelp$UploadMediaFileTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new UploadMediaFileTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new UploadMediaFileTask[i];
    }
}
