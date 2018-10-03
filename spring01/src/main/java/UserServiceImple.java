import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImple implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public void setUserRepository(UserRepository repository) {
        this.userRepository = repository;
    }


    public void setEncoder(PasswordEncoder encoder) {
        this.passwordEncoder = encoder;
    }

    @Override
    public void register(User user, String rawPassword) {

    }


}
