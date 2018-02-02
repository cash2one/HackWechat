package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Parcel;
import android.os.Parcelable.Creator;

class AddShortcutTask$2 implements Creator<AddShortcutTask> {
    AddShortcutTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new AddShortcutTask(parcel, (byte) 0);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new AddShortcutTask[i];
    }
}
