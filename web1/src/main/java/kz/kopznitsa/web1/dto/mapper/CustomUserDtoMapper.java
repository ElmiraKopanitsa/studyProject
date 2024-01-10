package kz.kopznitsa.web1.dto.mapper;

import kz.kopznitsa.web1.dto.CustomUserDto;
import kz.kopznitsa.web1.entity.CustomUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomUserDtoMapper {

    CustomUserDto customUserToCustomUserDto(CustomUser customUser);

    CustomUser customUserDtoToCustomUser(CustomUserDto customUserDto);
}
