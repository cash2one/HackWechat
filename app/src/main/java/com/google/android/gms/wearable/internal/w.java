package com.google.android.gms.wearable.internal;

import android.os.IInterface;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

public interface w extends IInterface {
    void a(DataHolder dataHolder);

    void a(AmsEntityUpdateParcelable amsEntityUpdateParcelable);

    void a(AncsNotificationParcelable ancsNotificationParcelable);

    void a(CapabilityInfoParcelable capabilityInfoParcelable);

    void a(ChannelEventParcelable channelEventParcelable);

    void a(MessageEventParcelable messageEventParcelable);

    void a(NodeParcelable nodeParcelable);

    void b(NodeParcelable nodeParcelable);

    void u(List<NodeParcelable> list);
}
