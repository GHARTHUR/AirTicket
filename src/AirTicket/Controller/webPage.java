package AirTicket.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AirTicket.Dao.UserDao;
import AirTicket.Data.User;

@Controller
public class webPage {
	
	@Resource
	private UserDao userdao;
	
	@RequestMapping(value="Login")
	public ModelAndView Login(User user,Model md){
		ModelAndView model = new ModelAndView();
		User temp  = userdao.findByUsername(user.getUsername());
		if(temp == null){
			md.addAttribute("message", "账号不存在");
			model.setViewName("Login");
		}else{
			if(temp.getPassword().equals(user.getPassword())){
				md.addAttribute("message", "登陆成功");
				model.setViewName("Login");
			}else{
				md.addAttribute("message", "密码错误");
				model.setViewName("Login");
			}
		}
	    return model;
	}
}
