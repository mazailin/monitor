

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

import com.ruyicai.common.constants.Contants;
import com.ruyicai.common.controller.BaseController;
import com.ruyicai.common.vo.BaseConditionVO;
import com.ruyicai.systemmanage.domain.SysRoleBean;
import com.ruyicai.systemmanage.service.RoleService;
import com.ruyicai.systemmanage.vo.ResourceVo;


/**
 * @author tianshangjun
 */
 // @Controller
 //@RequestMapping("/sysRole/*")
public class SysRoleController  extends BaseController {
	@Resource
	private RoleService roleService;
	 //---------------------add--------------------------------------
     @RequestMapping(value="add", method = RequestMethod.GET)
    public String  addSysRoleBean(Model model) {
         //model.addAttribute("roleList", roleList);
	 return "/func/sysRole/add";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(SysRoleBean sysRole) {
		try {
			roleService.save(sysRole);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	 //---------------------edit--------------------------------------
	@RequestMapping(value ="/edit/{sysRoleId}", method = RequestMethod.GET)
	public String edit(@PathVariable("sysRoleId") String sysRoleId, Model model) {
		SysRoleBean  sysRole = roleService.findByKey(sysRoleId);

		model.addAttribute("vo", sysRole);

		return "/func/sysRole/edit";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(SysRoleBean  sysRole) {
	try {
		SysRoleBean sysRoleold = roleService.findByKey(sysRole.getId()+"");
               	     	sysRoleold.setName(sysRole.getName());
			     	sysRoleold.setDescription(sysRole.getDescription());
			     	roleService.update(sysRole);
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
   //---------------------delete--------------------------------------
   @RequestMapping(value = "/delete/{sysRoleId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("sysRoleId") int sysRoleId) {
             try {
            	 roleService.deleteByIds("("+sysRoleId+")");
		} catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
   //---------------------list--------------------------------------

   @RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list2(BaseConditionVO vo, Model model) {
		return list(vo, model);
	}
		@RequestMapping(value = "/listSysRoleBean", method = RequestMethod.POST)
	public  String list(BaseConditionVO vo, Model model
	 		
        // @RequestParam(required = false)  Long id,      		
        // @RequestParam(required = false)  String name,      		
        // @RequestParam(required = false)  String description            
	) {
		long total = 0;
				
		  Map param=new HashMap();
            List<SysRoleBean> list=new ArrayList<SysRoleBean>();
        
	  try{
             
		//  if(!Util.strIsNull(id))param.put("id", id);
             
		//  if(!Util.strIsNull(name))param.put("name", name);
             
		//  if(!Util.strIsNull(description))param.put("description", description);
              total=roleService.findCount(param);
	if(total>0)list=roleService.find(param, (vo.getPageNum()-1)*vo.getNumPerPage(),
					vo.getNumPerPage());
		
                   vo.setTotalCount(total);	
		model.addAttribute("vo", vo);	
		model.addAttribute("sysRoleList", list);
		return "/func/sysRole/list";
	}catch (Exception e) {
		e.printStackTrace();
		return "";
	}
  }
		
		 //---------------------alloc-permission--------------------------------------	

		   @RequestMapping(value = "/allocpermission", method = RequestMethod.GET)
		   public String doAllocPerm(Map model) {
		     try {
		    	 Map param=new HashMap();
		    	 param.put(Contants.FIELD_STARTDATE, "1");
		            List<SysRoleBean> list=new ArrayList<SysRoleBean>();
		    	 list=roleService.find(param, null,null);
		       model.put("roles", list);
		       model.put("permissions", roleService.getTreeResource());
		       model.put("action", "rolepermission");
		       model.put("openType", "navTab");
		       model.put("random", Double.valueOf(Math.random()));
		     } catch (Exception e) {
		    	 e.printStackTrace();
		 		return "";
		     }
		 
		 	return "/func/sysRole/alloc_permission";
		   }
		   /**
		    * 给角色分配资源保存到数据库
		    * 
		    * @param roleIds
		    * @param permissionIds
		    * @return
		    */
		   @RequestMapping(value = "/rolepermission", method = RequestMethod.POST)
		   public ModelAndView doAddRolePermissionRelation( String[] roleIds,String[] permissionIds)
		   {
		     try
		     {
		    	 roleService.allocpermission(roleIds,permissionIds);		       
		       return ajaxDoneSuccess("分配权限成功");
		     } catch (Exception e) {
					e.printStackTrace();
					return ajaxDoneError(e.getMessage());
			}
				
		     
		   }
		   /**
			 * 角色管理模块 根据id返回资源信息
			 */
			@RequestMapping(value = "/permissions/{id}", method = RequestMethod.GET)
			public 
			String listResourceByRole(Map model,@PathVariable long id) throws Exception {
				List<ResourceVo> resources = roleService.getResourcesByRoleId(id);
				  model.put("rolepermissions", resources);
				  model.put("roleroleId", id);
				  model.put("random", Double.valueOf(Math.random()));
				return "/func/sysRole/role_permissions";
			}
			
			 @RequestMapping(value = "/rolepermissionremove", method = RequestMethod.POST)
			   public @ResponseBody ModelMap rolepermissionremove( @RequestParam(required = false)   String roleId, 
					   @RequestParam(required = false)  String permissionIds)
			   {
			     try
			     {
			    	 roleService.removeRolePermission(roleId,permissionIds);		 
			    	 model.clear();
			    	 model.put("status", "true");
			    	 model.put("message", "删除权限成功");
			       return model;
			     } catch (Exception e) {
						e.printStackTrace();
						model.clear();
						model.put("status", "false");
						model.put("message", "删除权限失败！原因：" + e.toString());
						return model;
				}
					
			     
			   }
		
}

