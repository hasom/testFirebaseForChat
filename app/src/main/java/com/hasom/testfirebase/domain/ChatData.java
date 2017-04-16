package com.hasom.testfirebase.domain;

import lombok.Data;

/**
 * Created by leejunho on 2017. 4. 16..
 */

@Data
public class ChatData {
    private String userName;
    private String message;

    public ChatData() { }

    public ChatData(String userName, String message) {
        this.userName = userName;
        this.message = message;
    }

}
