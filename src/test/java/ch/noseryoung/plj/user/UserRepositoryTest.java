package ch.noseryoung.plj.user;

import ch.noseryoung.plj.User;
import ch.noseryoung.plj.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void whenFindByName_thenReturnUser() {

    User user = new User("sina", "blattmann");
    entityManager.persist(user);
    entityManager.flush();

    User found = userRepository.findByName(user.getLastName());

    assertEquals(user.getLastName(), found.getLastName());
  }

}