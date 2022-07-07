package com.example.managernews.service;

import com.example.managernews.entity.Account;
import com.example.managernews.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class AccountService implements UserDetailsService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Tìm account theo user name trong bang account
        Account account = accountRepository.findAccountByUsername(username);
//      Tạo danh sách quyền. ( một người dùng có thể có nhiều quyền).
//        Có thể tạo ra quyền riêng mapping n - n với account
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (account.getRole() == 0){
//            thêm quyền thoe trường role trong account
            authorities.add(new SimpleGrantedAuthority("user"));
        } else if (account.getRole() == 1){
            authorities.add(new SimpleGrantedAuthority("admin"));
        } else {
            authorities.add(new SimpleGrantedAuthority("guest"));
        }
//        Tạo đối tượng user detail theo thông tin username, password và quyền được lấy ra ở trên.
//        trong đó password là pass được mã hóa
        return new User(account.getUsername(), account.getPasswordHash(), authorities);
    }
}
