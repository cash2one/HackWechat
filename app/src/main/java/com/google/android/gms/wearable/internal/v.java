package com.google.android.gms.wearable.internal;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface v extends IInterface {
    void a(AddLocalCapabilityResponse addLocalCapabilityResponse);

    void a(ChannelReceiveFileResponse channelReceiveFileResponse);

    void a(ChannelSendFileResponse channelSendFileResponse);

    void a(CloseChannelResponse closeChannelResponse);

    void a(DeleteDataItemsResponse deleteDataItemsResponse);

    void a(GetAllCapabilitiesResponse getAllCapabilitiesResponse);

    void a(GetCapabilityResponse getCapabilityResponse);

    void a(GetChannelInputStreamResponse getChannelInputStreamResponse);

    void a(GetChannelOutputStreamResponse getChannelOutputStreamResponse);

    void a(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse);

    void a(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse);

    void a(GetCloudSyncSettingResponse getCloudSyncSettingResponse);

    void a(GetConfigResponse getConfigResponse);

    void a(GetConfigsResponse getConfigsResponse);

    void a(GetConnectedNodesResponse getConnectedNodesResponse);

    void a(GetDataItemResponse getDataItemResponse);

    void a(GetFdForAssetResponse getFdForAssetResponse);

    void a(GetLocalNodeResponse getLocalNodeResponse);

    void a(OpenChannelResponse openChannelResponse);

    void a(PutDataResponse putDataResponse);

    void a(RemoveLocalCapabilityResponse removeLocalCapabilityResponse);

    void a(SendMessageResponse sendMessageResponse);

    void a(StorageInfoResponse storageInfoResponse);

    void b(DataHolder dataHolder);

    void b(CloseChannelResponse closeChannelResponse);

    void f(Status status);
}
