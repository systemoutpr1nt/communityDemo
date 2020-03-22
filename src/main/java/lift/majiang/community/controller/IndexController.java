package lift.majiang.community.controller;

import lift.majiang.community.mapper.UserMapper;
import lift.majiang.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request)  {
    Cookie[] cookies = request.getCookies();
    for (Cookie cookie : cookies){
        if (cookie.getName().equals("token")){
            String token = cookie.getValue();
            User user = userMapper.findByToken(token);
            if (user != null){
                request.getSession().setAttribute("user",user);
            }
            break;
        }
    }










        return "index";
    }

}