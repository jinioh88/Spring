public interface PasswordEncoder {
    String encode(User user, String rawPassword);
}
