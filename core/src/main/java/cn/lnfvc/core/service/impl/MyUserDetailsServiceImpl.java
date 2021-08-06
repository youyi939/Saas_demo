package cn.lnfvc.core.service.impl;

import cn.lnfvc.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author: KenChen
 * @Description: 实现UserDetailsService接口，配置Security基于JDBC的鉴权
 * @Date: Create in  2021/8/5 下午5:14
 */
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    SecurityService securityService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.lnfvc.core.pojo.User user = securityService.getByName(username);
        return new User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_vip1"));
    }


}