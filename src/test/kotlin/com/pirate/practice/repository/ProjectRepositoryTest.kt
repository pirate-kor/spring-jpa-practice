package com.pirate.practice.repository

import org.hibernate.proxy.HibernateProxy
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.platform.commons.logging.LoggerFactory
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjectRepositoryTest(
        private val projectRepository: ProjectRepository
) {

    companion object{
        private val logger = LoggerFactory.getLogger(ProjectRepositoryTest::class.java)
    }

    @Test
    internal fun projectIsInitialized() {
        val project = projectRepository.findById(1)
        assertTrue(project.isPresent)
    }

    @Test
    internal fun lazyLoadEnabled() {
        val project = projectRepository.findById(1).get()
        val client = project.client!!

        logger.info { "${client::class.java}" }
        assertTrue(HibernateProxy::class.java.isAssignableFrom(client::class.java))
    }

    @Test
    internal fun equalsIssue() {
        val project = projectRepository.findById(1).get()
        assertTrue(project == project.copy())
    }

}