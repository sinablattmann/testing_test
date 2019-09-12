package ch.noseryoung.plj.user;

import ch.noseryoung.plj.User;
import ch.noseryoung.plj.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.Assert.*;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

  @Autowired
  private TestEntityManager entityManager;

  @Autowired
  private UserRepository userRepository;

  @Test
  public void whenFindByName_thenReturnEmployee() {
    // given
    User alex = new User();
    alex.setFirstName("Alex");
    entityManager.persist(alex);
    entityManager.flush();

    // when
    User found = userRepository.findByFirstName(alex.getFirstName());

    // then
    assertEquals(found.getFirstName(), alex.getFirstName());
  }
}
