package ch.noseryoung.plj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.Assert.*;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
