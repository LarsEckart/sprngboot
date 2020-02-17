package ee.lars.sprng;

import java.util.Arrays;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException
    {
        User user = userDao.getUser( username );
        if ( user == null )
        {
            throw new UsernameNotFoundException( "User '" + username + "' not found." );
        }
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority( user.getRole() );

        return new org.springframework.security.core.userdetails.User( user.getUsername(),
                user.getPassword(), Collections.singletonList( grantedAuthority ) );
    }
}
