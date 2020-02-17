package ee.lars.sprng;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser( String username )
    {
        try
        {
            final String sql =
                    "select u.user_name user_name, u.user_pass user_pass, ur.user_role user_role from user u, user_role ur where u.user_name = ? and u.user_name = ur.user_name";
            return jdbcTemplate.queryForObject( sql, new Object[] { username }, ( rs, i ) -> new User(
                    rs.getString( "user_name" ),
                    rs.getString( "user_pass" ),
                    rs.getString( "user_role" ) ) );
        }
        catch ( EmptyResultDataAccessException ex )
        {
            return null;// should have proper handling of Exception
        }
    }
}
