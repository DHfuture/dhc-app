package com.dhc.app.api.service.administrator.service.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface AdministratorRequestDTO {

    interface Common {

        String getLonginName();

        void setLonginName(String longinName);

        String getPassword();

        void setPassword(String password);

        String getNickname();

        void setNickname(String nickname);
    }

    @Getter
    @Setter
    public class Create implements Common {
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

    @Getter
    @Setter
    public class Update implements Common {

        @NotNull
        private Long id;

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

}
