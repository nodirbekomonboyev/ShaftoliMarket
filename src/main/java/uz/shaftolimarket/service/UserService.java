package uz.shaftolimarket.service;


import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uz.shaftolimarket.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EmailCodeService emailCodeService;
    private final ModelMapper modelMapper;


    public Boolean verifyByEmail(String email, String code){
        return false;
    }


}
