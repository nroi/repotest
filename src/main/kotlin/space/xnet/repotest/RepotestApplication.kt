package space.xnet.repotest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(
    scanBasePackages = [
      "space.xnet.repotest"
    ]
)
@EnableJpaRepositories(
    basePackageClasses = [FooBarController::class],
)
class RepotestApplication

fun main(args: Array<String>) {
	runApplication<RepotestApplication>(*args)
}
