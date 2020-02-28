package com.july.shop.portal.base;

import com.july.shop.api.dto.member.output.UserOutDTO;
import com.july.shop.common.base.entity.BaseResponse;
import com.july.shop.common.base.portal.BaseWebController;
import com.july.shop.common.utils.CookieUtils;
import com.july.shop.portal.member.controller.feign.MemberServiceFeign;
import com.july.shop.portal.web.constants.WebConstants;
import com.xxl.sso.core.login.SsoWebLoginHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: july
 * @date: 2020/2/26 14:26
 * @description:
 */
@Controller
public class IndexController extends BaseWebController {
    @Autowired
    private MemberServiceFeign memberServiceFeign;
    /**
     * 跳转到index页面
     */
    private static final String INDEX_FTL = "index";
    private static final String REDIRECT_INDEX_FTL = "redirect:/";

    @RequestMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 1.从cookie 中 获取 会员token
        String token = CookieUtils.getCookieValue(request, WebConstants.LOGIN_TOKEN_COOKIENAME, true);
        if (!StringUtils.isEmpty(token)) {
            // 2.调用会员服务接口,查询会员用户信息
            BaseResponse<UserOutDTO> userInfo = memberServiceFeign.getInfo(token);
            if (isSuccess(userInfo)) {
                UserOutDTO data = userInfo.getData();
                if (data != null) {
                    String mobile = data.getMobile();
                    // 对手机号码实现脱敏
                    String desensMobile = mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
                    model.addAttribute("desensMobile", desensMobile);
                }

            }

        }
        return INDEX_FTL;
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response, Model model) {
        // 1.从cookie 中 获取 会员token
        String token = CookieUtils.getCookieValue(request, WebConstants.LOGIN_TOKEN_COOKIENAME, true);
        // logout
        SsoWebLoginHelper.logout(request, response);
        // TODO 完成退出功能 实现唯一登陆心跳检测 前端定时器 定时 使用js 读取本地cookie 信息 使用token 查询当前状态 如果token状态为1的话，页面直接刷新下。
        CookieUtils.deleteCookie(request, response, WebConstants.LOGIN_TOKEN_COOKIENAME);
        return REDIRECT_INDEX_FTL;
    }
}
