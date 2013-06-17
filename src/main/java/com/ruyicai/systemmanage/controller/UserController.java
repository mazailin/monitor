package com.ruyicai.systemmanage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ruyicai.common.controller.BaseController;
import com.ruyicai.common.utils.LoggerUtil;
import com.ruyicai.common.utils.Utils;
import com.ruyicai.common.vo.BaseConditionVO;
import com.ruyicai.systemmanage.domain.User;
import com.ruyicai.systemmanage.service.RoleService;
import com.ruyicai.systemmanage.service.UserService;
import com.ruyicai.systemmanage.vo.RoleVo;

//@Controller
//@RequestMapping("/user")
public class UserController extends BaseController {
	@Resource
	private UserService userService;
	@Resource
	private RoleService roleService;
	private List<RoleVo> roleList = null;


	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(@RequestParam(required = false) String navTabId,
			User user) {
		try {
			userService.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}


	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(User user) {
		try {
			User userold = userService.findById(user.getId());
//	System.out.println(user.toString(ToSOstringStyle.DEFAULT_STYLE));
			userold.setName(user.getName());
			userold.setLoginname(user.getLoginname());
			userold.setPassword(user.getPassword());
			userold.setWorkid(user.getWorkid());
			userold.setGroupid(user.getGroupid());
			userold.setAgclineno(user.getAgclineno());
			userold.setCallno(user.getCallno());
			userold.setRoleId(user.getRoleId());
			userold.setDescription(user.getDescription());
			userService.update(userold);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("userId") String userId) {

		if ("1".equals(userId)) {
			return ajaxDoneError("管理员不能删除");
		}
		try {
			userService.delete("(" + userId + ")");
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list2(BaseConditionVO vo, Model model) {
		return list(vo, model, null);
	}

	@RequestMapping(value = "/listUser", method = RequestMethod.POST)
	public String list(BaseConditionVO vo, Model model,
	// @RequestParam(required = false) Long id,
			// @RequestParam(required = false) String name,
			// @RequestParam(required = false) String loginname,
			// @RequestParam(required = false) String password,
			// @RequestParam(required = false) String description,
			@RequestParam(required = false) String workid
	// @RequestParam(required = false) String groupid,
	// @RequestParam(required = false) Integer state,
	// @RequestParam(required = false) java.util.Date intime,
	// @RequestParam(required = false) java.util.Date begintime,
	// @RequestParam(required = false) java.util.Date endtime,
	// @RequestParam(required = false) String callno,
	// @RequestParam(required = false) Integer agctype,
	// @RequestParam(required = false) Integer callcount,
	// @RequestParam(required = false) Integer agclineno,
	// @RequestParam(required = false) Integer roleId
	) {
		long total = 0;
		Map param = new HashMap();
		List<User> list = new ArrayList<User>();
		// if(!Util.strIsNull(id))param.put("id", id);

		// if(!Util.strIsNull(name))param.put("name", name);

		// if(!Util.strIsNull(loginname))param.put("loginname", loginname);

		// if(!Util.strIsNull(password))param.put("password", password);

		// if(!Util.strIsNull(description))param.put("description",
		// description);
		String sql = "";
		if (!Utils.strIsNull(workid))
			sql = " where workid like  '%" + workid + "%'";

		// if(!Util.strIsNull(groupid))param.put("groupid", groupid);

		// if(!Util.strIsNull(state))param.put("state", state);

		// if(!Util.strIsNull(intime))param.put("intime", intime);

		// if(!Util.strIsNull(begintime))param.put("begintime", begintime);

		// if(!Util.strIsNull(endtime))param.put("endtime", endtime);

		// if(!Util.strIsNull(callno))param.put("callno", callno);

		// if(!Util.strIsNull(agctype))param.put("agctype", agctype);

		// if(!Util.strIsNull(callcount))param.put("callcount", callcount);

		// if(!Util.strIsNull(agclineno))param.put("agclineno", agclineno);

		// if(!Util.strIsNull(roleId))param.put("roleId", roleId);

		total = userService
				.getCountByCondition("select count(u.id) from User u" + sql);
		List<User> users = new ArrayList<User>();
		if (total > 0) {
			users = userService.getListByConditionPerPage("from User" + sql, vo
					.getStartIndex(), vo.getNumPerPage());
		}
		vo.setTotalCount(total);

		model.addAttribute("vo", vo);
		model.addAttribute("userList", users);
		// model.addAttribute("targetType", "navTab");
		// model.addAttribute("totalCount", total);
		// model.addAttribute("numPerPage", vo.getNumPerPage());
		// model.addAttribute("pageNumShown", vo);
		// model.addAttribute("currentPage", vo.getPageNum());

		return "/func/user/list";
	}

	@RequestMapping(value = "/profile")
	public String doProfile(Map model) {
		// try {
		// User user =
		// (User)MVC.ctx().getSession().getAttribute(UserCons.LOGIN_USER_ATTR_NAME());
		// this.id = Long.valueOf(user.getId());
		// } catch (Exception e) {
		// model.put(DWZCons.ERROR_ATTR_NAME(),
		// StringUtil.getExceptionString(e));
		// return DWZCons.ERROR_PAGE();
		// }
		model.put("openType", "dialog");
		return "/func/user/profile";
	}

	@RequestMapping(value = "psd")
	public @ResponseBody
	ModelMap editPassword(ModelMap model, @RequestParam String oldPassword,
			@RequestParam String newPassword) throws Exception {

		String userName = LoggerUtil.getLoginUserName();
		User account = userService.findByName(userName);
		String wrongString = "";
		boolean success = false;
		if (!oldPassword.equals(account.getPassword())) {
			wrongString = "原密码输入错误";
			success = false;
		} else {
			if (account.getPassword().equals(newPassword)) {
				wrongString = "密码没有改变,无需保存";
				success = false;
			} else {
				account.setPassword(newPassword);
				userService.updateBySelf(account);
				success = true;
			}
		}
		model.put("success", success);
		model.put("wrongString", wrongString);
		return model;

	}
}
