package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.ui.FileDownloadConfirmUI;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;

public class SubCoreGameCenter$StartGameProcessTask extends GameProcessActivityTask {
    public static final Creator<SubCoreGameCenter$StartGameProcessTask> CREATOR = new 1();
    public long fmZ;

    public final void a(Context context, a aVar) {
        Intent intent = new Intent(context, FileDownloadConfirmUI.class);
        intent.putExtra("extra_download_id", this.fmZ);
        context.startActivity(intent);
        aVar.afh();
    }

    public final void Ys() {
    }

    public final void f(Parcel parcel) {
        this.fmZ = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.fmZ);
    }

    public SubCoreGameCenter$StartGameProcessTask(Context context) {
        super(context);
    }

    private SubCoreGameCenter$StartGameProcessTask(Parcel parcel) {
        f(parcel);
    }
}
