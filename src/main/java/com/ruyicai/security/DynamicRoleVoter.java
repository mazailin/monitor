package com.ruyicai.security;

import java.util.Collection;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.ruyicai.common.utils.Utils;

public class DynamicRoleVoter implements AccessDecisionVoter<Object> {
	private String rolePrefix = "ROLE_";

	public String getRolePrefix() {
		return rolePrefix;
	}

	public void setRolePrefix(String rolePrefix) {
		this.rolePrefix = rolePrefix;
	}

	public boolean supports(ConfigAttribute attribute) {
		if ((attribute.getAttribute() != null)
				&& attribute.getAttribute().startsWith(getRolePrefix())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object,
			Collection<ConfigAttribute> attributes) {
		 int result = ACCESS_ABSTAIN;
	        Collection<? extends GrantedAuthority> authorities =authentication.getAuthorities();

	        for (ConfigAttribute attribute : attributes) {
	            if (this.supports(attribute)) {
	                result = ACCESS_DENIED;

	                // Attempt to find a matching granted authority
	                for (GrantedAuthority authority : authorities) {
	                    if (!Utils.strIsNull(authority.getAuthority())) {
	                        return ACCESS_GRANTED;
	                    }
	                }
	            }
	        }

	        return result;
	}

}
