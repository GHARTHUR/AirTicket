package AirTicket.Controller;

import java.io.IOException;

import javax.annotation.Resource;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import AirTicket.Dao.UserDao;
import AirTicket.Data.User;
import AirTicket.Service.QunaerApi;

@Controller
public class webPage {
	
	@Resource
	private UserDao userdao;
	@Resource
	private QunaerApi qapi;
	
	@RequestMapping(value="Login")
	public ModelAndView Login(User user,Model md){
		ModelAndView model = new ModelAndView();
		User temp  = userdao.findByUsername(user.getUsername());
		if(temp == null){
			try {
				qapi.getAirPrice("2016-07-22", "重庆", "深圳");
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
