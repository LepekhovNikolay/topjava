package ru.javawebinar.topjava.service.datajpa;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.AbstractUserServiceTest;

import static ru.javawebinar.topjava.Profiles.DATAJPA;

@ActiveProfiles(DATAJPA)
//@ActiveProfiles(profiles = {"postgres", DATAJPA})

public class DataJpaUserServiceTest extends AbstractUserServiceTest {

}
