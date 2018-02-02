package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public class QueryDownloadInfoTask extends GWMainProcessTask {
    public static Creator<QueryDownloadInfoTask> CREATOR = new Creator<QueryDownloadInfoTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new QueryDownloadInfoTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new QueryDownloadInfoTask[i];
        }
    };
    public long fmZ;
    public ArrayList<FileDownloadTaskInfo> lPm;
    public ArrayList<String> mXo;
    public int type;

    public final void Yr() {
        x.i("MicroMsg.QueryDownloadInfoTask", "QueryDownloadInfoTask");
        switch (this.type) {
            case 1:
                FileDownloadTaskInfo bY = f.aAd().bY(this.fmZ);
                this.lPm = new ArrayList();
                this.lPm.add(bY);
                return;
            case 2:
                if (this.mXo == null || this.mXo.size() == 0) {
                    x.i("MicroMsg.QueryDownloadInfoTask", "appIdList is null");
                    return;
                }
                f.aAd();
                this.lPm = f.n(this.mXo);
                return;
            default:
                return;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeLong(this.fmZ);
        parcel.writeList(this.mXo);
        parcel.writeList(this.lPm);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.fmZ = parcel.readLong();
        this.mXo = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
        this.lPm = parcel.readArrayList(QueryDownloadInfoTask.class.getClassLoader());
    }

    private QueryDownloadInfoTask(Parcel parcel) {
        f(parcel);
    }
}
