package cn.lnfvc.core.service.impl;

import cn.lnfvc.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: KenChen
 * @Description: 实现UserDetailsService接口，配置Security基于JDBC的鉴权
 * @Date: Create in  2021/8/5 下午5:14
 */
@Service("userDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        cn.lnfvc.commons.entity.User user =userService.getByName(username);
        return new User(user.getName(),new BCryptPasswordEncoder().encode(user.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_vip1"));
    }


}