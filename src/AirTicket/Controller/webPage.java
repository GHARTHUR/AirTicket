package AirTicket.Controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.handlers.message_rfc822;

import AirTicket.Dao.JobDao;
import AirTicket.Dao.UserDao;
import AirTicket.Data.Job;
import AirTicket.Data.User;
import AirTicket.Service.QunaerApi;

@Controller
public class webPage {
	
	@Resource
	private UserDao userdao;
	@Resource
	private QunaerApi qapi;
	@Resource
	private JobDao jobdao;
	@Resource
	private HttpSession httpSession;
	
	String msg = "<div class='alert alert-danger alert-dismissible  col-lg-4 col-lg-offset-4 col-sm-6 col-sm-offset-3' role='alert'><button type='button' class='close' data-dismiss='alert' aria-label='Close'><span aria-hidden='true'>&times;</span></button><p>DATA</p></div>";
	
	@RequestMapping(value="Login")
	public ModelAndView Login(User user,Model md){
		ModelAndView model = new ModelAndView();
		User temp  = userdao.findByUsername(user.getUsername());
		if(user.getUsername() == null ){
			model.setViewName("Login");
			return model;
		}
		if(temp == null){
			/*try {
				qapi.getAirPrice("2016-07-22", "重庆", "深圳");
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			md.addAttribute("msg", msg.replaceAll("DATA", "账号不存在"));
			model.setViewName("Login");
		}else{
			if(temp.getPassword().equals(user.getPassword())){
				md.addAttribute("msg", msg.replaceAll("DATA", "登陆成功").replace("alert-danger","alert-success"));
				httpSession.setAttribute("user", temp);
				md.addAttribute("userid",temp.getId());
				model.setViewName("Index");
			}else{
				md.addAttribute("msg", msg.replaceAll("DATA", "密码错误"));
				model.setViewName("Login");
			}
		}
	    return model;
	}
	
	@RequestMapping(value="Regist")
	public ModelAndView Regist(User user,Model md){
		ModelAndView model = new ModelAndView();
		
		if(user.getUsername() == null){
			model.setViewName("Regist");
			return model;
		}
		
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(user.getUsername());
		if(matcher.matches()){
			md.addAttribute("msg", msg.replaceAll("DATA", "注册成功，请登录").replace("alert-danger","alert-success"));
			userdao.addUser(user);
			model.setViewName("Login");
		}else{
			md.addAttribute("msg", msg.replaceAll("DATA", "邮箱错误"));
			model.setViewName("Error");
		}
		return model;
	}
	
	@RequestMapping(value="Index")
	public ModelAndView Index(Job job,Model md){
		ModelAndView model = new ModelAndView();
		User temp = (User)httpSession.getAttribute("user");
		if(temp==null) return new ModelAndView("Login");
		
		md.addAttribute("userid",temp.getId());
		
		if(job.getAirfrom() == null || job.getAirto() == null || job.getAirdate() == null){
			model.setViewName("Index");
		}else{
			User user = (User)httpSession.getAttribute("user");
			job.setLmoney(99999);
			job.setUserid(user.getId());
			jobdao.addJob(job);
			md.addAttribute("msg", msg.replaceAll("DATA", "监控成功").replace("alert-danger","alert-success"));
			model.setViewName("Index");
		}
		return model;
	}
}
