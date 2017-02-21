package com.gaobin.weixin.model
/**
 * Created with IntelliJ IDEA.
 * User: gaobin
 * Date: 2017/2/21
 * Time: 16:31
 * To change this template use File | Settings | File Templates.
 * Description: 
 */
class Button {
    private String type;
    private String name;
    private Button[] sub_button;

    String getType() {
        return type
    }

    void setType(String type) {
        this.type = type
    }

    String getName() {
        return name
    }

    void setName(String name) {
        this.name = name
    }

    Button[] getSub_button() {
        return sub_button
    }

    void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button
    }
}
