package uz.shaftolimarket.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.dto.UserDTO;
import uz.shaftolimarket.model.UserEntity;
import uz.shaftolimarket.repository.UserRepository;

import static uz.shaftolimarket.model.UserRole.USER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmailCodeService emailCodeService;
    private final ModelMapper modelMapper;


    public UserEntity save(UserDTO userDTO){
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setRole(USER);
        user.setVerified(false);
        emailCodeService.save(user.getEmail());
        return user;
    }
}
