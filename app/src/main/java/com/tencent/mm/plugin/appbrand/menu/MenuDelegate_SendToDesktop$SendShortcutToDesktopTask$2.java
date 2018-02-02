package com.tencent.mm.plugin.appbrand.menu;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.menu.MenuDelegate_SendToDesktop.SendShortcutToDesktopTask;

class MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$2 implements Creator<SendShortcutToDesktopTask> {
    MenuDelegate_SendToDesktop$SendShortcutToDesktopTask$2() {
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        return new SendShortcutToDesktopTask(parcel);
    }

    public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
        return new SendShortcutToDesktopTask[i];
    }
}
