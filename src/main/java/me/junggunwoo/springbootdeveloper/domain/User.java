package me.junggunwoo.springbootdeveloper.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Builder
    public User(String email, String password, String auth) {
        this.email = email;
        this.password = password;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override // 사용자 id 반환
    public String getUsername() {
        return email;
    }

    @Override // 사용자 비밀번호 반환
    public String getPassword() {
        return password;
    }

    @Override // 계정 만료 여부 반환
    public boolean isAccountNonExpired() {
        // 만료 여부 확인 로직
        return true; // true -> 계정 만료 안됨
    }

    @Override // 계정 잠금 여부 반환
    public boolean isAccountNonLocked() {
        // 계정 잠금 여부 확인 로직
        return true; // true -> 계정 안 잠김
    }

    @Override // 패스워드의 만료 여부 반환
    public boolean isCredentialsNonExpired() {
        // 비밀번호 만료 여부 확인 로직
        return true;  // true -> 비밀번호 만료 안됨
    }

    @Override // 계정 사용 가능 여부 반환
    public boolean isEnabled() {
        // 계정 사용 가능 여부 확인 로직
        return true; // true-> 계정 사용 가능
    }
}
