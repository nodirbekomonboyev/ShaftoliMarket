package uz.shaftolimarket.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.dto.UserDTO;
import uz.shaftolimarket.exception.DataNotFound;
import uz.shaftolimarket.model.UserEntity;
import uz.shaftolimarket.repository.UserRepository;

import java.util.Optional;

import static uz.shaftolimarket.model.UserRole.ADMIN;
import static uz.shaftolimarket.model.UserRole.USER;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    public UserEntity save (UserDTO userDTO) {
        UserEntity user = modelMapper.map(userDTO, UserEntity.class);
        user.setRole(USER);
        user.setVerified(false);
        return userRepository.save(user);
    }
    public void verifyByEmail(String email) {
        Optional<UserEntity> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            throw new DataNotFound("user not found");
        }
        UserEntity user1 = user.get();
        user1.setVerified(true);
        userRepository.save(user1);
    }
//    String sendCode(String email) {
//
//    }

}
