package usermanagement.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import springbootservice.consume.model.User;
import usermanagement.model.UserDetails;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class);

    @Mappings({
            @Mapping( source = "id", target = "id" ),
            @Mapping( source = "name", target = "name" ),
            @Mapping( source = "age", target = "age" ),
            @Mapping( source = "salary", target = "salary" )
    })
    UserDetails userToUserDetails(User user);
    User userDetailsToUser(UserDetails userDetails);

    @IterableMapping
    List<UserDetails> userListToUserDetailsList(List<User> user);

    @IterableMapping
    List<User> userDetailsListToUserList(List<UserDetails> userDetails);
}
