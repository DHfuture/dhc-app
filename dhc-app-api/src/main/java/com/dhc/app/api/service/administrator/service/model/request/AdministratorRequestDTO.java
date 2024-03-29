package com.dhc.app.api.service.administrator.service.model.request;

import com.dhc.app.api.service.administrator.constants.AdministratorRole;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public interface AdministratorRequestDTO {

    interface Common {

        String getLoginName();

        String getPassword();

        String getNickname();

        AdministratorRole getAuthority();
    }

    @Getter
    @Setter
    @Schema(name = "AdministratorRequestDTO_Create")
    class Create implements Common {

        @Schema(title = "登录名", requiredMode = Schema.RequiredMode.REQUIRED)
        @Size(min = 5, max = 30, message = "登录名长度5-30")
        private String loginName;

        @Schema(title = "密码", requiredMode = Schema.RequiredMode.REQUIRED)
        @Size(min = 7, max = 30, message = "密码长度7-30")
        private String password;

        @Schema(title = "昵称", requiredMode = Schema.RequiredMode.REQUIRED)
        @Size(min = 1, max = 20, message = "昵称长度1-20")
        private String nickname;

        @Schema(title = AdministratorRole.DOC, requiredMode = Schema.RequiredMode.REQUIRED)
        private AdministratorRole authority;
    }

    @Getter
    @Setter
    @Schema(name = "AdministratorRequestDTO_Update")
    class Update implements Common {

        @NotNull
        private Long id;

        @Schema(title = "登录名", requiredMode = Schema.RequiredMode.AUTO)
        @Size(min = 5, max = 30, message = "登录名长度5-30")
        private String loginName;

        @Schema(title = "密码", requiredMode = Schema.RequiredMode.AUTO)
        @Size(min = 7, max = 30, message = "密码长度7-30")
        private String password;

        @Schema(title = "昵称", requiredMode = Schema.RequiredMode.AUTO)
        @Size(min = 1, max = 20, message = "昵称长度1-20")
        private String nickname;

        @Schema(title = AdministratorRole.DOC, requiredMode = Schema.RequiredMode.AUTO)
        private AdministratorRole authority;
    }

    @Getter
    @Setter
    @Schema(name = "AdministratorRequestDTO_Login")
    class Login {
        @Schema(title = "登录名")
        @Size(min = 1, max = 20, message = "昵称长度1-20")
        private String loginName;

        @Schema(title = "密码")
        private String password;
    }
}
