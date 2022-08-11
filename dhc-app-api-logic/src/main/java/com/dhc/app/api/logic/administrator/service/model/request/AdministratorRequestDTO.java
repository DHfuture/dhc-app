package com.dhc.app.api.logic.administrator.service.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

public class AdministratorRequestDTO {

    @Getter
    @Setter
    class Common {
        /**
         * 登陆名
         */
        @Size(min = 5, max = 30, message = "登录名长度5-30")
        private String longinName;

        /**
         * 密码
         */
        @Size(min = 7, max = 30, message = "密码长度7-30")
        private String password;

        /**
         * 昵称
         */
        @Size(min = 1, max = 20, message = "昵称长度1-20")
        private String nickname;
    }

    public class Create extends Common {

    }

    public class Update extends Common {

    }

}
