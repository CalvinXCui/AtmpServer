package cn.wildfirechat.sdk;

import cn.wildfirechat.common.APIPath;
import cn.wildfirechat.pojos.*;
import cn.wildfirechat.sdk.model.IMResult;
import cn.wildfirechat.sdk.utilities.AdminHttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class MessageAdmin {

    private static final Logger LOG = LoggerFactory.getLogger(MessageAdmin.class);

    public static IMResult<SendMessageResult> sendMessage(String sender, Conversation conversation, MessagePayload payload) throws Exception {
        LOG.info("sendMessage");
        String path = APIPath.Msg_Send;
        SendMessageData messageData = new SendMessageData();
        messageData.setSender(sender);
        messageData.setConv(conversation);
        messageData.setPayload(payload);
        System.out.println("sendMessage+messageData==============="+messageData);
        return AdminHttpUtils.httpJsonPost(path, messageData, SendMessageResult.class);
    }

    public static IMResult<Void> recallMessage(String operator, long messageUid) throws Exception {
        LOG.info("recallMessage");
        String path = APIPath.Msg_Recall;
        RecallMessageData messageData = new RecallMessageData();
        messageData.setOperator(operator);
        messageData.setMessageUid(messageUid);
        System.out.println("recallMessage+messageData==============="+messageData);
        return AdminHttpUtils.httpJsonPost(path, messageData, Void.class);
    }

    public static IMResult<Void> deleteMessage(long messageUid) throws Exception {
        LOG.info("deleteMessage");
        String path = APIPath.Msg_Delete;
        DeleteMessageData deleteMessageData = new DeleteMessageData();
        deleteMessageData.setMessageUid(messageUid);
        System.out.println("deleteMessageData+deleteMessageData==============="+deleteMessageData);
        return AdminHttpUtils.httpJsonPost(path, deleteMessageData, Void.class);
    }



    /**
     * 撤回群发或者广播的消息
     * @param target 目标用户
     * @param messageUid 消息唯一ID
     * @return
     * @throws Exception
     */
    public static IMResult<Void> recallBroadcastOrMulticastMessage(String target, long messageUid) throws Exception {
        LOG.info("recallBroadcastOrMulticastMessage");
        String path = APIPath.Msg_Recall;
        RecallMessageData messageData = new RecallMessageData();
        messageData.setOperator(target);
        messageData.setMessageUid(messageUid);
        return AdminHttpUtils.httpJsonPost(path, messageData, Void.class);
    }

    public static IMResult<BroadMessageResult> broadcastMessage(String sender, int line, MessagePayload payload) throws Exception {
        LOG.info("broadcastMessage");
        String path = APIPath.Msg_Broadcast;
        BroadMessageData messageData = new BroadMessageData();
        messageData.setSender(sender);
        messageData.setLine(line);
        messageData.setPayload(payload);
        return AdminHttpUtils.httpJsonPost(path, messageData, BroadMessageResult.class);
    }

    public static IMResult<MultiMessageResult> multicastMessage(String sender, List<String> receivers, int line, MessagePayload payload) throws Exception {
        LOG.info("multicastMessage");
        String path = APIPath.Msg_Multicast;
        MulticastMessageData messageData = new MulticastMessageData();
        messageData.setSender(sender);
        messageData.setTargets(receivers);
        messageData.setLine(line);
        messageData.setPayload(payload);
        return AdminHttpUtils.httpJsonPost(path, messageData, MultiMessageResult.class);
    }
}
