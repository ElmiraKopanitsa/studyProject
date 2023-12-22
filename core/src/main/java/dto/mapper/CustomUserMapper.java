package dto.mapper;

import dto.CustomUserDto;
import entity.CustomUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomUserMapper {

    CustomUserMapper INSTANCE = Mappers.getMapper(CustomUserMapper.class);

    @Mapping(target = "id", ignore = true) // id не нужно маппировать
    @Mapping(target = "roles", ignore = true) // игнорировать маппинг для roles
    CustomUserDto customUserToCustomUserDto(CustomUser customUser);

    CustomUser customUserDtoToCustomUser(CustomUserDto customUserDto);
}