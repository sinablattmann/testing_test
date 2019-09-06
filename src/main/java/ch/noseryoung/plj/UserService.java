package ch.noseryoung.plj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This is the Service Layer
 * 
 * @author Sina
 */
@Service
public class UserService {

  private UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  public Optional<User> getUserById(long id) {
    return userRepository.findById(id);
  }


  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User saveUser(User user) {
    return userRepository.save(user);
  }

  public void deleteUser(long id) {
    Optional<User> optional = userRepository.findById(id);
    if(optional.isPresent()) {
      userRepository.delete(optional.get());
    }
  }

  public User updateUser(long id, String firstName, String lastName) {
    User user = null;
    if(userRepository.findById(id).isPresent()){
      user = userRepository.findById(id).get();
      user.setFirstName(firstName);
      user.setLastName(lastName);
      userRepository.save(user);
    }
    return user;
  }
}
