package com.company.bean;

public class Message {

    /**
     * MessageID 前台界面控件ID
     */
    private String messageID;
    /**
     * Operator 操作符
     * :T:,:V:,:MT:,:A:,:D:
     */
    private String operator;
    /**
     * Definition 描述信息
     */
    private String definition;
    /**
     * VaildateMessage 校验信息
     */
    private String validateMessage;
    /**
     * Required 是否隐藏默认为Y,当为[:V:]子操作为N
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
