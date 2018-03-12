package com.company.bean;

public class Message {

    /**
     * MessageID ǰ̨����ؼ�ID
     */
    private String messageID;
    /**
     * Operator ������
     * :T:,:V:,:MT:,:A:,:D:
     */
    private String operator;
    /**
     * Definition ������Ϣ
     */
    private String definition;
    /**
     * VaildateMessage У����Ϣ
     */
    private String validateMessage;
    /**
     * Required �Ƿ�����Ĭ��ΪY,��Ϊ[:V:]�Ӳ���ΪN
     */
    private String required;
    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getValidateMessage() {
        return validateMessage;
    }

    public void setValidateMessage(String validateMessage) {
        this.validateMessage = validateMessage;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    @Override
    public String toString() {
        return "Message [messageID=" + messageID + ", operator=" + operator + ", definition=" + definition + ", validateMessage=" + validateMessage + ", required=" + required + "]";
    }


}
